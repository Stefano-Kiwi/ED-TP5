package ar.edu.uner.fcad.ed.ejercicio1;

import java.lang.reflect.Array;

public class TablaHash<K,T> implements TablaHashInterfaz<K, T>{
    
    protected T [] tabla = null;     //  debe ir de tipo T
    protected int cantElem = 0;
    
    public TablaHash(Class clase,int tam) {
        tabla = (T[]) Array.newInstance(clase, tam);
    }
    
    
    @Override
    public void put(K clave, T valor) {
        int claveHash = clave.hashCode()%tabla.length;
        System.out.println("El nuevo hashcode es: "+claveHash);
        
    }
    
    public int pruebaLineal(int clave){
        
        
        
        return 0;
    }
    
    @Override
    public void remove(K clave) {
        
        
    }

    @Override
    public T get(K clave) {

        return null;
    }

    @Override
    public boolean contains(K clave) {
        return false;
    }

    @Override
    public void makeEmpty() {
        
    }

    @Override
    public int size() {
        return this.cantElem;
    }

    @Override
    public boolean isFull() {
        return false;
    }
    
}
