package edu.jhu.fcriscu1.javaslang;

import rx.functions.Func1;

/**
 * Created by fcriscuolo on 4/1/16.
 */
public class  Monad <T> {
    private T value;

    private Monad(T value) {
        this.value = value;
    }

    public static <T> Monad<T> unit(T value) {
        return new Monad<T>(value);
    }

    public <R> Monad<R> flatMap(Func1<T, Monad<R>> func) {
        return func.call(this.value);
    }

    public T get() {
        return value;
    }

    public static void main(String...args) {
        Monad<Integer> intMonad = Monad.unit(2);
        Monad<Double> doubleMonad = Monad.unit(3.1417D);

        double result = intMonad.flatMap(new Func1<Integer, Monad<Double>>() {

            public Monad<Double> call(Integer input) {
                return Monad.unit(Math.sqrt(input));
            }
        }).flatMap(new Func1<Double, Monad<Double>>() {

            public Monad<Double> call(Double aDouble) {
                return Monad.unit(aDouble*3.0);
            }
        }).get();
        System.out.println("Result of " +intMonad.get() +" = " +result);
    }
}
