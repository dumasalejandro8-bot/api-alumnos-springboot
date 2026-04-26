package com.tuusuario.sistemadealumnos.controller;

import com.tuusuario.sistemadealumnos.dto.AlumnoRequest;
import com.tuusuario.sistemadealumnos.dto.AlumnoResponseDTO;
import com.tuusuario.sistemadealumnos.entity.Alumno;
import com.tuusuario.sistemadealumnos.service.AlumnoService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/alumnos")
public class AlumnoController {

    // Inyecto el AlumnoService para tener acceso a el (MEJOR PRIVATE)
    private final AlumnoService service;

    // Utilizo constructor para inicializarlo
        public AlumnoController(AlumnoService service){
        this.service = service;
    }


    // CREATE (C)
    @PostMapping
    public String crear(@RequestBody AlumnoRequest alumnoRequest){

            //Obtengo los datos desde AlumnoRequest y los transfiero al service
            service.crearAlumno(alumnoRequest.getDocumento(), alumnoRequest.getNombre(), alumnoRequest.getApellido());

        return "Alumno creado correctamente";
    }


    // READ (R)

    // Get all
    @GetMapping
    public List<AlumnoResponseDTO> obtener(){
            return service.obtenerAlumnos();
    }

    // Get por ID

    @GetMapping("/{id}")
    public AlumnoResponseDTO obtener(@PathVariable Long id){
            return service.buscarAlumno(id);
    }

    // PUT (C)

    @PutMapping("/{id}")
    public String actualizar(@RequestBody AlumnoRequest alumnoRequest, @PathVariable Long id){
            service.actualizarAlumno(id, alumnoRequest.getDocumento(), alumnoRequest.getNombre(), alumnoRequest.getApellido());
            return "Datos de Alumno actualizados.";
    }

    @DeleteMapping("/{id}")
    public String borrar(@PathVariable Long id){

            service.borrarAlumno(id);
            return "Alumno borrado correctamente.";
    }
}
