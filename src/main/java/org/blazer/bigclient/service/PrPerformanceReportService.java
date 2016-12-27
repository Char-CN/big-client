package org.blazer.bigclient.service;

import com.github.abel533.echarts.Option;
import com.github.abel533.echarts.axis.CategoryAxis;
import com.github.abel533.echarts.axis.ValueAxis;
import com.github.abel533.echarts.code.Trigger;
import com.github.abel533.echarts.data.PieData;
import com.github.abel533.echarts.series.Bar;
import com.github.abel533.echarts.series.Pie;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.blazer.bigclient.model.PrPerformanceReport;
import org.blazer.bigclient.util.DateUtil;
import org.blazer.bigclient.util.IntegerUtil;
import org.blazer.bigclient.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.*;

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
        if (StringUtils.isEmpty(search)) {
            search = DateUtil.date2Str(new Date(), DateUtil.DATE_FORMAT_SHORT);
            criteria.andEqualTo("version", search);
        } else {
            criteria.andEqualTo("version",search);
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
            criteria.andEqualTo("version", search);
        }
        return selectByExample(example);
    }

    //echarts
    public Option selectRemoveCauses() throws Exception {
        /*//查询前20
        PageHelper.startPage(1, 20, false);
        //数据库查询获取统计数据
        *//*List<Map<String, Object>> list = kc22Mapper.selectRemoveCauses();
        //为了数据从大到小排列，这里需要倒叙
        Collections.sort(list, new Comparator<Map<String, Object>>() {
            @Override
            public int compare(Map<String, Object> o1, Map<String, Object> o2) {
                return -1;
            }
        });*//*
        //创建Option
        Option option = new Option();
        option.title("剔除药品").tooltip(Trigger.axis).legend("金额（元）");
        //横轴为值轴
        option.xAxis(new ValueAxis().boundaryGap(0d, 0.01));
        //创建类目轴
        CategoryAxis category = new CategoryAxis();
        //柱状数据
        Bar bar = new Bar("金额（元）");
        //饼图数据
        Pie pie = new Pie("金额（元）");
        //循环数据
        for (Map<String, Object> objectMap : list) {
            //设置类目
            category.data(objectMap.get("NAME"));
            //类目对应的柱状图
            bar.data(objectMap.get("TOTAL"));
            //饼图数据
            pie.data(new PieData(objectMap.get("NAME").toString(), objectMap.get("TOTAL")));
        }
        //设置类目轴
        option.yAxis(category);
        //饼图的圆心和半径
        pie.center(900,380).radius(100);
        //设置数据
        option.series(bar, pie);
        //由于药品名字过长，图表距离左侧距离设置180，关于grid可以看ECharts的官方文档
        option.grid().x(180);
        //返回Option
        return option;*/
        return null;
    }

}
