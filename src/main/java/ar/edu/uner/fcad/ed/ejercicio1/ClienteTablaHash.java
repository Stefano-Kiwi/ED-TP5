package ar.edu.uner.fcad.ed.ejercicio1;

public class ClienteTablaHash {
    public static void main(String[] args) {
        TablaHash tabla = new TablaHash(String.class, 40);
        tabla.put("perro", "perro");
        tabla.put("arbol", "arbol");
        tabla.put("sombrero", "sombrero");
        tabla.put("naranja", "naranja");
        tabla.put("cactus", "cactus");
        
        System.out.println("Tabla: "+tabla.toString());
        System.out.println("El tamanio de la tabla es: "+tabla.size());
        System.out.println("Tiene que devolver cactus(1 redireccion)= "+tabla.get("cactus"));
        
        tabla.get("cactus");
        
        tabla.makeEmpty();
        System.out.println("Tabla: "+tabla.toString());
    }
    
}
