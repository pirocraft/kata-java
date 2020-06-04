package org.ssg.prossato.kata.fizzbuzz;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FizzBuzzShould {

    private FizzBuzz fizzBuzz;

    @BeforeEach
    void setUp() {
        fizzBuzz = new FizzBuzz();
    }

    @Test
    public void return_1_when_1() {
        assertThat(fizzBuzz.fizzBuzz(1)).isEqualTo(1);
    }

    @Test
    public void return_2_when_2() {
        assertThat(fizzBuzz.fizzBuzz(2)).isEqualTo(2);
    }
}
