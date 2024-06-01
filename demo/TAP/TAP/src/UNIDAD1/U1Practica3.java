package UNIDAD1;

import javax.swing.*;

public class U1Practica3 {
    public static void main(String[] args) {
        Discos[] disc = new Discos[]{new Discos("comienza la dinastia",new fecha(26,8,2014),new String[]{"aprovechate de mi","Ella te engaña","EL bombon"}),
                new Discos("ozuTochi",new fecha(7,10,2022),new String[]{"Kotodama","Mañana","Favorita"}),
                new Discos("te Felicito",new fecha(21,04,2022),new String[]{"te Felicito"}),
                new Discos("De lo bueno, lo Mejor",new fecha(1,1,2013),new String[]{"la buena y la mala", "anestesiado","el bueno y el malo ", "antes del fin del mundo"})
        };
        boolean salir = false;
        while (!salir) {
            String[] opciones1 = {"1. mostrar discos", "2. discos lanzados en mm/aaaa", "3. buscar una cancion", "4.salir"};
            String respuesta = (String) JOptionPane.showInputDialog(null, "Que quieres hacer",
                    "", JOptionPane.QUESTION_MESSAGE, null, opciones1, 0);
            switch (respuesta) {
                case "1. mostrar discos":
                    String s="";
                    for (Discos l: disc) {
                        s += "\n"+l.toString();
                    }
                    JOptionPane.showMessageDialog(null,s);
                    break;
                case "2. discos lanzados en mm/aaaa":
                    int i = Integer.parseInt(JOptionPane.showInputDialog(null,"ingrese el mes de la cancion"));
                    int j =Integer.parseInt(JOptionPane.showInputDialog(null,"ingrese el año"));
                     s="Discos:";
                    for (Discos l: disc) {
                        if(l.getFechaLanzamiento().getMes() == i && l.getFechaLanzamiento().getAño() == j)
                                s+="\n"+ l.getTitulo();
                    }
                    JOptionPane.showMessageDialog(null,s);
                    break;
                case "3. buscar una cancion":
                    String buscar = JOptionPane.showInputDialog(null,"ingrese el nombre de la cancion");
                    j=0;
                    for (Discos l: disc) {
                        i=0;
                        for (String a: l.getCanciones()) {
                            if(a.equalsIgnoreCase(buscar)){
                                JOptionPane.showMessageDialog(null,"Disco: "+ l.getTitulo() + "\nposicion: " +(i+1));
                                j++;
                            }
                            i++;
                        }
                        j++;
                    }
                    if(j== disc.length){
                        JOptionPane.showMessageDialog(null,"Cacnion no encontrada");
                    }
                    break;
                case "4.salir":
                    salir=true;
                    break;
            }
        }
    }
}
