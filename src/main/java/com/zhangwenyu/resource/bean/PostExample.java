package com.zhangwenyu.resource.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class PostExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PostExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andPostIdIsNull() {
            addCriterion("post_id is null");
            return (Criteria) this;
        }

        public Criteria andPostIdIsNotNull() {
            addCriterion("post_id is not null");
            return (Criteria) this;
        }

        public Criteria andPostIdEqualTo(Integer value) {
            addCriterion("post_id =", value, "postId");
            return (Criteria) this;
        }

        public Criteria andPostIdNotEqualTo(Integer value) {
            addCriterion("post_id <>", value, "postId");
            return (Criteria) this;
        }

        public Criteria andPostIdGreaterThan(Integer value) {
            addCriterion("post_id >", value, "postId");
            return (Criteria) this;
        }

        public Criteria andPostIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("post_id >=", value, "postId");
            return (Criteria) this;
        }

        public Criteria andPostIdLessThan(Integer value) {
            addCriterion("post_id <", value, "postId");
            return (Criteria) this;
        }

        public Criteria andPostIdLessThanOrEqualTo(Integer value) {
            addCriterion("post_id <=", value, "postId");
            return (Criteria) this;
        }

        public Criteria andPostIdIn(List<Integer> values) {
            addCriterion("post_id in", values, "postId");
            return (Criteria) this;
        }

        public Criteria andPostIdNotIn(List<Integer> values) {
            addCriterion("post_id not in", values, "postId");
            return (Criteria) this;
        }

        public Criteria andPostIdBetween(Integer value1, Integer value2) {
            addCriterion("post_id between", value1, value2, "postId");
            return (Criteria) this;
        }

        public Criteria andPostIdNotBetween(Integer value1, Integer value2) {
            addCriterion("post_id not between", value1, value2, "postId");
            return (Criteria) this;
        }

        public Criteria andPostUidIsNull() {
            addCriterion("post_uid is null");
            return (Criteria) this;
        }

        public Criteria andPostUidIsNotNull() {
            addCriterion("post_uid is not null");
            return (Criteria) this;
        }

        public Criteria andPostUidEqualTo(String value) {
            addCriterion("post_uid =", value, "postUid");
            return (Criteria) this;
        }

        public Criteria andPostUidNotEqualTo(String value) {
            addCriterion("post_uid <>", value, "postUid");
            return (Criteria) this;
        }

        public Criteria andPostUidGreaterThan(String value) {
            addCriterion("post_uid >", value, "postUid");
            return (Criteria) this;
        }

        public Criteria andPostUidGreaterThanOrEqualTo(String value) {
            addCriterion("post_uid >=", value, "postUid");
            return (Criteria) this;
        }

        public Criteria andPostUidLessThan(String value) {
            addCriterion("post_uid <", value, "postUid");
            return (Criteria) this;
        }

        public Criteria andPostUidLessThanOrEqualTo(String value) {
            addCriterion("post_uid <=", value, "postUid");
            return (Criteria) this;
        }

        public Criteria andPostUidLike(String value) {
            addCriterion("post_uid like", value, "postUid");
            return (Criteria) this;
        }

        public Criteria andPostUidNotLike(String value) {
            addCriterion("post_uid not like", value, "postUid");
            return (Criteria) this;
        }

        public Criteria andPostUidIn(List<String> values) {
            addCriterion("post_uid in", values, "postUid");
            return (Criteria) this;
        }

        public Criteria andPostUidNotIn(List<String> values) {
            addCriterion("post_uid not in", values, "postUid");
            return (Criteria) this;
        }

        public Criteria andPostUidBetween(String value1, String value2) {
            addCriterion("post_uid between", value1, value2, "postUid");
            return (Criteria) this;
        }

        public Criteria andPostUidNotBetween(String value1, String value2) {
            addCriterion("post_uid not between", value1, value2, "postUid");
            return (Criteria) this;
        }

        public Criteria andPostTitleIsNull() {
            addCriterion("post_title is null");
            return (Criteria) this;
        }

        public Criteria andPostTitleIsNotNull() {
            addCriterion("post_title is not null");
            return (Criteria) this;
        }

        public Criteria andPostTitleEqualTo(String value) {
            addCriterion("post_title =", value, "postTitle");
            return (Criteria) this;
        }

        public Criteria andPostTitleNotEqualTo(String value) {
            addCriterion("post_title <>", value, "postTitle");
            return (Criteria) this;
        }

        public Criteria andPostTitleGreaterThan(String value) {
            addCriterion("post_title >", value, "postTitle");
            return (Criteria) this;
        }

        public Criteria andPostTitleGreaterThanOrEqualTo(String value) {
            addCriterion("post_title >=", value, "postTitle");
            return (Criteria) this;
        }

        public Criteria andPostTitleLessThan(String value) {
            addCriterion("post_title <", value, "postTitle");
            return (Criteria) this;
        }

        public Criteria andPostTitleLessThanOrEqualTo(String value) {
            addCriterion("post_title <=", value, "postTitle");
            return (Criteria) this;
        }

        public Criteria andPostTitleLike(String value) {
            addCriterion("post_title like", value, "postTitle");
            return (Criteria) this;
        }

        public Criteria andPostTitleNotLike(String value) {
            addCriterion("post_title not like", value, "postTitle");
            return (Criteria) this;
        }

        public Criteria andPostTitleIn(List<String> values) {
            addCriterion("post_title in", values, "postTitle");
            return (Criteria) this;
        }

        public Criteria andPostTitleNotIn(List<String> values) {
            addCriterion("post_title not in", values, "postTitle");
            return (Criteria) this;
        }

        public Criteria andPostTitleBetween(String value1, String value2) {
            addCriterion("post_title between", value1, value2, "postTitle");
            return (Criteria) this;
        }

        public Criteria andPostTitleNotBetween(String value1, String value2) {
            addCriterion("post_title not between", value1, value2, "postTitle");
            return (Criteria) this;
        }

        public Criteria andPostTextIsNull() {
            addCriterion("post_text is null");
            return (Criteria) this;
        }

        public Criteria andPostTextIsNotNull() {
            addCriterion("post_text is not null");
            return (Criteria) this;
        }

        public Criteria andPostTextEqualTo(String value) {
            addCriterion("post_text =", value, "postText");
            return (Criteria) this;
        }

        public Criteria andPostTextNotEqualTo(String value) {
            addCriterion("post_text <>", value, "postText");
            return (Criteria) this;
        }

        public Criteria andPostTextGreaterThan(String value) {
            addCriterion("post_text >", value, "postText");
            return (Criteria) this;
        }

        public Criteria andPostTextGreaterThanOrEqualTo(String value) {
            addCriterion("post_text >=", value, "postText");
            return (Criteria) this;
        }

        public Criteria andPostTextLessThan(String value) {
            addCriterion("post_text <", value, "postText");
            return (Criteria) this;
        }

        public Criteria andPostTextLessThanOrEqualTo(String value) {
            addCriterion("post_text <=", value, "postText");
            return (Criteria) this;
        }

        public Criteria andPostTextLike(String value) {
            addCriterion("post_text like", value, "postText");
            return (Criteria) this;
        }

        public Criteria andPostTextNotLike(String value) {
            addCriterion("post_text not like", value, "postText");
            return (Criteria) this;
        }

        public Criteria andPostTextIn(List<String> values) {
            addCriterion("post_text in", values, "postText");
            return (Criteria) this;
        }

        public Criteria andPostTextNotIn(List<String> values) {
            addCriterion("post_text not in", values, "postText");
            return (Criteria) this;
        }

        public Criteria andPostTextBetween(String value1, String value2) {
            addCriterion("post_text between", value1, value2, "postText");
            return (Criteria) this;
        }

        public Criteria andPostTextNotBetween(String value1, String value2) {
            addCriterion("post_text not between", value1, value2, "postText");
            return (Criteria) this;
        }

        public Criteria andPostImageIsNull() {
            addCriterion("post_image is null");
            return (Criteria) this;
        }

        public Criteria andPostImageIsNotNull() {
            addCriterion("post_image is not null");
            return (Criteria) this;
        }

        public Criteria andPostImageEqualTo(String value) {
            addCriterion("post_image =", value, "postImage");
            return (Criteria) this;
        }

        public Criteria andPostImageNotEqualTo(String value) {
            addCriterion("post_image <>", value, "postImage");
            return (Criteria) this;
        }

        public Criteria andPostImageGreaterThan(String value) {
            addCriterion("post_image >", value, "postImage");
            return (Criteria) this;
        }

        public Criteria andPostImageGreaterThanOrEqualTo(String value) {
            addCriterion("post_image >=", value, "postImage");
            return (Criteria) this;
        }

        public Criteria andPostImageLessThan(String value) {
            addCriterion("post_image <", value, "postImage");
            return (Criteria) this;
        }

        public Criteria andPostImageLessThanOrEqualTo(String value) {
            addCriterion("post_image <=", value, "postImage");
            return (Criteria) this;
        }

        public Criteria andPostImageLike(String value) {
            addCriterion("post_image like", value, "postImage");
            return (Criteria) this;
        }

        public Criteria andPostImageNotLike(String value) {
            addCriterion("post_image not like", value, "postImage");
            return (Criteria) this;
        }

        public Criteria andPostImageIn(List<String> values) {
            addCriterion("post_image in", values, "postImage");
            return (Criteria) this;
        }

        public Criteria andPostImageNotIn(List<String> values) {
            addCriterion("post_image not in", values, "postImage");
            return (Criteria) this;
        }

        public Criteria andPostImageBetween(String value1, String value2) {
            addCriterion("post_image between", value1, value2, "postImage");
            return (Criteria) this;
        }

        public Criteria andPostImageNotBetween(String value1, String value2) {
            addCriterion("post_image not between", value1, value2, "postImage");
            return (Criteria) this;
        }

        public Criteria andPostTimeIsNull() {
            addCriterion("post_time is null");
            return (Criteria) this;
        }

        public Criteria andPostTimeIsNotNull() {
            addCriterion("post_time is not null");
            return (Criteria) this;
        }

        public Criteria andPostTimeEqualTo(Date value) {
            addCriterionForJDBCDate("post_time =", value, "postTime");
            return (Criteria) this;
        }

        public Criteria andPostTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("post_time <>", value, "postTime");
            return (Criteria) this;
        }

        public Criteria andPostTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("post_time >", value, "postTime");
            return (Criteria) this;
        }

        public Criteria andPostTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("post_time >=", value, "postTime");
            return (Criteria) this;
        }

        public Criteria andPostTimeLessThan(Date value) {
            addCriterionForJDBCDate("post_time <", value, "postTime");
            return (Criteria) this;
        }

        public Criteria andPostTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("post_time <=", value, "postTime");
            return (Criteria) this;
        }

        public Criteria andPostTimeIn(List<Date> values) {
            addCriterionForJDBCDate("post_time in", values, "postTime");
            return (Criteria) this;
        }

        public Criteria andPostTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("post_time not in", values, "postTime");
            return (Criteria) this;
        }

        public Criteria andPostTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("post_time between", value1, value2, "postTime");
            return (Criteria) this;
        }

        public Criteria andPostTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("post_time not between", value1, value2, "postTime");
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