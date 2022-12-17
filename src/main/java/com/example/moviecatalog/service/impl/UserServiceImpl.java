package com.example.moviecatalog.service.impl;

import com.example.moviecatalog.model.User;
import com.example.moviecatalog.repository.UserRepository;
import com.example.moviecatalog.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Slf4j
@Service
public class UserServiceImpl extends AbstractService<User, UserRepository, Long> implements UserService {

    protected UserServiceImpl(UserRepository repository) {
        super(repository);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        log.info("Search for a user with email = {}.", email);
        User user = repository.findByEmail(email).orElseThrow(
                () -> new UsernameNotFoundException(String.format("The user with the email = %s was not found in the database.", email))
        );

        Collection<SimpleGrantedAuthority> authorities = user.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getName().getValue()))
                .collect(Collectors.toSet());

        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), authorities);
    }

}