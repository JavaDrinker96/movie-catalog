package com.example.moviecatalog.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@Entity(name = "role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_role")
    @SequenceGenerator(name = "seq_role", sequenceName = "SEQ_ROLE", allocationSize = 10)
    private Long id;

    @NotNull
    @Enumerated(EnumType.STRING)
    private RoleName name;

}