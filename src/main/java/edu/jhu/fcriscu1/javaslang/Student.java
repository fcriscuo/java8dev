package edu.jhu.fcriscu1.javaslang;

import javaslang.collection.List;
import javaslang.control.Validation;
import lombok.extern.log4j.Log4j;

/**
 * Created by fcriscuolo on 3/3/16.
 */
@Log4j
public class Student extends Person {
    private Student (StudentBuilder builder) {
        super(builder.name,
                builder.age,
                builder.zipcode,
                builder.occupation);
    }

    /**
     * The type Student builder.
     */
    public static class StudentBuilder {
        private String name;
        private Integer age;
        private String zipcode;
        private String occupation;

        /**
         * The Person validator.
         */
        PersonValidator personValidator = new PersonValidator();

        /**
         * Sets name.
         *
         * @param name the name
         * @return the name
         */
        public StudentBuilder setName(String name) {
            this.name = name;
            return this;
        }

        /**
         * Sets age.
         *
         * @param age the age
         * @return the age
         */
        public StudentBuilder setAge(Integer age) {
            this.age = age;
            return this;
        }

        /**
         * Sets zipcode.
         *
         * @param zipcode the zipcode
         * @return the zipcode
         */
        public StudentBuilder setZipcode(String zipcode) {
            this.zipcode = zipcode;
            return this;
        }

        /**
         * Sets occupation.
         *
         * @param occupation the occupation
         * @return the occupation
         */
        public StudentBuilder setOccupation(String occupation) {
            this.occupation = occupation;
            return this;
        }

        /**
         * Build student.
         *
         * @return the student
         */
        public Student build() {
            // Valid(Person(John Doe, 30))
            Validation<List<String>, Person> valid =
                    personValidator.validatePerson(name, age, zipcode, occupation);
            if (valid.isInvalid()) {
                valid.getError().toStream().forEach((s) -> System.out.println(s));
                return null;
            }

            return new Student(this);
        }
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
//
    public static void main(String[] args) {
        log.info("Person1");
        Person person1 = new StudentBuilder().setName("Tom").setAge(50).setZipcode("92116").setOccupation("lawyer").build();
        if (person1 != null) {
            log.info(person1.getName());
        }
        log.info("Person2");
        Person person2 = new StudentBuilder().setName("Frank01").setAge(10).setZipcode("A2116").setOccupation("lawyer").build();
        if (person2 != null) {
            log.info(person2.getName());
        }
        log.info("Person3");
        Person person3 = new StudentBuilder().setName("Ann").setAge(20).setZipcode("92116").setOccupation("lawyer").build();
        if (person3 != null) {
            log.info(person3.getName());
        }
    }
}
