package edu.jhu.fcriscu1.h2dev;


import lombok.extern.log4j.Log4j;
import org.jooq.*;
import org.jooq.impl.DSL;
import org.jooq.impl.DefaultConfiguration;

import org.nygenome.cdrn.nyc.sitestudy.h2.generated.tables.CohortStudyMeta;
import org.nygenome.cdrn.nyc.sitestudy.h2.generated.tables.records.CohortStudyMetaRecord;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.List;

/**
 * Created by fcriscuolo on 5/23/16.
 */
@Log4j
public class MetadataqueryTest {
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "org.h2.Driver";
  // connect using TCP connection
    static final String DB_URL = "jdbc:h2:tcp://localhost//data/cohort_study/h2db/cohortstudy;SCHEMA=COHORT_STUDY";
    //  Database credentials
    static final String USER = "cdrn";
    static final String PASS = "cdrn";
    public static void main(String[] args) {

        Statement stmt = null;
        try {
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String testSql = "select * from cohort_study";
        try{
           DSLContext context = CohortStudyContextService.INSTANCE.dslContext().get();

            context.select().from(CohortStudyMeta.COHORT_STUDY_META).where(CohortStudyMeta.COHORT_STUDY_META.PENDING.eq(true)
                        .and(CohortStudyMeta.COHORT_STUDY_META.STUDY_MAX_DAYS.ge(14)))
                    .stream().map((record) -> (CohortStudyMetaRecord) record)
                    .forEach((meta) ->System.out.println("Study code: " +meta.getStudyCode() + " " +meta.getStudyOriginContactInfo()));

            CohortStudyMetaRecord record = context.newRecord(org.nygenome.cdrn.nyc.sitestudy.h2.generated.tables.CohortStudyMeta.COHORT_STUDY_META);
            record.setPending(true);
            record.setStudyCode("Study_Code_25May2016");
            record.setStudyMaxDays(100);
            record.setStudyOriginContactInfo("John Smith, DNA Lab (212) 555-1212");
            record.setStudyOriginEmail("jsmith@gmail.com");
            record.setStudyOriginSiteCode("TEST_HS11");
            record.setStudySqlQuery("SELECT DISTINCT(patid) from encounter limit 100");
            record.setStudyType("SQL_QUERY");
            // store the record
            record.store();
            Long id = record.getCohortStudyId();
            log.info("CohortStudyMeta  row inserted id " +id.toString());
            // update an existing record
            CohortStudyMetaRecord meta2  =context.fetchOne(org.nygenome.cdrn.nyc.sitestudy.h2.generated.tables.CohortStudyMeta.COHORT_STUDY_META,
                    org.nygenome.cdrn.nyc.sitestudy.h2.generated.tables.CohortStudyMeta.COHORT_STUDY_META.COHORT_STUDY_ID.eq(1L));
            log.info("retrieved " + meta2.getStudyOriginContactInfo());
            meta2.setStudyOriginContactInfo("Patty Griffin, Hematology, WCMC");
            meta2.store();


        }catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();
        }
    }
}
