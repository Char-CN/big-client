package org.blazer.bigclient.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.blazer.bigclient.body.AdvisorInfoBean;
import org.blazer.bigclient.mapper.KamAdvisorMapper;
import org.blazer.bigclient.model.KamAdvisor;
import org.blazer.bigclient.util.IntegerUtil;
import org.blazer.bigclient.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.HashMap;
import java.util.List;

/**
 * Created by yyccb on 2016-10-12.
 */
@Service
public class KamAdvisorService extends BaseService<KamAdvisor> {

    private static final Logger LOGGER = LoggerFactory.getLogger(KamAdvisorService.class);

    @Autowired
    private KamAdvisorMapper kamAdvisorMapper;

    public PageInfo<AdvisorInfoBean> findByPage(HashMap<String, String> params) {
        LOGGER.info("分页条件查询");

        PageHelper.startPage(IntegerUtil.getIntZero(params.get("currentPage")), IntegerUtil.getIntZero(params.get("pageSize")));

        String search = StringUtil.getStrEmpty(params.get("search"));
        List<AdvisorInfoBean> list = this.kamAdvisorMapper.findByPage(search);
        return new PageInfo<>(list);
    }


    /**
     * 根据中文名查询投顾
     *
     * @param actualName
     * @return
     */
    public KamAdvisor selectByActualName(String actualName) {
        KamAdvisor advisor = null;
        try {
            Example example = new Example(KamAdvisor.class);
            Example.Criteria criteria = example.createCriteria();
            String name = StringUtil.getStrEmpty(actualName);
            criteria.andEqualTo("actualName", name);
            List<KamAdvisor> list = selectByExample(example);
            if (list != null && list.size() != 0) {
                advisor = list.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return advisor;
    }

    /**
     * 新增投顾，查询投顾编号是否存在
     *
     * @param serialNumber
     * @return
     */
    public Boolean selectBySerialNumber(String serialNumber) {
        Boolean flag = false;
        KamAdvisor advisor = new KamAdvisor();
        advisor.setSerialNumber(serialNumber);
        KamAdvisor kamAdvisor = this.selcetOne(advisor);
        if (kamAdvisor == null) {
            flag = true;
        }
        return flag;
    }

}
