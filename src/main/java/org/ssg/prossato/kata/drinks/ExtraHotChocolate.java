package org.ssg.prossato.kata.drinks;

public class ExtraHotChocolate extends Chocolate {

    @Override
    public String code() {
        return super.code() + EXTRA_HOT_CODE;
    }
}
