package org.blazer.bigclient.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.blazer.bigclient.model.KamExtUserUpload;
import org.blazer.bigclient.model.KamUserInfo;
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
public class KamUserInfoService extends BaseService<KamUserInfo> {

    private static final Logger LOGGER = LoggerFactory.getLogger(KamUserInfoService.class);

    @Autowired
    private KamExtUserUploadService kamExtUserUploadService;

    public PageInfo<KamUserInfo> findUserByPage(HashMap<String, String> params) {
        LOGGER.info("根据条件查询客户列表。。。");
        Example example = new Example(KamUserInfo.class);
        Example.Criteria criteria = example.createCriteria();
        String search = StringUtil.getStrEmpty(params.get("search"));
        if (StringUtils.isNotEmpty(search)) {
            criteria.andCondition("phone_number like '%" + search + "%'" + " or user_name like '%" + search + "%'");
        }
        String userIdentify = StringUtil.getStrEmpty(params.get("userIdentify"));
        if (StringUtils.isNotEmpty(userIdentify)) {
            //通过客户标识DKH000，DHK001区别客户类别
            criteria.andEqualTo("userIdentify", userIdentify);
        }
        String ifReportOrAllot = StringUtil.getStrEmpty(params.get("ifReportOrAllot"));
        if (StringUtils.isNotEmpty(ifReportOrAllot)) {
            criteria.andEqualTo("ifReportOrAllot", ifReportOrAllot);
        }
        String advisorName = StringUtil.getStrEmpty(params.get("advisorName"));
        if (StringUtils.isNotEmpty(advisorName)) {
            //此处为实体类的属性，不是表字段
            criteria.andEqualTo("investmentAdviser", advisorName);
        }
        criteria.andEqualTo("ifDelete", 0);
        PageHelper.startPage(IntegerUtil.getIntZero(params.get("currentPage")), IntegerUtil.getIntZero(params.get("pageSize")));
        List<KamUserInfo> list = selectByExample(example);
        return new PageInfo<KamUserInfo>(list);
    }


    /*外部拓展客户*/

    /**
     * 根据条件查询外部拓展用户集合，
     * 用于前台页面的Excel导出
     *
     * @param search
     * @return
     */
    public List<KamUserInfo> findBySearch(String search) {
        Example example = new Example(KamUserInfo.class);
        Example.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotEmpty(search)) {
            criteria.andCondition("phone_number like '%" + search + "%'" + " or sys_name like '%" + search + "%'");
        }
        List<KamUserInfo> list = selectByExample(example);
        return list;
    }

    /**
     * 保存单个用户到两张表
     *
     * @param kamUserInfo
     * @param kamExtUserUpload
     * @return
     */
    public int saveUserToTwo(KamUserInfo kamUserInfo, KamExtUserUpload kamExtUserUpload) {
        int num1 = this.save(kamUserInfo);
        int num2 = this.kamExtUserUploadService.save(kamExtUserUpload);
        if (num1 > 0 && num2 > 0) {
            return 1;
        } else {
            return -1;
        }
    }

    /**
     * 查找手机号是否存在
     * 两张表里有一张存在就是true，都不存在即为false
     *
     * @param phoneNumber
     * @return
     */
    public Boolean findByPhoneNumber(String phoneNumber) {
        //构建查询条件
        KamUserInfo kamUserInfo = new KamUserInfo();
        kamUserInfo.setPhoneNumber(Long.parseLong(phoneNumber));
        KamExtUserUpload kamExtUserUpload = new KamExtUserUpload();
        kamExtUserUpload.setPhoneNumber(kamUserInfo.getPhoneNumber());
        //查询
        KamUserInfo userInfo = this.mapper.selectOne(kamUserInfo);
        KamExtUserUpload extUserUpload = this.kamExtUserUploadService.selcetOne(kamExtUserUpload);
        if (userInfo == null && extUserUpload == null) {
            //该手机号不存在
            return false;
        } else {
            return true;
        }
    }

    /*平台待分配客户*/


    /*正式客户*/
}
