package edu.jhu.fcriscu1.cyclops;

import com.aol.cyclops.control.FluentFunctions;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Created by fcriscuolo on 4/20/16.
 */
public class CyclopsTest {
    private int times = 0;

    public CyclopsTest() {}

    public void performTests() {
//        FluentFunctions.ofChecked(this::exceptionalFirstTime)
//                .println()
//                .retry(2,500)
//                .apply("hello");

        FluentFunctions.ofChecked(this::exceptionalFirstTime)
                .recover(IOException.class, in->in+"boo!")
                .println()
                .apply("hello ");

        FluentFunctions.of(this::gen)
                .println()
                .generate("next element ")
                .onePer(1, TimeUnit.SECONDS)
                .forEach(System.out::println);
    }

    public static void main(String[] args) {
        CyclopsTest test = new CyclopsTest();
        test.performTests();
    }

    public String gen(String input){
        return input+System.currentTimeMillis();
    }

    public String exceptionalFirstTime(String input) throws IOException{
        if(times==0){
            times++;
            throw new IOException();
        }
        return input + " world";
    }
}
