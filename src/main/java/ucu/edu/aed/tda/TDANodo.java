package ucu.edu.aed.tda;

public class TDANodo<T> {
    protected T valor;
    protected TDANodo<T> siguiente;

    public TDANodo(T valor) {
        this.valor = valor;
    }

    public T getValor() {
        return valor;
    }

    public void setValor(T valor) {
        this.valor = valor;
    }

    public TDANodo<T> getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(TDANodo<T> siguiente) {
        this.siguiente = siguiente;
    }
}
