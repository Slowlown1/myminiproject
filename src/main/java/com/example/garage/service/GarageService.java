package com.example.garage.service;

import com.example.garage.model.Client;
import com.example.garage.model.Voiture;
import com.example.garage.model.Reparation;
import com.example.garage.repository.ClientRepository;
import com.example.garage.repository.InMemoryRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class GarageService {
    private final ClientRepository clientRepo = new ClientRepository();
    private final InMemoryRepository<Voiture> voitureRepo = new InMemoryRepository<>();
    private final InMemoryRepository<Reparation> reparationRepo = new InMemoryRepository<>();

    // Client operations
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

    // Voiture operations
    public Voiture enregistrerVoiture(int clientId, String marque, String modele, String immatriculation) {
        Voiture v = new Voiture(0, marque, modele, immatriculation);
        voitureRepo.save(v);
        clientRepo.findById(clientId).ifPresent(client -> client.ajouterVoiture(v));
        return v;
    }

    public List<Voiture> toutesLesVoitures() {
        return voitureRepo.findAll();
    }

    // Reparation operations
    public Reparation enregistrerReparation(int voitureId, String description, double cout) {
        Reparation r = new Reparation(0, voitureId, description, cout, LocalDate.now());
        return reparationRepo.save(r);
    }

    public List<Reparation> toutesReparations() {
        return reparationRepo.findAll();
    }

    // Quelques manipulations utiles
    public Optional<Voiture> trouverVoitureParId(int id) {
        return voitureRepo.findById(id);
    }

    public boolean supprimerClient(int id) {
        // suppression simple: on supprime client (sans cascade)
        return clientRepo.delete(id);
    }
}
