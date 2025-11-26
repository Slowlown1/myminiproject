package com.example.garage.model;

import java.time.LocalDate;
import java.util.Objects;

public class Reparation implements Identifiable {
    private int id;
    private int voitureId;
    private String description;
    private double cout;
    private LocalDate date;

    public Reparation() { }

    public Reparation(int id, int voitureId, String description, double cout, LocalDate date) {
        this.id = id;
        this.voitureId = voitureId;
        this.description = description;
        this.cout = cout;
        this.date = date;
    }

    @Override
    public int getId() { return id; }
    @Override
    public void setId(int id) { this.id = id; }

    public int getVoitureId() { return voitureId; }
    public void setVoitureId(int voitureId) { this.voitureId = voitureId; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public double getCout() { return cout; }
    public void setCout(double cout) { this.cout = cout; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }

    @Override
    public String toString() {
        return "Reparation{" + "id=" + id + ", voitureId=" + voitureId +
               ", description='" + description + '\'' + ", cout=" + cout +
               ", date=" + date + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Reparation)) return false;
        Reparation that = (Reparation) o;
        return id == that.id;
    }

    @Override
    public int hashCode() { return Objects.hash(id); }
}
