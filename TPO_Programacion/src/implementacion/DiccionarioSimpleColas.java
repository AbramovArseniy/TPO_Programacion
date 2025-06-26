package implementacion;

import imple.ColaPrioridad;
import imple.DiccionarioSimple;
import tda.ColaPrioridadTDA;
import tda.ColaTDA;
import tda.ConjuntoTDA;
import tda.DiccionarioSimpleTDA;

public class DiccionarioSimpleColas implements DiccionarioSimpleTDA {
    private ColaPrioridadTDA cola;
    private int cant;

    @Override
    public void inicializarDiccionario() {
        this.cant = 0;
        this.cola = new ColaPrioridad();
        this.cola.inicializarCola();
    }

    @Override
    public void agregar(int clave, int valor) {
        int res = modificar_elemento(clave, valor);
        if (res == -1){
        cola.acolarPrioridad(valor, clave);
        cant++;
        }
    }

    private int modificar_elemento(int clave, int nuevo_valor) {
        int res = 1;
        if (cola.colaVacia()) {
            res = -1;
            return res;
        }
        int valor = cola.primero();
        int prioridad = cola.prioridad();
        cola.desacolar();

        if (prioridad == clave) {
            cola.acolarPrioridad(nuevo_valor, prioridad);
            return 1;
        } else {
            res = modificar_elemento(clave, nuevo_valor);
            cola.acolarPrioridad(valor, prioridad);

        }
        return res;
    }


    @Override
    public void eliminar(int clave) {

        int valor = cola.primero();
        int prioridad = cola.prioridad();
        cola.desacolar();

        if (prioridad == clave) {
            cant--;
        } else {
            eliminar(clave);
            cola.acolarPrioridad(valor, prioridad);
        }

    }

    @Override
    public int recuperar(int clave) {
        return recuperarRecursivo(clave);
    }

    @Override
    public ConjuntoTDA claves() {
        return null;
    }

    private int recuperarRecursivo(int clave) {
        if (cola.colaVacia()) {
            return -1;
        }

        int valor = cola.primero();
        int prioridad = cola.prioridad();
        cola.desacolar();

        int resultado;

        if (prioridad == clave) {
            resultado = valor;
        } else {
            resultado = recuperarRecursivo(clave); // ищем дальше
        }
        cola.acolarPrioridad(valor, prioridad); // возвращаем обратно
        return resultado;
    }
}
