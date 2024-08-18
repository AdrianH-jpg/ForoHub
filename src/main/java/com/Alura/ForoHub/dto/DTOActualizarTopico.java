package com.Alura.ForoHub.dto;

import jakarta.validation.constraints.NotNull;

public record DTOActualizarTopico(

        @NotNull
        String titulo,
        @NotNull
        String mensaje,

        //Long autorId,
        @NotNull
        String curso

){
}
