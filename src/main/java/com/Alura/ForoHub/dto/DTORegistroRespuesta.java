package com.Alura.ForoHub.dto;

import lombok.NonNull;

public record DTORegistroRespuesta(
        @NonNull
        String mensaje,
        @NonNull
        Long autorId
) {
}
