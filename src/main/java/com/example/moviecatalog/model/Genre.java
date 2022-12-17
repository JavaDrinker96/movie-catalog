package com.example.moviecatalog.model;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@NoArgsConstructor
@Entity(name = "genre")
public class Genre extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_genre")
    @SequenceGenerator(name = "seq_genre", sequenceName = "SEQ_GENRE", allocationSize = 10)
    private Long id;

    @NotBlank
    @Size(min = 3, max = 20)
    private String name;

}