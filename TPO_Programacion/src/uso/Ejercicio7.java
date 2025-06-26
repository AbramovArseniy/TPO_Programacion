package uso;

import imple.*;
import tda.*;

public class Ejercicio7 {
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
        System.out.println("Pila en argumento: 5 2 1 4 6 1 2");
        ConjuntoTDA conjRepetidos = conjuntoDeRepetidos(pila);

        System.out.print("Elementos en conjunto de repetidos: ");
        while (!conjRepetidos.conjuntoVacio()) {
            int valor = conjRepetidos.elegir();
            System.out.print(valor);
            System.out.print(" ");
            conjRepetidos.sacar(valor);
        }
    }

    public static ConjuntoTDA conjuntoDeRepetidos(PilaTDA pila) {
        PilaTDA copia = new Pila();
        copia.inicializarPila();
        ConjuntoTDA conjTodos = new Conjunto();
        conjTodos.inicializarConjunto();
        ConjuntoTDA conjRepetidos = new Conjunto();
        conjRepetidos.inicializarConjunto();
        while (!pila.pilaVacia()) {
            int v = pila.tope();
            pila.desapilar();
            copia.apilar(v);
            if (conjTodos.pertenece(v)) {
                conjRepetidos.agregar(v);
            } else {
                conjTodos.agregar(v);
            }
        }

        while (!copia.pilaVacia()) {
            int v = copia.tope();
            pila.apilar(v);
            copia.desapilar();
        }
        return conjRepetidos;
    }
}
