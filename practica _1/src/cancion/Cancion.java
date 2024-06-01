package cancion;

public class Cancion {
	private String nombre;
	private String interprete;
	private float duracion;
	
	public Cancion() {
		
	}

	public Cancion(String nombre, String interprete, float duracion) {
		this.nombre = nombre;
		this.interprete = interprete;
		this.duracion = duracion;
	}

	public String getNombre() {
		return nombre;
	}

	public String getInterprete() {
		return interprete;
	}

	public float getDuracion() {
		return duracion;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setInterprete(String interprete) {
		this.interprete = interprete;
	}

	public void setDuracion(float duracion) {
		this.duracion = duracion;
	}
	
	public String toString() {
		return "Cancion: " + getNombre() +
				"Interprete: " + getInterprete() +
				"Duracion: " + getDuracion();
		
	}
	
	
}
