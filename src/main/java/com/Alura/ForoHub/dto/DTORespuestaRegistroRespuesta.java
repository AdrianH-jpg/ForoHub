package com.Alura.ForoHub.dto;

import com.Alura.ForoHub.entity.Respuesta;

import java.time.LocalDateTime;

public record DTORespuestaRegistroRespuesta(Long id,
                                            String mensaje,
                                            //@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
                                            LocalDateTime fecha,
                                            Long topicoId,
                                            Long autorId,
                                            String autorNombre

) {

    public DTORespuestaRegistroRespuesta(Respuesta respuesta){
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