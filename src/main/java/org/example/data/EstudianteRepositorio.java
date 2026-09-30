package org.example.data;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.example.business.Estudiante;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class EstudianteRepositorio {
    private final String archivo = "data/estudiantes.json";
    private final Gson gson = new Gson();

    public List<Estudiante> listar() {
        File f = new File(archivo);
        if (!f.exists()) {
            return new ArrayList<>();   // primera vez: aún no hay archivo
        }
        try (Reader reader = new FileReader(f)) {
            Type tipo = new TypeToken<List<Estudiante>>() {}.getType();
            List<Estudiante> estudiantes = gson.fromJson(reader, tipo);
            return estudiantes != null ? estudiantes : new ArrayList<>();
        } catch (Exception e) {
            System.out.println("Error al leer estudiantes: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    public void guardar(List<Estudiante> estudiantes) {
        new File("data").mkdirs();
        try (Writer writer = new FileWriter(archivo)) {
            gson.toJson(estudiantes, writer);
        } catch (Exception e) {
            System.out.println("Error al guardar estudiante: " + e.getMessage());
        }
    }
}