package com.example.moviecatalog.service;

public interface BaseService<E, ID> {

    E create(E entity);

    E read(ID id);

    E update(E newEntity);

    void delete(ID id);

}
