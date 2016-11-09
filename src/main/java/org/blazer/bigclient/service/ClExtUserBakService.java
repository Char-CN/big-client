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
 * Created by cuican on 2016-11-8.
 */
@Service
public class ClExtUserBakService extends BaseService<ClExtUserBak> {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClExtUserBakService.class);

    @Autowired
    private KamExcelService kamExcelService;

    @Autowired
    private ClFormalUserService clFormalUserService;

    @Autowired
    private ClFormalUserVersionService clFormalUserVersionService;

    @Autowired
    private KamAdvisorService kamAdvisorService;

    /**
     * 保存excel导入数据
     *
     * @param listBean
     * @param excel
     */
    public void importExcelData(List<ClExtUserBak> listBean, KamExcel excel) {

        if (listBean != null && listBean.size() > 0 && excel != null) {

            //保存excel文件对象信息到数据库表
            LOGGER.info("保存excel对象信息到数据库表。");
            this.kamExcelService.getMapper().insert(excel);
            Long id = excel.getId();
            //遍历上传名单的list集合，完善每一个客户对象信息
            for (int i = 0; i < listBean.size(); i++) {
                ClExtUserBak extUserBak = listBean.get(i);

                //查询该手机号是否存在，（有效用户两个原则：1,上报姓名正确原则 2,先报先得原则）
                Long phoneNumber = LongUtil.getLongZero(extUserBak.getPhoneNumber());
                List<ClExtUserBak> clExtUserBaks = this.selectByPhoneNumber(phoneNumber);

                //如果手机号不存在，设置该条数据有效
                if (clExtUserBaks == null || clExtUserBaks.size() == 0) {
                    extUserBak.setExcelId(id);//当前excel文件的id
                    extUserBak.setCtime(new Date());//该记录创建时间
                    extUserBak.setIfDelete(0);//可用（未删除）
                    extUserBak.setIfEffective(1);//有效名单

                    //同时，保存到正式名单
                    ClFormalUser formalUser = new ClFormalUser();
                    formalUser.setPhoneNumber(phoneNumber);
                    formalUser.setReportOrAllot("上报");
                    formalUser.setReportOrAllotDate(DateUtil.dateTime2Str(extUserBak.getCtime(), DateUtil.DEFAULT_DATE_TIME_FORMAT));
                    formalUser.setUserIdentify("DKH000");
                    formalUser.setInvestmentAdviser(extUserBak.getInvestmentAdviser());
                    formalUser.setIfDelete(0);
                    formalUser.setCtime(new Date());
                    this.clFormalUserService.save(formalUser);

                    //保存到user版本表
                    ClFormalUserVersion userVersion = new ClFormalUserVersion();
                    userVersion.setUserId(formalUser.getId());
                    KamAdvisor advisor = kamAdvisorService.selectByActualName(extUserBak.getInvestmentAdviser());
                    Long advisorId = null;
                    if (advisor != null) {
                        advisorId = advisor.getId();
                    }
                    userVersion.setAdvisorId(advisorId);
                    userVersion.setVersionNo("1");
                    userVersion.setStartDate(extUserBak.getCtime());
                    userVersion.setCtime(new Date());
                    this.clFormalUserVersionService.save(userVersion);
                } else {
                    //存在
                    extUserBak.setIfDelete(0);//先不删除，让投顾手动删除
                    extUserBak.setIfEffective(0);//无效客户名单
                    extUserBak.setRemark("无效原因：手机号已存在");//记录备注信息
                }
                this.save(extUserBak);
            }
        }


    }

    /**
     * 根据手机号查询
     *
     * @param phoneNumber
     * @return
     */
    public List<ClExtUserBak> selectByPhoneNumber(Long phoneNumber) {
        Example example = new Example(ClExtUserBak.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("phoneNumber", phoneNumber);
        LOGGER.info("根据手机号：" + phoneNumber + ",查询外部拓展客户（上传）表中是否已存在。");
        List<ClExtUserBak> list = this.selectByExample(example);
        return list;
    }

    /**
     * 分页列表查询
     *
     * @param params
     * @return
     */
    public PageInfo<ClExtUserBak> findByPage(HashMap<String, String> params) {

        LOGGER.info("根据条件查询列表。。。");
        Example example = new Example(ClExtUserBak.class);
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
        List<ClExtUserBak> list = selectByExample(example);
        return new PageInfo<ClExtUserBak>(list);

    }

    /**
     * 新增单个客户
     *
     * @param extUserBak
     */
    public void saveOne(ClExtUserBak extUserBak) {
        try {
            if (extUserBak != null) {

                this.save(extUserBak);

                //同时，保存到正式名单
                ClFormalUser formalUser = new ClFormalUser();
                formalUser.setPhoneNumber(extUserBak.getPhoneNumber());
                formalUser.setReportOrAllot("上报");
                formalUser.setReportOrAllotDate(DateUtil.dateTime2Str(extUserBak.getCtime(), DateUtil.DEFAULT_DATE_TIME_FORMAT));
                formalUser.setUserIdentify("DKH000");
                formalUser.setInvestmentAdviser(extUserBak.getInvestmentAdviser());
                formalUser.setIfDelete(0);
                formalUser.setCtime(new Date());
                this.clFormalUserService.save(formalUser);

                //保存到user版本表
                ClFormalUserVersion userVersion = new ClFormalUserVersion();
                userVersion.setUserId(formalUser.getId());
                KamAdvisor advisor = kamAdvisorService.selectByActualName(extUserBak.getInvestmentAdviser());
                Long advisorId = null;
                if (advisor != null) {
                    advisorId = advisor.getId();
                }
                userVersion.setAdvisorId(advisorId);
                userVersion.setVersionNo("1");
                userVersion.setStartDate(extUserBak.getCtime());
                userVersion.setCtime(new Date());
                this.clFormalUserVersionService.save(userVersion);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 修改单个用户
     *
     * @param extUserBak
     */
    public void updateOne(ClExtUserBak extUserBak) {
        try {
            if(extUserBak != null){
                this.updateNotNull(extUserBak);

                //查询出正式客户
                ClFormalUser formalUser = this.clFormalUserService.selectByPhoneNumber(extUserBak.getPhoneNumber());
                if(formalUser != null){
                    formalUser.setInvestmentAdviser(extUserBak.getInvestmentAdviser());
                    this.clFormalUserService.updateNotNull(formalUser);
                }
                //更新user版本表
                ClFormalUserVersion maxVersion = this.clFormalUserVersionService.selectMaxVerNoByUid(formalUser.getId());
                KamAdvisor advisor = kamAdvisorService.selectByActualName(extUserBak.getInvestmentAdviser());
                Long advisorId = null;
                if (advisor != null) {
                    advisorId = advisor.getId();
                }
                maxVersion.setAdvisorId(advisorId);
                maxVersion.setVersionNo(maxVersion.getVersionNo()+1);
                maxVersion.setStartDate(new Date());
                maxVersion.setCtime(new Date());

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
