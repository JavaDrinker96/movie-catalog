package com.example.moviecatalog.dto.user;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class UserShortResponse {

    @Min(value = 1, message = "The id must be greater than zero.")
    @NotNull(message = "The id must not be null.")
    private Long id;

    @NotBlank(message = "The firstname should not be blank or null.")
    @Size(min = 3, max = 50, message = "The length of the firstname should be between 3 and 50 characters.")
    private String firstname;

    @NotBlank(message = "The lastname should not be blank or null.")
    @Size(min = 3, max = 50, message = "The length of the lastname should be between 3 and 50 characters.")
    private String lastname;

}