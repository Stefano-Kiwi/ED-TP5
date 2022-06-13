/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ar.edu.uner.fcad.ed.ejercicio5;

import ar.edu.uner.fcad.ed.arbolesabbyavl.NodoABB;
import ar.edu.uner.fcad.ed.arbolesabbyavl.NodoAVL;
import ar.edu.uner.fcad.ed.edlineales.ListaEnlazadaNoOrdenada;
import ar.edu.uner.fcad.ed.edlineales.iteradores.Iterador;

/**
 *
 * @author David Zarcó
 * @param <T>
 */
public class IteradorPreInverAVL<T extends Comparable<T>> implements Iterador<T> {
    private final Iterador <T> iterador;
    
    public IteradorPreInverAVL(NodoABB<T> raiz){
        this.iterador = generarRecorrido(raiz).iterador();
    }

    private ListaEnlazadaNoOrdenada<T> generarRecorrido(NodoABB<T> raiz) {
        ListaEnlazadaNoOrdenada<T> resultado = new ListaEnlazadaNoOrdenada();

        resultado.addAll(agregarSubArbol(raiz));

        return resultado;
    }

    private ListaEnlazadaNoOrdenada<T> agregarSubArbol(NodoABB<T> nodoActual){
        ListaEnlazadaNoOrdenada<T> resultado = new ListaEnlazadaNoOrdenada();

        resultado.addToRear(nodoActual.getValor());

        if(nodoActual.tieneHijoDerecho()){
            resultado.addAll(agregarSubArbol(nodoActual.getHijoDerecho()));
        }
        
        if(nodoActual.tieneHijoIzquierdo()){
            resultado.addAll(agregarSubArbol(nodoActual.getHijoIzquierdo()));
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


