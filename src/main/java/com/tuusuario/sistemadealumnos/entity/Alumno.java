package com.tuusuario.sistemadealumnos.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Alumno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String documento;
    private String nombre;
    private String apellido;

    // mappedBy 👉 “Alumno se relaciona con Nota a través del campo alumno que está en Nota”
    @OneToMany(mappedBy = "alumno")
    private List<Nota> notas = new ArrayList<Nota>();

    public Alumno() {
    }

    public Alumno(String documento, String nombre, String apellido, List<Nota> notas) {
        this.documento = documento;
        this.nombre = nombre;
        this.apellido = apellido;
        this.notas = notas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public List<Nota> getNotas() {
        return notas;
    }

    public void setNotas(List<Nota> notas) {
        this.notas = notas;
    }
}
