
package ar.edu.uner.fcad.ed.ejercicio5;

import ar.edu.uner.fcad.ed.arbolesabbyavl.NodoABB;
import ar.edu.uner.fcad.ed.edlineales.ListaEnlazadaNoOrdenada;
import ar.edu.uner.fcad.ed.edlineales.iteradores.Iterador;


public class IteradorInorderInverso<T extends Comparable<T>> implements Iterador<T> {
     private final Iterador<T> iterador;

    public IteradorInorderInverso(NodoABB<T> raiz){
        this.iterador = generarRecorrido(raiz).iterador();
    }

    private ListaEnlazadaNoOrdenada<T> generarRecorrido(NodoABB<T> raiz) {
        ListaEnlazadaNoOrdenada<T> resultado = new ListaEnlazadaNoOrdenada();

        resultado.addAll(agregarNodos(raiz));

        return resultado;
    }

    private ListaEnlazadaNoOrdenada<T> agregarNodos(NodoABB<T> nodo){
        ListaEnlazadaNoOrdenada<T> resultado = new ListaEnlazadaNoOrdenada();

        if(nodo.tieneHijoDerecho()){
            resultado.addAll(agregarNodos(nodo.getHijoDerecho()));
        }
        
        resultado.addToRear(nodo.getValor());

        if(nodo.tieneHijoIzquierdo()){
            resultado.addAll(agregarNodos(nodo.getHijoIzquierdo()));
        }

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
