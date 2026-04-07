package ucu.edu.aed;

public class Libro {
    private String titulo;
    private String identificador;
    private float precio;
    private int cantEjemplares;

    public Libro(String titulo, String identificador, int precio, int cantEjemplares) {
        this.titulo = titulo;
        this.identificador = identificador;
        this.precio = precio;
        this.cantEjemplares = cantEjemplares;
    }

    public String getTitulo() { return titulo; }

    public String getIdentificador(){return identificador;}

    public int getCantEjemplares() {
        return cantEjemplares;
    }

    public void setCantEjemplares(int cantEjemplares) {
        this.cantEjemplares = cantEjemplares;
    }

    @Override
    public String toString() {
        return "Libro: " + this.titulo +
                "\n Código: " + this.identificador +
                "\n Precio: " + this.precio +
                "\n Stock: " + this.cantEjemplares;
    }
}
