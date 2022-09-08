package com.example.simple_rest_api.repository;

import java.util.List;
import java.util.Optional;

public interface CrudRepository<T, R> {
    Optional<T> findById(R id);

    List<T> findAll();

    void save(T entity);

    void update(T entity);

    void delete(R id);
}

