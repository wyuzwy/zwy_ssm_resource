package com.zhangwenyu.resource.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ResourceExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ResourceExample() {
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

        public Criteria andResourceIdIsNull() {
            addCriterion("resource_id is null");
            return (Criteria) this;
        }

        public Criteria andResourceIdIsNotNull() {
            addCriterion("resource_id is not null");
            return (Criteria) this;
        }

        public Criteria andResourceIdEqualTo(Integer value) {
            addCriterion("resource_id =", value, "resourceId");
            return (Criteria) this;
        }

        public Criteria andResourceIdNotEqualTo(Integer value) {
            addCriterion("resource_id <>", value, "resourceId");
            return (Criteria) this;
        }

        public Criteria andResourceIdGreaterThan(Integer value) {
            addCriterion("resource_id >", value, "resourceId");
            return (Criteria) this;
        }

        public Criteria andResourceIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("resource_id >=", value, "resourceId");
            return (Criteria) this;
        }

        public Criteria andResourceIdLessThan(Integer value) {
            addCriterion("resource_id <", value, "resourceId");
            return (Criteria) this;
        }

        public Criteria andResourceIdLessThanOrEqualTo(Integer value) {
            addCriterion("resource_id <=", value, "resourceId");
            return (Criteria) this;
        }

        public Criteria andResourceIdIn(List<Integer> values) {
            addCriterion("resource_id in", values, "resourceId");
            return (Criteria) this;
        }

        public Criteria andResourceIdNotIn(List<Integer> values) {
            addCriterion("resource_id not in", values, "resourceId");
            return (Criteria) this;
        }

        public Criteria andResourceIdBetween(Integer value1, Integer value2) {
            addCriterion("resource_id between", value1, value2, "resourceId");
            return (Criteria) this;
        }

        public Criteria andResourceIdNotBetween(Integer value1, Integer value2) {
            addCriterion("resource_id not between", value1, value2, "resourceId");
            return (Criteria) this;
        }

        public Criteria andResourceCidIsNull() {
            addCriterion("resource_cid is null");
            return (Criteria) this;
        }

        public Criteria andResourceCidIsNotNull() {
            addCriterion("resource_cid is not null");
            return (Criteria) this;
        }

        public Criteria andResourceCidEqualTo(Integer value) {
            addCriterion("resource_cid =", value, "resourceCid");
            return (Criteria) this;
        }

        public Criteria andResourceCidNotEqualTo(Integer value) {
            addCriterion("resource_cid <>", value, "resourceCid");
            return (Criteria) this;
        }

        public Criteria andResourceCidGreaterThan(Integer value) {
            addCriterion("resource_cid >", value, "resourceCid");
            return (Criteria) this;
        }

        public Criteria andResourceCidGreaterThanOrEqualTo(Integer value) {
            addCriterion("resource_cid >=", value, "resourceCid");
            return (Criteria) this;
        }

        public Criteria andResourceCidLessThan(Integer value) {
            addCriterion("resource_cid <", value, "resourceCid");
            return (Criteria) this;
        }

        public Criteria andResourceCidLessThanOrEqualTo(Integer value) {
            addCriterion("resource_cid <=", value, "resourceCid");
            return (Criteria) this;
        }

        public Criteria andResourceCidIn(List<Integer> values) {
            addCriterion("resource_cid in", values, "resourceCid");
            return (Criteria) this;
        }

        public Criteria andResourceCidNotIn(List<Integer> values) {
            addCriterion("resource_cid not in", values, "resourceCid");
            return (Criteria) this;
        }

        public Criteria andResourceCidBetween(Integer value1, Integer value2) {
            addCriterion("resource_cid between", value1, value2, "resourceCid");
            return (Criteria) this;
        }

        public Criteria andResourceCidNotBetween(Integer value1, Integer value2) {
            addCriterion("resource_cid not between", value1, value2, "resourceCid");
            return (Criteria) this;
        }

        public Criteria andResourceUidIsNull() {
            addCriterion("resource_uid is null");
            return (Criteria) this;
        }

        public Criteria andResourceUidIsNotNull() {
            addCriterion("resource_uid is not null");
            return (Criteria) this;
        }

        public Criteria andResourceUidEqualTo(String value) {
            addCriterion("resource_uid =", value, "resourceUid");
            return (Criteria) this;
        }

        public Criteria andResourceUidNotEqualTo(String value) {
            addCriterion("resource_uid <>", value, "resourceUid");
            return (Criteria) this;
        }

        public Criteria andResourceUidGreaterThan(String value) {
            addCriterion("resource_uid >", value, "resourceUid");
            return (Criteria) this;
        }

        public Criteria andResourceUidGreaterThanOrEqualTo(String value) {
            addCriterion("resource_uid >=", value, "resourceUid");
            return (Criteria) this;
        }

        public Criteria andResourceUidLessThan(String value) {
            addCriterion("resource_uid <", value, "resourceUid");
            return (Criteria) this;
        }

        public Criteria andResourceUidLessThanOrEqualTo(String value) {
            addCriterion("resource_uid <=", value, "resourceUid");
            return (Criteria) this;
        }

        public Criteria andResourceUidLike(String value) {
            addCriterion("resource_uid like", value, "resourceUid");
            return (Criteria) this;
        }

        public Criteria andResourceUidNotLike(String value) {
            addCriterion("resource_uid not like", value, "resourceUid");
            return (Criteria) this;
        }

        public Criteria andResourceUidIn(List<String> values) {
            addCriterion("resource_uid in", values, "resourceUid");
            return (Criteria) this;
        }

        public Criteria andResourceUidNotIn(List<String> values) {
            addCriterion("resource_uid not in", values, "resourceUid");
            return (Criteria) this;
        }

        public Criteria andResourceUidBetween(String value1, String value2) {
            addCriterion("resource_uid between", value1, value2, "resourceUid");
            return (Criteria) this;
        }

        public Criteria andResourceUidNotBetween(String value1, String value2) {
            addCriterion("resource_uid not between", value1, value2, "resourceUid");
            return (Criteria) this;
        }

        public Criteria andResourceNameIsNull() {
            addCriterion("resource_name is null");
            return (Criteria) this;
        }

        public Criteria andResourceNameIsNotNull() {
            addCriterion("resource_name is not null");
            return (Criteria) this;
        }

        public Criteria andResourceNameEqualTo(String value) {
            addCriterion("resource_name =", value, "resourceName");
            return (Criteria) this;
        }

        public Criteria andResourceNameNotEqualTo(String value) {
            addCriterion("resource_name <>", value, "resourceName");
            return (Criteria) this;
        }

        public Criteria andResourceNameGreaterThan(String value) {
            addCriterion("resource_name >", value, "resourceName");
            return (Criteria) this;
        }

        public Criteria andResourceNameGreaterThanOrEqualTo(String value) {
            addCriterion("resource_name >=", value, "resourceName");
            return (Criteria) this;
        }

        public Criteria andResourceNameLessThan(String value) {
            addCriterion("resource_name <", value, "resourceName");
            return (Criteria) this;
        }

        public Criteria andResourceNameLessThanOrEqualTo(String value) {
            addCriterion("resource_name <=", value, "resourceName");
            return (Criteria) this;
        }

        public Criteria andResourceNameLike(String value) {
            addCriterion("resource_name like", value, "resourceName");
            return (Criteria) this;
        }

        public Criteria andResourceNameNotLike(String value) {
            addCriterion("resource_name not like", value, "resourceName");
            return (Criteria) this;
        }

        public Criteria andResourceNameIn(List<String> values) {
            addCriterion("resource_name in", values, "resourceName");
            return (Criteria) this;
        }

        public Criteria andResourceNameNotIn(List<String> values) {
            addCriterion("resource_name not in", values, "resourceName");
            return (Criteria) this;
        }

        public Criteria andResourceNameBetween(String value1, String value2) {
            addCriterion("resource_name between", value1, value2, "resourceName");
            return (Criteria) this;
        }

        public Criteria andResourceNameNotBetween(String value1, String value2) {
            addCriterion("resource_name not between", value1, value2, "resourceName");
            return (Criteria) this;
        }

        public Criteria andResourceImageIsNull() {
            addCriterion("resource_image is null");
            return (Criteria) this;
        }

        public Criteria andResourceImageIsNotNull() {
            addCriterion("resource_image is not null");
            return (Criteria) this;
        }

        public Criteria andResourceImageEqualTo(String value) {
            addCriterion("resource_image =", value, "resourceImage");
            return (Criteria) this;
        }

        public Criteria andResourceImageNotEqualTo(String value) {
            addCriterion("resource_image <>", value, "resourceImage");
            return (Criteria) this;
        }

        public Criteria andResourceImageGreaterThan(String value) {
            addCriterion("resource_image >", value, "resourceImage");
            return (Criteria) this;
        }

        public Criteria andResourceImageGreaterThanOrEqualTo(String value) {
            addCriterion("resource_image >=", value, "resourceImage");
            return (Criteria) this;
        }

        public Criteria andResourceImageLessThan(String value) {
            addCriterion("resource_image <", value, "resourceImage");
            return (Criteria) this;
        }

        public Criteria andResourceImageLessThanOrEqualTo(String value) {
            addCriterion("resource_image <=", value, "resourceImage");
            return (Criteria) this;
        }

        public Criteria andResourceImageLike(String value) {
            addCriterion("resource_image like", value, "resourceImage");
            return (Criteria) this;
        }

        public Criteria andResourceImageNotLike(String value) {
            addCriterion("resource_image not like", value, "resourceImage");
            return (Criteria) this;
        }

        public Criteria andResourceImageIn(List<String> values) {
            addCriterion("resource_image in", values, "resourceImage");
            return (Criteria) this;
        }

        public Criteria andResourceImageNotIn(List<String> values) {
            addCriterion("resource_image not in", values, "resourceImage");
            return (Criteria) this;
        }

        public Criteria andResourceImageBetween(String value1, String value2) {
            addCriterion("resource_image between", value1, value2, "resourceImage");
            return (Criteria) this;
        }

        public Criteria andResourceImageNotBetween(String value1, String value2) {
            addCriterion("resource_image not between", value1, value2, "resourceImage");
            return (Criteria) this;
        }

        public Criteria andResourceUrlIsNull() {
            addCriterion("resource_url is null");
            return (Criteria) this;
        }

        public Criteria andResourceUrlIsNotNull() {
            addCriterion("resource_url is not null");
            return (Criteria) this;
        }

        public Criteria andResourceUrlEqualTo(String value) {
            addCriterion("resource_url =", value, "resourceUrl");
            return (Criteria) this;
        }

        public Criteria andResourceUrlNotEqualTo(String value) {
            addCriterion("resource_url <>", value, "resourceUrl");
            return (Criteria) this;
        }

        public Criteria andResourceUrlGreaterThan(String value) {
            addCriterion("resource_url >", value, "resourceUrl");
            return (Criteria) this;
        }

        public Criteria andResourceUrlGreaterThanOrEqualTo(String value) {
            addCriterion("resource_url >=", value, "resourceUrl");
            return (Criteria) this;
        }

        public Criteria andResourceUrlLessThan(String value) {
            addCriterion("resource_url <", value, "resourceUrl");
            return (Criteria) this;
        }

        public Criteria andResourceUrlLessThanOrEqualTo(String value) {
            addCriterion("resource_url <=", value, "resourceUrl");
            return (Criteria) this;
        }

        public Criteria andResourceUrlLike(String value) {
            addCriterion("resource_url like", value, "resourceUrl");
            return (Criteria) this;
        }

        public Criteria andResourceUrlNotLike(String value) {
            addCriterion("resource_url not like", value, "resourceUrl");
            return (Criteria) this;
        }

        public Criteria andResourceUrlIn(List<String> values) {
            addCriterion("resource_url in", values, "resourceUrl");
            return (Criteria) this;
        }

        public Criteria andResourceUrlNotIn(List<String> values) {
            addCriterion("resource_url not in", values, "resourceUrl");
            return (Criteria) this;
        }

        public Criteria andResourceUrlBetween(String value1, String value2) {
            addCriterion("resource_url between", value1, value2, "resourceUrl");
            return (Criteria) this;
        }

        public Criteria andResourceUrlNotBetween(String value1, String value2) {
            addCriterion("resource_url not between", value1, value2, "resourceUrl");
            return (Criteria) this;
        }

        public Criteria andResourceDescIsNull() {
            addCriterion("resource_desc is null");
            return (Criteria) this;
        }

        public Criteria andResourceDescIsNotNull() {
            addCriterion("resource_desc is not null");
            return (Criteria) this;
        }

        public Criteria andResourceDescEqualTo(String value) {
            addCriterion("resource_desc =", value, "resourceDesc");
            return (Criteria) this;
        }

        public Criteria andResourceDescNotEqualTo(String value) {
            addCriterion("resource_desc <>", value, "resourceDesc");
            return (Criteria) this;
        }

        public Criteria andResourceDescGreaterThan(String value) {
            addCriterion("resource_desc >", value, "resourceDesc");
            return (Criteria) this;
        }

        public Criteria andResourceDescGreaterThanOrEqualTo(String value) {
            addCriterion("resource_desc >=", value, "resourceDesc");
            return (Criteria) this;
        }

        public Criteria andResourceDescLessThan(String value) {
            addCriterion("resource_desc <", value, "resourceDesc");
            return (Criteria) this;
        }

        public Criteria andResourceDescLessThanOrEqualTo(String value) {
            addCriterion("resource_desc <=", value, "resourceDesc");
            return (Criteria) this;
        }

        public Criteria andResourceDescLike(String value) {
            addCriterion("resource_desc like", value, "resourceDesc");
            return (Criteria) this;
        }

        public Criteria andResourceDescNotLike(String value) {
            addCriterion("resource_desc not like", value, "resourceDesc");
            return (Criteria) this;
        }

        public Criteria andResourceDescIn(List<String> values) {
            addCriterion("resource_desc in", values, "resourceDesc");
            return (Criteria) this;
        }

        public Criteria andResourceDescNotIn(List<String> values) {
            addCriterion("resource_desc not in", values, "resourceDesc");
            return (Criteria) this;
        }

        public Criteria andResourceDescBetween(String value1, String value2) {
            addCriterion("resource_desc between", value1, value2, "resourceDesc");
            return (Criteria) this;
        }

        public Criteria andResourceDescNotBetween(String value1, String value2) {
            addCriterion("resource_desc not between", value1, value2, "resourceDesc");
            return (Criteria) this;
        }

        public Criteria andResourceLevelIsNull() {
            addCriterion("resource_level is null");
            return (Criteria) this;
        }

        public Criteria andResourceLevelIsNotNull() {
            addCriterion("resource_level is not null");
            return (Criteria) this;
        }

        public Criteria andResourceLevelEqualTo(String value) {
            addCriterion("resource_level =", value, "resourceLevel");
            return (Criteria) this;
        }

        public Criteria andResourceLevelNotEqualTo(String value) {
            addCriterion("resource_level <>", value, "resourceLevel");
            return (Criteria) this;
        }

        public Criteria andResourceLevelGreaterThan(String value) {
            addCriterion("resource_level >", value, "resourceLevel");
            return (Criteria) this;
        }

        public Criteria andResourceLevelGreaterThanOrEqualTo(String value) {
            addCriterion("resource_level >=", value, "resourceLevel");
            return (Criteria) this;
        }

        public Criteria andResourceLevelLessThan(String value) {
            addCriterion("resource_level <", value, "resourceLevel");
            return (Criteria) this;
        }

        public Criteria andResourceLevelLessThanOrEqualTo(String value) {
            addCriterion("resource_level <=", value, "resourceLevel");
            return (Criteria) this;
        }

        public Criteria andResourceLevelLike(String value) {
            addCriterion("resource_level like", value, "resourceLevel");
            return (Criteria) this;
        }

        public Criteria andResourceLevelNotLike(String value) {
            addCriterion("resource_level not like", value, "resourceLevel");
            return (Criteria) this;
        }

        public Criteria andResourceLevelIn(List<String> values) {
            addCriterion("resource_level in", values, "resourceLevel");
            return (Criteria) this;
        }

        public Criteria andResourceLevelNotIn(List<String> values) {
            addCriterion("resource_level not in", values, "resourceLevel");
            return (Criteria) this;
        }

        public Criteria andResourceLevelBetween(String value1, String value2) {
            addCriterion("resource_level between", value1, value2, "resourceLevel");
            return (Criteria) this;
        }

        public Criteria andResourceLevelNotBetween(String value1, String value2) {
            addCriterion("resource_level not between", value1, value2, "resourceLevel");
            return (Criteria) this;
        }

        public Criteria andResourceTimeIsNull() {
            addCriterion("resource_time is null");
            return (Criteria) this;
        }

        public Criteria andResourceTimeIsNotNull() {
            addCriterion("resource_time is not null");
            return (Criteria) this;
        }

        public Criteria andResourceTimeEqualTo(Date value) {
            addCriterionForJDBCDate("resource_time =", value, "resourceTime");
            return (Criteria) this;
        }

        public Criteria andResourceTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("resource_time <>", value, "resourceTime");
            return (Criteria) this;
        }

        public Criteria andResourceTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("resource_time >", value, "resourceTime");
            return (Criteria) this;
        }

        public Criteria andResourceTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("resource_time >=", value, "resourceTime");
            return (Criteria) this;
        }

        public Criteria andResourceTimeLessThan(Date value) {
            addCriterionForJDBCDate("resource_time <", value, "resourceTime");
            return (Criteria) this;
        }

        public Criteria andResourceTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("resource_time <=", value, "resourceTime");
            return (Criteria) this;
        }

        public Criteria andResourceTimeIn(List<Date> values) {
            addCriterionForJDBCDate("resource_time in", values, "resourceTime");
            return (Criteria) this;
        }

        public Criteria andResourceTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("resource_time not in", values, "resourceTime");
            return (Criteria) this;
        }

        public Criteria andResourceTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("resource_time between", value1, value2, "resourceTime");
            return (Criteria) this;
        }

        public Criteria andResourceTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("resource_time not between", value1, value2, "resourceTime");
            return (Criteria) this;
        }

        public Criteria andResourceGoodIsNull() {
            addCriterion("resource_good is null");
            return (Criteria) this;
        }

        public Criteria andResourceGoodIsNotNull() {
            addCriterion("resource_good is not null");
            return (Criteria) this;
        }

        public Criteria andResourceGoodEqualTo(Integer value) {
            addCriterion("resource_good =", value, "resourceGood");
            return (Criteria) this;
        }

        public Criteria andResourceGoodNotEqualTo(Integer value) {
            addCriterion("resource_good <>", value, "resourceGood");
            return (Criteria) this;
        }

        public Criteria andResourceGoodGreaterThan(Integer value) {
            addCriterion("resource_good >", value, "resourceGood");
            return (Criteria) this;
        }

        public Criteria andResourceGoodGreaterThanOrEqualTo(Integer value) {
            addCriterion("resource_good >=", value, "resourceGood");
            return (Criteria) this;
        }

        public Criteria andResourceGoodLessThan(Integer value) {
            addCriterion("resource_good <", value, "resourceGood");
            return (Criteria) this;
        }

        public Criteria andResourceGoodLessThanOrEqualTo(Integer value) {
            addCriterion("resource_good <=", value, "resourceGood");
            return (Criteria) this;
        }

        public Criteria andResourceGoodIn(List<Integer> values) {
            addCriterion("resource_good in", values, "resourceGood");
            return (Criteria) this;
        }

        public Criteria andResourceGoodNotIn(List<Integer> values) {
            addCriterion("resource_good not in", values, "resourceGood");
            return (Criteria) this;
        }

        public Criteria andResourceGoodBetween(Integer value1, Integer value2) {
            addCriterion("resource_good between", value1, value2, "resourceGood");
            return (Criteria) this;
        }

        public Criteria andResourceGoodNotBetween(Integer value1, Integer value2) {
            addCriterion("resource_good not between", value1, value2, "resourceGood");
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