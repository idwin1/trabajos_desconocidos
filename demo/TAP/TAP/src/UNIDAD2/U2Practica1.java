package UNIDAD2;

import javax.swing.*;

public class U2Practica1 {
    public static void main(String[] args){
        boolean salir = false;
        while (!salir) {
            String[] opciones1 = {"1. Maximo comun divisor de 2 enteros", "2. Multiplicar campesino egipcio", "3. Salir"};
            String respuesta = (String) JOptionPane.showInputDialog(null, "Que quieres hacer",
                    "", JOptionPane.QUESTION_MESSAGE, null, opciones1, 0);
            switch (respuesta) {
                case "1. Máximo común divisor de 2 enteros":
                    int i = Integer.parseInt(JOptionPane.showInputDialog("inserte el primer numero"));
                    int j= Integer.parseInt(JOptionPane.showInputDialog("inserte el segundo numero"));
                    JOptionPane.showMessageDialog(null,"el mcd es: "+mcd(i,j));
                    break;
                case "2. Multiplicar campesino egipcio":
                     i = Integer.parseInt(JOptionPane.showInputDialog("inserte el primer numero"));
                     j= Integer.parseInt(JOptionPane.showInputDialog("inserte el segundo numero"));
                    JOptionPane.showMessageDialog(null,"el mcd es: "+multCampesino(i,j));
                    break;
                case  "3. Salir":
                    salir=true;
                    break;
            }
        }
    }


	public static int mcd(int a, int b) {
        if(b>0){
            return mcd(b, a%b);
        } else
        	return a;
    }

    public static int multCampesino(int p, int q){
        if(q==0){
            return 0;
        }else if(q==1){
            return p;
        }else if(q>=2 && q%2==0){
            return multCampesino(2*p, q/2);
        }else if(q>=2){
            return multCampesino(2*p, q/2) + p;
        }

        return 0;
    }
}
