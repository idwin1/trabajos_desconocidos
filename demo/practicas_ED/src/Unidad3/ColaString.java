package Unidad3;

public class ColaString{
        private String c[]; // Vector de ENTEROS
        private int frente, fin; // Apuntadores para el frente y final de la estructura

        public ColaString() {
            c = new String[5];
            frente = 0;
            fin = -1;
        }

        public ColaString(int n) {
            c = new String[n];
            frente = 0;
            fin = -1;
        }

        public String[] getC() {
            return c;
        }

        public int getFrente() {
            return frente;
        }

        public int getFin() {
            return fin;
        }

        public void setC(String[] c) {
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

        public void insertar(String x) {
            if (!estaLlena()) {
                fin++;
                c[fin] = x;
            }
        }

        public String eliminar() {
            String borrado = "";
            if (!estaVacia()) {
                borrado = c[frente];
                c[frente] = "";
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

        public String elementoEnFrente ( ) {
            if (estaVacia( ) )
                return "";
            else
                return c[frente];
        }

        public String elementoEnFin(){
            if(estaVacia())
                return "";
            else
                return c[fin];
        }



        public String toString( ) {
            String s = "";
            for (int i = frente; i <= fin; i++)
                s += c[i] + "\n";
            return s;
        }
}
