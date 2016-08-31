package org.blazer.bigclient.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by cc on 16-8-31.
 *
 * Excel上传导入处理
 */
public class ExcelUtil {

	public static List<Map<String, String>> importExcel(String fileName, MultipartFile file) throws Exception {
        //准备返回值列表
        List<Map<String, String>> valueList = new ArrayList<Map<String, String>>();

        //创建缓存文件目录
        String filePathTemp = "/src/upload/tmp";
        //获取文件扩展名
        String extensionName = UploadUtils.getExtensionName(fileName);
        //创建缓存文件名
        String tmpFileName = System.currentTimeMillis() + "." + extensionName;

        //根据缓存文件目录创建file文件对象
        File filelist = new File(filePathTemp);

        if (!filelist.exists() && !filelist.isDirectory()) {
            filelist.mkdir();
        }
        String filePath = filePathTemp + System.getProperty("file.separator") + tmpFileName;
        File tmpfile = new File(filePath);
        //拷贝文件到服务器缓存目录（在项目下）
        UploadUtils.copy(file, filePathTemp, tmpFileName);//spring mvc用的方法

        System.out.println("后缀名："+extensionName);



        //删除缓存文件
        tmpfile.delete();



        return valueList;

    }


}
