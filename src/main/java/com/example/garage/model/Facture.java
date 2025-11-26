package com.example.garage.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Facture implements Identifiable {
    private int id;
    private int clientId;
    private LocalDate date;
    private final List<String> lignes = new ArrayList<>();
    private double total;

    public Facture() { }

    public Facture(int id, int clientId, LocalDate date) {
        this.id = id;
        this.clientId = clientId;
        this.date = date;
        this.total = 0.0;
    }

    @Override
    public int getId() { return id; }
    @Override
    public void setId(int id) { this.id = id; }

    public int getClientId() { return clientId; }
    public void setClientId(int clientId) { this.clientId = clientId; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }

    public List<String> getLignes() { return List.copyOf(lignes); }

    public double getTotal() { return total; }

    public void ajouterLigne(String description, double prix) {
        if (description == null) description = "";
        lignes.add(description + " : " + prix + " DH");
        total += prix;
    }

    @Override
    public String toString() {
        return "Facture{" + "id=" + id + ", clientId=" + clientId + ", date=" + date +
               ", total=" + total + ", lignes=" + lignes + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Facture)) return false;
        Facture facture = (Facture) o;
        return id == facture.id;
    }

    @Override
    public int hashCode() { return Objects.hash(id); }
}
