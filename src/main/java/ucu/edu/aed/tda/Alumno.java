package ucu.edu.aed.tda;

public class Alumno {
    private int cedula;
    private String nombre;
    private String apellido;

    public Alumno(int cedula, String nombre, String apellido) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public int getCedula() {
        return cedula;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Alumno alumno = (Alumno) o;
        return cedula == alumno.cedula;
    }

    @Override
    public int hashCode() {
        return cedula;
    }

    @Override
    public String toString() {
        return cedula + " - " + nombre + " " + apellido;
    }
}