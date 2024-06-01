package matrices;


import javax.swing.JOptionPane;

/**
 * @author 
 * manejo de una matriz de enteros
 */
public class Practica_3 {

	public static int m[][], i, j;  // solo se declara la matriz
	  
	  public static void main (String arg[]){
	    m = new int [3][10];   // crea una matriz rectangular
	    // asignar valores mediante codigo
	    for (i = 0; i < m.length; i++)
	       for (j = 0; j < m[i].length; j++) 
	          m[i][j] = 10 + i + j;
	   // JOptionPane.showMessageDialog (null, Arrays.deepToString(m));
	    despliega();
	    m = new int [2][2]; //crea matriz cuadrada
	    captura();
	    despliega();
	    m = new int[][] { {1,2,3},    // crea una matriz irregular
	                      {4},
	                      {5,6,7,8},
	                      {9,} };
	    despliega ();
	  }
	  
	  public static void captura () {
	    for (i = 0; i < m.length; i++) 
	       for (j = 0; j < m[i].length; j++) 
	          m[i][j] = Integer.parseInt (
	             JOptionPane.showInputDialog("Valor ["+ i +"]["+j+"] :"));
	    } 
	    
	  public static void despliega () {
	    // despliegue matricial
	    String s = "Despliegue matricial\n\n";
	    for (i = 0; i < m.length; i++) {
	       for (j = 0; j < m[i].length; j++) 
	          s+= m[i][j] + "   ";
	       s += "\n";   
	    }
	    JOptionPane.showMessageDialog (null, s);}

}
