package Unidad4;

public class NodoArticulo {

    private String descripcion;
    private int cantidad;
    private float precio;
    private NodoArticulo enlace;

    public NodoArticulo ( ) {
        descripcion = "";
        cantidad = 0;
        precio = 0.0f;
        enlace = null;
    }

    public NodoArticulo (String s,int i, float f) {
        descripcion = s;
        cantidad = i;
        precio = f;
        enlace = null;
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

    public NodoArticulo getEnlace() {
        return enlace;
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

    public void setEnlace(NodoArticulo enlace) {
        this.enlace = enlace;
    }

    public String toString(){
        return descripcion + "\n" + cantidad + "\n" + precio + "\n";
    }
}
