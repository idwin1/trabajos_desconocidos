package pruevas;

import javax.swing.JOptionPane;

public class U4Practica1 {

	    public static void main(String[] args) {

	        ListaArticulos c = new ListaArticulos();
	        boolean salir = false;
	        while (salir == false) {
	            String[] opciones = {"1. Insertar un articulo alfabeticamente","2. Mostrar lista de articulos","3. Eliminar ultimo articulo", "4. Terminar"};
	            String respuesta = (String) JOptionPane.showInputDialog(null, "Que quieres hacer", "Menu",
	                    JOptionPane.QUESTION_MESSAGE, null, opciones, 0);
	            switch (respuesta){
	                case"1. Insertar un articulo alfabeticamente":
	                    String desc = JOptionPane.showInputDialog("descripcion","inserte la descripcion");
	                    int cant = Integer.parseInt(JOptionPane.showInputDialog(null,"inserte la cantidad"));
	                    float pre = Float.parseFloat(JOptionPane.showInputDialog(null,"inserte el precio"));
	                    c.insertarAlfabeticamente(new NodoArticulo(desc,cant,pre));
	                    break;
	                case"2. Mostrar lista de articulos":
	                    JOptionPane.showMessageDialog(null,c.toString());
	                    break;
	                case"3. Eliminar ultimo articulo":
	                    break;
	                case"4. Terminar":
	                    salir=true;
	                    break;

	            }
	        }
	    }
	}

