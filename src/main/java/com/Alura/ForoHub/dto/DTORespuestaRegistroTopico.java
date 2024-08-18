package com.Alura.ForoHub.dto;

import com.Alura.ForoHub.entity.Topico;

import java.time.LocalDateTime;

public record DTORespuestaRegistroTopico(Long id,
                                         String titulo,
                                         String mensaje,
                                         //@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
                                         LocalDateTime fechaCreacion,
                                         Long autorId,
                                         String autorNombre,
                                         String curso
)
{
    //constructor para convertir la respuesta de registro de topico
    public DTORespuestaRegistroTopico(Topico topico) {
        this(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFechaCreacion(),
                topico.getAutor().getId(),
                topico.getAutor().getUsername(),
                topico.getCurso()
        );
    }
}