package com.example.moviecatalog.dto.user;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter
@Setter
public class UserRequest {

    @NotBlank(message = "The firstname should not be blank or null.")
    @Size(min = 3, max = 50, message = "The length of the firstname should be between 3 and 50 characters.")
    private String firstname;

    @NotBlank(message = "The lastname should not be blank or null.")
    @Size(min = 3, max = 50, message = "The length of the lastname should be between 3 and 50 characters.")
    private String lastname;

    @Pattern(regexp = "^\\d{2}\\.\\d{2}\\.\\d{4}$", message = "The birthday must match the template dd.mm.yyyy .")
    private String birthday;

    @NotNull
    @Size(max = 320, message = "The email length should be no more than 320 characters.")
    @Email(regexp = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$",
            message = "Email must be specified correctly.")
    private String email;

    @NotBlank(message = "The password should not be blank or null.")
    @Size(min = 8, max = 30, message = "The length of the password should be between 8 and 30 characters.")
    private String password;

}