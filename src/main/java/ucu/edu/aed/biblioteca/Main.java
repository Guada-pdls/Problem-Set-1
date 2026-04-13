package ucu.edu.aed.biblioteca;

import ucu.edu.aed.utils.FileUtils;

import java.util.ArrayList;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        int variacionTotal = 0;

        FileUtils.leerLineas("./adquisiciones.txt", linea -> {
            String[] data = linea.split(", ");
            biblioteca.agregarLibro(data[1], data[0], Integer.parseInt(data[2]), Integer.parseInt(data[3]));
        });

        FileUtils.leerLineas("./prestamos.txt", linea -> {
            String[] data = linea.split(", ");
            if (Objects.equals(data[1], "PRESTAMO")) {
                boolean prestamo = biblioteca.registrarPrestamo(data[0], "user", Integer.parseInt(data[2])); // "user" esta hardcodeado, si el programa creciera se agrega el usuario por contexto
                if (!prestamo) {
                    System.out.println("No se pudo registrar el prestamo. Verifique los datos e intente nuevamente.");
                } else {
                    variacionTotal -= Integer.parseInt(data[2]);
                }
            } else if (Objects.equals(data[1], "DEVOLUCION")) {
                biblioteca.registrarDevolucion(data[0], "user", Integer.parseInt(data[2]));
                variacionTotal += Integer.parseInt(data[2]);
            }
        });

        biblioteca.listarLibrosOrdenados();
    }
}
