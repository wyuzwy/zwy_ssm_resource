package com.zhangwenyu.resource.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TeacherExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TeacherExample() {
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

        public Criteria andTeacherIdIsNull() {
            addCriterion("teacher_id is null");
            return (Criteria) this;
        }

        public Criteria andTeacherIdIsNotNull() {
            addCriterion("teacher_id is not null");
            return (Criteria) this;
        }

        public Criteria andTeacherIdEqualTo(String value) {
            addCriterion("teacher_id =", value, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdNotEqualTo(String value) {
            addCriterion("teacher_id <>", value, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdGreaterThan(String value) {
            addCriterion("teacher_id >", value, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdGreaterThanOrEqualTo(String value) {
            addCriterion("teacher_id >=", value, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdLessThan(String value) {
            addCriterion("teacher_id <", value, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdLessThanOrEqualTo(String value) {
            addCriterion("teacher_id <=", value, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdLike(String value) {
            addCriterion("teacher_id like", value, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdNotLike(String value) {
            addCriterion("teacher_id not like", value, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdIn(List<String> values) {
            addCriterion("teacher_id in", values, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdNotIn(List<String> values) {
            addCriterion("teacher_id not in", values, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdBetween(String value1, String value2) {
            addCriterion("teacher_id between", value1, value2, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdNotBetween(String value1, String value2) {
            addCriterion("teacher_id not between", value1, value2, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherNameIsNull() {
            addCriterion("teacher_name is null");
            return (Criteria) this;
        }

        public Criteria andTeacherNameIsNotNull() {
            addCriterion("teacher_name is not null");
            return (Criteria) this;
        }

        public Criteria andTeacherNameEqualTo(String value) {
            addCriterion("teacher_name =", value, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameNotEqualTo(String value) {
            addCriterion("teacher_name <>", value, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameGreaterThan(String value) {
            addCriterion("teacher_name >", value, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameGreaterThanOrEqualTo(String value) {
            addCriterion("teacher_name >=", value, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameLessThan(String value) {
            addCriterion("teacher_name <", value, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameLessThanOrEqualTo(String value) {
            addCriterion("teacher_name <=", value, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameLike(String value) {
            addCriterion("teacher_name like", value, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameNotLike(String value) {
            addCriterion("teacher_name not like", value, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameIn(List<String> values) {
            addCriterion("teacher_name in", values, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameNotIn(List<String> values) {
            addCriterion("teacher_name not in", values, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameBetween(String value1, String value2) {
            addCriterion("teacher_name between", value1, value2, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameNotBetween(String value1, String value2) {
            addCriterion("teacher_name not between", value1, value2, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherSexIsNull() {
            addCriterion("teacher_sex is null");
            return (Criteria) this;
        }

        public Criteria andTeacherSexIsNotNull() {
            addCriterion("teacher_sex is not null");
            return (Criteria) this;
        }

        public Criteria andTeacherSexEqualTo(String value) {
            addCriterion("teacher_sex =", value, "teacherSex");
            return (Criteria) this;
        }

        public Criteria andTeacherSexNotEqualTo(String value) {
            addCriterion("teacher_sex <>", value, "teacherSex");
            return (Criteria) this;
        }

        public Criteria andTeacherSexGreaterThan(String value) {
            addCriterion("teacher_sex >", value, "teacherSex");
            return (Criteria) this;
        }

        public Criteria andTeacherSexGreaterThanOrEqualTo(String value) {
            addCriterion("teacher_sex >=", value, "teacherSex");
            return (Criteria) this;
        }

        public Criteria andTeacherSexLessThan(String value) {
            addCriterion("teacher_sex <", value, "teacherSex");
            return (Criteria) this;
        }

        public Criteria andTeacherSexLessThanOrEqualTo(String value) {
            addCriterion("teacher_sex <=", value, "teacherSex");
            return (Criteria) this;
        }

        public Criteria andTeacherSexLike(String value) {
            addCriterion("teacher_sex like", value, "teacherSex");
            return (Criteria) this;
        }

        public Criteria andTeacherSexNotLike(String value) {
            addCriterion("teacher_sex not like", value, "teacherSex");
            return (Criteria) this;
        }

        public Criteria andTeacherSexIn(List<String> values) {
            addCriterion("teacher_sex in", values, "teacherSex");
            return (Criteria) this;
        }

        public Criteria andTeacherSexNotIn(List<String> values) {
            addCriterion("teacher_sex not in", values, "teacherSex");
            return (Criteria) this;
        }

        public Criteria andTeacherSexBetween(String value1, String value2) {
            addCriterion("teacher_sex between", value1, value2, "teacherSex");
            return (Criteria) this;
        }

        public Criteria andTeacherSexNotBetween(String value1, String value2) {
            addCriterion("teacher_sex not between", value1, value2, "teacherSex");
            return (Criteria) this;
        }

        public Criteria andTeacherBirthIsNull() {
            addCriterion("teacher_birth is null");
            return (Criteria) this;
        }

        public Criteria andTeacherBirthIsNotNull() {
            addCriterion("teacher_birth is not null");
            return (Criteria) this;
        }

        public Criteria andTeacherBirthEqualTo(Date value) {
            addCriterionForJDBCDate("teacher_birth =", value, "teacherBirth");
            return (Criteria) this;
        }

        public Criteria andTeacherBirthNotEqualTo(Date value) {
            addCriterionForJDBCDate("teacher_birth <>", value, "teacherBirth");
            return (Criteria) this;
        }

        public Criteria andTeacherBirthGreaterThan(Date value) {
            addCriterionForJDBCDate("teacher_birth >", value, "teacherBirth");
            return (Criteria) this;
        }

        public Criteria andTeacherBirthGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("teacher_birth >=", value, "teacherBirth");
            return (Criteria) this;
        }

        public Criteria andTeacherBirthLessThan(Date value) {
            addCriterionForJDBCDate("teacher_birth <", value, "teacherBirth");
            return (Criteria) this;
        }

        public Criteria andTeacherBirthLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("teacher_birth <=", value, "teacherBirth");
            return (Criteria) this;
        }

        public Criteria andTeacherBirthIn(List<Date> values) {
            addCriterionForJDBCDate("teacher_birth in", values, "teacherBirth");
            return (Criteria) this;
        }

        public Criteria andTeacherBirthNotIn(List<Date> values) {
            addCriterionForJDBCDate("teacher_birth not in", values, "teacherBirth");
            return (Criteria) this;
        }

        public Criteria andTeacherBirthBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("teacher_birth between", value1, value2, "teacherBirth");
            return (Criteria) this;
        }

        public Criteria andTeacherBirthNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("teacher_birth not between", value1, value2, "teacherBirth");
            return (Criteria) this;
        }

        public Criteria andTeacherDescIsNull() {
            addCriterion("teacher_desc is null");
            return (Criteria) this;
        }

        public Criteria andTeacherDescIsNotNull() {
            addCriterion("teacher_desc is not null");
            return (Criteria) this;
        }

        public Criteria andTeacherDescEqualTo(String value) {
            addCriterion("teacher_desc =", value, "teacherDesc");
            return (Criteria) this;
        }

        public Criteria andTeacherDescNotEqualTo(String value) {
            addCriterion("teacher_desc <>", value, "teacherDesc");
            return (Criteria) this;
        }

        public Criteria andTeacherDescGreaterThan(String value) {
            addCriterion("teacher_desc >", value, "teacherDesc");
            return (Criteria) this;
        }

        public Criteria andTeacherDescGreaterThanOrEqualTo(String value) {
            addCriterion("teacher_desc >=", value, "teacherDesc");
            return (Criteria) this;
        }

        public Criteria andTeacherDescLessThan(String value) {
            addCriterion("teacher_desc <", value, "teacherDesc");
            return (Criteria) this;
        }

        public Criteria andTeacherDescLessThanOrEqualTo(String value) {
            addCriterion("teacher_desc <=", value, "teacherDesc");
            return (Criteria) this;
        }

        public Criteria andTeacherDescLike(String value) {
            addCriterion("teacher_desc like", value, "teacherDesc");
            return (Criteria) this;
        }

        public Criteria andTeacherDescNotLike(String value) {
            addCriterion("teacher_desc not like", value, "teacherDesc");
            return (Criteria) this;
        }

        public Criteria andTeacherDescIn(List<String> values) {
            addCriterion("teacher_desc in", values, "teacherDesc");
            return (Criteria) this;
        }

        public Criteria andTeacherDescNotIn(List<String> values) {
            addCriterion("teacher_desc not in", values, "teacherDesc");
            return (Criteria) this;
        }

        public Criteria andTeacherDescBetween(String value1, String value2) {
            addCriterion("teacher_desc between", value1, value2, "teacherDesc");
            return (Criteria) this;
        }

        public Criteria andTeacherDescNotBetween(String value1, String value2) {
            addCriterion("teacher_desc not between", value1, value2, "teacherDesc");
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