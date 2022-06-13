package ar.edu.uner.fcad.ed.ejercicio1;

public class ClienteTablaHash {
    public static void main(String[] args) {
        TablaHash tabla = new TablaHash(String.class, 40);
        tabla.put("perro", "perro");
        tabla.put("arbol", "arbol");
        tabla.put("sombrero", "sombrero");
        tabla.put("naranja", "naranja");
        tabla.put("cactus", "cactus");
        tabla.put("teclado", "teclado");
        tabla.put("actu", "actu");
        tabla.put("CaCtUs", "CaCtUs");
        tabla.put("cACTus", "cACTus");
        tabla.put("hello", "hello");
        tabla.put("world", "world");
        tabla.put("tomate", "tomate");
        tabla.put("azul", "azul");
        tabla.put("facebook", "facebook");
        tabla.put("habitacion", "habitacion");
        tabla.put("ligadura", "ligadura");
        tabla.put("esgrima", "esgrima");
        tabla.put("cepillo", "cepillo");
        tabla.put("sable", "sable");
        tabla.put("florete", "florete");
        tabla.put("mascara", "mascara");
        tabla.put("espada", "espada");
        tabla.put("puntuacion", "puntuacion");
        tabla.put("peon", "peon");
        tabla.put("fundacion", "fundacion");
        
        
        System.out.println("Tabla: "+tabla.toString());
        System.out.println("El tamanio de la tabla es: "+tabla.size());
        
        tabla.remove("perro");
        tabla.remove("sombrero");
        System.out.println("Luego de eliminar la clave perro y sombrero: "+tabla.toString());
        System.out.println("Tiene que devolver cactus(1 redireccion)= "+tabla.get("cactus"));
        System.out.println("Tiene que devolver puntuacion(1 redireccion)= "+tabla.get("puntuacion"));
        System.out.println("Tiene que devolver peon(2 redirecciones)= "+tabla.get("peon"));
        System.out.println("Tiene que devolver hello(1 redireccion)= "+tabla.get("hello"));
        System.out.println("Tiene que devolver world(2 redirecciones)= "+tabla.get("world"));
        tabla.makeEmpty();
        System.out.println("Vaciamos la tabla: "+tabla.toString());
    }
    
}
