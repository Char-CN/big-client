package org.blazer.bigclient.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.blazer.bigclient.model.PaCurrentPackageRegularSalesScaleAccounting;
import org.blazer.bigclient.model.PaCurrentSalesScaleAccounting;
import org.blazer.bigclient.util.DateUtil;
import org.blazer.bigclient.util.IntegerUtil;
import org.blazer.bigclient.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.HashMap;
import java.util.List;

/**
 * Created by cuican on 2016-11-21.
 */
@Service
public class PaCurrentPackageRegularSalesScaleAccountingService extends BaseService<PaCurrentPackageRegularSalesScaleAccounting> {

    private static final Logger LOGGER = LoggerFactory.getLogger(PaCurrentPackageRegularSalesScaleAccountingService.class);

    public PageInfo<PaCurrentPackageRegularSalesScaleAccounting> findByPage(HashMap<String, String> params) {
        LOGGER.info("根据条件分页查询：活包定销售规模核算<PaCurrentPackageRegularSalesScaleAccounting>列表...");
        Example example = new Example(PaCurrentSalesScaleAccounting.class);
        Example.Criteria criteria = example.createCriteria();
        String search = StringUtil.getStrEmpty(params.get("search"));
        if (StringUtils.isNotEmpty(search)) {
            criteria.andCondition("phone_number like '%" + search + "%'" + " or user_name like '%" + search + "%'");
        }
//        String advisorName = StringUtil.getStrEmpty(params.get("advisorName"));
//        if (StringUtils.isNotEmpty(advisorName)) {
//            //此处为实体类的属性，不是表字段
//            criteria.andEqualTo("investmentAdviser", advisorName);
//        }
        String dateStart = StringUtil.getStrEmpty(params.get("dateStart"));
        if(StringUtils.isEmpty(dateStart)){
            dateStart="1900-01-01";
        }
        criteria.andGreaterThanOrEqualTo("purchaseDate",dateStart);
        String dateEnd = StringUtil.getStrEmpty(params.get("dateEnd"));
        if(StringUtils.isEmpty(dateEnd)){
            dateEnd = DateUtil.thisDate();
        }
        criteria.andLessThanOrEqualTo("purchaseDate",dateEnd);
        PageHelper.startPage(IntegerUtil.getIntZero(params.get("currentPage")), IntegerUtil.getIntZero(params.get("pageSize")));
        List<PaCurrentPackageRegularSalesScaleAccounting> list = this.selectByExample(example);
        return new PageInfo(list);
    }

    public List<PaCurrentPackageRegularSalesScaleAccounting> findBySearch(String search) {
        LOGGER.info("根据条件查询：活包定销售规模核算<PaCurrentPackageRegularSalesScaleAccounting>，导出到excel表...");
        Example example = new Example(PaCurrentSalesScaleAccounting.class);
        Example.Criteria criteria = example.createCriteria();
        String search_text = StringUtil.getStrEmpty(search);
        if (StringUtils.isNotEmpty(search_text)) {
            criteria.andCondition("phone_number like '%" + search + "%'" + " or user_name like '%" + search + "%'");
        }
        return this.selectByExample(example);
    }

}
