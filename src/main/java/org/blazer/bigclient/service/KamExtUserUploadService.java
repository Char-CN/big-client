package org.blazer.bigclient.service;

import org.blazer.bigclient.model.KamExcel;
import org.blazer.bigclient.model.KamExtUserUpload;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by yyccb on 2016-10-13.
 */
@Service
public class KamExtUserUploadService extends BaseService<KamExtUserUpload> {

    public void importExcelData(List<KamExtUserUpload> listBean, KamExcel kamExcel) {
    }
}
