package uso;

import imple.Pila;
import tda.PilaTDA;

public class Ejercicio6 {
    public static void main(String[] args) {
        PilaTDA pila = new Pila();
        pila.inicializarPila();
        //Llenamos la pila.
        pila.apilar(5);
        pila.apilar(2);
        pila.apilar(1);
        pila.apilar(4);
        pila.apilar(6);
        pila.apilar(1);
        pila.apilar(2);
        System.out.println("Tope de pila: "+pila.tope());
        float res = porcentajeDePares(pila); // Obtenemos el porcentaje.
        System.out.println("Porcentaje de pares: " + res + "%");
        System.out.println("Tope de pila: " + pila.tope());
    }

    public static float porcentajeDePares(PilaTDA pila) {
        // Función para calcular el porcentaje de pares, complejidad O(2n).

        PilaTDA nuevoPila = new Pila(); //Creamos una pila auxiliar.
        nuevoPila.inicializarPila();

        float cantPares = 0;
        float cant = 0;
        //Recorremos la pila y contamos la cantidad de elementos y la cantidad de elementos pares.
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
        //Devolvemos los elementos a la pila original.
        while (!nuevoPila.pilaVacia()) {
            pila.apilar(nuevoPila.tope());
            nuevoPila.desapilar();
        }
        return (cantPares / cant) * 100;
    }
}
