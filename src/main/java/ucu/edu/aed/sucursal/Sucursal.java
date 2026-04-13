package ucu.edu.aed.sucursal;

import ucu.edu.aed.tda.ListaEnlazada;
import java.util.function.Predicate;

public class Sucursal extends ListaEnlazada<String> {
    private int id;
    private String ciudad;

    public Sucursal() {
        super();
    }
    public void agregar (String ciudad){
        super.agregar(ciudad);
    }
    public String buscar(Predicate<String> ciudad){
        System.out.println("Buscando sucursal");
        return super.buscar(ciudad);
    }
    public boolean remover(String ciudad){
        System.out.println("Eliminando sucursal");
        return super.remover(ciudad);
    }
    public void listar() {
        System.out.println("Listando sucursales");
        super.listar();
    }

    public void cantSucursales(Sucursal sucursal) {
        System.out.println("La cantidad de sucursales es: "+ sucursal.tamaño());
    }

    public String haySucursales(Sucursal sucursal){
        String mensaje;
        if (sucursal.esVacio()){
            mensaje = "El directorio de sucursales esta vacio";
        } else {
            mensaje = "El directorio de sucursales no esta vacio";
        }
        return mensaje;
    }
}
