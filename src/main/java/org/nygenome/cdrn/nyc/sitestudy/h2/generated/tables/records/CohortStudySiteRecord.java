/**
 * This class is generated by jOOQ
 */
package org.nygenome.cdrn.nyc.sitestudy.h2.generated.tables.records;


import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record3;
import org.jooq.Row3;
import org.jooq.impl.UpdatableRecordImpl;
import org.nygenome.cdrn.nyc.sitestudy.h2.generated.tables.CohortStudySite;


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
public class CohortStudySiteRecord extends UpdatableRecordImpl<CohortStudySiteRecord> implements Record3<Long, Long, String> {

    private static final long serialVersionUID = -791035783;

    /**
     * Setter for <code>COHORT_STUDY.COHORT_STUDY_SITE.COHORT_STUDY_SITE_ID</code>.
     */
    public void setCohortStudySiteId(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>COHORT_STUDY.COHORT_STUDY_SITE.COHORT_STUDY_SITE_ID</code>.
     */
    public Long getCohortStudySiteId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>COHORT_STUDY.COHORT_STUDY_SITE.COHORT_STUDY_ID</code>.
     */
    public void setCohortStudyId(Long value) {
        set(1, value);
    }

    /**
     * Getter for <code>COHORT_STUDY.COHORT_STUDY_SITE.COHORT_STUDY_ID</code>.
     */
    public Long getCohortStudyId() {
        return (Long) get(1);
    }

    /**
     * Setter for <code>COHORT_STUDY.COHORT_STUDY_SITE.SITE_CODE</code>.
     */
    public void setSiteCode(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>COHORT_STUDY.COHORT_STUDY_SITE.SITE_CODE</code>.
     */
    public String getSiteCode() {
        return (String) get(2);
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
    // Record3 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row3<Long, Long, String> fieldsRow() {
        return (Row3) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row3<Long, Long, String> valuesRow() {
        return (Row3) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field1() {
        return CohortStudySite.COHORT_STUDY_SITE.COHORT_STUDY_SITE_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field2() {
        return CohortStudySite.COHORT_STUDY_SITE.COHORT_STUDY_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return CohortStudySite.COHORT_STUDY_SITE.SITE_CODE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value1() {
        return getCohortStudySiteId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value2() {
        return getCohortStudyId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getSiteCode();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CohortStudySiteRecord value1(Long value) {
        setCohortStudySiteId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CohortStudySiteRecord value2(Long value) {
        setCohortStudyId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CohortStudySiteRecord value3(String value) {
        setSiteCode(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CohortStudySiteRecord values(Long value1, Long value2, String value3) {
        value1(value1);
        value2(value2);
        value3(value3);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached CohortStudySiteRecord
     */
    public CohortStudySiteRecord() {
        super(CohortStudySite.COHORT_STUDY_SITE);
    }

    /**
     * Create a detached, initialised CohortStudySiteRecord
     */
    public CohortStudySiteRecord(Long cohortStudySiteId, Long cohortStudyId, String siteCode) {
        super(CohortStudySite.COHORT_STUDY_SITE);

        set(0, cohortStudySiteId);
        set(1, cohortStudyId);
        set(2, siteCode);
    }
}
