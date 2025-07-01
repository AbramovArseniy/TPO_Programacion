package implementacion;

import imple.DiccionarioSimple;
import interfaz.DiccionarioSimpleModTDA;
import imple.Conjunto;
import tda.ConjuntoTDA;

// Implementación de un diccionario que además cuenta cuántas veces se modificó cada clave
public class DiccionarioSimpleMod implements DiccionarioSimpleModTDA {

    private Elemento[] elementos;
    private int cant;

    // Inicializa el diccionario vacío
    @Override
    public void inicializarDiccionario() {
        this.cant = 0;
        this.elementos = new Elemento[100];
    }

    // Agrega una clave con su valor. Si ya existe, actualiza el valor y aumenta el contador de modificaciones.
    // Tiempo de ejecucion: O(n)
    @Override
    public void agregar(int clave, int valor) {
        int pos = this.clave2Indice(clave);

        if (pos == -1) {
            // Si la clave no existe, se agrega al final
            this.elementos[this.cant] = new Elemento();
            this.elementos[this.cant].clave = clave;
            this.elementos[this.cant].valor = valor;

            ++this.cant;
        } else {
            // Si ya existe, actualiza el valor y incrementa la modificación
            this.elementos[pos].valor = valor;
            this.elementos[pos].mod++;
        }
    }

    // Elimina una clave si existe, reemplazándola por el último elemento
    // Tiempo de ejecucion: O(n)
    @Override
    public void eliminar(int clave) {
        int pos = this.clave2Indice(clave);

        if (pos != -1) {
            // Reemplaza con el último elemento para no dejar huecos
            this.elementos[pos] = this.elementos[this.cant - 1];
            --this.cant;
        }
    }

    // Devuelve el valor asociado a una clave
    // Tiempo de ejecucion: O(n)
    @Override
    public int recuperar(int clave) {
        int pos = this.clave2Indice(clave);
        return this.elementos[pos].valor;
    }

    // Devuelve cuántas veces se modificó el valor asociado a una clave
    // Tiempo de ejecucion: O(n)
    @Override
    public int recuperarMod(int clave) {
        int pos = this.clave2Indice(clave);
        return this.elementos[pos].mod;
    }

    // Devuelve el conjunto de claves actualmente almacenadas
    // Tiempo de ejecucion: O(n)
    @Override
    public ConjuntoTDA claves() {
        ConjuntoTDA conj = new Conjunto();
        conj.inicializarConjunto();

        for (int i = 0; i < this.cant; ++i) {
            conj.agregar(this.elementos[i].clave);
        }

        return conj;
    }

    // Función auxiliar: busca el índice del arreglo donde está la clave dada
    // Devuelve -1 si la clave no existe
    // Tiempo de ejecucion: O(n)
    private int clave2Indice(int clave) {
        int i;

        for (i = this.cant - 1; i >= 0 && this.elementos[i].clave != clave; --i) {
        }

        return i;
    }

    // Clase interna que representa cada entrada del diccionario
    private class Elemento {
        int clave;     // clave asociada
        int valor;     // valor asociado
        int mod = 0;   // cantidad de modificaciones hechas al valor

        private Elemento() {
        }
    }
}
