package org.ssg.prossato.kata.fizzbuzz;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ChiffreEnLettresShould {

    private ChiffreEnLettres chiffreEnLettres;

    @BeforeEach
    void setUp() {
        chiffreEnLettres = new ChiffreEnLettres();
    }

    @Test
    void renvoyer_nombre_quand_nom_unique() {
        assertThat(chiffreEnLettres.enLettres(1)).isEqualTo("un");
        assertThat(chiffreEnLettres.enLettres(2)).isEqualTo("deux");
        assertThat(chiffreEnLettres.enLettres(3)).isEqualTo("trois");
        assertThat(chiffreEnLettres.enLettres(4)).isEqualTo("quatre");
        assertThat(chiffreEnLettres.enLettres(5)).isEqualTo("cinq");
        assertThat(chiffreEnLettres.enLettres(6)).isEqualTo("six");
        assertThat(chiffreEnLettres.enLettres(7)).isEqualTo("sept");
        assertThat(chiffreEnLettres.enLettres(8)).isEqualTo("huit");
        assertThat(chiffreEnLettres.enLettres(9)).isEqualTo("neuf");
        assertThat(chiffreEnLettres.enLettres(10)).isEqualTo("dix");
        assertThat(chiffreEnLettres.enLettres(11)).isEqualTo("onze");
        assertThat(chiffreEnLettres.enLettres(12)).isEqualTo("douze");
        assertThat(chiffreEnLettres.enLettres(13)).isEqualTo("treize");
        assertThat(chiffreEnLettres.enLettres(14)).isEqualTo("quatorze");
        assertThat(chiffreEnLettres.enLettres(15)).isEqualTo("quinze");
        assertThat(chiffreEnLettres.enLettres(16)).isEqualTo("seize");
//        assertThat(chiffreEnLettres.enLettres(17)).isEqualTo("dix-sept");
    }
}
