package Unidad2;

import javax.swing.*;

public class PilaArticulo1 {
    private Articulo[] p;
    private int tope;

    PilaArticulo1(){
        p = new Articulo[5];
        tope=-1;
    }

    PilaArticulo1(int n){
        p = new Articulo[n];
        tope = -1;
    }

    public Articulo[] getP() {
        return p;
    }

    public int getTope() {
        return tope;
    }

    public void setP(Articulo[] p) {
        this.p = p;
    }

    public void setTope(int tope) {
        this.tope = tope;
    }

    public boolean existeArticulo(String descripcion){
        for(int i=0; i<=tope; i++)
            if(descripcion.equalsIgnoreCase(p[i].getDescripcion()))
                return true;
        return false;
    }

    public boolean estaVacia() {
        if(tope==-1)
            return true;
        else
            return false;
    }

    public boolean estaLlena() {
        if(tope==p.length-1)
            return true;
        else
            return false;
    }

    public void insertar(String descripcion, int cantidad, float precio){
        if(!estaLlena()){
            tope++;
            p[tope] = new Articulo(descripcion, cantidad, precio);
        }
    }

    public Articulo eliminar(){
        Articulo borrado=null;
        if(!estaVacia()){
            borrado=p[tope];
            p[tope]=null;
            tope--;
        }
        return borrado;
    }

    public void calcularTotal(){
        float sum = 0;
        for (int i = 0; i <= tope; i++) {
            sum += p[i].getCantidad() * p[i].getPrecio();
        }
        JOptionPane.showMessageDialog(null,"Total inventario: " + sum);
    }

    public void aumentarPrecio(){
        for (int i = 0; i <= tope; i++) {
            p[i].setPrecio(p[i].getPrecio() * 1.08f);
        }
    }
    public void buscarArticulo(String str) {
        for (int i = 0; i <= tope; i++) {
            if (p[i].getDescripcion().equalsIgnoreCase(str)) {
                JOptionPane.showMessageDialog(null, p[i].toString());
            }
        }
    }

    public void articuloMasCaro(){
        float masCaro=0;
        int v=0;
        for (int i=tope;i>=0;i--){
            if(p[i].getPrecio()>masCaro){
                masCaro=p[i].getPrecio();
                v=i;
            }
        }
        JOptionPane.showMessageDialog(null,"el articulo mas caro es:\n " +p[v].toString());
    }

    public void articulosMenora5(){
        String s="";
        for (int i=tope;i>=0;i--){
            if(p[i].getCantidad()<5){
                s+=p[i].toString();
            }
        }
        if(s.equals("")){
            JOptionPane.showMessageDialog(null,"no hay articulos menores a 5");
        }else {
            JOptionPane.showMessageDialog(null,s);
        }
    }

    public String toString() {
        String s="Elementos en la pila:\n";
        int i;
        for( i = tope; i >= 0; i--){
            s += p[i]+"\n";
        }
        s+="Fin de la pila";
        return s;
    }

    public void vaciarPila(){
        for (int i=tope;i>=0;i--){
            p[i]=null;
        }
        tope=-1;
        JOptionPane.showMessageDialog(null,"se a vaciado la pila");
    }
}
