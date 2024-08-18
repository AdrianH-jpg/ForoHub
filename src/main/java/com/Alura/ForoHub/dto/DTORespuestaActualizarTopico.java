package com.Alura.ForoHub.dto;

import com.Alura.ForoHub.entity.Topico;

import java.time.LocalDateTime;

public record DTORespuestaActualizarTopico(
        Long id,
        String titulo,
        String mensaje,
        //@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
        LocalDateTime fechaCreacion,
        Boolean activo,
        Long autor,
        String autorNombre,
        String curso
) {

    public DTORespuestaActualizarTopico(Topico topico){
        this(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFechaCreacion(),
                topico.getActivo(),
                topico.getAutor().getId(),
                topico.getAutor().getUsername(),
                topico.getCurso()


        );
    }
}