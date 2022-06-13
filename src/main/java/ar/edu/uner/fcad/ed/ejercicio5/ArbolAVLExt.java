
package ar.edu.uner.fcad.ed.ejercicio5;

import ar.edu.uner.fcad.ed.arbolesabbyavl.ArbolABBIteratorPreorden;
import ar.edu.uner.fcad.ed.arbolesabbyavl.ArbolAVL;
import ar.edu.uner.fcad.ed.arbolesabbyavl.NodoABB;
import ar.edu.uner.fcad.ed.edlineales.ListaEnlazadaNoOrdenada;
import ar.edu.uner.fcad.ed.edlineales.iteradores.Iterador;

public class ArbolAVLExt <T extends Comparable<T>> extends ArbolAVL <T> implements ArbolAVLExtInterfaz<T>  {

    public boolean isEmpty() {
        return raiz == null;
    } 

        /**
* Define un iterador en preorden inverso para el árbol AVL.
* Para el ejemplo el iterador en preorden inverso devuelve: A, C, B.
* @return
*/
    @Override
    public Iterador<T> iteradorPreOrdenInverso() {
      if (isEmpty()) {
            throw new IllegalStateException("Arbol vacío");
        }
        Iterador<T> resultado = new IteradorPreInverAVL(this.raiz);
        return resultado;
    }
    
    
    /**
   * Define un iterador en inorden inverso para el árbol AVL.
* Para el ejemplo el iterador en inorden inverso devolverá: C, A, B.
* @return
*/ 
    @Override
    public Iterador<T> iteradorInordenInverso() {
      if (isEmpty()) {
            throw new IllegalStateException("Arbol vacío");
        }
        Iterador<T> resultado = new IteradorInorderInverso(this.raiz);
        return resultado;
    }
/**
* Define un iterador en posorden inverso para el árbol AVL.
* Para el ejemplo el iterador en posorden inverso devuelve: C, B, A.
* @return
*/
    @Override
    public Iterador<T> iteradorPosordenInverso() {
        if (isEmpty()) {
            throw new IllegalStateException("Arbol vacío");
        }
        Iterador<T> resultado = new IteradorPosOrdenInverso(this.raiz);
        return resultado;
    }

    

}
