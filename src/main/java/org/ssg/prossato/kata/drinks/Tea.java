package org.ssg.prossato.kata.drinks;

public class Tea implements Drink {
    @Override
    public String code() {
        return "T";
    }

    @Override
    public float price() {
        return 0.4f;
    }
}
