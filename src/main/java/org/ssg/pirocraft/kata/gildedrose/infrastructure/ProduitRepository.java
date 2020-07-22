package org.ssg.pirocraft.kata.gildedrose.infrastructure;

import org.ssg.pirocraft.kata.gildedrose.Produit;

import java.util.List;
import java.util.UUID;

/**
 * Dépôt de persistance des {@link Produit}
 */
public interface ProduitRepository {
    /**
     * @param produit le produit à persister ou à mettre à jour
     */
    void save(Produit produit);

    /**
     * @return une copie du {@link Produit} persisté
     */
    Produit getProduit(UUID identifiantProduit);

    /**
     * @return une liste de copies des {@link Produit} persistés
     */
    List<Produit> getProduits();
}
