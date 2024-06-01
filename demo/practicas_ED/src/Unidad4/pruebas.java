package Unidad4;

import javax.swing.*;

public class pruebas {
    public static void main(String[] args) {

        ListaCircular c = new ListaCircular();
        boolean salir = false;
        while (salir == false) {
            String[] opciones = {"1. Insertar un articulo alfabeticamente", "2.INSERTAR INICIO","3. Terminar","4. Mostrar","5"};
            String respuesta = (String) JOptionPane.showInputDialog(null, "Que quieres hacer", "Menu",
                    JOptionPane.QUESTION_MESSAGE, null, opciones, 0);
            switch (respuesta) {
                case "1. Insertar un articulo alfabeticamente":
                    String desc = JOptionPane.showInputDialog("descripcion", "inserte la descripcion");
                    float pre = Float.parseFloat(JOptionPane.showInputDialog(null, "inserte el precio"));
                    c.insertarFinal(new Nodo(desc,pre));
                    break;
                case "2.INSERTAR INICIO":
                    desc = JOptionPane.showInputDialog("descripcion", "inserte la descripcion");
                    pre = Float.parseFloat(JOptionPane.showInputDialog(null, "inserte el precio"));
                    c.insertaInicio(new Nodo(desc,pre));
                    break;
                case"3. Terminar":
                    salir = true;
                    break;
                case "4. Mostrar":
                    JOptionPane.showMessageDialog(null,c.toString());
                    break;
                case "5":
                    JOptionPane.showMessageDialog(null,c.eliminarX(JOptionPane.showInputDialog("ingrese dato1")));
                    break;
            }
        }
    }
}
