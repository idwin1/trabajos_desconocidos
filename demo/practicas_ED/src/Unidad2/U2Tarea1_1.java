package Unidad2;

import javax.swing.*;

public class U2Tarea1_1 {
    public static void main(String[] args) {
        String descripcion;
        int cantidad;
        float precio;
        PilaArticulo1 ferreteria = new PilaArticulo1(14);
        String opciones = "1. Insertar un artículo" + "\n2. Mostrar pila de artículos" + "\n3. Eliminar un artículo" + "\n4. Mostrar el total del inventario" +
                "\n5. Aumentar precio de todos los artículos" + "\n6. Buscar un artículo" + "\n7. Artículo más caro" +
                "\n8. Artículos con cantidad < 5" + "\n9. Vaciar la pila" + "\n10. Terminar";
        int opc = 0;
        while(opc !=10){
            opc = Integer.parseInt(JOptionPane.showInputDialog(null, opciones));
            switch (opc) {
                case 1:
                    if (!ferreteria.estaLlena()){
                        descripcion = JOptionPane.showInputDialog(null, "Descripción del artículo: ");
                        cantidad = Integer.parseInt(JOptionPane.showInputDialog("Cantidad: "));
                        precio = Float.parseFloat((JOptionPane.showInputDialog("Precio: ")));
                        ferreteria.insertar(descripcion, cantidad, precio);
                    }else {
                        JOptionPane.showMessageDialog(null,"la fereteria esta llena no se puede insertar",null,0);
                    }

                    break;
                case 2:
                    if (!ferreteria.estaVacia()) {
                        JOptionPane.showMessageDialog(null, ferreteria.toString());
                    } else {
                        JOptionPane.showMessageDialog(null, "La ferretaria esta vacia!");
                    }
                    break;
                case 3:
                    if (!ferreteria.estaVacia()) {
                        JOptionPane.showMessageDialog(null, "Artículo borrado" + "\n" + ferreteria.eliminar());
                    } else {
                        JOptionPane.showMessageDialog(null, "La ferretaria esta vacia!");
                    }
                    break;
                case 4:
                    if (!ferreteria.estaVacia()) {
                        ferreteria.calcularTotal();
                    } else {
                        JOptionPane.showMessageDialog(null, "La ferretaria esta vacia!");
                    }
                    break;
                case 5:
                    if (!ferreteria.estaVacia()) {
                        ferreteria.aumentarPrecio();
                    } else {
                        JOptionPane.showMessageDialog(null, "La ferretaria esta vacia!");
                    }
                    break;
                case 6:
                    if (!ferreteria.estaVacia()) {
                        descripcion = JOptionPane.showInputDialog(null, "Descripcion a buscar");
                        ferreteria.buscarArticulo(descripcion);
                    } else {
                        JOptionPane.showMessageDialog(null, "La ferretaria esta vacia!");
                    }
                    ;
                    break;
                case 7:
                    if (!ferreteria.estaVacia()) {
                        ferreteria.articuloMasCaro();
                    } else {
                        JOptionPane.showMessageDialog(null, "La ferretaria esta vacia!");
                    }
                    break;
                case 8:
                    if (!ferreteria.estaVacia()) {
                        ferreteria.articulosMenora5();
                    } else {
                        JOptionPane.showMessageDialog(null, "La ferretaria esta vacia!");
                    }
                    break;
                case 9:
                    if (!ferreteria.estaVacia()) {
                        ferreteria.vaciarPila();
                    } else {
                        JOptionPane.showMessageDialog(null, "La ferretaria esta vacia!");
                        break;
                    }
            }
        }
    }

}

