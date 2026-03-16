/**
 * Clase que encapsula la gestión de la colección de empleados.
 * <p>
 * Mantiene internamente un array de {@link Empleado} llamado {@code lista} y
 * ofrece operaciones para dar de alta empleados, aumentar salarios y mostrar el listado.
 * </p>
 */
public class Empleados {

    /**
     * Array que contiene los empleados dados de alta. Se expone públicamente
     * para compatibilidad con el ejercicio, aunque se recomienda acceso mediante
     * los métodos de la clase.
     */
    public Empleado[] lista;
    /**
     * Número de empleados actualmente almacenados en {@link #lista}.
     */
    private int count;

    /**
     * Construye un gestor de empleados con la capacidad por defecto.
     */
    public Empleados() {
        this(Constantes.DEFAULT_CAPACIDAD);
    }

    /**
     * Construye un gestor de empleados con una capacidad inicial.
     *
     * @param capacidadInicial capacidad inicial del array; si es <= 0 se usa la constante por defecto
     */
    public Empleados(int capacidadInicial) {
        if (capacidadInicial <= 0) capacidadInicial = Constantes.DEFAULT_CAPACIDAD;
        this.lista = new Empleado[capacidadInicial];
        this.count = 0;
    }

    /**
     * Añade un empleado a la lista. Si el array está lleno se expande automáticamente.
     *
     * @param empleado empleado a añadir; si es {@code null} no realiza ninguna acción
     */
    public void darAlta(Empleado empleado) {
        if (empleado == null) return;
        if (count >= lista.length) {
            expandir();
        }
        lista[count++] = empleado;
    }

    private void expandir() {
        Empleado[] nueva = new Empleado[lista.length * 2];
        System.arraycopy(lista, 0, nueva, 0, lista.length);
        lista = nueva;
    }

    /**
     * Aumenta el salario de todos los empleados activos en la lista en el porcentaje
     * indicado (por ejemplo 10 aumenta un 10%).
     *
     * @param porcentaje porcentaje a aplicar (valor en %)
     */
    public void aumentarSalario(double porcentaje) {
        for (int i = 0; i < count; i++) {
            Empleado e = lista[i];
            if (e == null) continue;
            double nuevoSalario = e.getSalario() * (1 + porcentaje / 100);
            e.setSalario(nuevoSalario);
        }
    }

    /**
     * Imprime por consola el listado de empleados actualmente dados de alta.
     */
    public void mostrarListado() {
        for (int i = 0; i < count; i++) {
            System.out.println(lista[i]);
        }
    }

    // acceso opcional al array completo
    /**
     * Devuelve el array interno que contiene los empleados. Atención: el array
     * puede contener posiciones nulas si no está completamente lleno.
     *
     * @return array interno de empleados
     */
    public Empleado[] getLista() {
        return lista;
    }
}
