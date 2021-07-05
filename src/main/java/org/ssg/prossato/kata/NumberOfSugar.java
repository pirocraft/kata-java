package org.ssg.prossato.kata;

public class NumberOfSugar {
    private final int numberOfSugar;

    public NumberOfSugar(int numberOfSugar) {
        this.numberOfSugar = numberOfSugar;
    }

    public String code() {
        if (numberOfSugar > 0)
            return String.valueOf(numberOfSugar);
        return "";
    }

    public String stickCode() {
        if (numberOfSugar >0)
            return "0";
        return "";
    }
}
