package ED.Unidad1;

public class Empleado {
    //IDWIN RAZIEL BALDERAS ALMANZA
    private String nombre;
    private float sueldoPorHora;
    private int horas;

    public Empleado(String nombre, float sueldoPorHora, int horas) {
        this.nombre = nombre;
        this.sueldoPorHora = sueldoPorHora;
        this.horas = horas;
    }

    public String getNombre() {
        return nombre;
    }
    public float getSueldoPorHora() {
        return sueldoPorHora;
    }
    public int getHoras() {
        return horas;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setSueldoPorHora(float sueldoPorHora) {
        this.sueldoPorHora = sueldoPorHora;
    }
    public void setHoras(int horas) {
        this.horas = horas;
    }

    public  String toString(){

        return "Nombre:" + nombre +"\nSueldo: " + sueldoPorHora + "\nHoras: " + horas;
    }
}
