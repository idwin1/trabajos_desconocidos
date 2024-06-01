package Unidad5;

public class NodoArbolBin {
    // Clase instanciable para manejar NODOS de un árbol binario ordenado
    private NodoArbolBin izquierdo; //apuntador al hijo izquierdo
    private String dato;            // nodo con UN dato String
    private NodoArbolBin derecho;   //apuntador al hijo derecho

    // Constructor: Crea nodos hoja
    public NodoArbolBin ( String d ) {
        dato = d;
        izquierdo = derecho = null;
    }

    // 3 get...
    public String getDato ( ) {
        return dato;
    }

    public NodoArbolBin getIzquierdo ( ) {
        return izquierdo;
    }

    public NodoArbolBin getDerecho ( ) {
        return derecho;
    }

    // 3 set..
    public void setDato (String nuevoD) {
        dato = nuevoD;
    }

    public void setIzquierdo ( NodoArbolBin nuevoIzq ) {
        izquierdo = nuevoIzq;
    }

    public void setDerecho ( NodoArbolBin nuevoDer ) {
        derecho = nuevoDer;
    }

    // toString
    public String toString() {
        return dato;
    }
}
