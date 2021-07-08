package org.ssg.prossato.kata.drinks;

public class ExtraHotTea extends Tea {
    @Override
    public String code() {
        return super.code() + EXTRA_HOT_CODE;
    }
}
