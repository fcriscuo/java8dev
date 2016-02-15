package edu.jhu.fcriscu1.java8dev;

import java.util.function.Consumer;

/**
 * Created by fcriscuo on 12/8/15.
 */
public class ConsumerImpl<T>  implements Consumer<T> {
    @Override
    public void accept(T t) {
        System.out.println(t);
    }
}
