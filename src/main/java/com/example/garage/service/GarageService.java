package com.example.garage.service;

import com.example.garage.model.Client;
import com.example.garage.model.Voiture;
import com.example.garage.model.Reparation;

import com.example.garage.repository.ClientRepositoryJDBC; 
import com.example.garage.repository.VoitureRepositoryJDBC; 
import com.example.garage.repository.ReparationRepositoryJDBC; 

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class GarageService {
    
    private final ClientRepositoryJDBC clientRepo = new ClientRepositoryJDBC();
    private final VoitureRepositoryJDBC voitureRepo = new VoitureRepositoryJDBC();
    private final ReparationRepositoryJDBC reparationRepo = new ReparationRepositoryJDBC();

    
    public Client creerClient(String nom, String prenom, String telephone) {
        Client c = new Client(0, nom, prenom, telephone);
        return clientRepo.save(c); 
    }

    public Optional<Client> trouverClientParId(int id) {
        return clientRepo.findById(id);
    }

    public List<Client> tousLesClients() {
        return clientRepo.findAll();
    }

   
    public Voiture enregistrerVoiture(int clientId, String marque, String modele, String immatriculation) {
        Voiture v = new Voiture(0, marque, modele, immatriculation);
        
        
        Voiture savedV = voitureRepo.saveVoiturePourClient(v, clientId); 

        
        return savedV;
    }

    public List<Voiture> toutesLesVoitures() {
        return voitureRepo.findAll();
    }

    
    public Reparation enregistrerReparation(int voitureId, String description, double cout) {
        Reparation r = new Reparation(0, voitureId, description, cout, LocalDate.now());
        return reparationRepo.save(r); 
    }

    public List<Reparation> toutesReparations() {
        return reparationRepo.findAll();
    }

    
    public Optional<Voiture> trouverVoitureParId(int id) {
        return voitureRepo.findById(id);
    }

    public boolean supprimerClient(int id) {
        
        return clientRepo.delete(id); 
    }
}