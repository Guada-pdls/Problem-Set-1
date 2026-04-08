package ucu.edu.aed;

import ucu.edu.aed.biblioteca.Libro;

public class Nodo {
    Libro dato;
    Nodo siguiente;

    public Nodo(Libro dato){
        this.dato=dato;
        this.siguiente=null;
    }
}
