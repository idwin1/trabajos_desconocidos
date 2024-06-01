package UNIDAD2;

import javax.swing.*;

public class appRecirsivos {
    public static void main(String[] args) {
        int i,ini,fin,suma=0;
        ini=Integer.parseInt(JOptionPane.showInputDialog("valor inicial para sumar"));
        //fin=Integer.parseInt(JOptionPane.showInputDialog("valor final para sumar"));
        //suma iterativa
       /* for(i=ini;i<=fin;i++){
            suma+=i;
        }*/
       // System.out.println("suma iterativa entre " + ini + " y "+fin+" es "+ suma);
        //System.out.println("suma recursiva entre " + ini + " y "+fin+" es "+ sumaRecusriva(ini,fin));
        System.out.println("el numero es: " + ini +"   resultado: " + ConvBin(ini));
        String s = ConvBin(ini);
        System.out.println("el numero es: " + ConvBin(ini) + "  resultado " +conDes(s,0,s.length()-1) );
    }

    public static int sumaRecusriva(int ini,int fin){
        if(ini==fin){
            return fin;
        }else
            return ini+sumaRecusriva(ini+1,fin);
    }

    public static String ConvBin(int i){
        if(i/2 ==0 ){
            return i%2+"";
        }
        return ConvBin(i/2) + i%2;
    }

    public static int conDes(String s,int pos,int elevar){
        if(pos<s.length()){
            if(s.charAt(pos)=='1'){
                //int sum=((int) Math.pow(elevar,2) + conDes(s,pos+1,elevar-1));
                return ((int) Math.pow(elevar,2) + conDes(s,pos+1,elevar-1));
            }
            return conDes(s,pos+1,elevar-1);
        }
        return 0;
    }
}
