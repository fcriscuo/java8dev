/**
 * This class is generated by jOOQ
 */
package org.nygenome.cdrn.nyc.sitestudy.h2.generated;


import javax.annotation.Generated;

import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.UniqueKey;
import org.jooq.impl.AbstractKeys;
import org.nygenome.cdrn.nyc.sitestudy.h2.generated.tables.CohortStudyMeta;
import org.nygenome.cdrn.nyc.sitestudy.h2.generated.tables.CohortStudyPatient;
import org.nygenome.cdrn.nyc.sitestudy.h2.generated.tables.CohortStudySite;
import org.nygenome.cdrn.nyc.sitestudy.h2.generated.tables.CohortStudySiteEhr;
import org.nygenome.cdrn.nyc.sitestudy.h2.generated.tables.records.CohortStudyMetaRecord;
import org.nygenome.cdrn.nyc.sitestudy.h2.generated.tables.records.CohortStudyPatientRecord;
import org.nygenome.cdrn.nyc.sitestudy.h2.generated.tables.records.CohortStudySiteEhrRecord;
import org.nygenome.cdrn.nyc.sitestudy.h2.generated.tables.records.CohortStudySiteRecord;


/**
 * A class modelling foreign key relationships between tables of the <code>COHORT_STUDY</code> 
 * schema
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.8.1"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

    // -------------------------------------------------------------------------
    // IDENTITY definitions
    // -------------------------------------------------------------------------

    public static final Identity<CohortStudyMetaRecord, Long> IDENTITY_COHORT_STUDY_META = Identities0.IDENTITY_COHORT_STUDY_META;
    public static final Identity<CohortStudySiteRecord, Long> IDENTITY_COHORT_STUDY_SITE = Identities0.IDENTITY_COHORT_STUDY_SITE;

    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<CohortStudyMetaRecord> CONSTRAINT_E = UniqueKeys0.CONSTRAINT_E;
    public static final UniqueKey<CohortStudyPatientRecord> CONSTRAINT_1 = UniqueKeys0.CONSTRAINT_1;
    public static final UniqueKey<CohortStudySiteEhrRecord> CONSTRAINT_5 = UniqueKeys0.CONSTRAINT_5;
    public static final UniqueKey<CohortStudySiteRecord> CONSTRAINT_E1 = UniqueKeys0.CONSTRAINT_E1;

    // -------------------------------------------------------------------------
    // FOREIGN KEY definitions
    // -------------------------------------------------------------------------

    public static final ForeignKey<CohortStudyPatientRecord, CohortStudyMetaRecord> CONSTRAINT_14 = ForeignKeys0.CONSTRAINT_14;
    public static final ForeignKey<CohortStudySiteEhrRecord, CohortStudyPatientRecord> CONSTRAINT_5D2 = ForeignKeys0.CONSTRAINT_5D2;
    public static final ForeignKey<CohortStudySiteRecord, CohortStudyMetaRecord> CONSTRAINT_E13 = ForeignKeys0.CONSTRAINT_E13;

    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class Identities0 extends AbstractKeys {
        public static Identity<CohortStudyMetaRecord, Long> IDENTITY_COHORT_STUDY_META = createIdentity(CohortStudyMeta.COHORT_STUDY_META, CohortStudyMeta.COHORT_STUDY_META.COHORT_STUDY_ID);
        public static Identity<CohortStudySiteRecord, Long> IDENTITY_COHORT_STUDY_SITE = createIdentity(CohortStudySite.COHORT_STUDY_SITE, CohortStudySite.COHORT_STUDY_SITE.COHORT_STUDY_SITE_ID);
    }

    private static class UniqueKeys0 extends AbstractKeys {
        public static final UniqueKey<CohortStudyMetaRecord> CONSTRAINT_E = createUniqueKey(CohortStudyMeta.COHORT_STUDY_META, "CONSTRAINT_E", CohortStudyMeta.COHORT_STUDY_META.COHORT_STUDY_ID);
        public static final UniqueKey<CohortStudyPatientRecord> CONSTRAINT_1 = createUniqueKey(CohortStudyPatient.COHORT_STUDY_PATIENT, "CONSTRAINT_1", CohortStudyPatient.COHORT_STUDY_PATIENT.SS_ID);
        public static final UniqueKey<CohortStudySiteEhrRecord> CONSTRAINT_5 = createUniqueKey(CohortStudySiteEhr.COHORT_STUDY_SITE_EHR, "CONSTRAINT_5", CohortStudySiteEhr.COHORT_STUDY_SITE_EHR.SSS_ID);
        public static final UniqueKey<CohortStudySiteRecord> CONSTRAINT_E1 = createUniqueKey(CohortStudySite.COHORT_STUDY_SITE, "CONSTRAINT_E1", CohortStudySite.COHORT_STUDY_SITE.COHORT_STUDY_SITE_ID);
    }

    private static class ForeignKeys0 extends AbstractKeys {
        public static final ForeignKey<CohortStudyPatientRecord, CohortStudyMetaRecord> CONSTRAINT_14 = createForeignKey(org.nygenome.cdrn.nyc.sitestudy.h2.generated.Keys.CONSTRAINT_E, CohortStudyPatient.COHORT_STUDY_PATIENT, "CONSTRAINT_14", CohortStudyPatient.COHORT_STUDY_PATIENT.COHORT_STUDY_ID);
        public static final ForeignKey<CohortStudySiteEhrRecord, CohortStudyPatientRecord> CONSTRAINT_5D2 = createForeignKey(org.nygenome.cdrn.nyc.sitestudy.h2.generated.Keys.CONSTRAINT_1, CohortStudySiteEhr.COHORT_STUDY_SITE_EHR, "CONSTRAINT_5D2", CohortStudySiteEhr.COHORT_STUDY_SITE_EHR.SS_ID);
        public static final ForeignKey<CohortStudySiteRecord, CohortStudyMetaRecord> CONSTRAINT_E13 = createForeignKey(org.nygenome.cdrn.nyc.sitestudy.h2.generated.Keys.CONSTRAINT_E, CohortStudySite.COHORT_STUDY_SITE, "CONSTRAINT_E13", CohortStudySite.COHORT_STUDY_SITE.COHORT_STUDY_ID);
    }
}
