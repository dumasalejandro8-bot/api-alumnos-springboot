# 📚 API de Alumnos - Spring Boot

Este proyecto es una API REST desarrollada con Spring Boot que permite gestionar alumnos y sus notas.

## 🚀 Funcionalidades

* Crear alumnos
* Obtener lista de alumnos
* Obtener alumno por ID
* Actualizar datos de alumnos
* Eliminar alumnos
* Gestión de notas asociadas a cada alumno

## 🧱 Tecnologías utilizadas

* Java
* Spring Boot
* Spring Data JPA
* Hibernate
* MySQL
* Maven
  
## ▶️ Cómo ejecutar el proyecto

1. Clonar el repositorio:
git clone https://github.com/dumasalejandro8-bot/api-alumnos-springboot.git

2. Abrir en IntelliJ o IDE preferido

3. Configurar la base de datos en application.properties

4. Ejecutar la aplicación

La API estará disponible en:
http://localhost:8080

## 🏗️ Arquitectura

El proyecto sigue una arquitectura en capas:

* Controller → Manejo de requests
* Service → Lógica de negocio
* Repository → Acceso a datos
* DTO → Transferencia de datos

## 🔗 Endpoints principales

### 📌 Alumnos

* GET /alumnos
* GET /alumnos/{id}
* POST /alumnos
* PUT /alumnos/{id}
* DELETE /alumnos/{id}

### 📌 Notas

* POST /notas
* (podés extender con más endpoints)

## 📦 Ejemplo de JSON

### Crear alumno

{
"documento": "123",
"nombre": "Juan",
"apellido": "Perez"
}

## 💡 Autor

Desarrollado por Alejandro Dumas como parte de su aprendizaje en desarrollo backend con Java y Spring Boot.
