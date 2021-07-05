package org.ssg.prossato.kata;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.ssg.prossato.kata.drinks.Chocolate;
import org.ssg.prossato.kata.drinks.Coffee;
import org.ssg.prossato.kata.drinks.Tea;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class CoffeeMachineShould {

    private DrinkMakerDouble drinkMaker;
    private CoffeeMachine coffeeMachine;

    @BeforeEach
    void setUp() {
        drinkMaker = new DrinkMakerDouble();
        coffeeMachine = new CoffeeMachine(drinkMaker);
    }

    @Test
    void command_a_tea_with_no_sugar() {
        coffeeMachine.command(new Command(new Tea(), new NumberOfSugar(0), new ClientMoney(0.6f)));
        assertEquals("T::", drinkMaker.getReceivedCommand());
    }

    @Test
    void command_a_tea_with_one_sugar() {
        coffeeMachine.command(new Command(new Tea(), new NumberOfSugar(1), new ClientMoney(0.6f)));
        assertEquals("T:1:0", drinkMaker.getReceivedCommand());
    }

    @Test
    void command_a_tea_with_two_sugar() {
        coffeeMachine.command(new Command(new Tea(), new NumberOfSugar(2), new ClientMoney(0.6f)));
        assertEquals("T:2:0", drinkMaker.getReceivedCommand());
    }

    @Test
    void command_a_chocolate_with_no_sugar() {
        coffeeMachine.command(new Command(new Chocolate(), new NumberOfSugar(0), new ClientMoney(0.6f)));
        assertEquals("H::", drinkMaker.getReceivedCommand());
    }

    @Test
    void command_a_chocolate_with_one_sugar() {
        coffeeMachine.command(new Command(new Chocolate(), new NumberOfSugar(1), new ClientMoney(0.6f)));
        assertEquals("H:1:0", drinkMaker.getReceivedCommand());
    }

    @Test
    void command_a_chocolate_with_two_sugar() {
        coffeeMachine.command(new Command(new Chocolate(), new NumberOfSugar(2), new ClientMoney(0.6f)));
        assertEquals("H:2:0", drinkMaker.getReceivedCommand());
    }

    @Test
    void command_a_coffee_with_no_sugar() {
        coffeeMachine.command(new Command(new Coffee(), new NumberOfSugar(0), new ClientMoney(0.6f)));
        assertEquals("C::", drinkMaker.getReceivedCommand());
    }

    @Test
    void command_a_coffee_with_one_sugar() {
        coffeeMachine.command(new Command(new Coffee(), new NumberOfSugar(1), new ClientMoney(0.7f)));
        assertEquals("C:1:0", drinkMaker.getReceivedCommand());
    }

    @Test
    void command_a_coffee_with_two_sugar() {
        coffeeMachine.command(new Command(new Coffee(), new NumberOfSugar(2), new ClientMoney(0.8f)));
        assertEquals("C:2:0", drinkMaker.getReceivedCommand());
    }

    @Test
    void refuse_a_coffee_command_without_enough_money() {
        coffeeMachine.command(new Command(new Coffee(), new NumberOfSugar(0), new ClientMoney(0.4f)));
        assertNull(drinkMaker.getReceivedCommand());
        assertEquals("M:Missing 0.2€", drinkMaker.getDeliveredMessage());
    }

    @Test
    void refuse_a_chocolate_command_without_enough_money() {
        coffeeMachine.command(new Command(new Chocolate(), new NumberOfSugar(0), new ClientMoney(0.4f)));
        assertNull(drinkMaker.getReceivedCommand());
        assertEquals("M:Missing 0.1€", drinkMaker.getDeliveredMessage());
    }

    @Test
    void refuse_a_tea_command_without_enough_money() {
        coffeeMachine.command(new Command(new Tea(), new NumberOfSugar(0), new ClientMoney(0.0f)));
        assertNull(drinkMaker.getReceivedCommand());
        assertEquals("M:Missing 0.4€", drinkMaker.getDeliveredMessage());
    }


    private class DrinkMakerDouble implements DrinkMaker {
        private String receivedCommand;
        private String deliveredMessage;

        @Override
        public void command(String command) {
            this.receivedCommand = command;
        }

        @Override
        public void deliverMessage(String message) {
            this.deliveredMessage = message;
        }

        public String getReceivedCommand() {
            return receivedCommand;
        }

        public String getDeliveredMessage() {
            return deliveredMessage;
        }
    }
}
