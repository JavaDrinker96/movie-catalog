package com.example.moviecatalog.service;

import com.example.moviecatalog.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService, BaseService<User, Long> {
}