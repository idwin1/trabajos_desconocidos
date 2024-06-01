package UNIDAD3;

public class Canciones {
    private String nombre;
    private String interprete;
    private float duracion;

    public Canciones(String nombre, String interprete, float duracion) {
        this.nombre = nombre;
        this.interprete = interprete;
        this.duracion = duracion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getInterprete() {
        return interprete;
    }

    public float getDuracion() {
        return duracion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setInterprete(String interprete) {
        this.interprete = interprete;
    }

    public void setDuracion(float duracion) {
        this.duracion = duracion;
    }

    public String toString(){
        return "\nNombre: " + nombre + "\ninterprete: " + interprete + "\nduracion: " + duracion ;
    }
}
