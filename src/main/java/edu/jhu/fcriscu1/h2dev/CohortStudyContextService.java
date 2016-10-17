package edu.jhu.fcriscu1.h2dev;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import javaslang.control.Either;
import javaslang.control.Try;
import lombok.extern.log4j.Log4j;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.nygenome.cdrn.nyc.sitestudy.h2.generated.tables.CohortStudyMeta;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;

/**
 * Created by fcriscuolo on 5/24/16.
 */
@Log4j
public enum CohortStudyContextService {
    INSTANCE;
    private final Try<DSLContext> dslContextTry = Suppliers.memoize(new DSLContextSupplier()).get();

    public Either<Throwable,DSLContext> dslContext() {
        return dslContextTry.toEither();
    }

    public Either executeContextFunction(Function<DSLContext, ? extends Object> databaseFunction) {
        if( CohortStudyContextService.INSTANCE.dslContext().isLeft()) {
            log.error(CohortStudyContextService.INSTANCE.dslContext().getLeft().getMessage());
            return Either.left(CohortStudyContextService.INSTANCE.dslContext().left());
        }
       return  CohortStudyContextService.INSTANCE.dslContext().map(databaseFunction);
    }


   // main method for standalone testing
    public static void main(String[] args) {
//        if( CohortStudyContextService.INSTANCE.dslContext().isLeft()) {
//            log.error(CohortStudyContextService.INSTANCE.dslContext().getLeft().getMessage());
//            return;
//        }
       Function<DSLContext,Integer> selectRowFunction = (context)-> {
            AtomicInteger ai = new AtomicInteger();
            context.fetch( "select * from cohort_study_meta")
                    .stream().forEach((row)-> {
                log.info("STUDY_CODE " + row.getValue(CohortStudyMeta.COHORT_STUDY_META.STUDY_CODE));
                ai.getAndIncrement();
            });
            return ai.get();
        };
//        CohortStudyContextService.INSTANCE.dslContext().map(selectRowFunction);
         log.info("Row count = " +CohortStudyContextService.INSTANCE.executeContextFunction(selectRowFunction).get());



    }

    private class DSLContextSupplier implements Supplier<Try<DSLContext>>{
        //TODO : set these values from properties
        // JDBC driver name and database URL
        static final String JDBC_DRIVER = "org.h2.Driver";
        // connect using TCP connection
        static final String DB_TCP_URL = "jdbc:h2:tcp://localhost//data/cohort_study/h2db/cohortstudy;SCHEMA=COHORT_STUDY";
        //  Database credentials
        static final String USER = "cdrn";
        static final String PASS = "cdrn";
        private  DSLContext dslContext;

        DSLContextSupplier() {
            try {
                Class.forName("org.h2.Driver");
                this.dslContext = DSL.using(DriverManager.getConnection(DB_TCP_URL, USER, PASS), SQLDialect.H2);
            } catch (ClassNotFoundException | SQLException e) {
                log.error(e.getMessage());
                e.printStackTrace();
            }

        }

        private Try<DSLContext> resolveDSLContext(String url){
            try {
                Class.forName("org.h2.Driver");
                return Try.success(DSL.using(DriverManager.getConnection(url, USER, PASS), SQLDialect.H2));
            } catch (Exception e){
                return Try.failure(e);
            }
        }
        @Override
        public Try<DSLContext> get() {
            return this.resolveDSLContext(DB_TCP_URL);
        }


    }
}
