package org.ssg.prossato.kata.fizzbuzz;

public class Place {
    private boolean reservee;

    public Place() {
        this.reservee = false;
    }

    public Place(boolean reservee) {
        this.reservee = reservee;
    }

    public boolean isDisponible() {
        return !reservee;
    }

    public void reserver() {
        reservee = true;
    }
}
