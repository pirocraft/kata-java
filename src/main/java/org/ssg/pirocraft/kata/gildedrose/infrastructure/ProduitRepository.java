package org.ssg.pirocraft.kata.gildedrose.infrastructure;

import org.ssg.pirocraft.kata.gildedrose.Produit;

import java.util.List;

public interface ProduitRepository {
    void addProduit(Produit produit);

    List<Produit> getProduits();
}
