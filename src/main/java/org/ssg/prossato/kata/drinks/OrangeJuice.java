package org.ssg.prossato.kata.drinks;

public class OrangeJuice implements Drink {
    @Override
    public String code() {
        return "O";
    }

    @Override
    public float price() {
        return 0.6f;
    }
}
