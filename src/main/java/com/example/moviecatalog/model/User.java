package com.example.moviecatalog.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Data
@EqualsAndHashCode
@NoArgsConstructor
@Entity(name = "app_user")
public class User extends BaseEntity {

    @NotNull
    private String firstname;

    @NotNull
    private String lastname;

    private LocalDate birthday;

    @NotNull
    private String email;

    @NotNull
    private String password;

    @NotEmpty
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            joinColumns = @JoinColumn(name = "app_user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    @OneToMany(mappedBy = "author", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<Review> reviews;

}