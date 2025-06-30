package uso;

import imple.ABB;
import tda.ABBTDA;

public class Ejercicio13 {
    public static void main(String[] args) {

        ABBTDA abb2 = new ABB();
        abb2.inicializarArbol();

        abb2.agregarElem(20);  // raíz
        abb2.agregarElem(10);  // hoja par
        abb2.agregarElem(30);
        abb2.agregarElem(25);  // hoja impar
        abb2.agregarElem(35);  // hoja impar

        int cantidadHojasPares = contarHojasPares(abb2);
        System.out.println("Cantidad de hojas con valor par: " + cantidadHojasPares);  // Esperado: 1
    }
    public static int contarHojasPares(ABBTDA abb) {
        if (abb.arbolVacio()) {
            return 0;
        }

        boolean esHoja = abb.hijoIzq().arbolVacio() && abb.hijoDer().arbolVacio();
        int suma = 0;

        if (esHoja && abb.raiz() % 2 == 0) {
            suma = 1;
        }

        return suma +
                contarHojasPares(abb.hijoIzq()) +
                contarHojasPares(abb.hijoDer());
    }
}
