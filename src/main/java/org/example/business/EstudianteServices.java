package org.example.business;

import org.example.data.EstudianteRepositorio;

import java.util.List;

public class EstudianteServices {
    private final EstudianteRepositorio repositorio;

    public EstudianteServices() {
        this.repositorio = new EstudianteRepositorio();
    }

    /** Devuelve false si ya existe un estudiante con ese id. */
    public boolean registrar(Estudiante estudiante) {
        List<Estudiante> estudiantes = repositorio.listar();
        boolean existe = estudiantes.stream().anyMatch(e -> e.getId() == estudiante.getId());
        if (existe) {
            return false;
        }
        estudiantes.add(estudiante);
        repositorio.guardar(estudiantes);
        return true;
    }

    public List<Estudiante> listar() {
        return repositorio.listar();
    }

    public boolean actualizar(Estudiante estudiante) {
        List<Estudiante> estudiantes = repositorio.listar();
        for (Estudiante e : estudiantes) {
            if (e.getId() == estudiante.getId()) {
                e.setNombre(estudiante.getNombre());
                e.setCorreo(estudiante.getCorreo());
                repositorio.guardar(estudiantes);
                return true;
            }
        }
        return false;
    }

    public boolean eliminar(int id) {
        List<Estudiante> estudiantes = repositorio.listar();
        boolean eliminado = estudiantes.removeIf(e -> e.getId() == id);
        if (eliminado) {
            repositorio.guardar(estudiantes);
        }
        return eliminado;
    }
}