package org.blazer.bigclient.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.blazer.bigclient.model.PrReturnPaymentReport;
import org.blazer.bigclient.util.IntegerUtil;
import org.blazer.bigclient.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.HashMap;
import java.util.List;

/**
 * Created by cuican on 2017-01-10.
 */
@Service
public class PrReturnPaymentReportService extends BaseService<PrReturnPaymentReport> {

    private static final Logger LOGGER = LoggerFactory.getLogger(PrReturnPaymentReportService.class);

    public PageInfo<PrReturnPaymentReport> findByPage(HashMap<String, String> params) {
        LOGGER.info("根据条件分页查询：定期兑付<PrReturnPaymentReport>...");
        Example example = new Example(PrReturnPaymentReport.class);
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
        List<PrReturnPaymentReport> list = selectByExample(example);
        return new PageInfo(list);
    }

    public List<PrReturnPaymentReport> findBySearch(String search) {
        LOGGER.info("根据条件查询：定期兑付<PrReturnPaymentReport>，导出到excel表...");
        Example example = new Example(PrReturnPaymentReport.class);
        Example.Criteria criteria = example.createCriteria();
        String search_text = StringUtil.getStrEmpty(search);
        if (StringUtils.isNotEmpty(search_text)) {
            criteria.andCondition("phone_number like '%" + search + "%'" + " or user_name like '%" + search + "%'");
        }
        return selectByExample(example);
    }

}
