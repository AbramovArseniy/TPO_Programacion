package implementacion;

import imple.DiccionarioSimple;
import interfaz.DiccionarioSimpleModTDA;
import imple.Conjunto;
import tda.ConjuntoTDA;

public class DiccionarioSimpleMod implements DiccionarioSimpleModTDA {
    private Elemento[] elementos;
    private int cant;


    @Override
    public void inicializarDiccionario() {
        this.cant = 0;
        this.elementos = new Elemento[100];
    }

    @Override
    public void agregar(int clave, int valor) {
        int pos = this.clave2Indice(clave);
        if (pos == -1) {
            this.elementos[this.cant] = new Elemento();
            this.elementos[this.cant].clave = clave;
            this.elementos[this.cant].valor = valor;

            ++this.cant;
        } else {
            this.elementos[pos].valor = valor;
            this.elementos[pos].mod++;
        }
    }

    @Override
    public void eliminar(int clave) {
        int pos = this.clave2Indice(clave);
        if (pos != -1) {
            this.elementos[pos] = this.elementos[this.cant - 1];
            --this.cant;
        }
    }

    @Override
    public int recuperar(int clave) {
        int pos = this.clave2Indice(clave);
        return this.elementos[pos].valor;
    }

    @Override
    public int recuperarMod(int clave) {
        int pos = this.clave2Indice(clave);
        return this.elementos[pos].mod;
    }

    @Override
    public ConjuntoTDA claves() {
        ConjuntoTDA conj = new Conjunto();
        conj.inicializarConjunto();

        for (int i = 0; i < this.cant; ++i) {
            conj.agregar(this.elementos[i].clave);
        }

        return conj;
    }

    private int clave2Indice(int clave) {
        int i;

        for (i = this.cant - 1; i >= 0 && this.elementos[i].clave != clave; --i) {
        }

        return i;
    }

    private class Elemento {
        int clave;
        int valor;
        int mod = 0;

        private Elemento() {
        }
    }
}
