package org.ssg.prossato.kata.fizzbuzz;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class TheatreTest {
    @Test
    public void doit_proposer_une_place() {
        Theatre theatre = theatreAvecPlacesDisponibles();

        assertThat(theatre.proposerPlace(1).size()).isEqualTo(1);
    }

    @Test
    public void doit_reserver_une_place() {
        Theatre theatre = theatreAvecPlacesDisponibles();
        Place place = new Place();

        assertThat(theatre.reserver(place)).isTrue();
    }

    @Test
    public void doit_proposer_deux_places() {
        Theatre theatre = theatreAvecPlacesDisponibles();
        List<Place> places = theatre.proposerPlace(2);

        assertThat(places.size()).isEqualTo(2);
    }

    @Test
    public void doit_proposer_une_place_disponible_quand_theatre_2_places_dont_1_reservee() {
        List<Place> placesDuTheatre = new ArrayList<>(2);
        Place placeReservee = new Place(true);
        placesDuTheatre.add(placeReservee);
        Place placeDisponible = new Place(false);
        placesDuTheatre.add(placeDisponible);
        Theatre theatre = new Theatre(placesDuTheatre);

        List<Place> places = theatre.proposerPlace(1);

        assertThat(places.size()).isEqualTo(1);
        assertThat(places.get(0)).isEqualTo(placeDisponible);
    }

    @Test
    public void doit_proposer_une_place_disponible_quand_theatre_2_places_apres_1_reservation() {
        Theatre theatre = theatreAvecPlacesDisponibles();

        List<Place> places = theatre.proposerPlace(1);
        Place placeReservee = places.get(0);
        theatre.reserver(placeReservee);
        Place placeProposee = theatre.proposerPlace(1).get(0);

        assertThat(placeProposee).isNotEqualTo(placeReservee);
    }

    private Theatre theatreAvecPlacesDisponibles() {
        List<Place> placesDuTheatre = new ArrayList<>(2);
        placesDuTheatre.add(new Place());
        placesDuTheatre.add(new Place());
        Theatre theatre = new Theatre(placesDuTheatre);
        return theatre;
    }
}
