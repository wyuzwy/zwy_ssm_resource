package com.zhangwenyu.resource.bean;

import java.util.ArrayList;
import java.util.List;

public class FollowExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FollowExample() {
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

        public Criteria andFollowUidIsNull() {
            addCriterion("follow_uid is null");
            return (Criteria) this;
        }

        public Criteria andFollowUidIsNotNull() {
            addCriterion("follow_uid is not null");
            return (Criteria) this;
        }

        public Criteria andFollowUidEqualTo(String value) {
            addCriterion("follow_uid =", value, "followUid");
            return (Criteria) this;
        }

        public Criteria andFollowUidNotEqualTo(String value) {
            addCriterion("follow_uid <>", value, "followUid");
            return (Criteria) this;
        }

        public Criteria andFollowUidGreaterThan(String value) {
            addCriterion("follow_uid >", value, "followUid");
            return (Criteria) this;
        }

        public Criteria andFollowUidGreaterThanOrEqualTo(String value) {
            addCriterion("follow_uid >=", value, "followUid");
            return (Criteria) this;
        }

        public Criteria andFollowUidLessThan(String value) {
            addCriterion("follow_uid <", value, "followUid");
            return (Criteria) this;
        }

        public Criteria andFollowUidLessThanOrEqualTo(String value) {
            addCriterion("follow_uid <=", value, "followUid");
            return (Criteria) this;
        }

        public Criteria andFollowUidLike(String value) {
            addCriterion("follow_uid like", value, "followUid");
            return (Criteria) this;
        }

        public Criteria andFollowUidNotLike(String value) {
            addCriterion("follow_uid not like", value, "followUid");
            return (Criteria) this;
        }

        public Criteria andFollowUidIn(List<String> values) {
            addCriterion("follow_uid in", values, "followUid");
            return (Criteria) this;
        }

        public Criteria andFollowUidNotIn(List<String> values) {
            addCriterion("follow_uid not in", values, "followUid");
            return (Criteria) this;
        }

        public Criteria andFollowUidBetween(String value1, String value2) {
            addCriterion("follow_uid between", value1, value2, "followUid");
            return (Criteria) this;
        }

        public Criteria andFollowUidNotBetween(String value1, String value2) {
            addCriterion("follow_uid not between", value1, value2, "followUid");
            return (Criteria) this;
        }

        public Criteria andFollowedUidIsNull() {
            addCriterion("followed_uid is null");
            return (Criteria) this;
        }

        public Criteria andFollowedUidIsNotNull() {
            addCriterion("followed_uid is not null");
            return (Criteria) this;
        }

        public Criteria andFollowedUidEqualTo(String value) {
            addCriterion("followed_uid =", value, "followedUid");
            return (Criteria) this;
        }

        public Criteria andFollowedUidNotEqualTo(String value) {
            addCriterion("followed_uid <>", value, "followedUid");
            return (Criteria) this;
        }

        public Criteria andFollowedUidGreaterThan(String value) {
            addCriterion("followed_uid >", value, "followedUid");
            return (Criteria) this;
        }

        public Criteria andFollowedUidGreaterThanOrEqualTo(String value) {
            addCriterion("followed_uid >=", value, "followedUid");
            return (Criteria) this;
        }

        public Criteria andFollowedUidLessThan(String value) {
            addCriterion("followed_uid <", value, "followedUid");
            return (Criteria) this;
        }

        public Criteria andFollowedUidLessThanOrEqualTo(String value) {
            addCriterion("followed_uid <=", value, "followedUid");
            return (Criteria) this;
        }

        public Criteria andFollowedUidLike(String value) {
            addCriterion("followed_uid like", value, "followedUid");
            return (Criteria) this;
        }

        public Criteria andFollowedUidNotLike(String value) {
            addCriterion("followed_uid not like", value, "followedUid");
            return (Criteria) this;
        }

        public Criteria andFollowedUidIn(List<String> values) {
            addCriterion("followed_uid in", values, "followedUid");
            return (Criteria) this;
        }

        public Criteria andFollowedUidNotIn(List<String> values) {
            addCriterion("followed_uid not in", values, "followedUid");
            return (Criteria) this;
        }

        public Criteria andFollowedUidBetween(String value1, String value2) {
            addCriterion("followed_uid between", value1, value2, "followedUid");
            return (Criteria) this;
        }

        public Criteria andFollowedUidNotBetween(String value1, String value2) {
            addCriterion("followed_uid not between", value1, value2, "followedUid");
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