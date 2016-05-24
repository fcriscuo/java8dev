package edu.jhu.fcriscu1.rxjava;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by fcriscuolo on 4/1/16.
 */
public enum TaskCounter {
    INSTANCE;
    private AtomicInteger counter = new AtomicInteger(0);

    public  Integer getCounterValue() {
        return counter.intValue();
    }

    public Integer incrementCounter(){
        return counter.incrementAndGet();
    }

    public Integer decrementCounter() {
        return counter.decrementAndGet();
    }




}
