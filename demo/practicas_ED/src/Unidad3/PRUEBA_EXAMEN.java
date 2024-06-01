package Unidad3;

import ED.Unidad1.Libro;

public class PRUEBA_EXAMEN {
    private Libro c[] ;
    private int fin,frente;

    public PRUEBA_EXAMEN(){
        c = new Libro[5];
        frente = 0;
        fin = -1;
    }

    public Libro[] getC() {
        return c;
    }

    public int getFin() {
        return fin;
    }

    public int getFrente() {
        return frente;
    }
}
