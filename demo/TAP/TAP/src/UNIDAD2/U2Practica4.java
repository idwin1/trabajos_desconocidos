package UNIDAD2;

import javax.swing.*;
import java.lang.reflect.Array;
import java.util.Arrays;

public class U2Practica4 {
    public static void main(String[] args) {
        int x, y;
        int[][] matriz = new int[2][2];
        String[] opciones = {"Generar Matriz", "Despliega Matriz", "Suma de elementos", "multiplicar matrices", "Terminar"};
        boolean salir = false;
        while (!salir) {
            String respuesta = (String) JOptionPane.showInputDialog(null, "Seleccione una opción", "Matrices Recursivas", JOptionPane.QUESTION_MESSAGE, null, opciones, 0);
            switch (respuesta) {
                case "Generar Matriz":
                    JLabel labelx = new JLabel("Filas");
                    JTextField tfx = new JTextField();
                    JLabel labely = new JLabel("Columnas");
                    JTextField tfy = new JTextField();
                    Object[] comp2 = {labelx, tfx, labely, tfy};
                    JOptionPane.showMessageDialog(null, comp2, "Generar Matriz", JOptionPane.QUESTION_MESSAGE, null);
                    x = Integer.parseInt(tfx.getText());
                    y = Integer.parseInt(tfy.getText());
                    matriz = new int[x][y];
                    llenaMatriz(matriz, 0, 0);
                    break;
                case "Despliega Matriz":
                    JOptionPane.showMessageDialog(null, despliegaMatriz(matriz, 0, 0));
                    break;
                case "Suma de elementos":
                    JOptionPane.showMessageDialog(null, sumaMatriz(matriz, 0, 0));
                    break;
                case "multiplicar matrices":
                    int tamaño = Integer.parseInt(JOptionPane.showInputDialog("ingrese el tamaño de la matriz"));
                    int[][] mult = new int[tamaño][tamaño];
                    int[][] a = new int[tamaño][tamaño];
                    int[][] b = new int[tamaño][tamaño];
                    llenaMatriz(a, 0, 0);
                    System.out.println(" matriz a\n " + despliegaMatriz(a, 0, 0));
                    llenaMatriz(b, 0, 0);
                    System.out.println(" matriz b\n " + despliegaMatriz(b, 0, 0));
                    mult(a, b, mult, 0, 0);
                    System.out.println(" matriz multi\n " + despliegaMatriz(mult, 0, 0));
                    //int[][] mult= new int[2][2];
                    //int[][] a={{2,4},{1,5}};
                    System.out.println(" matriz a\n " + despliegaMatriz(a, 0, 0));
                    //int[][] b={{4,7},{5,6}};
                    System.out.println(" matriz b\n " + despliegaMatriz(b, 0, 0));
                    mult(a, b, mult, 0, 0);
                    System.out.println(" matriz multi\n " + despliegaMatriz(mult, 0, 0));
                    break;
                case "Terminar":
                    salir = true;
            }
        }
    }

    public static void mult(int[][] a, int[][] b, int[][] multi, int fila, int columna) {
        if (fila == a.length || columna == a[fila].length) {
            return;
        } else {
            //System.out.println("fila :" + fila +"  columna:" + columna);
            multi[fila][columna] = suma(a, b, fila, columna, 0);
            //System.out.println("fila :" + fila +"  columna:" + columna);
            mult(a, b, multi, fila, columna + 1);
            mult(a, b, multi, fila + 1, 0);
        }
    }

    public static int suma(int[][] a, int[][] b, int fila, int columna, int var) {
        if (columna >= a.length || var >= a.length) {
            return 0;
        } else {
            //System.out.println("fila :" + fila +"  columna:" + columna);
            int sumaa = (a[fila][var] * b[var][columna]) + suma(a, b, fila, columna, var + 1);
            //System.out.println("suma:"+sumaa);
            return sumaa;
        }
    }

    public static void llenaMatriz(int[][] m, int fila, int columna) {
        if (fila == m.length || columna == m[fila].length) {
            return;
        } else {
            m[fila][columna] = 1 + (int) (Math.random() * 10);
            llenaMatriz(m, fila, columna + 1);
            llenaMatriz(m, fila + 1, 0);
        }
    }

    public static String despliegaMatriz(int [][] m,int fila, int columna){
        if(fila==m.length){
            return "";
        }
        if(columna==m[fila].length){
            return "\n" + despliegaMatriz(m, fila+1, 0);
        }else{
            return m[fila][columna] + " " + despliegaMatriz(m, fila, columna+1);
        }
    }

    public static int sumaMatriz(int [][] m,int fila, int columna){
        if(fila==m.length){
            return 0;
        }
        if(columna==m[fila].length){
            return sumaMatriz(m, fila+1, 0);
        }else{
            return m[fila][columna] + sumaMatriz(m, fila, columna+1);
        }
    }

}
