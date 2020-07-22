package org.ssg.pirocraft.kata.gildedrose.infrastructure;

import org.ssg.pirocraft.kata.gildedrose.Produit;

import java.util.ArrayList;
import java.util.List;

public class InMemoryProduitRepository implements ProduitRepository {
    private List<Produit> produits = new ArrayList<>();

    @Override
    public void addProduit(Produit produit) {
        produits.add(produit);
    }

    @Override
    public List<Produit> getProduits() {
        return produits;
    }
}
