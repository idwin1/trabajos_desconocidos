package UNIDAD2;

import javax.swing.*;

public class U2Practica2 {
    public static void main(String[] args) {
        boolean salir = false;
        while (!salir) {
            String[] opciones1 = { "1. Contar mayusculas", "2. Contar vocales", "3. Invertir cadena", "4. Salir" };
            char respuesta = ((String) JOptionPane.showInputDialog(null, "Que quieres hacer", "Opciones recursividad",
                    JOptionPane.QUESTION_MESSAGE, null, opciones1, 0)).charAt(0);
            switch (respuesta) {
                case '1' -> {
                    String s = JOptionPane.showInputDialog("Ingrese una string:");
                    JOptionPane.showMessageDialog(null, "No. de mayúsculas en la string \"" + s + "\": " + cuentaMay(s, 0));
                }
                case '2' -> {
                    String s = JOptionPane.showInputDialog("Ingrese una string:");
                    JOptionPane.showMessageDialog(null, "No. de vocales en la string \"" + s + "\": " + cantVocales(s, 0));
                }
                case '3' -> {
                    String s = JOptionPane.showInputDialog("Ingrese una string:");
                    JOptionPane.showMessageDialog(null, "Inversión de la string \"" + s + "\": " + invString(s, (s.length()-1)));
                }
                case '4' -> {
                    salir = true;
                }
            }
        }
    }

    // Casos de prueba cuentaMay("Hola", 0);
    public static int cuentaMay(String s, int indice) {
        if (indice >= s.length() - 1) {
            return (Character.isUpperCase(s.charAt(indice))) ? 1 : 0;
        }
        return (Character.isUpperCase(s.charAt(indice))) ? (1 + cuentaMay(s, indice + 1)) : (cuentaMay(s, indice + 1));

    }

    public static int cantVocales(String s, int indice){
        switch (s.charAt(indice)) {
            case 'a' -> {
                return (cantVocales(s,indice + 1) + 1);
            }
            case 'e' -> {
                return (cantVocales(s,indice + 1) + 1);
            }
        }
        return 0;
    }

    public static String invString(String s,int indice) {
        if (indice >= 0)
            return s.charAt(indice) + invString(s, indice-1);
        else {
            return "";
        }
    }
}

