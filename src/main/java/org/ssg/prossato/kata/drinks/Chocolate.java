package org.ssg.prossato.kata.drinks;

public class Chocolate implements Drink {
    @Override
    public String code() {
        return "H";
    }

    @Override
    public float price() {
        return 0.5f;
    }
}
