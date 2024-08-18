package com.Alura.ForoHub.dto;

import jakarta.validation.constraints.NotNull;

public record DTORegistroTopico(
        //Los datos del tópico (título, mensaje, autor y curso)

        @NotNull
        String titulo,
        @NotNull
        String mensaje,
        @NotNull
        Long autorId,
        @NotNull
        String curso
){
}
