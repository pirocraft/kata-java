package org.ssg.prossato.kata;

import org.ssg.prossato.kata.drinks.Drink;

import java.text.MessageFormat;

public class Command {
    private static final String MISSING_MONEY_PATTERN = "M:Missing {0}€";
    private final Drink drink;
    private final NumberOfSugar numberOfSugar;
    private final ClientMoney clientMoney;

    public Command(Drink drink, NumberOfSugar numberOfSugar, ClientMoney clientMoney) {
        this.drink = drink;
        this.numberOfSugar = numberOfSugar;
        this.clientMoney = clientMoney;
    }

    String encodedCommand() {
        return drink.code() + ":" + numberOfSugar.code() + ":" + numberOfSugar.stickCode();
    }

    boolean enoughMoney() {
        return clientMoney.cover(drink.price());
    }

    String missingMoney() {
        String missingMoney = clientMoney.missingMoney(drink.price());
        return MessageFormat.format(MISSING_MONEY_PATTERN, missingMoney);
    }

    public boolean containsA(Class<? extends Drink> drinkType) {
        return drink.getClass().equals(drinkType);
    }

    public float moneyEarned() {
        return drink.price();
    }
}
