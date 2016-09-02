package org.blazer.bigclient.action;

import com.github.pagehelper.PageInfo;
import org.blazer.bigclient.excel.ExcelHeader;
import org.blazer.bigclient.model.BcExcel;
import org.blazer.bigclient.model.BcExternalUser;
import org.blazer.bigclient.service.BcExcelService;
import org.blazer.bigclient.service.BcExternalUserService;
import org.blazer.bigclient.util.IPUtil;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
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
     * @param request
     * @param response
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "upload", method = RequestMethod.POST)
    public String importExcel(HttpServletRequest request, HttpServletResponse response) {

        System.out.println("进入控制层");

	/*	User loginUser = (User) request.getSession().getAttribute("loginUser");
        // 判断SESSION是否失效
		if (loginUser == null || "".equals(loginUser)) {
			return "250";
		}
		int loginUserId = loginUser.getUserId();*/
        List<String> paths = new ArrayList<>();
        // 设置上下文
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
        // 检查form是否有enctype="multipart/form-data"
        if (multipartResolver.isMultipart(request)) {

            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;

            Iterator<String> iter = multiRequest.getFileNames();

            while (iter.hasNext()) {
                // 由CommonsMultipartFile继承而来,拥有上面的方法.
                MultipartFile file = multiRequest.getFile(iter.next());
                System.out.println("file:" + file.getSize());
                // 如果文件不为空，则进行处理
                if (!file.isEmpty()) {
                    // 获取文件名
                    String originalFileName = file.getOriginalFilename();

                    // 取得后缀
                    String suffixString = UploadUtil.getExtensionName(originalFileName);

                    // 取得IP地址
                    String ip = IPUtil.getIpAddr(request);

                    // 设定文件名称
                    String fileName = UploadUtil.getNewFileName(ip,suffixString);

                    // 设置上传路径
                    String filePath = "/src/upload/"+fileName;

                    File localFile = new File(filePath);

                    try {
                        file.transferTo(localFile);
                        // 将名称和相对路径存到数据库中
                        BcExcel bcExcel = new BcExcel();
                        bcExcel.setExcelName(originalFileName);
                        bcExcel.setExcelRealName(fileName);
                        bcExcel.setExcelRealPath(filePath);

                        System.out.println("bcExcel = " + bcExcel);
                    } catch (IllegalStateException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }
        }
        return "redirect:/ext/findByPage.do";
    }

	/*@RequestMapping(value = "upload", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult importExcel(HttpServletRequest request, @RequestParam("fileExcel") MultipartFile file) {
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
			e.printStackTrace();
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
	}*/


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
