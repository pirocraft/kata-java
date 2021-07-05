package org.ssg.prossato.kata;

public class CoffeeMachine {
    private final DrinkMaker drinkMaker;

    public CoffeeMachine(DrinkMaker drinkMaker) {
        this.drinkMaker = drinkMaker;
    }

    public void command(Command command) {
        drinkMaker.command(command.encodedCommand());
    }

}
