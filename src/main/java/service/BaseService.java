package service;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;
import repository.BaseRepository;

import java.util.List;
import java.util.Optional;

public abstract class BaseService<T, ID, R extends BaseRepository<T, ID>> {

    @Inject
    R repository;

    public List<T> findAll() {
        return repository.listAll();
    }

    public T findById(ID id) {
        return repository
                .findByIdOptional(id)
                .orElseThrow(() -> new NotFoundException("Resource not found by id"));
    }

    public Optional<T> findByIdOptional(ID id) {
        return repository.findByIdOptional(id);
    }

    @Transactional
    public T create(T entity) {
        repository.persist(entity);
        return entity;
    }

    @Transactional
    public T update(T entity) {
        return repository.getEntityManager().merge(entity);
    }

    @Transactional
    public void deleteById(ID id) {
        findById(id);
        repository.deleteById(id);
    }
}

