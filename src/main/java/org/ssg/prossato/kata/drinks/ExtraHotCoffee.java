package org.ssg.prossato.kata.drinks;

public class ExtraHotCoffee extends Coffee {
    @Override
    public String code() {
        return super.code() + EXTRA_HOT_CODE;
    }
}
