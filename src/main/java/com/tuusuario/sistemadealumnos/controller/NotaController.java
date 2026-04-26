package com.tuusuario.sistemadealumnos.controller;


import com.tuusuario.sistemadealumnos.dto.NotaRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.tuusuario.sistemadealumnos.service.NotaService;

@RestController
@RequestMapping("/notas")
public class NotaController {

    // Indico que este Controller va a tener un service
    private final NotaService service;

    // Inicializo mediante constructor
    public NotaController(NotaService service) {
        this.service = service;
    }

    @PostMapping
    public String crear(@RequestBody NotaRequest notaRequest){
        // Obtengo los datos desde el NotaRequest y los transfiero al service
        service.crearNota(notaRequest.getPuntaje(), notaRequest.getMateria(),notaRequest.getAlumnoId());
    return "Nota crada correctamente";
    }
}
