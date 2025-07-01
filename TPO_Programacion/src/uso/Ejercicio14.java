package uso;

import imple.*;
import tda.*;

public class Ejercicio14 {
    public static void main(String[] args) {
            // Crear grafo y vértices
            GrafoTDA grafo = new Grafo();
            grafo.inicializarGrafo();

            grafo.agregarVertice(1);
            grafo.agregarVertice(2);
            grafo.agregarVertice(3);
            grafo.agregarVertice(4);

            // Aristas
            grafo.agregarArista(1, 2, 1); // 1 → 2
            grafo.agregarArista(2, 3, 1); // 2 → 3
            grafo.agregarArista(1, 4, 1); // 1 → 4
            grafo.agregarArista(4, 3, 1); // 4 → 3

            ConjuntoTDA puentes = verticesPuente(grafo, 1, 3);
            while (!puentes.conjuntoVacio()) {
                int x = puentes.elegir();
                System.out.println("Puente: " + x);
                puentes.sacar(x);
            }
    }
    public static ConjuntoTDA verticesPuente(GrafoTDA grafo, int origen, int destino) {
        ConjuntoTDA puente = new Conjunto();
        puente.inicializarConjunto();

        // recuperamos las vertices del grafo
        ConjuntoTDA vertices = grafo.vertices();
        int v = vertices.elegir();

        while (!vertices.conjuntoVacio()) {
            if (grafo.existeArista(origen, v) && grafo.existeArista(v, destino)) {
                puente.agregar(v); // si es una vertice puente agregamosla al conjunto puente
            }
            vertices.sacar(v);
            if (!vertices.conjuntoVacio()) {
                v = vertices.elegir();
            }
        }

        return puente;
    }
}
