package org.blazer.bigclient.controller;

import com.github.pagehelper.PageInfo;
import org.blazer.bigclient.excel.ExcelHeader;
import org.blazer.bigclient.model.SrAssetsBalance;
import org.blazer.bigclient.service.SrAssetsBalanceService;
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
 * Created by cuican on 2016-11-14.
 */
@RequestMapping("/sr/assets_balance")
@Controller
public class SrAssetsBalanceController extends BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SrAssetsBalanceController.class);

    @Autowired
    private SrAssetsBalanceService srAssetsBalanceService;

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
    public PageInfo<SrAssetsBalance> findByPage(HttpServletRequest request, HttpServletResponse response) {
        //获取前台传递过来的参数
        HashMap<String, String> params = getParamMap(request);
        LOGGER.debug("分页条件查询列表--当前页-currentPage:" + IntegerUtil.getIntZero(params.get("currentPage")) +
                ", 每页的行数-pageSize:" + IntegerUtil.getIntZero(params.get("pageSize")) +
                ", 查询条件-search:" + StringUtil.getStrEmpty(params.get("search")) +
                ", AUM时间点-dateStart:" + StringUtil.getStrEmpty(params.get("dateStart")) +"......");

        /*//获取当前登录用户
        KamAdvisor advisor = super.getCurrentUser(request);

        //判断当前登录用户如果为投顾,则添加投顾真实姓名作为查询参数
        if (advisor != null) {
            params.put("advisorName", advisor.getActualName());
        }*/
        return this.srAssetsBalanceService.findByPage(params);
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
            LOGGER.debug("查询条件-search:" + StringUtil.getStrEmpty(params.get("search")) +
                    ", AUM时间点-dateStart:" + StringUtil.getStrEmpty(params.get("dateStart")) +"......");

            //xml配置中的ID
            String id = "srAssetsBalance";
            // 要导出的数据
            List<SrAssetsBalance> list = this.srAssetsBalanceService.findBySearch(params);
            if (list == null || list.size() == 0) {
                SrAssetsBalance assetsBalance = new SrAssetsBalance(Long.parseLong("0"),"0",Long.parseLong("0"),"0",
                        "0","0","0","0","0","0",new Date(),new Date());
                list.add(assetsBalance);
            }
            //excel文件名称,不需要任何后缀
            String excelName = "AssetsBalance_Export_" + DateUtil.date2Str(new Date(), DateUtil.DEFAULT_DATE_TIME_FORMAT);
            //可以为空,自定义Excel头信息
            ExcelHeader header = null;
            //指定导出字段
            List<String> specifyFields = new ArrayList<String>();
            specifyFields.add("userName");
            specifyFields.add("phoneNumber");
            specifyFields.add("investmentAdviser");
            specifyFields.add("registerDate");
            specifyFields.add("regularAssetsTotal");
            specifyFields.add("currentAssetsTotal");
            specifyFields.add("crpAssetsTotal");
            specifyFields.add("aumTotal");
            specifyFields.add("aumTimePoint");

            //构建excel试图
            mv = super.createExcelView(id, list, excelName, header, specifyFields);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mv;
    }


    /**
     * 月初AUM导出
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "exportMonthly", method = RequestMethod.POST)
    public ModelAndView exportMonthly(HttpServletRequest request) {
        ModelAndView mv = null;
        try {
            //获取前台传递过来的参数
            String data = request.getParameter("date");
            LOGGER.debug("查询的月份-data:" + data);

            //xml配置中的ID
            String id = "srAssetsBalance";
            // 要导出的数据
            List<SrAssetsBalance> list = this.srAssetsBalanceService.findByMonthly(data);
            if (list == null || list.size() == 0) {
                SrAssetsBalance assetsBalance = new SrAssetsBalance(Long.parseLong("0"),"0",Long.parseLong("0"),"0",
                        "0","0","0","0","0","0",new Date(),new Date());
                list.add(assetsBalance);
            }
            //excel文件名称,不需要任何后缀
            String excelName = "AssetsBalance_Monthly_" + DateUtil.date2Str(new Date(), DateUtil.DEFAULT_DATE_TIME_FORMAT);
            //可以为空,自定义Excel头信息
            ExcelHeader header = null;
            //指定导出字段
            List<String> specifyFields = new ArrayList<String>();
            specifyFields.add("userName");
            specifyFields.add("phoneNumber");
            specifyFields.add("investmentAdviser");
            specifyFields.add("registerDate");
            specifyFields.add("regularAssetsTotal");
            specifyFields.add("currentAssetsTotal");
            specifyFields.add("crpAssetsTotal");
            specifyFields.add("aumTotal");
            specifyFields.add("aumTimePoint");

            //构建excel试图
            mv = super.createExcelView(id, list, excelName, header, specifyFields);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mv;
    }

}
