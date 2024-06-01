package UNIDAD3;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class U3Practica11 {
    public static void main(String[] args) {
        String archivo = "C:\\Users\\Asus TUF\\.eclipse\\tec trabajos\\demo\\TAP\\TAP\\src\\UNIDAD3\\paises.txt";
        BufferedReader br = null;
        String[] paises=new String[50];
        int cont=0;
        try {
            br = new BufferedReader(new FileReader(archivo));
            String linea;
            while ((linea = br.readLine()) != null) {
                paises[cont] = linea;
                cont++;
            }
            for (int i = cont;i<paises.length;i++){
                paises[i]="@";
            }
            System.out.println("termino de leer");
            mostrar(paises);
            quicksortAscendente(paises,0, paises.length-1);
            mostrar(paises);
        } catch (IOException e) {
            System.out.println("Error al leer el archivo " + archivo + ": " + e.getMessage());
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
                System.out.println("Error al cerrar el archivo " + archivo + ": " + e.getMessage());
            }
        }
    }

    public static void mostrar(String[] x){
        int cont=0;
        String s="";
        for (int i=0;i<x.length;i++){
            if(x[i].compareToIgnoreCase("@") != 0 ){
                if(cont==10){
                    s+="\n" + x[i] +",";
                    cont=1;
                }else {
                    s+=x[i] +",";
                }
                cont++;
            }
        }
        JOptionPane.showMessageDialog(null,s);
    }
    public static void quicksortAscendente (String a [ ], int inicio, int fin) {
        String pivote = a [inicio]; // Se guarda en como pivote al primer del conjunto a ordenar
        int izq = inicio; // “izq” comienza en el inicio del rango a ordenar
        int der = fin; // “der” comienza en el final del rango a ordenar
        String aux; // esta variable auxiliar se usará para hacer intercambios

        // la izquierda SIEMPRE se va a INCREMENTAR y la derecha SIEMPRE se va a DECREMENTAR
        while ( izq < der ) { // ciclo principal de esta pasada

            while (pivote.compareToIgnoreCase(a [izq])>=0 && izq < der ) // comparaciones por la izquierda (>=)
                izq++; // avanza apuntador por la izquierda
            while (pivote.compareToIgnoreCase(a [der])<0 ) // comparaciones por la derecha (<)
                der--; // avanza apuntador por la derecha
            if ( izq < der ) { // realiza un intercambio entre datos del vector para su acomodo
                aux = a [izq];
                a [izq] = a [der];
                a [der] = aux;
            }
        }


        a [inicio] = a [der];
        a [der] = pivote;



        if ( inicio < der -1)
            quicksortAscendente (a, inicio, der-1);
        if ( der+1 < fin) // SOLO si queda un conjunto (2 o más elementos) a la derecha, hace
            quicksortAscendente (a, der+1, fin); // ... llamada RECURSIVA con la partición derecha
    }
}
