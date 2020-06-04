package org.ssg.prossato.kata.fizzbuzz;

public class FizzBuzz {

    private static final String FIZZ = "fizz";
    private static final String BUZZ = "buzz";

    public String fizzBuzz(int i) {
        if (i % 15 == 0) {
            return FIZZ + BUZZ;
        }
        if (i % 3 == 0) {
            return FIZZ;
        }
        if (i % 5 == 0) {
            return BUZZ;
        }
        return String.valueOf(i);
    }
}
