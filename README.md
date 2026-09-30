# Laboratorio 02 - Sistema de Gestión Académica

Laboratorio 02 del curso de Arquitectura de Software.
**Autor:** [Tu nombre completo]
**Universidad:** UNSCH - Escuela Profesional de Ingeniería de Sistemas

## Descripción
Aplicación de consola en Java que permite gestionar **estudiantes** y **cursos**
(registrar, listar, actualizar y eliminar). Los datos se guardan en archivos JSON
usando la librería Gson.

## Arquitectura en 3 capas

| Capa | Paquete | Clases | Responsabilidad |
|---|---|---|---|
| Presentación | `org.example.presentacion` | `EstudianteUI`, `CursoUI`, `Entrada` | Menús por consola y lectura de datos |
| Negocio | `org.example.business` | `Estudiante`, `Curso`, `EstudianteServices`, `CursoServices` | Entidades y reglas del CRUD |
| Datos | `org.example.data` | `EstudianteRepositorio`, `CursoRepositorio` | Lectura y escritura de JSON |

Flujo: `UI → Services → Repositorio → JSON`

## Validaciones
- No se permiten ids duplicados.
- Los campos de texto no pueden estar vacíos.
- Los créditos de un curso deben ser mayores a 0.
- Si se escribe texto donde se espera un número, el programa vuelve a pedir el dato.

## Requisitos
- JDK 24
- Maven (la dependencia Gson 2.11.0 se descarga automáticamente)

## Ejecución
Ejecutar la clase `org.example.Main`. Los datos se guardan en la carpeta `data/`,
que se crea automáticamente.