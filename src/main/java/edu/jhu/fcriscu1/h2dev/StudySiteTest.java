package edu.jhu.fcriscu1.h2dev;


import lombok.extern.log4j.Log4j;
import org.jooq.*;
import org.jooq.impl.DSL;
import org.jooq.impl.DefaultConfiguration;
import org.nygenome.cdrn.nyc.sitestudy.h2.generated.Keys;
import org.nygenome.cdrn.nyc.sitestudy.h2.generated.tables.CohortStudySite;
import org.nygenome.cdrn.nyc.sitestudy.h2.generated.tables.records.CohortStudySiteRecord;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * Created by fcriscuolo on 5/23/16.
 */
@Log4j
public class StudySiteTest {
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

        try( Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);){
            // create some cohort_study_site records
            DSLContext create = DSL.using(conn, SQLDialect.H2);
            CohortStudySiteRecord ss1 = create.newRecord(CohortStudySite.COHORT_STUDY_SITE);
            ss1.setCohortStudyId(1L);
            ss1.setSiteCode("TEST_HS3");
            ss1.store();
            Long id1 = ss1.getCohortStudySiteId();
            CohortStudySiteRecord ss2 = create.newRecord(CohortStudySite.COHORT_STUDY_SITE);
            ss2.setCohortStudyId(1L);
            ss2.setSiteCode("TEST_HS4");
            ss2.store();
            Long id2 = ss2.getCohortStudySiteId();
            CohortStudySiteRecord ss3 = create.newRecord(CohortStudySite.COHORT_STUDY_SITE);
            ss3.setCohortStudyId(1L);
            ss3.setSiteCode("TEST_HS5");
            ss3.store();
            Long id3 = ss3.getCohortStudySiteId();
            // retrieve the cohort study metadata record
            log.info("cohort study id = " +ss3.fetchParent(Keys.CONSTRAINT_E1).getCohortStudyId());


        }catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();
        }
    }
}
