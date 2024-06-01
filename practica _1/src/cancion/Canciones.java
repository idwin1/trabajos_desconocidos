package cancion;

import javax.swing.JOptionPane;

public class Canciones {

	public static void main(String[] args) {
		int tamaño=4;
		Cancion playlist[] = new Cancion[tamaño]; //a)
		playlist[0] = new Cancion("In the End","Link Park",3.37f);  //b)
	
		for(int i=1;i<tamaño;i++) { //c)
			String nombreCan = JOptionPane.showInputDialog(null,"escriba el nombre de la cancion");
			String artista = JOptionPane.showInputDialog(null,"escriba el nmbre del artista");
			float duracion = Float.parseFloat(JOptionPane.showInputDialog(null,"duracion de la cancion"));
			playlist[i] = new Cancion(nombreCan,artista,duracion);
		}
		
		playlist[3].setDuracion(4.15f); //d)
		
		for(int i=0;i<tamaño;i++) {
			if(playlist[i].getInterprete().equalsIgnoreCase("Morat")) {
				JOptionPane.showMessageDialog(null, playlist[i]);
			}
		}
		int mayor=0;
		for(int i=0;i<tamaño;i++) {
			if(playlist[i].getDuracion()>playlist[mayor].getDuracion()) {
				mayor=i;
			}
		}
		float mayorDur = playlist[mayor].getDuracion();
		for(int i=0;i<tamaño;i++) {
			if(playlist[0].getDuracion()==mayorDur) {
				JOptionPane.showMessageDialog(null, playlist[i].toString());
			}
		}

	}

}
