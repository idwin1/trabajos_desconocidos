package UNIDAD3;

import javax.swing.*;
import java.util.Random;

public class U3Practica8 {
    public static void main(String[] args) {
        boolean salir = false;
        while (!salir) {
            String s;
            String[] opciones1 = {"1. Ordenar Ascendente por SHELL", "2. Ordenar Alfabético por SHELL","3. Terminar"};
            String respuesta = (String) JOptionPane.showInputDialog(null, "Que quieres hacer",
                    "", JOptionPane.QUESTION_MESSAGE, null, opciones1, 0);
            switch (respuesta) {
                case "1. Ordenar Ascendente por SHELL":
                    int[] arreglo = new int[20];
                    generarEnteros(arreglo);
                    mostrar(arreglo);
                    s=shell(arreglo);
                    JOptionPane.showMessageDialog(null,s);
                    mostrar(arreglo);
                    break;
                case "2. Ordenar Alfabético por SHELL":
                    String[] arreglo1 = new String[]{"Hector","kieran","Babun","Dayana","Cristian","Hermes","Adrian","Aron","Renata","Leo"};
                    mostrarString(arreglo1);
                    s=shellAlfabetico(arreglo1);
                    JOptionPane.showMessageDialog(null,s);
                    mostrarString(arreglo1);
                    break;
                case "3. Terminar":
                    salir=true;
                    break;
            }
        }
    }
    public static void mostrarString(String[] x){
        int cont=0;
        String s="";
        for (int i=0;i<x.length;i++){
            if(cont==10){
                s+="\n" + x[i] +",";
                cont=1;
            }else {
                s+=x[i] +",";
            }
            cont++;
        }
        JOptionPane.showMessageDialog(null,s);
    }
    public static void mostrar(int[] x){
        int cont=0;
        String s="";
        for (int i=0;i<x.length;i++){
            if(cont==10){
                s+="\n" + x[i] +",";
                cont=1;
            }else {
                s+=x[i] +",";
            }
            cont++;
        }
        JOptionPane.showMessageDialog(null,s);
    }
    public static void generarEnteros(int[] x){
        Random rm = new Random();
        for (int i = 0; i<x.length;i++){
            x[i]= rm.nextInt(1,50);
        }
    }
    public static String shell(int[] x){
        int i,intervalo,temp,comparaciones = 0,intercambios = 0;
        boolean sw;
        intervalo = x.length;
        while (intervalo>=1){
            intervalo = intervalo/2;
            sw = true;
            while (sw){
                sw=false;
                i=0;
                while ((i+intervalo)< x.length){
                    comparaciones++;
                    if(x[i]> x[i+intervalo]){
                        intercambios++;
                        temp = x[i];
                        x[i] = x[i+intervalo];
                        x[i+intervalo] = temp;
                        sw=true;
                    }
                    i++;
                }
            }
        }
        return "comparaciones: " +comparaciones +"  intercambios:  " +intercambios;
    }
    public static String shellAlfabetico(String[] x){
        int i,intervalo,comparaciones = 0,intercambios = 0;
        boolean sw;
        String temp;
        intervalo = x.length;
        while (intervalo>=1){
            intervalo = intervalo/2;
            sw = true;
            while (sw){
                sw=false;
                i=0;
                while ((i+intervalo)< x.length){
                    comparaciones++;
                    if(x[i].compareToIgnoreCase(x[i+intervalo])>0){
                        intercambios++;
                        temp = x[i];
                        x[i] = x[i+intervalo];
                        x[i+intervalo] = temp;
                        sw=true;
                    }
                    i++;
                }
            }
        }
        return "comparaciones: " +comparaciones +"  intercambios:  " +intercambios;
    }

}
