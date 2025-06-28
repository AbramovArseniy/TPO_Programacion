package uso;

import imple.Conjunto;
import imple.DiccionarioSimple;
import imple.Pila;
import tda.ConjuntoTDA;
import tda.DiccionarioSimpleTDA;
import tda.PilaTDA;

public class Ejercicio10 {
    public static void main(String[] args) {
        PilaTDA pila = new Pila();
        pila.inicializarPila();
        pila.apilar(1);
        pila.apilar(2);
        pila.apilar(3);
        pila.apilar(1);
        pila.apilar(1);
        pila.apilar(4);
        pila.apilar(2);

        DiccionarioSimpleTDA dicc = crear_diccionario(pila);
        System.out.println("Cantidad de 1 en la pila: " + dicc.recuperar(1));
        System.out.println("Cantidad de 2 en la pila: " + dicc.recuperar(2));
        System.out.println("Cantidad de 3 en la pila: " + dicc.recuperar(3));
        System.out.println("Cantidad de 4 en la pila: " + dicc.recuperar(4));
    }

    public static DiccionarioSimpleTDA crear_diccionario(PilaTDA pila) {
        //Función para crear un diccionario donde la clave sea el número y el valor sea la cantidad de veces que ese número aparece en la pila.
        //Complejidad O(n)

        DiccionarioSimpleTDA dicc = new DiccionarioSimple();
        PilaTDA copyPila = new Pila(); //copia de pila
        ConjuntoTDA claves = new Conjunto(); // conjunto de claves

        dicc.inicializarDiccionario();
        copyPila.inicializarPila();
        claves.inicializarConjunto();

        while (!pila.pilaVacia()) {

            int elemento = pila.tope();
            pila.desapilar();
            copyPila.apilar(elemento);

            if (claves.pertenece(elemento)) {
                //Si el elemento se encuentra en Claves, le sumamos 1 al valor de la clave.
                dicc.agregar(elemento, dicc.recuperar(elemento) + 1);
            } else {
                // Si no existe esa clave, el valor es 1.
                dicc.agregar(elemento, 1);
                claves.agregar(elemento);
            }
        }
        while (!pila.pilaVacia()) {
            //restauramos la pila original
            int elemento = copyPila.tope();
            copyPila.desapilar();
            pila.apilar(elemento);
        }
        return dicc;

    }

}
