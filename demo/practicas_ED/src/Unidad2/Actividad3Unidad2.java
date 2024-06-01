package Unidad2;

import javax.swing.*;

public class Actividad3Unidad2 {
    public static void main(String[] args) {
        float dato1 = 0f, dato2 = 0f;
        String expresion = JOptionPane.showInputDialog(null, "Ingrese la expresion");
        Pilafloat pila = new Pilafloat(expresion.length());
        for (int i = 0; i < expresion.length(); i++) {
            switch (prioridad(expresion.charAt(i))) {
                case 0:
                    pila.insertar(Float.parseFloat(String.valueOf(expresion.charAt(i))));
                    break;
                case 1:
                    dato1 = pila.eliminar();
                    dato2 = pila.eliminar();
                    pila.insertar(dato2 + dato1);
                    break;
                case 2:
                    dato1 = pila.eliminar();
                    dato2 = pila.eliminar();
                    pila.insertar(dato2 - dato1);
                    break;
                case 3:
                    dato1 = pila.eliminar();
                    dato2 = pila.eliminar();
                    pila.insertar(dato2 * dato1);
                    break;
                case 4:
                    dato1 = pila.eliminar();
                    dato2 = pila.eliminar();
                    pila.insertar(dato2 / dato1);
                    break;
                case 5:
                    dato1 = pila.eliminar();
                    dato2 = pila.eliminar();
                    pila.insertar((float) Math.pow(dato2, dato1));
                    break;
            }
        }
        JOptionPane.showMessageDialog(null, "Resultado en infijo" + pila.datoEnTope());
    }

    public static int prioridad(char c)
    {
        int regreso=0;
        String[] vector=new String[]{"+","-","*","/","^"};
        for(int i=0;i<vector.length;i++)
        {
            for (int j=0;j<vector[i].length();j++)
            {
                if(c==vector[i].charAt(j))
                {
                    regreso=(i+1);
                }
            }
        }
        return regreso;
    }
}
