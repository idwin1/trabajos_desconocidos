package Unidad3;

/**
 *  Este programa sirve para manejar una estructura de datos de tipo
 *
 *  COLA CIRCULAR
 *
 *  para manejar un vector de datos de tipo String
 *
 **/

public class ColaCircularString {
    // ATRIBUTOS
    private String cc[ ];        // Este es el vector donde se guardan los datos
    private int frente;          // Apuntador al frente , YA NO SE NECESITA EL APUNTADOR DEL FINAL
    private int contador;        // Ahora el control se maneja a traves de un CONTADOR de datos ingresados

    // 1er Constructor crea una cola CIRCULAR de 5 casillas
    public ColaCircularString () {
        cc=new String[5];
        frente = 0;
        contador = 0;
    }

    // 2do Constructor crea una cola CIRCULAR con el numero de elementos que se recibe como parametro
    public ColaCircularString (int num) {
        cc=new String [num];
        frente = 0;
        contador = 0;
    }

    // getters
    public String[ ] getCc () {
        return cc;
    }

    public int getFrente () {
        return frente;
    }

    public int getContador () {
        return contador;
    }

    // setters
    public void setCc (String[] nuevoCc) {
        cc = nuevoCc;
    }

    public void setFrente (int nuevoFrente) {
        frente = nuevoFrente;
    }

    public void setContador (int nuevoCont) {
        contador = nuevoCont;
    }

    //Ahora cuando esta VACIA lo sabemos simplemente porque el CONTADOR de ingresados vale CERO
    public boolean estaVacia ()  {
        if  (contador == 0)
            return true;
        else
            return false;
    }

    // Y para checar si esta LLENA tambien lo podemos saber gracias al CONTADOR de ingresados
    // que se compara contra la cantidad de casillas que tiene el vector
    public boolean estaLlena()  {
        if  ( contador == cc.length)
            return true;
        else
            return false;
    }

    // Devuelve el elemento del frente de la cola CIRCULAR. NO LO ELIMINA
    public String elementoEnFrente () {
        if ( estaVacia() )
            return null;
        else
            return cc [frente];
    }

    // Devuelve el elemento del final de la cola CIRCULAR. NO LO ELIMINA
    public String elementoEnFin () {
        if ( estaVacia() )
            return null;
        else
            return cc [(frente - 1 + contador) % cc.length];
    }

    // Devuelve la cantidad de elementos que hay actualmente en la cola CIRCULAR
    public int numElementos ( ) {
        return contador;
    }

    // Metodo para insertar un dato x
    public void insertar (String x) {
        if ( ! estaLlena () ) {                // solo podemos insertar si NO esta llena
            cc [(frente + contador) % cc.length] = x;    // se calcula la posicion donde se insertara x
            contador++;                       // obviamente se incrementa el contador, ya que se inserto un elemento
        }
    }

    // Metodo para eliminar un dato, devuelve el elemento eliminado o null si no hay datos para borrar
    public String eliminar ( ) {
        String eliminado=null;
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

}   // fin de la clase ColaCircularString