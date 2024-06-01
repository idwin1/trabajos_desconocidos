package Unidad2;

import javax.swing.*;

public class PilaArticulos {
    private Articulo[] p;
    private int tope;

    public PilaArticulos(){
        p = new Articulo[5];
        tope=-1;
    }

    public PilaArticulos(int n) {
        p = new Articulo[n];
        tope=-1;
    }

    public float inventario(){
        float suma = 0;
        for (int i = tope; tope>=0; i--){
            suma += p[i].getPrecio()*p[i].getCantidad();
        }
        return suma;
    }

    public void aumentarPrecio(){
        for (int i = tope; i>=0;i--){
            p[i].setPrecio(p[i].getPrecio()*1.08f);
        }
    }

    public boolean existeArticulo(String s){
        for (int i = 0;i>=0;i--){
            if(s.equalsIgnoreCase(p[i].getDescripcion())){
                return true;
            }
        }
        return false;
    }

    public boolean estaVacia ( ) {
        if( tope == -1) // checa si el tope no señala a ninguna casilla
            return true;
        else
            return false;
    }

    // método que checa si la pila está llena
    public boolean estaLlena ( ) {
        if ( tope == p.length - 1) //checa si el tope está en la última casilla
            return true;
        else
            return false;
    }

    public void insertar(String s,int c,float pr){
        tope++;
        p[tope]= new Articulo(s,c,pr);
    }

    public Articulo eliminar ( ) {
        Articulo borrado = null; // variable que devuelve el dato borrado
        if ( !estaVacia() ) {
            borrado = p[tope]; // se saca el dato del tope
            p[tope] = null; // se borra físicamente la casilla
            tope--; // se decrementa el tope
        }
        return borrado; // se devuelve el valor eliminado
    }

    public float mostrarInventario(){
        float suma=0;
        for (int i=tope;tope>=0;i--){
            suma += p[i].getPrecio()*p[i].getCantidad();
        }
        return suma;
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
        JOptionPane.showMessageDialog(null,"el articulo mas caro es: " +p[v].toString());
    }

    public void articulosMenora5(){
        String s=null;
        for (int i=tope;i>=0;i--){
            if(p[i].getCantidad()<5){
                s+=p[i].toString();
            }
        }
        if(s.equals(null)){
            JOptionPane.showMessageDialog(null,"no hay articulos menores a 5");
        }else {
            JOptionPane.showMessageDialog(null,s);
        }
    }

    public void vaciarPila(){
        tope=-1;
        JOptionPane.showMessageDialog(null,"se a vaciado la pila");
    }



    public String toString(){
        String s="";
        for (int i=tope;i>=0;i--){
            s += p[i].toString();
        }
        return s;
    }
}
