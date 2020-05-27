package com.shahab.crudsample.dto;

import com.shahab.crudsample.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDTO {
    @NotNull
    @Size(min = 5, max = 20)
    private String name;

    @NotNull
    private Integer age;

    @NotNull
    @Email
    private String email;
}