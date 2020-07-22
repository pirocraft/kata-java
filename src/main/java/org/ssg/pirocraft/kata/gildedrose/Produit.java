package org.ssg.pirocraft.kata.gildedrose;

import java.util.UUID;

public class Produit {
    private UUID identifiant;
    private int qualite;
    private int venduDans;

    public Produit(UUID idFigurineBatman) {
        this.identifiant = idFigurineBatman;
    }

    public UUID getIdentifiant() {
        return identifiant;
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
