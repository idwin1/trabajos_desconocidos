package Unidad5;

public class ArbolCiudades {

    private NodoCiudades raiz;

    public ArbolCiudades(){
        raiz = null;
    }

    public NodoCiudades getRaiz() {
        return raiz;
    }

    public void setRaiz(NodoCiudades raiz) {
        this.raiz = raiz;
    }

    public boolean estaVacio() {
        if ( raiz == null )
            return true;
        else
            return false;
    }

    public void insertarNodo ( NodoCiudades n) {
        if( estaVacio() ) //si el arbol esta vacio, crea la raiz con este nodo nuevo
            raiz = n;
        else
            insertar(raiz, n); //si ya tiene nodos, busca dónde insertarlo usando un método auxiliar
    }

    public void insertar (NodoCiudades raiz, NodoCiudades n) {
        if ( n.getNombre().compareToIgnoreCase(raiz.getNombre() ) < 0) { // si el nuevo es menor a la raiz se va a la izquierda
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

    public String preorden (NodoCiudades nodo) {
        if (nodo == null) // caso base o primitiva PARA LA EJECUCIÓN DEL MÉTODO
            return "";
        return nodo.toString() +"\n"+ preorden(nodo.getIzquierdo()) +  preorden(nodo.getDerecho());
    }

    public NodoCiudades eliminar(NodoCiudades nodo, String borrar) {

        if(nodo == null)  // Caso base para parar la llamada recursiva al método
            return nodo;

        if (borrar.compareToIgnoreCase(nodo.getNombre()) < 0) {   //busca el nodo a borrar a la izquierda
            nodo.setIzquierdo(eliminar(nodo.getIzquierdo(), borrar));
        } else
        if (borrar.compareToIgnoreCase(nodo.getNombre()) > 0) {  // o lo busca a la derecha
            nodo.setDerecho(eliminar(nodo.getDerecho(), borrar));
        } else {
            // Este es el nodo a borrar que coincide con el string recibido
            if (nodo.getIzquierdo() == null && nodo.getDerecho() == null) {
                // Es una HOJA sin hijos
                System.out.println("borrando: " + borrar);
                return null;
            } else if (nodo.getIzquierdo() == null) {
                // Solo tiene su hijo derecho
                System.out.println("borrando: " + borrar);
                return nodo.getDerecho();
            } else if (nodo.getDerecho() == null) {
                // Solo tiene su hijo izquierdo
                System.out.println("borrando: "+borrar);
                return nodo.getIzquierdo();
            } else {     // Es un nodo que TIENE SUS 2 HIJOS
                // Busca el nodo MENOR del subárbol DERECHO
                String desc = menorDesc(nodo.getDerecho());    // Utiliza metodos auxiliares para
                String pais = menorpais(nodo.getDerecho());
                nodo.setNombre(desc);                     // COPIA los datos de ese nodo SUCESOR que va a
                nodo.setPais(pais);                        // sustituir al nodo que sera eliminado
                nodo.setDerecho(eliminar(nodo.getDerecho(), desc));  // se actualiza el enlace al hijo derecho
                //System.out.println("borrando " + borrar);
            }
        }
        return nodo;
    }

    private String menorDesc (NodoCiudades nodo) {

        if(nodo.getIzquierdo() != null) {
            return menorDesc(nodo.getIzquierdo());
        }
        return nodo.getNombre();
    }

    private String menorpais (NodoCiudades nodo) {

        if(nodo.getIzquierdo() != null) {
            return menorpais(nodo.getIzquierdo());
        }
        return nodo.getNombre();
    }

    public boolean buscaArticulo (NodoCiudades nodo, String desc) {
        if (nodo == null)
            return false;
        if (nodo.getNombre().equalsIgnoreCase (desc))
            return true || buscaArticulo (nodo.getIzquierdo(), desc) || buscaArticulo (nodo.getDerecho(), desc);
        else
            return false || buscaArticulo (nodo.getIzquierdo(), desc) || buscaArticulo (nodo.getDerecho(), desc);

    }

    public String CiudadesFrancia(NodoCiudades nodo,String nombre){
        if(nodo==null){
            return "";
        }
        if(nodo.getPais().equalsIgnoreCase(nombre)){
            return nodo.getNombre()+"\n" + CiudadesFrancia(nodo.getIzquierdo(),nombre) + CiudadesFrancia(nodo.getDerecho(),nombre);
        }else
            return CiudadesFrancia(nodo.getIzquierdo(),nombre) + CiudadesFrancia(nodo.getDerecho(),nombre);
    }

    public String BuscarCiudad(NodoCiudades nodo,String nombre){
        if(nodo==null){
            return "";
        }
        if(nodo.getNombre().equalsIgnoreCase(nombre)){
            return nodo.toString();
        }else
            return BuscarCiudad(nodo.getIzquierdo(),nombre) + BuscarCiudad(nodo.getDerecho(),nombre);
    }

}
