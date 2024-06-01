package UNIDAD3;

public class Pais {
    private String nombre;
    private String capital;

    public Pais(String nombre, String capital) {
        this.nombre = nombre;
        this.capital = capital;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCapital() {
        return capital;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String toString(){
        return "\nNombre: "+nombre + " Capital: " + capital;
    }
}
