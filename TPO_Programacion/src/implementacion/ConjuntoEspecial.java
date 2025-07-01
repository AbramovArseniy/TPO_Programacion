package implementacion;

import interfaz.ConjuntoEspecialTDA;

public class ConjuntoEspecial implements ConjuntoEspecialTDA {

    private int[] a;
    private int cant;

    // Inicializa el conjunto: crea el arreglo y lo deja vacío
    public void inicializarConjunto() {
        a = new int[100];
        cant = 0;
    }

    // Agrega un valor al conjunto si no está presente y hay espacio
    // Devuelve una estructura Respuesta con el valor y si hubo error
    // Tiempo de ejecucion: O(n)
    @Override
    public ConjuntoEspecialTDA.Respuesta agregar(int valor) {
        ConjuntoEspecialTDA.Respuesta resp = new ConjuntoEspecialTDA.Respuesta();
        resp.rta = valor;
        resp.error = true; // asumimos error por defecto

        // Verifica que el valor no pertenezca y haya espacio disponible
        if (!pertenece(valor) && cant != 100) {
            a[cant] = valor; // lo agrega al final
            ++cant;
            resp.error = false; // operación exitosa
        }
        return resp;
    }

    // Elimina un valor del conjunto si existe
    // Reemplaza el valor por el último y reduce la cantidad
    // Tiempo de ejecucion: O(n)
    @Override
    public ConjuntoEspecialTDA.Respuesta sacar(int valor) {
        ConjuntoEspecialTDA.Respuesta resp = new ConjuntoEspecialTDA.Respuesta();
        resp.rta = valor;
        resp.error = true; // asumimos error por defecto

        int i;
        for (i = 0; i < cant && a[i] != valor; ++i) {
            // búsqueda del valor en el arreglo
        }

        if (i < cant) {
            a[i] = a[cant - 1]; // lo reemplaza por el último elemento
            --cant;
            resp.error = false; // operación exitosa
        }
        return resp;
    }

    // Devuelve un elemento aleatorio del conjunto
    // Tiempo de ejecucion: O(1)
    @Override
    public ConjuntoEspecialTDA.Respuesta elegir() {
        ConjuntoEspecialTDA.Respuesta resp = new ConjuntoEspecialTDA.Respuesta();
        resp.error = true;

        // Si el conjunto está vacío, devuelve error
        if (conjuntoVacio()) {
            return resp;
        }

        // Genera una posición aleatoria entre 0 y cant-1
        int max = cant - 1;
        int min = 0;
        int pos = (int) (Math.random() * (double) (max - min + 1) + (double) min);

        resp.rta = a[pos]; // asigna el valor elegido
        resp.error = false; // operación exitosa
        return resp;
    }

    // Verifica si un valor pertenece al conjunto
    // Tiempo de ejecucion: O(n)
    @Override
    public boolean pertenece(int valor) {
        int i;
        for (i = 0; i < cant && a[i] != valor; ++i) {
            // búsqueda secuencial
        }

        return i < cant; // si lo encontró, retorna true
    }

    // Verifica si el conjunto está vacío
    // Tiempo de ejecucion: O(1)
    @Override
    public boolean conjuntoVacio() {
        return cant == 0;
    }
}
