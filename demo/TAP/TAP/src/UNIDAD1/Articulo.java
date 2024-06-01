package UNIDAD1;

public class Articulo {
    private String descripcion;
    private int cantidad;
    private float precio;
    private fecha fechaCaducidad;

    public Articulo(String descripcion, int cantidad, float precio, fecha fechaCaducidad) {
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.precio = precio;
        this.fechaCaducidad = fechaCaducidad;
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

    public fecha getFechaCaducidad() {
        return fechaCaducidad;
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

    public void setFechaCaducidad(fecha fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }

    public String toString(){
        return "Descripcion: " + descripcion +
                "\nCantidad: " + cantidad +
                "\nPrecio: " + precio +
                "\nFecha Caducidad: " + fechaCaducidad.toString();
    }
}
