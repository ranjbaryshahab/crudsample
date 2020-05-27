package com.shahab.crudsample.service;

import com.shahab.crudsample.exception.AvailableUserException;
import com.shahab.crudsample.exception.UserNotFoundException;
import com.shahab.crudsample.model.User;
import com.shahab.crudsample.repositories.UserRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Component //or @Repository or @Service
public class UserServiceImpl implements UserService {

    final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(User user) {
        if (userRepository.findByEmail(user.getEmail()).isPresent())
            throw new AvailableUserException(user.getEmail());
        user.setCreateDate(LocalDate.now());
        user.setIsAdmin(false);
        return userRepository.save(user);
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException(email));
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User edit(User user, Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (!optionalUser.isPresent())
            throw new UserNotFoundException(id);
        User newUser = optionalUser.get();
        newUser.setAge(user.getAge());
        newUser.setName(user.getName());
        newUser.setEmail(user.getEmail());
        return userRepository.save(newUser);
    }

    @Override
    public void delete(String email) {
        Optional<User> user = userRepository.findByEmail(email);
        if (!user.isPresent())
            throw new UserNotFoundException(email);
        userRepository.delete(user.get());
    }
}
