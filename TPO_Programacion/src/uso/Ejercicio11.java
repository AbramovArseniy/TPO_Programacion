package uso;

import imple.Cola;
import imple.Conjunto;
import imple.DiccionarioMultiple;
import tda.ColaTDA;
import tda.ConjuntoTDA;
import tda.DiccionarioMultipleTDA;
import tda.DiccionarioSimpleTDA;

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

        ColaTDA resultado = valoresSinRepeticionRestaurando(dicc);

        System.out.print("Cola resultado: ");
        while (!resultado.colaVacia()) {
            System.out.print(resultado.primero() + " ");
            resultado.desacolar();
        }
    }

    public static ColaTDA valoresSinRepeticionRestaurando(DiccionarioMultipleTDA dicc) {
        ColaTDA resultado = new Cola();
        resultado.inicializarCola();

        ConjuntoTDA clavesOriginales = dicc.claves();
        ConjuntoTDA copiaClaves = new Conjunto();
        copiaClaves.inicializarConjunto();

        ConjuntoTDA valoresUnicos = new Conjunto();
        valoresUnicos.inicializarConjunto();

        while (!clavesOriginales.conjuntoVacio()) {
            int clave = clavesOriginales.elegir();
            clavesOriginales.sacar(clave);
            copiaClaves.agregar(clave);
        }

        while (!copiaClaves.conjuntoVacio()) {
            int clave = copiaClaves.elegir();
            copiaClaves.sacar(clave);

            ConjuntoTDA valoresOriginales = dicc.recuperar(clave);
            ConjuntoTDA valoresCopia = new Conjunto();
            valoresCopia.inicializarConjunto();

            while (!valoresOriginales.conjuntoVacio()) {
                int valor = valoresOriginales.elegir();
                valoresOriginales.sacar(valor);

                if (!valoresUnicos.pertenece(valor)) {
                    valoresUnicos.agregar(valor);
                    resultado.acolar(valor);
                }

                valoresCopia.agregar(valor);
            }

            while (!valoresCopia.conjuntoVacio()) {
                int valor = valoresCopia.elegir();
                valoresCopia.sacar(valor);
                dicc.agregar(clave, valor);
            }
        }

        return resultado;
    }
}
