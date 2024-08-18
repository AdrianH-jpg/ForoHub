package com.Alura.ForoHub.controller;

import com.Alura.ForoHub.entity.Topico;
import com.Alura.ForoHub.entity.Usuario;
import com.Alura.ForoHub.repository.IRespuestaRepository;
import com.Alura.ForoHub.repository.ITopicoRepository;
import com.Alura.ForoHub.repository.IUsuarioRepository;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import com.Alura.ForoHub.dto.DTORegistroRespuesta;
import com.Alura.ForoHub.dto.DTORespuestaRegistroRespuesta;
import com.Alura.ForoHub.entity.Respuesta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/respuestas")
@SecurityRequirement(name = "bearer-key")
public class RespuestaController {

    @Autowired
    private ITopicoRepository topicoRepository;

    @Autowired
    private IUsuarioRepository usuarioRepository;

    @Autowired
    private IRespuestaRepository respuestaRepository;


    @PostMapping("/{topicoId}")
    @Transactional
    public ResponseEntity<DTORespuestaRegistroRespuesta> registroTo(
            @PathVariable Long topicoId,
            @RequestBody DTORegistroRespuesta dtoRegistroRespuesta
    ){

        //buscar el topico al cual ingresaremos una respuesta
        Optional<Topico> topicoOptional = topicoRepository.findById(topicoId);
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(dtoRegistroRespuesta.autorId());


        if (topicoOptional.isPresent() && usuarioOptional.isPresent()) {

            //crear la respuesta
            var respuesta = new Respuesta(
                    dtoRegistroRespuesta,
                    topicoOptional.get(),
                    usuarioOptional.get()
            );

            //guardar la respuesta
            var respuestaSaved = respuestaRepository.save(respuesta);

            //convertir la respuesta a DTO de salida
            var respuestaDTO = new DTORespuestaRegistroRespuesta(
                    respuestaSaved);

            //pendiente url con la respuesta, todavia no tengo el endpoint

            //salida
            return ResponseEntity.ok(respuestaDTO);

        }else {
            return ResponseEntity.notFound().build();
        }
    }


}