package edu.jhu.fcriscu1.javaslang;

import javaslang.collection.List;
import javaslang.control.Validation;
import lombok.extern.log4j.Log4j;

@Log4j
public class PersonBuilder {
    private String name;
    private Integer age;
    private String zipcode;
    private String occupation;

    PersonValidator personValidator = new PersonValidator();



    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setAge(Integer age) {
        this.age = age;
        return this;
    }

    public PersonBuilder setZipcode(String zipcode) {
        this.zipcode = zipcode;
        return this;
    }

    public PersonBuilder setOccupation(String occupation) {
        this.occupation = occupation;
        return this;
    }

    public Person build() {
        // Valid(Person(John Doe, 30))
        Validation<List<String>, Person> valid =
                personValidator.validatePerson(name, age, zipcode,occupation);
        if (valid.isInvalid()) {
            valid.getError().toStream().forEach((s) -> System.out.println(s));
            return null;
        }

        return valid.get();
    }
    //
    public static void main(String[] args) {
        log.info("Person1");
        Person person1 = new PersonBuilder().setName("Tom").setAge(50).setZipcode("92116").setOccupation("lawyer").build();
        if(person1 != null ) {
            log.info(person1.getName());
        }
        log.info("Person2");
        Person person2 = new PersonBuilder().setName("Frank01").setAge(10).setZipcode("A2116").setOccupation("lawyer").build();
        if(person2 != null ) {
            log.info(person2.getName());
        }
        log.info("Person3");
        Person person3 = new PersonBuilder().setName("Ann").setAge(20).setZipcode("92116").setOccupation("lawyer").build();
        if(person3 != null ) {
            log.info(person3.getName());
        }
    }


}