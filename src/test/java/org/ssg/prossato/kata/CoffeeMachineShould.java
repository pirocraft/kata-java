package org.ssg.prossato.kata;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CoffeeMachineShould {

    private DrinkMakerDouble drinkMaker;
    private CoffeeMachine coffeeMachine;

    @BeforeEach
    void setUp() {
        drinkMaker = new DrinkMakerDouble();
        coffeeMachine = new CoffeeMachine(drinkMaker);
    }

    @Test
    public void command_a_tea_with_no_sugar() {
        coffeeMachine.command(new Command(new Tea(), new NumberOfSugar(0)));
        assertEquals("T::", drinkMaker.getReceivedCommand());
    }
    @Test
    public void command_a_tea_with_one_sugar() {
        coffeeMachine.command(new Command(new Tea(), new NumberOfSugar(1)));
        assertEquals("T:1:0", drinkMaker.getReceivedCommand());
    }

    @Test
    public void command_a_tea_with_two_sugar() {
        coffeeMachine.command(new Command(new Tea(), new NumberOfSugar(2)));
        assertEquals("T:2:0", drinkMaker.getReceivedCommand());
    }

    @Test
    public void command_a_chocolate_with_no_sugar() {
        coffeeMachine.command(new Command(new Chocolate(), new NumberOfSugar(0)));
        assertEquals("H::", drinkMaker.getReceivedCommand());
    }

    @Test
    public void command_a_chocolate_with_one_sugar() {
        coffeeMachine.command(new Command(new Chocolate(), new NumberOfSugar(1)));
        assertEquals("H:1:0", drinkMaker.getReceivedCommand());
    }

    @Test
    public void command_a_chocolate_with_two_sugar() {
        coffeeMachine.command(new Command(new Chocolate(), new NumberOfSugar(2)));
        assertEquals("H:2:0", drinkMaker.getReceivedCommand());
    }

    @Test
    public void command_a_coffee_with_no_sugar() {
        coffeeMachine.command(new Command(new Coffee(), new NumberOfSugar(0)));
        assertEquals("C::", drinkMaker.getReceivedCommand());
    }

    @Test
    public void command_a_coffee_with_one_sugar() {
        coffeeMachine.command(new Command(new Coffee(), new NumberOfSugar(1)));
        assertEquals("C:1:0", drinkMaker.getReceivedCommand());
    }

    @Test
    public void command_a_coffee_with_two_sugar() {
        coffeeMachine.command(new Command(new Coffee(), new NumberOfSugar(2)));
        assertEquals("C:2:0", drinkMaker.getReceivedCommand());
    }

    private class DrinkMakerDouble implements DrinkMaker {
        private String receivedCommand;

        @Override
        public void command(String command) {
            this.receivedCommand = command;
        }

        @Override
        public void deliverMessage(String message) {

        }

        public String getReceivedCommand() {
            return receivedCommand;
        }
    }
}
