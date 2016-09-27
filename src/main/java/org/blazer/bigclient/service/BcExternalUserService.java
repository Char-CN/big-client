package org.blazer.bigclient.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.blazer.bigclient.model.BcExternalUser;
import org.blazer.bigclient.model.BcExternalUserBackup;
import org.blazer.bigclient.util.IntegerUtil;
import org.blazer.bigclient.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.HashMap;
import java.util.List;

/**
 * Created by cuican on 2016-8-26.
 */
@Service
public class BcExternalUserService extends BaseService<BcExternalUser> {

    @Autowired
    private BcExternalUserBackupService bcExternalUserBackupService;

    /**
     * 分页条件查询用户列表
     *
     * @param params
     * @return
     */
    public PageInfo<BcExternalUser> findByPage(HashMap<String, String> params) {
        Example example = new Example(BcExternalUser.class);
        Example.Criteria criteria = example.createCriteria();
        String search = StringUtil.getStrEmpty(params.get("search"));
        if (StringUtils.isNotEmpty(search)) {
            criteria.andCondition("phone_number like '%" + search + "%'" + " or sys_name like '%" + search + "%'");
        }
        PageHelper.startPage(IntegerUtil.getIntZero(params.get("currentPage")), IntegerUtil.getIntZero(params.get("pageSize")));
        List<BcExternalUser> list = selectByExample(example);
        return new PageInfo<BcExternalUser>(list);
    }

    /**
     * 根据条件查询外部拓展用户集合，
     * 用于前台页面的Excel导出
     *
     * @param search
     * @return
     */
    public List<BcExternalUser> findBySearch(String search) {
        Example example = new Example(BcExternalUser.class);
        Example.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotEmpty(search)) {
            criteria.andCondition("phone_number like '%" + search + "%'" + " or sys_name like '%" + search + "%'");
        }
        List<BcExternalUser> list = selectByExample(example);
        return list;
    }

    /**
     * 保存单个用户到两张表
     *
     * @param bcExternalUser
     * @param bcExternalUserBackup
     * @return
     */
    public int saveUserToTwo(BcExternalUser bcExternalUser, BcExternalUserBackup bcExternalUserBackup) {
        int num1 = this.save(bcExternalUser);
        int num2 = this.bcExternalUserBackupService.save(bcExternalUserBackup);
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
        BcExternalUser bcExternalUser = new BcExternalUser();
        bcExternalUser.setPhoneNumber(Long.parseLong(phoneNumber));
        BcExternalUserBackup bcExternalUserBackup = new BcExternalUserBackup();
        bcExternalUserBackup.setPhoneNumber(bcExternalUser.getPhoneNumber());
        //查询
        BcExternalUser externalUser = this.mapper.selectOne(bcExternalUser);
        BcExternalUserBackup externalUserBackup = this.bcExternalUserBackupService.selcetOne(bcExternalUserBackup);
        if (externalUser == null && externalUserBackup == null) {
            return false;
        } else {
            return true;
        }
    }

}
