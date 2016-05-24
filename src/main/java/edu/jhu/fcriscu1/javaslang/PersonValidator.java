package edu.jhu.fcriscu1.javaslang;

import javaslang.collection.CharSeq;
import javaslang.collection.List;
import javaslang.control.Validation;

/**
 * Created by fcriscuolo on 3/2/16.
 */
public class PersonValidator {
    private static final String VALID_NAME_CHARS = "[a-zA-Z ]";
    private static final String VALID_ZIPCODE_CHARS = "[0-9]";
    private static final int MIN_AGE = 18;

    /**
     * Validate person validation.
     *
     * @param name       the name
     * @param age        the age
     * @param zipcode    the zipcode
     * @param occupation the occupation
     * @return the validation
     */
    public Validation<List<String>, Person> validatePerson(String name,
                                                           int age, String zipcode,
                                                           String occupation) {
        return Validation.combine(validateName(name), validateAge(age),
                validateZipcode(zipcode),validateOccupation(occupation)).ap(Person::new);
    }

    private Validation<String, String> validateName(String name) {
        return CharSeq.of(name).replaceAll(VALID_NAME_CHARS, "").transform(seq -> seq.isEmpty()
                ? Validation.valid(name)
                : Validation.invalid("Name contains invalid characters: '"
                + seq.distinct().sorted() + "'"));
    }

    private Validation<String, String> validateOccupation(String occupation) {
        return CharSeq.of(occupation).replaceAll(VALID_NAME_CHARS, "").transform(seq -> seq.isEmpty()
                ? Validation.valid(occupation)
                : Validation.invalid("Occupation contains invalid characters: '"
                + seq.distinct().sorted() + "'"));
    }
    private Validation<String, String> validateZipcode(String zipcode) {
        return CharSeq.of(zipcode).replaceAll(VALID_ZIPCODE_CHARS, "")
                .transform(seq -> seq.isEmpty()
                ? Validation.valid(zipcode)
                : Validation.invalid("Zipcode contains invalid characters: '"
                + seq.distinct().sorted() + "'"));
    }

    private Validation<String, Integer> validateAge(int age) {
        return age < MIN_AGE
                ? Validation.invalid("Age must be greater than " + MIN_AGE)
                : Validation.valid(age);
    }
}
