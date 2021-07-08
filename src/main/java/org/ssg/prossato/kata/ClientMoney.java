package org.ssg.prossato.kata;

import java.text.DecimalFormat;

public class ClientMoney {
    private final float money;

    public ClientMoney(float money) {
        this.money = money;
    }

    boolean cover(float price) {
        return money >= price;
    }

    String missingMoney(float price) {
        var decimalFormat = new DecimalFormat("#.#");
        return decimalFormat.format(price - money).replace(',', '.');
    }
}
