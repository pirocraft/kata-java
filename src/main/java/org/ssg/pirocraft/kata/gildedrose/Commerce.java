package org.ssg.pirocraft.kata.gildedrose;

import org.ssg.pirocraft.kata.gildedrose.infrastructure.ProduitRepository;

public class Commerce {
    private ProduitRepository produitRepository;

    public Commerce(ProduitRepository produitRepository) {
        this.produitRepository = produitRepository;
    }

    public void mettreAJour() {
        for (Produit produit : produitRepository.getProduits()) {
            produit.setQualite(produit.getQualite() - 1);
            produit.setVenduDans(produit.getVenduDans() - 1);
            produitRepository.save(produit);
        }
    }
}
