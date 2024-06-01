package Unidad3;

public class Automovil {
    private String placa;
    private int tipoServicio;

    public Automovil(String placa, int tipoServicio){
        this.placa = placa;
        this.tipoServicio = tipoServicio;
    }
    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getTipoServicio() {
        return tipoServicio;
    }

    public void setTipoServicio(int tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    public String toString(){
        return "Placa: " + placa +
                "\nTipo de servicio: " + tipoServicio;
    }
}
