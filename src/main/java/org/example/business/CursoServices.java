package org.example.business;

import org.example.data.CursoRepositorio;

import java.util.List;

public class CursoServices {
    private final CursoRepositorio repositorio;

    public CursoServices() {
        this.repositorio = new CursoRepositorio();
    }

    /** Devuelve false si ya existe un curso con ese id. */
    public boolean registrar(Curso curso) {
        List<Curso> cursos = repositorio.listar();
        boolean existe = cursos.stream().anyMatch(c -> c.getId() == curso.getId());
        if (existe) {
            return false;
        }
        cursos.add(curso);
        repositorio.guardar(cursos);
        return true;
    }

    public List<Curso> listar() {
        return repositorio.listar();
    }

    public boolean actualizar(Curso curso) {
        List<Curso> cursos = repositorio.listar();
        for (Curso c : cursos) {
            if (c.getId() == curso.getId()) {
                c.setNombre(curso.getNombre());
                c.setCreditos(curso.getCreditos());
                c.setDocente(curso.getDocente());
                repositorio.guardar(cursos);
                return true;
            }
        }
        return false;
    }

    public boolean eliminar(int id) {
        List<Curso> cursos = repositorio.listar();
        boolean eliminado = cursos.removeIf(c -> c.getId() == id);
        if (eliminado) {
            repositorio.guardar(cursos);
        }
        return eliminado;
    }
}