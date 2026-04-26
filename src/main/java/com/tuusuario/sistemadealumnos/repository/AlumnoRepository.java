package com.tuusuario.sistemadealumnos.repository;

import com.tuusuario.sistemadealumnos.entity.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlumnoRepository extends JpaRepository<Alumno, Long> {

    boolean existsByDocumento(String documento);


}
