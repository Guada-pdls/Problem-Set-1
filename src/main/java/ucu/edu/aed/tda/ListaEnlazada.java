package ucu.edu.aed.tda;

import java.util.Comparator;
import java.util.function.Predicate;

public class ListaEnlazada<T> implements TDALista<T> {
    protected TDANodo<T> primero;

    @Override
    public void agregar(int index, T elem) {

    }

    @Override
    public T obtener(int index) {
        return null;
    }

    @Override
    public T remover(int index) {
        return null;
    }

    @Override
    public boolean remover(T elem) {
        if (primero==null){
            return false;
        }

        if (primero.getValor().equals(elem)){
            primero=primero.getSiguiente();
            return true;
        }
        TDANodo<T> actual=primero;
        while (actual.getSiguiente() !=null){
            if (actual.getSiguiente().getValor().equals(elem)){
                actual.setSiguiente(actual.getSiguiente().getSiguiente());
                return true;
            }
            actual=actual.getSiguiente();
        }
        return false;

    }

    @Override
    public boolean contiene(T elem) {
        return false;
    }

    @Override
    public int indiceDe(T elem) {
        return 0;
    }

    @Override
    public T buscar(Predicate<T> criterio) {
        TDANodo<T> actual=primero;
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
        TDANodo<T> actual=primero;
        while (actual !=null){
            contador++;
            actual=actual.getSiguiente();
        }
        return contador;
    }

    @Override
    public boolean esVacio() {
        return false;
    }

    @Override
    public void vaciar() {

    }

    @Override
    public void agregar(T elem) {
        TDANodo<T> nuevoNodo = new TDANodo<T>(elem);
        nuevoNodo.setSiguiente(primero);
        primero = nuevoNodo;
    }
}
