package com.example.moviecatalog.dto.movie;

import com.example.moviecatalog.dto.genre.GenreResponse;
import com.example.moviecatalog.model.Genre;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;
import java.util.Set;

@Getter
@Setter
public class MovieRequest {

    @NotBlank(message = "The title should not be blank or null.")
    @Size(min = 1, max = 352, message = "The length of the title should be between 1 and 352 characters.")
    private String title;

    @Size(min = 15, max = 1000, message = "The length of the description must be null or between 15 and 1000 characters")
    private String description;

    @NotNull(message = "The release date should not be null.")
    @Pattern(regexp = "^\\d{2}\\.\\d{2}\\.\\d{4}$", message = "The release date must match the template dd.mm.yyyy .")
    private String releaseDate;

    @NotNull(message = "The duration should not be null.")
    @Pattern(regexp = "^\\d{2}:\\d{2}:\\d{2}$", message = "The duration must match the template hh:mm:ss.")
    private String duration;

    @NotEmpty(message = "At least one genre must be specified.")
    private Set<GenreResponse> genres;

}