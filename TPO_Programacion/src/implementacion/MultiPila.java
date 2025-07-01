package implementacion;

import imple.Pila;
import interfaz.MultiPilaTDA;
import tda.PilaTDA;

public class MultiPila implements MultiPilaTDA {
    private int[] arr;
    private int indice;

    // Apila una pila completa dentro de la MultiPila
    // Tiempo de ejecucion: O(m)   m - cantidad de valores en el argumento
    @Override
    public void apilar(PilaTDA valores) {
        // Creamos una copia para no perder los valores originales
        PilaTDA copia = new Pila();
        copia.inicializarPila();

        // Vaciamos la pila original en orden inverso hacia la copia
        while (!valores.pilaVacia()) {
            int v = valores.tope();
            valores.desapilar();
            copia.apilar(v);
        }

        // Restauramos la pila original y almacenamos sus valores en el arreglo interno
        while (!copia.pilaVacia()) {
            int v = copia.tope();
            arr[indice] = v;
            ++indice;
            valores.apilar(v);
            copia.desapilar();
        }
    }

    // Desapila una pila completa si coincide con los últimos elementos de la MultiPila
    // Tiempo de ejecucion: O(m)   m - cantidad de valores en el argumento
    @Override
    public void desapilar(PilaTDA valores) {
        PilaTDA copia = new Pila();
        copia.inicializarPila();
        int i = 0;

        // Recorremos la pila original y comparamos con el arreglo desde el final
        while (!valores.pilaVacia()) {
            i++;
            int v = valores.tope();
            valores.desapilar();
            copia.apilar(v);

            // Si hay una diferencia, se cancela la operación y se restaura la pila original
            if (v != arr[indice - i]) {
                while (!copia.pilaVacia()) {
                    v = copia.tope();
                    valores.apilar(v);
                    copia.desapilar();
                }
                return;
            }
        }

        // Si todos los elementos coinciden, se eliminan del arreglo
        indice -= i;

        // Restauramos la pila original
        while (!copia.pilaVacia()) {
            int v = copia.tope();
            valores.apilar(v);
            copia.desapilar();
        }
    }

    // Devuelve una pila con los últimos `cantidad` elementos apilados en la MultiPila
    // Tiempo de ejecucion: O(cantidad)
    @Override
    public PilaTDA tope(int cantidad) {
        PilaTDA res = new Pila();
        res.inicializarPila();

        // Calculamos desde dónde copiar los elementos
        int i = indice - cantidad;
        if (i < 0) {
            i = 0; // Evitamos índice negativo
        }

        // Apilamos los últimos `cantidad` elementos en la nueva pila
        while (i < indice) {
            res.apilar(arr[i]);
            i++;
        }

        return res;
    }

    @Override
    public void inicializarPila() {
        this.arr = new int[100];
        this.indice = 0;
    }

    // Verifica si la MultiPila está vacía
    // Tiempo de ejecucion: O(1)
    @Override
    public boolean pilaVacia() {
        return this.indice == 0;
    }
}
