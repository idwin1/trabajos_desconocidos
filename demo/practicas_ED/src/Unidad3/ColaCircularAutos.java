package Unidad3;

public class ColaCircularAutos {
    private Automovil cc[ ];        // Este es el vector donde se guardan los datos
    private int frente;          // Apuntador al frente , YA NO SE NECESITA EL APUNTADOR DEL FINAL
    private int contador;

    public ColaCircularAutos(){
        cc = new Automovil[5];
        frente = 0;
        contador = 0;
    }

    public ColaCircularAutos(int x){
        cc = new Automovil[x];
        frente = 0;
        contador = 0;
    }

    public Automovil[] getCc () {
        return cc;
    }

    public int getFrente () {
        return frente;
    }

    public int getContador () {
        return contador;
    }

    public boolean estaVacia ()  {
        if  (contador == 0)
            return true;
        else
            return false;
    }

    public boolean estaLlena()  {
        if  ( contador == cc.length)
            return true;
        else
            return false;
    }

    public Automovil elementoEnFrente () {
        if ( estaVacia() )
            return null;
        else
            return cc [frente];
    }

    public Automovil elementoEnFin () {
        if ( estaVacia() )
            return null;
        else
            return cc [(frente - 1 + contador) % cc.length];
    }

    public int numElementos ( ) {
        return contador;
    }

    public void insertar (Automovil x) {
        if (!estaLlena()) {                // solo podemos insertar si NO esta llena
            cc[(frente + contador) % cc.length] = x;    // se calcula la posicion donde se insertara x
            contador++;                       // obviamente se incrementa el contador, ya que se inserto un elemento
        }
    }

    public Automovil eliminar ( ) {
        Automovil eliminado=null;
        if ( ! estaVacia () ) {                  // solo podemos eliminar si NO esta vacia
            eliminado = cc[frente];               // Dato que se elimina y es el que se devuelve
            cc[frente] = null;                    // se anula el dato de la casilla
            frente = (frente + 1 ) % cc.length;   // se calcula la nueva posicion del frente
            contador--;                           // obviamente se decrementa el contador, ya que se elimino un elemento
        }
        return eliminado;
    }

    public String toString() {
        String s="";
        int i= 1, indice = frente;
        while (i <= contador) {     // ciclo para desplegar la cantidad de elemtos que hay en la cola circular
            s+= cc[indice] + "\n";   // se concatena cada elemento de acuerdo al indice en una variable string
            if (indice == cc.length - 1)  // si ya esta el indice en la ultima casilla, tiene que regresar a la posicion 0
                indice = 0;
            else                         // si no esta en la ultima casilla, simplemente se incrementa el indice a la sig. casilla
                indice++;
            i++;	       // se incrementa i que controla la cantidad de iteraciones de acuerdo al contador
        }
        return s;
    }
}
