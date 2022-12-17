package com.example.moviecatalog.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@Entity(name = "role")
public class Role extends BaseEntity {

    @NotNull
    @Enumerated(EnumType.STRING)
    private RoleName name;

}