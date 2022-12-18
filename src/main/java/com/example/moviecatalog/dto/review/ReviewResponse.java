package com.example.moviecatalog.dto.review;

import com.example.moviecatalog.dto.user.UserShortResponse;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.*;

@Getter
@Setter
public class ReviewResponse {

    @NotNull(message = "Score should not be null.")
    @Range(min = 1, max = 100, message = "The score value must be in the range from 1 to 100.")
    private Integer score;

    @NotBlank(message = "The title should not be blank or null.")
    @Size(min = 3, max = 352, message = "The length of the title should be between 3 and 352 characters.")
    private String title;

    @NotBlank(message = "The content should not be blank or null.")
    @Size(min = 5, max = 600, message = "The length of the content should be between 5 and 600 characters.")
    private String content;

    @NotNull(message = "The movie id must not be null.")
    @Min(value = 1, message = "The movie id must be greater than zero.")
    private Long movieId;

    @Null(message = "The user id must be null.")
    private UserShortResponse author;

}