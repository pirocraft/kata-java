package org.ssg.pirocraft.kata.gildedrose.infrastructure;

import org.ssg.pirocraft.kata.gildedrose.Produit;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Stub pour besoin de tests uniquement
 */
public class InMemoryProduitRepository implements ProduitRepository {
    private Map<UUID, Produit> produits = new HashMap<>();

    @Override
    public void save(Produit produit) {
        produits.put(produit.getIdentifiant(), produit);
    }

    @Override
    public Produit getProduit(UUID identifiantProduit) {
        Produit produit = produits.get(identifiantProduit);
        return copyProduit(produit);
    }

    @Override
    public List<Produit> getProduits() {
        return produits.values().stream().map((this::copyProduit)).collect(Collectors.toList());
    }

    private Produit copyProduit(Produit produit) {
        Produit copie = new Produit(produit.getIdentifiant());
        copie.setQualite(produit.getQualite());
        copie.setVenduDans(produit.getVenduDans());
        return copie;
    }
}
