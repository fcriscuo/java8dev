package edu.jhu.fcriscu1.javaslang;

import javaslang.control.Try;

/**
 * Created by fcriscuolo on 4/5/16.
 */
public class FailureHandling {

        public static void main(String[] args) {
            CompositionObject test = new CompositionObject(30, null);
            System.out.println(
                    Try.of(() -> test)
                            .filter(v -> v != null)
                            .onFailure(e -> System.out.println("test is null"))
                            .map(CompositionObject::getField2)
                            .filter(v -> v != null)
                            .onFailure(e -> System.out.println("field2 is null"))
                            .recover(e -> "a")
                            .get());
        }

         static class CompositionObject {
            Integer field1;
            String field2;

            public CompositionObject(Integer field1, String field2) {
                this.field1 = field1;
                this.field2 = field2;
            }

            public Integer getField1() {
                return field1;
            }

            public String getField2() {
                return field2;
            }
        }
}
