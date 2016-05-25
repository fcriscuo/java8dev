/**
 * This class is generated by jOOQ
 */
package org.nygenome.cdrn.nyc.sitestudy.h2.generated.tables;


import java.sql.Date;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Identity;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.TableImpl;
import org.nygenome.cdrn.nyc.sitestudy.h2.generated.CohortStudy;
import org.nygenome.cdrn.nyc.sitestudy.h2.generated.Keys;
import org.nygenome.cdrn.nyc.sitestudy.h2.generated.tables.records.CohortStudyMetaRecord;


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
public class CohortStudyMeta extends TableImpl<CohortStudyMetaRecord> {

    private static final long serialVersionUID = -288716902;

    /**
     * The reference instance of <code>COHORT_STUDY.COHORT_STUDY_META</code>
     */
    public static final CohortStudyMeta COHORT_STUDY_META = new CohortStudyMeta();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<CohortStudyMetaRecord> getRecordType() {
        return CohortStudyMetaRecord.class;
    }

    /**
     * The column <code>COHORT_STUDY.COHORT_STUDY_META.COHORT_STUDY_ID</code>.
     */
    public final TableField<CohortStudyMetaRecord, Long> COHORT_STUDY_ID = createField("COHORT_STUDY_ID", org.jooq.impl.SQLDataType.BIGINT.nullable(false).defaultValue(org.jooq.impl.DSL.field("(NEXT VALUE FOR COHORT_STUDY.SYSTEM_SEQUENCE_FB792871_2314_4592_892A_79BB856C458E)", org.jooq.impl.SQLDataType.BIGINT)), this, "");

    /**
     * The column <code>COHORT_STUDY.COHORT_STUDY_META.STUDY_ID</code>.
     */
    public final TableField<CohortStudyMetaRecord, String> STUDY_ID = createField("STUDY_ID", org.jooq.impl.SQLDataType.VARCHAR.length(60), this, "");

    /**
     * The column <code>COHORT_STUDY.COHORT_STUDY_META.STUDY_CODE</code>.
     */
    public final TableField<CohortStudyMetaRecord, String> STUDY_CODE = createField("STUDY_CODE", org.jooq.impl.SQLDataType.VARCHAR.length(40), this, "");

    /**
     * The column <code>COHORT_STUDY.COHORT_STUDY_META.STUDY_ORIGIN_SITE_CODE</code>.
     */
    public final TableField<CohortStudyMetaRecord, String> STUDY_ORIGIN_SITE_CODE = createField("STUDY_ORIGIN_SITE_CODE", org.jooq.impl.SQLDataType.VARCHAR.length(12).nullable(false), this, "");

    /**
     * The column <code>COHORT_STUDY.COHORT_STUDY_META.STUDY_ORIGIN_CONTACT_INFO</code>.
     */
    public final TableField<CohortStudyMetaRecord, String> STUDY_ORIGIN_CONTACT_INFO = createField("STUDY_ORIGIN_CONTACT_INFO", org.jooq.impl.SQLDataType.VARCHAR.length(128).nullable(false), this, "");

    /**
     * The column <code>COHORT_STUDY.COHORT_STUDY_META.STUDY_ORIGIN_EMAIL</code>.
     */
    public final TableField<CohortStudyMetaRecord, String> STUDY_ORIGIN_EMAIL = createField("STUDY_ORIGIN_EMAIL", org.jooq.impl.SQLDataType.VARCHAR.length(40).nullable(false), this, "");

    /**
     * The column <code>COHORT_STUDY.COHORT_STUDY_META.STUDY_TYPE</code>.
     */
    public final TableField<CohortStudyMetaRecord, String> STUDY_TYPE = createField("STUDY_TYPE", org.jooq.impl.SQLDataType.VARCHAR.length(20).nullable(false), this, "");

    /**
     * The column <code>COHORT_STUDY.COHORT_STUDY_META.STUDY_REG_DATE</code>.
     */
    public final TableField<CohortStudyMetaRecord, Date> STUDY_REG_DATE = createField("STUDY_REG_DATE", org.jooq.impl.SQLDataType.DATE.defaultValue(org.jooq.impl.DSL.field("CURRENT_DATE()", org.jooq.impl.SQLDataType.DATE)), this, "");

    /**
     * The column <code>COHORT_STUDY.COHORT_STUDY_META.STUDY_MAX_DAYS</code>.
     */
    public final TableField<CohortStudyMetaRecord, Integer> STUDY_MAX_DAYS = createField("STUDY_MAX_DAYS", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>COHORT_STUDY.COHORT_STUDY_META.PENDING</code>.
     */
    public final TableField<CohortStudyMetaRecord, Boolean> PENDING = createField("PENDING", org.jooq.impl.SQLDataType.BOOLEAN.defaultValue(org.jooq.impl.DSL.field("TRUE", org.jooq.impl.SQLDataType.BOOLEAN)), this, "");

    /**
     * The column <code>COHORT_STUDY.COHORT_STUDY_META.STUDY_SQL_QUERY</code>.
     */
    public final TableField<CohortStudyMetaRecord, String> STUDY_SQL_QUERY = createField("STUDY_SQL_QUERY", org.jooq.impl.SQLDataType.VARCHAR.length(256), this, "");

    /**
     * Create a <code>COHORT_STUDY.COHORT_STUDY_META</code> table reference
     */
    public CohortStudyMeta() {
        this("COHORT_STUDY_META", null);
    }

    /**
     * Create an aliased <code>COHORT_STUDY.COHORT_STUDY_META</code> table reference
     */
    public CohortStudyMeta(String alias) {
        this(alias, COHORT_STUDY_META);
    }

    private CohortStudyMeta(String alias, Table<CohortStudyMetaRecord> aliased) {
        this(alias, aliased, null);
    }

    private CohortStudyMeta(String alias, Table<CohortStudyMetaRecord> aliased, Field<?>[] parameters) {
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
    public Identity<CohortStudyMetaRecord, Long> getIdentity() {
        return Keys.IDENTITY_COHORT_STUDY_META;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<CohortStudyMetaRecord> getPrimaryKey() {
        return Keys.CONSTRAINT_E;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<CohortStudyMetaRecord>> getKeys() {
        return Arrays.<UniqueKey<CohortStudyMetaRecord>>asList(Keys.CONSTRAINT_E);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CohortStudyMeta as(String alias) {
        return new CohortStudyMeta(alias, this);
    }

    /**
     * Rename this table
     */
    public CohortStudyMeta rename(String name) {
        return new CohortStudyMeta(name, null);
    }
}
