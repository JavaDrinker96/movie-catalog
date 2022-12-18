package com.example.moviecatalog.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.Duration;
import java.time.LocalDate;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity(name = "movie")
public class Movie extends BaseEntity {

    @NotNull
    private String title;

    private String description;

    @NotNull
    private LocalDate releaseDate;

    @NotNull
    private Duration duration;

    @Column(updatable = false)
    private Integer rating;

    @Column(updatable = false)
    @OneToMany(mappedBy = "movie", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private Set<Review> reviews;

    @NotEmpty
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id"))
    private Set<Genre> genres;

}