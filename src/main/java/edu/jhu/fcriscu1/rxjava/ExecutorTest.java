package edu.jhu.fcriscu1.rxjava;

import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Action0;
import rx.schedulers.Schedulers;

import java.util.Arrays;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by fcriscuolo on 4/4/16.
 */
public class ExecutorTest {
    public static void main(String[] args) {


        Observable<String> obs = Observable.from(Arrays.asList("one", "two", "three"));
        obs.subscribe(new Subscriber<String>() {
            @Override
            public void onCompleted() {
                System.out.println("Finis...");
            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onNext(String s) {

                Scheduler.Worker outputWorker = Schedulers.newThread().createWorker();
                final Subscription schedule = outputWorker.schedule(new Action0() {
                    @Override
                    public void call() {
                        System.out.println("word = " +s +" thread= " +Thread.currentThread().getName());
                    }

                });
            }

        });
    }
}
