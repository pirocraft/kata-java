package org.ssg.prossato.kata;

public class NumberOfSugar {
    private final int number;

    public NumberOfSugar(int number) {
        this.number = number;
    }

    String code() {
        if (number > 0)
            return String.valueOf(number);
        return "";
    }

    String stickCode() {
        if (number > 0)
            return "0";
        return "";
    }
}
