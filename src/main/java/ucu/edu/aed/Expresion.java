package ucu.edu.aed;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class Expresion {
    boolean controlCorchetes(LinkedList<String> listaDeEntrada) {
        Stack<String> pila = new Stack<String>();

        for (String letra : listaDeEntrada) {
            switch (letra) {
                case "{":
                    pila.push(letra);
                    break;
                case "}":
                    if (pila.isEmpty()) {
                        return false;
                    }
                    pila.pop();
                    break;
                default:
                    return false;
            }
        }

        if (pila.isEmpty()) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese una expresión con { y } para analizar:");

        String input = scanner.nextLine();

        // Convertimos el string en lista de Strings (caracter por caracter)
        LinkedList<String> lista = new LinkedList<>();
        for (char c : input.toCharArray()) {
            lista.add(String.valueOf(c));
        }

        Expresion exp = new Expresion();
        boolean resultado = exp.controlCorchetes(lista);

        if (resultado) {
            System.out.println("Expresión bien formada");
        } else {
            System.out.println("Expresión mal formada");
        }

        scanner.close();
    }
}