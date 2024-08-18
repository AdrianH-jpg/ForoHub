package com.Alura.ForoHub.dto;

import com.Alura.ForoHub.entity.Topico;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public record DTORespuestaListadoTopicos(
        Long id,
        String titulo,
        String mensaje,
        //@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
        LocalDateTime fechaCreacion,
        Boolean activo,
        Long autor,
        String curso,
        List<DTORespuestaListado> respuestas
) {
    public DTORespuestaListadoTopicos(Topico topico){
        this(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFechaCreacion(),
                topico.getActivo(),
                topico.getAutor().getId(),
                topico.getCurso(),

                //para formatear la salida de los atributos de respuesta
                topico.getRespuestas()
                        .stream().map(
                                DTORespuestaListado::new
                        ).collect(Collectors.toList())
        );
    }

}
