package UNIDAD3;

import javax.swing.*;
import java.util.Arrays;

public class U3Practica3 {
    public static void main(String[] args) {
        boolean salir = false;
        while (!salir) {
            Canciones[] canciones = new Canciones[]{new Canciones("No se va","Morat",3.31f),
                    new Canciones("Salir con vida","Morat",2.56f),
                    new Canciones("A traves del vaso","Banda los sebastianes",3.02f),
                    new Canciones("pa quererte","Rels b",2.47f)};
            String[] opciones1 = {"1. ordenar Alfabeticamente (A..Z) por nombre de la cancion", "2. ordenar Ascendente por duracion","3. ordenar Alfabeticamente inverso (Z..A) por interprete", "4. Salir"};
            String respuesta = (String) JOptionPane.showInputDialog(null, "Que quieres hacer",
                    "", JOptionPane.QUESTION_MESSAGE, null, opciones1, 0);
            switch (respuesta) {
                case "1. ordenar Alfabeticamente (A..Z) por nombre de la cancion":
                    JOptionPane.showMessageDialog(null,"canciones desordenadas: " + Arrays.toString(canciones));
                    ordenarAscendente(canciones);
                    JOptionPane.showMessageDialog(null,"canciones ordenadas por nombre: " + Arrays.toString(canciones));
                    break;
                case "2. ordenar Ascendente por duracion":
                    JOptionPane.showMessageDialog(null,"canciones desordenadas: " + Arrays.toString(canciones));
                    ordenarAscendenteDuracion(canciones);
                    JOptionPane.showMessageDialog(null,"canciones ordenadas por duracion: " + Arrays.toString(canciones));
                    break;
                case"3. ordenar Alfabeticamente inverso (Z..A) por interprete":
                    JOptionPane.showMessageDialog(null,"canciones desordenadas: " + Arrays.toString(canciones));
                    ordenarDesententeInterprete(canciones);
                    JOptionPane.showMessageDialog(null,"canciones ordenadas por nombre: " + Arrays.toString(canciones));
                    break;
                case  "4. Salir":
                    salir=true;
                    break;
            }
        }
    }
    public static void ordenarAscendente(Canciones[] a){
        int n= a.length;
        Canciones aux;
        for(int i=1;i<=n-1;i++){
            for(int j=0;j<n-i;j++) {
                if (a[j].getNombre().compareToIgnoreCase(a[j + 1].getNombre()) > 0) {
                    aux = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = aux;
                }
            }
        }
    }
    public static void ordenarAscendenteDuracion(Canciones[] a) {
        int n = a.length;
        Canciones aux;
        for (int i = 1; i <= n - 1; i++) {
            for (int j = 0; j < n - i; j++) {
                if (a[j].getDuracion() > a[j + 1].getDuracion()) {
                    aux = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = aux;
                }
            }
        }
    }
    public static void ordenarDesententeInterprete(Canciones[] a){
        int n= a.length;
        Canciones aux;
        for(int i=1;i<=n-1;i++){
            for(int j=0;j<n-i;j++) {
                if (a[j].getInterprete().compareToIgnoreCase(a[j + 1].getInterprete()) < 0) {
                    aux = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = aux;
                }
            }
        }
    }
}