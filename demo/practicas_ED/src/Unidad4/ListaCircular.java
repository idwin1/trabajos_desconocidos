package Unidad4;

/* CLASE INSTANCIABLE PARA MANEJAR UNA LISTA ENLAZADA CIRCULAR con 3 atributos:
 *  - un apuntador al primer nodo (inicio)
 *  - un apuntador al ultimo nodo (fin)
 *  - un contador de nodos (numNodos) que SIEMPRE va a ser ENTERO */

import javax.swing.*;
import java.util.Random;

public class ListaCircular {
    // Atributos
    private Nodo inicio;
    private Nodo fin;
    private int numNodos;

    //  Constructor (crea una lista vacia)
    public ListaCircular () {
        inicio = fin = null;
        numNodos = 0;
    }

    // get...
    public Nodo getInicio() {
        return inicio;
    }

    public Nodo getFin() {
        return fin;
    }

    public int getNumNodos() {
        return numNodos;
    }

    // set...
    public void setInicio (Nodo n) {
        inicio = n;
    }

    public void setFin (Nodo n) {
        fin = n;
    }

    public void setNumNodos (int nn) {
        numNodos = nn;
    }

    // checa si la lista esta vacia
    public boolean listaVacia () {
        if (inicio == null)
            return true;
        else
            return false;
    }

    //inserta nodo al inicio
    public void insertaInicio (Nodo nuevo) {
        if (listaVacia () ) {
            inicio = fin = nuevo;
            nuevo.setEnlace (nuevo);
        }
        else {
            nuevo.setEnlace (inicio);
            inicio = nuevo;
            fin.setEnlace (nuevo);
        }
        numNodos++;
    }

    public void insertarFinal(Nodo nuevo){
        if (listaVacia () ) {
            inicio = fin = nuevo;
            nuevo.setEnlace (nuevo);
        }
        else {
            fin.setEnlace (nuevo);
            fin = nuevo;
            fin.setEnlace (inicio);
        }
        numNodos++;
    }

    public Nodo eliminarX(String borra){
        if(!listaVacia()) {
            Nodo r = inicio;
            Nodo c = null;
            int i = 1;
            if (r.getDato1().equalsIgnoreCase(borra)) {
                if (numNodos == 1) {
                    inicio = null;
                    numNodos--;
                } else {
                    inicio = r.getEnlace();
                    fin.setEnlace(inicio);
                    numNodos--;
                }
                return r;
            }
            do {
                if (i < numNodos) {
                    if (r.getDato1().equalsIgnoreCase(borra)) {
                        c.setEnlace(r.getEnlace());
                        numNodos--;
                        return r;
                    }
                }
                if (i == numNodos) {
                    if (r.getDato1().equalsIgnoreCase(borra)) {
                        c.setEnlace(inicio);
                        fin = c;
                        numNodos--;
                        return r;
                    }
                }
                c = r;
                r = r.getEnlace();
                i++;
            } while (r != inicio);
        }
        return null;
    }

    public void insertarAlfabeticamente1(Nodo nuevo){
        String x = nuevo.getDato1();
        Nodo momento = null;
        Nodo r=inicio;
        int i=1;
        if(!listaVacia()){
            if(x.compareToIgnoreCase(inicio.getDato1())<0)
                insertaInicio(nuevo);
            else{
                while(i<numNodos) {
                    if (x.compareToIgnoreCase(r.getDato1()) > 0 && x.compareToIgnoreCase(r.getEnlace().getDato1()) < 0) {
                        momento = r.getEnlace();
                        r.setEnlace(nuevo);
                        nuevo.setEnlace(momento);
                        numNodos++;
                        break;
                    }
                    i++;
                    r=r.getEnlace();
                }
                if (i == numNodos)
                    insertarFinal(nuevo);
            }
        }else
            insertaInicio(nuevo);
    }


    public void centurion(int n) {
        Random ran = new Random();
        int random;
        for (int i = 1; i <= n; i++) {
            insertarAlfabeticamente1(new Nodo(JOptionPane.showInputDialog("ingrese el nombre","PEPE")));
        }
        JOptionPane.showMessageDialog(null,"LOS PARTICIPANTES SON: \n"+ nombres());
        Nodo r = inicio;
        while(numNodos!=1){
            random=ran.nextInt(1,6);
            JOptionPane.showMessageDialog(null,"EL SOLDADO: "+r.getDato1()+" \nLANZO EL DADO Y CAYO: "+random);
            for (int j = 1 ; j <= random; j++){
                if(j==random) {
                    JOptionPane.showMessageDialog(null,"EL SOLDADO ELIMINADO ES:  " +eliminarX(r.getDato1()).getDato1());
                }
                r = r.getEnlace();
            }
            if(numNodos==1)
                JOptionPane.showMessageDialog(null,"EL GANADOR ES: \n" + nombres());
            else
                JOptionPane.showMessageDialog(null,"LOS SOLDADOS QUE QUEDAN SON:\n "+nombres());
        }
    }
    public String nombres() {
        String s = "";
        Nodo r = inicio;
        if (listaVacia () )
            s += "Lista vacia";
        else {
            do {
                s += r.getDato1() + "\n";
                r = r.getEnlace();
            } while (r != inicio);
        }
        return s;
    }

    //toString
    public String toString() {
        String s = "";
        Nodo r = inicio;
        if (listaVacia () )
            s += "Lista vacia";
        else {
            do {
                s += r.toString() + "\n";
                r = r.getEnlace();
            } while (r != inicio);
        }
        return s;
    }

    // faltan métodos
}
