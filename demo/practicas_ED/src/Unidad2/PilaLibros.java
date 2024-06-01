package Unidad2;
import Unidad2.Articulo;

import javax.swing.*;

public class PilaLibros {
    private Libro[] p;
    private int tope;

    public int getTope() {
        return tope;
    }

    public PilaLibros() {
        p = new Libro[5];
        tope=-1;
    }

    public PilaLibros(int i) {
        p = new Libro[i];
        tope=-1;
    }

    public boolean estaVacia ( ) {
        if( tope == -1) // checa si el tope no señala a ninguna casilla
            return true;
        else
            return false;
    }

    public boolean estaLlena ( ) {
        if ( tope == p.length - 1) //checa si el tope está en la última casilla
            return true;
        else
            return false;
    }

    public void insertar(String s,String c,float pr){
        tope++;
        p[tope]= new Libro(s,c,pr);
    }

    public Libro eliminar ( ) {
        Libro borrado = null; // variable que devuelve el dato borrado
        if ( !estaVacia() ) {
            borrado = p[tope]; // se saca el dato del tope
            p[tope] = null; // se borra físicamente la casilla
            tope--; // se decrementa el tope
        }
        return borrado; // se devuelve el valor eliminado
    }

    public void vaciarPila(){
        tope=-1;
        JOptionPane.showMessageDialog(null,"se a vaciado la pila");
    }

    public float TotalDePrecios(){
        float suma =0;
        for (int i=tope;i>=0;i--){
            suma += p[i].getPrecio();
        }
        return suma;
    }

    public String toString(){
        String s="";
        for (int i=tope;i>=0;i--){
            s += p[i].toString();
        }
        return s;
    }

}
