package org.ssg.pirocraft.kata.gildedrose.infrastructure;

import org.ssg.pirocraft.kata.gildedrose.Produit;

import java.util.List;
import java.util.UUID;

/**
 * Dépôt de persistance des {@link Produit}<br>
 * Les modifications apportées aux {@link Produit} sont automatiquement persistées
 */
public interface ProduitRepository {
    UUID addProduit(Produit produit);

    Produit getProduit(UUID idProduit);

    List<Produit> getProduits();
}
