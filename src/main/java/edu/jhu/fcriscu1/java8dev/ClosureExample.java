package edu.jhu.fcriscu1.java8dev;

import java.util.function.Function;

/**
 * Created by fcriscuo on 12/9/15.
 */
public class ClosureExample {
    int instanceLength;
    final String separator =":";
    public Function<String, String> getStringOperation() {
        return target -> {
           int localLength = target.length() ;
            instanceLength = target.length();
            return target.toLowerCase() +
                    separator +
                    instanceLength
                    +separator
                    +localLength;
        };
    }
}
