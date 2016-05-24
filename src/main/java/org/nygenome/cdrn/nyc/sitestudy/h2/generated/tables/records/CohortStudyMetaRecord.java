/**
 * This class is generated by jOOQ
 */
package org.nygenome.cdrn.nyc.sitestudy.h2.generated.tables.records;


import java.sql.Date;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record11;
import org.jooq.Row11;
import org.jooq.impl.UpdatableRecordImpl;
import org.nygenome.cdrn.nyc.sitestudy.h2.generated.tables.CohortStudyMeta;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.8.1"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class CohortStudyMetaRecord extends UpdatableRecordImpl<CohortStudyMetaRecord> implements Record11<Long, String, String, String, String, String, String, Date, Integer, String, Boolean> {

    private static final long serialVersionUID = -1199108928;

    /**
     * Setter for <code>COHORT_STUDY.COHORT_STUDY_META.COHORT_STUDY_ID</code>.
     */
    public void setCohortStudyId(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>COHORT_STUDY.COHORT_STUDY_META.COHORT_STUDY_ID</code>.
     */
    public Long getCohortStudyId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>COHORT_STUDY.COHORT_STUDY_META.STUDY_ID</code>.
     */
    public void setStudyId(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>COHORT_STUDY.COHORT_STUDY_META.STUDY_ID</code>.
     */
    public String getStudyId() {
        return (String) get(1);
    }

    /**
     * Setter for <code>COHORT_STUDY.COHORT_STUDY_META.STUDY_CODE</code>.
     */
    public void setStudyCode(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>COHORT_STUDY.COHORT_STUDY_META.STUDY_CODE</code>.
     */
    public String getStudyCode() {
        return (String) get(2);
    }

    /**
     * Setter for <code>COHORT_STUDY.COHORT_STUDY_META.STUDY_ORIGIN_SITE_CODE</code>.
     */
    public void setStudyOriginSiteCode(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>COHORT_STUDY.COHORT_STUDY_META.STUDY_ORIGIN_SITE_CODE</code>.
     */
    public String getStudyOriginSiteCode() {
        return (String) get(3);
    }

    /**
     * Setter for <code>COHORT_STUDY.COHORT_STUDY_META.STUDY_ORIGIN_CONTACT_INFO</code>.
     */
    public void setStudyOriginContactInfo(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>COHORT_STUDY.COHORT_STUDY_META.STUDY_ORIGIN_CONTACT_INFO</code>.
     */
    public String getStudyOriginContactInfo() {
        return (String) get(4);
    }

    /**
     * Setter for <code>COHORT_STUDY.COHORT_STUDY_META.STUDY_ORIGIN_EMAIL</code>.
     */
    public void setStudyOriginEmail(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>COHORT_STUDY.COHORT_STUDY_META.STUDY_ORIGIN_EMAIL</code>.
     */
    public String getStudyOriginEmail() {
        return (String) get(5);
    }

    /**
     * Setter for <code>COHORT_STUDY.COHORT_STUDY_META.STUDY_TYPE</code>.
     */
    public void setStudyType(String value) {
        set(6, value);
    }

    /**
     * Getter for <code>COHORT_STUDY.COHORT_STUDY_META.STUDY_TYPE</code>.
     */
    public String getStudyType() {
        return (String) get(6);
    }

    /**
     * Setter for <code>COHORT_STUDY.COHORT_STUDY_META.STUDY_REG_DATE</code>.
     */
    public void setStudyRegDate(Date value) {
        set(7, value);
    }

    /**
     * Getter for <code>COHORT_STUDY.COHORT_STUDY_META.STUDY_REG_DATE</code>.
     */
    public Date getStudyRegDate() {
        return (Date) get(7);
    }

    /**
     * Setter for <code>COHORT_STUDY.COHORT_STUDY_META.STUDY_MAX_DAYS</code>.
     */
    public void setStudyMaxDays(Integer value) {
        set(8, value);
    }

    /**
     * Getter for <code>COHORT_STUDY.COHORT_STUDY_META.STUDY_MAX_DAYS</code>.
     */
    public Integer getStudyMaxDays() {
        return (Integer) get(8);
    }

    /**
     * Setter for <code>COHORT_STUDY.COHORT_STUDY_META.STUDY_SQL_QUERY</code>.
     */
    public void setStudySqlQuery(String value) {
        set(9, value);
    }

    /**
     * Getter for <code>COHORT_STUDY.COHORT_STUDY_META.STUDY_SQL_QUERY</code>.
     */
    public String getStudySqlQuery() {
        return (String) get(9);
    }

    /**
     * Setter for <code>COHORT_STUDY.COHORT_STUDY_META.PENDING</code>.
     */
    public void setPending(Boolean value) {
        set(10, value);
    }

    /**
     * Getter for <code>COHORT_STUDY.COHORT_STUDY_META.PENDING</code>.
     */
    public Boolean getPending() {
        return (Boolean) get(10);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record11 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row11<Long, String, String, String, String, String, String, Date, Integer, String, Boolean> fieldsRow() {
        return (Row11) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row11<Long, String, String, String, String, String, String, Date, Integer, String, Boolean> valuesRow() {
        return (Row11) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field1() {
        return CohortStudyMeta.COHORT_STUDY_META.COHORT_STUDY_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return CohortStudyMeta.COHORT_STUDY_META.STUDY_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return CohortStudyMeta.COHORT_STUDY_META.STUDY_CODE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field4() {
        return CohortStudyMeta.COHORT_STUDY_META.STUDY_ORIGIN_SITE_CODE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field5() {
        return CohortStudyMeta.COHORT_STUDY_META.STUDY_ORIGIN_CONTACT_INFO;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field6() {
        return CohortStudyMeta.COHORT_STUDY_META.STUDY_ORIGIN_EMAIL;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field7() {
        return CohortStudyMeta.COHORT_STUDY_META.STUDY_TYPE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Date> field8() {
        return CohortStudyMeta.COHORT_STUDY_META.STUDY_REG_DATE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field9() {
        return CohortStudyMeta.COHORT_STUDY_META.STUDY_MAX_DAYS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field10() {
        return CohortStudyMeta.COHORT_STUDY_META.STUDY_SQL_QUERY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Boolean> field11() {
        return CohortStudyMeta.COHORT_STUDY_META.PENDING;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value1() {
        return getCohortStudyId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getStudyId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getStudyCode();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value4() {
        return getStudyOriginSiteCode();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value5() {
        return getStudyOriginContactInfo();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value6() {
        return getStudyOriginEmail();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value7() {
        return getStudyType();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Date value8() {
        return getStudyRegDate();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value9() {
        return getStudyMaxDays();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value10() {
        return getStudySqlQuery();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean value11() {
        return getPending();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CohortStudyMetaRecord value1(Long value) {
        setCohortStudyId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CohortStudyMetaRecord value2(String value) {
        setStudyId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CohortStudyMetaRecord value3(String value) {
        setStudyCode(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CohortStudyMetaRecord value4(String value) {
        setStudyOriginSiteCode(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CohortStudyMetaRecord value5(String value) {
        setStudyOriginContactInfo(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CohortStudyMetaRecord value6(String value) {
        setStudyOriginEmail(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CohortStudyMetaRecord value7(String value) {
        setStudyType(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CohortStudyMetaRecord value8(Date value) {
        setStudyRegDate(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CohortStudyMetaRecord value9(Integer value) {
        setStudyMaxDays(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CohortStudyMetaRecord value10(String value) {
        setStudySqlQuery(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CohortStudyMetaRecord value11(Boolean value) {
        setPending(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CohortStudyMetaRecord values(Long value1, String value2, String value3, String value4, String value5, String value6, String value7, Date value8, Integer value9, String value10, Boolean value11) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        value10(value10);
        value11(value11);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached CohortStudyMetaRecord
     */
    public CohortStudyMetaRecord() {
        super(CohortStudyMeta.COHORT_STUDY_META);
    }

    /**
     * Create a detached, initialised CohortStudyMetaRecord
     */
    public CohortStudyMetaRecord(Long cohortStudyId, String studyId, String studyCode, String studyOriginSiteCode, String studyOriginContactInfo, String studyOriginEmail, String studyType, Date studyRegDate, Integer studyMaxDays, String studySqlQuery, Boolean pending) {
        super(CohortStudyMeta.COHORT_STUDY_META);

        set(0, cohortStudyId);
        set(1, studyId);
        set(2, studyCode);
        set(3, studyOriginSiteCode);
        set(4, studyOriginContactInfo);
        set(5, studyOriginEmail);
        set(6, studyType);
        set(7, studyRegDate);
        set(8, studyMaxDays);
        set(9, studySqlQuery);
        set(10, pending);
    }
}
