import implementacion.*;
import interfaz.*;
import imple.*;
import tda.*;

public class Ejersicio1 {
    public static void main(String[] args) {
        usoConjuntoEspecial();
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
}
