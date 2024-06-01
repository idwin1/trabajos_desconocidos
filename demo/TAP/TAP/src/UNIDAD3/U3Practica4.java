package UNIDAD3;

import javax.swing.*;
import java.util.Arrays;

public class U3Practica4 {
    public static void main(String[] args) {
        boolean salir = false;
        while (!salir) {
            Pais[] paises ={ new Pais("Chipre", "Nicosia"), new Pais("Eslovenia", "Liubliana"),
                    new Pais("Albania", "Tirana"), new Pais("Hungría", "Budapest"), new Pais("Islandia", "Reikiavik"),
                    new Pais("Irlanda", "Dublín"), new Pais("Alemania", "Berlín"),
                    new Pais("Andorra", "Andorra la Vella"), new Pais("Bélgica", "Bruselas"),
                    new Pais("Bosnia y Herzegovina", "Sarajevo"), new Pais("Croacia", "Zagreb"),
                    new Pais("Bulgaria", "Sofía"), new Pais("Dinamarca", "Copenhague"), new Pais("Estonia", "Tallin"),
                    new Pais("Finlandia", "Helsinki"), new Pais("Francia", "París"), new Pais("Grecia", "Atenas"),
                    new Pais("Austria", "Viena"), new Pais("Eslovaquia", "Bratislava"), new Pais("España", "Madrid") };
            /*Pais[] paises = {
                    new Pais("España", "Madrid"),
                    new Pais("Francia", "París"),
                    new Pais("Alemania", "Berlín"),
                    new Pais("Italia", "Roma"),
                    new Pais("Reino Unido", "Londres"),
                    new Pais("Rusia", "Moscú"),
                    new Pais("Turquía", "Ankara"),
                    new Pais("Suecia", "Estocolmo"),
                    new Pais("Noruega", "Oslo"),
                    new Pais("Suiza", "Berna"),
                    new Pais("Austria", "Viena"),
                    new Pais("Grecia", "Atenas"),
                    new Pais("Bélgica", "Bruselas"),
                    new Pais("Países Bajos", "Ámsterdam"),
                    new Pais("Portugal", "Lisboa"),
                    new Pais("Irlanda", "Dublín"),
                    new Pais("Dinamarca", "Copenhague"),
                    new Pais("Finlandia", "Helsinki"),
                    new Pais("Polonia", "Varsovia"),
                    new Pais("Ucrania", "Kiev")
            };*/
            String[] opciones1 = {"1. Alfabeto (A..Z) por capital", "2. Alfabeto inverso (Z..A) por pais", "3. Salir"};
            String respuesta = (String) JOptionPane.showInputDialog(null, "Que quieres hacer",
                    "", JOptionPane.QUESTION_MESSAGE, null, opciones1, 0);
            switch (respuesta) {
                case "1. Alfabeto (A..Z) por capital":
                    JOptionPane.showMessageDialog(null,"vector desordenado: \n" + Arrays.toString(paises));
                    JOptionPane.showMessageDialog(null, Seleccion(paises) + "\n vector organiado: \n" + Arrays.toString(paises));
                    break;
                case "2. Alfabeto inverso (Z..A) por pais":
                    JOptionPane.showMessageDialog(null,"vector desordenado: \n" + Arrays.toString(paises));
                    JOptionPane.showMessageDialog(null, SeleccionInversa(paises) + "\n vector organiado: \n" + Arrays.toString(paises));
                    break;
                case "3. Salir":
                    salir=true;
                    break;
            }
        }
    }

    /*public static String Seleccion(Pais p[]){
        Pais menor, mayor, aux;
        int pos,intercambios=0;
        for (int i = 0; i < p.length - 1; i++) { // pasadas
            menor = p[i];
            pos = i;
            for (int j = i + 1; j < p.length; j++) { // comparaciones
                if (p[j].getCapital().compareTo(menor.getCapital()) < 0) {
                    menor = p[j];
                    pos = j;
                }
            }
            if (pos != i) {
                aux = p[i];
                p[i] = p[pos];
                p[pos] = aux;
                intercambios++;
            }
        }
        return ""+intercambios;
    }*/
    public static String Seleccion(Pais p[]){
        int i,j,pos,comparaciones=0,intercambios=0;
        Pais aux,menor;
        for (i = 0 ; i < p.length - 1; i++){
            menor=p[i];
            pos=i;
            for (j = i + 1; j < p.length ; j++){
                comparaciones++;
                if(p[j].getCapital().compareToIgnoreCase(menor.getCapital())<0){
                    menor = p[j];
                    pos = j ;
                }
            }
            if(pos != i ){
                intercambios++;
                aux = p[i];
                p[i] = p[pos];
                p[pos] = aux;
            }
        }
        return "comparaciones: "+comparaciones +" intercambios: "+ intercambios;
    }

    public static String SeleccionInversa(Pais p[]){
        int i,j,pos,comparaciones=0,intercambios=0;
        Pais aux,menor;
        for (i=0;i<p.length-1;i++){
            menor=p[i];
            pos=i;
            for (j=i|+1;j<p.length;j++){
                comparaciones++;
                if(p[j].getNombre().compareToIgnoreCase(menor.getNombre())>0){
                    menor= p[j];
                    pos=j;
                }
            }
            if(pos!=i){
                intercambios++;
                aux=p[i];
                p[i]=p[pos];
                p[pos]=aux;
            }
        }
        return "comparaciones: "+comparaciones +" intercambios: "+ intercambios;
    }
}
