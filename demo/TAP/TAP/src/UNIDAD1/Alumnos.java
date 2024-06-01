package UNIDAD1;

public class Alumnos {
    private String nombre;
    private int edad;
    private int numControl;
    private float[] calif;
    private fecha fecha;

    public Alumnos(){
        this.calif=null;
        this.edad=0;
        this.nombre="";
        this.numControl=0;
        this.fecha=null;
    }
    public Alumnos(String nombre, float[] calif,int numControl,fecha fecha){
        this.calif=calif;
        this.edad=0;
        this.nombre=nombre;
        this.numControl=numControl;
        this.fecha = fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public int getNumControl() {
        return numControl;
    }

    public float[] getCalif() {
        return calif;
    }

    public UNIDAD1.fecha getFecha() {
        return fecha;
    }

    public void setFecha(fecha fecha) {
        this.fecha = fecha;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setNumControl(int numControl) {
        this.numControl = numControl;
    }

    public void setCalif(float[] calif) {
        this.calif = calif;
    }

    public String toString(){
        fecha fecha2 =new fecha(2,2,2023); // la fecha 2 indica la fecha actual de la cracion del programa
        if( fecha.getMes()<=fecha2.getMes()) {
            if (fecha.getDia()<fecha2.getDia() ){
                edad = (fecha.getAño() - fecha2.getAño()) * -1;
            }else
                edad = (((fecha.getAño() - fecha2.getAño()) * -1) - 1);
        } else {
            edad = (((fecha.getAño() - fecha2.getAño()) * -1) - 1);
        }
        return "\nNombre: "+nombre + "\n" + "edad: " + edad +"\n"+ "numero control: " + numControl + "\n" +
                "calif1:"+calif[0]+ "\n" + "calif2:"
                + calif[1]+ "\n" + "calif:"+calif[2] +
                "\n" + fecha.toString();
    }
    public String calificaciones(){
        String s="";
        for(int i=0;i<calif.length;i++){
            s+="\nCalificaion " + (i+1) +": "+ calif[i];
        }
        return s;
    }

    public float calcularPromedio(){
        float total=0;
        for (int i=0;i<calif.length;i++){
            total+=calif[i];
        }
        return total/3;
    }
}
