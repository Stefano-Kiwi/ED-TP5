package ar.edu.uner.fcad.ed.ejercicio5;

import ar.edu.uner.fcad.ed.edlineales.iteradores.Iterador;

public class ClienteArbolAVLExt {
     
    public static void main(String[] args) {
        ArbolAVLExt<Integer> arbol = new ArbolAVLExt<>();
        arbol.add(2);
        arbol.add(3);
        arbol.add(4);
        arbol.add(5);
        arbol.add(6);
        arbol.add(7);
        arbol.add(8);
        System.out.println("IteradorPreOrdenInverso :");
        Iterador<Integer> iterador = arbol.iteradorPreOrdenInverso();
        while (iterador.existeSiguiente()) {
            System.out.print(iterador.siguiente().toString() + ", ");
        }
        System.out.println("");
        System.out.println("IteradorInOrdenInverso :");
        Iterador<Integer> iterador2 = arbol.iteradorInordenInverso();
        while (iterador2.existeSiguiente()) {
            System.out.print(iterador2.siguiente().toString() + ", ");
        }
        System.out.println("");
        System.out.println("IteradorPosOrdenInverso :");
        Iterador<Integer> iterador3 = arbol.iteradorPosordenInverso();
        while (iterador3.existeSiguiente()) {
            System.out.print(iterador3.siguiente().toString() + ", ");
        }
        
 
    }
}
