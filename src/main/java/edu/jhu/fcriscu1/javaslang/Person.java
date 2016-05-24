package edu.jhu.fcriscu1.javaslang;

import lombok.ToString;
import lombok.extern.log4j.Log4j;

/**
 * Created by fcriscuolo on 3/2/16.
 */
@Log4j
@ToString
public  class Person {
    private  String name;
    private  Integer age;
    private  String zipcode;
    private  String occupation;

     Person(String name, Integer age, String zipcode, String occupation) {
        this.name = name;
        this.age = age;
        this.zipcode = zipcode;
        this.occupation = occupation;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public String getZipcode() {
        return zipcode;
    }

    public String getOccupation() {
        return occupation;
    }
}
