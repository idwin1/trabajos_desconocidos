package UNIDAD3;


import java.util.Arrays;

import javax.swing.JOptionPane;

    public class p {

        private static int comparaciones = 0;
        private static int intercambios = 0;

        public static void main(String[] args) {
            String[] opciones = { "1. Ordenar A-Z (ASC) por CAPITAL", "2. Ordenar Z-A (DESC) por PAÍS", "3. Salir" };
            boolean salir = false;
            while (!salir) {

                Pais[] paisesEuropeos = { new Pais("Chipre", "Nicosia"), new Pais("Eslovenia", "Liubliana"),
                        new Pais("Albania", "Tirana"), new Pais("Hungría", "Budapest"), new Pais("Islandia", "Reikiavik"),
                        new Pais("Irlanda", "Dublín"), new Pais("Alemania", "Berlín"),
                        new Pais("Andorra", "Andorra la Vella"), new Pais("Bélgica", "Bruselas"),
                        new Pais("Bosnia y Herzegovina", "Sarajevo"), new Pais("Croacia", "Zagreb"),
                        new Pais("Bulgaria", "Sofía"), new Pais("Dinamarca", "Copenhague"), new Pais("Estonia", "Tallin"),
                        new Pais("Finlandia", "Helsinki"), new Pais("Francia", "París"), new Pais("Grecia", "Atenas"),
                        new Pais("Austria", "Viena"), new Pais("Eslovaquia", "Bratislava"), new Pais("España", "Madrid") };

                char respuesta = ((String) JOptionPane.showInputDialog(null, "Que quieres hacer?", "Opciones",
                        JOptionPane.QUESTION_MESSAGE, null, opciones, 0)).charAt(0);

                switch (respuesta) {
                    case '1' -> {
                        JOptionPane.showMessageDialog(null, "Vector desordenado: " + Arrays.deepToString(paisesEuropeos));
                        seleccion(paisesEuropeos, 0);
                        JOptionPane.showMessageDialog(null,
                                "Vector ordenado ascendentemente A-Z por CAPITAL: " + Arrays.deepToString(paisesEuropeos));
                        JOptionPane.showMessageDialog(null,
                                "Comparaciones: " + comparaciones + "\nIntercambios: " + intercambios);

                        comparaciones = 0;
                        intercambios = 0;
                    }
                    case '2' -> {
                        JOptionPane.showMessageDialog(null, "Vector desordenado: " + Arrays.toString(paisesEuropeos));
                        seleccion(paisesEuropeos, 1);
                        JOptionPane.showMessageDialog(null,
                                "Vector ordenado descendentemente Z-A por PAÍS: " + Arrays.toString(paisesEuropeos));
                        JOptionPane.showMessageDialog(null,
                                "Comparaciones: " + comparaciones + "\nIntercambios: " + intercambios);
                        comparaciones = 0;
                        intercambios = 0;
                    }
                    case '3' -> {
                        salir = true;
                    }
                }
            }
        }

        public static void seleccion(Pais v[], int opcion) {
            Pais menor, mayor, aux;
            int pos;
            for (int i = 0; i < v.length - 1; i++) { // pasadas
                menor = v[i];
                mayor = v[i];
                pos = i;
                for (int j = i + 1; j < v.length; j++) { // comparaciones
                    if (opcion == 0 && v[j].getCapital().compareTo(menor.getCapital()) < 0) {
                        menor = v[j];
                        pos = j;
                    }

                    if (opcion == 1 && v[j].getNombre().compareTo(mayor.getNombre()) > 0) {
                        mayor = v[j];
                        pos = j;
                    }
                    comparaciones++;
                }
                if (pos != i) {
                    aux = v[i];
                    v[i] = v[pos];
                    v[pos] = aux;
                    intercambios++;
                }

            }

        }

    }