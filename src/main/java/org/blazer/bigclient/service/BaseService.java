package org.blazer.bigclient.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.blazer.bigclient.util.DateUtil;
import org.blazer.bigclient.util.IntegerUtil;
import org.blazer.bigclient.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.entity.Example;

import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.List;

/**
 * 公共service，提供了通用的方法
 *
 * Created by cuican on 2016/08/26.
 */
public class BaseService<T> {

    @Autowired
    protected Mapper<T> mapper;

    /**
     * 获取泛型T的class
     *
     * @return
     */
    public T getInstance() {
        T instance = null;
        Class<T> entityClass = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        return instance;
    }

    public Mapper<T> getMapper() {
        return mapper;
    }

    public T selectByKey(Object key) {
        return mapper.selectByPrimaryKey(key);
    }

    public int save(T entity) {
        return mapper.insert(entity);
    }

    public int delete(Object key) {
        return mapper.deleteByPrimaryKey(key);
    }

    public int updateAll(T entity) {
        return mapper.updateByPrimaryKey(entity);
    }

    public int updateNotNull(T entity) {
        return mapper.updateByPrimaryKeySelective(entity);
    }

    public List<T> selectByExample(Object example) {
        return mapper.selectByExample(example);
    }

    public T selcetOne(T entity){
        return mapper.selectOne(entity);
    }

    // TODO 其他...

    public Logger getLogger(T t){
        final Logger LOGGER = LoggerFactory.getLogger(t.getClass());
        return LOGGER;
    }

    /**
     * 条件分页查询
     * 客户的手机号或者姓名模糊查询
     * 购买时间的起始和截止条件
     *
     * @param t
     * @param params
     * @return
     */
    public PageInfo<T> findByPage(T t,HashMap<String, String> params,String dateName) {
        Example example = new Example(t.getClass());
        Example.Criteria criteria = example.createCriteria();
        String search = StringUtil.getStrEmpty(params.get("search"));
        if (StringUtils.isNotEmpty(search)) {
            criteria.andCondition("phone_number like '%" + search + "%'" + " or user_name like '%" + search + "%'");
        }
        String dateStart = StringUtil.getStrEmpty(params.get("dateStart"));
        if (StringUtils.isEmpty(dateStart)) {
            dateStart = "1900-01-01";
        }
        criteria.andGreaterThanOrEqualTo(dateName, dateStart);
        String dateEnd = StringUtil.getStrEmpty(params.get("dateEnd"));
        if (StringUtils.isEmpty(dateEnd)) {
            dateEnd = DateUtil.thisDate();
        }
        criteria.andLessThanOrEqualTo(dateName, dateEnd);
        PageHelper.startPage(IntegerUtil.getIntZero(params.get("currentPage")), IntegerUtil.getIntZero(params.get("pageSize")));
        List<T> list = this.selectByExample(example);
        return new PageInfo(list);
    }

    /**
     * excel导出的查询
     *
     * @param t
     * @param params
     * @return
     */
    public List<T> findBySearch(T t,HashMap<String, String> params,String dateName) {
        Example example = new Example(t.getClass());
        Example.Criteria criteria = example.createCriteria();
        String search = StringUtil.getStrEmpty(params.get("search"));
        if (StringUtils.isNotEmpty(search)) {
            criteria.andCondition("phone_number like '%" + search + "%'" + " or user_name like '%" + search + "%'");
        }
        String dateStart = StringUtil.getStrEmpty(params.get("dateStart"));
        if (StringUtils.isEmpty(dateStart)) {
            dateStart = "1900-01-01";
        }
        criteria.andGreaterThanOrEqualTo(dateName, dateStart);
        String dateEnd = StringUtil.getStrEmpty(params.get("dateEnd"));
        if (StringUtils.isEmpty(dateEnd)) {
            dateEnd = DateUtil.thisDate();
        }
        criteria.andLessThanOrEqualTo(dateName, dateEnd);
        return this.selectByExample(example);
    }

    /**
     * 转换成json
     *
     * @param object
     * @param <T>
     * @return
     */
    public <T> String objectToJson(T object){
        ObjectMapper mapper = new ObjectMapper();
        String jsonValue = null;
        try {
            jsonValue = mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return jsonValue;
    }

}
