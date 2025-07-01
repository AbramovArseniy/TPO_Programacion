package implementacion;

import imple.ColaPrioridad;
import imple.DiccionarioSimple;
import tda.ColaPrioridadTDA;
import tda.ColaTDA;
import tda.ConjuntoTDA;
import tda.DiccionarioSimpleTDA;

// Implementación de un diccionario simple utilizando una cola de prioridad.
// Las claves se usan como prioridades en la cola.
public class DiccionarioSimpleColas implements DiccionarioSimpleTDA {

    private ColaPrioridadTDA cola;
    private int cant;

    // Inicializa el diccionario y la cola
    @Override
    public void inicializarDiccionario() {
        this.cant = 0;
        this.cola = new ColaPrioridad();
        this.cola.inicializarCola();
    }

    // Agrega una nueva clave con su valor.
    // Si la clave ya existe, se modifica su valor; si no, se agrega un nuevo par.
    @Override
    public void agregar(int clave, int valor) {
        int res = modificar_elemento(clave, valor); // Intenta modificar si ya existe
        if (res == -1){
            // Si no existe, se agrega el nuevo par clave-valor
            cola.acolarPrioridad(valor, clave);
            cant++;
        }
    }

    // Método auxiliar recursivo para modificar el valor asociado a una clave existente
    private int modificar_elemento(int clave, int nuevo_valor) {
        int res = 1;

        if (cola.colaVacia()) {
            return -1; // Si está vacía, no se encontró la clave
        }

        int valor = cola.primero();         // Obtiene el valor en la cabeza
        int prioridad = cola.prioridad();   // Obtiene la clave (prioridad)
        cola.desacolar();                   // Saca el elemento de la cola

        if (prioridad == clave) {
            // Si coincide con la clave buscada, modifica el valor
            cola.acolarPrioridad(nuevo_valor, prioridad);
            return 1;
        } else {
            // Si no coincide, sigue buscando recursivamente
            res = modificar_elemento(clave, nuevo_valor);
            // Después de la recursión, vuelve a insertar el elemento actual
            cola.acolarPrioridad(valor, prioridad);
        }

        return res;
    }

    // Elimina una clave del diccionario
    @Override
    public void eliminar(int clave) {
        int valor = cola.primero();        // Obtiene el valor actual
        int prioridad = cola.prioridad();  // Obtiene la clave actual
        cola.desacolar();                  // Saca el elemento de la cola

        if (prioridad == clave) {
            // Si coincide, simplemente no lo reinsertamos
            cant--;
        } else {
            // Si no coincide, continúa la eliminación recursiva
            eliminar(clave);
            // Luego se reinserta el elemento original
            cola.acolarPrioridad(valor, prioridad);
        }
    }

    // Devuelve el valor asociado a una clave
    @Override
    public int recuperar(int clave) {
        return recuperarRecursivo(clave); // Llama a la función recursiva
    }

    // Método pendiente: debería devolver un conjunto con todas las claves
    @Override
    public ConjuntoTDA claves() {
        return null; // No implementado todavía
    }

    // Función recursiva para recuperar el valor asociado a una clave
    private int recuperarRecursivo(int clave) {
        if (cola.colaVacia()) {
            return -1; // Si no se encontró la clave
        }

        int valor = cola.primero();        // Valor actual
        int prioridad = cola.prioridad();  // Clave actual
        cola.desacolar();                  // Se elimina temporalmente

        int resultado;

        if (prioridad == clave) {
            // Si coincide la clave, se guarda el resultado
            resultado = valor;
        } else {
            // Si no coincide, sigue buscando
            resultado = recuperarRecursivo(clave);
        }

        // Se reinserta el elemento original para mantener la cola intacta
        cola.acolarPrioridad(valor, prioridad);
        return resultado;
    }
}
