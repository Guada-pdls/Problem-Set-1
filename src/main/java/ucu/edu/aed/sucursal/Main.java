package ucu.edu.aed.sucursal;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        Sucursal sucursales = new Sucursal();
        try (BufferedReader br = new BufferedReader(new FileReader("sucursales.txt"))) {

            String linea;

            while ((linea = br.readLine()) != null) {
                sucursales.agregar(linea);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        sucursales.listar(";");
        sucursales.cantSucursales(sucursales);
    }
}
