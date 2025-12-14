package com.example.garage.repository;

import com.example.garage.model.Client;
import com.example.garage.model.Reparation;
import com.example.garage.model.Voiture;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClientRepositoryJDBC implements Repository<Client> {

    private static final String INSERT_SQL = "INSERT INTO Client (nom, prenom, telephone) VALUES (?, ?, ?)";
    private static final String SELECT_BY_ID_SQL = "SELECT * FROM Client WHERE id = ?";
    private static final String SELECT_ALL_SQL = "SELECT * FROM Client";
    private static final String DELETE_SQL = "DELETE FROM Client WHERE id = ?";
    
    
    @Override
    public Client save(Client entity) {
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS)) {
            
            stmt.setString(1, entity.getNom());
            stmt.setString(2, entity.getPrenom());
            stmt.setString(3, entity.getTelephone());
            
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
    public Optional<Client> findById(int id) {
        Client client = null;
        
       
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            
            stmt.setInt(1, id);
            
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    client = mapResultSetToClient(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

       
        if (client != null) {
            List<Voiture> voitures = trouverVoituresParClient(id);
            voitures.forEach(client::ajouterVoiture);
        }

        return Optional.ofNullable(client);
    }

    @Override
    public List<Client> findAll() {
        List<Client> clients = new ArrayList<>();
        try (Connection conn = DBUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SELECT_ALL_SQL)) {
            
            while (rs.next()) {
                clients.add(mapResultSetToClient(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clients;
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

    private Client mapResultSetToClient(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        String nom = rs.getString("nom");
        String prenom = rs.getString("prenom");
        String telephone = rs.getString("telephone");
        
        
        Client c = new Client(id, nom, prenom, telephone);
        
        return c;
    }
   
    public List<Voiture> trouverVoituresParClient(int clientId) {
        List<Voiture> voitures = new ArrayList<>();
        String SELECT_VOITURES_BY_CLIENT = "SELECT * FROM Voiture WHERE client_id = ?";
        
      
        VoitureRepositoryJDBC voitureRepo = new VoitureRepositoryJDBC();

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(SELECT_VOITURES_BY_CLIENT)) {

            stmt.setInt(1, clientId);
            
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                   
                    int voitureId = rs.getInt("id");
                    Voiture v = new Voiture(
                        voitureId,
                        rs.getString("marque"),
                        rs.getString("modele"),
                        rs.getString("immatriculation")
                    );
                
                    List<Reparation> reparations = voitureRepo.trouverReparationsParVoiture(voitureId);
                    reparations.forEach(v::ajouterReparation); 
                    
                    voitures.add(v);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return voitures;
    }
}