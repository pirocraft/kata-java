package org.ssg.prossato.kata.fizzbuzz;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FizzBuzzShould {

    public static final String EXPECTED_FIZZ = "fizz";
    public static final String EXPECTED_BUZZ = "buzz";
    public static final String EXPECTED_FIZZBUZZ = "fizzbuzz";
    private FizzBuzz fizzBuzz;

    @BeforeEach
    void setUp() {
        fizzBuzz = new FizzBuzz();
    }

    @Test
    public void return_number_when_number() {
        assertThat(fizzBuzz.fizzBuzz(1)).isEqualTo(String.valueOf(1));
        assertThat(fizzBuzz.fizzBuzz(2)).isEqualTo(String.valueOf(2));
        assertThat(fizzBuzz.fizzBuzz(4)).isEqualTo(String.valueOf(4));
        assertThat(fizzBuzz.fizzBuzz(7)).isEqualTo(String.valueOf(7));
        assertThat(fizzBuzz.fizzBuzz(8)).isEqualTo(String.valueOf(8));
        assertThat(fizzBuzz.fizzBuzz(11)).isEqualTo(String.valueOf(11));
        assertThat(fizzBuzz.fizzBuzz(13)).isEqualTo(String.valueOf(13));
        assertThat(fizzBuzz.fizzBuzz(14)).isEqualTo(String.valueOf(14));
    }

    @Test
    public void return_fizz_when_multiple_of_3() {
        assertThat(fizzBuzz.fizzBuzz(3)).isEqualTo(EXPECTED_FIZZ);
        assertThat(fizzBuzz.fizzBuzz(9)).isEqualTo(EXPECTED_FIZZ);
        assertThat(fizzBuzz.fizzBuzz(12)).isEqualTo(EXPECTED_FIZZ);
    }

    @Test
    public void return_buzz_when_multiple_of_5() {
        assertThat(fizzBuzz.fizzBuzz(5)).isEqualTo(EXPECTED_BUZZ);
        assertThat(fizzBuzz.fizzBuzz(10)).isEqualTo(EXPECTED_BUZZ);
    }

    @Test
    public void return_fizzbuzz_when_multiple_of_3_and_5() {
        assertThat(fizzBuzz.fizzBuzz(15)).isEqualTo(EXPECTED_FIZZBUZZ);
    }
}
