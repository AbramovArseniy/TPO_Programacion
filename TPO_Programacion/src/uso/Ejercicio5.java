package uso;

import implementacion.DiccionarioSimpleColas;
import tda.DiccionarioSimpleTDA;

public class Ejercicio5 {
    public static void main(String[] args) {
        UsoDiccionarioSimpleColas();
    }
    public static void UsoDiccionarioSimpleColas() {
        DiccionarioSimpleTDA dic = new DiccionarioSimpleColas();
        dic.inicializarDiccionario();

        dic.agregar(1, 100);
        dic.agregar(2, 200);
        dic.agregar(3, 300);

        System.out.println("Clave 1: " + dic.recuperar(1));
        System.out.println("Clave 2: " + dic.recuperar(2));
        System.out.println("Clave 3: " + dic.recuperar(3));
        System.out.println("Clave 1: " + dic.recuperar(1));

        dic.agregar(2, 250);
        System.out.println("Clave 2 después de modificar: " + dic.recuperar(2));

        dic.eliminar(1);

        System.out.println("clave 2 sigue " + dic.recuperar(2));

        dic.eliminar(2);

        System.out.println("clave 1 sigue " + dic.recuperar(1));
        System.out.println("Clave 3 sigue " + dic.recuperar(3));
    }
}
