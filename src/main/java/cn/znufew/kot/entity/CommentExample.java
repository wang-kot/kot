package cn.znufew.kot.entity;

import java.util.ArrayList;
import java.util.List;

public class CommentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CommentExample() {
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

        public Criteria andFromIsNull() {
            addCriterion("from is null");
            return (Criteria) this;
        }

        public Criteria andFromIsNotNull() {
            addCriterion("from is not null");
            return (Criteria) this;
        }

        public Criteria andFromEqualTo(Integer value) {
            addCriterion("from =", value, "from");
            return (Criteria) this;
        }

        public Criteria andFromNotEqualTo(Integer value) {
            addCriterion("from <>", value, "from");
            return (Criteria) this;
        }

        public Criteria andFromGreaterThan(Integer value) {
            addCriterion("from >", value, "from");
            return (Criteria) this;
        }

        public Criteria andFromGreaterThanOrEqualTo(Integer value) {
            addCriterion("from >=", value, "from");
            return (Criteria) this;
        }

        public Criteria andFromLessThan(Integer value) {
            addCriterion("from <", value, "from");
            return (Criteria) this;
        }

        public Criteria andFromLessThanOrEqualTo(Integer value) {
            addCriterion("from <=", value, "from");
            return (Criteria) this;
        }

        public Criteria andFromIn(List<Integer> values) {
            addCriterion("from in", values, "from");
            return (Criteria) this;
        }

        public Criteria andFromNotIn(List<Integer> values) {
            addCriterion("from not in", values, "from");
            return (Criteria) this;
        }

        public Criteria andFromBetween(Integer value1, Integer value2) {
            addCriterion("from between", value1, value2, "from");
            return (Criteria) this;
        }

        public Criteria andFromNotBetween(Integer value1, Integer value2) {
            addCriterion("from not between", value1, value2, "from");
            return (Criteria) this;
        }

        public Criteria andToIsNull() {
            addCriterion("to is null");
            return (Criteria) this;
        }

        public Criteria andToIsNotNull() {
            addCriterion("to is not null");
            return (Criteria) this;
        }

        public Criteria andToEqualTo(Integer value) {
            addCriterion("to =", value, "to");
            return (Criteria) this;
        }

        public Criteria andToNotEqualTo(Integer value) {
            addCriterion("to <>", value, "to");
            return (Criteria) this;
        }

        public Criteria andToGreaterThan(Integer value) {
            addCriterion("to >", value, "to");
            return (Criteria) this;
        }

        public Criteria andToGreaterThanOrEqualTo(Integer value) {
            addCriterion("to >=", value, "to");
            return (Criteria) this;
        }

        public Criteria andToLessThan(Integer value) {
            addCriterion("to <", value, "to");
            return (Criteria) this;
        }

        public Criteria andToLessThanOrEqualTo(Integer value) {
            addCriterion("to <=", value, "to");
            return (Criteria) this;
        }

        public Criteria andToIn(List<Integer> values) {
            addCriterion("to in", values, "to");
            return (Criteria) this;
        }

        public Criteria andToNotIn(List<Integer> values) {
            addCriterion("to not in", values, "to");
            return (Criteria) this;
        }

        public Criteria andToBetween(Integer value1, Integer value2) {
            addCriterion("to between", value1, value2, "to");
            return (Criteria) this;
        }

        public Criteria andToNotBetween(Integer value1, Integer value2) {
            addCriterion("to not between", value1, value2, "to");
            return (Criteria) this;
        }

        public Criteria andContentIsNull() {
            addCriterion("content is null");
            return (Criteria) this;
        }

        public Criteria andContentIsNotNull() {
            addCriterion("content is not null");
            return (Criteria) this;
        }

        public Criteria andContentEqualTo(String value) {
            addCriterion("content =", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotEqualTo(String value) {
            addCriterion("content <>", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThan(String value) {
            addCriterion("content >", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThanOrEqualTo(String value) {
            addCriterion("content >=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThan(String value) {
            addCriterion("content <", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThanOrEqualTo(String value) {
            addCriterion("content <=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLike(String value) {
            addCriterion("content like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotLike(String value) {
            addCriterion("content not like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentIn(List<String> values) {
            addCriterion("content in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotIn(List<String> values) {
            addCriterion("content not in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentBetween(String value1, String value2) {
            addCriterion("content between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotBetween(String value1, String value2) {
            addCriterion("content not between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andExistIsNull() {
            addCriterion("exist is null");
            return (Criteria) this;
        }

        public Criteria andExistIsNotNull() {
            addCriterion("exist is not null");
            return (Criteria) this;
        }

        public Criteria andExistEqualTo(Boolean value) {
            addCriterion("exist =", value, "exist");
            return (Criteria) this;
        }

        public Criteria andExistNotEqualTo(Boolean value) {
            addCriterion("exist <>", value, "exist");
            return (Criteria) this;
        }

        public Criteria andExistGreaterThan(Boolean value) {
            addCriterion("exist >", value, "exist");
            return (Criteria) this;
        }

        public Criteria andExistGreaterThanOrEqualTo(Boolean value) {
            addCriterion("exist >=", value, "exist");
            return (Criteria) this;
        }

        public Criteria andExistLessThan(Boolean value) {
            addCriterion("exist <", value, "exist");
            return (Criteria) this;
        }

        public Criteria andExistLessThanOrEqualTo(Boolean value) {
            addCriterion("exist <=", value, "exist");
            return (Criteria) this;
        }

        public Criteria andExistIn(List<Boolean> values) {
            addCriterion("exist in", values, "exist");
            return (Criteria) this;
        }

        public Criteria andExistNotIn(List<Boolean> values) {
            addCriterion("exist not in", values, "exist");
            return (Criteria) this;
        }

        public Criteria andExistBetween(Boolean value1, Boolean value2) {
            addCriterion("exist between", value1, value2, "exist");
            return (Criteria) this;
        }

        public Criteria andExistNotBetween(Boolean value1, Boolean value2) {
            addCriterion("exist not between", value1, value2, "exist");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Long value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Long value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Long value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Long value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Long value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Long> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Long> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Long value1, Long value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Long value1, Long value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
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