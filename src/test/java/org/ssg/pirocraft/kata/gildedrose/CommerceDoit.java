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
    private UUID idFigurineBatman = UUID.randomUUID();
    private UUID idTaser = UUID.randomUUID();

    @BeforeEach
    void setUp() {
        produitRepository = new InMemoryProduitRepository();
        commerce = new Commerce(produitRepository);

        Produit figurineBatman = new Produit(idFigurineBatman);
        figurineBatman.setQualite(QUALITE_FIGURINE_BATMAN);
        produitRepository.save(figurineBatman);

        Produit taser = new Produit(idTaser);
        taser.setQualite(QUALITE_TASER);
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
}
