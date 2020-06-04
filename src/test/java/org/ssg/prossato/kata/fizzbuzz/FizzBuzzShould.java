package org.ssg.prossato.kata.fizzbuzz;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FizzBuzzShould {

    @Test
    public void return_1_when_1() {
        FizzBuzz fizzBuzz = new FizzBuzz();

        assertThat(fizzBuzz.next()).isEqualTo(1);
    }
}
