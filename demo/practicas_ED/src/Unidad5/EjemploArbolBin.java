package Unidad5;

import javax.swing.*;

public class EjemploArbolBin {
    public static void main(String[] args) {
        int opcion,num;
        String d1;
        float d2;
        ArbolBinario tree = new ArbolBinario();
        String menu = "     MENU DE OPCIONES\n";
        menu += "1\n";
        menu += "2\n";
        menu += "3\n";
        menu += "4\n";
        opcion = 0;
        while (opcion!=5){
            opcion = Integer.parseInt(JOptionPane.showInputDialog(menu));
            switch (opcion){
                case 1:
                    d1=JOptionPane.showInputDialog("DATO STRING NODO");
                    tree.insertarNodo(new NodoArbolBin(d1));
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null,tree.preorden(tree.getRaiz()));
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null,tree.inorden(tree.getRaiz()));
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null,tree.postorden(tree.getRaiz()));
                    break;
                case 5:
                    JOptionPane.showMessageDialog(null,"Fin del programa");
                    break;
            }
        }

    }

}
