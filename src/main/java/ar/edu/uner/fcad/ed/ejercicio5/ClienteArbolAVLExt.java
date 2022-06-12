package ar.edu.uner.fcad.ed.ejercicio5;

import ar.edu.uner.fcad.ed.edlineales.iteradores.Iterador;

public class ClienteArbolAVLExt {
    
    
    public static void main(String[] args) {
        ArbolAVLExt<Integer> arbol = new ArbolAVLExt<>();
        arbol.add(8);
        arbol.add(2);
        arbol.add(3);
        arbol.add(4);
        arbol.add(5);
        arbol.add(6);
        arbol.add(7);
        arbol.toString();
        
        Iterador<Integer> iterador = arbol.iteradorPreOrdenInverso();
          while (iterador.existeSiguiente()) {
        System.out.println(arbol.iteradorPreOrdenInverso().toString());   
            }
    }
}
