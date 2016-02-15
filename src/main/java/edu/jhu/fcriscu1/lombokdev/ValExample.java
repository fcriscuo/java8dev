package edu.jhu.fcriscu1.lombokdev;

import lombok.extern.log4j.Log4j;
import lombok.val;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by fcriscuo on 12/20/15.
 */
@Log4j
public class ValExample {
       public String example() {
           val example = new ArrayList<String>();
           example.add("Hello World!");
           val foo = example.get(0);
           return foo.toLowerCase();
    }

    public void example2() {
        val map = new HashMap<Integer,String>();
        map.put(0,"zero");
        map.put(5,"five");
        for (val entry : map.entrySet()){
            System.out.println("key " +entry.getKey() +" value = " +entry.getValue());
        }
    }


    public static void main (String...args) {
        ValExample ve = new ValExample();
        log.info(ve.example());
        ve.example2();


    }
}
