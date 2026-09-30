package org.example;

import org.example.presentacion.CursoUI;
import org.example.presentacion.EstudianteUI;
import org.example.presentacion.Entrada;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n=== SISTEMA DE GESTIÓN ACADÉMICA ===");
            System.out.println("1. Gestionar estudiantes");
            System.out.println("2. Gestionar cursos");
            System.out.println("0. Salir");
            opcion = Entrada.leerEntero(sc, "Seleccione una opción: ");

            switch (opcion) {
                case 1 -> EstudianteUI.mostrarMenu(sc);
                case 2 -> CursoUI.mostrarMenu(sc);
                case 0 -> System.out.println("Sistema finalizado.");
                default -> System.out.println("Opción no válida");
            }
        } while (opcion != 0);

        sc.close();
    }
}