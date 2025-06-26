package implementacion;

import interfaz.ConjuntoEspecialTDA;

public class ConjuntoEspecial implements ConjuntoEspecialTDA {

    private int[] a;
    private int cant;


    public void inicializarConjunto() {
        a = new int[100];
        cant = 0;
    }

    @Override
    public ConjuntoEspecialTDA.Respuesta agregar(int valor) {
        ConjuntoEspecialTDA.Respuesta resp = new ConjuntoEspecialTDA.Respuesta();
        resp.rta = valor;
        resp.error = true;
        if (!pertenece(valor) && cant != 100) {
            a[cant] = valor;
            ++cant;
            resp.error = false;
        }
        return resp;
    }

    @Override
    public ConjuntoEspecialTDA.Respuesta sacar(int valor) {
        ConjuntoEspecialTDA.Respuesta resp = new ConjuntoEspecialTDA.Respuesta();
        resp.rta = valor;
        resp.error = true;
        int i;
        for (i = 0; i < cant && a[i] != valor; ++i) {
        }

        if (i < cant) {
            a[i] = a[cant - 1];
            --cant;
            resp.error = false;
        }
        return resp;
    }

    @Override
    public ConjuntoEspecialTDA.Respuesta elegir() {
        ConjuntoEspecialTDA.Respuesta resp = new ConjuntoEspecialTDA.Respuesta();
        resp.error = true;
        if (conjuntoVacio()) {
            return resp;
        }

        int max = cant - 1;
        int min = 0;
        int pos = (int) (Math.random() * (double) (max - min + 1) + (double) min);
        resp.rta = a[pos];
        resp.error = false;
        return resp;
    }

    @Override
    public boolean pertenece(int valor) {
        int i;
        for (i = 0; i < cant && a[i] != valor; ++i) {
        }

        return i < cant;
    }

    @Override
    public boolean conjuntoVacio() {
        return cant == 0;
    }
}
