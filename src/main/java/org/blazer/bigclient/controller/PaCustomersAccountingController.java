package org.blazer.bigclient.controller;

import com.github.pagehelper.PageInfo;
import org.blazer.bigclient.excel.ExcelHeader;
import org.blazer.bigclient.model.PaCustomersAccounting;
import org.blazer.bigclient.service.PaCustomersAccountingService;
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
@RequestMapping("/pa/customers_accounting")
@Controller
public class PaCustomersAccountingController extends BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PaCustomersAccountingController.class);

    @Autowired
    private PaCustomersAccountingService paCustomersAccountingService;

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
    public PageInfo<PaCustomersAccounting> findByPage(HttpServletRequest request, HttpServletResponse response) {
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
        return this.paCustomersAccountingService.findByPage(params);
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
            String id = "paCustomersAccounting";
            // 要导出的数据
            List<PaCustomersAccounting> list = this.paCustomersAccountingService.findBySearch(search);
            if (list == null || list.size() == 0) {
                PaCustomersAccounting customersAccounting = new PaCustomersAccounting(Long.parseLong("0"),"0",Long.parseLong("0"),
                        "0","0","0",0,"0","0","0","0","0",0,"0",0,0,0,0,0,0,0,"0", new Date(), new Date());
                list.add(customersAccounting);
            }
            //excel文件名称,不需要任何后缀
            String excelName = "CustomersAccounting_Export_" + DateUtil.date2Str(new Date(), DateUtil.DEFAULT_DATE_TIME_FORMAT);
            //可以为空,自定义Excel头信息
            ExcelHeader header = null;
            //指定导出字段
            List<String> specifyFields = new ArrayList<String>();

            specifyFields.add("id");
            specifyFields.add("userName");
            specifyFields.add("phoneNumber");
            specifyFields.add("registerDate");
            specifyFields.add("endingBalance");
            specifyFields.add("endingBalanceTimePoint");
            specifyFields.add("endingNotLessThanFifty");
            specifyFields.add("investmentAdviser");
            specifyFields.add("buyAmount");
            specifyFields.add("currentAmountPaid");
            specifyFields.add("beginningBalance");
            specifyFields.add("beginningBalanceTimePoint");
            specifyFields.add("beginningNoGreaterThanFifty");
            specifyFields.add("userIdentify");
            specifyFields.add("ifPerformancePool");
            specifyFields.add("advisorGetCustomers");
            specifyFields.add("comparisonHistoricalAdvisor");
            specifyFields.add("advisorGetCustomersRemoveDuplicates");
            specifyFields.add("centerForCustomers");
            specifyFields.add("comparisonHistoricalCenter");
            specifyFields.add("centerForCustomersRemoveDuplicates");
            specifyFields.add("errorQuery");

            //构建excel试图
            mv = super.createExcelView(id, list, excelName, header, specifyFields);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mv;
    }

}
