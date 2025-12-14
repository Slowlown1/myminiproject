package com.example.garage.repository;

import com.example.garage.model.Facture;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FactureRepositoryJDBC implements Repository<Facture> {

    private static final String INSERT_SQL = "INSERT INTO Facture (client_id, date, total, lignes) VALUES (?, ?, ?, ?)";
    private static final String SELECT_BY_ID_SQL = "SELECT * FROM Facture WHERE id = ?";
    private static final String SELECT_ALL_SQL = "SELECT * FROM Facture";
    private static final String DELETE_SQL = "DELETE FROM Facture WHERE id = ?";

    @Override
    public Facture save(Facture entity) {
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS)) {

            
            String lignesAsString = String.join(";", entity.getLignes());

            stmt.setInt(1, entity.getClientId());
            stmt.setObject(2, entity.getDate());
            stmt.setDouble(3, entity.getTotal());
            stmt.setString(4, lignesAsString);
            
            stmt.executeUpdate();

            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    entity.setId(generatedKeys.getInt(1));
                }
            }
            return entity;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // Implémentation complète omise pour concision, mais elle doit suivre le même modèle que les autres
    public Optional<Facture> findById(int id) {
        
        return Optional.empty();
    }
    
    @Override
    public List<Facture> findAll() {
       
        return new ArrayList<>();
    }

    @Override
    public boolean delete(int id) {
        
        return false;
    }
}