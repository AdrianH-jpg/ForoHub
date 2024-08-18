package com.Alura.ForoHub.dto;

import com.Alura.ForoHub.entity.Respuesta;

import java.time.LocalDateTime;

public record DTORespuestaListado(Long id,
                                  String mensaje,
                                  LocalDateTime fecha,
                                  Long topicoId,
                                  Long autorId,
                                  String autorNombre
) {

    public DTORespuestaListado(Respuesta respuesta) {
        this(
                respuesta.getId(),
                respuesta.getMensaje(),
                respuesta.getFechaCreacion(),
                respuesta.getTopico().getId(),
                respuesta.getAutor().getId(),
                respuesta.getAutor().getUsername()
        );
    }

}