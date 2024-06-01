package Unidad5;

public class NodoCiudades {

    private NodoCiudades izquierdo; //apuntador al hijo izquierdo
    private String nombre;            // nodo con UN dato String
    private String pais;
    private NodoCiudades derecho;   //apuntador al hijo derecho

    public NodoCiudades(String nom, String pa){
        nombre = nom;
        pais = pa;
        izquierdo = derecho = null;
    }

    public NodoCiudades getIzquierdo() {
        return izquierdo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPais() {
        return pais;
    }

    public NodoCiudades getDerecho() {
        return derecho;
    }

    public void setIzquierdo(NodoCiudades izquierdo) {
        this.izquierdo = izquierdo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public void setDerecho(NodoCiudades derecho) {
        this.derecho = derecho;
    }

    public String toString(){
        return "ciudad: " + nombre + "\n" + "pais:" + pais;
    }
}
