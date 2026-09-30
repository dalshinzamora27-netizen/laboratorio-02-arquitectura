package org.example.presentacion;

import java.util.Scanner;

/** Utilidad para leer datos por consola sin que el programa se caiga. */
public class Entrada {

    public static int leerEntero(Scanner sc, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String linea = sc.nextLine().trim();
            try {
                return Integer.parseInt(linea);
            } catch (NumberFormatException e) {
                System.out.println("Debe ingresar un número entero.");
            }
        }
    }

    public static String leerTexto(Scanner sc, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String linea = sc.nextLine().trim();
            if (!linea.isEmpty()) {
                return linea;
            }
            System.out.println("El campo no puede estar vacío.");
        }
    }
}