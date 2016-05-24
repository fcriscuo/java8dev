package edu.jhu.fcriscu1.javaslang.trytest;

import autovalue.shaded.com.google.common.common.collect.Lists;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.io.ByteStreams;
import javaslang.Tuple2;
import javaslang.control.Try;
import lombok.extern.log4j.Log4j;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.time.LocalDate;
import java.util.function.Supplier;

import static com.google.common.base.Charsets.*;
import static javaslang.API.Case;
import static javaslang.API.Match;

/**
 * Created by fcriscuolo on 4/11/16.
 */
@Log4j
public class TryTest {
    public TryTest(){
        this.performTests();
    }

    Try<String> getContent(String location) {
        return Try
                .of(() -> new URL(location))
                .filter(url -> "http".equals(url.getProtocol()))
                .flatMap(url -> Try.of(url::openConnection))
                .flatMap(con -> Try.of(con::getInputStream))
                .map(this::readAndClose);

}
    private String readAndClose(InputStream is){
        try( BufferedInputStream bis = new BufferedInputStream(is)) {
            return new String(ByteStreams.toByteArray(bis), UTF_8);
        } catch (IOException e){
            log.error(e.getMessage());
        }
        return "";
    }
    Try<Integer> addTry(String value) {
        return Try
                .of(() -> value)
                .map(this::addStringValue);
    }

    public Try<Double> tryParseDouble(String s){
        return Try.of(() -> s)
                .map( (sd) -> {
                    Preconditions.checkArgument(!Strings.isNullOrEmpty(sd),
                            "A valid numeric string is required");
                    return Double.parseDouble(sd);
                }
                );
    }

    public Tuple2<Boolean,Double> tryParseDouble(String s, Double d){
          Try<Double> doubleTry = Try.of(() -> s)
                  .map(Double::parseDouble);
        if(doubleTry.isSuccess()){
            return new Tuple2<>(true, doubleTry.get());
        }
        return new Tuple2<>(false, d);
    }

    public Tuple2<Boolean,Integer> tryParseInteger(String s, Integer i){
        Try<Integer> integerTry = Try.of(() -> s)
                .map(Integer::parseInt);
        if(integerTry.isSuccess()){
            i= integerTry.get();
        }
        return new Tuple2<>(integerTry.isSuccess(),i);
    }


    public Tuple2<Boolean,LocalDate> tryParseLocalDate(String aDate, LocalDate localDate){
        Try<LocalDate> ldTry = Try.of(()-> aDate ).map(LocalDate::parse);
        if(ldTry.isSuccess()){
            localDate = ldTry.get();
        }
        return  new Tuple2<Boolean,LocalDate> (ldTry.isSuccess(),localDate);
    }


    private Integer addStringValue(String numericString) {
        Preconditions.checkArgument(!Strings.isNullOrEmpty(numericString),
                "A numeric value is required");
        Preconditions.checkState(Integer.valueOf(numericString) > 0,
                "The numeric value must be > 0");
        Preconditions.checkState(Integer.valueOf(numericString) <10,
                "The numeric value must be < 10");
        return Integer.valueOf(numericString) + 10;
    }

    public void performTests() {
        Double defaultDouble = 0.0d;

        Lists.newArrayList("123.45", "67.99","ABCDE","",null).stream()
                .forEach((s) -> {
                    Tuple2<Boolean,Double> td = tryParseDouble(s,defaultDouble);
                    log.info("parse double string =" +s
                            +" success=" +td._1()
                            +" result = " +td._2());
                });

        Lists.newArrayList("123.45", "67.99","ABCDE","",null).stream()
                .forEach((s) -> {
                    Try<Double> td = tryParseDouble(s);
                    if(td.isSuccess()){
                        log.info("Success value = " +td.get());
                    } else {
                        log.error(td.getCause().toString());
                    }
                        });


        String validDate = "AAAAA";
        LocalDate ld = LocalDate.now();
        log.info("Result for " +validDate +" = " +
                tryParseLocalDate(validDate,ld)._1() +" date "+
        tryParseLocalDate(validDate,ld)._2());

        String testIntString = "123XX" ;
        Integer testInt = 0;
        log.info("Result for " +testIntString + " is " +
           tryParseInteger(testIntString,testInt)._1() +" value "
        +tryParseInteger(testIntString,testInt)._2());

        String value = "100";
        Try<Integer> intTry = addTry(value);

        intTry.onSuccess((s) ->  log.info("intTry for " +value +" = " +s))
                .orElse(addTry("2"));

        String location = "http://xxx.google.com";
        Try<String> tryS = getContent(location);
        tryS.onSuccess((s) -> log.info(s))
                .orElseRun((t) -> log.error(t.getMessage()));


    }

    public static void main(String[] args) {
        TryTest test = new TryTest();
    }
}
