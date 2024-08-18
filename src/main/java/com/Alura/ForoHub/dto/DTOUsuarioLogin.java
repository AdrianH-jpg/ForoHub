package com.Alura.ForoHub.dto;

import jakarta.validation.constraints.NotBlank;

public record DTOUsuarioLogin(
@NotBlank
String username,
@NotBlank
String password
){
}
