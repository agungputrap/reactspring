package com.agung.agungtesting.domain;

import java.util.ArrayList;
import java.util.List;

public class PenggunaPeranExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table pengguna_peran
     *
     * @mbg.generated Mon Jul 02 02:49:41 ICT 2018
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table pengguna_peran
     *
     * @mbg.generated Mon Jul 02 02:49:41 ICT 2018
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table pengguna_peran
     *
     * @mbg.generated Mon Jul 02 02:49:41 ICT 2018
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pengguna_peran
     *
     * @mbg.generated Mon Jul 02 02:49:41 ICT 2018
     */
    public PenggunaPeranExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pengguna_peran
     *
     * @mbg.generated Mon Jul 02 02:49:41 ICT 2018
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pengguna_peran
     *
     * @mbg.generated Mon Jul 02 02:49:41 ICT 2018
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pengguna_peran
     *
     * @mbg.generated Mon Jul 02 02:49:41 ICT 2018
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pengguna_peran
     *
     * @mbg.generated Mon Jul 02 02:49:41 ICT 2018
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pengguna_peran
     *
     * @mbg.generated Mon Jul 02 02:49:41 ICT 2018
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pengguna_peran
     *
     * @mbg.generated Mon Jul 02 02:49:41 ICT 2018
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pengguna_peran
     *
     * @mbg.generated Mon Jul 02 02:49:41 ICT 2018
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pengguna_peran
     *
     * @mbg.generated Mon Jul 02 02:49:41 ICT 2018
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pengguna_peran
     *
     * @mbg.generated Mon Jul 02 02:49:41 ICT 2018
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pengguna_peran
     *
     * @mbg.generated Mon Jul 02 02:49:41 ICT 2018
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table pengguna_peran
     *
     * @mbg.generated Mon Jul 02 02:49:41 ICT 2018
     */
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

        public Criteria andIdPenggunaIsNull() {
            addCriterion("id_pengguna is null");
            return (Criteria) this;
        }

        public Criteria andIdPenggunaIsNotNull() {
            addCriterion("id_pengguna is not null");
            return (Criteria) this;
        }

        public Criteria andIdPenggunaEqualTo(Long value) {
            addCriterion("id_pengguna =", value, "idPengguna");
            return (Criteria) this;
        }

        public Criteria andIdPenggunaNotEqualTo(Long value) {
            addCriterion("id_pengguna <>", value, "idPengguna");
            return (Criteria) this;
        }

        public Criteria andIdPenggunaGreaterThan(Long value) {
            addCriterion("id_pengguna >", value, "idPengguna");
            return (Criteria) this;
        }

        public Criteria andIdPenggunaGreaterThanOrEqualTo(Long value) {
            addCriterion("id_pengguna >=", value, "idPengguna");
            return (Criteria) this;
        }

        public Criteria andIdPenggunaLessThan(Long value) {
            addCriterion("id_pengguna <", value, "idPengguna");
            return (Criteria) this;
        }

        public Criteria andIdPenggunaLessThanOrEqualTo(Long value) {
            addCriterion("id_pengguna <=", value, "idPengguna");
            return (Criteria) this;
        }

        public Criteria andIdPenggunaIn(List<Long> values) {
            addCriterion("id_pengguna in", values, "idPengguna");
            return (Criteria) this;
        }

        public Criteria andIdPenggunaNotIn(List<Long> values) {
            addCriterion("id_pengguna not in", values, "idPengguna");
            return (Criteria) this;
        }

        public Criteria andIdPenggunaBetween(Long value1, Long value2) {
            addCriterion("id_pengguna between", value1, value2, "idPengguna");
            return (Criteria) this;
        }

        public Criteria andIdPenggunaNotBetween(Long value1, Long value2) {
            addCriterion("id_pengguna not between", value1, value2, "idPengguna");
            return (Criteria) this;
        }

        public Criteria andIdPeranIsNull() {
            addCriterion("id_peran is null");
            return (Criteria) this;
        }

        public Criteria andIdPeranIsNotNull() {
            addCriterion("id_peran is not null");
            return (Criteria) this;
        }

        public Criteria andIdPeranEqualTo(Long value) {
            addCriterion("id_peran =", value, "idPeran");
            return (Criteria) this;
        }

        public Criteria andIdPeranNotEqualTo(Long value) {
            addCriterion("id_peran <>", value, "idPeran");
            return (Criteria) this;
        }

        public Criteria andIdPeranGreaterThan(Long value) {
            addCriterion("id_peran >", value, "idPeran");
            return (Criteria) this;
        }

        public Criteria andIdPeranGreaterThanOrEqualTo(Long value) {
            addCriterion("id_peran >=", value, "idPeran");
            return (Criteria) this;
        }

        public Criteria andIdPeranLessThan(Long value) {
            addCriterion("id_peran <", value, "idPeran");
            return (Criteria) this;
        }

        public Criteria andIdPeranLessThanOrEqualTo(Long value) {
            addCriterion("id_peran <=", value, "idPeran");
            return (Criteria) this;
        }

        public Criteria andIdPeranIn(List<Long> values) {
            addCriterion("id_peran in", values, "idPeran");
            return (Criteria) this;
        }

        public Criteria andIdPeranNotIn(List<Long> values) {
            addCriterion("id_peran not in", values, "idPeran");
            return (Criteria) this;
        }

        public Criteria andIdPeranBetween(Long value1, Long value2) {
            addCriterion("id_peran between", value1, value2, "idPeran");
            return (Criteria) this;
        }

        public Criteria andIdPeranNotBetween(Long value1, Long value2) {
            addCriterion("id_peran not between", value1, value2, "idPeran");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table pengguna_peran
     *
     * @mbg.generated do_not_delete_during_merge Mon Jul 02 02:49:41 ICT 2018
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table pengguna_peran
     *
     * @mbg.generated Mon Jul 02 02:49:41 ICT 2018
     */
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