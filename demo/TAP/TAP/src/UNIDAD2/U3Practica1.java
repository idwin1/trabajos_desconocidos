package UNIDAD2;

import javax.swing.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

public class U3Practica1 {
    public static void main(String[] args) {
        int[] arreglo = new int[8];
        int[] arreglob=new int[12];
        boolean salir = false;
        while (!salir) {
            String[] opciones1 = {"1. ordenar ascendente por burbuja", "2. ordenar desendente por burbuja", "3. Salir"};
            String respuesta = (String) JOptionPane.showInputDialog(null, "Que quieres hacer",
                    "", JOptionPane.QUESTION_MESSAGE, null, opciones1, 0);
            switch (respuesta) {
                case "1. ordenar ascendente por burbuja":
                    llenarVector(arreglo);
                    JOptionPane.showMessageDialog(null,"el arreglo es: " + Arrays.toString(arreglo));
                    JOptionPane.showMessageDialog(null,ordenarAscendente(arreglo) + "\nel arreglo ordenado queda: \n" + Arrays.toString(arreglo));
                    break;
                case  "2. ordenar desendente por burbuja":
                    llenarVectorb(arreglob);
                    JOptionPane.showMessageDialog(null,"el arreglo es: " + Arrays.toString(arreglob));
                    JOptionPane.showMessageDialog(null,ordenarDesendente(arreglob) + "\nel arreglo ordenado queda: \n" + Arrays.toString(arreglob));
                    break;
                case  "3. Salir":
                    salir=true;
                    break;
            }
        }
    }
    public static String ordenarAscendente(int[] a){
        int aux ,comp=0,inter=0,n= a.length;
        for(int i=1;i<=n-1;i++){
            for(int j=0;j<n-i;j++){
                comp++;
                if(a[j]>a[j+1]){
                    aux=a[j];
                    a[j]= a[j+1];
                    a[j+1]=aux;
                    inter++;
                }
            }
        }
        return "comparaciones: " + comp + " intercambios: " +inter;
    }
    public static String ordenarDesendente(int[] a){
        int aux ,comp=0,inter=0,n= a.length;
        for(int i=1;i<=n-1;i++){
            for(int j=0;j<n-i;j++){
                comp++;
                if(a[j]<a[j+1]){
                    aux=a[j];
                    a[j]= a[j+1];
                    a[j+1]=aux;
                    inter++;
                }
            }

        }
        return "comparaciones: " + comp + " intercambios: " +inter;
    }
    public static void llenarVector(int[] a){
        Random rn = new Random();
        for(int i=0;i<a.length;i++){
            a[i]= rn.nextInt(1,10) ;
            //a[i]=(int) (1+(Math.random()*10));
        }
    }
    public static void llenarVectorb(int[] a){
        Random rn = new Random();
        for(int i=0;i<a.length;i++){
            a[i]= rn.nextInt(-10,10) ;
            //a[i]=(int) (1+(Math.random()*10));
        }
    }
}
