package org.blazer.bigclient.controller;

import com.github.pagehelper.PageInfo;
import org.blazer.bigclient.excel.ExcelHeader;
import org.blazer.bigclient.model.PaCurrentPackageRegularSalesScaleAccounting;
import org.blazer.bigclient.service.PaCurrentPackageRegularSalesScaleAccountingService;
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
@RequestMapping("/pa/cpr_sales_scale")
@Controller
public class PaCurrentPackageRegularSalesScaleAccountingController extends BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PaCurrentPackageRegularSalesScaleAccountingController.class);

    @Autowired
    private PaCurrentPackageRegularSalesScaleAccountingService paCurrentPackageRegularSalesScaleAccountingService;

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
    public PageInfo<PaCurrentPackageRegularSalesScaleAccounting> findByPage(HttpServletRequest request, HttpServletResponse response) {
        //获取前台传递过来的参数
        HashMap<String, String> params = getParamMap(request);
        LOGGER.debug("分页条件查询列表--当前页-currentPage:" + IntegerUtil.getIntZero(params.get("currentPage")) +
                ", 每页的行数-pageSize:" + IntegerUtil.getIntZero(params.get("pageSize")) +
                ", 查询条件-search:" + StringUtil.getStrEmpty(params.get("search")) +
                ", 起始时间-dateStart:" + StringUtil.getStrEmpty(params.get("dateStart")) +
                ", 截止时间-dateEnd:" + StringUtil.getStrEmpty(params.get("dateEnd"))+"......");

        /*//获取当前登录用户
        KamAdvisor advisor = super.getCurrentUser(request);

        //判断当前登录用户如果为投顾,则添加投顾真实姓名作为查询参数
        if (advisor != null) {
            params.put("advisorName", advisor.getActualName());
        }*/
        return this.paCurrentPackageRegularSalesScaleAccountingService.findByPage(new PaCurrentPackageRegularSalesScaleAccounting(),params,"purchaseDate");
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
            //获取前台传递过来的参数
            HashMap<String, String> params = getParamMap(request);
            LOGGER.debug("excel导出条件查询--当前页-currentPage:" + IntegerUtil.getIntZero(params.get("currentPage")) +
                    ", 每页的行数-pageSize:" + IntegerUtil.getIntZero(params.get("pageSize")) +
                    ", 查询条件-search:" + StringUtil.getStrEmpty(params.get("search")) +
                    ", 起始时间-dateStart:" + StringUtil.getStrEmpty(params.get("dateStart")) +
                    ", 截止时间-dateEnd:" + StringUtil.getStrEmpty(params.get("dateEnd"))+"---");

            //xml配置中的ID
            String id = "paCurrentSalesScaleAccounting";
            // 要导出的数据
            List<PaCurrentPackageRegularSalesScaleAccounting> list = this.paCurrentPackageRegularSalesScaleAccountingService.findBySearch(
                    new PaCurrentPackageRegularSalesScaleAccounting(),params,"purchaseDate");
            if (list == null || list.size() == 0) {
                PaCurrentPackageRegularSalesScaleAccounting salesScaleAccounting = new PaCurrentPackageRegularSalesScaleAccounting(
                        Long.parseLong("0"),"0",Long.parseLong("0"),0,"0","0","0","0","0","0","0",
                        Double.parseDouble("0"),0,Double.parseDouble("0"),Double.parseDouble("0"),new Date(),new Date());
                list.add(salesScaleAccounting);
            }
            //excel文件名称,不需要任何后缀
            String excelName = "CurrentSalesScaleAccounting_Export_" + DateUtil.date2Str(new Date(), DateUtil.DEFAULT_DATE_TIME_FORMAT);
            //可以为空,自定义Excel头信息
            ExcelHeader header = null;
            //指定导出字段
            List<String> specifyFields = new ArrayList<String>();

            specifyFields.add("userName");
            specifyFields.add("phoneNumber");
            specifyFields.add("reportOrAllot");
            specifyFields.add("reportOrAllotDate");
            specifyFields.add("investmentAdviser");
            specifyFields.add("userIdentify");
            specifyFields.add("basicProductName");
            specifyFields.add("monthlyPurchaseAmount");
            specifyFields.add("currentAssetsTotal");
            specifyFields.add("purchaseDate");
            specifyFields.add("monthlyPurchaseAmount5");
            specifyFields.add("performancePoolCoefficient");
            specifyFields.add("effectiveCurrentSalesScale");
            specifyFields.add("deferredNextMonth");

            //构建excel试图
            mv = super.createExcelView(id, list, excelName, header, specifyFields);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mv;
    }

}
