package ucu.edu.aed.sucursal;


import ucu.edu.aed.sucursal.utils.FileUtils;

import java.util.LinkedList;

public class Main {
    LinkedList<Sucursal> sucursales = new LinkedList<>();
    int contador = 0;

    public void main(String[] args) {
        FileUtils.leerLineas("archivo.txt", linea -> {
            contador++;
            sucursales.add(new Sucursal(contador, linea));
        });
    }

}
