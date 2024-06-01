package ED.Unidad1;

import javax.swing.*;
import java.util.Random;

public class practica3 {
    public static int i,j;
    public static String s;
    public static void main(String[] args) {
        int[][] m = new int[3][3];
        m=generaMatriz(m);
        cambiarColumnas(m,0,2);
    }
    public static void cambiarColumnas(int[][] a, int n,int m){
        int [] v = new int[a.length];
        for(i=0;i<a.length;i++){
            v[i] = a[i][n];
            a[i][n]= a[i][m];
        }
        //for(i=0;i<a.length;i++){
          //  a[i][n] =a[i][m] ;
        //}
        for(i=0;i<a.length;i++){
            a[i][m] = v[i];
        }
        s = "";
        for(i=0;i<a.length;i++){
            for(j=0;j<a[i].length;j++){
                s += a[i][j] +", ";
            }
            s += "\n";
        }
        JOptionPane.showMessageDialog(null,s);
    }

    public static int[][] generaMatriz(int[][]m){
        Random ran = new Random();
        for (i = 0;i  <m.length ; i++) {
            for (j = 0; j < m[i].length; j++) {
                m[i][j] = ran.nextInt(-50, 50);
            }
        }
        String s = "";
        for(i=0;i<m.length;i++){
            for(j=0;j<m[i].length;j++){
                s += m[i][j] + ", ";
            }
            s += "\n";
        }
        JOptionPane.showMessageDialog(null,s);
        return m;
    }

}

