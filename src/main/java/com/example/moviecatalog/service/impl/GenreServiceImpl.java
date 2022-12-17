package com.example.moviecatalog.service.impl;

import com.example.moviecatalog.model.Genre;
import com.example.moviecatalog.repository.GenreRepository;
import com.example.moviecatalog.service.GenreService;
import org.springframework.stereotype.Service;

@Service
public class GenreServiceImpl extends AbstractService<Genre, GenreRepository, Long> implements GenreService {

    protected GenreServiceImpl(GenreRepository repository) {
        super(repository);
    }

}