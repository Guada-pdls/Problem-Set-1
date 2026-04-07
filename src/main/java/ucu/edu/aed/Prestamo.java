package ucu.edu.aed;

public class Prestamo {
    private Libro libroAPrestar;
    private String nombreUsuario;

    public Prestamo(Libro libroAPrestar, String nombreUsuario) {
        this.libroAPrestar = libroAPrestar;
        this.nombreUsuario = nombreUsuario;
    }

    public Libro getLibroAPrestar() {
        return libroAPrestar;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }
}
