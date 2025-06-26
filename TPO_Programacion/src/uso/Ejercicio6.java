package uso;

import imple.Pila;
import tda.PilaTDA;

public class Ejercicio6 {
    public static void main(String[] args) {
        PilaTDA pila = new Pila();
        pila.inicializarPila();
        pila.apilar(5);
        pila.apilar(2);
        pila.apilar(1);
        pila.apilar(4);
        pila.apilar(6);
        pila.apilar(1);
        pila.apilar(2);
        System.out.println(pila.tope());
        float res = porcentajeDePares(pila);
        System.out.println("Porcentaje de pares: " + res + "%");
        System.out.println("Tope de pila: " + pila.tope());
    }

    public static float porcentajeDePares(PilaTDA pila) {
        PilaTDA nuevoPila = new Pila();
        nuevoPila.inicializarPila();
        float cantPares = 0;
        float cant = 0;
        while (!pila.pilaVacia()) {
            cant++;
            int elemento = pila.tope();
            pila.desapilar();
            nuevoPila.apilar(elemento);
            if (elemento % 2 == 0) {
                cantPares++;
            }

        }
        pila.inicializarPila();
        System.out.println(nuevoPila.pilaVacia());
        while (!nuevoPila.pilaVacia()) {
            pila.apilar(nuevoPila.tope());
            nuevoPila.desapilar();
        }
        return (cantPares / cant) * 100;
    }
}
