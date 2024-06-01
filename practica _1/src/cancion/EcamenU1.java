package cancion;

import javax.swing.JOptionPane;

public class EcamenU1 {
	public static void main(String[]args) {
		int tamaño = Integer.parseInt(JOptionPane.showInputDialog("¿Cuantas figuras quieres guardar?"));
	    Libro[] arreglo = new Libro[tamaño];
	    boolean salir = false;
	    String[] opciones = {"","","",""};

	    String[] opciones1 = {"Capturar un libro","Mostrar datos de libro ","sumar precios","Aumentar precios(15% a libros >100)","manejo de una matriz","terminar"};
	    String respuesta =(String) JOptionPane.showInputDialog(null, "Que quieres hacer",
	            "", JOptionPane.QUESTION_MESSAGE, null, opciones1, "llenar lista");
	    
	    switch (respuesta) {
		case "llenar lista":
			
			break;

	}
}
}
	
