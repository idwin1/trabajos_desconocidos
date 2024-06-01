package Unidad4;

/** CLASE INSTANCIABLE PARA MANEJAR UNA LISTA ENLAZADA LINEAL Ó SIMPLE
 * La lista que vamos a estar manejando tiene 2 atributos:
 * - el apuntador al primer nodo (inicio) del mismo tipo de la clase anterior Nodo
 * - un contador de nodos (numNodos) que SIEMPRE va a ser ENTERO */

public class ListaLineal {
    // Atributos
    private Nodo inicio;
    private int numNodos;

    // Constructor para crear una lista vacía
    public ListaLineal () {
        inicio = null;
        numNodos=0;
    }

    // get...
    public Nodo getInicio ( ) {
        return inicio;
    }

    public int getNumNodos ( ) {
        return numNodos;
    }

    // Método que devuelve true si la lista está vacía
    public boolean listaVacia() {
        if (inicio == null)
            return true;
        else
            return false;
    }

    // Método que inserta un nodo al inicio de la lista
    public void insertaInicio (Nodo nuevo) {
        nuevo.setEnlace(inicio);
        inicio = nuevo;
        numNodos++;
    }

    public void recorreLista() {
        Nodo r = inicio;
        System.out.println("Empieza la lista:\n");
        while (r != null) {
            System.out.println ( r.toString() + "\n");
            r = r.getEnlace();
        }
        System.out.println("Fin de la lista"); }

    // FALTAN MUCHOS MÁS MÉTODOS

    public void insertarFinal(Nodo x) {
        Nodo r = inicio;
        if (listaVacia())
            inicio = x;
        else{
            while (r.getEnlace() != null) {
                r = r.getEnlace();
            }
        r.setEnlace(x);
        }
        numNodos++;
    }
    public String toString(){
        Nodo r = inicio;
        String s="Datos de la lista \n";
        for(;;){
            if(r==null){
                break;
            }
            s += r.toString() + "\n ";
            r = r.getEnlace();
        }
        return s;
    }
}