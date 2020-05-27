package com.shahab.crudsample.controller;

import com.shahab.crudsample.dto.UserDTO;
import com.shahab.crudsample.model.User;
import com.shahab.crudsample.service.UserService;
import io.swagger.annotations.Api;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api("user controller")
@RestController("/user")
public class UserController {
    final UserService userService;
    final ModelMapper modelMapper;

    public UserController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @PostMapping("/save")
    private UserDTO save(@Valid @RequestBody UserDTO userDTO) {
        User user = userService.save(modelMapper.map(userDTO, User.class));
        return modelMapper.map(user, UserDTO.class);
    }

    @GetMapping("/find-by-id/{id}")
    private UserDTO findById(@PathVariable Long id) {
        return modelMapper.map(
                userService.findById(id),
                UserDTO.class
        );
    }

    @GetMapping("/find-by-email/{email}")
    private UserDTO findByEmail(@PathVariable String email) {
        return modelMapper.map(
                userService.findByEmail(email),
                UserDTO.class
        );
    }

    @GetMapping("/all")
    private List<User> findAll() {
        return userService.findAll();
    }

    @DeleteMapping("/remove/{email}")
    private void delete(@PathVariable String email) {
        userService.delete(email);
    }

    @PatchMapping("/edit/{id}")
    private UserDTO edit(@Valid @RequestBody UserDTO userDTO, @PathVariable Long id) {
        User user = userService.edit(modelMapper.map(userDTO, User.class), id);
        return modelMapper.map(user, UserDTO.class);
    }

}
