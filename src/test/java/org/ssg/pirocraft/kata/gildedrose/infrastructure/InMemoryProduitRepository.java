package org.ssg.pirocraft.kata.gildedrose.infrastructure;

import org.ssg.pirocraft.kata.gildedrose.Produit;

import java.util.*;

/**
 * Stub pour besoin de tests uniquement
 */
public class InMemoryProduitRepository implements ProduitRepository {
    private Map<UUID, Produit> produits = new HashMap<>();

    @Override
    public UUID addProduit(Produit produit) {
        UUID newId = UUID.randomUUID();
        produits.put(newId, produit);
        return newId;
    }

    @Override
    public Produit getProduit(UUID idProduit) {
        return produits.get(idProduit);
    }

    @Override
    public List<Produit> getProduits() {
        return new ArrayList<>(produits.values());
    }
}
