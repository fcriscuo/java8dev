package edu.jhu.fcriscu1.rxjava;

import rx.functions.Func1;

/**
 * Created by fcriscuolo on 4/4/16.
 */
public class Monad<T> {
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
        Monad<String> stringMonad = Monad.unit("abcdefg12QR1st");

        String newString = stringMonad.flatMap((a) ->
                new Monad<String>(a.toUpperCase())
        ).flatMap( (r)-> new Monad<String>(r.concat(".json")) ).get();
        System.out.println(newString);
        double result = intMonad.flatMap(new Func1<Integer, Monad<Double>>() {
            @Override
            public Monad<Double> call(Integer input) {
                return Monad.unit(Math.sqrt(input));
            }
        }).flatMap(new Func1<Double, Monad<Double>>() {
            @Override
            public Monad<Double> call(Double aDouble) {
                return Monad.unit(aDouble*3.0);
            }
        }).get();
        System.out.println("Result of " +intMonad.get() +" = " +result);
        System.out.println("Result of double Monad = "+doubleMonad.get());
    }
}

