package org.blazer.bigclient.controller;

import com.github.pagehelper.PageInfo;
import org.blazer.bigclient.excel.ExcelHeader;
import org.blazer.bigclient.model.PaRegularSalesScaleAccounting;
import org.blazer.bigclient.service.PaRegularSalesScaleAccountingService;
import org.blazer.bigclient.util.DateUtil;
import org.blazer.bigclient.util.IntegerUtil;
import org.blazer.bigclient.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Created by cuican on 2016-11-21.
 */
@RequestMapping("/pa/regular_sales_scale")
@Controller
public class PaRegularSalesScaleAccountingController extends BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PaRegularSalesScaleAccountingController.class);

    @Autowired
    private PaRegularSalesScaleAccountingService paRegularSalesScaleAccountingService;

    /**
     * 根据搜索条件分页查询
     * 添加了投顾权限控制
     *
     * @param request
     * @param response
     * @return
     */
    @ResponseBody
    @RequestMapping("findByPage")
    public PageInfo<PaRegularSalesScaleAccounting> findByPage(HttpServletRequest request, HttpServletResponse response) {
        //获取前台传递过来的参数
        HashMap<String, String> params = getParamMap(request);
        LOGGER.debug("currentPage:" + IntegerUtil.getIntZero(params.get("currentPage")) +
                ", pageSize:" + IntegerUtil.getIntZero(params.get("pageSize")) +
                ", search:" + StringUtil.getStrEmpty(params.get("search")));

        /*//获取当前登录用户
        KamAdvisor advisor = super.getCurrentUser(request);

        //判断当前登录用户如果为投顾,则添加投顾真实姓名作为查询参数
        if (advisor != null) {
            params.put("advisorName", advisor.getActualName());
        }*/
        return this.paRegularSalesScaleAccountingService.findByPage(params);
    }


    /**
     * 条件查询导出excel文件
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "exportExcel", method = RequestMethod.POST)
    public ModelAndView exportExcel(HttpServletRequest request) {
        ModelAndView mv = null;
        try {
            //根据条件获取要导出的数据集合
            String search = StringUtil.getStrEmpty(request.getParameter("search"));
            LOGGER.debug("查询条件---search:" + search);

            //xml配置中的ID
            String id = "paRegularSalesScaleAccounting";
            // 要导出的数据
            List<PaRegularSalesScaleAccounting> list = this.paRegularSalesScaleAccountingService.findBySearch(search);
            if (list == null || list.size() == 0) {
                PaRegularSalesScaleAccounting regularSalesScaleAccounting = new PaRegularSalesScaleAccounting();
                regularSalesScaleAccounting.setUserName("测试姓名");
                list.add(regularSalesScaleAccounting);
            }
            //excel文件名称,不需要任何后缀
            String excelName = "RegularSalesScaleAccounting_Export_" + DateUtil.date2Str(new Date(), DateUtil.DEFAULT_DATE_TIME_FORMAT);
            //可以为空,自定义Excel头信息
            ExcelHeader header = null;
            //指定导出字段
            List<String> specifyFields = new ArrayList<String>();
            /*
            * <field name="id" title="自动编号"/>
                <field name="userName" title="客户姓名"/>
                <field name="phoneNumber" title="手机号码"/>
                <field name="referrer" title="扫码推荐人"/>
                <field name="rebateExpirationDate" title="返利失效日期"/>
                <field name="reportOrAllot" title="上报/分配"/>
                <field name="reportOrAllotDate" title="上报/分配时间"/>
                <field name="investmentAdviser" title="投资顾问"/>
                <field name="userIdentify" title="客户标识"/>
                <field name="basicProductName" title="基础产品名称（定期）"/>
                <field name="investmentAmount" title="投资金额"/>
                <field name="regularAssetsTotal" title="现有资产"/>
                <field name="investmentDate" title="购买时间"/>
                <field name="partitionCoefficient" title="分配系数"/>
                <field name="performancePoolCoefficient" title="业绩池系数"/>
                <field name="productCoefficient" title="产品系数"/>
                <field name="effectiveSalesAmount" title="有效销售金额（单位：元）"/>
                <field name="mtime" title="更新时间" pattern="yyyy-MM-dd HH:mm:ss"/>
                <field name="ctime" title="创建时间" pattern="yyyy-MM-dd HH:mm:ss"/>
            * */
            specifyFields.add("userName");
            specifyFields.add("phoneNumber");
            specifyFields.add("referrer");
            specifyFields.add("rebateExpirationDate");
            specifyFields.add("reportOrAllot");
            specifyFields.add("reportOrAllotDate");
            specifyFields.add("investmentAdviser");
            specifyFields.add("userIdentify");
            specifyFields.add("basicProductName");
            specifyFields.add("investmentAmount");
            specifyFields.add("regularAssetsTotal");
            specifyFields.add("investmentDate");
            specifyFields.add("partitionCoefficient");
            specifyFields.add("performancePoolCoefficient");
            specifyFields.add("productCoefficient");
            specifyFields.add("effectiveSalesAmount");

            //构建excel试图
            mv = super.createExcelView(id, list, excelName, header, specifyFields);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mv;
    }

}
