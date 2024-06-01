package trianguloPractica;

/**
 * @author idwin
 *ejemplo del uso de objetos Triangulo
 */
public class practica1 {

	public static void main(String[] args) {
		Triangulo tri;	//declara el 1er objeto
		Triangulo tri2 = new Triangulo(); // declara y crea el 2do objeto
		tri = new Triangulo(8.7f); //crear el 1er objeto
		System.out.println("1er triangulo: \n" 
							+ tri.toString());	//mostrar el 1er objeto
		
		System.out.println("1er triangulo despues de modificar el lado 3: \n" 
							+ tri.toString());
		System.out.println("2do triangulo: \n" 
							+ tri2.toString());
		System.out.println("area de 1er triangulo: " + tri.CalcularArea());
		System.out.println("perimetro del 2do triangulo: " + tri2.CalcularPerimetro());
	}

}
