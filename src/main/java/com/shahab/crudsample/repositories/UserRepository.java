package com.shahab.crudsample.repositories;

import com.shahab.crudsample.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component //or @Repository or @Service
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}