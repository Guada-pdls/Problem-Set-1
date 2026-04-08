package ucu.edu.aed.biblioteca;

public class Devolucion {
    private Libro libroADevolver;
    private String nombreUsuario;

    public Devolucion(Libro libroADevolver, String nombreUsuario) {
        this.libroADevolver = libroADevolver;
        this.nombreUsuario = nombreUsuario;
    }

    public Libro getLibroADevolver() {
        return libroADevolver;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }
}
