package com.example.moviecatalog.service.impl;

import com.example.moviecatalog.model.BaseEntity;
import com.example.moviecatalog.service.BaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.util.Assert;

import javax.persistence.EntityNotFoundException;
import java.util.Objects;

@Slf4j
public abstract class AbstractService<E extends BaseEntity, R extends JpaRepository<E, ID>, ID> implements BaseService<E, ID> {

    protected final R repository;

    protected AbstractService(R repository) {
        this.repository = repository;
    }

    @Override
    public E create(E entity) {
        Assert.notNull(entity, "The entity being saved cannot be null.");
        log.info("An attempt to create a entity = {}.", entity);
        if (!entity.getId().equals(0L) || Objects.nonNull(entity.getId())) {
            throw new IllegalArgumentException("The saved entity must have null or zero id.");
        }
        return repository.save(entity);
    }

    @Override
    public E read(ID id) {
        Assert.notNull(id, "The id for entity search cannot be null.");
        log.info("Trying to find a entity with id = {}.", id);
        return repository.findById(id)
                .orElseThrow(
                        () -> new EntityNotFoundException(String.format("Entity with id = %s not found in the database.", id))
                );
    }

    @Override
    public E update(E newEntity) {
        Assert.notNull(newEntity, "The entity updated cannot be null.");
        log.info("An attempt to update a entity = {}.", newEntity);
        Assert.notNull(newEntity.getId(), "The id of the entity being updated cannot be null.");
        return repository.save(newEntity);
    }

    @Override
    public void delete(ID id) {
        Assert.notNull(id, "The id to delete a entity cannot be null.");
        log.info("Attempt to delete a entity with id = {}.", id);
        repository.deleteById(id);
    }

}