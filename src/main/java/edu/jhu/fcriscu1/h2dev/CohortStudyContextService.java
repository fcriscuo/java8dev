package edu.jhu.fcriscu1.h2dev;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import lombok.extern.log4j.Log4j;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.nygenome.cdrn.nyc.sitestudy.h2.generated.tables.CohortStudyMeta;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by fcriscuolo on 5/24/16.
 */
@Log4j
public enum CohortStudyContextService {
    INSTANCE;
    private final DSLContext dslContext = Suppliers.memoize(new DSLContextSupplier()).get();

    public DSLContext dslContext() {
        return dslContext;
    }

   // main method for standalone testing
    public static void main(String[] args) {
            CohortStudyContextService.INSTANCE.dslContext().fetch( "select * from cohort_study_meta")
                    .stream().forEach((row)-> log.info("study code " +row.getValue(CohortStudyMeta.COHORT_STUDY_META.STUDY_CODE)));
    }

    private class DSLContextSupplier implements Supplier<DSLContext>{
        //TODO : set these values from properties
        // JDBC driver name and database URL
        static final String JDBC_DRIVER = "org.h2.Driver";
        // connect using TCP connection
        static final String DB_URL = "jdbc:h2:tcp://localhost//data/cohort_study/h2db/cohortstudy;SCHEMA=COHORT_STUDY";
        //  Database credentials
        static final String USER = "cdrn";
        static final String PASS = "cdrn";
        private  DSLContext dslContext;

        DSLContextSupplier() {
            try {
                Class.forName("org.h2.Driver");
                this.dslContext = DSL.using(DriverManager.getConnection(DB_URL, USER, PASS), SQLDialect.H2);
            } catch (ClassNotFoundException | SQLException e) {
                log.error(e.getMessage());
                e.printStackTrace();
            }

        }
        @Override
        public DSLContext get() {
            return this.dslContext;
        }
    }
}
