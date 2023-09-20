package com.example.geektrust.repositories;

import java.util.List;
import java.util.Optional;

public interface CRUDRepository<T,D> {
    public T save(T entity);
    public List<T> findAll();
    public Optional<T> findById(D Id);
}
