package org.ssg.prossato.kata;

import java.text.DecimalFormat;

public class ClientMoney {
    private final float money;

    public ClientMoney(float money) {
        this.money = money;
    }

    public boolean cover(float price) {
        return money >= price;
    }

    public String missingMoney(float price) {
        DecimalFormat decimalFormat = new DecimalFormat("#.#");
        return decimalFormat.format(price - money).replace(',', '.');
    }
}
