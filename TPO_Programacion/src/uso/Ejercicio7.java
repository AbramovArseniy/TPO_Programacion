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

    // Tiempo de ejecucion: O(n^2)  n - cantidad de valores en la pila
    public static ConjuntoTDA conjuntoDeRepetidos(PilaTDA pila) {
        // Creamos una copia para no perder los valores originales
        PilaTDA copia = new Pila();
        copia.inicializarPila();
        // Conjunto de todos elemetos de pila para encontrar las repeticiones
        ConjuntoTDA conjTodos = new Conjunto();
        conjTodos.inicializarConjunto();
        // Conjunto de elementos repetidos de la pila
        ConjuntoTDA conjRepetidos = new Conjunto();
        conjRepetidos.inicializarConjunto();

        while (!pila.pilaVacia()) {
            int v = pila.tope(); // tomamos valor tope
            pila.desapilar();
            copia.apilar(v); // agregamos valores de pila original a la copia
            if (conjTodos.pertenece(v)) {
                conjRepetidos.agregar(v); // si ya encontremos este valor lo agregamos a conjRepetidos
            } else {
                conjTodos.agregar(v); // si no encontremos este valor lo agregamos a conjuntoTodos
            }
        }

        // Restauramos la pila original
        while (!copia.pilaVacia()) {
            int v = copia.tope();
            pila.apilar(v);
            copia.desapilar();
        }
        return conjRepetidos;
    }
}
