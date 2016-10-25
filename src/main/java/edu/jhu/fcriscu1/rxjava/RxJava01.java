package edu.jhu.fcriscu1.rxjava;

import rx.Observable;

import java.util.Arrays;
import java.util.List;

/**
 * Created by fcriscuolo on 4/1/16.
 */
public class RxJava01 {

    // add comment 01
    public static void main(String[] args) {
        List<String> list = Arrays.asList(
                "blue", "red", "green", "yellow", "orange", "cyan", "purple"
        );
        Observable<String> listObservable = Observable.from(list);
        listObservable.subscribe(System.out::println);
        listObservable.subscribe(
                color -> System.out.print(color + "|"),
                System.out::println,
                System.out::println
        );
        listObservable.subscribe(color -> System.out.print(color + "/"));
    }
}
