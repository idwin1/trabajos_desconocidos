package Unidad4;

public class ListaCircularPartidos {

    private NodoPartido inicio;
    private NodoPartido fin;
    private int numNodos;

    public ListaCircularPartidos () {
        inicio = fin = null;
        numNodos = 0;
    }

    public NodoPartido getInicio() {
        return inicio;
    }

    public NodoPartido getFin() {
        return fin;
    }

    public int getNumNodos() {
        return numNodos;
    }

    // set...
    public void setInicio (NodoPartido n) {
        inicio = n;
    }

    public void setFin (NodoPartido n) {
        fin = n;
    }

    public void setNumNodos (int nn) {
        numNodos = nn;
    }

    public boolean listaVacia () {
        if (inicio == null)
            return true;
        else
            return false;
    }

    //inserta nodo al inicio
    public void insertaInicio (NodoPartido nuevo) {
        if (listaVacia () ) {
            inicio = fin = nuevo;
            nuevo.setEnlace (nuevo);
        }
        else {
            nuevo.setEnlace (inicio);
            inicio = nuevo;
            fin.setEnlace (nuevo);
        }
        numNodos++;
    }

    public void insertarFinal(NodoPartido nuevo){
        if (listaVacia () ) {
            inicio = fin = nuevo;
            nuevo.setEnlace (nuevo);
        }
        else {
            fin.setEnlace (nuevo);
            fin = nuevo;
            fin.setEnlace (inicio);
        }
        numNodos++;
    }

    public void insertar(NodoPartido nuevo){
        boolean s = true;
        if(listaVacia())
            insertaInicio(nuevo);
        else {
            NodoPartido r = inicio;
            do {
                if(nuevo.getPartido().equalsIgnoreCase(r.getPartido())){
                    r.setVotos(r.getVotos()+nuevo.getVotos());
                    s=false;
                }
                r=r.getEnlace();
            } while (r != inicio);
            if(s==true){
                insertarFinal(nuevo);
            }
        }
    }

    public NodoPartido eliminarPrimero(){
        NodoPartido r = inicio;
        fin.setEnlace(r.getEnlace());
        inicio=r.getEnlace();
        numNodos--;
        if(numNodos==0)
            inicio=fin=null;
        return r;
    }

    public String toString() {
        String s = "";
        NodoPartido r = inicio;
        if (listaVacia () )
            s += "Lista vacia";
        else {
            do {
                s += r.toString() + "\n";
                r = r.getEnlace();
            } while (r != inicio);
        }
        return s;
    }

}
