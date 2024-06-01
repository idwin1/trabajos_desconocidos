package UNIDAD3;

import javax.swing.*;
import java.text.Normalizer;
import java.util.Arrays;

public class U3Practica5 {
    public static void main(String[] args) {
        boolean salir = false;
        while (!salir) {
            Pais[] paises = {new Pais("Argentina", "Buenos Aires"),
                    new Pais("Bolivia", "La Paz"),
                    new Pais("Brasil", "Brasilia"),
                    new Pais("Perú", "Lima"),
                    new Pais("Canadá", "Ottawa"),
                    new Pais("Costa Rica", "San José"),
                    new Pais("Cuba", "La Habana"),
                    new Pais("México", "Ciudad de México"),
                    new Pais("Chile", "Santiago"),
                    new Pais("Uruguay", "Montevideo"),
                    new Pais("Colombia", "Bogotá"),
                    new Pais("Estados Unidos", "Washington D.C.")};
            String[] opciones1 = {"1. Alfabeto (A..Z) por pais", "2. Alfabeto inverso (Z..A) por capital", "3. Salir"};
            String respuesta = (String) JOptionPane.showInputDialog(null, "Que quieres hacer",
                    "", JOptionPane.QUESTION_MESSAGE, null, opciones1, 0);
            switch (respuesta) {
                case "1. Alfabeto (A..Z) por pais":
                    JOptionPane.showMessageDialog(null,"vector original\n " + Arrays.toString(paises));
                    insercionDirecta(paises);
                    JOptionPane.showMessageDialog(null,"vector ordenado\n " + Arrays.toString(paises));
                    break;
                case "2. Alfabeto inverso (Z..A) por capital":
                    JOptionPane.showMessageDialog(null,"vector original\n " + Arrays.toString(paises));
                    insercionDirectaInverza(paises);
                    JOptionPane.showMessageDialog(null,"vector ordenado\n " + Arrays.toString(paises));
                    break;
                case  "3. Salir":
                    salir=true;
                    break;
            }
        }
    }

    public static void insercionDirecta(Pais x[]){
        int i, j;
        int cont=0;
        Pais aux;
        for (i = 1; i < x.length; i++){ // desde el segundo elemento hasta

            aux = x[i];           // el final, guardamos el elemento y
            j = i - 1;            // empezamos a comprobar con el anterior
            while ((j >= 0) && (aux.getNombre().compareToIgnoreCase(x[j].getNombre()) < 0 )){ // mientras queden posiciones y el
                                        // valor de aux sea menor que los
                cont++;
                x[j + 1] = x[j];   // de la izquierda, se desplaza a
                j--;               // la derecha
            }
            x[j + 1] = aux;       // colocamos aux en su sitio
        }
        JOptionPane.showMessageDialog(null,"cantidad de comparaciones: "+ cont);
    }
    public static void insercionDirectaInverza(Pais x[]){
        int i, j;
        int cont=0;
        Pais aux;
        for (i = 1; i < x.length; i++){ // desde el segundo elemento hasta

            aux = x[i];           // el final, guardamos el elemento y
            j = i - 1;            // empezamos a comprobar con el anterior
            while ((j >= 0) && (normalizarCaracteres(aux.getCapital()).compareToIgnoreCase(normalizarCaracteres(x[j].getCapital())) > 0)){ // mientras queden posiciones y el
                // valor de aux sea menor que los
                cont++;
                x[j + 1] = x[j];   // de la izquierda, se desplaza a
                j--;               // la derecha
            }
            x[j + 1] = aux;       // colocamos aux en su sitio
        }
        JOptionPane.showMessageDialog(null,"cantidad de comparaciones: "+ cont);
    }
    private static String normalizarCaracteres(String input) {
        return input == null ? null : Normalizer.normalize(input, Normalizer.Form.NFKD);
    }
}
