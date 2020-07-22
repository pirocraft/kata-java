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
    private UUID idProduit;

    @BeforeEach
    void setUp() {
        produitRepository = new InMemoryProduitRepository();
        commerce = new Commerce(produitRepository);
        Produit produit = new Produit();
        produit.setQualite(5);
        idProduit = produitRepository.addProduit(produit);
    }

    @Test
    void mettre_a_jour_la_qualite_des_produits() {
        commerce.mettreAJour();

        Produit produitStocke = produitRepository.getProduit(idProduit);
        assertThat(produitStocke.getQualite()).isEqualTo(4);
    }
}
