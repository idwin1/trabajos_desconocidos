package UNIDAD1;

import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.table.TableCellRenderer;
import javax.swing.JList;
import javax.swing.UIManager;
import java.util.Arrays;
import java.awt.Component;

public class prueba {
    private static int dineroCaja;
    public static void main(String[] args) {
        String[] opciones = {"Pedir snack", "Mostrar golosinas", "Dinero en caja","Rellenar snacks","Salir"};
        int eleccion,i,j;
        int cambio;
        boolean salir=false;
        dineroCaja = 100;
        Snack[][] snacks =new Snack[][]{
                {new Snack("Crunch",0), new Snack("Doritos",1), new Snack("Bubaloo",2)},
                {new Snack("KitKat",0),new Snack("Chetos",1),new Snack("Trident",2)},
                {new Snack("Hershey's",0),new Snack("Ruffles queso",1),new Snack("Clorets",2)},
                {new Snack("Snickers",0),new Snack("Fritos",1),new Snack("Orbits",2)},
                {new Snack("MilkyWay",0),new Snack("Chips jalapeño",1),new Snack("Chiclets",2)}};
        while(!salir){
            String respuesta = (String) JOptionPane.showInputDialog(null,"Seleccione una opción","Snacks", JOptionPane.QUESTION_MESSAGE, null, opciones, 0);
            switch (respuesta){
                case "Pedir snack":
                    eleccion = Integer.parseInt(JOptionPane.showInputDialog("Escriba la ubicación del snack"));
                    i=eleccion/10;
                    j=eleccion%10;
                    if(i<5 & j<3){
                        int precio = snacks[i][j].getPrecio();
                        int inventario = snacks[i][j].getInventario();
                        int dinero = Integer.parseInt(JOptionPane.showInputDialog(null, snacks[i][j].toString() + "\nInserte el dinero"));
                        JOptionPane.showMessageDialog(null, validacion(dinero, snacks[i][j]));
                    }else{
                        JOptionPane.showMessageDialog(null, "Posición no valida");
                    }
                    break;
                case "Mostrar golosinas":
                    String[][] maquina = new String[5][3];
                    for(i=0; i < snacks.length; i++){
                        for(j=0; j< snacks[i].length;j++){
                            maquina[i][j] = "<html>Nombre: " + snacks[i][j].getNombre() + "<br>Precio: " + snacks[i][j].getPrecio() + "<br>Inventario " + snacks[i][j].getInventario();
                        }
                    }
                    MultiLineTableCellRenderer renderer = new MultiLineTableCellRenderer();
                    String[] columnas = {"Chocolates", "Papitas", "Chicles"};
                    JTable table = new JTable(maquina,columnas);
                    table.setDefaultRenderer(String[][].class, renderer);
                    table.setRowHeight(100);
                    JOptionPane.showMessageDialog(null, new JScrollPane(table));
                    break;
                case "Dinero en caja":
                    JOptionPane.showMessageDialog(null, "El dinero disponible actualmente en caja es de $" + dineroCaja);
                    break;
                case "Rellenar snacks":
                    JLabel labelPwd  =new JLabel("Contraseña");
                    JPasswordField pwdFld = new JPasswordField(5);
                    Object[] comp = {labelPwd, pwdFld};
                    JOptionPane.showMessageDialog(null, comp, "Escriba la contraseña", JOptionPane.QUESTION_MESSAGE,null);
                    char[] contraseña = {'D','e','l','i','S','n','a','c','K'};
                    if(pwdFld.getPassword().length!=contraseña.length){
                        JOptionPane.showMessageDialog(null, "Contraseña incorrecta");
                    }else{
                        if(Arrays.equals(contraseña,pwdFld.getPassword())){
                            JLabel labelPos = new JLabel("Posición");
                            JTextField tfPos = new JTextField();
                            JLabel labelCant = new JLabel("Cantidad");
                            JTextField tfCantidad  =new JTextField();
                            Object[] comp2 = {labelPos, tfPos, labelCant, tfCantidad};
                            JOptionPane.showMessageDialog(null, comp2, "Rellenar", JOptionPane.QUESTION_MESSAGE, null);
                            i=Integer.parseInt(tfPos.getText())/10;
                            j=Integer.parseInt(tfPos.getText())%10;
                            snacks[i][j].setInventario(snacks[i][j].getInventario()+Integer.parseInt(tfCantidad.getText()));
                        }else{
                            JOptionPane.showMessageDialog(null, "Contraseña incorrecta");
                        }
                    }
                    break;
                case "Salir":
                    salir=true;
                    break;
            }
        }
    }

    public static String validacion(int dinero, Snack snack){
        if(snack.getInventario()<0){
            return "No hay inventario de " + snack.getNombre();
        }
        if(dinero<snack.getPrecio()){
            return "Dinero insuficiente";
        }
        int cambio = dinero - snack.getPrecio();
        if(dineroCaja-cambio<0){
            return "La máquina no tiene suficiente dinero";
        }
        dineroCaja-=cambio;
        return "Su cambio es de " + cambio;
    }

}

class Snack {
    private int precio;
    private String nombre;
    private int tipo;
    private int inventario;

    public Snack(String nombre, int tipo){
        this.nombre = nombre;
        inventario=5;
        switch (tipo) {
            case 0 -> precio = 24;
            case 1 -> precio = 15;
            case 2 -> precio = 8;
        }
    }

    public String getNombre(){
        return nombre;
    }

    public int getInventario(){
        return inventario;
    }

    public int getPrecio(){
        return precio;
    }

    public void setInventario(int inventario){
        this.inventario=inventario;
    }

    public String toString(){
        return "Nombre: " + nombre + "\nPrecio: " + precio;
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

    public static String inverso(String s,int indice) {
        if (indice >= 0)
            return s.charAt(indice) + inverso(s, indice-1);
        else {
            return "";
        }
    }
}

