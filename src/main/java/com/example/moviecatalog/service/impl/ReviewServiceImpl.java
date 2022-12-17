package com.example.moviecatalog.service.impl;

import com.example.moviecatalog.model.Review;
import com.example.moviecatalog.repository.ReviewRepository;
import com.example.moviecatalog.service.ReviewService;
import org.springframework.stereotype.Service;

@Service
public class ReviewServiceImpl extends AbstractService<Review, ReviewRepository, Long> implements ReviewService {

    protected ReviewServiceImpl(ReviewRepository repository) {
        super(repository);
    }

}