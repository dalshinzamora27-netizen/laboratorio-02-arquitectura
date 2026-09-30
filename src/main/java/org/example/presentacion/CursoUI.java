package org.example.presentacion;

import org.example.business.Curso;
import org.example.business.CursoServices;

import java.util.List;
import java.util.Scanner;

public class CursoUI {
    private static final CursoServices servicio = new CursoServices();

    public static void mostrarMenu(Scanner sc) {
        int opcion;
        do {
            System.out.println("\n=== GESTIÓN DE CURSOS ===");
            System.out.println("1. Registrar");
            System.out.println("2. Listar");
            System.out.println("3. Actualizar");
            System.out.println("4. Eliminar");
            System.out.println("0. Regresar");
            opcion = Entrada.leerEntero(sc, "Seleccione una opción: ");

            switch (opcion) {
                case 1 -> {
                    int id = Entrada.leerEntero(sc, "Id: ");
                    String nombre = Entrada.leerTexto(sc, "Nombre: ");
                    int creditos = Entrada.leerEntero(sc, "Créditos: ");
                    String docente = Entrada.leerTexto(sc, "Docente: ");
                    if (creditos <= 0) {
                        System.out.println("Los créditos deben ser mayores a 0");
                    } else {
                        boolean ok = servicio.registrar(new Curso(id, nombre, creditos, docente));
                        System.out.println(ok ? "Curso registrado" : "Ya existe un curso con ese id");
                    }
                }
                case 2 -> {
                    List<Curso> lista = servicio.listar();
                    if (lista.isEmpty()) {
                        System.out.println("No hay cursos registrados");
                    } else {
                        lista.forEach(c -> System.out.println(
                                c.getId() + " | " + c.getNombre() + " | "
                                        + c.getCreditos() + " créditos | " + c.getDocente()));
                    }
                }
                case 3 -> {
                    int id = Entrada.leerEntero(sc, "Id a actualizar: ");
                    String nombre = Entrada.leerTexto(sc, "Nuevo nombre: ");
                    int creditos = Entrada.leerEntero(sc, "Nuevos créditos: ");
                    String docente = Entrada.leerTexto(sc, "Nuevo docente: ");
                    if (creditos <= 0) {
                        System.out.println("Los créditos deben ser mayores a 0");
                    } else {
                        boolean ok = servicio.actualizar(new Curso(id, nombre, creditos, docente));
                        System.out.println(ok ? "Curso actualizado" : "No se encontró el id");
                    }
                }
                case 4 -> {
                    int id = Entrada.leerEntero(sc, "Id a eliminar: ");
                    boolean ok = servicio.eliminar(id);
                    System.out.println(ok ? "Curso eliminado" : "No se encontró el id");
                }
                case 0 -> { }
                default -> System.out.println("Opción no válida");
            }
        } while (opcion != 0);
    }
}