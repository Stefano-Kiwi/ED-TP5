
package ar.edu.uner.fcad.ed.ejercicio5;

import ar.edu.uner.fcad.ed.arbolesabbyavl.NodoABB;
import ar.edu.uner.fcad.ed.edlineales.ListaEnlazadaNoOrdenada;
import ar.edu.uner.fcad.ed.edlineales.iteradores.Iterador;


public class IteradorPosOrdenInverso<T extends Comparable<T>> implements Iterador<T>  {
    private final Iterador <T> iterador;
    
    public IteradorPosOrdenInverso(NodoABB<T> raiz){
        this.iterador = generarRecorrido(raiz).iterador();
    }

    private ListaEnlazadaNoOrdenada<T> generarRecorrido(NodoABB<T> raiz) {
        ListaEnlazadaNoOrdenada<T> resultado = new ListaEnlazadaNoOrdenada();

        resultado.addAll(agregarSubArbol(raiz));

        return resultado;
    }

    private ListaEnlazadaNoOrdenada<T> agregarSubArbol(NodoABB<T> nodoActual){
        ListaEnlazadaNoOrdenada<T> resultado = new ListaEnlazadaNoOrdenada();

        if(nodoActual.tieneHijoDerecho()){
            resultado.addAll(agregarSubArbol(nodoActual.getHijoDerecho()));
        }
        
        if(nodoActual.tieneHijoIzquierdo()){
            resultado.addAll(agregarSubArbol(nodoActual.getHijoIzquierdo()));
        }
        
        resultado.addToRear(nodoActual.getValor());

        return resultado;
    }

    @Override
    public boolean existeSiguiente() {
        return iterador.existeSiguiente();
    }

    @Override
    public T siguiente() {
        return iterador.siguiente();
    }

    
}
