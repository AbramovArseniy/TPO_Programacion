package implementacion;

import imple.Pila;
import interfaz.MultiPilaTDA;
import tda.PilaTDA;

public class MultiPila implements MultiPilaTDA {
    private int[] arr;
    private int indice;

    @Override
    public void apilar(PilaTDA valores) {
        PilaTDA copia = new Pila();
        copia.inicializarPila();
        while (!valores.pilaVacia()) {
            int v = valores.tope();
            valores.desapilar();
            copia.apilar(v);
        }

        while (!copia.pilaVacia()) {
            int v = copia.tope();
            arr[indice] = v;
            ++indice;
            valores.apilar(v);
            copia.desapilar();
        }
    }

    @Override
    public void desapilar(PilaTDA valores) {
        PilaTDA copia = (PilaTDA) valores;
        copia.inicializarPila();
        int i = 0;
        while (!valores.pilaVacia()) {
            i++;
            int v = valores.tope();
            valores.desapilar();
            copia.apilar(v);
            if (v != arr[indice - i - 1]) {
                while (!copia.pilaVacia()) {
                    v = copia.tope();
                    valores.apilar(v);
                    copia.desapilar();
                }
                return;
            }
        }
        indice -= i;
        while (!copia.pilaVacia()) {
            int v = copia.tope();
            valores.apilar(v);
            copia.desapilar();
        }
    }

    @Override
    public PilaTDA tope(int cantidad) {
        PilaTDA res = new Pila();
        res.inicializarPila();
        int i = indice - cantidad - 1;
        if (i < 0) {
            i = 0;
        }
        while (i < indice) {
            res.apilar(arr[i]);
            i++;
        }
        return res;
    }

    /**
     * Inicializa la pila
     */
    @Override
    public void inicializarPila() {
        this.arr = new int[100];
        this.indice = 0;
    }

    /**
     * Devuelve un booleano que indica si la pila está vacía
     */
    @Override
    public boolean pilaVacia() {
        return this.indice == 0;
    }
}
