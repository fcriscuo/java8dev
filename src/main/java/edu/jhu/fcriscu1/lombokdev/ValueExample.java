package edu.jhu.fcriscu1.lombokdev;

import lombok.AccessLevel;
import lombok.ToString;
import lombok.Value;
import lombok.experimental.NonFinal;
import lombok.experimental.Wither;

/**
 * Created by fcriscuo on 12/20/15.
 */
public class ValueExample {
    String name;
    int age;
    double score;
    protected String[] tags;
    @ToString(includeFieldNames = true)
    @Value(staticConstructor = "of")
    public static class Exercise<T> {
        String name;
        T value;
    }

}
