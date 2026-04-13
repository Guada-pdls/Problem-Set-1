package ucu.edu.aed.tda;

import java.util.Comparator;
import java.util.function.Predicate;

public class ListaEnlazada<T> implements TDALista<T> {
    protected Nodo<T> primero;

    @Override
    public void agregarConIndice(int index, T elem) {
    }

    @Override
    public T obtener(int index) {
        Nodo<T> actual = primero;
        int i = 0;
        while (actual != null) {
            if (i == index) {
                return actual.getValor();
            }
            actual = actual.getSiguiente();
            i++;
        }
        throw new IndexOutOfBoundsException();
    }

    @Override
    public T remover(int index) {
        return null;
    }

    @Override
    public boolean remover(T elem) { // Quita el elemento de la lista, pero lo deja disponible para su posterior utilizacion
        if (primero==null){ // Si esta vacia
            return false;
        }

        if (primero.getValor().equals(elem)){ // si el primer valor es igual al elemento a buscar
            primero=primero.getSiguiente(); // lo elimino de la lista
            return true;
        }
        Nodo<T> actual=primero; // sino
                while (actual.getSiguiente() !=null){ // mientras el siguiente al actual no sea nulo
                    if (actual.getSiguiente().getValor().equals(elem)){ // verifico si el sig es igual al elemento a remover
                        actual.setSiguiente(actual.getSiguiente().getSiguiente()); // le quito la ref 
                return true;
            }
            actual=actual.getSiguiente();
        }
        return false;

    }

    @Override
    public boolean contiene(T elem) {
        Nodo<T> actual = primero;
        while (actual != null) {
            if (actual.getValor().equals(elem)) {
                return true;
            }
            actual = actual.getSiguiente();
        }
        return false;
    }

    @Override
    public int indiceDe(T elem) {
        Nodo<T> actual = primero;
        int i = 0;
        while (actual != null) {
            if (actual.getValor().equals(elem)) {
                return i;
            }
            actual = actual.getSiguiente();
            i++;
        }
        return -1;
    }

    @Override
    public T buscar(Predicate<T> criterio) {
        Nodo<T> actual=primero;
        while (actual!=null){
            if (criterio.test(actual.getValor())){
                return actual.getValor();
            }
            actual=actual.getSiguiente();
        }
        return null;
    }

    @Override
    public TDALista<T> ordenar(Comparator<T> comparator) {
        return null;
    }

    @Override
    public int tamaño() {
        int contador=0;
        Nodo<T> actual=primero;
        while (actual !=null){
            contador++;
            actual=actual.getSiguiente();
        }
        return contador;
    }

    @Override
    public boolean esVacio() {
        return primero == null;
    }

    @Override
    public void vaciar() {
        primero = null;
    }

    @Override
    public void agregar(T elem) {
        Nodo<T> nuevoNodo = new Nodo<T>(elem);
        nuevoNodo.setSiguiente(primero);
        primero = nuevoNodo;
    }

    public void listar(String separador) {
        Nodo<T> actual=primero;
        while (actual!=null) {
            System.out.println(actual.getValor() + separador);
            actual = actual.getSiguiente();
        }
    }
}
