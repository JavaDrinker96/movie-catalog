package com.example.moviecatalog.dto.user;

import com.example.moviecatalog.dto.role.RoleResponse;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;
import java.util.Set;

@Getter
@Setter
public class UserResponse {

    @Min(value = 1, message = "The id must be greater than zero.")
    @NotNull(message = "The id must not be null.")
    private Long id;

    @NotBlank(message = "The firstname should not be blank or null.")
    @Size(min = 3, max = 50, message = "The length of the firstname should be between 3 and 50 characters.")
    private String firstname;

    @NotBlank(message = "The lastname should not be blank or null.")
    @Size(min = 3, max = 50, message = "The length of the lastname should be between 3 and 50 characters.")
    private String lastname;

    @Pattern(regexp = "^\\d{2}\\.\\d{2}\\.\\d{4}$", message = "The birthday must match the template dd.mm.yyyy .")
    private String birthday;

    @NotNull
    @Email(regexp = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$",
            message = "Email must be specified correctly.")
    private String email;

    @NotNull(message = "Roles should not be null.")
    private Set<RoleResponse> roles;

}