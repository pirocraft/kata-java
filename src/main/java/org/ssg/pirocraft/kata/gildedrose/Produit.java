package org.ssg.pirocraft.kata.gildedrose;

import java.util.UUID;

public class Produit {
    private UUID identifiant;
    private String nom;
    private int qualite;
    private int venduDans;

    /**
     * @param identifiant l'identifiant unique du produit
     */
    public Produit(UUID identifiant) {
        this.identifiant = identifiant;
    }

    public UUID getIdentifiant() {
        return identifiant;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setQualite(int qualite) {
        this.qualite = qualite;
    }

    public int getQualite() {
        return qualite;
    }

    public int getVenduDans() {
        return venduDans;
    }

    public void setVenduDans(int venduDans) {
        this.venduDans = venduDans;
    }
}
