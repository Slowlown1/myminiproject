package com.example.garage.repository;

import com.example.garage.model.Identifiable;

import java.util.List;
import java.util.Optional;

public interface Repository<T extends Identifiable> {
    T save(T entity);
    Optional<T> findById(int id);
    List<T> findAll();
    boolean delete(int id);
}
