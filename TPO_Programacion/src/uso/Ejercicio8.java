package uso;

import imple.Cola;
import imple.Conjunto;
import tda.ColaTDA;
import tda.ConjuntoTDA;

public class Ejercicio8 {
    public static void main(String[] args) {
        ColaTDA cola = new Cola();
        cola.inicializarCola();
        cola.acolar(1);
        cola.acolar(4);
        cola.acolar(2);
        cola.acolar(3);
        cola.acolar(1);
        cola.acolar(2);
        cola.acolar(4);

        ColaTDA colaSinRepetidos = eliminarRepetidos(cola);
        System.out.println("Elementos de nueva cola:");
        System.out.println(colaSinRepetidos.primero());
        colaSinRepetidos.desacolar();
        System.out.println(colaSinRepetidos.primero());
        colaSinRepetidos.desacolar();
        System.out.println(colaSinRepetidos.primero());
        colaSinRepetidos.desacolar();
        System.out.println(colaSinRepetidos.primero());
        colaSinRepetidos.desacolar();


    }
    public static ColaTDA eliminarRepetidos(ColaTDA cola){
        //Función que elimina los elementos repetidos, complejidad O(n)


        ColaTDA nuevoCola = new Cola(); //cola sin repetidos
        ColaTDA copiaCola = new Cola(); // cola auxiliar.
        ConjuntoTDA elementos = new Conjunto(); // conjunto de elementos de cola

        nuevoCola.inicializarCola();
        copiaCola.inicializarCola();
        elementos.inicializarConjunto();

        while (!cola.colaVacia()){
            int elemento = cola.primero();
            cola.desacolar();
            copiaCola.acolar(elemento);

            if (!elementos.pertenece(elemento)){
                //Si el elemento no está en el conjunto, lo agregamos al conjunto y a la cola.

                elementos.agregar(elemento);
                nuevoCola.acolar(elemento);
            }
        }

        //Devolvemos los elementos a la cola original.
        while (!copiaCola.colaVacia()){
            int elemento = copiaCola.primero();
            copiaCola.desacolar();
            cola.acolar(elemento);
        }

        return nuevoCola;
    }
}
