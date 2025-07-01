package uso;

import tda.*;
import imple.*;

public class Ejercicio12 {
    public static void main(String[] args) {

        ABBTDA abb1 = new ABB();
        abb1.inicializarArbol();

        abb1.agregarElem(10);
        abb1.agregarElem(5);
        abb1.agregarElem(7);
        abb1.agregarElem(12);
        abb1.agregarElem(9);

        int sumaImpares = sumaImpares(abb1);
        System.out.println("Suma de elementos impares: " + sumaImpares);  // Esperado: 5 + 7 + 9 = 21
    }

    public static int sumaImpares(ABBTDA abb) {
        if (abb.arbolVacio()) {
            return 0;
        }

        int valor = abb.raiz();
        int suma = (valor % 2 != 0) ? valor : 0;

        return suma +
                sumaImpares(abb.hijoIzq()) +
                sumaImpares(abb.hijoDer());
    }
}
