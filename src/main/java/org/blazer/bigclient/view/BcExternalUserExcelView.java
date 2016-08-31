package org.blazer.bigclient.view;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.blazer.bigclient.model.BcExternalUser;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

public class BcExternalUserExcelView extends AbstractExcelView {

    @Override
    protected void buildExcelDocument(Map<String, Object> model, HSSFWorkbook workbook,
                                      HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 从model对象中获取userList
        List<BcExternalUser> userList = (List<BcExternalUser>) model.get("userList");
        // 创建Excel的sheet
        HSSFSheet sheet = workbook.createSheet("外部拓展客户名单列表");

        // 创建标题行
        HSSFRow header = sheet.createRow(0);
        header.createCell(0).setCellValue("自动序号");
        header.createCell(1).setCellValue("手机号码");
        header.createCell(2).setCellValue("系统内姓名");
        header.createCell(3).setCellValue("是否注册");
        header.createCell(4).setCellValue("注册日期");
        header.createCell(5).setCellValue("是否实名");
        header.createCell(6).setCellValue("是否绑卡");
        header.createCell(7).setCellValue("是否有过交易");
        header.createCell(8).setCellValue("扫码推荐人");
        header.createCell(9).setCellValue("返利失效日期");
        header.createCell(10).setCellValue("更新时间");
        header.createCell(11).setCellValue("创建时间");

        // 填充数据
        int rowNum = 1;
        for (BcExternalUser user : userList) {
            HSSFRow row = sheet.createRow(rowNum);
            row.createCell(0).setCellValue(user.getId());
            row.createCell(1).setCellValue(user.getPhoneNumber());
            row.createCell(2).setCellValue(user.getSysName());
            row.createCell(3).setCellValue(user.getSysIfRegister());
            row.createCell(4).setCellValue(user.getSysRegisterDate());
            row.createCell(5).setCellValue(user.getSysIfRealName());
            row.createCell(6).setCellValue(user.getSysIfBindCard());
            row.createCell(7).setCellValue(user.getSysIfTransaction());
            row.createCell(8).setCellValue(user.getSysReferrer());
            row.createCell(9).setCellValue(user.getSysRebateExpirationDate());
            row.createCell(10).setCellValue(user.getMtime());
            row.createCell(11).setCellValue(user.getCtime());
//            String sexStr;
//            if (user.getSex() == 1) {
//                sexStr = "男";
//            } else if (user.getSex() == 2) {
//                sexStr = "女";
//            } else {
//                sexStr = "未知";
//            }
            rowNum++;
        }
        // 设置相应头信息，以附件形式下载并且指定文件名
        response.setHeader("Content-Disposition", "attachment;filename=" + new String("外部拓展客户名单列表.xls".getBytes(), "ISO-8859-1"));
    }

}