package Unidad2;

public class Libro {
    private String titulo;
    private String autor;
    private float precio;

    public Libro(String titulo, String autor, float precio) {
        this.titulo = titulo;
        this.autor = autor;
        this.precio = precio;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public float getPrecio() {
        return precio;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String toString(){
        return "Titulo: " + getTitulo() +
                "\n Autor: " + getAutor() +
                "\n Precio " + getPrecio();
    }
}
