package Unidad4;

/**
 *
 *   CLASE APLICACION PARA MANEJAR UNA LISTA ENLAZADA
 *
 **/

import javax.swing.JOptionPane;

public class UsaMenu {

    public static void main(String args [ ]) {

        // DECLARACION DE VARIABLES

        int opcion, num, totalOpciones;

        // Crear una lista enlazada de Nodos

        ListaLineal lis = new ListaLineal();
        String d1;
        float d2;
        // VARIABLE String  DONDE SE VAN AGREGANDO LAS OPCIONES DEL MENU
        String menu = "             MENU DE OPCIONES \n";
        menu += "1. Insertar un nodo al inicio \n";
        menu += "2. Insertar un nodo al final\n";
        menu += "3.  Mostrar datos de la lista  \n";
        menu += "4.  Opcion 4 \n";
        menu += "5.  Salir \n";

        totalOpciones = 5;  // ACTUALIZAR SIEMPRE ESTA VARIABLE PARA AJUSTARSE AL TOTAL DE OPCIONES

        // CICLO ITERATIVO QUE PRESENTA EL MENU DE OPCIONES HASTA QUE EL USUARIO SELECCIONE LA OPCION Salir

        do {
            // SE CAPTURA DEL TECLADO UN ENTERO (NUMERO DE LA OPCION) SEGUN EL MENU PRESENTADO
            opcion = Integer.parseInt (JOptionPane.showInputDialog (menu));

            switch (opcion){
                case 1:
                    d1 = JOptionPane.showInputDialog("dato String del nodo: ");
                    d2 = Float.parseFloat(JOptionPane.showInputDialog("dato flotante del nodo"));
                    lis.insertaInicio(new Nodo(d1,d2));
                    break;
                case 2:
                    d1 = JOptionPane.showInputDialog("dato String del nodo: ");
                    d2 = Float.parseFloat(JOptionPane.showInputDialog("dato flotante del nodo"));
                    lis.insertarFinal(new Nodo(d1,d2));
                    break;
                case 3:
                    JOptionPane.showMessageDialog (null, lis.toString());
                    break;
                case 4:
                    JOptionPane.showMessageDialog (null, "Elegiste la opcion 4");
                    break;
                case 5:
                    JOptionPane.showMessageDialog (null, "Fin del Programa");
                    break;
                default:
                    JOptionPane.showMessageDialog (null, "Opción NO válida");
                    break;
            }  //  FIN DEL SWITCH

        } while (opcion != totalOpciones);   // FIN DEL DO..WHILE


    }  // FIN DEL METODO main

}  // FIN DE LA CLASE
