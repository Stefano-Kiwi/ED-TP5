package ar.edu.uner.fcad.ed.ejercicio1;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;


public class TablaHash<K,T> implements TablaHashInterfaz<K, T>{
    
    protected Class clase;
    protected T [] tabla = null;     //  debe ir de tipo T
    protected int cantElem = 0;
    protected List<ObjetoRedireccionado> tablaRedir = new ArrayList();       // Guarda los objetos que tuvieron que pasar por una prueba y la cant de pruebas
    protected float factorDeCarga = 0;
    
    public TablaHash(Class clase,int tam) {
        this.clase = clase;
        tabla = (T[]) Array.newInstance(clase, tam);
    }
    
    
    @Override
    public void put(K clave, T valor){
        if(this.isFull()){
            System.out.println("Esta llena la tabla");
        }else{
            int claveHash = clave.hashCode()%tabla.length;
        claveHash = Math.abs(claveHash);
         //   System.out.println("EL CODIGO HASH DE: "+clave+" ES "+claveHash);
        claveHash = pruebaLineal(claveHash,clave,0);
        //claveHash = dobleHash(claveHash,clave,0);
        tabla[claveHash] = valor;
        cantElem++;
        }
       
        this.actualizarFactorCarga();
    }
    
    public int pruebaLineal(int clave, K claveOriginal,int iteraciones){
        int claveNueva = clave;
        if(iteraciones == 0){   // Esto si es la primera vez que entra a la tabla
            int j = 0;
        while((tabla[claveNueva]!=null)){
            j++;
            claveNueva = claveNueva+1;
            claveNueva = claveNueva % tabla.length;
        }
        if(j>0){ // Si por lo menos tuve que redireccionarlo 1 vez
            
                tablaRedir.add(new ObjetoRedireccionado(claveOriginal, j)); 
            
            
        }
        
        return claveNueva;
        
        
        }else{  // Esto si estoy buscando el valor
            for(int i=0;i<iteraciones;i++){
                claveNueva = claveNueva+1;
                claveNueva = claveNueva % tabla.length;
            }
        }
        return claveNueva;
    }
    
    public int dobleHash(int clave, K claveOriginal, int iteraciones){
        int claveNueva = clave;
        if(iteraciones == 0){   // Esto si es la primera vez que entra a la tabla
            int j = 0;
        while((tabla[claveNueva]!=null)){
            j++;
            claveNueva = System.identityHashCode(claveNueva)%tabla.length;
            
            System.out.println("El hashcode luego de doble hash es: "+claveNueva);
            if(j>5){
                break;                                                                      // ACA DEBE DEJAR UNA EXCEPCION, YA QUE PASARON LOS 5 INTENTOS
            }
        }
        if(j>0){ // Si por lo menos tuve que redireccionarlo 1 vez
            
                tablaRedir.add(new ObjetoRedireccionado(claveOriginal, j)); 
            
            
        }
        
        return claveNueva;
        
        
        }else{  // Esto si estoy buscando el valor
            for(int i=0;i<iteraciones;i++){
                claveNueva = System.identityHashCode(claveNueva)%tabla.length;
            }
        }
        return claveNueva;
    }

    @Override
    public void remove(K clave) {
        int claveHash = clave.hashCode() % tabla.length;
        claveHash = Math.abs(claveHash);
        boolean encontrado = false;
        int cantRedir = 0;
        for (int i = 0; i < tablaRedir.size(); i++) {
            if (tablaRedir.get(i).getElemento() == clave) {
                encontrado = true;
                cantRedir = tablaRedir.get(i).getCantRed();
                tablaRedir.remove(i);
                break;
            }
        }
        if(encontrado == true){ // Si pasó alguna redireccion
            claveHash = pruebaLineal(claveHash, clave, cantRedir);
        }
        
        tabla[claveHash] = null;
        cantElem = cantElem -1;
        
        this.actualizarFactorCarga();
    }

    @Override
    public T get(K clave) {
    int claveHash = clave.hashCode()%tabla.length;
    claveHash = Math.abs(claveHash);
    if(tabla[claveHash]==null){
        return null;
    }
    boolean encontrado = false;
    int direEncontrado = 0;
    for(int i=0;i<tablaRedir.size();i++){
        if(tablaRedir.get(i).getElemento()==clave){
            encontrado = true;
            direEncontrado = i;
        }
    }
    if(encontrado==true && tablaRedir.get(direEncontrado).getCantRed()>0){
        claveHash = pruebaLineal(claveHash, clave, tablaRedir.get(direEncontrado).getCantRed());
        //claveHash = dobleHash(claveHash, clave, tablaRedir.get(direEncontrado).getCantRed());
    }
        return tabla[claveHash];
    }

    @Override
    public boolean contains(K clave) {
        return false;
    }

    @Override
    public void makeEmpty() {
         for(int i= 0;i<tabla.length;i++){
            if(tabla[i]!=null){
               tabla[i]=null;
            }
        }
         
         this.actualizarFactorCarga();
    }

    @Override
    public int size() {
        return this.cantElem;
    }

    @Override
    public boolean isFull() {
        return false;
    }
    public void actualizarFactorCarga(){
        if(tabla.length>0){
            factorDeCarga = this.cantElem/tabla.length;
        }else{
            factorDeCarga = 0;
        }
    }
    
    public void duplicarTamanio(int valor){
        //Crear nuevoArray con length = array.length + 1
        T [] nuevoArray = (T[]) Array.newInstance(this.clase, tabla.length*2);
        //Copiar los valores de array en otro array nuevoArray
        for (int i = 0; i < tabla.length; i++) {
            nuevoArray[i] = tabla[i];
        }
        //Poner el nuevo valor en nuevoArray 
        //nuevoArray[nuevoArray.length - 1] = valor;        
        //Sobreescribir el valor de array
        this.tabla = nuevoArray;
    }
    

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TablaHash{");
        sb.append("tabla="+"\n");
        for(int i= 0;i<tabla.length;i++){
            if(tabla[i]!=null){
                sb.append(i+"= ");
            sb.append(tabla[i]+"\n");
            }
            
        }
        sb.append('}');
        return sb.toString();
    }
    
    
}
