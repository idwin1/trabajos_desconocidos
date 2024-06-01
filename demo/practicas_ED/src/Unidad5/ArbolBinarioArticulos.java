package Unidad5;

public class ArbolBinarioArticulos {

    private NodoArticuloArbolBin raiz;

    public ArbolBinarioArticulos(){
        raiz = null;
    }

    public NodoArticuloArbolBin getRaiz() {
        return raiz;
    }

    public boolean estaVacio() {
        if ( raiz == null )
            return true;
        else
            return false;
    }

    public void insertarNodo ( NodoArticuloArbolBin n) {
        if( estaVacio() ) //si el arbol esta vacio, crea la raiz con este nodo nuevo
            raiz = n;
        else
            insertar(raiz, n); //si ya tiene nodos, busca dónde insertarlo usando un método auxiliar
    }

    public void insertar (NodoArticuloArbolBin raiz, NodoArticuloArbolBin n) {
        if ( n.getDescripcion().compareToIgnoreCase(raiz.getDescripcion() ) < 0) { // si el nuevo es menor a la raiz se va a la izquierda
            if ( raiz.getIzquierdo() == null)
                raiz.setIzquierdo(n); // en esta posición inserta un nuevo nodo
            else    // cuando ya tiene hijo izquierdo ese nodo, y no lo puede colgar
                insertar (raiz.getIzquierdo(), n); //se manda llamar a sí mismo para buscar lugar libre
        }
        else { // cuando el nuevo es >=se va a la derecha
            if (raiz.getDerecho() == null)
                raiz.setDerecho (n); // en esta posición inserta un nuevo nodo
            else
                insertar (raiz.getDerecho(), n); //se manda llamar a sí mismo para buscar espacio libre
        }

    }

    public String preorden (NodoArticuloArbolBin nodo) {
        if (nodo == null) // caso base o primitiva PARA LA EJECUCIÓN DEL MÉTODO
            return "";
        return nodo.toString() +"\n"+ preorden(nodo.getIzquierdo()) +  preorden(nodo.getDerecho());
    }

    // devuelve un String con el recorrido INORDEN del árbol
    public String inorden (NodoArticuloArbolBin nodo) {
        if (nodo == null) // caso base o primitiva PARA LA EJECUCIÓN DEL MÉTODO
            return "";
        return inorden(nodo.getIzquierdo()) + nodo.toString() +"\n"+ inorden(nodo.getDerecho());
    }

    public float inventario(NodoArticuloArbolBin nodo){
        if (nodo == null) // caso base o primitiva PARA LA EJECUCIÓN DEL MÉTODO
            return 0f;
        return (nodo.getCantidad() * nodo.getPrecio()) + inventario(nodo.getIzquierdo()) +  inventario(nodo.getDerecho());
    }

    public void aumentarPrecio(NodoArticuloArbolBin nodo){
        if (nodo == null) // caso base o primitiva PARA LA EJECUCIÓN DEL MÉTODO
             return;
        nodo.setPrecio(nodo.getPrecio()*1.03f);
        inventario(nodo.getIzquierdo());
        inventario(nodo.getDerecho());
    }
}
