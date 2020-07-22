package org.ssg.pirocraft.kata.gildedrose;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.ssg.pirocraft.kata.gildedrose.infrastructure.InMemoryProduitRepository;
import org.ssg.pirocraft.kata.gildedrose.infrastructure.ProduitRepository;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

class CommerceDoit {
    private ProduitRepository produitRepository;
    private Commerce commerce;

    private static final int QUALITE_FIGURINE_BATMAN = 5;
    private static final int QUALITE_TASER = 10;
    private static final int FIGURINE_BATMAN_VENDU_DANS = 7;
    private static final int TASER_VENDU_DANS = 6;
    private UUID idFigurineBatman = UUID.randomUUID();
    private UUID idTaser = UUID.randomUUID();

    @BeforeEach
    void setUp() {
        produitRepository = new InMemoryProduitRepository();
        commerce = new Commerce(produitRepository);

        Produit figurineBatman = new Produit(idFigurineBatman);
        figurineBatman.setQualite(QUALITE_FIGURINE_BATMAN);
        figurineBatman.setVenduDans(FIGURINE_BATMAN_VENDU_DANS);
        produitRepository.save(figurineBatman);

        Produit taser = new Produit(idTaser);
        taser.setQualite(QUALITE_TASER);
        taser.setVenduDans(TASER_VENDU_DANS);
        produitRepository.save(taser);
    }

    @Test
    void mettre_a_jour_la_qualite_des_produits() {
        commerce.mettreAJour();

        Produit figurineBatman = produitRepository.getProduit(idFigurineBatman);
        Produit taser = produitRepository.getProduit(idTaser);
        assertThat(figurineBatman.getQualite()).isEqualTo(QUALITE_FIGURINE_BATMAN - 1);
        assertThat(taser.getQualite()).isEqualTo(QUALITE_TASER - 1);
    }

    @Test
    void mettre_a_jour_la_duree_de_vente_des_produits() {
        commerce.mettreAJour();

        Produit figurineBatman = produitRepository.getProduit(idFigurineBatman);
        Produit taser = produitRepository.getProduit(idTaser);
        assertThat(figurineBatman.getVenduDans()).isEqualTo(FIGURINE_BATMAN_VENDU_DANS - 1);
        assertThat(taser.getVenduDans()).isEqualTo(TASER_VENDU_DANS - 1);
    }
}
