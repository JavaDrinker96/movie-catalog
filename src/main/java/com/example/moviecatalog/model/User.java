package com.example.moviecatalog.model;

import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@Entity(name = "app_user")
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_user")
    @SequenceGenerator(name = "seq_user", sequenceName = "SEQ_USER", allocationSize = 10)
    private Long id;

    @NotBlank
    @Size(min = 3, max = 50)
    private String firstName;

    @NotBlank
    @Size(min = 3, max = 50)
    private String lastName;

    @NotNull
    private LocalDate birthday;

    @Email
    @NotNull
    private String email;

    @NotBlank
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