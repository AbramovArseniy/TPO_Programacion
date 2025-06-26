package implementacion;

import interfaz.ConjuntoMamushkaTDA;

public class ConjuntoMamushka implements ConjuntoMamushkaTDA {
    private int[] a;
    private int cant;

    @Override
    public void inicializar() {
        a = new int[100];
        cant = 0;
    }

    @Override
    public void guardar(int dato) {
        a[cant] = dato;
        ++cant;
    }

    @Override
    public void sacar(int dato) {
        int i;
        for (i = 0; i < cant && a[i] != dato; ++i) {
        }

        if (i < cant) {
            a[i] = a[cant - 1];
            --cant;
        }
    }

    @Override
    public int elegir() {
        int max = cant - 1;
        int min = 0;
        int pos = (int) (Math.random() * (double) (max - min + 1) + (double) min);
        return a[pos];
    }

    @Override
    public int perteneceCant(int dato) {
        int i;
        int cantDato = 0;
        for (i = 0; i < cant; ++i) {
            if (a[i] == dato) {
                cantDato++;
            }
        }

        return cantDato;
    }

    @Override
    public boolean estaVacio() {
        return cant == 0;
    }
}
