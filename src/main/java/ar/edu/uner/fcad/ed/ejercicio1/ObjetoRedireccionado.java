package ar.edu.uner.fcad.ed.ejercicio1;

/**
 *
 * @author stefa
 */
public class ObjetoRedireccionado <T>{
    private T elemento = null;
    private int cantRed = 0;

    public ObjetoRedireccionado(T elemento, int cant) {
        this.elemento = elemento;
        this.cantRed = cant;
    }

    public T getElemento() {
        return elemento;
    }

    public void setElemento(T elemento) {
        this.elemento = elemento;
    }

    public int getCantRed() {
        return cantRed;
    }

    public void setCantRed(int cantRed) {
        this.cantRed = cantRed;
    }
    public void sumarCant(){
        this.cantRed++;
    }
    
    @Override
    public String toString() {
        return "ObjetoRedireccionado{" + "elemento=" + elemento + ", cantRed=" + cantRed + '}';
    }
    
   

    
    
}
