package org.blazer.bigclient.action;

import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
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
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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


	@ResponseBody
	@RequestMapping(value = "upload", method = RequestMethod.POST)
	public String importExcel(HttpServletRequest request) {



		return "redirect:/ext/findByPage.do";
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


}
