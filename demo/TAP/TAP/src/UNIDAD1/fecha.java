package UNIDAD1;

public class fecha {
    private int dia;
    private int mes;
    private int año;

    public fecha() {
        this.dia = 1;
        this.mes = 1;
        this.año = 1;
    }

    public fecha(int dia, int mes, int año) {
        this.dia = dia;
        this.mes = mes;
        this.año = año;
    }

    public int getDia() {
        return dia;
    }

    public int getMes() {
        return mes;
    }

    public int getAño() {
        return año;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public String toString(){
        String[] arreglo = new String[]{"Enero","Febrero","Marzo","Abril","Mayo","Junio","julio","Agosto","Septiebre","Octubre","Novienbre","Diciembre"};
        return  dia + "/" + arreglo[mes-1] + "/" + año;
    }
}
