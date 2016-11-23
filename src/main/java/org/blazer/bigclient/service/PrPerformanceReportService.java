package org.blazer.bigclient.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.blazer.bigclient.model.PrPerformanceReport;
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
public class PrPerformanceReportService extends BaseService<PrPerformanceReport> {

    private static final Logger LOGGER = LoggerFactory.getLogger(PrPerformanceReportService.class);

    public PageInfo<PrPerformanceReport> findByPage(HashMap<String, String> params) {
        LOGGER.info("根据条件分页查询：业绩报表<PrPerformanceReport>...");
        Example example = new Example(PrPerformanceReport.class);
        Example.Criteria criteria = example.createCriteria();
        String search = StringUtil.getStrEmpty(params.get("search"));
        String advisorName = StringUtil.getStrEmpty(params.get("advisorName"));
        if (StringUtils.isNotEmpty(search)) {
            criteria.andLike("investmentAdvisor","%" + search + "%");
        }
        if (StringUtils.isNotEmpty(advisorName)) {
            //此处为实体类的属性，不是表字段
            criteria.andEqualTo("investmentAdviser", advisorName);
        }
        PageHelper.startPage(IntegerUtil.getIntZero(params.get("currentPage")), IntegerUtil.getIntZero(params.get("pageSize")));
        List<PrPerformanceReport> list = selectByExample(example);
        return new PageInfo(list);
    }

    public List<PrPerformanceReport> findBySearch(String search) {
        LOGGER.info("根据条件查询：业绩报表<PrPerformanceReport>，导出到excel表...");
        Example example = new Example(PrPerformanceReport.class);
        Example.Criteria criteria = example.createCriteria();
        String search_text = StringUtil.getStrEmpty(search);
        if (StringUtils.isNotEmpty(search_text)) {
            criteria.andLike("investmentAdvisor","%" + search + "%");
        }
        return selectByExample(example);
    }

}
