package org.ssg.prossato.kata;

public class Command {
    private final Drink drink;
    private final NumberOfSugar numberOfSugar;

    public Command(Drink drink, NumberOfSugar numberOfSugar) {
        this.drink = drink;
        this.numberOfSugar = numberOfSugar;
    }

    String encodedCommand() {
        return drink.code()+":" + numberOfSugar.code() + ":" + numberOfSugar.stickCode();
    }
}
