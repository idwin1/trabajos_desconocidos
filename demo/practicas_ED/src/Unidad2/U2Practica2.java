package Unidad2;

import javax.swing.*;

public class U2Practica2 {
    public static void main(String[] args) {
        PilaString nombresAM = new PilaString(10);
        PilaString nombresNZ = new PilaString(10);
        boolean l = true;
        while (l){
            String[] opciones1 = {"Capturar un nombre", "Mostrar nombres de A a M", "Mostrar nombres de N a Z","Eliminar un nombre de A a M","Eliminar un nombre de N a Z","Salir"};
            String respuesta = (String) JOptionPane.showInputDialog(null, "¿Qué quieres hacer?",
                    "", JOptionPane.QUESTION_MESSAGE, null, opciones1, "Capturar un nombre");
            switch (respuesta){
                case "Capturar un nombre":
                    String n = JOptionPane.showInputDialog(null,"Nombre a insetar");
                    if(n.toUpperCase().charAt(0) >= 'A' && n.toUpperCase().charAt(0) <= 'M'){
                        insertar(nombresAM,n);
                    }else if(n.toUpperCase().charAt(0) >= 'N' && n.toUpperCase().charAt(0) <= 'Z'){
                        insertar(nombresNZ,n);
                    }
                    break;
                case "Mostrar nombres de A a M":
                    if(nombresAM.estaVacia())
                        JOptionPane.showMessageDialog(null, "Está vacía");
                    else
                        JOptionPane.showMessageDialog(null,"Cantidad de elementos: " + nombresAM.numElementos() + "\n" + nombresAM);
                    break;
                case "Mostrar nombres de N a Z":
                    if(nombresNZ.estaVacia())
                        JOptionPane.showMessageDialog(null, "Está vacía");
                    else
                        JOptionPane.showMessageDialog(null,"Cantidad de elementos: " + nombresNZ.numElementos() + "\n" + nombresNZ);
                    break;
                case "Eliminar un nombre de A a M":
                    JOptionPane.showMessageDialog(null, "Elemento eliminado: " + nombresAM.eliminar());
                    break;
                case "Eliminar un nombre de N a Z":
                    JOptionPane.showMessageDialog(null, "Elemento eliminado: " + nombresNZ.eliminar());
                    break;
                case "Salir":
                    l=false;
                    break;
            }
        }
    }

    public static void insertar(PilaString pila, String nombre){
        if(!pila.estaLlena()){
            pila.insertar(nombre);
        }
    }

}
