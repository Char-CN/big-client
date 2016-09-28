package org.blazer.bigclient.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.blazer.bigclient.model.BcFormalUser;
import org.blazer.bigclient.util.IntegerUtil;
import org.blazer.bigclient.util.StringUtil;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.HashMap;
import java.util.List;

/**
 * Created by cuican on 2016-8-26.
 */
@Service
public class BcFormalUserService extends BaseService<BcFormalUser> {

    /**
     * 分页条件查询用户列表
     *
     * @param params
     * @return
     */
    public PageInfo<BcFormalUser> findByPage(HashMap<String, String> params) {
        Example example = new Example(BcFormalUser.class);
        Example.Criteria criteria = example.createCriteria();
        String search = StringUtil.getStrEmpty(params.get("search"));
        if (StringUtils.isNotEmpty(search)) {
            criteria.andCondition("phone_number like '%" + search + "%'" + " or sys_name like '%" + search + "%'");
        }
        PageHelper.startPage(IntegerUtil.getIntZero(params.get("currentPage")), IntegerUtil.getIntZero(params.get("pageSize")));
        List<BcFormalUser> list = selectByExample(example);
        return new PageInfo<BcFormalUser>(list);
    }

    /**
     * 根据条件查询外部拓展用户集合，
     * 用于前台页面的Excel导出
     *
     * @param search
     * @return
     */
    public List<BcFormalUser> findBySearch(String search) {
        Example example = new Example(BcFormalUser.class);
        Example.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotEmpty(search)) {
            criteria.andCondition("phone_number like '%" + search + "%'" + " or sys_name like '%" + search + "%'");
        }
        List<BcFormalUser> list = selectByExample(example);
        return list;
    }

//    /**
//     * 保存单个用户到两张表
//     *
//     * @param BcFormalUser
//     * @return
//     */
//    public int saveUserToTwo(BcFormalUser bcFormalUser) {
//        int num1 = this.save(BcFormalUser);
//        int num2 = this.BcFormalUserBackupService.save(BcFormalUserBackup);
//        if (num1 > 0 && num2 > 0) {
//            return 1;
//        } else {
//            return -1;
//        }
//    }
//
//    /**
//     * 查找手机号是否存在
//     * 两张表里有一张存在就是true，都不存在即为false
//     *
//     * @param phoneNumber
//     * @return
//     */
//    public Boolean findByPhoneNumber(String phoneNumber) {
//        //构建查询条件
//        BcFormalUser BcFormalUser = new BcFormalUser();
//        BcFormalUser.setPhoneNumber(Long.parseLong(phoneNumber));
//        BcFormalUserBackup BcFormalUserBackup = new BcFormalUserBackup();
//        BcFormalUserBackup.setPhoneNumber(BcFormalUser.getPhoneNumber());
//        //查询
//        BcFormalUser externalUser = this.mapper.selectOne(BcFormalUser);
//        if (externalUser == null && externalUserBackup == null) {
//            return false;
//        } else {
//            return true;
//        }
//    }

}
