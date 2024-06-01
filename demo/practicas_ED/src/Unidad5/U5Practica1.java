package Unidad5;

import Unidad4.ListaCircularPartidos;

import javax.swing.*;

public class U5Practica1 {
    public static void main(String[] args) {
        ArbolBinarioArticulos tienda = new ArbolBinarioArticulos();
        boolean salir = false;
        while (!salir) {
            String[] opciones1 = {"1. Insertar un artículo", "2. Recorrido Inorden ", "3. Recorrido Preorden", "4. Inventario total","5. Aumentar precio","6. Terminar"};
            String respuesta = (String) JOptionPane.showInputDialog(null, "Que quieres hacer",
                    "", JOptionPane.QUESTION_MESSAGE, null, opciones1, 0);
            switch (respuesta){
                case "1. Insertar un artículo":
                    String des = JOptionPane.showInputDialog("inserte la descripcion del articulo","descripcion");
                    int can = Integer.parseInt(JOptionPane.showInputDialog("inserte la cantidad de articulos","cantidad"));
                    float pre = Float.parseFloat(JOptionPane.showInputDialog("inserte el precio por articulo","Precio"));
                    tienda.insertarNodo(new NodoArticuloArbolBin(des,can,pre));
                    break;
                case "2. Recorrido Inorden ":
                    JOptionPane.showMessageDialog(null,tienda.inorden(tienda.getRaiz()));
                    break;
                case "3. Recorrido Preorden":
                    JOptionPane.showMessageDialog(null,tienda.preorden(tienda.getRaiz()));
                    break;
                case "4. Inventario total":
                    JOptionPane.showMessageDialog(null,tienda.inventario(tienda.getRaiz()));
                    break;
                case "5. Aumentar precio":
                    tienda.aumentarPrecio(tienda.getRaiz());
                    break;
                case "6. Terminar":
                    salir = true;
                    break;
            }
        }
    }
}
