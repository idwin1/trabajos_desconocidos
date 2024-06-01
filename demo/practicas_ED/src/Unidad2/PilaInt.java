package Unidad2;
public class PilaInt {
    // atributos
    private int p[ ]; // vector para guardar datos, únicamente se declara
    private int tope; // apuntador al último elemento de la pila

    // 1er. constructor, genera una pila de 5 casillas
    public PilaInt ( ) {
        p = new int [5]; // se crea el vector (pila)
        tope = -1; // pila está vacía, por lo que se inicializa el tope
    }

    // 2do. constructor, genera una pila de tamaño n
    public PilaInt (int n) {
        p=new int [n]; // se crea el vector (pila) de n casillas
        tope = -1; // igual, se inicializa el tope
    }

    // get...
    public int [ ] getP ( ) {
        return p;
    }

    public int getTope ( ) {
        return tope;
    }

    // set
    public void setP ( int [ ] nuevoP ) {
        p = nuevoP;
    }

    public void setTope ( int nuevoTope ) {
        tope = nuevoTope;
    }

    // inserta un elemento en la pila
    public void insertar ( int nuevo ) {
        if ( !estaLlena() ) { // checa que la pila NO esté llena
            tope++; // mueve el tope a la sig. casilla libre
            p[tope] = nuevo; // guarda el dato en el tope de la pila
        }
    }

    // elimina un elemento de la pila
    public int eliminar ( ) {
        int borrado = -99999; // variable que devuelve el dato borrado
        if ( !estaVacia() ) {
            borrado = p[tope]; // se saca el dato del tope
            p[tope] = 0; // se borra físicamente la casilla
            tope--; // se decrementa el tope
        }
        return borrado; // se devuelve el valor eliminado
    }

    // método que checa si la pila está vacía
    public boolean estaVacia ( ) {
        if( tope == -1) // checa si el tope no señala a ninguna casilla
            return true;
        else
            return false;
    }

    // método que checa si la pila está llena
    public boolean estaLlena ( ) {
        if ( tope == p.length - 1) //checa si el tope está en la última casilla
            return true;
        else
            return false;
    }

    // devuelve el elemento del tope, pero NO LO ELIMINA
    public int datoEnTope ( ) {
        if ( !estaVacia() )
            return p[tope];
        else
            return -99999;
    }

    // devuelve el número de elementos que hay actualmente en la pila
    public int numElementos ( ) {
        return tope+1;
    }

    public String toString( ) {
        String s="Elementos en la pila:\n";
        int i;
        for( i = tope; i >= 0; i--){
            s += p[i]+"\n";
        }
        s+="Fin de la pila";
        return s;
    }
}// fin de la clase PilaInt
