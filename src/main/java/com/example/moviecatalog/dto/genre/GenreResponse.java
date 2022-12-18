package com.example.moviecatalog.dto.genre;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class GenreResponse {

    @NotNull(message = "The id must not be null.")
    @Min(value = 1, message = "The id must be greater than zero.")
    private Long id;

    @NotBlank(message = "The name should not be blank or null.")
    @Size(min = 3, max = 20, message = "The length of the genre name should be between 3 and 20 characters.")
    private String name;

}