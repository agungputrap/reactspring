package com.agung.agungtesting.domain;

import java.util.ArrayList;
import java.util.List;

public class CustomerExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table customer
     *
     * @mbg.generated Mon Jul 02 02:49:41 ICT 2018
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table customer
     *
     * @mbg.generated Mon Jul 02 02:49:41 ICT 2018
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table customer
     *
     * @mbg.generated Mon Jul 02 02:49:41 ICT 2018
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table customer
     *
     * @mbg.generated Mon Jul 02 02:49:41 ICT 2018
     */
    public CustomerExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table customer
     *
     * @mbg.generated Mon Jul 02 02:49:41 ICT 2018
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table customer
     *
     * @mbg.generated Mon Jul 02 02:49:41 ICT 2018
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table customer
     *
     * @mbg.generated Mon Jul 02 02:49:41 ICT 2018
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table customer
     *
     * @mbg.generated Mon Jul 02 02:49:41 ICT 2018
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table customer
     *
     * @mbg.generated Mon Jul 02 02:49:41 ICT 2018
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table customer
     *
     * @mbg.generated Mon Jul 02 02:49:41 ICT 2018
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table customer
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
     * This method corresponds to the database table customer
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
     * This method corresponds to the database table customer
     *
     * @mbg.generated Mon Jul 02 02:49:41 ICT 2018
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table customer
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
     * This class corresponds to the database table customer
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andNamaIsNull() {
            addCriterion("nama is null");
            return (Criteria) this;
        }

        public Criteria andNamaIsNotNull() {
            addCriterion("nama is not null");
            return (Criteria) this;
        }

        public Criteria andNamaEqualTo(String value) {
            addCriterion("nama =", value, "nama");
            return (Criteria) this;
        }

        public Criteria andNamaNotEqualTo(String value) {
            addCriterion("nama <>", value, "nama");
            return (Criteria) this;
        }

        public Criteria andNamaGreaterThan(String value) {
            addCriterion("nama >", value, "nama");
            return (Criteria) this;
        }

        public Criteria andNamaGreaterThanOrEqualTo(String value) {
            addCriterion("nama >=", value, "nama");
            return (Criteria) this;
        }

        public Criteria andNamaLessThan(String value) {
            addCriterion("nama <", value, "nama");
            return (Criteria) this;
        }

        public Criteria andNamaLessThanOrEqualTo(String value) {
            addCriterion("nama <=", value, "nama");
            return (Criteria) this;
        }

        public Criteria andNamaLike(String value) {
            addCriterion("nama like", value, "nama");
            return (Criteria) this;
        }

        public Criteria andNamaNotLike(String value) {
            addCriterion("nama not like", value, "nama");
            return (Criteria) this;
        }

        public Criteria andNamaIn(List<String> values) {
            addCriterion("nama in", values, "nama");
            return (Criteria) this;
        }

        public Criteria andNamaNotIn(List<String> values) {
            addCriterion("nama not in", values, "nama");
            return (Criteria) this;
        }

        public Criteria andNamaBetween(String value1, String value2) {
            addCriterion("nama between", value1, value2, "nama");
            return (Criteria) this;
        }

        public Criteria andNamaNotBetween(String value1, String value2) {
            addCriterion("nama not between", value1, value2, "nama");
            return (Criteria) this;
        }

        public Criteria andBankIsNull() {
            addCriterion("bank is null");
            return (Criteria) this;
        }

        public Criteria andBankIsNotNull() {
            addCriterion("bank is not null");
            return (Criteria) this;
        }

        public Criteria andBankEqualTo(String value) {
            addCriterion("bank =", value, "bank");
            return (Criteria) this;
        }

        public Criteria andBankNotEqualTo(String value) {
            addCriterion("bank <>", value, "bank");
            return (Criteria) this;
        }

        public Criteria andBankGreaterThan(String value) {
            addCriterion("bank >", value, "bank");
            return (Criteria) this;
        }

        public Criteria andBankGreaterThanOrEqualTo(String value) {
            addCriterion("bank >=", value, "bank");
            return (Criteria) this;
        }

        public Criteria andBankLessThan(String value) {
            addCriterion("bank <", value, "bank");
            return (Criteria) this;
        }

        public Criteria andBankLessThanOrEqualTo(String value) {
            addCriterion("bank <=", value, "bank");
            return (Criteria) this;
        }

        public Criteria andBankLike(String value) {
            addCriterion("bank like", value, "bank");
            return (Criteria) this;
        }

        public Criteria andBankNotLike(String value) {
            addCriterion("bank not like", value, "bank");
            return (Criteria) this;
        }

        public Criteria andBankIn(List<String> values) {
            addCriterion("bank in", values, "bank");
            return (Criteria) this;
        }

        public Criteria andBankNotIn(List<String> values) {
            addCriterion("bank not in", values, "bank");
            return (Criteria) this;
        }

        public Criteria andBankBetween(String value1, String value2) {
            addCriterion("bank between", value1, value2, "bank");
            return (Criteria) this;
        }

        public Criteria andBankNotBetween(String value1, String value2) {
            addCriterion("bank not between", value1, value2, "bank");
            return (Criteria) this;
        }

        public Criteria andRekeningIsNull() {
            addCriterion("rekening is null");
            return (Criteria) this;
        }

        public Criteria andRekeningIsNotNull() {
            addCriterion("rekening is not null");
            return (Criteria) this;
        }

        public Criteria andRekeningEqualTo(String value) {
            addCriterion("rekening =", value, "rekening");
            return (Criteria) this;
        }

        public Criteria andRekeningNotEqualTo(String value) {
            addCriterion("rekening <>", value, "rekening");
            return (Criteria) this;
        }

        public Criteria andRekeningGreaterThan(String value) {
            addCriterion("rekening >", value, "rekening");
            return (Criteria) this;
        }

        public Criteria andRekeningGreaterThanOrEqualTo(String value) {
            addCriterion("rekening >=", value, "rekening");
            return (Criteria) this;
        }

        public Criteria andRekeningLessThan(String value) {
            addCriterion("rekening <", value, "rekening");
            return (Criteria) this;
        }

        public Criteria andRekeningLessThanOrEqualTo(String value) {
            addCriterion("rekening <=", value, "rekening");
            return (Criteria) this;
        }

        public Criteria andRekeningLike(String value) {
            addCriterion("rekening like", value, "rekening");
            return (Criteria) this;
        }

        public Criteria andRekeningNotLike(String value) {
            addCriterion("rekening not like", value, "rekening");
            return (Criteria) this;
        }

        public Criteria andRekeningIn(List<String> values) {
            addCriterion("rekening in", values, "rekening");
            return (Criteria) this;
        }

        public Criteria andRekeningNotIn(List<String> values) {
            addCriterion("rekening not in", values, "rekening");
            return (Criteria) this;
        }

        public Criteria andRekeningBetween(String value1, String value2) {
            addCriterion("rekening between", value1, value2, "rekening");
            return (Criteria) this;
        }

        public Criteria andRekeningNotBetween(String value1, String value2) {
            addCriterion("rekening not between", value1, value2, "rekening");
            return (Criteria) this;
        }

        public Criteria andIbanCodeIsNull() {
            addCriterion("iban_code is null");
            return (Criteria) this;
        }

        public Criteria andIbanCodeIsNotNull() {
            addCriterion("iban_code is not null");
            return (Criteria) this;
        }

        public Criteria andIbanCodeEqualTo(String value) {
            addCriterion("iban_code =", value, "ibanCode");
            return (Criteria) this;
        }

        public Criteria andIbanCodeNotEqualTo(String value) {
            addCriterion("iban_code <>", value, "ibanCode");
            return (Criteria) this;
        }

        public Criteria andIbanCodeGreaterThan(String value) {
            addCriterion("iban_code >", value, "ibanCode");
            return (Criteria) this;
        }

        public Criteria andIbanCodeGreaterThanOrEqualTo(String value) {
            addCriterion("iban_code >=", value, "ibanCode");
            return (Criteria) this;
        }

        public Criteria andIbanCodeLessThan(String value) {
            addCriterion("iban_code <", value, "ibanCode");
            return (Criteria) this;
        }

        public Criteria andIbanCodeLessThanOrEqualTo(String value) {
            addCriterion("iban_code <=", value, "ibanCode");
            return (Criteria) this;
        }

        public Criteria andIbanCodeLike(String value) {
            addCriterion("iban_code like", value, "ibanCode");
            return (Criteria) this;
        }

        public Criteria andIbanCodeNotLike(String value) {
            addCriterion("iban_code not like", value, "ibanCode");
            return (Criteria) this;
        }

        public Criteria andIbanCodeIn(List<String> values) {
            addCriterion("iban_code in", values, "ibanCode");
            return (Criteria) this;
        }

        public Criteria andIbanCodeNotIn(List<String> values) {
            addCriterion("iban_code not in", values, "ibanCode");
            return (Criteria) this;
        }

        public Criteria andIbanCodeBetween(String value1, String value2) {
            addCriterion("iban_code between", value1, value2, "ibanCode");
            return (Criteria) this;
        }

        public Criteria andIbanCodeNotBetween(String value1, String value2) {
            addCriterion("iban_code not between", value1, value2, "ibanCode");
            return (Criteria) this;
        }

        public Criteria andIdPenggunaIsNull() {
            addCriterion("id_pengguna is null");
            return (Criteria) this;
        }

        public Criteria andIdPenggunaIsNotNull() {
            addCriterion("id_pengguna is not null");
            return (Criteria) this;
        }

        public Criteria andIdPenggunaEqualTo(Integer value) {
            addCriterion("id_pengguna =", value, "idPengguna");
            return (Criteria) this;
        }

        public Criteria andIdPenggunaNotEqualTo(Integer value) {
            addCriterion("id_pengguna <>", value, "idPengguna");
            return (Criteria) this;
        }

        public Criteria andIdPenggunaGreaterThan(Integer value) {
            addCriterion("id_pengguna >", value, "idPengguna");
            return (Criteria) this;
        }

        public Criteria andIdPenggunaGreaterThanOrEqualTo(Integer value) {
            addCriterion("id_pengguna >=", value, "idPengguna");
            return (Criteria) this;
        }

        public Criteria andIdPenggunaLessThan(Integer value) {
            addCriterion("id_pengguna <", value, "idPengguna");
            return (Criteria) this;
        }

        public Criteria andIdPenggunaLessThanOrEqualTo(Integer value) {
            addCriterion("id_pengguna <=", value, "idPengguna");
            return (Criteria) this;
        }

        public Criteria andIdPenggunaIn(List<Integer> values) {
            addCriterion("id_pengguna in", values, "idPengguna");
            return (Criteria) this;
        }

        public Criteria andIdPenggunaNotIn(List<Integer> values) {
            addCriterion("id_pengguna not in", values, "idPengguna");
            return (Criteria) this;
        }

        public Criteria andIdPenggunaBetween(Integer value1, Integer value2) {
            addCriterion("id_pengguna between", value1, value2, "idPengguna");
            return (Criteria) this;
        }

        public Criteria andIdPenggunaNotBetween(Integer value1, Integer value2) {
            addCriterion("id_pengguna not between", value1, value2, "idPengguna");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table customer
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
     * This class corresponds to the database table customer
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