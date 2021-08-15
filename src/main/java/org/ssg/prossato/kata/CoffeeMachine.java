package org.ssg.prossato.kata;

import org.ssg.prossato.kata.spi.*;

public class CoffeeMachine {
    private static final String SHORTAGE_DELIVERED_MESSAGE = "M:Can't be delivered because of a shortage";
    private final DrinkMaker drinkMaker;
    private final ReportPrinter printer;
    private final CommandRepository commandRepository;
    private final BeverageQuantityChecker beverageQuantityChecker;
    private final EmailNotifier emailNotifier;

    public CoffeeMachine(DrinkMaker drinkMaker, ReportPrinter printer, CommandRepository commandRepository,
                         BeverageQuantityChecker beverageQuantityChecker, EmailNotifier emailNotifier) {
        this.drinkMaker = drinkMaker;
        this.printer = printer;
        this.commandRepository = commandRepository;
        this.beverageQuantityChecker = beverageQuantityChecker;
        this.emailNotifier = emailNotifier;
    }

    public void command(Command command) {
        if (beverageQuantityChecker.isEmpty(command.drinkCode())) {
            drinkMaker.deliverMessage(SHORTAGE_DELIVERED_MESSAGE);
            emailNotifier.notifyMissingDrink(command.drinkCode());
        } else if (command.enoughMoney()) {
            drinkMaker.command(command.encodedCommand());
            commandRepository.persist(command);
        } else {
            drinkMaker.deliverMessage(command.missingMoney());
        }
    }

    public void printSalesReport() {
        printer.print(new Report(commandRepository.getAllCommands()));
    }
}
