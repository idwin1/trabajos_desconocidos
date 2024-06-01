package Unidad2;

public class Pilafloat {
    private float p[];
    private int tope;

    public Pilafloat() {
        p=new float[5];
        tope = -1;
    }

    public Pilafloat(int n) {
        p=new float[n];
        tope=-1;
    }


    public float[] getP() {
        return p;
    }

    public int getTope() {
        return tope;
    }

    public void setP(float[] nuevoP) {
        p = nuevoP;
    }

    public void setTope(int nuevoTope) {
        tope = nuevoTope;
    }

    public void insertar(float nuevo) {
        if(!estaLlena()) {
            tope++;
            p[tope] = nuevo;
        }
    }

    public float eliminar() {
        float borrado= -999999;
        if(!estaVacia()) {
            borrado=p[tope];
            p[tope]=0;
            tope--;
        }
        return borrado;
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

    public float datoEnTope() {
        if(!estaVacia())
            return p[tope];
        else
            return -999999;
    }

    public int numElementos() {
        return tope+1;
    }

    public String toString() {
        String s="Elementos de la pila:\n";
        int i;
        for(i=tope; i>=0; i--) {
            s+=p[i]+"\n";
        }
        s+="Fin de la pila";
        return s;
    }

}
