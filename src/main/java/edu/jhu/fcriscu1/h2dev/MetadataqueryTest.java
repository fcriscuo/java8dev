package edu.jhu.fcriscu1.h2dev;


import lombok.extern.log4j.Log4j;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.impl.DSL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * Created by fcriscuolo on 5/23/16.
 */
@Log4j
public class H2ConnectionTest {
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

            log.info("Connected database successfully...");
            Result<Record> result =
                    DSL.using(conn)
                            .fetch(testSql);
            result.stream().forEach((record)-> {
                String studyCode = (String)record.getValue("STUDY_CODE");
                log.info(studyCode);

            });


        }catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();
        }
    }
}
