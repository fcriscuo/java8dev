package edu.jhu.fcriscu1.javaslang;

import javaslang.Function3;

/**
 * Created by fcriscuolo on 4/6/16.
 */
public class FunctionTest {

    public FunctionTest() {}

    public Integer execFunction3 (Function3<Integer,Integer,Integer,Integer> func3){
        return func3.apply(7,8,9);
    }

    public static void main(String[] args) {
        FunctionTest test = new FunctionTest();
        Sample01 sample = new Sample01();
        System.out.println(test.execFunction3(sample.function3));
    }
}
