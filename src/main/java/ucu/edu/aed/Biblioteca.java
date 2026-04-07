package ucu.edu.aed;

import ucu.edu.aed.tda.ListaEnlazada;

import java.util.Objects;
import java.util.function.Predicate;

public class Biblioteca {
    public Catalogo catalogo;
    public ListaEnlazada<Prestamo> prestamos;
    public ListaEnlazada<Devolucion> devoluciones;

    private static Predicate<Libro> getLibroPredicate(String codigoLibro) {
        Predicate<Libro> esIgual = libro -> Objects.equals(libro.getIdentificador(), codigoLibro);
        return esIgual;
    }

    public boolean registrarPrestamo(String codigoLibro, String nombreUsuario) {
        Predicate<Libro> esIgual = getLibroPredicate(codigoLibro);
        Libro libro = catalogo.buscar(esIgual);

        boolean fuePrestado = catalogo.prestar(libro); // Si no hay existencias suficientes no se puede prestar, devuelve false
        Prestamo nuevoPrestamo = new Prestamo(libro, nombreUsuario);

        if (fuePrestado) {
            prestamos.agregar(nuevoPrestamo);
            return true;
        } else {
            return false;
        }
    }

    public void registrarDevolucion(String codigoLibro, String nombreUsuario) {
        Predicate<Libro> esIgual = getLibroPredicate(codigoLibro);
        Libro libro = catalogo.buscar(esIgual);

        Devolucion nuevaDevolucion = new Devolucion(libro, nombreUsuario);
        catalogo.agregarExistencias(libro, 1);
        devoluciones.agregar(nuevaDevolucion);
    }

    public int cantidadExistencias(String codigoLibro) {
        Predicate<Libro> esIgual = getLibroPredicate(codigoLibro);
        Libro libro = catalogo.buscar(esIgual);
        return libro.getCantEjemplares();
    }

    public void listarLibrosOrdenados(){
        int n=catalogo.tamaño();
        Libro[] libros =new Libro[n];


    }
}
