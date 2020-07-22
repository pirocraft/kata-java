package org.ssg.pirocraft.kata.gildedrose;

import org.junit.jupiter.api.Test;
import org.ssg.pirocraft.kata.gildedrose.infrastructure.InMemoryProduitRepository;
import org.ssg.pirocraft.kata.gildedrose.infrastructure.ProduitRepository;

import static org.assertj.core.api.Assertions.assertThat;

class CommerceDoit {
    @Test
    void mettre_a_jour_la_qualite_des_produits() {
        Produit produit = new Produit();
        produit.setQualite(5);
        ProduitRepository produitRepository = new InMemoryProduitRepository();
        produitRepository.addProduit(produit);
        Commerce commerce = new Commerce(produitRepository);

        commerce.mettreAJour();

        assertThat(produit.getQualite()).isEqualTo(4);
    }
}
