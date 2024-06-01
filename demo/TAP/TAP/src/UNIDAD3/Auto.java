package UNIDAD3;

public class Auto {
    private String modelo;
    private int Km;

    public Auto(String modelo, int km) {
        this.modelo = modelo;
        Km = km;
    }

    public String getModelo() {
        return modelo;
    }

    public int getKm() {
        return Km;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setKm(int km) {
        Km = km;
    }

    public String toString(){
        return "Modelo: " + modelo + "  Km: "+Km;
    }
}
