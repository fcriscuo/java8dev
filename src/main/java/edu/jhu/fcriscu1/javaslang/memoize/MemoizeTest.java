package edu.jhu.fcriscu1.javaslang.memoize;

import javaslang.Lazy;
import lombok.extern.log4j.Log4j;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.function.Supplier;

/**
 * Created by fcriscuolo on 4/25/16.
 */
@Log4j
public class MemoizeTest {
    private static final String prefix = "NYGC_";
    public static void main(String[] args) {

        Lazy<Double> lazy = Lazy.of(Math::random);
        log.info(lazy.isEvaluated()); // = false
        log.info(lazy.get());
        Lazy<String> lazyS = Lazy.of(()->
                prefix + LocalDateTime.now().toString());

        log.info(lazyS.get());
    }

}
