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

        ListaEnlazadaNoOrdenada<T> internos = new ListaEnlazadaNoOrdenada(); //asi estaba
        ListaEnlazadaNoOrdenada<NodoABB<T>> aux = new ListaEnlazadaNoOrdenada();
        T valorActual = null;

        aux.addToRear(raiz);
        internos.addToRear(aux.first().getValor());

        while (!aux.isEmpty()) {

            if (aux.first().tieneHijoIzquierdo()) {
                aux.addToRear(aux.first().getHijoIzquierdo());
                internos.addToRear(aux.first().getHijoIzquierdo().getValor());
            }
            if (aux.first().tieneHijoDerecho()) {
                aux.addToRear(aux.first().getHijoDerecho());
                internos.addToRear(aux.first().getHijoDerecho().getValor());
            }
            aux.removeFirst();
        }
        valorActual = min();
        
        while (!internos.isEmpty()) { 
            if (valor.compareTo(internos.first()) > 1 && valorActual.compareTo(internos.first()) < 1) {
                valorActual = internos.first();
            }
            internos.removeFirst();
        }
        return valorActual;
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