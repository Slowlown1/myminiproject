package com.example.garage.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Client implements Identifiable {
    private int id;
    private String nom;
    private String prenom;
    private String telephone;
    private final List<Voiture> voitures = new ArrayList<>();

    public Client() { }

    public Client(int id, String nom, String prenom, String telephone) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
    }

    @Override
    public int getId() { return id; }
    @Override
    public void setId(int id) { this.id = id; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getPrenom() { return prenom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }

    public String getTelephone() { return telephone; }
    public void setTelephone(String telephone) { this.telephone = telephone; }

    public List<Voiture> getVoitures() { return voitures; }
    public void ajouterVoiture(Voiture v) {
        if (v != null) voitures.add(v);
    }

    @Override
    public String toString() {
        return "Client{" + "id=" + id + ", nom='" + nom + '\'' +
               ", prenom='" + prenom + '\'' + ", telephone='" + telephone + '\'' +
               ", voitures=" + voitures + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Client)) return false;
        Client client = (Client) o;
        return id == client.id;
    }

    @Override
    public int hashCode() { return Objects.hash(id); }
}
