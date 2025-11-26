package com.example.garage.model;

import java.util.Objects;

public class Voiture implements Identifiable {
    private int id;
    private String marque;
    private String modele;
    private String immatriculation;

    public Voiture() { }

    public Voiture(int id, String marque, String modele, String immatriculation) {
        this.id = id;
        this.marque = marque;
        this.modele = modele;
        this.immatriculation = immatriculation;
    }

    @Override
    public int getId() { return id; }
    @Override
    public void setId(int id) { this.id = id; }

    public String getMarque() { return marque; }
    public void setMarque(String marque) { this.marque = marque; }

    public String getModele() { return modele; }
    public void setModele(String modele) { this.modele = modele; }

    public String getImmatriculation() { return immatriculation; }
    public void setImmatriculation(String immatriculation) { this.immatriculation = immatriculation; }

    @Override
    public String toString() {
        return "Voiture{" + "id=" + id + ", " + marque + " " + modele + " (" + immatriculation + ")}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Voiture)) return false;
        Voiture voiture = (Voiture) o;
        return id == voiture.id;
    }

    @Override
    public int hashCode() { return Objects.hash(id); }
}
