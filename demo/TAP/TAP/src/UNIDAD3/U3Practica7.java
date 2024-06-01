package UNIDAD3;

import javax.swing.*;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.table.TableCellRenderer;
import javax.swing.JList;
import javax.swing.UIManager;
import java.awt.Component;

public class U3Practica7 {
    public static void main(String[] args) {
        boolean salir = false;
        String[][] Snacks =new String[][]{
                {"Crunch","Doritos","Bubaloo","Cocadas","Fritos"},
                {"KitKat","Chetoos","Trident","Palanquetas","Pringles"},
                {"Hersheys","Rufles Queso","Clorets","Jamoncillo","Totis"},
                {"Snickers","Fritos","Orbit","Glorias","Churumais"},
                {"Milky Way","Chips Jalapeño","Chicles","Quesabritas","Sunbites"},
                {"Carlos V","Tostitos","Mentos","Takis","Runners"},
                {"Fererro","Conchitas","Max air","Rancheritos","Prispas"},
                {"Kichs","sabritas","Bubli Bubli","Pake taxo","Papi ringas"},
        };
        while (!salir) {
            String[] opciones1 = {"1. Filas en orden Alfabetico", "2. Columnas en orden Alfabetico","3. Salir"};
            String respuesta = (String) JOptionPane.showInputDialog(null, "Que quieres hacer",
                    "", JOptionPane.QUESTION_MESSAGE, null, opciones1, 0);
            switch (respuesta) {
                case "1. Filas en orden Alfabetico":
                    String[] temps;
                    for(int i=0;i<Snacks.length;i++){
                        temps = new String[Snacks[i].length];
                        for(int j=0;j<Snacks[i].length;j++){
                            temps[j] = Snacks[i][j];
                        }
                        Binaria(temps);
                        Snacks[i]=temps;
                    }
                    mostrarMatriz(Snacks,"hola");
                    break;
                case "2. Columnas en orden Alfabetico":
                    String[] temp;
                    for(int i=0;i<Snacks[i].length;i++){
                        temps = new String[Snacks.length];
                        for(int j=0;j<Snacks.length;j++){
                            temps[j] = Snacks[j][i];
                        }
                        Binaria(temps);
                        for(int k=0;k<Snacks.length;k++){
                            Snacks[k][i]=temps[k];
                        }
                    }
                    mostrarMatriz(Snacks,"columnas");
                    break;
                case "3. Salir":
                    salir=true;
                    break;
            }
        }
    }
    public static void Mostrar(String[][] s){
        String s1="";
        for(int i = 0; i<s.length;i++){
            for(int j = 0;j<s[i].length;j++){
                s1 += s[i][j];
            }
            s1+="\n";
        }
    }
    public static void Binaria(String x[]){
        int i,j,izq,der,mitad;
        String temp;
        for(i=1;i<x.length;i++){
            temp=x[i];
            izq=0;
            der=i-1;
            while (izq<=der){
                mitad=((izq+der)/2);
                if(temp.compareToIgnoreCase(x[mitad])<=0){
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

    public static void mostrarMatriz(String[][] snacks, String tipo){
        MultiLineTableCellRenderer renderer = new MultiLineTableCellRenderer();
        String[] columnas = {"Columna 1", "Columna 2", "Columna 3", "Columna 4", "Columna 5"};
        JTable table = new JTable(snacks,columnas);
        table.setDefaultRenderer(String[][].class, renderer);
        table.setRowHeight(100);
        JOptionPane.showMessageDialog(null,  new JScrollPane(table), tipo, JOptionPane.INFORMATION_MESSAGE);
    }
}

class MultiLineTableCellRenderer extends JList<String> implements TableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        //make multi line where the cell value is String[]
        if (value instanceof String[]) {
            setListData((String[]) value);
        }
        //cell backgroud color when selected
        if (isSelected) {
            setBackground(UIManager.getColor("Table.selectionBackground"));
        } else {
            setBackground(UIManager.getColor("Table.background"));
        }
        return this;
    }
}

