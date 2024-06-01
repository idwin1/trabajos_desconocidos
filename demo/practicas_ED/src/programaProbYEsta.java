import javax.swing.*;
import java.util.Arrays;

public class programaProbYEsta {
    public static double[] ma;
    public static int i,j,cont;
    public static void main(String[]args){
        ma =new double[]{2,3,.3,3.3,1.3,.4,.2,6,5.5,6.5,.2,2.3,1.5,4,5.9,1.8,4.7,.7,4.5,.3,1.5,.5,2.5,5,1,6,5.6,6,1.2,.2};

        ordenar(ma);
        System.out.println("mediana: "+mediana(ma));
        System.out.println("moda: "+moda(ma));
        System.out.println("media: " +media(ma));
        System.out.println(ma.length);
        System.out.println("varianza: " + varianza(ma));
        desviacion();
        talloHojas();

    }
    public static void talloHojas(){
        ordenar(ma);
        String tallo = "";
        String hojas = "";
        String frecuencia = "";
        int num =(int) ma[ma.length-1];
        for(i=0;i<num;i++){
            hojas +="\n|--------------------------|\n";
            cont=1;
            for(j=0;j<ma.length;j++){

                if(i==((int) ma[j])) {
                    if(cont ==1){
                        hojas += "  ";
                        cont++;
                    }

                    hojas += (Math.round((ma[j] - i) * 100.0) / 100.0) + ", ";
                }
                System.out.println(cont);

            }
            hojas += "|";

        }
        System.out.println(hojas);
    }
    public static void desviacion(){
        double desvi=0;
        desvi=Math.sqrt(varianza(ma));
        System.out.println("desviacion: "+desvi);
    }
    public static double varianza(double[] m){
        double varianza=0;
        double med = media(m);
        for(i=0;i<m.length;i++){
            varianza = varianza + (Math.pow((m[i]-med),2)) ;
        }
        varianza = varianza/m.length;
        return varianza;
    }
    public static void ordenar(double[] m){
        Arrays.sort(m);
        String s="";
        cont = 0;
        for(i=0;i<m.length;i++){
            if(cont==5){
                cont=0;
                s += "\n";
            }
            cont++;
            s += m[i]+", ";
        }
        JOptionPane.showMessageDialog(null,s);

    }
    public static double mediana(double[] m){
        double mediana = 0;
        Arrays.sort(m);
        if((m.length % 2) == 0){
            mediana = (m[(m.length/2)] + m[(m.length/2)-1])/2;
        }else {
            cont =(int)((m.length/2)+1);
            mediana = m[cont];
        }
        return mediana;
    }
    public static double moda(double[] m){
        double moda=0;
        int maximoNumRepeticiones= 0;
        for(int i=0; i<m.length; i++)
        {
            int numRepeticiones= 0;
            for(int j=0; j<m.length; j++)
            {
                if(m[i]==m[j])
                {
                    numRepeticiones++;
                }   //fin if
                if(numRepeticiones>maximoNumRepeticiones)
                {
                    moda= m[i];
                    maximoNumRepeticiones= numRepeticiones;
                }   //fin if
            }
        }
        return moda;
    }

    public static double media(double[] m){
        double media=0;
        for(i=0;i<m.length;i++) {
            media += m[i];

        }
        media = (media/m.length);
        return media;
    }
}
