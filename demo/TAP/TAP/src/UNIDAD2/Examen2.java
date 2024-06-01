package UNIDAD2;

import javax.swing.*;

public class Examen2 {
    public static void main(String[] args) {
        String[] opciones = {"Suma aritmetica", "binomial de newton", "Terminar"};
        boolean salir = false;
        while (!salir) {
            String respuesta = (String) JOptionPane.showInputDialog(null, "Seleccione una opción", "Matrices Recursivas", JOptionPane.QUESTION_MESSAGE, null, opciones, 0);
            switch (respuesta) {
                case "Suma aritmetica":
                    String s=JOptionPane.showInputDialog("ingrese el string que desea analizar");
                    JOptionPane.showMessageDialog(null,"su frase es: "+ s+"  y  la suma de los numeros es " + sumaAritmetica(s,0));
                    break;
                case "binomial de newton":
                    int n=Integer.parseInt(JOptionPane.showInputDialog("ingrese el primer numero"));
                    int k=Integer.parseInt(JOptionPane.showInputDialog("ingrese el segundo numero"));
                    JOptionPane.showMessageDialog(null,"los numeros fueron: "+ n + " y "+k + " el resultado es: " + newton(n,k) );
                    break;
                case "Terminar":
                    salir=true;
                    break;
            }
        }
    }

    public static int sumaAritmetica(String s,int i){
        if(i<=s.length()-1){
            if(s.charAt(i)=='0'||s.charAt(i)=='1'||s.charAt(i)=='2'||s.charAt(i)=='3'||s.charAt(i)=='4'||s.charAt(i)=='5'||s.charAt(i)=='6'||s.charAt(i)=='7'||s.charAt(i)=='8'||s.charAt(i)=='9'){
                return Integer.parseInt((""+s.charAt(i))) + sumaAritmetica(s,i+1) ;
            }else if(i<=s.length()-1){
                return sumaAritmetica(s,i+1);
            }
        }
        return 0;
    }
    public static int newton(int n,int k){
        if(k==0||n==k){
            return 1;
        }else if(n>k && k>0){
            return newton(n-1,k) + newton(n-1,k-1);
        }
        return 0;
    }
}
