package org.ssg.prossato.kata.fizzbuzz;

public class FizzBuzz {

    private static final String FIZZ = "fizz";
    private static final String BUZZ = "buzz";

    public String fizzBuzz(int i) {
        if (isMultipleOf(i, 15))
            return FIZZ + BUZZ;
        if (isMultipleOf(i, 3))
            return FIZZ;
        if (isMultipleOf(i, 5))
            return BUZZ;
        return String.valueOf(i);
    }

    private boolean isMultipleOf(int number, int factor) {
        return number % factor == 0;
    }
}
