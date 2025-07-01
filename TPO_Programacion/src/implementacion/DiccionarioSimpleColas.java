package implementacion;

import imple.ColaPrioridad;
import imple.Conjunto;
import tda.ColaPrioridadTDA;
import tda.ConjuntoTDA;
import tda.DiccionarioSimpleTDA;

public class DiccionarioSimpleColas implements DiccionarioSimpleTDA {
    private ColaPrioridadTDA cola;
    private int cant;

    @Override
    public void inicializarDiccionario() {
        // Inicializamos el diccionario
        this.cant = 0;
        this.cola = new ColaPrioridad();
        this.cola.inicializarCola();
    }

    @Override
    public void agregar(int clave, int valor) {
//        Agregamos o modificamos el valor
//        func recursiva
        int res = modificar_elemento(clave, valor);
        if (res == -1) {
            // si no tenemos clave en el dicc
            cola.acolarPrioridad(valor, clave);
            cant++;
        }
    }

    private int modificar_elemento(int clave, int nuevo_valor) {

        int res;
        if (cola.colaVacia()) {
            // Si recorremos todas las llaves y no encontramos coincidencias, devolvemos -1.
            res = -1;
            return res;
        }
        int valor = cola.primero();
        int prioridad = cola.prioridad();
        cola.desacolar();

        if (prioridad == clave) {
            // Si encontramos la llave que necesitamos, modificamos su valor
            cola.acolarPrioridad(nuevo_valor, prioridad);
            return 1;
        } else {
            // Si no, lo devolvemos como estaba
            res = modificar_elemento(clave, nuevo_valor);
            cola.acolarPrioridad(valor, prioridad);

        }
        return res;
    }


    @Override
    public void eliminar(int clave) {
        //Eliminamos el clave y valor
        int valor = cola.primero();
        int prioridad = cola.prioridad();
        cola.desacolar();

        if (prioridad == clave) {
            cant--;
        } else {
            //Si no es la llave, la devolvemos y seguimos buscando
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
        ConjuntoTDA c = new Conjunto();
        c.inicializarConjunto();

        recibirClaves(c);
        return c;
    }

    private void recibirClaves(ConjuntoTDA claves) {
        if (!cola.colaVacia()) {
            int valor = cola.primero();
            int prioridad = cola.prioridad();
            cola.desacolar();
            claves.agregar(prioridad);
            recibirClaves(claves);
            cola.acolarPrioridad(valor, prioridad);
        }
    }

    private int recuperarRecursivo(int clave) {
        if (cola.colaVacia()) {
            // si no encontramos devolvemos -1
            return -1;
        }

        int valor = cola.primero();
        int prioridad = cola.prioridad();
        cola.desacolar();

        int resultado;

        if (prioridad == clave) {
            // si encontramos devolvemos el valor
            resultado = valor;
        } else {
            //si no, seguimos buscando
            resultado = recuperarRecursivo(clave);
        }
        cola.acolarPrioridad(valor, prioridad);
        return resultado;
    }
}