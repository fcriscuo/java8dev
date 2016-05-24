package edu.jhu.fcriscu1.javaslang;


import javaslang.*;
import javaslang.collection.List;
import javaslang.collection.Stream;
import javaslang.control.Either;
import javaslang.control.Option;
import org.apache.log4j.Logger;

import java.util.Collections;
import java.util.Objects;
import java.util.function.Consumer;

import static java.lang.String.format;
import static java.lang.System.out;
import static javaslang.API.$;
import static javaslang.API.Case;
import static javaslang.API.Match;
import static javaslang.Patterns.None;
import static javaslang.Patterns.Some;


/**
 * Created by fcriscuo on 2/15/16.
 */
public class Sample01 {

    public Sample01() {}

    public void performTests() {
            System.out.println(function3.apply(1,2,3));
    }

    public Integer addThree (Integer a, Integer b, Integer c) {
        return a+b+c;
    }

    //use Function3.of to invoke a Java method that takes 3 parameters.
    //
   public Function3<Integer,Integer,Integer,Integer> function3 =
            Function3.of(this::addThree);


    public static final Logger logger = Logger.getLogger(Sample01.class);

    static Consumer<String> infoConsumer = (s) -> {
        if(logger.isInfoEnabled()){
           logger.info(s);
        }
        out.println(s);
    };

    static int sumFunction(int first, int second) {
        if (first < 0 || second < 0) {
            throw new IllegalArgumentException("Only positive integers are allowed");
        }
        return first + second;
    }

    public static void main(String... args) {
        Sample01 test = new Sample01();
        List<Integer> list01 = List.of(1,2,3);
        List<Integer> list02 = list01.tail().prepend(0);
        infoConsumer.accept(list01.toString());
        infoConsumer.accept(list02.toString());
        // = List(1, 2, 3)
        Function2<Integer, Integer, Integer> divide = (a, b) -> a / b;
        Function2<Integer, Integer, Option<Integer>> safeDivide = Function2.lift(divide);
        // = None
        Option<Integer> i1 = safeDivide.apply(1, 0);
        out.println(i1);
        // = Some
        Option<Integer> i2 = safeDivide.apply(4, 2);
        out.println(i2);

        out.println("arity = ");
        //curried functions
        //define full  function with 2 inputs
        Function2<Integer, Integer, Integer> sum = (a, b) -> a + b;
        //define  curried variation with one constant input
        Function1<Integer, Integer> add2 = sum.curried().apply(2);
        //complete the curried function by applying the 2nd parameter
        //this is equivalent to the full function
        out.println(add2.apply(4));

        Function2<Integer,Integer,Integer> sum2 = (a,b) -> a+b;
        //function w/o inputs (a supplier) - supplys a random number
        Function0<Double> dynamicR =
                Function0.of(Math::random);


        Function0<Double> hashCache =
                Function0.of(Math::random).memoized();
        infoConsumer.accept(hashCache.apply().toString()+ " " +dynamicR.apply());
        infoConsumer.accept(hashCache.apply().toString()+ " " +dynamicR.apply());
        // since the hashCache value is memoized, it does not change
        String[] words = {"The","cat","in","the","hat"};

        //joins a List of words into a csv String
           infoConsumer.accept( List.of(words).intersperse(",")
                    .fold("", String::concat));
       // Either<String,Integer> value = compute().right().map(i -> i * 2).toEither();

        //Using a Match statement to process an Option
        Option<String> sOpt = Option.of("ABC");
        String status =   Match(sOpt).of(
                Case(Some($()), "defined"),
                Case(None(), "empty")
        );
        System.out.println(status);

        test.performTests();




    }
}
