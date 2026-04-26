package com.tuusuario.sistemadealumnos.repository;

import com.tuusuario.sistemadealumnos.entity.Alumno;
import com.tuusuario.sistemadealumnos.entity.Nota;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotaRepository extends JpaRepository<Nota, Long> {


    boolean existsByAlumnoAndMateria(Alumno alumno, String materia);
}
