package EXAMEN_EDgar;

public class NodoABMateria {
    private NodoABMateria izquierdo; //apuntador al hijo izquierdo
    private String nombre;            // nodo con UN dato String
    private int creditos;
    private NodoABMateria derecho;   //apuntador al hijo derecho

    public NodoABMateria ( String d,int c) {
        nombre = d;
        creditos = c;
        izquierdo = derecho = null;
    }

    public NodoABMateria getIzquierdo() {
        return izquierdo;
    }

    public String getDescripcion() {
        return nombre;
    }

    public int getCantidad() {
        return creditos;
    }


    public NodoABMateria getDerecho() {
        return derecho;
    }

    public void setIzquierdo(NodoABMateria izquierdo) {
        this.izquierdo = izquierdo;
    }

    public void setDescripcion(String descripcion) {
        this.nombre = descripcion;
    }

    public void setCantidad(int cantidad) {
        this.creditos = cantidad;
    }

    public void setDerecho(NodoABMateria derecho) {
        this.derecho = derecho;
    }

    public String toString() {
        return "Descripcion: " + nombre + "\n" +
                "Cantidad: " + creditos +"\n";
    }
}



