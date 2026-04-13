package ucu.edu.aed.biblioteca;

import ucu.edu.aed.tda.ListaEnlazada;

import java.util.Arrays;
import java.util.Objects;
import java.util.function.Predicate;

public class Biblioteca {
    public Catalogo catalogo = new Catalogo();
    public ListaEnlazada<Prestamo> prestamos = new ListaEnlazada<>();
    public ListaEnlazada<Devolucion> devoluciones = new ListaEnlazada<>();

    private static Predicate<Libro> getLibroPredicate(String codigoLibro) {
        Predicate<Libro> esIgual = libro -> Objects.equals(libro.getIdentificador(), codigoLibro);
        return esIgual;
    }

    public Libro agregarLibro(String titulo, String identificador, int precio, int cantEjemplares) {
        Libro existente = catalogo.buscar(getLibroPredicate(identificador));
        if (existente != null) {
            System.out.println("Libro ya existente");
            return existente;
        }

        Libro nuevoLibro = new Libro(titulo, identificador, precio, cantEjemplares);
        catalogo.agregar(nuevoLibro);
        return nuevoLibro;
    }

    public boolean registrarPrestamo(String codigoLibro, String nombreUsuario, int cantidad) {
        Predicate<Libro> esIgual = getLibroPredicate(codigoLibro);
        Libro libro = catalogo.buscar(esIgual);

        boolean fuePrestado = catalogo.prestar(libro, cantidad); // Si no hay existencias suficientes no se puede prestar, devuelve false
        Prestamo nuevoPrestamo = new Prestamo(libro, nombreUsuario, cantidad);

        if (fuePrestado) {
            prestamos.agregar(nuevoPrestamo);
            return true;
        } else {
            return false;
        }
    }

    public void registrarDevolucion(String codigoLibro, String nombreUsuario, int cantidad) {
        Predicate<Libro> esIgual = getLibroPredicate(codigoLibro);
        Libro libro = catalogo.buscar(esIgual);

        Devolucion nuevaDevolucion = new Devolucion(libro, nombreUsuario, cantidad);
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

        for (int i = 0; i < n; i++) {
            libros[i] = catalogo.obtener(i);
        }

        Arrays.sort(libros, (a, b) -> a.getTitulo().compareTo(b.getTitulo()));

        for (Libro libro : libros) {
            System.out.println(libro);
            System.out.println("-------------------");
        }
    }
}
