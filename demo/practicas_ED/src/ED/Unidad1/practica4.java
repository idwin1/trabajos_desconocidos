package ED.Unidad1;

import javax.swing.*;
import java.util.Arrays;

public class practica4 {
    public static String v[];
    public static char mc1[][];
    public static int i,j;
    public static char mc2[][];
    public static char alf[]=new char[]{'a','b','c','d','e','f','g','h','i','j','k','l','m',
            'n','o','p','q','r','s','t','u','v','w','x','y','z'};

    public static void main(String[] args){
        v = new String[5];
        int n = 0;
        mc1 = new char[5][];
        mc2 = new char[5][];

        for (int i = 0; i < mc1.length; i++) {
            String s = JOptionPane.showInputDialog(null,"cadena" + (i+1));
            mc1[i] = new char[s.length()];
            mc2[i] = new char[s.length()];
            for (int j = 0; j < s.length(); j++) {
                mc1[i][j] = s.charAt(j);
                mc2[i][j] = s.charAt(j);
            }
        }
        //despliega(mc1);
        //acomodarPalabras();
        //despliega(mc2);
        //acomodarPalbras2(mc1);
        acomodarPalbras3(mc2);
        despliega(mc2);
    }
    public static void acomodarPalabras(){
        for(i=0;i<mc2.length;i++){
            for (j=0;j<mc2[i].length;j++){
                Arrays.sort(mc2[i]);
            }
        }
    }

    public static void despliega(char[][] m){
        String s = "";
        for (int i = 0; i < m.length ; i++) {
            for (int j = 0; j < m[i].length; j++) {
                s+= m[i][j] + ",";
            }
            s+= "\n";
        }
        JOptionPane.showMessageDialog(null,s);
    }

    public static void acomodarPalbras2(char[][] m){
        char aux = 'a';
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                if(m[i][j] <= aux){
                    aux = m[i][j];
                    m[i][j] = aux;
                }
            }
        }
        JOptionPane.showMessageDialog(null,Arrays.deepToString(m));
    }
    public static void acomodarPalbras3(char[][] m){
        boolean bo = false;
        int cont;
        int tot;
        char aux;
        while(bo ==false){
            cont=0;
            tot=0;
            for(i=0;i< m.length;i++){
                for(j=0;j<m[i].length-1;j++) {
                    if (m[i][j] > m[i][j + 1]) {
                        aux = m[i][j];
                        m[i][j] = m[i][j + 1];
                        m[i][j + 1] = aux;
                    } else {
                        cont++;
                    }
                }
                cont++;
                tot += m[i].length;
            }
            if(cont== tot){
                bo = true;
            }

        }
    }

}
