package org.blazer.bigclient.excel;

import org.apache.commons.lang3.ArrayUtils;
import org.blazer.bigclient.body.AdvisorInfoBean;
import org.blazer.bigclient.body.FormalUserBean;
import org.blazer.bigclient.model.*;
import org.blazer.bigclient.util.ReflectUtil;
import org.springframework.util.TypeUtils;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.List;

/**
 * 快速构建Excel配置,列多时敏捷开发使用
 *
 * @author cc
 */
public class ExcelXmlBuild {

    //是否生成其他标签
    private static boolean otherTag = false;

    //快速构建一个XML配置,看不懂直接运行
    public static void main(String[] args) {

        /*String xml = builderXml("clExtUserBak", "外部拓展客户（导入）", true, ClExtUserBak.class, 5000);
        System.out.println(xml);
        String xml1 = builderXml("clExtUser", "外部拓展客户", true, ClExtUser.class, 5000);
        System.out.println(xml1);
        String xml2 = builderXml("clAllotUser", "平台待分配客户", true, ClAllotUser.class, 5000);
        System.out.println(xml2);
        String xml3 = builderXml("clFormalUser", "正式客户名单（导入）", true, ClFormalUser.class, 5000);
        System.out.println(xml3);
        String xml = builderXml("srAssetsBalance", "资产余额", true, SrAssetsBalance.class, 5000);
        System.out.println(xml);
        String xml1 = builderXml("srRegularSalesDetails", "定期销售明细", true, SrRegularSalesDetails.class, 5000);
        System.out.println(xml1);
        String xml2 = builderXml("srCurrentSalesDetails", "活期期销售明细", true, SrCurrentSalesDetails.class, 5000);
        System.out.println(xml2);
        String xml3 = builderXml("paRegularSalesScaleAccounting", "定期销售规模核算", true, PaRegularSalesScaleAccounting.class, 5000);
        System.out.println(xml3);
        String xml4 = builderXml("paCurrentSalesScaleAccounting", "活期销售规模核算", true, PaCurrentSalesScaleAccounting.class, 5000);
        System.out.println(xml4);
        String xml5 = builderXml("paCustomersAccounting", "获客数核算", true, PaCustomersAccounting.class, 5000);
        System.out.println(xml5);
        String xml6 = builderXml("formalUserBean", "正式客户名单", true, FormalUserBean.class, 5000);
        System.out.println(xml6);
        String xml7 = builderXml("advisorInfoBean", "投资顾问信息", true, AdvisorInfoBean.class, 5000);
        System.out.println(xml7);*/
        String xml1 = builderXml("prConstituteCustomer", "获客构成", true, PrConstituteCustomer.class, 5000);
        System.out.println(xml1);
        String xml2 = builderXml("prCustomerConversionRate", "客户转换率", true, PrCustomerConversionRate.class, 5000);
        System.out.println(xml2);
        String xml3 = builderXml("prPerformanceReport", "业绩报表", true, PrPerformanceReport.class, 5000);
        System.out.println(xml3);
        String xml4 = builderXml("prRegularPayment", "定期兑付报表", true, PrRegularPayment.class, 5000);
        System.out.println(xml4);

    }

    /**
     * 创建Excel 标签
     *
     * @param id                 标签ID
     * @param sheetname          导出时sheet名称
     * @param enableStyle        是否开启样式支持
     * @param clazz              生成的类型
     * @param defaultColumnWidth 默认宽度
     * @param clazzs             复杂类型数组(比如需要生成student.book.name),
     *                           那么如果传入的clazz是Student,
     *                           那么这里应该传递Book.class
     * @return
     */
    public static String builderXml(String id, String sheetname, boolean enableStyle, Class<?> clazz, Integer defaultColumnWidth, Class<?>... clazzs) {
        StringBuilder res = new StringBuilder();
        res.append("<excel id=\"" + id + "\" class=\"" + clazz.getName() + "\" sheetname=\"" + sheetname + "\" defaultColumnWidth=\"" + defaultColumnWidth + "\" enableStyle=\"" + enableStyle + "\">");
        List<Field> fields = ReflectUtil.getFields(clazz);
        for (Field f : fields) {
            String str = buildFields(f, f.getName(), clazzs);
            res.append(str);
        }
        res.append("\n</excel>");
        return res.toString();
    }

    /**
     * 生成field标签
     *
     * @param field  字段
     * @param name   字段名称
     * @param clazzs 复杂对象类型
     * @return
     */
    private static String buildFields(Field field, String name, Class<?>... clazzs) {
        StringBuilder res = new StringBuilder();
        boolean build = true;
        if (ArrayUtils.isNotEmpty(clazzs)) {
            for (Class<?> clz : clazzs) {
                if (field.getType() == clz) {
                    build = false;
                    List<Field> fs = ReflectUtil.getFields(clz);
                    for (Field f : fs) {
                        res.append(buildFields(f, name + "." + f.getName(), clazzs));
                    }
                }
            }
        }
        if (build) {
            buildStringField(res, field, name);
        }
        return res.toString();
    }

    //创建field标签字符
    private static void buildStringField(StringBuilder res, Field field, String name) {
        //不是复杂对象
        res.append("\n").append("\t<field").append(" name=").append("\"" + name + "\"").append(" title=").append("\"" + name + "\"");
        if (TypeUtils.isAssignable(Date.class, field.getType())) {
            String pattern = "yyyy-MM-dd HH:mm:ss";
            res.append(" pattern=").append("\"" + pattern + "\"");
        }
        //是否构建其他标签信息
        if (otherTag) {
            //是否允许为空
            res.append(" isNull=").append("\"" + true + "\"");
            //cell样式是否与标题一致
            res.append(" uniformStyle=").append("\"" + true + "\"");
            //cell宽度
            res.append(" columnWidth=").append("\"5000\"");
            //导入时正则
            res.append(" regex=").append("\"\"");
            //导入时正则
            res.append(" regexErrMsg=").append("\"" + name + "不合法\"");
            //format
            //resolveFieldValueConverterName
            //columnWidth
            //align
            //titleBgColor
            //titleFountColor
            //uniformStyle

        }
        res.append("/>");
    }

}
