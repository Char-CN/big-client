package org.blazer.bigclient.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.blazer.bigclient.mapper.KamExcelMapper;
import org.blazer.bigclient.model.KamExcel;
import org.blazer.bigclient.model.KamExtUserUpload;
import org.blazer.bigclient.util.IntegerUtil;
import org.blazer.bigclient.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.HashMap;
import java.util.List;

/**
 * Created by yyccb on 2016-10-13.
 */
@Service
public class KamExtUserUploadService extends BaseService<KamExtUserUpload> {

    private static final Logger LOGGER = LoggerFactory.getLogger(KamExtUserUploadService.class);

    @Autowired
    private KamExcelService kamExcelService;

    /**
     * 条件分页查询列表
     *
     * @param params
     * @return
     */
    public PageInfo<KamExtUserUpload> findByPage(HashMap<String, String> params) {
        LOGGER.info("根据条件查询列表。。。");
        Example example = new Example(KamExtUserUpload.class);
        Example.Criteria criteria = example.createCriteria();
        String search = StringUtil.getStrEmpty(params.get("search"));
        String advisorName = StringUtil.getStrEmpty(params.get("advisorName"));
        if (StringUtils.isNotEmpty(search)) {
            criteria.andCondition("phone_number like '%" + search + "%'" + " or user_name like '%" + search + "%'");
        }
        if (StringUtils.isNotEmpty(advisorName)) {
            //此处为实体类的属性，不是表字段
            criteria.andEqualTo("investmentAdviser", advisorName);
        }
        PageHelper.startPage(IntegerUtil.getIntZero(params.get("currentPage")), IntegerUtil.getIntZero(params.get("pageSize")));
        List<KamExtUserUpload> list = selectByExample(example);
        return new PageInfo<KamExtUserUpload>(list);
    }

    /**
     * 根据条件查询 用于前台页面的Excel导出
     *
     * @param search
     * @return
     */
    public List<KamExtUserUpload> findBySearch(String search) {
        Example example = new Example(KamExtUserUpload.class);
        Example.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotEmpty(search)) {
            criteria.andCondition("phone_number like '%" + search + "%'" + " or user_name like '%" + search + "%'");
        }
        List<KamExtUserUpload> list = selectByExample(example);
        return list;
    }

    /**
     * excel导入名单
     *
     * @param listBean
     * @param kamExcel
     */
    public void importExcelData(List<KamExtUserUpload> listBean, KamExcel kamExcel) {
        if (listBean != null && listBean.size() > 0 && kamExcel != null) {
            kamExcelService.mapper.insert(kamExcel);
            KamExcel excel = kamExcelService.mapper.selectOne(kamExcel);

            for (int i = 0; i < listBean.size(); i++) {
                KamExtUserUpload kamExtUserUpload = listBean.get(i);
                kamExtUserUpload.setExcelId(excel.getId());
                this.mapper.insert(kamExtUserUpload);
            }
        }
    }
}
