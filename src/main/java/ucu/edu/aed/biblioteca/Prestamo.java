package ucu.edu.aed.biblioteca;

public class Prestamo {
    private Libro libroAPrestar;
    private String nombreUsuario;
    private int cantidad;

    public Prestamo(Libro libroAPrestar, String nombreUsuario, int cantidad) {
        this.libroAPrestar = libroAPrestar;
        this.nombreUsuario = nombreUsuario;
        this.cantidad = cantidad;
    }

    public Libro getLibroAPrestar() {
        return libroAPrestar;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
