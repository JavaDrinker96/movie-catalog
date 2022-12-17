package com.example.moviecatalog.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@Entity(name = "genre")
public class Genre extends BaseEntity {

    @NotBlank
    @Size(min = 3, max = 20)
    private String name;

}