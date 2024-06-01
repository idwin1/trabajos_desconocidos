package EXAMEN_EDgar;

import Unidad5.NodoCiudades;

public class ArbolBinMaterias {
    private NodoABMateria raiz;

    public ArbolBinMaterias(){
        raiz = null;
    }

    public NodoABMateria getRaiz() {
        return raiz;
    }

    public boolean estaVacio() {
        if ( raiz == null )
            return true;
        else
            return false;
    }

    public void insertarNodo ( NodoABMateria n) {
        if( estaVacio() ) //si el arbol esta vacio, crea la raiz con este nodo nuevo
            raiz = n;
        else
            insertar(raiz, n); //si ya tiene nodos, busca dónde insertarlo usando un método auxiliar
    }

    public void insertar (NodoABMateria raiz, NodoABMateria n) {
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

    public String preorden (NodoABMateria nodo) {
        if (nodo == null) // caso base o primitiva PARA LA EJECUCIÓN DEL MÉTODO
            return "";
        return nodo.toString() +"\n"+ preorden(nodo.getIzquierdo()) +  preorden(nodo.getDerecho());
    }

    // devuelve un String con el recorrido INORDEN del árbol
    public String inorden (NodoABMateria nodo) {
        if (nodo == null) // caso base o primitiva PARA LA EJECUCIÓN DEL MÉTODO
            return "";
        return inorden(nodo.getIzquierdo()) + nodo.toString() +"\n"+ inorden(nodo.getDerecho());
    }

    public String BuscarMaterias(NodoCiudades nodo, String nombre){
        if(nodo==null){
            return "";
        }
        if(nodo.getNombre().equalsIgnoreCase(nombre)){
            return nodo.toString();
        }else
            return BuscarMaterias(nodo.getIzquierdo(),nombre) + BuscarMaterias(nodo.getDerecho(),nombre);
    }
}
