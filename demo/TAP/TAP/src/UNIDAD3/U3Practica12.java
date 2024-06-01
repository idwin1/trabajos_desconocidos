package UNIDAD3;

import javax.swing.*;
import java.util.Random;

public class U3Practica12 {
    public static void main(String[] args) {
        boolean salir = false;
        while (!salir) {
            String[] opciones1 = {"1. calcular tiempos","2.Salir"};
            String respuesta = (String) JOptionPane.showInputDialog(null, "Que quieres hacer",
                    "", JOptionPane.QUESTION_MESSAGE, null, opciones1, 0);
            switch (respuesta) {
                case "1. calcular tiempos":
                    String s1,s2,s3,s4,s5,s6;
                    long totBur, totSel,totIns,totBin,totshell,totQuick;
                    int i=Integer.parseInt(JOptionPane.showInputDialog("ingresa el tamaño del vecto"));
                    int[] x = new int[i];
                    rellenar(x);
                    long iniBur = System.currentTimeMillis();
                    Burbuja(x);
                    long finBur = System.currentTimeMillis();
                    totBur = finBur - iniBur;
                    s1=mostrar(x);
                    System.out.println("termino burbuja " + totBur);

                    rellenar(x);
                    iniBur =System.currentTimeMillis();
                    Seleccion(x);
                    finBur = System.currentTimeMillis();
                    totSel=finBur-iniBur;
                    s2=mostrar(x);
                    System.out.println("termino seleccion " + totSel);

                    rellenar(x);
                    iniBur =System.currentTimeMillis();
                    insercionDirecta(x);
                    finBur = System.currentTimeMillis();
                    totIns=finBur-iniBur;
                    s3=mostrar(x);
                    System.out.println("termono Inserccion " +totIns);

                    rellenar(x);
                    iniBur =System.currentTimeMillis();
                    Binaria(x);
                    finBur = System.currentTimeMillis();
                    totBin=finBur-iniBur;
                    s4=mostrar(x);
                    System.out.println("termono binario " + totBin);

                    rellenar(x);
                    iniBur =System.currentTimeMillis();
                    shell(x);
                    finBur = System.currentTimeMillis();
                    totshell=finBur-iniBur;
                    s5=mostrar(x);
                    System.out.println("termono shell " + totshell);

                    rellenar(x);
                    iniBur =System.currentTimeMillis();
                    quicksortAscendente(x,0,x.length-1);
                    finBur = System.currentTimeMillis();
                    totQuick=finBur-iniBur;
                    s6=mostrar(x);
                    System.out.println("termono Quick short " + totQuick);
                    JOptionPane.showMessageDialog(null,
                            "Metodo burbuja: \n" + "Tiempo: " + totBur +"\n vector ordenado:" + s1 +
                                    "\nMetodo Seleccion: \n" + "Tiempo: " + totSel +"\n vector ordenado:" + s2 +
                                    "\nMetodo Inserccion: \n" + "Tiempo: " + totIns +"\nVector Ordenado: " + s3 +
                                    "\nMetodo Binario: \n" + "Tiempo: " + totBin +"\nVector Ordenado: " + s4 +
                                    "\nMetodo shell: \n" + "Tiempo: " + totshell + "\nVector ordenado: " + s5 +
                                    "\nMetodo Quick short: \n" +"Tiempo: " + totQuick + "\nVector ordenado: " + s6);
                    break;
                case "2.Salir":
                    salir=true;
                    break;
            }
        }
    }
    public static void rellenar(int[] x){
        Random rm = new Random();
        for(int i=0;i<x.length;i++){
            x[i]= rm.nextInt(1,1000);
        }
        System.out.println("ya se lleno");
    }
    public static String mostrar(int[] x){
        String s="";
        for(int i=0;i<=50 && i<x.length; i++){
            if(i%20==0){
                s+="\n" + x[i]+",";
            }else {
                s+= x[i]+",";
            }
        }
        return s;
    }
    public static void shell(int[] x){
        int i,intervalo,temp;
        boolean sw;
        intervalo = x.length;
        while (intervalo>=1){
            intervalo = intervalo/2;
            sw = true;
            while (sw){
                sw=false;
                i=0;
                while ((i+intervalo)< x.length){
                    if(x[i]> x[i+intervalo]){
                        temp = x[i];
                        x[i] = x[i+intervalo];
                        x[i+intervalo] = temp;
                        sw=true;
                    }
                    i++;
                }
            }
        }
    }
    public static void Burbuja(int[] a){
        int n= a.length;
        int aux;
        for(int i=1;i<=n-1;i++){
            for(int j=0;j<n-i;j++) {
                if (a[j]>a[j + 1] ) {
                    aux = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = aux;
                }
            }
        }
    }

    public static void Seleccion(int p[]){
        int i,j,pos;
        int aux,menor;
        for (i = 0 ; i < p.length - 1; i++){
            menor=p[i];
            pos=i;
            for (j = i + 1; j < p.length ; j++){
                if(p[j]<menor){
                    menor = p[j];
                    pos = j ;
                }
            }
            if(pos != i ){
                aux = p[i];
                p[i] = p[pos];
                p[pos] = aux;
            }
        }
    }

    public static void insercionDirecta(int x[]){
        int i, j;
        int cont=0;
        int aux;
        for (i = 1; i < x.length; i++){ // desde el segundo elemento hasta

            aux = x[i];           // el final, guardamos el elemento y
            j = i - 1;            // empezamos a comprobar con el anterior
            while ((j >= 0) && (aux<x[j])){ // mientras queden posiciones y el
                // valor de aux sea menor que los
                cont++;
                x[j + 1] = x[j];   // de la izquierda, se desplaza a
                j--;               // la derecha
            }
            x[j + 1] = aux;       // colocamos aux en su sitio
        }
    }

    public static void Binaria(int x[]){
        int i,j,izq,der,mitad,temp;
        for(i=1;i<x.length;i++){
            temp=x[i];
            izq=0;
            der=i-1;
            while (izq<=der){
                mitad=((izq+der)/2);
                if(temp<=x[mitad]){
                    der=mitad-1;
                }
                else{
                    izq=mitad+1;
                }
            }
            j=i-1;
            while(j>=izq){
                x[j+1]=x[j];
                j=j-1;
            }
            x[izq]=temp;
        }
    }

    public static void quicksortAscendente (int a [ ], int inicio, int fin) {
        int pivote = a [inicio]; // Se guarda en como pivote al primer del conjunto a ordenar
        int izq = inicio; // “izq” comienza en el inicio del rango a ordenar
        int der = fin; // “der” comienza en el final del rango a ordenar
        int aux; // esta variable auxiliar se usará para hacer intercambios

        // la izquierda SIEMPRE se va a INCREMENTAR y la derecha SIEMPRE se va a DECREMENTAR
        while ( izq < der ) { // ciclo principal de esta pasada

            while (pivote >= a [izq] && izq < der ) // comparaciones por la izquierda (>=)
                izq++; // avanza apuntador por la izquierda
            while (pivote < a [der] ) // comparaciones por la derecha (<)
                der--; // avanza apuntador por la derecha
            if ( izq < der ) { // realiza un intercambio entre datos del vector para su acomodo
                aux = a [izq];
                a [izq] = a [der];
                a [der] = aux;
            }
        }

        a [inicio] = a [der];
        a [der] = pivote;


        if ( inicio < der -1) // SOLO si queda un conjunto (2 o más elementos) a la izquierda, hace
            quicksortAscendente (a, inicio, der-1); // ... llamada RECURSIVA para la partición izq.
        if ( der+1 < fin) // SOLO si queda un conjunto (2 o más elementos) a la derecha, hace
            quicksortAscendente (a, der+1, fin); // ... llamada RECURSIVA con la partición derecha
    }
}
