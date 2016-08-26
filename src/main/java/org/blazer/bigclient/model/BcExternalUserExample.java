package org.blazer.bigclient.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BcExternalUserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BcExternalUserExample() {
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

        public Criteria andSysNameIsNull() {
            addCriterion("sys_name is null");
            return (Criteria) this;
        }

        public Criteria andSysNameIsNotNull() {
            addCriterion("sys_name is not null");
            return (Criteria) this;
        }

        public Criteria andSysNameEqualTo(String value) {
            addCriterion("sys_name =", value, "sysName");
            return (Criteria) this;
        }

        public Criteria andSysNameNotEqualTo(String value) {
            addCriterion("sys_name <>", value, "sysName");
            return (Criteria) this;
        }

        public Criteria andSysNameGreaterThan(String value) {
            addCriterion("sys_name >", value, "sysName");
            return (Criteria) this;
        }

        public Criteria andSysNameGreaterThanOrEqualTo(String value) {
            addCriterion("sys_name >=", value, "sysName");
            return (Criteria) this;
        }

        public Criteria andSysNameLessThan(String value) {
            addCriterion("sys_name <", value, "sysName");
            return (Criteria) this;
        }

        public Criteria andSysNameLessThanOrEqualTo(String value) {
            addCriterion("sys_name <=", value, "sysName");
            return (Criteria) this;
        }

        public Criteria andSysNameLike(String value) {
            addCriterion("sys_name like", value, "sysName");
            return (Criteria) this;
        }

        public Criteria andSysNameNotLike(String value) {
            addCriterion("sys_name not like", value, "sysName");
            return (Criteria) this;
        }

        public Criteria andSysNameIn(List<String> values) {
            addCriterion("sys_name in", values, "sysName");
            return (Criteria) this;
        }

        public Criteria andSysNameNotIn(List<String> values) {
            addCriterion("sys_name not in", values, "sysName");
            return (Criteria) this;
        }

        public Criteria andSysNameBetween(String value1, String value2) {
            addCriterion("sys_name between", value1, value2, "sysName");
            return (Criteria) this;
        }

        public Criteria andSysNameNotBetween(String value1, String value2) {
            addCriterion("sys_name not between", value1, value2, "sysName");
            return (Criteria) this;
        }

        public Criteria andSysIfRegisterIsNull() {
            addCriterion("sys_if_register is null");
            return (Criteria) this;
        }

        public Criteria andSysIfRegisterIsNotNull() {
            addCriterion("sys_if_register is not null");
            return (Criteria) this;
        }

        public Criteria andSysIfRegisterEqualTo(String value) {
            addCriterion("sys_if_register =", value, "sysIfRegister");
            return (Criteria) this;
        }

        public Criteria andSysIfRegisterNotEqualTo(String value) {
            addCriterion("sys_if_register <>", value, "sysIfRegister");
            return (Criteria) this;
        }

        public Criteria andSysIfRegisterGreaterThan(String value) {
            addCriterion("sys_if_register >", value, "sysIfRegister");
            return (Criteria) this;
        }

        public Criteria andSysIfRegisterGreaterThanOrEqualTo(String value) {
            addCriterion("sys_if_register >=", value, "sysIfRegister");
            return (Criteria) this;
        }

        public Criteria andSysIfRegisterLessThan(String value) {
            addCriterion("sys_if_register <", value, "sysIfRegister");
            return (Criteria) this;
        }

        public Criteria andSysIfRegisterLessThanOrEqualTo(String value) {
            addCriterion("sys_if_register <=", value, "sysIfRegister");
            return (Criteria) this;
        }

        public Criteria andSysIfRegisterLike(String value) {
            addCriterion("sys_if_register like", value, "sysIfRegister");
            return (Criteria) this;
        }

        public Criteria andSysIfRegisterNotLike(String value) {
            addCriterion("sys_if_register not like", value, "sysIfRegister");
            return (Criteria) this;
        }

        public Criteria andSysIfRegisterIn(List<String> values) {
            addCriterion("sys_if_register in", values, "sysIfRegister");
            return (Criteria) this;
        }

        public Criteria andSysIfRegisterNotIn(List<String> values) {
            addCriterion("sys_if_register not in", values, "sysIfRegister");
            return (Criteria) this;
        }

        public Criteria andSysIfRegisterBetween(String value1, String value2) {
            addCriterion("sys_if_register between", value1, value2, "sysIfRegister");
            return (Criteria) this;
        }

        public Criteria andSysIfRegisterNotBetween(String value1, String value2) {
            addCriterion("sys_if_register not between", value1, value2, "sysIfRegister");
            return (Criteria) this;
        }

        public Criteria andSysRegisterDateIsNull() {
            addCriterion("sys_register_date is null");
            return (Criteria) this;
        }

        public Criteria andSysRegisterDateIsNotNull() {
            addCriterion("sys_register_date is not null");
            return (Criteria) this;
        }

        public Criteria andSysRegisterDateEqualTo(String value) {
            addCriterion("sys_register_date =", value, "sysRegisterDate");
            return (Criteria) this;
        }

        public Criteria andSysRegisterDateNotEqualTo(String value) {
            addCriterion("sys_register_date <>", value, "sysRegisterDate");
            return (Criteria) this;
        }

        public Criteria andSysRegisterDateGreaterThan(String value) {
            addCriterion("sys_register_date >", value, "sysRegisterDate");
            return (Criteria) this;
        }

        public Criteria andSysRegisterDateGreaterThanOrEqualTo(String value) {
            addCriterion("sys_register_date >=", value, "sysRegisterDate");
            return (Criteria) this;
        }

        public Criteria andSysRegisterDateLessThan(String value) {
            addCriterion("sys_register_date <", value, "sysRegisterDate");
            return (Criteria) this;
        }

        public Criteria andSysRegisterDateLessThanOrEqualTo(String value) {
            addCriterion("sys_register_date <=", value, "sysRegisterDate");
            return (Criteria) this;
        }

        public Criteria andSysRegisterDateLike(String value) {
            addCriterion("sys_register_date like", value, "sysRegisterDate");
            return (Criteria) this;
        }

        public Criteria andSysRegisterDateNotLike(String value) {
            addCriterion("sys_register_date not like", value, "sysRegisterDate");
            return (Criteria) this;
        }

        public Criteria andSysRegisterDateIn(List<String> values) {
            addCriterion("sys_register_date in", values, "sysRegisterDate");
            return (Criteria) this;
        }

        public Criteria andSysRegisterDateNotIn(List<String> values) {
            addCriterion("sys_register_date not in", values, "sysRegisterDate");
            return (Criteria) this;
        }

        public Criteria andSysRegisterDateBetween(String value1, String value2) {
            addCriterion("sys_register_date between", value1, value2, "sysRegisterDate");
            return (Criteria) this;
        }

        public Criteria andSysRegisterDateNotBetween(String value1, String value2) {
            addCriterion("sys_register_date not between", value1, value2, "sysRegisterDate");
            return (Criteria) this;
        }

        public Criteria andSysIfRealNameIsNull() {
            addCriterion("sys_if_real_name is null");
            return (Criteria) this;
        }

        public Criteria andSysIfRealNameIsNotNull() {
            addCriterion("sys_if_real_name is not null");
            return (Criteria) this;
        }

        public Criteria andSysIfRealNameEqualTo(String value) {
            addCriterion("sys_if_real_name =", value, "sysIfRealName");
            return (Criteria) this;
        }

        public Criteria andSysIfRealNameNotEqualTo(String value) {
            addCriterion("sys_if_real_name <>", value, "sysIfRealName");
            return (Criteria) this;
        }

        public Criteria andSysIfRealNameGreaterThan(String value) {
            addCriterion("sys_if_real_name >", value, "sysIfRealName");
            return (Criteria) this;
        }

        public Criteria andSysIfRealNameGreaterThanOrEqualTo(String value) {
            addCriterion("sys_if_real_name >=", value, "sysIfRealName");
            return (Criteria) this;
        }

        public Criteria andSysIfRealNameLessThan(String value) {
            addCriterion("sys_if_real_name <", value, "sysIfRealName");
            return (Criteria) this;
        }

        public Criteria andSysIfRealNameLessThanOrEqualTo(String value) {
            addCriterion("sys_if_real_name <=", value, "sysIfRealName");
            return (Criteria) this;
        }

        public Criteria andSysIfRealNameLike(String value) {
            addCriterion("sys_if_real_name like", value, "sysIfRealName");
            return (Criteria) this;
        }

        public Criteria andSysIfRealNameNotLike(String value) {
            addCriterion("sys_if_real_name not like", value, "sysIfRealName");
            return (Criteria) this;
        }

        public Criteria andSysIfRealNameIn(List<String> values) {
            addCriterion("sys_if_real_name in", values, "sysIfRealName");
            return (Criteria) this;
        }

        public Criteria andSysIfRealNameNotIn(List<String> values) {
            addCriterion("sys_if_real_name not in", values, "sysIfRealName");
            return (Criteria) this;
        }

        public Criteria andSysIfRealNameBetween(String value1, String value2) {
            addCriterion("sys_if_real_name between", value1, value2, "sysIfRealName");
            return (Criteria) this;
        }

        public Criteria andSysIfRealNameNotBetween(String value1, String value2) {
            addCriterion("sys_if_real_name not between", value1, value2, "sysIfRealName");
            return (Criteria) this;
        }

        public Criteria andSysIfBindCardIsNull() {
            addCriterion("sys_if_bind_card is null");
            return (Criteria) this;
        }

        public Criteria andSysIfBindCardIsNotNull() {
            addCriterion("sys_if_bind_card is not null");
            return (Criteria) this;
        }

        public Criteria andSysIfBindCardEqualTo(String value) {
            addCriterion("sys_if_bind_card =", value, "sysIfBindCard");
            return (Criteria) this;
        }

        public Criteria andSysIfBindCardNotEqualTo(String value) {
            addCriterion("sys_if_bind_card <>", value, "sysIfBindCard");
            return (Criteria) this;
        }

        public Criteria andSysIfBindCardGreaterThan(String value) {
            addCriterion("sys_if_bind_card >", value, "sysIfBindCard");
            return (Criteria) this;
        }

        public Criteria andSysIfBindCardGreaterThanOrEqualTo(String value) {
            addCriterion("sys_if_bind_card >=", value, "sysIfBindCard");
            return (Criteria) this;
        }

        public Criteria andSysIfBindCardLessThan(String value) {
            addCriterion("sys_if_bind_card <", value, "sysIfBindCard");
            return (Criteria) this;
        }

        public Criteria andSysIfBindCardLessThanOrEqualTo(String value) {
            addCriterion("sys_if_bind_card <=", value, "sysIfBindCard");
            return (Criteria) this;
        }

        public Criteria andSysIfBindCardLike(String value) {
            addCriterion("sys_if_bind_card like", value, "sysIfBindCard");
            return (Criteria) this;
        }

        public Criteria andSysIfBindCardNotLike(String value) {
            addCriterion("sys_if_bind_card not like", value, "sysIfBindCard");
            return (Criteria) this;
        }

        public Criteria andSysIfBindCardIn(List<String> values) {
            addCriterion("sys_if_bind_card in", values, "sysIfBindCard");
            return (Criteria) this;
        }

        public Criteria andSysIfBindCardNotIn(List<String> values) {
            addCriterion("sys_if_bind_card not in", values, "sysIfBindCard");
            return (Criteria) this;
        }

        public Criteria andSysIfBindCardBetween(String value1, String value2) {
            addCriterion("sys_if_bind_card between", value1, value2, "sysIfBindCard");
            return (Criteria) this;
        }

        public Criteria andSysIfBindCardNotBetween(String value1, String value2) {
            addCriterion("sys_if_bind_card not between", value1, value2, "sysIfBindCard");
            return (Criteria) this;
        }

        public Criteria andSysIfTransactionIsNull() {
            addCriterion("sys_if_transaction is null");
            return (Criteria) this;
        }

        public Criteria andSysIfTransactionIsNotNull() {
            addCriterion("sys_if_transaction is not null");
            return (Criteria) this;
        }

        public Criteria andSysIfTransactionEqualTo(String value) {
            addCriterion("sys_if_transaction =", value, "sysIfTransaction");
            return (Criteria) this;
        }

        public Criteria andSysIfTransactionNotEqualTo(String value) {
            addCriterion("sys_if_transaction <>", value, "sysIfTransaction");
            return (Criteria) this;
        }

        public Criteria andSysIfTransactionGreaterThan(String value) {
            addCriterion("sys_if_transaction >", value, "sysIfTransaction");
            return (Criteria) this;
        }

        public Criteria andSysIfTransactionGreaterThanOrEqualTo(String value) {
            addCriterion("sys_if_transaction >=", value, "sysIfTransaction");
            return (Criteria) this;
        }

        public Criteria andSysIfTransactionLessThan(String value) {
            addCriterion("sys_if_transaction <", value, "sysIfTransaction");
            return (Criteria) this;
        }

        public Criteria andSysIfTransactionLessThanOrEqualTo(String value) {
            addCriterion("sys_if_transaction <=", value, "sysIfTransaction");
            return (Criteria) this;
        }

        public Criteria andSysIfTransactionLike(String value) {
            addCriterion("sys_if_transaction like", value, "sysIfTransaction");
            return (Criteria) this;
        }

        public Criteria andSysIfTransactionNotLike(String value) {
            addCriterion("sys_if_transaction not like", value, "sysIfTransaction");
            return (Criteria) this;
        }

        public Criteria andSysIfTransactionIn(List<String> values) {
            addCriterion("sys_if_transaction in", values, "sysIfTransaction");
            return (Criteria) this;
        }

        public Criteria andSysIfTransactionNotIn(List<String> values) {
            addCriterion("sys_if_transaction not in", values, "sysIfTransaction");
            return (Criteria) this;
        }

        public Criteria andSysIfTransactionBetween(String value1, String value2) {
            addCriterion("sys_if_transaction between", value1, value2, "sysIfTransaction");
            return (Criteria) this;
        }

        public Criteria andSysIfTransactionNotBetween(String value1, String value2) {
            addCriterion("sys_if_transaction not between", value1, value2, "sysIfTransaction");
            return (Criteria) this;
        }

        public Criteria andSysReferrerIsNull() {
            addCriterion("sys_referrer is null");
            return (Criteria) this;
        }

        public Criteria andSysReferrerIsNotNull() {
            addCriterion("sys_referrer is not null");
            return (Criteria) this;
        }

        public Criteria andSysReferrerEqualTo(String value) {
            addCriterion("sys_referrer =", value, "sysReferrer");
            return (Criteria) this;
        }

        public Criteria andSysReferrerNotEqualTo(String value) {
            addCriterion("sys_referrer <>", value, "sysReferrer");
            return (Criteria) this;
        }

        public Criteria andSysReferrerGreaterThan(String value) {
            addCriterion("sys_referrer >", value, "sysReferrer");
            return (Criteria) this;
        }

        public Criteria andSysReferrerGreaterThanOrEqualTo(String value) {
            addCriterion("sys_referrer >=", value, "sysReferrer");
            return (Criteria) this;
        }

        public Criteria andSysReferrerLessThan(String value) {
            addCriterion("sys_referrer <", value, "sysReferrer");
            return (Criteria) this;
        }

        public Criteria andSysReferrerLessThanOrEqualTo(String value) {
            addCriterion("sys_referrer <=", value, "sysReferrer");
            return (Criteria) this;
        }

        public Criteria andSysReferrerLike(String value) {
            addCriterion("sys_referrer like", value, "sysReferrer");
            return (Criteria) this;
        }

        public Criteria andSysReferrerNotLike(String value) {
            addCriterion("sys_referrer not like", value, "sysReferrer");
            return (Criteria) this;
        }

        public Criteria andSysReferrerIn(List<String> values) {
            addCriterion("sys_referrer in", values, "sysReferrer");
            return (Criteria) this;
        }

        public Criteria andSysReferrerNotIn(List<String> values) {
            addCriterion("sys_referrer not in", values, "sysReferrer");
            return (Criteria) this;
        }

        public Criteria andSysReferrerBetween(String value1, String value2) {
            addCriterion("sys_referrer between", value1, value2, "sysReferrer");
            return (Criteria) this;
        }

        public Criteria andSysReferrerNotBetween(String value1, String value2) {
            addCriterion("sys_referrer not between", value1, value2, "sysReferrer");
            return (Criteria) this;
        }

        public Criteria andSysRebateExpirationDateIsNull() {
            addCriterion("sys_rebate_expiration_date is null");
            return (Criteria) this;
        }

        public Criteria andSysRebateExpirationDateIsNotNull() {
            addCriterion("sys_rebate_expiration_date is not null");
            return (Criteria) this;
        }

        public Criteria andSysRebateExpirationDateEqualTo(String value) {
            addCriterion("sys_rebate_expiration_date =", value, "sysRebateExpirationDate");
            return (Criteria) this;
        }

        public Criteria andSysRebateExpirationDateNotEqualTo(String value) {
            addCriterion("sys_rebate_expiration_date <>", value, "sysRebateExpirationDate");
            return (Criteria) this;
        }

        public Criteria andSysRebateExpirationDateGreaterThan(String value) {
            addCriterion("sys_rebate_expiration_date >", value, "sysRebateExpirationDate");
            return (Criteria) this;
        }

        public Criteria andSysRebateExpirationDateGreaterThanOrEqualTo(String value) {
            addCriterion("sys_rebate_expiration_date >=", value, "sysRebateExpirationDate");
            return (Criteria) this;
        }

        public Criteria andSysRebateExpirationDateLessThan(String value) {
            addCriterion("sys_rebate_expiration_date <", value, "sysRebateExpirationDate");
            return (Criteria) this;
        }

        public Criteria andSysRebateExpirationDateLessThanOrEqualTo(String value) {
            addCriterion("sys_rebate_expiration_date <=", value, "sysRebateExpirationDate");
            return (Criteria) this;
        }

        public Criteria andSysRebateExpirationDateLike(String value) {
            addCriterion("sys_rebate_expiration_date like", value, "sysRebateExpirationDate");
            return (Criteria) this;
        }

        public Criteria andSysRebateExpirationDateNotLike(String value) {
            addCriterion("sys_rebate_expiration_date not like", value, "sysRebateExpirationDate");
            return (Criteria) this;
        }

        public Criteria andSysRebateExpirationDateIn(List<String> values) {
            addCriterion("sys_rebate_expiration_date in", values, "sysRebateExpirationDate");
            return (Criteria) this;
        }

        public Criteria andSysRebateExpirationDateNotIn(List<String> values) {
            addCriterion("sys_rebate_expiration_date not in", values, "sysRebateExpirationDate");
            return (Criteria) this;
        }

        public Criteria andSysRebateExpirationDateBetween(String value1, String value2) {
            addCriterion("sys_rebate_expiration_date between", value1, value2, "sysRebateExpirationDate");
            return (Criteria) this;
        }

        public Criteria andSysRebateExpirationDateNotBetween(String value1, String value2) {
            addCriterion("sys_rebate_expiration_date not between", value1, value2, "sysRebateExpirationDate");
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