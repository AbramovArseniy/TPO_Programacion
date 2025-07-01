package uso;

import imple.Conjunto;
import imple.Grafo;
import tda.ConjuntoTDA;
import tda.GrafoTDA;

public class Ejercicio15 {
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

        int grado = gradoVertice(grafo, 2);
        System.out.println("Grado de 2: " + grado); // Esperado: 1 salida, 1 entrada → 0
    }

    public static int gradoVertice(GrafoTDA grafo, int v) {
        int entra = 0;
        int sale = 0;

        // recuperamos las vertices del grafo
        ConjuntoTDA vertices = grafo.vertices();
        int x = vertices.elegir();

        while (!vertices.conjuntoVacio()) {
            if (grafo.existeArista(x, v)) {
                entra++; // si hay una arista x -> v
            }
            if (grafo.existeArista(v, x)) {
                sale++;
            }
            vertices.sacar(x);
            if (!vertices.conjuntoVacio()) {
                x = vertices.elegir();
            }
        }

        return sale - entra;
    }
}
