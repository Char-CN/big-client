package org.blazer.bigclient.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.blazer.bigclient.body.FormalUserBean;
import org.blazer.bigclient.mapper.ClFormalUserMapper;
import org.blazer.bigclient.model.*;
import org.blazer.bigclient.util.DateUtil;
import org.blazer.bigclient.util.IntegerUtil;
import org.blazer.bigclient.util.LongUtil;
import org.blazer.bigclient.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Created by cuican on 2016-11-8.
 */
@Service
public class ClFormalUserService extends BaseService<ClFormalUser> {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClFormalUserService.class);

    @Autowired
    private ClFormalUserMapper clFormalUserMapper;

    @Autowired
    private ClExcelService clExcelService;

    @Autowired
    private ClPerformancePoolListService clPerformancePoolListService;

    /**
     * 保存excel导入数据
     *
     * @param listBean
     * @param excel
     */
    public void importExcelData(List<ClPerformancePoolList> listBean, ClExcel excel) {

        this.clPerformancePoolListService.deleteAll();

        if (listBean != null && listBean.size() > 0 && excel != null) {

            //保存excel文件对象信息到数据库表
            LOGGER.info("保存excel对象信息到数据库表。");
            this.clExcelService.getMapper().insert(excel);

            //遍历上传名单的list集合，完善每一个客户对象信息
            for (int i = 0; i < listBean.size(); i++) {
                //先用该手机号匹配正式名单的客户
                ClPerformancePoolList clPerformancePoolList = listBean.get(i);
                Long phoneNumber = LongUtil.getLongZero(clPerformancePoolList.getPhoneNumber());
                ClFormalUser formalUser = this.selectByPhoneNumber(phoneNumber);

                if (formalUser != null) {
                    clPerformancePoolList.setCtime(new Date());//该记录创建时间
                    formalUser.setIfPerformancePool(1);
                    this.updateNotNull(formalUser);
                    this.clPerformancePoolListService.save(clPerformancePoolList);
                }
            }
        }
    }

    /**
     * 根据手机号查询单个客户
     *
     * @param phoneNumber
     * @return
     */
    public ClFormalUser selectByPhoneNumber(Long phoneNumber) {
        LOGGER.debug("根据手机号：" + phoneNumber + ",查询单个正式客户。");
        Example example = new Example(ClFormalUser.class);
        Example.Criteria criteria = example.createCriteria();
        Long phoneNo = LongUtil.getLongZero(phoneNumber);
        criteria.andEqualTo("phoneNumber", phoneNo);
        List<ClFormalUser> clFormalUsers = this.selectByExample(example);
        ClFormalUser user = null;
        if (clFormalUsers != null && clFormalUsers.size() != 0) {
            user = clFormalUsers.get(0);
        }
        return user;
    }

    /**
     * 首页列表
     *
     * @param params
     * @return
     */
    public PageInfo<FormalUserBean> findByPage(HashMap<String, String> params) {
        LOGGER.info("根据条件分页查询正式客户【FormalUserBean】列表。。。");

        String search = StringUtil.getStrEmpty(params.get("search"));
        String history = StringUtil.getStrEmpty(params.get("history"));
        String dateStart = StringUtil.getStrEmpty(params.get("dateStart"));
        if(StringUtils.isEmpty(dateStart)){
            dateStart="1900-01-01";
        }
        String dateEnd = StringUtil.getStrEmpty(params.get("dateEnd"));
        if(StringUtils.isEmpty(dateEnd)){
            dateEnd = DateUtil.thisDate();
        }

        PageHelper.startPage(IntegerUtil.getIntZero(params.get("currentPage")), IntegerUtil.getIntZero(params.get("pageSize")));
        List<FormalUserBean> list = this.clFormalUserMapper.selectMaxVersionList(search,dateStart,dateEnd,history);
        return new PageInfo<>(list);
    }

    public List<FormalUserBean> findBySearch(HashMap<String, String> params) {
        LOGGER.info("根据条件查询正式客户【FormalUserBean】，导出Excel文件。。。");

        String search = StringUtil.getStrEmpty(params.get("search"));
        String history = StringUtil.getStrEmpty(params.get("history"));
        String dateStart = StringUtil.getStrEmpty(params.get("dateStart"));
        if(StringUtils.isEmpty(dateStart)){
            dateStart="1900-01-01";
        }
        String dateEnd = StringUtil.getStrEmpty(params.get("dateEnd"));
        if(StringUtils.isEmpty(dateEnd)){
            dateEnd = DateUtil.thisDate();
        }

        return this.clFormalUserMapper.selectMaxVersionList(search,dateStart,dateEnd,history);
    }


}
