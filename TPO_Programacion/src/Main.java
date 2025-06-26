import imple.Pila;
import implementacion.DiccionarioSimpleColas;
import implementacion.DiccionarioSimpleMod;
import interfaz.DiccionarioSimpleModTDA;
import tda.*;


public class Main {

    public static void main(String[] args) {
//        UsoDiccionarioSimpleMod();
        UsoDiccionarioSimpleColas();
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
        claves.inicializarConjunto();

        System.out.println("Claves en el diccionario:");
        while (!claves.conjuntoVacio()) {
            int clave = claves.elegir();
            System.out.println("Clave: " + clave);
            claves.sacar(clave);
        }
    }

    public static void UsoDiccionarioSimpleColas() {
        DiccionarioSimpleTDA dic = new DiccionarioSimpleColas();
        dic.inicializarDiccionario();

        dic.agregar(1, 100);
        dic.agregar(2, 200);
        dic.agregar(3, 300);

        System.out.println("Clave 1 -> " + dic.recuperar(1));
        System.out.println("Clave 2 -> " + dic.recuperar(2));
        System.out.println("Clave 3 -> " + dic.recuperar(3));
        System.out.println("Clave 1 -> " + dic.recuperar(1));

        dic.agregar(2, 250);
        System.out.println("Clave 2 después de modificar -> " + dic.recuperar(2));

        dic.eliminar(1);

        System.out.println("clave 1 sigue " + dic.recuperar(2));

        dic.eliminar(2);

        System.out.println("clave 1 sigue " + dic.recuperar(1));
        System.out.println("Clave 3 sigue -> " + dic.recuperar(3));
    }

}