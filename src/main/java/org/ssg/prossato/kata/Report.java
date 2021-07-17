package org.ssg.prossato.kata;

import org.ssg.prossato.kata.drinks.Drink;

import java.util.List;

public class Report {
    private final List<Command> commands;

    public Report(List<Command> commands) {
        this.commands = commands;
    }

    public int howManyDrinksOf(Class<? extends Drink> drinkType) {
        return (int) commands.stream().filter(command -> command.containsA(drinkType)).count();
    }

    public float moneyEarned() {
        return commands.stream().reduce(0f, (subtotal, command) -> subtotal + command.moneyEarned(), (aFloat, aFloat2) -> aFloat + aFloat2);
    }
}
