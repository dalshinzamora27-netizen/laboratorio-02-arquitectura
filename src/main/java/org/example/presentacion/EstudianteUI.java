package org.example.presentacion;

import org.example.business.Estudiante;
import org.example.business.EstudianteServices;

import java.util.List;
import java.util.Scanner;

public class EstudianteUI {
    private static final EstudianteServices servicio = new EstudianteServices();

    public static void mostrarMenu(Scanner sc) {
        int opcion;
        do {
            System.out.println("\n=== GESTIÓN DE ESTUDIANTES ===");
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
                    String correo = Entrada.leerTexto(sc, "Correo: ");
                    boolean ok = servicio.registrar(new Estudiante(id, nombre, correo));
                    System.out.println(ok ? "Estudiante registrado" : "Ya existe un estudiante con ese id");
                }
                case 2 -> {
                    List<Estudiante> lista = servicio.listar();
                    if (lista.isEmpty()) {
                        System.out.println("No hay estudiantes registrados");
                    } else {
                        lista.forEach(e -> System.out.println(
                                e.getId() + " | " + e.getNombre() + " | " + e.getCorreo()));
                    }
                }
                case 3 -> {
                    int id = Entrada.leerEntero(sc, "Id a actualizar: ");
                    String nombre = Entrada.leerTexto(sc, "Nuevo nombre: ");
                    String correo = Entrada.leerTexto(sc, "Nuevo correo: ");
                    boolean ok = servicio.actualizar(new Estudiante(id, nombre, correo));
                    System.out.println(ok ? "Estudiante actualizado" : "No se encontró el id");
                }
                case 4 -> {
                    int id = Entrada.leerEntero(sc, "Id a eliminar: ");
                    boolean ok = servicio.eliminar(id);
                    System.out.println(ok ? "Estudiante eliminado" : "No se encontró el id");
                }
                case 0 -> { }
                default -> System.out.println("Opción no válida");
            }
        } while (opcion != 0);
    }
}