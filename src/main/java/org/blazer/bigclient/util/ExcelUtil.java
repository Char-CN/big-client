package org.blazer.bigclient.util;

import org.blazer.bigclient.model.BcExcel;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

/**
 * Created by cc on 16-8-31.
 *
 * Excel上传导入处理
 */
public class ExcelUtil {

    public static BcExcel importExcel(MultipartFile file) {

        if (!file.isEmpty()) {

            //当文件超过设置的大小时，则不运行上传
//			if (file.getSize() > fileSize) {
//				backInfo(response, false, 2, "");
//				return;
//			}

            //获取文件原始名称
            String originalFilename = file.getOriginalFilename();
            //获取文件名后缀
            String fileSuffix = UploadUtils.getExtensionName(originalFilename);


            //判断该类型的文件是否在允许上传的文件类型内
//			if (!Arrays.asList("xls,xlsx").contains(fileSuffix)) {
//				backInfo(response, false, 3, "");
//				return;
//			}
//			if (!ServletFileUpload.isMultipartContent(request)) {
//				backInfo(response, false, -1, "");
//				return;
//			}

            //创建缓存文件目录
            String filePathTemp = "/src/upload/tmp";

            // 检查上传文件的目录
            File uploadDir = new File(filePathTemp);
            if (!uploadDir.isDirectory()) {
                if (!uploadDir.mkdir()) {
                    return null;
                }
            }

            // 是否有上传的权限
            if (!uploadDir.canWrite()) {
                return null;
            }

            //创建服务器文件名
            String tmpFileName = System.currentTimeMillis() + "." + fileSuffix;

            System.out.println("后缀名：" + fileSuffix);
            System.out.println("服务器文件名 = [" + tmpFileName + "]");
            try {
                //保存文件
                file.transferTo(uploadDir);

                //获取该文件的路径
                String filePath = filePathTemp + System.getProperty("file.separator") + tmpFileName;
                System.out.println("filePath = [" + filePath + "]");

                File tmpfile = new File(filePath);

                //拷贝文件到服务器缓存目录（在项目下），spring mvc用的方法
                UploadUtils.copy(file, filePathTemp, tmpFileName);

                //删除缓存文件
                tmpfile.delete();

            } catch (Exception e) {
                return null;
            }
        } else {
            return null;
        }
        return null;
    }


}
