package com.Alura.ForoHub.entity;

import com.Alura.ForoHub.dto.DTORegistroRespuesta;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Table(name = "respuestas")
@Entity(name = "Respuesta")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
public class Respuesta {

    //atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String mensaje;
    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;

    @ManyToOne
    @JoinColumn(name = "topico_id")
    private Topico topico;

    @ManyToOne
    @JoinColumn(name = "autor_id")
    private Usuario autor;

    private Boolean solucion;

    public Respuesta(
            DTORegistroRespuesta dtoRegistroRespuesta,
            Topico topico,
            Usuario autor) {

        this.mensaje = dtoRegistroRespuesta.mensaje();
        //this.fechaCreacion = LocalDateTime.now();
        this.topico = topico;
        this.autor = autor;
        this.solucion = false;
    }
}
