package Unidad2;
public class PilaString {
    private String p[];
    private int tope;

    public PilaString() {
        p=new String[5];
        tope = -1;
    }

    public PilaString(int n) {
        p=new String[n];
        tope=-1;
    }

    public String[] getP() {
        return p;
    }

    public int getTope() {
        return tope;
    }

    public void setP(String[] nuevoP) {
        p = nuevoP;
    }

    public void setTope(int nuevoTope) {
        tope = nuevoTope;
    }

    public void insertar(String nuevo) {
        if(!estaLlena()) {
            tope++;
            p[tope] = nuevo;
        }
    }

    public String eliminar() {
        String borrado="Está vacía la pila";
        if(!estaVacia()) {
            borrado=p[tope];
            p[tope]=null;
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

    public String datoEnTope() {
        if(!estaVacia())
            return p[tope];
        else
            return "La pila está vacía";
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
