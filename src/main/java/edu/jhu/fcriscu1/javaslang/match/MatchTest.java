package edu.jhu.fcriscu1.javaslang.match;

import javaslang.Tuple;
import javaslang.Tuple3;
import javaslang.collection.Stream;
import javaslang.control.Either;
import javaslang.control.Option;
import lombok.extern.log4j.Log4j;

import java.time.LocalDate;

import java.time.LocalDate;

import static java.time.LocalDate.now;
import static javaslang.API.$;
import static javaslang.API.Case;
import static javaslang.API.Match;
import static javaslang.Predicates.instanceOf;
import static javaslang.Predicates.is;
import static javaslang.Predicates.isIn;


/**
 * Created by fcriscuolo on 3/22/16.
 */
@Log4j
public class MatchTest {

    public MatchTest() {}

    public void displayHelp() {
        System.out.println("This is a help message");
    }

    public void displayVersion() {
        System.out.println("MatchTest v 1.0.0");
    }

    public static void main(String[] args) {
        LocalDate localDate = now();
        int i = 29;
        String s = Match(i).of(
                Case( isIn(1,3,5,7,9),"odd"),
                Case(isIn(2,4,6,8,10),"even"),
                Case($(), "unknown")

        );
        log.info(s);
        i = 0;
        Option<String>sOpt = Match(i).option(
             Case($(0),"zero")
        );
        if(sOpt.isEmpty()){
            log.info("Option is empty");
        }else {
            log.info(sOpt.get());
        }


    }



}
