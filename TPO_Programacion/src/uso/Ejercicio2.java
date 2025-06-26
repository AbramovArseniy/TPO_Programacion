package uso;

import implementacion.*;
import interfaz.*;
import imple.*;
import tda.*;

public class Ejercicio2 {
    public static void main(String[] args) {
        usoConjuntoMamushka();
    }

    public static void usoConjuntoMamushka() {
        ConjuntoMamushka conjunto = new ConjuntoMamushka();
        conjunto.inicializar();

        System.out.println("¿Está vacío al inicio? " + conjunto.estaVacio()); // true

        conjunto.guardar(10);
        System.out.println("Guardar 10");
        conjunto.guardar(20);
        System.out.println("Guardar 20");
        conjunto.guardar(10);
        System.out.println("Guardar 10");
        conjunto.guardar(30);
        System.out.println("Guardar 30");

        System.out.println("Cantidad de 10: " + conjunto.perteneceCant(10)); // 2
        System.out.println("Cantidad de 20: " + conjunto.perteneceCant(20)); // 1
        System.out.println("Cantidad de 99 (inexistente): " + conjunto.perteneceCant(99)); // 0
        System.out.println("¿Está vacío después de guardar? " + conjunto.estaVacio()); // false

        int elegido = conjunto.elegir();
        System.out.println("Elemento elegido aleatoriamente: " + elegido); // Puede ser 10, 20 o 30

        conjunto.sacar(10);
        System.out.println("Sacar 10");
        System.out.println("Cantidad de 10: " + conjunto.perteneceCant(10)); // 1

        conjunto.sacar(10);
        System.out.println("Sacar 10");
        System.out.println("Cantidad de 10: " + conjunto.perteneceCant(10)); // 0

        conjunto.sacar(99); // No debería cambiar nada
        System.out.println("Intentamos sacar 99 (inexistente): OK");

        System.out.println("¿Está vacío al final? " + conjunto.estaVacio()); // false

        conjunto.sacar(20);
        System.out.println("Sacar 20");
        conjunto.sacar(30);
        System.out.println("Sacar 30");
        System.out.println("¿Está vacío tras sacar todo? " + conjunto.estaVacio()); // true
    }
}
