package com.example.moviecatalog.model;

import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.Duration;
import java.time.LocalDate;
import java.util.Set;

@NoArgsConstructor
@Entity(name = "movie")
public class Movie extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_movie")
    @SequenceGenerator(name = "seq_movie", sequenceName = "SEQ_MOVIE", allocationSize = 10)
    private Long id;

    @NotBlank
    @Size(min = 1, max = 352)
    private String title;

    private String description;

    @NotNull
    private LocalDate releaseDate;

    @NotNull
    private Duration duration;

    @Range(min = 0, max = 100)
    private Integer rating;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private Set<Review> reviews;

    @NotEmpty
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id"))
    private Set<Genre> genres;

}