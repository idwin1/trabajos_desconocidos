package Unidad3;

public class ColaLinealCliente {
    private Cliente c[];
    private int frente, fin;

    public ColaLinealCliente() {
        c = new Cliente[5];
        frente = 0;
        fin = -1;
    }

    public ColaLinealCliente(int n) {
        c = new Cliente[n];
        frente = 0;
        fin = -1;
    }

    public Cliente[] getC() {
        return c;
    }

    public int getFrente() {
        return frente;
    }

    public int getFin() {
        return fin;
    }

    public void setC(Cliente[] c) {
        this.c = c;
    }

    public void setFrente(int frente) {
        this.frente = frente;
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

    public boolean estaLlena() {
        if (fin == c.length - 1)
            return true;
        else
            return false;
    }
    public void insertar(Cliente x) {
        if (!estaLlena()) {
            fin++;
            c[fin] = x;
        }
    }

    public Cliente eliminar() {
        Cliente borrado = null;
        if (!estaVacia()) {
            borrado = c[frente];
            c[frente] = null;
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

    public String mostrarClientes(){
        String s="";
        for (int i = frente; i <= fin; i++)
            s +="cliente: " + i +"\n" +c[i].toString() + "\n" ;
        return s;
    }

    public float sumaSaldos(){
        float suma=0;
        for (int i = frente; i <= fin; i++)
            suma += c[i].getSaldo() ;
        return suma;
    }

    public void aumentarSaldoFrente(float x){
        if(!estaVacia())
            c[frente].setSaldo(c[frente].getSaldo()*((x/100)+1));
    }

    public String mostrartipoClientes(String s){
        String clientes="";
        for (int i = frente; i <= fin; i++)
            if(s.equalsIgnoreCase(c[i].getTipoCuenta()))
                clientes += c[i].getNombre();
        return clientes;
    }

    public String toString( ) {
        String s = "";
        for (int i = frente; i <= fin; i++)
            s += c[i].toString() + "\n";
        return s;
    }
}
