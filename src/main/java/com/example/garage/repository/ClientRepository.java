package com.example.garage.repository;

import com.example.garage.model.Client;

import java.util.Optional;

public class ClientRepository extends InMemoryRepository<Client> {
    public Optional<Client> findByTelephone(String telephone) {
        return findAll().stream()
                .filter(c -> telephone != null && telephone.equals(c.getTelephone()))
                .findFirst();
    }
}
