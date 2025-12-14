package com.example.garage.model;

import java.util.Objects;
import java.util.List;
import java.util.ArrayList;

public class Voiture implements Identifiable {
    private int id;
    private String marque;
    private String modele;
    private String immatriculation;
    
    // NOUVEAU: Liste pour les réparations associées
    private List<Reparation> reparations; 

    public Voiture() { 
        this.reparations = new ArrayList<>();
    }

    public Voiture(int id, String marque, String modele, String immatriculation) {
        this.id = id;
        this.marque = marque;
        this.modele = modele;
        this.immatriculation = immatriculation;
        this.reparations = new ArrayList<>(); // Initialisation de la liste
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

    // NOUVEAU: Méthode pour l'ajout de réparations (utilisée par le Repository)
    public void ajouterReparation(Reparation reparation) {
        this.reparations.add(reparation);
    }
    
    public List<Reparation> getReparations() {
        return reparations;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n  - Voiture ID: ").append(id)
          .append(", Immatriculation: ").append(immatriculation)
          .append(", Marque: ").append(marque)
          .append(", Modèle: ").append(modele);
        
        // Affichage des réparations (maintenant que la liste existe)
        if (!reparations.isEmpty()) {
            sb.append("\n    [RÉPARATIONS] : ");
            for (Reparation r : reparations) {
                sb.append("\n      > ").append(r); 
            }
        } else {
            sb.append(" (Aucune réparation enregistrée)");
        }
        return sb.toString();
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