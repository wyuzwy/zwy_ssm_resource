package com.zhangwenyu.resource.bean;

import java.util.ArrayList;
import java.util.List;

public class RegisterExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RegisterExample() {
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

        public Criteria andRegisterIdIsNull() {
            addCriterion("register_id is null");
            return (Criteria) this;
        }

        public Criteria andRegisterIdIsNotNull() {
            addCriterion("register_id is not null");
            return (Criteria) this;
        }

        public Criteria andRegisterIdEqualTo(String value) {
            addCriterion("register_id =", value, "registerId");
            return (Criteria) this;
        }

        public Criteria andRegisterIdNotEqualTo(String value) {
            addCriterion("register_id <>", value, "registerId");
            return (Criteria) this;
        }

        public Criteria andRegisterIdGreaterThan(String value) {
            addCriterion("register_id >", value, "registerId");
            return (Criteria) this;
        }

        public Criteria andRegisterIdGreaterThanOrEqualTo(String value) {
            addCriterion("register_id >=", value, "registerId");
            return (Criteria) this;
        }

        public Criteria andRegisterIdLessThan(String value) {
            addCriterion("register_id <", value, "registerId");
            return (Criteria) this;
        }

        public Criteria andRegisterIdLessThanOrEqualTo(String value) {
            addCriterion("register_id <=", value, "registerId");
            return (Criteria) this;
        }

        public Criteria andRegisterIdLike(String value) {
            addCriterion("register_id like", value, "registerId");
            return (Criteria) this;
        }

        public Criteria andRegisterIdNotLike(String value) {
            addCriterion("register_id not like", value, "registerId");
            return (Criteria) this;
        }

        public Criteria andRegisterIdIn(List<String> values) {
            addCriterion("register_id in", values, "registerId");
            return (Criteria) this;
        }

        public Criteria andRegisterIdNotIn(List<String> values) {
            addCriterion("register_id not in", values, "registerId");
            return (Criteria) this;
        }

        public Criteria andRegisterIdBetween(String value1, String value2) {
            addCriterion("register_id between", value1, value2, "registerId");
            return (Criteria) this;
        }

        public Criteria andRegisterIdNotBetween(String value1, String value2) {
            addCriterion("register_id not between", value1, value2, "registerId");
            return (Criteria) this;
        }

        public Criteria andRegisterPasswordIsNull() {
            addCriterion("register_password is null");
            return (Criteria) this;
        }

        public Criteria andRegisterPasswordIsNotNull() {
            addCriterion("register_password is not null");
            return (Criteria) this;
        }

        public Criteria andRegisterPasswordEqualTo(String value) {
            addCriterion("register_password =", value, "registerPassword");
            return (Criteria) this;
        }

        public Criteria andRegisterPasswordNotEqualTo(String value) {
            addCriterion("register_password <>", value, "registerPassword");
            return (Criteria) this;
        }

        public Criteria andRegisterPasswordGreaterThan(String value) {
            addCriterion("register_password >", value, "registerPassword");
            return (Criteria) this;
        }

        public Criteria andRegisterPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("register_password >=", value, "registerPassword");
            return (Criteria) this;
        }

        public Criteria andRegisterPasswordLessThan(String value) {
            addCriterion("register_password <", value, "registerPassword");
            return (Criteria) this;
        }

        public Criteria andRegisterPasswordLessThanOrEqualTo(String value) {
            addCriterion("register_password <=", value, "registerPassword");
            return (Criteria) this;
        }

        public Criteria andRegisterPasswordLike(String value) {
            addCriterion("register_password like", value, "registerPassword");
            return (Criteria) this;
        }

        public Criteria andRegisterPasswordNotLike(String value) {
            addCriterion("register_password not like", value, "registerPassword");
            return (Criteria) this;
        }

        public Criteria andRegisterPasswordIn(List<String> values) {
            addCriterion("register_password in", values, "registerPassword");
            return (Criteria) this;
        }

        public Criteria andRegisterPasswordNotIn(List<String> values) {
            addCriterion("register_password not in", values, "registerPassword");
            return (Criteria) this;
        }

        public Criteria andRegisterPasswordBetween(String value1, String value2) {
            addCriterion("register_password between", value1, value2, "registerPassword");
            return (Criteria) this;
        }

        public Criteria andRegisterPasswordNotBetween(String value1, String value2) {
            addCriterion("register_password not between", value1, value2, "registerPassword");
            return (Criteria) this;
        }

        public Criteria andRegisterNameIsNull() {
            addCriterion("register_name is null");
            return (Criteria) this;
        }

        public Criteria andRegisterNameIsNotNull() {
            addCriterion("register_name is not null");
            return (Criteria) this;
        }

        public Criteria andRegisterNameEqualTo(String value) {
            addCriterion("register_name =", value, "registerName");
            return (Criteria) this;
        }

        public Criteria andRegisterNameNotEqualTo(String value) {
            addCriterion("register_name <>", value, "registerName");
            return (Criteria) this;
        }

        public Criteria andRegisterNameGreaterThan(String value) {
            addCriterion("register_name >", value, "registerName");
            return (Criteria) this;
        }

        public Criteria andRegisterNameGreaterThanOrEqualTo(String value) {
            addCriterion("register_name >=", value, "registerName");
            return (Criteria) this;
        }

        public Criteria andRegisterNameLessThan(String value) {
            addCriterion("register_name <", value, "registerName");
            return (Criteria) this;
        }

        public Criteria andRegisterNameLessThanOrEqualTo(String value) {
            addCriterion("register_name <=", value, "registerName");
            return (Criteria) this;
        }

        public Criteria andRegisterNameLike(String value) {
            addCriterion("register_name like", value, "registerName");
            return (Criteria) this;
        }

        public Criteria andRegisterNameNotLike(String value) {
            addCriterion("register_name not like", value, "registerName");
            return (Criteria) this;
        }

        public Criteria andRegisterNameIn(List<String> values) {
            addCriterion("register_name in", values, "registerName");
            return (Criteria) this;
        }

        public Criteria andRegisterNameNotIn(List<String> values) {
            addCriterion("register_name not in", values, "registerName");
            return (Criteria) this;
        }

        public Criteria andRegisterNameBetween(String value1, String value2) {
            addCriterion("register_name between", value1, value2, "registerName");
            return (Criteria) this;
        }

        public Criteria andRegisterNameNotBetween(String value1, String value2) {
            addCriterion("register_name not between", value1, value2, "registerName");
            return (Criteria) this;
        }

        public Criteria andRegisterClassIsNull() {
            addCriterion("register_class is null");
            return (Criteria) this;
        }

        public Criteria andRegisterClassIsNotNull() {
            addCriterion("register_class is not null");
            return (Criteria) this;
        }

        public Criteria andRegisterClassEqualTo(String value) {
            addCriterion("register_class =", value, "registerClass");
            return (Criteria) this;
        }

        public Criteria andRegisterClassNotEqualTo(String value) {
            addCriterion("register_class <>", value, "registerClass");
            return (Criteria) this;
        }

        public Criteria andRegisterClassGreaterThan(String value) {
            addCriterion("register_class >", value, "registerClass");
            return (Criteria) this;
        }

        public Criteria andRegisterClassGreaterThanOrEqualTo(String value) {
            addCriterion("register_class >=", value, "registerClass");
            return (Criteria) this;
        }

        public Criteria andRegisterClassLessThan(String value) {
            addCriterion("register_class <", value, "registerClass");
            return (Criteria) this;
        }

        public Criteria andRegisterClassLessThanOrEqualTo(String value) {
            addCriterion("register_class <=", value, "registerClass");
            return (Criteria) this;
        }

        public Criteria andRegisterClassLike(String value) {
            addCriterion("register_class like", value, "registerClass");
            return (Criteria) this;
        }

        public Criteria andRegisterClassNotLike(String value) {
            addCriterion("register_class not like", value, "registerClass");
            return (Criteria) this;
        }

        public Criteria andRegisterClassIn(List<String> values) {
            addCriterion("register_class in", values, "registerClass");
            return (Criteria) this;
        }

        public Criteria andRegisterClassNotIn(List<String> values) {
            addCriterion("register_class not in", values, "registerClass");
            return (Criteria) this;
        }

        public Criteria andRegisterClassBetween(String value1, String value2) {
            addCriterion("register_class between", value1, value2, "registerClass");
            return (Criteria) this;
        }

        public Criteria andRegisterClassNotBetween(String value1, String value2) {
            addCriterion("register_class not between", value1, value2, "registerClass");
            return (Criteria) this;
        }

        public Criteria andRegisterLevelIsNull() {
            addCriterion("register_level is null");
            return (Criteria) this;
        }

        public Criteria andRegisterLevelIsNotNull() {
            addCriterion("register_level is not null");
            return (Criteria) this;
        }

        public Criteria andRegisterLevelEqualTo(String value) {
            addCriterion("register_level =", value, "registerLevel");
            return (Criteria) this;
        }

        public Criteria andRegisterLevelNotEqualTo(String value) {
            addCriterion("register_level <>", value, "registerLevel");
            return (Criteria) this;
        }

        public Criteria andRegisterLevelGreaterThan(String value) {
            addCriterion("register_level >", value, "registerLevel");
            return (Criteria) this;
        }

        public Criteria andRegisterLevelGreaterThanOrEqualTo(String value) {
            addCriterion("register_level >=", value, "registerLevel");
            return (Criteria) this;
        }

        public Criteria andRegisterLevelLessThan(String value) {
            addCriterion("register_level <", value, "registerLevel");
            return (Criteria) this;
        }

        public Criteria andRegisterLevelLessThanOrEqualTo(String value) {
            addCriterion("register_level <=", value, "registerLevel");
            return (Criteria) this;
        }

        public Criteria andRegisterLevelLike(String value) {
            addCriterion("register_level like", value, "registerLevel");
            return (Criteria) this;
        }

        public Criteria andRegisterLevelNotLike(String value) {
            addCriterion("register_level not like", value, "registerLevel");
            return (Criteria) this;
        }

        public Criteria andRegisterLevelIn(List<String> values) {
            addCriterion("register_level in", values, "registerLevel");
            return (Criteria) this;
        }

        public Criteria andRegisterLevelNotIn(List<String> values) {
            addCriterion("register_level not in", values, "registerLevel");
            return (Criteria) this;
        }

        public Criteria andRegisterLevelBetween(String value1, String value2) {
            addCriterion("register_level between", value1, value2, "registerLevel");
            return (Criteria) this;
        }

        public Criteria andRegisterLevelNotBetween(String value1, String value2) {
            addCriterion("register_level not between", value1, value2, "registerLevel");
            return (Criteria) this;
        }

        public Criteria andRegisterCheckIsNull() {
            addCriterion("register_check is null");
            return (Criteria) this;
        }

        public Criteria andRegisterCheckIsNotNull() {
            addCriterion("register_check is not null");
            return (Criteria) this;
        }

        public Criteria andRegisterCheckEqualTo(Integer value) {
            addCriterion("register_check =", value, "registerCheck");
            return (Criteria) this;
        }

        public Criteria andRegisterCheckNotEqualTo(Integer value) {
            addCriterion("register_check <>", value, "registerCheck");
            return (Criteria) this;
        }

        public Criteria andRegisterCheckGreaterThan(Integer value) {
            addCriterion("register_check >", value, "registerCheck");
            return (Criteria) this;
        }

        public Criteria andRegisterCheckGreaterThanOrEqualTo(Integer value) {
            addCriterion("register_check >=", value, "registerCheck");
            return (Criteria) this;
        }

        public Criteria andRegisterCheckLessThan(Integer value) {
            addCriterion("register_check <", value, "registerCheck");
            return (Criteria) this;
        }

        public Criteria andRegisterCheckLessThanOrEqualTo(Integer value) {
            addCriterion("register_check <=", value, "registerCheck");
            return (Criteria) this;
        }

        public Criteria andRegisterCheckIn(List<Integer> values) {
            addCriterion("register_check in", values, "registerCheck");
            return (Criteria) this;
        }

        public Criteria andRegisterCheckNotIn(List<Integer> values) {
            addCriterion("register_check not in", values, "registerCheck");
            return (Criteria) this;
        }

        public Criteria andRegisterCheckBetween(Integer value1, Integer value2) {
            addCriterion("register_check between", value1, value2, "registerCheck");
            return (Criteria) this;
        }

        public Criteria andRegisterCheckNotBetween(Integer value1, Integer value2) {
            addCriterion("register_check not between", value1, value2, "registerCheck");
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