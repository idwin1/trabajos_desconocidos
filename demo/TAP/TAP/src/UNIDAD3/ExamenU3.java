package UNIDAD3;

import javax.swing.*;

public class ExamenU3 {
    public static void main(String[] args) {
        boolean salir = false;
        while (!salir) {
            Auto[] arr = new Auto[]{new Auto("ford lightning", 55), new Auto("Ford maberick", 100), new Auto("vocho", 900),
                    new Auto("Scape", 50), new Auto("Mustang", 98), new Auto("Porch", 75),
                    new Auto("audi", 77), new Auto("Camaro", 14), new Auto("supra", 88), new Auto("modelo 3", 10)};
            String[] opciones1 = {"1. Ordenar con Burbuja DESCENDENTE por KILOMETRAJE del auto", "2. Ordenar con Inserción Binaria ALFABÉTICAMENTE por MODELO del auto", "3. Salir"};
            String respuesta = (String) JOptionPane.showInputDialog(null, "Que quieres hacer",
                    "", JOptionPane.QUESTION_MESSAGE, null, opciones1, 0);
            switch (respuesta) {
                case "1. Ordenar con Burbuja DESCENDENTE por KILOMETRAJE del auto":
                    JOptionPane.showMessageDialog(null,mostrar(arr));
                    ordenarDesententeInterprete(arr);
                    JOptionPane.showMessageDialog(null,mostrar(arr));
                    break;
                case "2. Ordenar con Inserción Binaria ALFABÉTICAMENTE por MODELO del auto":
                    JOptionPane.showMessageDialog(null,mostrar(arr));
                    Binaria(arr);
                    JOptionPane.showMessageDialog(null,mostrar(arr));
                    break;
                case "3. Salir":
                    salir=true;
                    break;
            }
        }
    }
    public static String mostrar(Auto[] x){
        String s="";
        for(int i=0;i<=50 && i<x.length; i++){
            if(i%2==0){
                s+="\n" + x[i].toString()+",";
            }else {
                s+= x[i].toString()+",";
            }
        }
        return s;
    }

    public static void ordenarDesententeInterprete(Auto[] a){
        int n= a.length;
        Auto aux;
        for(int i=1;i<=n-1;i++){
            for(int j=0;j<n-i;j++) {
                if (a[j].getKm()< a[j + 1].getKm()) {
                    aux = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = aux;
                }
            }
        }
    }

    public static void Binaria(Auto x[]){
        int i,j,izq,der,mitad;
        Auto temp;
        for(i=1;i<x.length;i++){
            temp=x[i];
            izq=0;
            der=i-1;
            while (izq<=der){
                mitad=((izq+der)/2);
                if(temp.getModelo().compareToIgnoreCase(x[mitad].getModelo())<=0){
                    der=mitad-1;
                }
                else{
                    izq=mitad+1;
                }
            }
            j=i-1;
            while(j>=izq){
                x[j+1]=x[j];
                j=j-1;
            }
            x[izq]=temp;
        }
    }
}
