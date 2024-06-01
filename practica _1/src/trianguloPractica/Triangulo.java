package trianguloPractica;

public class Triangulo {
	
	private float lado1;
	private float lado2;
	private float lado3;
	
	public Triangulo() {	
		lado1 = lado2 = lado3 = 0;
	}
	
	public Triangulo(float lado1, float lado2, float lado3) {
		this.lado1 = lado1;
		this.lado2 = lado2;
		this.lado3 = lado3;
	}
	
	public Triangulo(float lados) {
		lado1 = lado2 = lado3 = lados;
	}

	public float getLado1() {
		return lado1;
	}

	public float getLado2() {
		return lado2;
	}

	public float getLado3() {
		return lado3;
	}

	public void setLado1(float lado1) {
		this.lado1 = lado1;
	}

	public void setLado2(float lado2) {
		this.lado2 = lado2;
	}

	public void setLado3(float lado3) {
		this.lado3 = lado3;
	}
	
	public String toString() {
		return "El triangulo tiene estas medida: " +
				"\nlado1 = " + lado1 +
				"\nlado2 = " + lado2 +
				"\nlado3 = " + lado3;
	}
	
	public float CalcularPerimetro() {
		 return (lado1 + lado2 +lado3 );
	}
	
	public float CalcularArea() {
		float semiperimetro = CalcularPerimetro()/2;
		float area =(float) Math.sqrt(semiperimetro*((semiperimetro-lado1)*(semiperimetro-lado2)*(semiperimetro-lado3)));
		return area;
	} 
	
	public String TipoDeTriangulo() {
		if((lado1 == lado2) && (lado3 == lado2)) {
			return "equilatero";
		}else if((lado1 != lado2) &&(lado2!=lado3)&&(lado1!=lado3)) {
			return "escaleno";
		}else if(((lado1 == lado2)&&lado3!=lado1)||((lado1==lado3)&&lado2!=lado1)||((lado2==lado3)&&lado1!=lado2)){
			return "isoceles";
		}
		return "";
	}
}
