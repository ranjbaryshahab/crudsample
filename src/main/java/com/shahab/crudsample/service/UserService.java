package com.shahab.crudsample.service;

import com.shahab.crudsample.model.User;

import java.util.List;

public interface UserService {
    User save(User user);

    User findById(Long id);

    User findByEmail(String email);

    List<User> findAll();

    User edit(User user, Long id);

    void delete(String email);
}
