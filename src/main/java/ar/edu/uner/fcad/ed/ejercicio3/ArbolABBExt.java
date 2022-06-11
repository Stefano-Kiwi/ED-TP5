package ar.edu.uner.fcad.ed.ejercicio3;
import ar.edu.uner.fcad.ed.arbolesabbyavl.ArbolABB;
import ar.edu.uner.fcad.ed.arbolesabbyavl.NodoABB;
import ar.edu.uner.fcad.ed.arbolesbinariosyheaps.NodoArbolBinario;
import ar.edu.uner.fcad.ed.edlineales.ListaEnlazadaNoOrdenada;

/**
 *
 * @author David Zarcó
 * @param <T>
 */
public class ArbolABBExt<T extends Comparable<T>> extends ArbolABB<T> implements ArbolABBExtInterfaz<T> {

    @Override
    public T min() {

        NodoABB<T> nodoActual = raiz;

        if (!raiz.tieneHijoIzquierdo()) {
            return raiz.getValor();
        } else {
            while (nodoActual.tieneHijoIzquierdo() != false) {
                nodoActual = nodoActual.getHijoIzquierdo();
            }
        }
        return nodoActual.getValor();
    }

    @Override
    public T max() {
        
        NodoABB<T> nodoActual = raiz;
        

        if (!raiz.tieneHijoDerecho()) {
            return raiz.getValor();
        } else {
            while (nodoActual.tieneHijoDerecho() != false) {
                nodoActual = nodoActual.getHijoDerecho();
            }
        }
        return nodoActual.getValor();
    }

    @Override
    public T floor(T valor) {

        NodoABB<T> nodoActual = raiz;
        NodoABB<T> prox = raiz;

        while (nodoActual.tieneHijoIzquierdo() || nodoActual.tieneHijoDerecho()) {

            if  (valor.compareTo(nodoActual.getValor()) > 0) {
                nodoActual = nodoActual.getHijoDerecho();
            } else {
                nodoActual = nodoActual.getHijoIzquierdo();
            }
            
            
            if (nodoActual.getValor().compareTo(valor) > 0) {
                return nodoActual.getValor();
            }

        }
        return nodoActual.getValor();
    }

    @Override
    public T ceiling(T valor) {

        NodoABB<T> nodoActual = raiz;

        while (nodoActual.tieneHijoIzquierdo() || nodoActual.tieneHijoDerecho()) {

            if  (valor.compareTo(nodoActual.getValor()) < 0) {
                nodoActual = nodoActual.getHijoIzquierdo();
            } else {
                nodoActual = nodoActual.getHijoDerecho();
            }
            if (nodoActual.getValor().compareTo(valor) > 0) {
                return nodoActual.getValor();
            }

        }
        return nodoActual.getValor();
    }

    @Override
    public boolean esPerfecto() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}