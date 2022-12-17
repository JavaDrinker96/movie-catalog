package com.example.moviecatalog.model;

import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@NoArgsConstructor
@Entity(name = "review")
public class Review extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_review")
    @SequenceGenerator(name = "seq_review", sequenceName = "SEQ_REVIEW", allocationSize = 10)
    private Long id;

    @Range(min = 1, max = 100)
    private Integer score;

    @NotBlank
    @Size(min = 3, max = 352)
    private String title;

    @NotBlank
    @Size(min = 5, max = 600)
    private String content;

    @NotNull
    @Column(updatable = false)
    private LocalDate publicationDate;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "app_user_id")
    private User author;

}