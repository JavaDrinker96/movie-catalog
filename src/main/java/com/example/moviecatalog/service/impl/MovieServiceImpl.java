package com.example.moviecatalog.service.impl;

import com.example.moviecatalog.model.Movie;
import com.example.moviecatalog.repository.MovieRepository;
import com.example.moviecatalog.service.MovieService;
import org.springframework.stereotype.Service;

@Service
public class MovieServiceImpl extends AbstractService<Movie, MovieRepository, Long> implements MovieService {

    protected MovieServiceImpl(MovieRepository repository) {
        super(repository);
    }

}