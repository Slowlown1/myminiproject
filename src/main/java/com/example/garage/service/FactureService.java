package com.example.garage.service;

import com.example.garage.model.Facture;

import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicInteger;

public class FactureService {
    private final AtomicInteger idGen = new AtomicInteger(1);

    public Facture creerFacturePourClient(int clientId) {
        Facture f = new Facture(0, clientId, LocalDate.now());
        f.setId(idGen.getAndIncrement());
        return f;
    }
}
