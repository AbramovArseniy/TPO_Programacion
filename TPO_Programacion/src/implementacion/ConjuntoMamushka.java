package implementacion;

import interfaz.ConjuntoMamushkaTDA;

public class ConjuntoMamushka implements ConjuntoMamushkaTDA {

    private int[] a;
    private int cant;

    // Inicializa el conjunto: crea el arreglo y pone cantidad en 0
    @Override
    public void inicializar() {
        a = new int[100]; // capacidad máxima fija de 100
        cant = 0;
    }

    // Guarda un dato en el conjunto sin verificar duplicados
    // Tiempo de ejecucion: O(1)
    @Override
    public void guardar(int dato) {
        a[cant] = dato; // lo agrega al final
        ++cant;         // incrementa la cantidad
    }

    // Elimina una instancia del dato si existe
    // Reemplaza el elemento con el último para mantener continuidad
    // Tiempo de ejecucion: O(n)
    @Override
    public void sacar(int dato) {
        int i;
        // Busca la posición del dato
        for (i = 0; i < cant && a[i] != dato; ++i) {
        }

        if (i < cant) {
            // Reemplaza el dato por el último elemento
            a[i] = a[cant - 1];
            --cant; // reduce la cantidad total
        }
    }

    // Devuelve un dato al azar del conjunto
    // Tiempo de ejecucion: O(1)
    @Override
    public int elegir() {
        int max = cant - 1;
        int min = 0;
        int pos = (int) (Math.random() * (double) (max - min + 1) + (double) min);
        return a[pos]; // retorna el elemento en la posición aleatoria
    }

    // Cuenta cuántas veces aparece el dato en el conjunto
    // Tiempo de ejecucion: O(n)
    @Override
    public int perteneceCant(int dato) {
        int i;
        int cantDato = 0;
        // Recorre todo el arreglo y cuenta coincidencias
        for (i = 0; i < cant; ++i) {
            if (a[i] == dato) {
                cantDato++;
            }
        }

        return cantDato; // cantidad de veces que aparece el dato
    }

    // Verifica si el conjunto está vacío
    // Tiempo de ejecucion: O(1)
    @Override
    public boolean estaVacio() {
        return cant == 0;
    }
}
