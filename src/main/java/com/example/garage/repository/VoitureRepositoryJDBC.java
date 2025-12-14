package com.example.garage.repository;

import com.example.garage.model.Reparation;
import com.example.garage.model.Voiture;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class VoitureRepositoryJDBC implements Repository<Voiture> {

    private static final String INSERT_SQL = "INSERT INTO Voiture (client_id, marque, modele, immatriculation) VALUES (?, ?, ?, ?)";
    private static final String SELECT_BY_ID_SQL = "SELECT * FROM Voiture WHERE id = ?";
    private static final String SELECT_ALL_SQL = "SELECT * FROM Voiture";
    private static final String DELETE_SQL = "DELETE FROM Voiture WHERE id = ?";

    @Override
    public Voiture save(Voiture entity) {
        
        
        throw new UnsupportedOperationException("La méthode 'save' standard est dépréciée. Utilisez 'saveVoiturePourClient' dans le Service.");
    }
    
    
    public Voiture saveVoiturePourClient(Voiture entity, int clientId) {
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setInt(1, clientId); 
            stmt.setString(2, entity.getMarque());
            stmt.setString(3, entity.getModele());
            stmt.setString(4, entity.getImmatriculation());
            
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
    
    @Override
    public Optional<Voiture> findById(int id) {
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            
            stmt.setInt(1, id);
            
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return Optional.of(mapResultSetToVoiture(rs));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public List<Voiture> findAll() {
        List<Voiture> voitures = new ArrayList<>();
        try (Connection conn = DBUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SELECT_ALL_SQL)) {
            
            while (rs.next()) {
                voitures.add(mapResultSetToVoiture(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return voitures;
    }

    @Override
    public boolean delete(int id) {
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(DELETE_SQL)) {
            
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private Voiture mapResultSetToVoiture(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        
        String marque = rs.getString("marque");
        String modele = rs.getString("modele");
        String immatriculation = rs.getString("immatriculation");
        
        return new Voiture(id, marque, modele, immatriculation);
    }
    
    
    public List<Reparation> trouverReparationsParVoiture(int voitureId) {
        List<Reparation> reparations = new ArrayList<>();
        String SELECT_REPARATIONS_BY_VOITURE = "SELECT * FROM Reparation WHERE voitureId = ?";
        
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(SELECT_REPARATIONS_BY_VOITURE)) {

            stmt.setInt(1, voitureId);
            
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                   
                    Date sqlDate = rs.getDate("date"); 
                    LocalDate dateRep = (sqlDate != null) ? sqlDate.toLocalDate() : LocalDate.now(); 
                    
                    Reparation r = new Reparation(
                        rs.getInt("id"),
                        rs.getInt("voitureId"),
                        rs.getString("description"),
                        rs.getDouble("cout"),
                        dateRep
                    );
                    reparations.add(r);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reparations;
    }
}