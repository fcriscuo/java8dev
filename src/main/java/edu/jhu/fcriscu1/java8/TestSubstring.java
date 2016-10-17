package edu.jhu.fcriscu1.java8;

import lombok.extern.log4j.Log4j;

import java.util.function.Function;

/**
 * Created by fcriscuolo on 10/5/16.
 */
@Log4j
public class TestSubstring {
    public static void main(String[] args) {
        String update01 = "UPDATE fact_relationship set error_cnt = ( select 1 + fact_relationship.error_cnt         from fact_relationship         WHERE domain_concept_id_2 = 27 AND domain_concept_id_1 <> 19 limit 1)";
        String select01 = update01.substring(update01.indexOf("select"),
                update01.lastIndexOf(')')) +";";
        log.info(select01);
        String update02 = "UPDATE fact_relationship set error_cnt = ( select 1 + fact_relationship.error_cnt" +
        "        from fact_relationship fr1" +
                "        JOIN measurement m1 ON m1.measurement_id = fr1.fact_id_1" +
                " JOIN measurement m2 ON m2.measurement_id = fr1.fact_id_2" +
                " WHERE domain_concept_id_1 = 21 AND domain_concept_id_2 = 21" +
                " AND NOT EXISTS (SELECT 1" +
                "                FROM fact_relationship fr2"+
                "                WHERE fr2.domain_concept_id_1 = 21 AND fr2.domain_concept_id_2 = 21"+
                "                AND fr2.fact_id_1 = fr1.fact_id_2 AND fr2.fact_id_2 = fr1.fact_id_1 limit 1) limit 1);";
        String select02 = update02.substring(update02.indexOf("select"),
                update02.lastIndexOf(')')) +";";
        log.info(extractSelectStatementFunction.apply(update02));

    }
    static Function<String,String> extractSelectStatementFunction = (sql) ->
            sql.substring(sql.indexOf("select"),sql.lastIndexOf(')'))+";";
}
