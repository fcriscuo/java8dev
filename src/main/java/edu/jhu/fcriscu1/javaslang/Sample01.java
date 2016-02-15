package edu.jhu.fcriscu1.javaslang;


import javaslang.collection.List;
import org.apache.log4j.Logger;

import java.util.function.Consumer;


/**
 * Created by fcriscuo on 2/15/16.
 */
public class Sample01 {

    public static final Logger logger = Logger.getLogger(Sample01.class);

    static Consumer<String> infoConsumer = (s) -> {
        if(logger.isInfoEnabled()){
           logger.info(s);
        }
    };

    public static void main(String... args) {
        List<Integer> list01 = List.of(1,2,3);
        List<Integer> list02 = list01.tail().prepend(0);
        infoConsumer.accept(list01.toString());
        infoConsumer.accept(list02.toString());


    }
}
