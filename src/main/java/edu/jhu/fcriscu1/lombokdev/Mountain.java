package edu.jhu.fcriscu1.lombokdev;

import lombok.Data;
import lombok.extern.log4j.Log4j;

/**
 * Created by fcriscuo on 1/30/16.
 */
public @Data  @Log4j class Mountain {
    private final String name;
    private final String continent;
    private final int height;

    public static void main (String...args){
        Mountain m1 = new Mountain("K2", "Asia", 20000);
        log.info(m1.toString());
    }

}
