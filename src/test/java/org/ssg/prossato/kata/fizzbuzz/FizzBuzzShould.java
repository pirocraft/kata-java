package org.ssg.prossato.kata.fizzbuzz;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FizzBuzzShould {

    @Test
    public void return_1_when_1() {
        FizzBuzz fizzBuzz = new FizzBuzz();

        assertThat(fizzBuzz.fizzBuzz(1)).isEqualTo(1);
    }

    @Test
    public void return_2_when_2() {
        FizzBuzz fizzBuzz = new FizzBuzz();

        assertThat(fizzBuzz.fizzBuzz(2)).isEqualTo(2);
    }
}
