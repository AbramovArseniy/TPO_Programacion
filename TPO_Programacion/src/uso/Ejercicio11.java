package uso;

import imple.Cola;
import imple.Conjunto;
import imple.DiccionarioMultiple;
import tda.ColaTDA;
import tda.ConjuntoTDA;
import tda.DiccionarioMultipleTDA;

public class Ejercicio11 {
    public static void main(String[] args) {
        DiccionarioMultipleTDA dicc = new DiccionarioMultiple();
        dicc.inicializarDiccionario();

        dicc.agregar(1, 10);
        dicc.agregar(1, 20);
        dicc.agregar(2, 20);
        dicc.agregar(2, 30);
        dicc.agregar(3, 10);
        dicc.agregar(3, 40);

        System.out.println("Diccionario Multiple en argumento:");
        System.out.println("\t1 : [10, 20]");
        System.out.println("\t2 : [20, 30]");
        System.out.println("\t3 : [10, 40]");

        ColaTDA resultado = valoresSinRepeticion(dicc);

        System.out.print("Cola resultado: ");
        while (!resultado.colaVacia()) {
            System.out.print(resultado.primero() + " ");
            resultado.desacolar();
        }
    }

    // n - cantidad de elementos en el diccionario
    // Tiempo de ejecucion: O(n^2)
    public static ColaTDA valoresSinRepeticion(DiccionarioMultipleTDA dicc) {
        // cola de valores unicos del diccionario
        ColaTDA res = new Cola();
        res.inicializarCola();

        ConjuntoTDA claves = dicc.claves();

        ConjuntoTDA valoresUnicos = new Conjunto(); // conjunto de valores unicos del diccionario
        valoresUnicos.inicializarConjunto();

        while (!claves.conjuntoVacio()) {
            int clave = claves.elegir();
            claves.sacar(clave);

            ConjuntoTDA valores = dicc.recuperar(clave); // recuperamos valores por una clave

            while (!valores.conjuntoVacio()) {
                int valor = valores.elegir();
                valores.sacar(valor);

                // Si todavia no encontremos esta valor lo agregamos a res
                if (!valoresUnicos.pertenece(valor)) {
                    valoresUnicos.agregar(valor);
                    res.acolar(valor);
                }
            }
        }

        return res;
    }
}
