package org.ssg.prossato.kata;

import java.util.List;

public class CoffeeMachine {
    private final DrinkMaker drinkMaker;
    private final ReportPrinter printer;
    private final CommandRepository commandRepository;

    public CoffeeMachine(DrinkMaker drinkMaker, ReportPrinter printer, CommandRepository commandRepository) {
        this.drinkMaker = drinkMaker;
        this.printer = printer;
        this.commandRepository = commandRepository;
    }

    public void command(Command command) {
        if (command.enoughMoney()) {
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
