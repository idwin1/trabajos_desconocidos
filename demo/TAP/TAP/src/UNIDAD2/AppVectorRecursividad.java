package UNIDAD2;

import javax.swing.*;
import java.util.Arrays;

public class AppVectorRecursividad {
    public static void main(String[] args) {
        int n = Integer.parseInt(JOptionPane.showInputDialog("tamaño delvector: "));
        int[] vector = new int[n];
        llenarVector(vector,0);
        System.out.println("vector genereado: "+ Arrays.toString(vector));
       /* imprimirVector(vector,0);
        System.out.println("inverso");
        imprimirVectorInverso(vector, vector.length-1);
        System.out.println("suma:" + sumarVector(vector,0));
        System.out.println("numero mayor" +numeroMayor(vector,0,0));*/
        //System.out.println("vector genereado: "+ Arrays.toString(vector));
        invertir(vector,0,vector.length-1);
        System.out.println("vector genereado inverso: "+ Arrays.toString(vector));
    }
    public static void imprimirVectorInverso(int v[], int indice){
        if(indice<0)
            return;
        System.out.println(v[indice]);
        imprimirVectorInverso(v,indice-1);
    }
    public static void imprimirVector(int v[], int indice){
        if(indice>=v.length)
            return;
        System.out.println(v[indice]);
        imprimirVector(v,indice+1);
    }
    public static void llenarVector(int v[], int indice) {
        if (indice == v.length)
            return;
        else
            v[indice] = (int) (Math.random() * 100);
        llenarVector(v, indice + 1);
    }

    public static int sumarVector(int v[], int indice) {
        if (indice >= v.length){
            return 0;
        }
        return v[indice]+sumarVector(v,indice+1);
    }

    public static int numeroMayor(int v[], int indice,int m){
        if (indice >= v.length){
            return m;
        }
        if(m<v[indice])
            m=v[indice];
        return numeroMayor(v,indice+1,m);
    }

    public static void invertir(int v[], int indiceIn,int indiceF){
        if(indiceIn>(indiceF/2)){
            return;
        }
        int in=v[indiceIn];
        v[indiceIn]=v[indiceF];
        v[indiceF]=in;
        invertir(v,indiceIn+1,indiceF-1);
    }
}
