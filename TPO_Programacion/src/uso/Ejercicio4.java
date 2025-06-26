package uso;

import implementacion.DiccionarioSimpleMod;
import interfaz.DiccionarioSimpleModTDA;
import tda.ConjuntoTDA;

public class Ejercicio4 {
    public static void main(String[] args) {
        UsoDiccionarioSimpleMod();

    }
    public static void UsoDiccionarioSimpleMod() {
        DiccionarioSimpleModTDA dicc = new DiccionarioSimpleMod();
        dicc.inicializarDiccionario();

        // agregamos claves y valores
        dicc.agregar(1, 100);
        dicc.agregar(2, 200);
        dicc.agregar(1, 150);
        dicc.agregar(1, 180);

        System.out.println("Valor de clave 1: " + dicc.recuperar(1)); // esperamos 180
        System.out.println("Modificaciones de clave 1: " + dicc.recuperarMod(1)); // esperamos 2

        System.out.println("Valor de clave 2: " + dicc.recuperar(2)); // 200
        System.out.println("Modificaciones de clave 2: " + dicc.recuperarMod(2)); // 0

        ConjuntoTDA claves = dicc.claves();

        System.out.print("Claves en el diccionario: ");
        while (!claves.conjuntoVacio()) {
            int clave = claves.elegir();
            System.out.print(clave + " ");
            claves.sacar(clave);
        }
    }
}
