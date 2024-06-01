package trianguloPractica;

import javax.swing.JOptionPane;

public class practica2 {

	public static void main(String[] args) {
		Triangulo arrTriangulos[] = new Triangulo[10]; //declaro y creo el vector de tringulos
		arrTriangulos[9] = new Triangulo(); //b) Crear el triángulo de la última casilla con el primer constructor
		for(int i=0;i<4;i++) { //c) Los triángulos de las primeras 4 casillas se construyen con datos leídos del
			         		  //teclado (obviamente, usaremos el 2do. constructor).
			JOptionPane.showMessageDialog(null,"Triangulo " + (i+1));
			int lado1=Integer.parseInt(JOptionPane.showInputDialog("ingrese el primer lado"));
			int lado2=Integer.parseInt(JOptionPane.showInputDialog("ingrese el segundo lado"));
			int lado3=Integer.parseInt(JOptionPane.showInputDialog("ingrese el tercer lado"));
			arrTriangulos[i] = new Triangulo(lado1, lado2, lado3); 
		}
		
		arrTriangulos[8] = new  Triangulo(arrTriangulos[0].getLado1(), //d) Para el triángulo de la penúltima casilla se crea un NUEVO OBJETO, pero con
										  arrTriangulos[0].getLado2(), //LOS MISMOS DATOS del primer triángulo (índice [0])
										  arrTriangulos[0].getLado3());
		for(int i=0;i<10;i++) { //e) Desplegar en pantalla de cada triángulo que hay actualmente en el vector:
			if(arrTriangulos[i]!=null) {
				System.out.println("Triangulo:"+(i+1));
				System.out.println(arrTriangulos[i].toString());
				System.out.println("Area:"+ arrTriangulos[i].CalcularArea());
				System.out.println("Perimetro:"+ arrTriangulos[i].CalcularPerimetro());
				System.out.println("Tipo de Triangulo: " + arrTriangulos[i].TipoDeTriangulo());
				System.out.println();
			}
			
		}
	}

}
