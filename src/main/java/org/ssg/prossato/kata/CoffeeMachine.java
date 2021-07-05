package org.ssg.prossato.kata;

public class CoffeeMachine {
    private final DrinkMaker drinkMaker;

    public CoffeeMachine(DrinkMaker drinkMaker) {
        this.drinkMaker = drinkMaker;
    }

    public void command(Command command) {
        if (command.enoughMoney()) {
            drinkMaker.command(command.encodedCommand());
        } else {
            drinkMaker.deliverMessage(command.missingMoney());
        }
    }

}
