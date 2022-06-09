package ar.edu.uner.fcad.ed.ejercicio1;

public class ClienteTablaHash {
    public static void main(String[] args) {
        TablaHash tabla = new TablaHash(Integer.class, 40);
        tabla.put(100, 40);
        tabla.put(78, 40);
    }
    
}
