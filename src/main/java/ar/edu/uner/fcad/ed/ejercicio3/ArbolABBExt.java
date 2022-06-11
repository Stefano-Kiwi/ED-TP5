package ar.edu.uner.fcad.ed.ejercicio3;
import ar.edu.uner.fcad.ed.arbolesabbyavl.ArbolABB;
import ar.edu.uner.fcad.ed.arbolesabbyavl.NodoABB;
import ar.edu.uner.fcad.ed.edlineales.ListaEnlazadaNoOrdenada;


public class ArbolABBExt<T extends Comparable<T>> extends ArbolABB<T> implements ArbolABBExtInterfaz<T> {

    @Override
    public T min() {

        NodoABB<T> nodoActual = raiz;

        if (!raiz.tieneHijoIzquierdo()) {
            return raiz.getValor();
        } else {
            while (nodoActual.tieneHijoIzquierdo() != false) {
                nodoActual = nodoActual.getHijoIzquierdo();
            }
        }
        return nodoActual.getValor();
    }

    @Override
    public T max() {

        NodoABB<T> nodoActual = raiz;

        if (!raiz.tieneHijoDerecho()) {
            return raiz.getValor();
        } else {
            while (nodoActual.tieneHijoDerecho() != false) {
                nodoActual = nodoActual.getHijoDerecho();
            }
        }
        return nodoActual.getValor();
    }

    @Override
    public T floor(T valor) {

        ListaEnlazadaNoOrdenada<T> internos = new ListaEnlazadaNoOrdenada(); //asi estaba
        ListaEnlazadaNoOrdenada<NodoABB<T>> aux = new ListaEnlazadaNoOrdenada();

        aux.addToRear(raiz);
        internos.addToRear(aux.first().getValor());

        while (!aux.isEmpty()) {

            if (aux.first().tieneHijoIzquierdo()) {
                aux.addToRear(aux.first().getHijoIzquierdo());
                internos.addToRear(aux.first().getHijoIzquierdo().getValor());
            }
            if (aux.first().tieneHijoDerecho()) {
                aux.addToRear(aux.first().getHijoDerecho());
                internos.addToRear(aux.first().getHijoDerecho().getValor());
            }
            aux.removeFirst();
        }

        T valorActual = min();

        while (!internos.isEmpty()) {
            if ((internos.first().compareTo(valor) < 0) && internos.first().compareTo(valorActual) > 0) {
                valorActual = internos.first();
            }
            internos.removeFirst();
        }
        return valorActual;
    }

    @Override
    public T ceiling(T valor) {

        ListaEnlazadaNoOrdenada<T> internos = new ListaEnlazadaNoOrdenada(); //asi estaba
        ListaEnlazadaNoOrdenada<NodoABB<T>> aux = new ListaEnlazadaNoOrdenada();

        aux.addToRear(raiz);
        internos.addToRear(aux.first().getValor());

        while (!aux.isEmpty()) {

            if (aux.first().tieneHijoIzquierdo()) {
                aux.addToRear(aux.first().getHijoIzquierdo());
                internos.addToRear(aux.first().getHijoIzquierdo().getValor());
            }
            if (aux.first().tieneHijoDerecho()) {
                aux.addToRear(aux.first().getHijoDerecho());
                internos.addToRear(aux.first().getHijoDerecho().getValor());
            }
            aux.removeFirst();
        }

        T valorActual = max();

        while (!internos.isEmpty()) {
            if ((internos.first().compareTo(valor) > 0) && internos.first().compareTo(valorActual) < 0) {
                valorActual = internos.first();
            }
            internos.removeFirst();
        }
        return valorActual;
    }

    @Override
    public boolean esPerfecto() {
        ListaEnlazadaNoOrdenada<NodoABB<T>> aux = new ListaEnlazadaNoOrdenada();

        aux.addToRear(raiz);
        boolean noHijos = false;
        while (!aux.isEmpty()) {
            if ((noHijos == true)) {
                if (aux.first().tieneHijoIzquierdo()) {
                    return false;
                }
                if (aux.first().tieneHijoDerecho()) {
                    return false;
                }
            }

            if (aux.first().tieneHijoIzquierdo() && aux.first().tieneHijoDerecho()) {
                aux.addToRear(aux.first().getHijoIzquierdo());
                aux.addToRear(aux.first().getHijoDerecho());
            }
            if (aux.first().tieneHijoIzquierdo() && !aux.first().tieneHijoDerecho()) {
                return false;
            }
            if (aux.first().tieneHijoDerecho() && !aux.first().tieneHijoIzquierdo()) {
                return false;
            }
            if (!(aux.first().tieneHijoIzquierdo() && aux.first().tieneHijoDerecho())) {
                noHijos = true;
            }
            aux.removeFirst();
        }

        return true;
    }

}
