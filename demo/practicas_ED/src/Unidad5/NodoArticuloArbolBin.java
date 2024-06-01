package Unidad5;

public class NodoArticuloArbolBin {

    private NodoArticuloArbolBin izquierdo; //apuntador al hijo izquierdo
    private String descripcion;            // nodo con UN dato String
    private int cantidad;
    private float precio;
    private NodoArticuloArbolBin derecho;   //apuntador al hijo derecho

    public NodoArticuloArbolBin ( String d,int c,float p) {
        descripcion = d;
        cantidad = c;
        precio = p;
        izquierdo = derecho = null;
    }

    public NodoArticuloArbolBin getIzquierdo() {
        return izquierdo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public float getPrecio() {
        return precio;
    }

    public NodoArticuloArbolBin getDerecho() {
        return derecho;
    }

    public void setIzquierdo(NodoArticuloArbolBin izquierdo) {
        this.izquierdo = izquierdo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public void setDerecho(NodoArticuloArbolBin derecho) {
        this.derecho = derecho;
    }

    public String toString() {
        return "Descripcion: " + descripcion + "\n" +
                "Cantidad: " + cantidad +"\n" +
                "Precio: " + precio + "\n";
    }
}
