package edu.jhu.fcriscu1.h2dev;


import lombok.extern.log4j.Log4j;
import org.jooq.*;
import org.jooq.impl.DSL;
import org.jooq.impl.DefaultConfiguration;

import org.nygenome.cdrn.nyc.sitestudy.h2.generated.tables.daos.CohortStudyMetaDao;
import org.nygenome.cdrn.nyc.sitestudy.h2.generated.tables.pojos.CohortStudyMeta;
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
        try( Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);){
            Configuration configuration = new DefaultConfiguration().set(conn).set(SQLDialect.H2);
            CohortStudyMetaDao metaDao = new CohortStudyMetaDao(configuration);
           List<CohortStudyMeta> metaList= metaDao.fetchByPending(true);
            log.info("Found " +metaList.size() +" pending cohort studies");
            metaList.stream().forEach( (md) -> log.info (md.toString()));
            DSLContext create = DSL.using(conn, SQLDialect.H2);
            CohortStudyMetaRecord record = create.newRecord(org.nygenome.cdrn.nyc.sitestudy.h2.generated.tables.CohortStudyMeta.COHORT_STUDY_META);

            record.setPending(true);
            record.setStudyCode("Study_Code_24May2016");
            record.setStudyMaxDays(0);
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
            CohortStudyMetaRecord meta2  =create.fetchOne(org.nygenome.cdrn.nyc.sitestudy.h2.generated.tables.CohortStudyMeta.COHORT_STUDY_META,
                    org.nygenome.cdrn.nyc.sitestudy.h2.generated.tables.CohortStudyMeta.COHORT_STUDY_META.COHORT_STUDY_ID.eq(1L));
            log.info("retrieved " + meta2.getStudyOriginContactInfo());
            meta2.setStudyOriginContactInfo("Mary Hopkins, Hematology, Cornell");
            meta2.store();


        }catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();
        }
    }
}
