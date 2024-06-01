package UNIDAD3;

import javax.swing.*;
import java.util.Arrays;

public class U3Practica2 {
    public static void main(String[] args) {
        String[] amigos = new String[]{"kieran","babun","dayana","aaron","renata","mauro","edgar","abi"};
        String[] paises = new String[]{"mexico","estados unidos","canada","argentina","españa","peru","brasil", "noruega","francia","china","japon","australia"};
        boolean salir = false;
        while (!salir) {
            String[] opciones1 = {"1. ordenar amigos A..Z usando Burbuja", "2. ordenar paises Z..A usando Burbuja", "3. Salir"};
            String respuesta = (String) JOptionPane.showInputDialog(null, "Que quieres hacer",
                    "", JOptionPane.QUESTION_MESSAGE, null, opciones1, 0);
            switch (respuesta) {
                case "1. ordenar amigos A..Z usando Burbuja":
                    JOptionPane.showMessageDialog(null,"el arreglo de amigos es: " + Arrays.toString(amigos));
                    ordenarAscendente(amigos);
                    JOptionPane.showMessageDialog(null,  "\nel arreglo ordenado queda: \n" + Arrays.toString(amigos));
                    break;
                case  "2. ordenar paises Z..A usando Burbuja":
                    JOptionPane.showMessageDialog(null,"el arreglo de amigos es: " + Arrays.toString(paises));
                    ordenarDesendente(paises);
                    JOptionPane.showMessageDialog(null,  "\nel arreglo ordenado queda: \n" + Arrays.toString(paises));
                    break;
                case  "3. Salir":
                    salir=true;
                    break;
            }
        }
    }

    public static void ordenarAscendente(String[] a){
        int n= a.length,pasada=0;
        String aux;
        for(int i=1;i<=n-1;i++){
            pasada++;
            for(int j=0;j<n-i;j++) {
                if (a[j].compareToIgnoreCase(a[j + 1]) > 0) {
                    aux = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = aux;
                }
            }
            JOptionPane.showMessageDialog(null, "pasada: " + pasada + "\n" + Arrays.toString(a));
        }
    }
    public static void ordenarDesendente(String[] a){
        int n= a.length,pasada=0;
        String aux;
        for(int i=1;i<=n-1;i++){
            pasada++;
            for(int j=0;j<n-i;j++){
                if(a[j].compareToIgnoreCase(a[j+1])<0){
                    aux=a[j];
                    a[j]= a[j+1];
                    a[j+1]=aux;
                }
            }
            JOptionPane.showMessageDialog(null,"pasada: " + pasada + "\n" +Arrays.toString(a));
        }
    }
}
