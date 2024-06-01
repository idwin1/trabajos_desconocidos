package Unidad3;

public class ColaInt {
    // 3 atributos
    private int c[]; // Vector de ENTEROS
    private int frente, fin; // Apuntadores para el frente y final de la estructura

    public ColaInt() {
        c = new int[5];
        frente = 0;
        fin = -1;
    }

    public ColaInt(int n) {
        c = new int[n];
        frente = 0;
        fin = -1;
    }

    public int[] getC() {
        return c;
    }

    public void setC(int[] c) {
        this.c = c;
    }

    public int getFrente() {
        return frente;
    }

    public void setFrente(int frente) {
        this.frente = frente;
    }

    public int getFin() {
        return fin;
    }

    public void setFin(int fin) {
        this.fin = fin;
    }

    public boolean estaVacia() {
        if (frente > fin)
            return true;
        else
            return false;
    }

    public boolean estaLlena( ) {
        if (fin == c.length - 1)
            return true;
        else
            return false;
    }

    public void insertar(int x) {
        if (!estaLlena()) {
            fin++;
            c[fin] = x;
        }
    }

    public int eliminar( ) {
        int borrado = -99999;
        if (!estaVacia()) {
            borrado = c[frente];
            c[frente] = 0;
            frente++;
            if (estaVacia()) {
                frente = 0;
                fin = -1;
            }
        }
        return borrado;
    }

    public int numElementos( ) {
        return fin - frente + 1;
    }

    public int elementoEnFrente ( ) {
        if (estaVacia( ) )
            return -99999;
        else
            return c[frente];
    }

    public String toString( ) {
        String s="";
        for (int i = frente; i <= fin; i++)
            s += c[i]+"\n";
        return s;
    }
}
