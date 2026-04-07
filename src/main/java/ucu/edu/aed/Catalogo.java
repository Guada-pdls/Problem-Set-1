package ucu.edu.aed;
import ucu.edu.aed.tda.ListaEnlazada;
import ucu.edu.aed.tda.TDANodo;

import java.util.Objects;
import java.util.function.Predicate;

public class Catalogo extends ListaEnlazada<Libro> {
    protected TDANodo<Libro> primero;

    public void agregarExistencias(Libro libro, int cantidad) {
        libro.setCantEjemplares(libro.getCantEjemplares() + cantidad);
    }

    public boolean prestar(Libro libro) {
        if (libro.getCantEjemplares() >= 1) {
            libro.setCantEjemplares(libro.getCantEjemplares() - 1);
            return true;
        } else {
            return false;
        }
    }
}
