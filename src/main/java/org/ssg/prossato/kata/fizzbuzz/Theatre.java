package org.ssg.prossato.kata.fizzbuzz;

import java.util.ArrayList;
import java.util.List;

public class Theatre {
    private final List<Place> places;

    public Theatre(List<Place> placesDuTheatre) {
        this.places = placesDuTheatre;
    }

    public List<Place> proposerPlace(int nombreDePlaceSouhaitee) {
        List<Place> placesProposees = new ArrayList<>();
        for (int i = 0; i < nombreDePlaceSouhaitee; i++) {
            ajouterPremierePlaceDisponible(placesProposees);
        }
        return placesProposees;
    }

    private void ajouterPremierePlaceDisponible(List<Place> placesProposees) {
        places.stream()
                .filter(Place::isDisponible)
                .findFirst()
                .ifPresent(placesProposees::add);
    }

    public boolean reserver(Place place) {
        place.reserver();
        return true;
    }
}
