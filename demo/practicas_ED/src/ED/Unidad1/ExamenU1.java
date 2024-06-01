package ED.Unidad1;

import javax.swing.*;
import java.util.Random;

import static java.lang.Float.valueOf;


public class ExamenU1 {
   public static void main(String[]args){
      // int tamaño = Integer.parseInt(JOptionPane.showInputDialog("cuantos libros quieres guardar"));
       Libro[] arreglo = new Libro[50];
       boolean salir = false;
       int conti=0;


       while (salir == false) {

           String[] opciones1 = {"Capturar un libro", "Mostrar datos de libro ", "sumar precios", "Aumentar precios(15% a libros >100)", "manejo de una matriz", "terminar"};
           String respuesta = (String) JOptionPane.showInputDialog(null, "Que quieres hacer",
                   "", JOptionPane.QUESTION_MESSAGE, null, opciones1, "Capturar un libro");
           if(respuesta.equals("Capturar un libro")){
               conti++;
               System.out.println(conti);

           }
           switch (respuesta) {
               case "Capturar un libro":
                   String titulo="";
                   String autor="";
                   float precio=0;
                   if(conti<arreglo.length){
                       titulo=JOptionPane.showInputDialog(null,"nombre del libro");
                       autor=JOptionPane.showInputDialog(null,"nombre del autor");
                       precio = valueOf(JOptionPane.showInputDialog(null,"precio"));
                       JOptionPane.showMessageDialog(null,conti);
                       int contaux = conti-1;
                       arreglo[contaux] = new Libro(titulo,autor,precio);
                       System.out.println(conti-1);
                   }
                   break;
               case "Mostrar datos de libro ":
                  // int numero = Integer.parseInt(JOptionPane.showInputDialog(null,"numero del libro"));
                  /* String s="Titulo: ";
                   s+= arreglo[numero].getTitulo();
                   s+="\nAutor: "+ arreglo[numero].getAutor();
                   s+= "\nPrecio: "+arreglo[numero].getPrecio();
                   JOptionPane.showMessageDialog(null,s);*/
                   /*String s = "";
                   s = arreglo[numero].toString();
                   JOptionPane.showMessageDialog(null,s);*/
                   String nombreLi = JOptionPane.showInputDialog(null,"ingrese el nombre del libro");
                   for(int i=0;i<arreglo.length;i++){

                   }
                   break;
               case "terminar":
                   salir = true;
                   break;
               case "sumar precios":
                   for (int i=0;i<conti;i++){
                       float suma=0;
                       suma = suma + arreglo[i].getPrecio();
                   }
                   break;
               case "Aumentar precios(15% a libros >100)":
                   for (int i=0;i<conti;i++){
                       if(arreglo[i].getPrecio()>100){
                           float aumento=0;
                           aumento = arreglo[i].getPrecio() *.15f;
                           aumento = aumento + arreglo[i].getPrecio();
                           arreglo[i].setPrecio(aumento);
                       }
                   }
                   break;
               case "manejo de una matriz":
                   int n = Integer.parseInt(JOptionPane.showInputDialog(null,"ingrese el tamaño de la matriz"));
                   int[][] m = new int[n][n];
                   Random ran = new Random();
                   for (int i=0 ; i<m.length;i++){
                       for(int j =0; j<m[i].length;j++){
                           m[i][j]=ran.nextInt(-5, 10);
                       }
                   }
                   despliega(m,"matriz");
                   metodoB(m);

                   break;

           }
       }
   }

    public static void despliega(int[][] m, String titulo){
        String s = titulo + " \n\n";
        for (int i = 0; i < m.length ; i++) {
            for (int j = 0; j < m[i].length; j++) {
                s+= m[i][j] + ",";
            }
            s+= "\n";
        }
        JOptionPane.showMessageDialog(null,s);
    }
    public static void metodoB(int[][] m){

        int i,j;
        int cont = 1;
        int z = 1;
        boolean l = true;
        int suma=0;
        j = 0;
        while(l){
            i=0;
            for(j=z;j<m[i].length;j++){
                suma =m[i][j];

               /* System.out.println("numero en i: " + i);
                System.out.println("numero en j: "+j);
                System.out.println("nume:" + m[i][j]);
                System.out.println(m[0][4]);*/
                if(i!= m.length){
                    i++;
                }
                if(m[0][(m.length-1)]!=0){
                    l=false;
                    JOptionPane.showMessageDialog(null,suma);
                    break;
                }

            }

            z++;
        }

    }

}

