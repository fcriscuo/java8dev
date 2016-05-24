package edu.jhu.fcriscu1.rxjava;

import rx.Observable;


import java.util.concurrent.TimeUnit;

/**
 * Created by fcriscuolo on 5/23/16.
 */
public class TimerDelayDemo {
    public static void main(String[] args) {
        Observable.just("Lorem", "ipsum", "dolar", "sit","amet",
                "consectetur","adipiscing","elit")
                .delay(word -> Observable.timer(word.length(), TimeUnit.SECONDS))
                .subscribe(System.out::println);
        try {
            TimeUnit.SECONDS.sleep(15L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
