package com.example.garage.repository;

import com.example.garage.model.Reparation;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ReparationRepositoryJDBC implements Repository<Reparation> {

    private static final String INSERT_SQL = "INSERT INTO Reparation (voitureId, description, cout, date) VALUES (?, ?, ?, ?)";
    private static final String SELECT_BY_ID_SQL = "SELECT * FROM Reparation WHERE id = ?";
    private static final String SELECT_ALL_SQL = "SELECT * FROM Reparation";
    private static final String DELETE_SQL = "DELETE FROM Reparation WHERE id = ?";
    
 

    @Override
    public Reparation save(Reparation entity) {
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setInt(1, entity.getVoitureId());
            stmt.setString(2, entity.getDescription());
            stmt.setDouble(3, entity.getCout());
            stmt.setObject(4, entity.getDate()); 
            
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
    public Optional<Reparation> findById(int id) {
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            
            stmt.setInt(1, id);
            
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return Optional.of(mapResultSetToReparation(rs));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public List<Reparation> findAll() {
        List<Reparation> reparations = new ArrayList<>();
        try (Connection conn = DBUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SELECT_ALL_SQL)) {
            
            while (rs.next()) {
                reparations.add(mapResultSetToReparation(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reparations;
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

    private Reparation mapResultSetToReparation(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        int voitureId = rs.getInt("voitureId");
        String description = rs.getString("description");
        double cout = rs.getDouble("cout");
      
        LocalDate date = rs.getObject("date", LocalDate.class);
        
        return new Reparation(id, voitureId, description, cout, date);
    }
}