package ucu.edu.aed.tda;

public class Conjunto<T> extends ListaEnlazada<T> implements TDAConjunto<T> {

    @Override
    public TDAConjunto<T> union(TDAConjunto<T> otro) {
        Conjunto<T> resultado = new Conjunto<>();

        for (int i = 0; i < this.tamaño(); i++) {
            T elem = this.obtener(i);
            if (!resultado.contiene(elem)) {
                resultado.agregar(elem);
            }
        }

        for (int i = 0; i < otro.tamaño(); i++) {
            T elem = otro.obtener(i);
            if (!resultado.contiene(elem)) {
                resultado.agregar(elem);
            }
        }

        return resultado;
    }

    @Override
    public TDAConjunto<T> interseccion(TDAConjunto<T> otro) {
        Conjunto<T> resultado = new Conjunto<>();

        for (int i = 0; i < this.tamaño(); i++) {
            T elem = this.obtener(i);

            if (otro.contiene(elem) && !resultado.contiene(elem)) {
                resultado.agregar(elem);
            }
        }

        return resultado;
    }

    @Override
    public TDAConjunto<T> diferencia(TDAConjunto<T> otro) {
        return null;
    }

    @Override
    public boolean esSubconjuntoDe(TDAConjunto<T> otro) {
        return false;
    }
}