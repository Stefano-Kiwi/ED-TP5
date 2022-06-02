package ar.edu.uner.fcad.ed.ejercicio3;

public interface ArbolABBExtInterfaz <T extends Comparable<T>>{
    /** Devuelve el valor del nodo con menor valor de clave. */
    public T min();
    /** Devuelve el valor del nodo con mayor valor de clave.*/
    public T max();
    /** Devuelve el mayor valor que no supera al parámetro. */
    public T floor(T valor);
    /** Devuelve el menor valor que supera al parámetro. */
    public T ceiling(T valor);
    /**
    * Indica si el Árbol es perfecto con todos los niveles ocupados por nodos.
    * Nota: todas las hojas tienen que tener la misma profundidad y ningún nodo
    * interno puede tener un solo hijo.
    */
    public boolean esPerfecto();
}
