package uso;

import implementacion.*;
import interfaz.*;
import imple.*;
import tda.*;

public class Ejercicio3 {
    public static void main(String[] args) {
        usoMultiPila();
    }

    public static void usoMultiPila() {
        MultiPilaTDA mp = new MultiPila();
        mp.inicializarPila();

        // Crear primera pila
        PilaTDA p1 = new Pila();
        p1.inicializarPila();
        p1.apilar(1);
        p1.apilar(2);
        p1.apilar(3);

        // Apilar p1
        mp.apilar(p1);
        System.out.println("Apilada p1 (1,2,3)");

        // Crear segunda pila
        PilaTDA p2 = new Pila();
        p2.inicializarPila();
        p2.apilar(4);
        p2.apilar(5);

        // Apilar p2
        mp.apilar(p2);
        System.out.println("Apilada p2 (4,5)");

        // Ver tope de 4 elementos
        PilaTDA top = mp.tope(4);
        System.out.print("Tope de 4 elementos (debería mostrar 5,4,3,2): ");
        while (!top.pilaVacia()) {
            System.out.print(top.tope() + " ");
            top.desapilar();
        }
        System.out.println();

        // Desapilar p2
        mp.desapilar(p2);
        System.out.println("Desapilada p2");

        // Ver tope de 3 elementos
        top = mp.tope(3);
        System.out.print("Tope de 3 elementos (debería mostrar 3,2,1): ");
        while (!top.pilaVacia()) {
            System.out.print(top.tope() + " ");
            top.desapilar();
        }
        System.out.println();

        // Intentar desapilar p2 otra vez (no debería hacer nada)
        mp.desapilar(p2);
        System.out.println("Intento de desapilar p2 nuevamente (no debería cambiar)");

        // Ver tope final
        top = mp.tope(10);
        System.out.print("Contenido final de la multipila: ");
        while (!top.pilaVacia()) {
            System.out.print(top.tope() + " ");
            top.desapilar();
        }
        System.out.println();
    }
}
