package edu.jhu.fcriscu1.java8dev;

/**
 * A sample Java8 interface with default methods
 * Created by fcriscuo on 12/8/15.
 */
public interface Computable {

    public int compute();

    /*
    default implementations
    new comments
    another change
     */

    public default int doubleNumber( int num) {
        return num*2;
    }

    public default int negateNumber(int num){
        return -1*num;
    }
}
