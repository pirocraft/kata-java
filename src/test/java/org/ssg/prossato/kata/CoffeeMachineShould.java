package org.ssg.prossato.kata;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.ssg.prossato.kata.drinks.*;
import org.ssg.prossato.kata.spi.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class CoffeeMachineShould {

    private static final String SHORTAGE_DELIVERED_MESSAGE = "M:Can't be delivered because of a shortage";
    private DrinkMakerDouble drinkMaker;
    private CoffeeMachine coffeeMachine;
    private ReportPrinterDouble reportPrinter;
    private CommandRepository commandRepository;
    private boolean beverageShortage = false;
    private BeverageQuantityCheckerDouble beverageQuantityChecker;
    private EmailNotifierDouble emailNotifier;

    @BeforeEach
    void setUp() {
        drinkMaker = new DrinkMakerDouble();
        reportPrinter = new ReportPrinterDouble();
        commandRepository = new CommandRepositoryDouble();
        beverageQuantityChecker = new BeverageQuantityCheckerDouble();
        emailNotifier = new EmailNotifierDouble();
        coffeeMachine = new CoffeeMachine(drinkMaker, reportPrinter,
                commandRepository, beverageQuantityChecker,
                emailNotifier);
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
    void command_an_orange_juice() {
        coffeeMachine.command(new Command(new OrangeJuice(), new NumberOfSugar(0), new ClientMoney(0.8f)));
        assertEquals("O::", drinkMaker.getReceivedCommand());
    }

    @Test
    void command_an_extra_hot_coffee() {
        coffeeMachine.command(new Command(new ExtraHotCoffee(), new NumberOfSugar(0), new ClientMoney(0.6f)));
        assertEquals("Ch::", drinkMaker.getReceivedCommand());
    }

    @Test
    void command_an_extra_hot_chocolate() {
        coffeeMachine.command(new Command(new ExtraHotChocolate(), new NumberOfSugar(1), new ClientMoney(0.6f)));
        assertEquals("Hh:1:0", drinkMaker.getReceivedCommand());
    }

    @Test
    void command_an_extra_hot_tea() {
        coffeeMachine.command(new Command(new ExtraHotTea(), new NumberOfSugar(2), new ClientMoney(0.6f)));
        assertEquals("Th:2:0", drinkMaker.getReceivedCommand());
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

    @Test
    void refuse_an_orange_juice_command_without_enough_money() {
        coffeeMachine.command(new Command(new OrangeJuice(), new NumberOfSugar(0), new ClientMoney(0.0f)));
        assertNull(drinkMaker.getReceivedCommand());
        assertEquals("M:Missing 0.6€", drinkMaker.getDeliveredMessage());
    }

    @Test
    void print_the_sales_report_with_the_number_of_each_drink() {
        coffeeMachine.command(new Command(new OrangeJuice(), new NumberOfSugar(0), new ClientMoney(0.8f)));
        coffeeMachine.command(new Command(new Coffee(), new NumberOfSugar(1), new ClientMoney(0.8f)));
        coffeeMachine.command(new Command(new Coffee(), new NumberOfSugar(2), new ClientMoney(0.8f)));
        coffeeMachine.command(new Command(new Tea(), new NumberOfSugar(2), new ClientMoney(0.8f)));
        coffeeMachine.command(new Command(new ExtraHotCoffee(), new NumberOfSugar(2), new ClientMoney(0.8f)));
        coffeeMachine.command(new Command(new ExtraHotCoffee(), new NumberOfSugar(2), new ClientMoney(0.8f)));
        coffeeMachine.command(new Command(new ExtraHotTea(), new NumberOfSugar(2), new ClientMoney(0.8f)));
        coffeeMachine.command(new Command(new ExtraHotChocolate(), new NumberOfSugar(2), new ClientMoney(0.8f)));
        coffeeMachine.printSalesReport();

        Report receivedReport = reportPrinter.getReceivedReport();
        assertEquals(1, receivedReport.howManyDrinksOf(OrangeJuice.class));
        assertEquals(2, receivedReport.howManyDrinksOf(Coffee.class));
        assertEquals(0, receivedReport.howManyDrinksOf(Chocolate.class));
        assertEquals(1, receivedReport.howManyDrinksOf(Tea.class));
        assertEquals(2, receivedReport.howManyDrinksOf(ExtraHotCoffee.class));
        assertEquals(1, receivedReport.howManyDrinksOf(ExtraHotTea.class));
        assertEquals(1, receivedReport.howManyDrinksOf(ExtraHotChocolate.class));
    }

    @Test
    void print_the_sales_report_with_the_number_money_earned() {
        coffeeMachine.command(new Command(new OrangeJuice(), new NumberOfSugar(0), new ClientMoney(0.8f)));
        coffeeMachine.printSalesReport();

        Report receivedReport = reportPrinter.getReceivedReport();
        assertEquals(0.6f, receivedReport.moneyEarned());
    }

    @Test
    void inform_the_client_that_he_cant_be_delivered_an_orange_juice_cause_of_a_shortage() {
        beverageShortage = true;
        coffeeMachine.command(new Command(new OrangeJuice(), new NumberOfSugar(0), new ClientMoney(0.8f)));
        assertEquals(SHORTAGE_DELIVERED_MESSAGE, drinkMaker.getDeliveredMessage());
        assertEquals(new OrangeJuice().code(), beverageQuantityChecker.spiedDrink);
    }

    @Test
    void inform_the_client_that_he_cant_be_delivered_a_chocolate_cause_of_a_shortage() {
        beverageShortage = true;
        coffeeMachine.command(new Command(new Chocolate(), new NumberOfSugar(0), new ClientMoney(0.8f)));
        assertEquals(SHORTAGE_DELIVERED_MESSAGE, drinkMaker.getDeliveredMessage());
        assertEquals(new Chocolate().code(), beverageQuantityChecker.spiedDrink);
    }

    @Test
    void notify_the_compagny_that_there_is_a_tea_shortage() {
        beverageShortage = true;
        coffeeMachine.command(new Command(new Tea(), new NumberOfSugar(0), new ClientMoney(0.8f)));
        assertEquals(new Tea().code(), emailNotifier.getMissingDrinkNotified());
    }

    @Test
    void notify_the_compagny_that_there_is_a_chocolate_shortage() {
        beverageShortage = true;
        coffeeMachine.command(new Command(new Chocolate(), new NumberOfSugar(0), new ClientMoney(0.8f)));
        assertEquals(new Chocolate().code(), emailNotifier.getMissingDrinkNotified());
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

    private class ReportPrinterDouble implements ReportPrinter {
        private Report receivedReport;

        @Override
        public void print(Report report) {
            this.receivedReport = report;
        }

        public Report getReceivedReport() {
            return receivedReport;
        }
    }

    private class CommandRepositoryDouble implements CommandRepository {

        private final List<Command> commands = new ArrayList<>();

        @Override
        public void persist(Command command) {
            commands.add(command);
        }

        @Override
        public List<Command> getAllCommands() {
            return commands;
        }
    }

    private class BeverageQuantityCheckerDouble implements BeverageQuantityChecker {
        private String spiedDrink;

        @Override
        public boolean isEmpty(String drink) {
            spiedDrink = drink;
            return beverageShortage;
        }

        public String getSpiedDrink() {
            return spiedDrink;
        }
    }

    private class EmailNotifierDouble implements EmailNotifier {
        private String missingDrinkNotified;

        @Override
        public void notifyMissingDrink(String drink) {
            this.missingDrinkNotified = drink;
        }

        public String getMissingDrinkNotified() {
            return missingDrinkNotified;
        }
    }
}
