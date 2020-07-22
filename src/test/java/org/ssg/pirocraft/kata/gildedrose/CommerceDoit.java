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
    private UUID idFigurineBatman;
    private UUID idTaser;

    @BeforeEach
    void setUp() {
        produitRepository = new InMemoryProduitRepository();
        commerce = new Commerce(produitRepository);

        Produit figurineBatman = new Produit();
        figurineBatman.setQualite(QUALITE_FIGURINE_BATMAN);
        idFigurineBatman = produitRepository.addProduit(figurineBatman);

        Produit taser = new Produit();
        taser.setQualite(QUALITE_TASER);
        idTaser = produitRepository.addProduit(taser);
    }

    @Test
    void mettre_a_jour_la_qualite_des_produits() {
        commerce.mettreAJour();

        Produit figurineBatmanStockee = produitRepository.getProduit(idFigurineBatman);
        Produit taserStocke = produitRepository.getProduit(idTaser);
        assertThat(figurineBatmanStockee.getQualite()).isEqualTo(QUALITE_FIGURINE_BATMAN - 1);
        assertThat(taserStocke.getQualite()).isEqualTo(QUALITE_TASER - 1);
    }
}
