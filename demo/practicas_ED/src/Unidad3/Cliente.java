package Unidad3;

public class Cliente {

    private String nombre;
    private String tipoCuenta;
    private float saldo;

    public Cliente(String nombre,String tipoCuenta,float saldo){
        this.nombre = nombre;
        this.tipoCuenta = tipoCuenta;
        this.saldo = saldo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public String toString(){
        String s;
        s = "nombre: " + nombre +"\n" +
            "tipo cuent: " + tipoCuenta + "\n" +
            "saldo: " + saldo + "\n" ;
        return s;
    }
}
