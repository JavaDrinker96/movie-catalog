package com.example.moviecatalog.dto.genre;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
public class GenreRequest {

    @NotBlank(message = "The name should not be blank or null.")
    @Size(min = 3, max = 20, message = "The length of the name should be between 3 and 20 characters.")
    private String name;

}