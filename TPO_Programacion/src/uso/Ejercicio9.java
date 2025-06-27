package uso;

import imple.*;
import tda.*;

public class Ejercicio9 {
    public static void main(String[] args) {
        PilaTDA pila = new Pila();
        pila.inicializarPila();
        //Llenamos la pila.
        pila.apilar(5);
        pila.apilar(2);
        pila.apilar(1);
        pila.apilar(4);
        pila.apilar(6);
        System.out.println("Pila en argumento: 5 2 1 4 6");

        ColaTDA cola = new Cola();
        cola.inicializarCola();
        cola.acolar(2);
        cola.acolar(1);
        cola.acolar(8);
        cola.acolar(9);
        ConjuntoTDA conjComun = conjuntoComun(pila, cola);
        System.out.println("Pila en argumento: 2 1 8 9");

        System.out.print("Elementos en conjunto comun: ");
        while (!conjComun.conjuntoVacio()) {
            int valor = conjComun.elegir();
            System.out.print(valor);
            System.out.print(" ");
            conjComun.sacar(valor);
        }
    }

    public static ConjuntoTDA conjuntoComun(PilaTDA pila, ColaTDA cola) {
        PilaTDA copiaPila = new Pila();
        copiaPila.inicializarPila();
        ColaTDA copiaCola = new Cola();
        copiaCola.inicializarCola();
        ConjuntoTDA conjElemPila = new Conjunto();
        conjElemPila.inicializarConjunto();
        ConjuntoTDA conjComun = new Conjunto();
        conjComun.inicializarConjunto();
        while (!pila.pilaVacia()) {
            int v = pila.tope();
            pila.desapilar();
            copiaPila.apilar(v);
            conjElemPila.agregar(v);
        }

        while (!cola.colaVacia()) {
            int v = cola.primero();
            cola.desacolar();
            copiaCola.acolar(v);
            if (conjElemPila.pertenece(v)) {
                conjComun.agregar(v);
            }
        }

        while (!copiaPila.pilaVacia()) {
            int v = copiaPila.tope();
            pila.apilar(v);
            copiaPila.desapilar();
        }

        while (!copiaCola.colaVacia()) {
            int v = copiaCola.primero();
            cola.acolar(v);
            copiaCola.desacolar();
        }
        return conjComun;
    }
}