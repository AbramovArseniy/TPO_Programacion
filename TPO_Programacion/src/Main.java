import implementacion.*;
import interfaz.*;
import imple.*;
import tda.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("USO CONJUNTO ESPECIAL");
        usoConjuntoEspecial();

        System.out.println("USO CONJUNTO MAMUSHKA");
        usoConjuntoMamushka();

        System.out.println("USO MULTIPILA");
        usoMultiPila();
    }

    public static void usoConjuntoEspecial() {
        ConjuntoEspecialTDA conjunto = new ConjuntoEspecial();
        conjunto.inicializarConjunto();

        System.out.println("Conjunto vacío: " + conjunto.conjuntoVacio());

        ConjuntoEspecialTDA.Respuesta r;

        r = conjunto.agregar(10);
        System.out.println("Agregar 10 → error: " + r.error + ", valor: " + r.rta);

        r = conjunto.agregar(20);
        System.out.println("Agregar 20 → error: " + r.error + ", valor: " + r.rta);

        r = conjunto.agregar(10);
        System.out.println("Agregar 10 otra vez → error esperado: " + r.error);

        System.out.println("Pertenece 20: " + conjunto.pertenece(20));
        System.out.println("Pertenece 99: " + conjunto.pertenece(99));

        r = conjunto.elegir();
        System.out.println("Elegido → error: " + r.error + ", valor: " + r.rta);

        r = conjunto.sacar(10);
        System.out.println("Sacar 10 → error: " + r.error);

        r = conjunto.sacar(99);
        System.out.println("Sacar 99 (no existe) → error esperado: " + r.error);

        conjunto.sacar(20);
        System.out.println("Conjunto vacío al final: " + conjunto.conjuntoVacio());
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
