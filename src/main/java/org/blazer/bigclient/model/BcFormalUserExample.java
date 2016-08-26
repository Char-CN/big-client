package org.blazer.bigclient.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BcFormalUserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BcFormalUserExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andExcelIdIsNull() {
            addCriterion("excel_id is null");
            return (Criteria) this;
        }

        public Criteria andExcelIdIsNotNull() {
            addCriterion("excel_id is not null");
            return (Criteria) this;
        }

        public Criteria andExcelIdEqualTo(Long value) {
            addCriterion("excel_id =", value, "excelId");
            return (Criteria) this;
        }

        public Criteria andExcelIdNotEqualTo(Long value) {
            addCriterion("excel_id <>", value, "excelId");
            return (Criteria) this;
        }

        public Criteria andExcelIdGreaterThan(Long value) {
            addCriterion("excel_id >", value, "excelId");
            return (Criteria) this;
        }

        public Criteria andExcelIdGreaterThanOrEqualTo(Long value) {
            addCriterion("excel_id >=", value, "excelId");
            return (Criteria) this;
        }

        public Criteria andExcelIdLessThan(Long value) {
            addCriterion("excel_id <", value, "excelId");
            return (Criteria) this;
        }

        public Criteria andExcelIdLessThanOrEqualTo(Long value) {
            addCriterion("excel_id <=", value, "excelId");
            return (Criteria) this;
        }

        public Criteria andExcelIdIn(List<Long> values) {
            addCriterion("excel_id in", values, "excelId");
            return (Criteria) this;
        }

        public Criteria andExcelIdNotIn(List<Long> values) {
            addCriterion("excel_id not in", values, "excelId");
            return (Criteria) this;
        }

        public Criteria andExcelIdBetween(Long value1, Long value2) {
            addCriterion("excel_id between", value1, value2, "excelId");
            return (Criteria) this;
        }

        public Criteria andExcelIdNotBetween(Long value1, Long value2) {
            addCriterion("excel_id not between", value1, value2, "excelId");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberIsNull() {
            addCriterion("phone_number is null");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberIsNotNull() {
            addCriterion("phone_number is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberEqualTo(Long value) {
            addCriterion("phone_number =", value, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberNotEqualTo(Long value) {
            addCriterion("phone_number <>", value, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberGreaterThan(Long value) {
            addCriterion("phone_number >", value, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberGreaterThanOrEqualTo(Long value) {
            addCriterion("phone_number >=", value, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberLessThan(Long value) {
            addCriterion("phone_number <", value, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberLessThanOrEqualTo(Long value) {
            addCriterion("phone_number <=", value, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberIn(List<Long> values) {
            addCriterion("phone_number in", values, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberNotIn(List<Long> values) {
            addCriterion("phone_number not in", values, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberBetween(Long value1, Long value2) {
            addCriterion("phone_number between", value1, value2, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberNotBetween(Long value1, Long value2) {
            addCriterion("phone_number not between", value1, value2, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andReportOrAllotIsNull() {
            addCriterion("report_or_allot is null");
            return (Criteria) this;
        }

        public Criteria andReportOrAllotIsNotNull() {
            addCriterion("report_or_allot is not null");
            return (Criteria) this;
        }

        public Criteria andReportOrAllotEqualTo(String value) {
            addCriterion("report_or_allot =", value, "reportOrAllot");
            return (Criteria) this;
        }

        public Criteria andReportOrAllotNotEqualTo(String value) {
            addCriterion("report_or_allot <>", value, "reportOrAllot");
            return (Criteria) this;
        }

        public Criteria andReportOrAllotGreaterThan(String value) {
            addCriterion("report_or_allot >", value, "reportOrAllot");
            return (Criteria) this;
        }

        public Criteria andReportOrAllotGreaterThanOrEqualTo(String value) {
            addCriterion("report_or_allot >=", value, "reportOrAllot");
            return (Criteria) this;
        }

        public Criteria andReportOrAllotLessThan(String value) {
            addCriterion("report_or_allot <", value, "reportOrAllot");
            return (Criteria) this;
        }

        public Criteria andReportOrAllotLessThanOrEqualTo(String value) {
            addCriterion("report_or_allot <=", value, "reportOrAllot");
            return (Criteria) this;
        }

        public Criteria andReportOrAllotLike(String value) {
            addCriterion("report_or_allot like", value, "reportOrAllot");
            return (Criteria) this;
        }

        public Criteria andReportOrAllotNotLike(String value) {
            addCriterion("report_or_allot not like", value, "reportOrAllot");
            return (Criteria) this;
        }

        public Criteria andReportOrAllotIn(List<String> values) {
            addCriterion("report_or_allot in", values, "reportOrAllot");
            return (Criteria) this;
        }

        public Criteria andReportOrAllotNotIn(List<String> values) {
            addCriterion("report_or_allot not in", values, "reportOrAllot");
            return (Criteria) this;
        }

        public Criteria andReportOrAllotBetween(String value1, String value2) {
            addCriterion("report_or_allot between", value1, value2, "reportOrAllot");
            return (Criteria) this;
        }

        public Criteria andReportOrAllotNotBetween(String value1, String value2) {
            addCriterion("report_or_allot not between", value1, value2, "reportOrAllot");
            return (Criteria) this;
        }

        public Criteria andReportOrAllotDateIsNull() {
            addCriterion("report_or_allot_date is null");
            return (Criteria) this;
        }

        public Criteria andReportOrAllotDateIsNotNull() {
            addCriterion("report_or_allot_date is not null");
            return (Criteria) this;
        }

        public Criteria andReportOrAllotDateEqualTo(String value) {
            addCriterion("report_or_allot_date =", value, "reportOrAllotDate");
            return (Criteria) this;
        }

        public Criteria andReportOrAllotDateNotEqualTo(String value) {
            addCriterion("report_or_allot_date <>", value, "reportOrAllotDate");
            return (Criteria) this;
        }

        public Criteria andReportOrAllotDateGreaterThan(String value) {
            addCriterion("report_or_allot_date >", value, "reportOrAllotDate");
            return (Criteria) this;
        }

        public Criteria andReportOrAllotDateGreaterThanOrEqualTo(String value) {
            addCriterion("report_or_allot_date >=", value, "reportOrAllotDate");
            return (Criteria) this;
        }

        public Criteria andReportOrAllotDateLessThan(String value) {
            addCriterion("report_or_allot_date <", value, "reportOrAllotDate");
            return (Criteria) this;
        }

        public Criteria andReportOrAllotDateLessThanOrEqualTo(String value) {
            addCriterion("report_or_allot_date <=", value, "reportOrAllotDate");
            return (Criteria) this;
        }

        public Criteria andReportOrAllotDateLike(String value) {
            addCriterion("report_or_allot_date like", value, "reportOrAllotDate");
            return (Criteria) this;
        }

        public Criteria andReportOrAllotDateNotLike(String value) {
            addCriterion("report_or_allot_date not like", value, "reportOrAllotDate");
            return (Criteria) this;
        }

        public Criteria andReportOrAllotDateIn(List<String> values) {
            addCriterion("report_or_allot_date in", values, "reportOrAllotDate");
            return (Criteria) this;
        }

        public Criteria andReportOrAllotDateNotIn(List<String> values) {
            addCriterion("report_or_allot_date not in", values, "reportOrAllotDate");
            return (Criteria) this;
        }

        public Criteria andReportOrAllotDateBetween(String value1, String value2) {
            addCriterion("report_or_allot_date between", value1, value2, "reportOrAllotDate");
            return (Criteria) this;
        }

        public Criteria andReportOrAllotDateNotBetween(String value1, String value2) {
            addCriterion("report_or_allot_date not between", value1, value2, "reportOrAllotDate");
            return (Criteria) this;
        }

        public Criteria andInvestmentAdviserIsNull() {
            addCriterion("investment_adviser is null");
            return (Criteria) this;
        }

        public Criteria andInvestmentAdviserIsNotNull() {
            addCriterion("investment_adviser is not null");
            return (Criteria) this;
        }

        public Criteria andInvestmentAdviserEqualTo(String value) {
            addCriterion("investment_adviser =", value, "investmentAdviser");
            return (Criteria) this;
        }

        public Criteria andInvestmentAdviserNotEqualTo(String value) {
            addCriterion("investment_adviser <>", value, "investmentAdviser");
            return (Criteria) this;
        }

        public Criteria andInvestmentAdviserGreaterThan(String value) {
            addCriterion("investment_adviser >", value, "investmentAdviser");
            return (Criteria) this;
        }

        public Criteria andInvestmentAdviserGreaterThanOrEqualTo(String value) {
            addCriterion("investment_adviser >=", value, "investmentAdviser");
            return (Criteria) this;
        }

        public Criteria andInvestmentAdviserLessThan(String value) {
            addCriterion("investment_adviser <", value, "investmentAdviser");
            return (Criteria) this;
        }

        public Criteria andInvestmentAdviserLessThanOrEqualTo(String value) {
            addCriterion("investment_adviser <=", value, "investmentAdviser");
            return (Criteria) this;
        }

        public Criteria andInvestmentAdviserLike(String value) {
            addCriterion("investment_adviser like", value, "investmentAdviser");
            return (Criteria) this;
        }

        public Criteria andInvestmentAdviserNotLike(String value) {
            addCriterion("investment_adviser not like", value, "investmentAdviser");
            return (Criteria) this;
        }

        public Criteria andInvestmentAdviserIn(List<String> values) {
            addCriterion("investment_adviser in", values, "investmentAdviser");
            return (Criteria) this;
        }

        public Criteria andInvestmentAdviserNotIn(List<String> values) {
            addCriterion("investment_adviser not in", values, "investmentAdviser");
            return (Criteria) this;
        }

        public Criteria andInvestmentAdviserBetween(String value1, String value2) {
            addCriterion("investment_adviser between", value1, value2, "investmentAdviser");
            return (Criteria) this;
        }

        public Criteria andInvestmentAdviserNotBetween(String value1, String value2) {
            addCriterion("investment_adviser not between", value1, value2, "investmentAdviser");
            return (Criteria) this;
        }

        public Criteria andUserIdentifyIsNull() {
            addCriterion("user_identify is null");
            return (Criteria) this;
        }

        public Criteria andUserIdentifyIsNotNull() {
            addCriterion("user_identify is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdentifyEqualTo(String value) {
            addCriterion("user_identify =", value, "userIdentify");
            return (Criteria) this;
        }

        public Criteria andUserIdentifyNotEqualTo(String value) {
            addCriterion("user_identify <>", value, "userIdentify");
            return (Criteria) this;
        }

        public Criteria andUserIdentifyGreaterThan(String value) {
            addCriterion("user_identify >", value, "userIdentify");
            return (Criteria) this;
        }

        public Criteria andUserIdentifyGreaterThanOrEqualTo(String value) {
            addCriterion("user_identify >=", value, "userIdentify");
            return (Criteria) this;
        }

        public Criteria andUserIdentifyLessThan(String value) {
            addCriterion("user_identify <", value, "userIdentify");
            return (Criteria) this;
        }

        public Criteria andUserIdentifyLessThanOrEqualTo(String value) {
            addCriterion("user_identify <=", value, "userIdentify");
            return (Criteria) this;
        }

        public Criteria andUserIdentifyLike(String value) {
            addCriterion("user_identify like", value, "userIdentify");
            return (Criteria) this;
        }

        public Criteria andUserIdentifyNotLike(String value) {
            addCriterion("user_identify not like", value, "userIdentify");
            return (Criteria) this;
        }

        public Criteria andUserIdentifyIn(List<String> values) {
            addCriterion("user_identify in", values, "userIdentify");
            return (Criteria) this;
        }

        public Criteria andUserIdentifyNotIn(List<String> values) {
            addCriterion("user_identify not in", values, "userIdentify");
            return (Criteria) this;
        }

        public Criteria andUserIdentifyBetween(String value1, String value2) {
            addCriterion("user_identify between", value1, value2, "userIdentify");
            return (Criteria) this;
        }

        public Criteria andUserIdentifyNotBetween(String value1, String value2) {
            addCriterion("user_identify not between", value1, value2, "userIdentify");
            return (Criteria) this;
        }

        public Criteria andMtimeIsNull() {
            addCriterion("mtime is null");
            return (Criteria) this;
        }

        public Criteria andMtimeIsNotNull() {
            addCriterion("mtime is not null");
            return (Criteria) this;
        }

        public Criteria andMtimeEqualTo(Date value) {
            addCriterion("mtime =", value, "mtime");
            return (Criteria) this;
        }

        public Criteria andMtimeNotEqualTo(Date value) {
            addCriterion("mtime <>", value, "mtime");
            return (Criteria) this;
        }

        public Criteria andMtimeGreaterThan(Date value) {
            addCriterion("mtime >", value, "mtime");
            return (Criteria) this;
        }

        public Criteria andMtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("mtime >=", value, "mtime");
            return (Criteria) this;
        }

        public Criteria andMtimeLessThan(Date value) {
            addCriterion("mtime <", value, "mtime");
            return (Criteria) this;
        }

        public Criteria andMtimeLessThanOrEqualTo(Date value) {
            addCriterion("mtime <=", value, "mtime");
            return (Criteria) this;
        }

        public Criteria andMtimeIn(List<Date> values) {
            addCriterion("mtime in", values, "mtime");
            return (Criteria) this;
        }

        public Criteria andMtimeNotIn(List<Date> values) {
            addCriterion("mtime not in", values, "mtime");
            return (Criteria) this;
        }

        public Criteria andMtimeBetween(Date value1, Date value2) {
            addCriterion("mtime between", value1, value2, "mtime");
            return (Criteria) this;
        }

        public Criteria andMtimeNotBetween(Date value1, Date value2) {
            addCriterion("mtime not between", value1, value2, "mtime");
            return (Criteria) this;
        }

        public Criteria andCtimeIsNull() {
            addCriterion("ctime is null");
            return (Criteria) this;
        }

        public Criteria andCtimeIsNotNull() {
            addCriterion("ctime is not null");
            return (Criteria) this;
        }

        public Criteria andCtimeEqualTo(Date value) {
            addCriterion("ctime =", value, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeNotEqualTo(Date value) {
            addCriterion("ctime <>", value, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeGreaterThan(Date value) {
            addCriterion("ctime >", value, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("ctime >=", value, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeLessThan(Date value) {
            addCriterion("ctime <", value, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeLessThanOrEqualTo(Date value) {
            addCriterion("ctime <=", value, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeIn(List<Date> values) {
            addCriterion("ctime in", values, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeNotIn(List<Date> values) {
            addCriterion("ctime not in", values, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeBetween(Date value1, Date value2) {
            addCriterion("ctime between", value1, value2, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeNotBetween(Date value1, Date value2) {
            addCriterion("ctime not between", value1, value2, "ctime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}