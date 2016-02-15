package edu.jhu.fcriscu1.java8dev;

import autovalue.shaded.com.google.common.common.collect.Lists;
import org.apache.log4j.Logger;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.*;
import java.util.stream.Stream;

/**
 * A set of code blocks examples
 * things that you could use a REPL for if Java had one
 * Created by fcriscuo on 12/8/15.
 */
public class TestCodeBlock01 {
    // define a logger for output
    private static final Logger logger = Logger.getLogger(TestCodeBlock01.class);
    public static void main (String...args){
        Stream<Integer> s = Stream.of(12,52,32,74,25)
                .map(x -> x*2);
        s.forEach(x-> logger.info(x));
        // use Google Guava list as a Stream
        List<String> nameList = Lists.newArrayList();
        nameList.add("Sally");
        nameList.add("George");
        nameList.add("Paul");
        nameList.stream().forEach(name -> logger.info(name +" " +name.length()));
        nameList.forEach(x -> logger.info(processString(xx->xx.toLowerCase(),x)));
        //nameList.forEach(x -> logger.info(processString(xx->xx.toUpperCase(),x)));
        List<String> numberString = Arrays.asList("12","34","52");
        List<Integer> doubleNumbers = Lists.newArrayList();
        Function<List<String>,List<Integer>> doubleFunction = sl -> {
            sl.stream()
                    .forEach(t -> doubleNumbers.add(Integer.parseInt(t)*2));
            return doubleNumbers;
        };
        logger.info(doubleFunction.apply(numberString));

        logger.info(calculatePayFunction(EmployeeType.Hourly).apply(83, 15.75f));

        Function<String,String> f1 = String::toLowerCase;
        Consumer<String> cons =  s2 ->  logger.info(f1.apply(s2));
        nameList.forEach(cons);

        // test using the Memoizer class

        Function<Integer,Integer> memoizedFunction = Memoizer.memoize(x -> x*x);
        logger.info(memoizedFunction.apply(10));
        logger.info(memoizedFunction.apply(25));
       // test ClosureExample
        ClosureExample ce = new ClosureExample();
        final Function<String,String> function = ce.getStringOperation();
        logger.info(function.apply("Closure"));
        //Currying
        BiFunction<String,String,String> biFunctionConcat = (a,b) -> a+b;
        // curried function since b is unknown
        Function<String,Function<String,String>> curryConcat = (a) -> (b) -> biFunctionConcat.apply(a,b);
        Function<String,String> intermediateFunction = curryConcat.apply("Cat");
        System.out.println(intermediateFunction);
        System.out.println(curryConcat.apply("Cat"));
        // supply b to the intermediate function (curried)
        logger.info(intermediateFunction.apply("Dog"));
        logger.info(curryConcat.apply("Flying").apply("Monkeys"));
        // Can use the same function for adding numbers
        Function<Double,Function<Double,Double>> curryAdd = (a) -> (b) -> a+b;
        logger.info(curryAdd.apply(3.0).apply(4.0));
        // use a lambda function to implement an interface
        StringConcatenation sc = (s1,t) -> s1 +" : " +t;
        logger.info(sc.concatentate("A", "B"));
        Predicate<Integer> tooLarge = pl -> pl >100;
        logger.info(tooLarge.test(150));
        List<Integer> testList = Arrays.asList(230,45,13,564, 4);
        // a Consumer that uses uhe tooLarge function
        testList.stream().forEach(tl -> logger.info( tl + " " +tooLarge.test(tl)));
        //Supplier
        Supplier<Integer> randomIntegers = () -> {
            Random random = new Random();
            int number = random.nextInt(10);
            while (number >= 5 && number <= 8) {
                number = random.nextInt(10);
            }
            return number;
        };

        for (int i = 0; i <10 ; i++){
            logger.info("random number: "+randomIntegers.get());
        }

        //numberString.forEach(System.out::println);
        System.out.println(
                numberString.stream()
               .mapToInt(e -> Integer.parseInt(e))
                .sum()

        );

    }

    enum EmployeeType {Hourly, Salary, Sales}

    public static BiFunction<Integer,Float,Float> calculatePayFunction (EmployeeType type) {
        switch(type){
            case Hourly:
                return (hours, payRate) -> hours*payRate;
            case Salary:
                return (hours,payRate) -> 40*payRate;
            case Sales:
                return (hours, payRate) -> 500F +0.15f *payRate;
            default:
                return (hours, payRate) -> 0.0f;
        }
    }


    public static String processString(Function<String,String> stringFunction, String target){
        return stringFunction.apply(target);
    }


}
