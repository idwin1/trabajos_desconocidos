package Unidad2;
public class Articulo {
    private String descripcion;
    private int cantidad;
    private float precio;

    public Articulo(String descripcion, int cantidad, float precio) {
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.precio = precio;
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

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String toString(){
        String s="";
        s = "Descripcion: " + descripcion + "\n" +
            "Cantidad: " + cantidad + "\n" +
            "Precio: " + precio + "\n";
        return s;
    }
}
