package com.example.springcrud.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;


public record UsersRecordsDTO(@NotBlank String name, @NotNull BigDecimal value) {

}
