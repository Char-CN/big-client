package org.blazer.bigclient.action;

import com.github.pagehelper.PageInfo;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.blazer.bigclient.body.AjaxResult;
import org.blazer.bigclient.excel.ExcelException;
import org.blazer.bigclient.excel.ExcelHeader;
import org.blazer.bigclient.excel.vo.ExcelImportResult;
import org.blazer.bigclient.model.BcExcel;
import org.blazer.bigclient.model.BcExternalUser;
import org.blazer.bigclient.service.BcExcelService;
import org.blazer.bigclient.service.BcExternalUserService;
import org.blazer.bigclient.util.IntegerUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;


/**
 * Created by cuican on 2016-8-26.
 */
@RequestMapping("/ext")
@Controller
public class BcExternalUserController extends BaseController {

	private static final Logger LOGGER = LoggerFactory.getLogger(BcExternalUserController.class);

	private static final HashMap<String, String> TypeMap = new HashMap<String, String>();
	//设置文件允许上传的类型
	static {
//		TypeMap.put("image", "gif,jpg,jpeg,png,bmp");
//		TypeMap.put("flash", "swf,flv");
//		TypeMap.put("media", "swf,flv,mp3,wav,wma,wmv,mid,avi,mpg,asf,rm,rmvb");
//		TypeMap.put("file", "doc,docx,xls,xlsx,ppt,pptx,htm,html,txt,dwg,pdf");
		TypeMap.put("file", "xls,xlsx");
	}

	// 设置文件上传大小
	public static long fileSize = 3 * 1024 * 1024;

	@Autowired
	private BcExternalUserService bcExternalUserService;

	@Autowired
	private BcExcelService bcExcelService;



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
	 * @param //response
	 * @return
	 */
//	@ResponseBody
//	@RequestMapping(value = "upload", method = RequestMethod.POST)
//	public String importExcel(@RequestParam("file") CommonsMultipartFile file, HttpServletRequest request, HttpServletResponse response) {
//
//		LOGGER.info("该上传的excel文件的原文件名是 :" + file.getOriginalFilename());
//
//		BcExcel bcExcel = new BcExcel();
//		bcExcel.setExcelName(file.getOriginalFilename());
//		bcExcel.setExcelRealName("");
//		bcExcel.setExcelRealPath("");
//
//
//		return "redirect:/ext/findByPage.do";
//	}

	@RequestMapping(value = "upload", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult importExcel(HttpServletRequest request, @RequestParam("excelFile") MultipartFile file) {
		LOGGER.info("该上传的excel文件的原文件名是 :" + file.getOriginalFilename());

		BcExcel bcExcel = new BcExcel();
		bcExcel.setExcelName(file.getOriginalFilename());
		bcExcel.setExcelRealName("");
		bcExcel.setExcelRealPath("");

		AjaxResult result = AjaxResult.success("导入数据成功");
		try {
			String excelType = "bcExternalUser";
			ExcelImportResult readExcel = excelContext.readExcel(excelType, file.getInputStream());
			List<BcExternalUser> listBean = readExcel.getListBean();
//			bcExternalUserService.importExcelData(listBean);


		} catch (Exception e) {

			result.setCode(AjaxResult.CODE_FAILURE);
//			if (e instanceof ExcelException || e instanceof BaseException) {
			if (e instanceof ExcelException) {
				result.setMsg(e.getMessage());
			} else {
				if (e instanceof InvalidFormatException) {
					result.setMsg("错误的文件格式");
				}
//				result.setMsg(getErrorMessage());
				e.printStackTrace();
				LOGGER.error(String.valueOf(e));
			}
		}
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
