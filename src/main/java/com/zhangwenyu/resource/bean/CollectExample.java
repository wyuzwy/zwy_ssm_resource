package com.zhangwenyu.resource.bean;

import java.util.ArrayList;
import java.util.List;

public class CollectExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CollectExample() {
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

        public Criteria andCollectUidIsNull() {
            addCriterion("collect_uid is null");
            return (Criteria) this;
        }

        public Criteria andCollectUidIsNotNull() {
            addCriterion("collect_uid is not null");
            return (Criteria) this;
        }

        public Criteria andCollectUidEqualTo(String value) {
            addCriterion("collect_uid =", value, "collectUid");
            return (Criteria) this;
        }

        public Criteria andCollectUidNotEqualTo(String value) {
            addCriterion("collect_uid <>", value, "collectUid");
            return (Criteria) this;
        }

        public Criteria andCollectUidGreaterThan(String value) {
            addCriterion("collect_uid >", value, "collectUid");
            return (Criteria) this;
        }

        public Criteria andCollectUidGreaterThanOrEqualTo(String value) {
            addCriterion("collect_uid >=", value, "collectUid");
            return (Criteria) this;
        }

        public Criteria andCollectUidLessThan(String value) {
            addCriterion("collect_uid <", value, "collectUid");
            return (Criteria) this;
        }

        public Criteria andCollectUidLessThanOrEqualTo(String value) {
            addCriterion("collect_uid <=", value, "collectUid");
            return (Criteria) this;
        }

        public Criteria andCollectUidLike(String value) {
            addCriterion("collect_uid like", value, "collectUid");
            return (Criteria) this;
        }

        public Criteria andCollectUidNotLike(String value) {
            addCriterion("collect_uid not like", value, "collectUid");
            return (Criteria) this;
        }

        public Criteria andCollectUidIn(List<String> values) {
            addCriterion("collect_uid in", values, "collectUid");
            return (Criteria) this;
        }

        public Criteria andCollectUidNotIn(List<String> values) {
            addCriterion("collect_uid not in", values, "collectUid");
            return (Criteria) this;
        }

        public Criteria andCollectUidBetween(String value1, String value2) {
            addCriterion("collect_uid between", value1, value2, "collectUid");
            return (Criteria) this;
        }

        public Criteria andCollectUidNotBetween(String value1, String value2) {
            addCriterion("collect_uid not between", value1, value2, "collectUid");
            return (Criteria) this;
        }

        public Criteria andCollectRidIsNull() {
            addCriterion("collect_rid is null");
            return (Criteria) this;
        }

        public Criteria andCollectRidIsNotNull() {
            addCriterion("collect_rid is not null");
            return (Criteria) this;
        }

        public Criteria andCollectRidEqualTo(Integer value) {
            addCriterion("collect_rid =", value, "collectRid");
            return (Criteria) this;
        }

        public Criteria andCollectRidNotEqualTo(Integer value) {
            addCriterion("collect_rid <>", value, "collectRid");
            return (Criteria) this;
        }

        public Criteria andCollectRidGreaterThan(Integer value) {
            addCriterion("collect_rid >", value, "collectRid");
            return (Criteria) this;
        }

        public Criteria andCollectRidGreaterThanOrEqualTo(Integer value) {
            addCriterion("collect_rid >=", value, "collectRid");
            return (Criteria) this;
        }

        public Criteria andCollectRidLessThan(Integer value) {
            addCriterion("collect_rid <", value, "collectRid");
            return (Criteria) this;
        }

        public Criteria andCollectRidLessThanOrEqualTo(Integer value) {
            addCriterion("collect_rid <=", value, "collectRid");
            return (Criteria) this;
        }

        public Criteria andCollectRidIn(List<Integer> values) {
            addCriterion("collect_rid in", values, "collectRid");
            return (Criteria) this;
        }

        public Criteria andCollectRidNotIn(List<Integer> values) {
            addCriterion("collect_rid not in", values, "collectRid");
            return (Criteria) this;
        }

        public Criteria andCollectRidBetween(Integer value1, Integer value2) {
            addCriterion("collect_rid between", value1, value2, "collectRid");
            return (Criteria) this;
        }

        public Criteria andCollectRidNotBetween(Integer value1, Integer value2) {
            addCriterion("collect_rid not between", value1, value2, "collectRid");
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