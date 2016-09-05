package org.blazer.bigclient.action;

import com.github.pagehelper.PageInfo;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.blazer.bigclient.body.AjaxResult;
import org.blazer.bigclient.excel.ExcelException;
import org.blazer.bigclient.excel.ExcelHeader;
import org.blazer.bigclient.excel.vo.ExcelImportResult;
import org.blazer.bigclient.model.BcExcel;
import org.blazer.bigclient.model.BcExternalUser;
import org.blazer.bigclient.model.BcExternalUserBackup;
import org.blazer.bigclient.service.BcExcelService;
import org.blazer.bigclient.service.BcExternalUserBackupService;
import org.blazer.bigclient.service.BcExternalUserService;
import org.blazer.bigclient.util.ExcelHandlerUtil;
import org.blazer.bigclient.util.IntegerUtil;
import org.blazer.bigclient.util.UploadUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;


/**
 * Created by cuican on 2016-8-26.
 */
@RequestMapping("/ext")
@Controller
public class BcExternalUserController extends BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(BcExternalUserController.class);

    @Autowired
    private BcExternalUserService bcExternalUserService;

    @Autowired
    private BcExternalUserBackupService bcExternalUserBackupService;


    /**
     * 根据搜索条件分页查询列表
     *
     * @param request
     * @param response
     * @return
     */
    @ResponseBody
    @RequestMapping("findByPage")
    public PageInfo<BcExternalUser> listAllUserByPage(HttpServletRequest request, HttpServletResponse response) {
        HashMap<String, String> params = getParamMap(request);
        LOGGER.debug("currentPage:" + IntegerUtil.getInt0(params.get("currentPage")) + ", pageSize:" + IntegerUtil.getInt0(params.get("pageSize")));
        return bcExternalUserService.findByPage(params);
    }

    /**
     * Excel导入
     *
     * @param file
     * @param request
     * @param response
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "upload", method = RequestMethod.POST)
    public AjaxResult importExcel(@RequestParam("fileExcel") CommonsMultipartFile file, HttpServletRequest request, HttpServletResponse response) {

        LOGGER.info("该上传的excel文件的原文件名是 :" + file.getOriginalFilename());

        AjaxResult result = AjaxResult.success("导入数据成功");

	/*	User loginUser = (User) request.getSession().getAttribute("loginUser");
        // 判断SESSION是否失效
		if (loginUser == null || "".equals(loginUser)) {
			return "250";
		}
		int loginUserId = loginUser.getUserId();*/

        if (!file.isEmpty()) {

            //判断请求类型是否为文件上传类型
            if (!ServletFileUpload.isMultipartContent(request)) {
                result.setCode(AjaxResult.CODE_FAILURE);
                result.setMsg("该请求无法上传文件，请联系技术支持。。。");
                return result;
            }

            //当文件超过设置的大小时，则不运行上传
            if (file.getSize() > (1024*1024*100)) {
                result.setCode(AjaxResult.CODE_FAILURE);
                result.setMsg("该文件大小超过100m，请更换较小的文件重新上传。。。");
                return result;
            }

            //获取文件名后缀
            String OriginalFilename = file.getOriginalFilename();
            String fileSuffix = OriginalFilename.substring(OriginalFilename.lastIndexOf(".") + 1).toLowerCase();
            System.out.println("fileSuffix = " + fileSuffix);

            //判断该类型的文件是否在允许上传的文件类型内
            if (fileSuffix != "xls" && fileSuffix != "xlsx") {
                result.setCode(AjaxResult.CODE_FAILURE);
                result.setMsg("请检查上传的Excle文件的格式是否正确。。。");
                return result;
            }

            try {
                // 获取BcExcel对象
                BcExcel bcExcel = ExcelHandlerUtil.getExcelFile(file, request);
                bcExcel.setServiceId(1);
                bcExcel.setUserId(1L);
                bcExcel.setMtime(new Date());
                bcExcel.setCtime(bcExcel.getMtime());
                System.out.println("bcExcel = " + bcExcel);

                result.setObj(bcExcel);

                // 读取excel文件
                String excelType = "bcExternalUserBackup";
                ExcelImportResult readExcel = excelContext.readExcel(excelType, file.getInputStream());
                List<BcExternalUserBackup> listBean = readExcel.getListBean();
                bcExternalUserBackupService.importExcelData(listBean,bcExcel);

                // 上传文件
                UploadUtil.copy(file,bcExcel.getExcelRealPath(), bcExcel.getExcelRealName());
            } catch (Exception e) {
                result.setCode(AjaxResult.CODE_FAILURE);
                if (e instanceof ExcelException) {
                    result.setMsg(e.getMessage());
                } else {
                    if (e instanceof InvalidFormatException) {
                        result.setMsg("错误的文件格式");
                    }
                    result.setMsg(e.getMessage());
                    e.printStackTrace();
                    LOGGER.error(e.getMessage());
                }
            }
        }

        System.out.println("result = " + result);
        return result;
    }

    /**
     * 导出excel列表
     *
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping(value = "export/excel", method = RequestMethod.POST)
    public ModelAndView exportExcel(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                    @RequestParam(value = "rows", defaultValue = "10") Integer rows) {
        ModelAndView mv = new ModelAndView();
        // 设置视图名称
        mv.setViewName("excelView");
        // 模型数据
//		mv.addObject("userList", this.bcExternalUserService.queryUserList(page, rows).getRows());
        return mv;
    }


    @Override
    public ModelAndView createExcelView(String id, List<?> beans, String excelName, ExcelHeader header, List<String> fields) {

        return super.createExcelView(id, beans, excelName, header, fields);
    }


}
