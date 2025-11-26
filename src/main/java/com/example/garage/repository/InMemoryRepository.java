package com.example.garage.repository;

import com.example.garage.model.Identifiable;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class InMemoryRepository<T extends Identifiable> implements Repository<T> {
    protected final Map<Integer, T> storage = new HashMap<>();
    protected final AtomicInteger idGen = new AtomicInteger(1);

    @Override
    public T save(T entity) {
        if (entity.getId() <= 0) {
            int id = idGen.getAndIncrement();
            entity.setId(id);
        }
        storage.put(entity.getId(), entity);
        return entity;
    }

    @Override
    public Optional<T> findById(int id) {
        return Optional.ofNullable(storage.get(id));
    }

    @Override
    public List<T> findAll() {
        return new ArrayList<>(storage.values());
    }

    @Override
    public boolean delete(int id) {
        return storage.remove(id) != null;
    }
}
