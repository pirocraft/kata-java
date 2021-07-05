package org.ssg.prossato.kata.drinks;

public class Coffee implements Drink {
    @Override
    public String code() {
        return "C";
    }

    @Override
    public float price() {
        return 0.6f;
    }
}
