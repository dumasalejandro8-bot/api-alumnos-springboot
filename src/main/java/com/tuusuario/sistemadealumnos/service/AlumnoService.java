package com.tuusuario.sistemadealumnos.service;

import com.tuusuario.sistemadealumnos.dto.AlumnoRequest;
import com.tuusuario.sistemadealumnos.dto.AlumnoResponseDTO;
import com.tuusuario.sistemadealumnos.entity.Alumno;
import com.tuusuario.sistemadealumnos.repository.AlumnoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.antlr.v4.runtime.tree.xpath.XPath.findAll;
import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
public class AlumnoService {

    private final AlumnoRepository alumnoRepository;

    public AlumnoService(AlumnoRepository alumnoRepository){
        this.alumnoRepository = alumnoRepository;
    }

    // Metodo crear Alumno                                          CREATE

    public void crearAlumno(String documento, String nombre, String apellido){

    // Creo un objeto alumno
    Alumno alumno = new Alumno();

    // Verifico que el alumno no este creado anteriormente
    boolean existe = alumnoRepository.existsByDocumento(documento);

    if(existe){
        throw new RuntimeException("Este alumno ya existe");
    }

    // Seteo los datos
    alumno.setDocumento(documento);
    alumno.setNombre(nombre);
    alumno.setApellido(apellido);

    alumnoRepository.save(alumno);

    }

    //Metodo para buscar y traer todos los alumnos                  READ

    public List<AlumnoResponseDTO> obtenerAlumnos(){

        // Traigo los alumnos

        List<Alumno> alumnos = alumnoRepository.findAll();

        // Creo una lista dto

        List<AlumnoResponseDTO> listaDto = new ArrayList<>();

        // Recorro la lista de alumnos y los agrego a la lista dto

        for (Alumno alumno : alumnos){
            AlumnoResponseDTO dto = new AlumnoResponseDTO(alumno.getDocumento(), alumno.getNombre(), alumno.getApellido());
            listaDto.add(dto);
        }

        return listaDto;
    }

    // Creo un metodo para buscar Alumno por ID

    public AlumnoResponseDTO buscarAlumno(Long id){
        Optional<Alumno> alumnoOptional = alumnoRepository.findById(id);

        if (!alumnoOptional.isPresent()){
            throw new RuntimeException("El alumno no existe");
        }
        Alumno alumno = alumnoOptional.get();

        AlumnoResponseDTO alumnoDto = new AlumnoResponseDTO(alumno.getDocumento(), alumno.getNombre(), alumno.getApellido());
        return alumnoDto;
    }

    // Metodo para actualizar alumno                                PUT

    public void actualizarAlumno(Long id, String documento, String nombre, String apellido) {
        Optional<Alumno> alumnoId = alumnoRepository.findById(id);

        // Controlo si existe el alumno
        if (!alumnoId.isPresent()) {
            throw new RuntimeException("El alumno no existe");
        }

        // Si el alumno existe lo TRAIGO desde el repository

        Alumno alumno = alumnoId.get();

        // Seteo los valores

        alumno.setDocumento(documento);
        alumno.setNombre(nombre);
        alumno.setApellido(apellido);

        // Guardo

            alumnoRepository.save(alumno);
        }

            // DELETE (D)                                           DELETE
        public void borrarAlumno(Long id) {
            Optional<Alumno> alumnoId = alumnoRepository.findById(id);
            if (!alumnoId.isPresent()){
                throw new RuntimeException("El alumno no existe.");
            }

            // Si el alumno existe

            // Lo elimino

            alumnoRepository.deleteById(id);
        }
    }
