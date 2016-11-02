package org.blazer.bigclient.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
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
 * Created by yyccb on 2016-10-13.
 */
@Service
public class KamExtUserUploadService extends BaseService<KamExtUserUpload> {

    private static final Logger LOGGER = LoggerFactory.getLogger(KamExtUserUploadService.class);

    @Autowired
    private KamExcelService kamExcelService;

    @Autowired
    private KamUserInfoService kamUserInfoService;

    @Autowired
    private KamUserToAdvisorService kamUserToAdvisorService;

    @Autowired
    private KamAdvisorService kamAdvisorService;

    /**
     * 条件分页查询列表
     *
     * @param params
     * @return
     */
    public PageInfo<KamExtUserUpload> findByPage(HashMap<String, String> params) {
        LOGGER.info("根据条件查询列表。。。");
        Example example = new Example(KamExtUserUpload.class);
        Example.Criteria criteria = example.createCriteria();
        String search = StringUtil.getStrEmpty(params.get("search"));
        String advisorName = StringUtil.getStrEmpty(params.get("advisorName"));
        if (StringUtils.isNotEmpty(search)) {
            criteria.andCondition("phone_number like '%" + search + "%'" + " or user_name like '%" + search + "%'");
        }
        if (StringUtils.isNotEmpty(advisorName)) {
            //此处为实体类的属性，不是表字段
            criteria.andEqualTo("investmentAdviser", advisorName);
        }
        criteria.andEqualTo("ifDelete", 0);
        PageHelper.startPage(IntegerUtil.getIntZero(params.get("currentPage")), IntegerUtil.getIntZero(params.get("pageSize")));
        List<KamExtUserUpload> list = selectByExample(example);
        return new PageInfo<KamExtUserUpload>(list);
    }

    /**
     * 根据条件查询 用于前台页面的Excel导出
     *
     * @param search
     * @return
     */
    public List<KamExtUserUpload> findBySearch(String search) {
        Example example = new Example(KamExtUserUpload.class);
        Example.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotEmpty(search)) {
            criteria.andCondition("phone_number like '%" + search + "%'" + " or user_name like '%" + search + "%'");
        }
        criteria.andEqualTo("ifDelete", 0);
        List<KamExtUserUpload> list = selectByExample(example);
        return list;
    }

    /**
     * 保存excel导入名单
     *
     * @param listBean
     * @param kamExcel
     */
    public void importExcelData(List<KamExtUserUpload> listBean, KamExcel kamExcel) {

        if (listBean != null && listBean.size() > 0 && kamExcel != null) {
            this.kamExcelService.getMapper().insert(kamExcel);
            Long id = kamExcel.getId();

            for (int i = 0; i < listBean.size(); i++) {
                KamExtUserUpload kamExtUserUpload = listBean.get(i);
                kamExtUserUpload.setExcelId(id);
                kamExtUserUpload.setCtime(new Date());

                //此处对客户手机号是否存在做判断（有效用户两个原则：1,上报姓名正确原则 2,先报先得原则）
                Long phoneNumber = kamExtUserUpload.getPhoneNumber();
                List<KamUserInfo> userInfoList = this.kamUserInfoService.selectByPhoneNumber(phoneNumber);

                if (userInfoList == null || userInfoList.size() == 0) {
                    //不存在
                    kamExtUserUpload.setIfDelete(0);
                    kamExtUserUpload.setIfEffective(1);
                    //如果有效，则加入到正式名单里面
                    KamUserInfo user = new KamUserInfo();
                    user.setExcelId(kamExtUserUpload.getExcelId());
                    user.setPhoneNumber(kamExtUserUpload.getPhoneNumber());
                    user.setIfReportOrAllot(1);
                    user.setReportOrAllot("上报");
                    user.setReportOrAllotDate(DateUtil.dateTime2Str(kamExtUserUpload.getCtime(), DateUtil.DEFAULT_DATE_TIME_FORMAT));
                    user.setUserIdentify("DKH000");
                    user.setIfDelete(0);
                    user.setCtime(new Date());
                    kamUserInfoService.save(user);
                    //保存到user版本表
                    KamUserToAdvisor userToAdvisor = new KamUserToAdvisor();
                    userToAdvisor.setUserId(user.getId());
                    KamAdvisor advisor = kamAdvisorService.selectByActualName(kamExtUserUpload.getInvestmentAdviser());
                    Long advisorId = null;
                    if (advisor != null) {
                        advisorId = advisor.getId();
                    }
                    userToAdvisor.setAdvisorId(advisorId);
                    userToAdvisor.setVersionNo("1");
                    userToAdvisor.setStartDate(kamExtUserUpload.getCtime());
                    userToAdvisor.setCtime(new Date());
                    this.kamUserToAdvisorService.save(userToAdvisor);
                } else {
                    //存在
                    kamExtUserUpload.setIfDelete(1);
                    kamExtUserUpload.setIfEffective(0);
                    kamExtUserUpload.setRemark("无效原因：手机号已存在");
                }
                this.save(kamExtUserUpload);
            }
        }
    }

    /**
     * 根据手机号查询客户
     *
     * @param phoneNumber
     * @return
     */
    public List<KamExtUserUpload> selectByPhoneNumber(Long phoneNumber) {
        Example example = new Example(KamExtUserUpload.class);
        Example.Criteria criteria = example.createCriteria();
        Long phoneNo = LongUtil.getLongZero(phoneNumber);
        criteria.andEqualTo("phoneNumber", phoneNo);
        List<KamExtUserUpload> list = this.selectByExample(example);
        return list;
    }
}
