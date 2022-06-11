package ar.edu.uner.fcad.ed.ejercicio3;
import ar.edu.uner.fcad.ed.arbolesabbyavl.ArbolABB;

/**
 *
 * @author David Zarcó
 */
public class ClienteArbolABBExt {
    
    public static void main(String[] args) {

        ArbolABBExt<Integer> tree = new ArbolABBExt<>();

        tree.add(10);
        tree.add(15);
        tree.add(20);
        tree.add(3);
        tree.add(6);
        tree.add(9);
        tree.add(12);
        tree.add(4);
        tree.add(13);
        tree.add(16);
        tree.add(2);
        tree.add(21);
        tree.add(31);
        tree.add(88);
        tree.add(26);

        System.out.println("Nodo con menor valor de clave: " + tree.min());
        System.out.println("Nodo con mayor valor de clave: " + tree.max());
        System.out.println("Valor menor al parametro 10: " + tree.floor(10));
        System.out.println("Valor mayor al parametro 13: " + tree.ceiling(13));
        System.out.println("Es perfecto?: " + tree.esPerfecto());
        tree.remove(9);
        tree.remove(4);
        tree.remove(13);
        tree.remove(21);
        tree.remove(16);
        tree.remove(31);
        tree.remove(26);
        tree.remove(88);
        System.out.println("Es perfecto luego de eliminar algunos nodos?: " + tree.esPerfecto());
    }
}
