package Unidad5;

import javax.swing.*;

public class EjemploRecursivo {
    public static void main(String[] args) {
        int n;
        n=Integer.parseInt(JOptionPane.showInputDialog("Valor n"));
        int s=sumaRecursiva(n);
        imprimeParesRecursivos(n);
        JOptionPane.showMessageDialog(null,s);
    }

    public static int sumaRecursiva(int n){
        if(n==0)
            return 0;
        return n + sumaRecursiva(n-1);
    }
    public static void imprimeParesRecursivos(int n) {
        if (n <= 0)
            return;
        if (n % 2 == 0)
            System.out.println(n);
        imprimeParesRecursivos(n - 1);
    }
}
