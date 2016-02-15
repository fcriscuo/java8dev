package edu.jhu.fcriscu1.java8dev;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.function.Function;

/**
 * Created by fcriscuo on 12/9/15.
 */
public class Memoizer<T,U> {
    private final Map<T,U>  memoizationCache = new ConcurrentHashMap<>();
    private Function<T,U> doMemoize(final Function<T,U> function) {
        return input -> memoizationCache.computeIfAbsent(input, function::apply);
    }
    public static  <T,U> Function<T,U>  memoize (final Function<T,U> function) {

        return new Memoizer<T,U>().doMemoize(function);
    }
}
