package com.tuusuario.sistemadealumnos.service;
import com.tuusuario.sistemadealumnos.entity.Alumno;
import com.tuusuario.sistemadealumnos.entity.Nota;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tuusuario.sistemadealumnos.repository.AlumnoRepository;
import com.tuusuario.sistemadealumnos.repository.NotaRepository;

import java.util.Optional;


@Service
public class NotaService{

    @Autowired
    private NotaRepository notaRepository;

    @Autowired
    private AlumnoRepository alumnoRepository;

    // Metodo crear nota
    public void crearNota(int puntaje, String materia, Long alumnoId){

        // Busco el alumno y valido

        Optional<Alumno> optionalAlumno = alumnoRepository.findById(alumnoId);
            if (!optionalAlumno.isPresent()){
                throw new RuntimeException("Alumno no encontrado");
            }
                Alumno alumno = optionalAlumno.get();


        // Creo un objeto Nota
        Nota nota = new Nota();

        // Verifico que la materia ingresada no este repetida con metodo de Spring Data JPA
        boolean existe = notaRepository.existsByAlumnoAndMateria(alumno, materia);
        if (existe){
            throw new RuntimeException("Ya existe una nota para esa materia");
        }

        // Seteo los datos
        nota.setAlumno(alumno);
        nota.setMateria(materia);
        nota.setPuntaje(puntaje);

        // Guardo
        notaRepository.save(nota);
    }
}
