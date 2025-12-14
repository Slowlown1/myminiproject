package com.example.garage.service;

import com.example.garage.model.Facture;
import com.example.garage.repository.FactureRepositoryJDBC; // NOUVEAU

import java.time.LocalDate;

public class FactureService {
    
    private final FactureRepositoryJDBC factureRepo = new FactureRepositoryJDBC();

    public Facture creerFacturePourClient(int clientId) {
       
        Facture f = new Facture(0, clientId, LocalDate.now());
       
        return f;
    }
    
    
    public Facture sauvegarderFacture(Facture facture) {
        return factureRepo.save(facture);
    }
}