package com.example.moviecatalog.dto.movie;

import com.example.moviecatalog.dto.genre.GenreResponse;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;
import java.util.Set;

@Getter
@Setter
public class MovieResponse {

    @Min(value = 1, message = "The id must be greater than zero.")
    @NotNull(message = "The id must not be null.")
    private Long id;

    @NotBlank(message = "The title should not be blank or null.")
    @Size(min = 1, max = 352, message = "The length of the title should be between 1 and 352 characters.")
    private String title;

    @Size(min = 15, max = 1000, message = "The length of the description must be null or between 15 and 1000 characters.")
    private String description;

    @NotNull(message = "The release date should not be null.")
    @Pattern(regexp = "^\\d{2}\\.\\d{2}\\.\\d{4}$", message = "The release date must match the template dd.mm.yyyy .")
    private String releaseDate;

    @NotNull(message = "The duration should not be null.")
    @Pattern(regexp = "^\\d{2}:\\d{2}:\\d{2}$", message = "The duration must match the template hh:mm:ss.")
    private String duration;

    @Null(message = "The rating must be null.")
    private Integer rating;

    @NotEmpty(message = "At least one genre must be specified.")
    private Set<GenreResponse> genres;

}