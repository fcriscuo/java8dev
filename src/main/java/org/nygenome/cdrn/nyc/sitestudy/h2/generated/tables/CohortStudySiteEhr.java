/**
 * This class is generated by jOOQ
 */
package org.nygenome.cdrn.nyc.sitestudy.h2.generated.tables;


import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.TableImpl;
import org.nygenome.cdrn.nyc.sitestudy.h2.generated.CohortStudy;
import org.nygenome.cdrn.nyc.sitestudy.h2.generated.Keys;
import org.nygenome.cdrn.nyc.sitestudy.h2.generated.tables.records.CohortStudySiteEhrRecord;


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
public class CohortStudySiteEhr extends TableImpl<CohortStudySiteEhrRecord> {

    private static final long serialVersionUID = -659283889;

    /**
     * The reference instance of <code>COHORT_STUDY.COHORT_STUDY_SITE_EHR</code>
     */
    public static final CohortStudySiteEhr COHORT_STUDY_SITE_EHR = new CohortStudySiteEhr();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<CohortStudySiteEhrRecord> getRecordType() {
        return CohortStudySiteEhrRecord.class;
    }

    /**
     * The column <code>COHORT_STUDY.COHORT_STUDY_SITE_EHR.SSS_ID</code>.
     */
    public final TableField<CohortStudySiteEhrRecord, String> SSS_ID = createField("SSS_ID", org.jooq.impl.SQLDataType.VARCHAR.length(200).nullable(false), this, "");

    /**
     * The column <code>COHORT_STUDY.COHORT_STUDY_SITE_EHR.EHR_ID</code>.
     */
    public final TableField<CohortStudySiteEhrRecord, String> EHR_ID = createField("EHR_ID", org.jooq.impl.SQLDataType.VARCHAR.length(100).nullable(false), this, "");

    /**
     * The column <code>COHORT_STUDY.COHORT_STUDY_SITE_EHR.COHORT_STUDY_SITE_ID</code>.
     */
    public final TableField<CohortStudySiteEhrRecord, Long> COHORT_STUDY_SITE_ID = createField("COHORT_STUDY_SITE_ID", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * Create a <code>COHORT_STUDY.COHORT_STUDY_SITE_EHR</code> table reference
     */
    public CohortStudySiteEhr() {
        this("COHORT_STUDY_SITE_EHR", null);
    }

    /**
     * Create an aliased <code>COHORT_STUDY.COHORT_STUDY_SITE_EHR</code> table reference
     */
    public CohortStudySiteEhr(String alias) {
        this(alias, COHORT_STUDY_SITE_EHR);
    }

    private CohortStudySiteEhr(String alias, Table<CohortStudySiteEhrRecord> aliased) {
        this(alias, aliased, null);
    }

    private CohortStudySiteEhr(String alias, Table<CohortStudySiteEhrRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, "");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return CohortStudy.COHORT_STUDY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<CohortStudySiteEhrRecord> getPrimaryKey() {
        return Keys.CONSTRAINT_5;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<CohortStudySiteEhrRecord>> getKeys() {
        return Arrays.<UniqueKey<CohortStudySiteEhrRecord>>asList(Keys.CONSTRAINT_5);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CohortStudySiteEhr as(String alias) {
        return new CohortStudySiteEhr(alias, this);
    }

    /**
     * Rename this table
     */
    public CohortStudySiteEhr rename(String name) {
        return new CohortStudySiteEhr(name, null);
    }
}
