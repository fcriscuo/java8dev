package edu.jhu.fcriscu1.lombokdev;

import lombok.Builder;
import lombok.Singular;
import lombok.ToString;
import lombok.extern.log4j.Log4j;

import java.util.Set;

/**
 * Created by fcriscuo on 2/3/16.
 */
@Builder
@Log4j
@ToString
public class BuilderDev {
    private String name;
    private Integer age;
    @Singular Set<String> occupations;

    //main method for stand alone testing
    public static void main (String...args){
        BuilderDev bd1 = BuilderDev.builder().name("Tom").age(50).occupation("Tailor").occupation("Cowboy").build();
        BuilderDev bd2 = BuilderDev.builder().name("Alice").age(50).occupation("Maid").occupation("Bartender").build();
        log.info(bd1 == bd2);
        log.info(bd1.toString());

    }

}
