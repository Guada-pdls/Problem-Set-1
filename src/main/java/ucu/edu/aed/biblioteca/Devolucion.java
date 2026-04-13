package ucu.edu.aed.biblioteca;

public class Devolucion {
    private Libro libroADevolver;
    private String nombreUsuario;
    private int cantidad;

    public Devolucion(Libro libroADevolver, String nombreUsuario, int cantidad) {
        this.libroADevolver = libroADevolver;
        this.nombreUsuario = nombreUsuario;
        this.cantidad = cantidad;
    }

    public Libro getLibroADevolver() {
        return libroADevolver;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public int getCantidad() {
        return cantidad;
    }
}
