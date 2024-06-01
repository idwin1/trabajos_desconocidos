package UNIDAD1;

import javax.swing.*;

public class U1Practica6 {
    public static void main(String[] args) {
        int caja=100;
        String s="";
        System.out.println(s);
        Snack[][] maquinaExpendedora =new Snack[][]{
                {new Snack(0,"crunch",24),new Snack(1,"Doritos",15),new Snack(2,"Bubaloo",8)},
                {new Snack(0,"KitKat",24),new Snack(1,"Chetos",15),new Snack(2,"Trident",8)},
                {new Snack(0,"Hershe's",24),new Snack(1,"Ruffles queso",15),new Snack(2,"Clorets",8)},
                {new Snack(0,"Snickers",24),new Snack(1,"Fritos",15),new Snack(2,"Orbits",8)},
                {new Snack(0,"MilkyWay",24),new Snack(1,"Chips jalapeño",15),new Snack(2,"Chiclets",8)}};
        boolean salir = false;
        while (!salir) {
            String[] opciones1 = {"1. Pedir snack", "2. Mostrar golosinas", "3. Dinero en caja", "4. Rellenar snack", "5. Salir"};
            String respuesta = (String) JOptionPane.showInputDialog(null, "Que quieres hacer",
                    "", JOptionPane.QUESTION_MESSAGE, null, opciones1, 0);
            switch (respuesta) {
                case "1. Pedir snack":
                    int solicitud=Integer.parseInt(JOptionPane.showInputDialog(null,"introdusca el codigo"));
                    if(solicitud/10<5 && solicitud%10<3){
                        if(maquinaExpendedora[solicitud/10][solicitud%10].cantidad>0){
                            JLabel producto = new JLabel(maquinaExpendedora[solicitud/10][solicitud%10].getNombre());
                            JLabel precio = new JLabel(""+maquinaExpendedora[solicitud/10][solicitud%10].getPrecio());
                            JLabel cobro = new JLabel("cobro");
                            JTextField tfCobro = new JTextField();
                            Object[] ob = new Object[]{producto,precio,cobro,tfCobro};
                            JOptionPane.showMessageDialog(null,ob,"maquina expendora",JOptionPane.QUESTION_MESSAGE);
                            if(Integer.parseInt(tfCobro.getText())>=maquinaExpendedora[solicitud/10][solicitud%10].getPrecio()){
                                maquinaExpendedora[solicitud/10][solicitud%10].setCantidad(maquinaExpendedora[solicitud/10][solicitud%10].cantidad-1);
                                caja+=Integer.parseInt(tfCobro.getText())-maquinaExpendedora[solicitud/10][solicitud%10].getPrecio();
                                JOptionPane.showMessageDialog(null,"su cambio es de: $" +(Integer.parseInt(tfCobro.getText())-maquinaExpendedora[solicitud/10][solicitud%10].getPrecio()));
                            }else
                                JOptionPane.showMessageDialog(null,"necesita mas dinero");
                        }else
                            JOptionPane.showMessageDialog(null,"no hay producto disponible");
                    }else
                        JOptionPane.showMessageDialog(null,"codigo invalido");
                    break;
                case "2. Mostrar golosinas":

                    /*String s1 = "";
                    String s2="";
                    String s3="";
                    String patron="|%s|     |%s|    |%s|";
                    for(int i=0;i<maquinaExpendedora.length;i++){
                        for(int j=0;j<1;j++){
                            s="codigo a introducir: " + i + j ;
                            s1="codigo a introducir: " + (i) + (j+1);
                            s2="codigo a introducir:  "+ (i) + (j+2);
                            s3+=String.format(patron,s,s1,s2)+"\n";
                            s="Nombre: " +maquinaExpendedora[i][j].nombre;
                            s1="Nombre: " +maquinaExpendedora[i][j+1].nombre;
                            s2="Nombre: " +maquinaExpendedora[i][j+2].nombre;
                            s3+=String.format(patron,s,s1,s2)+"\n";
                            s="Precio: " +maquinaExpendedora[i][j].precio ;
                            s1="Precio: " +maquinaExpendedora[i][j+1].precio;
                            s2="Precio: " +maquinaExpendedora[i][j+2].precio;
                            s3+=String.format(patron,s,s1,s2)+"\n";
                            s="Cantidad:" +maquinaExpendedora[i][j].cantidad;
                            s1="Cantidad:" +maquinaExpendedora[i][j+1].cantidad;
                            s2="Cantidad:" +maquinaExpendedora[i][j+2].cantidad;
                            s3+=String.format(patron,s,s1,s2)+"\n";
                        }
                    }*/

                    for(int i=0;i<maquinaExpendedora.length;i++){
                        String s2;
                        for(int j=0;j<1;j++){
                            s+="\ncodigo a introducir: " + i + j;
                            s=acomodar(s);
                            s2="codigo a introducir: " + (i) + (j+1);
                            s+=acomodar(s2);
                            s2="codigo a introducir: " + (i) + (j+2);
                            s+=acomodar(s2);
                            s2="\nNombre: " +maquinaExpendedora[i][j].nombre;
                            s+=acomodar(s2);
                            s2="Nombre: " +maquinaExpendedora[i][j+1].nombre;
                            s+=acomodar(s2);
                            s2="Nombre: " +maquinaExpendedora[i][j+2].nombre;
                            s+=acomodar(s2);
                            s2="\nPrecio: " +maquinaExpendedora[i][j].precio;
                            s+=acomodar(s2);
                            s2="Precio: " +maquinaExpendedora[i][j+1].precio;
                            s+=acomodar(s2);
                            s2="Precio: " +maquinaExpendedora[i][j+2].precio;
                            s+=acomodar(s2);
                            s2="\nCantidad:" +maquinaExpendedora[i][j].cantidad;
                            s+=acomodar(s2);
                            s2="Cantidad:" +maquinaExpendedora[i][j+1].cantidad;
                            s+=acomodar(s2);
                            s2="Cantidad:" +maquinaExpendedora[i][j+2].cantidad;
                            s+=acomodar(s2);
                            /*s+="\n|codigo a introducir: " + i + j +    "|     |codigo a introducir: " + (i) + (j+1) +"|       |codigo a introducir:  "+ (i) + (j+2) +
                                    "\n|Nombre: " +maquinaExpendedora[i][j].nombre + "|                |Nombre: " +maquinaExpendedora[i][j+1].nombre + "          |       |Nombre: " +maquinaExpendedora[i][j+2].nombre +
                                    "\n|Precio: " +maquinaExpendedora[i][j].precio + "         |       |Precio: " +maquinaExpendedora[i][j+1].precio + "|      |Precio: " +maquinaExpendedora[i][j+2].precio +
                                    "\n|Cantidad:" +maquinaExpendedora[i][j].cantidad +"|        |Cantidad:" +maquinaExpendedora[i][j+1].cantidad +"|     |Cantidad:" +maquinaExpendedora[i][j+2].cantidad;
                                    */

                        }
                    }
                   /* for(int i=0;i<maquinaExpendedora.length;i++){
                        for(int j=0;j<maquinaExpendedora[i].length;j++){
                            s+="\ncodigo a introducir: " + i + j +"\nNombre: " +maquinaExpendedora[i][j].nombre +"\nPrecio: " +maquinaExpendedora[i][j].precio + "\nCantidad:" +maquinaExpendedora[i][j].cantidad;
                        }
                    }
                    JTextArea textArea = new JTextArea(12, 25);
                    textArea.setText(s);
                    textArea.setEditable(false);
                    JScrollPane contenedorScrolleable = new JScrollPane(textArea);
                    JOptionPane.showMessageDialog(null, contenedorScrolleable);*/
                    JOptionPane.showMessageDialog(null,s);
                    break;
                case "3. Dinero en caja":
                    JOptionPane.showMessageDialog(null,"cantidad de dinero en caja: " + caja);
                    break;
                case "4. Rellenar snack":
                    s= JOptionPane.showInputDialog(null,"ingrese la contraseña");
                    if(s.equals("DeliSnacK")){
                        JLabel soli = new JLabel("introdusca el codigo");
                        JLabel rellenar = new JLabel("cantidad a rellenar");
                        JTextField cod = new JTextField();
                        JTextField can = new JTextField();
                        Object[] ob = new Object[]{soli,cod,rellenar,can};
                        JOptionPane.showMessageDialog(null,ob,"tecnico",JOptionPane.QUESTION_MESSAGE);
                        maquinaExpendedora[(Integer.parseInt(cod.getText())/10)][(Integer.parseInt(cod.getText())%10)].setCantidad((maquinaExpendedora[Integer.parseInt(cod.getText())/10][Integer.parseInt(cod.getText())%10].getCantidad()+Integer.parseInt(can.getText())));
                        JOptionPane.showMessageDialog(null,"cantidad disponible: "+maquinaExpendedora[Integer.parseInt(cod.getText())/10][Integer.parseInt(cod.getText())%10].cantidad);
                    }else
                        JOptionPane.showMessageDialog(null,"contraseña incorrecta");
                    break;
                case "5. Salir":
                    salir=true;
                    break;
            }
        }
    }
    public static String acomodar(String a){
        char momento[] = new char[30];
        for(int i=0;i<momento.length;i++){
            if(a.length()>i){
                momento[i]=a.charAt(i);
            }else {
                momento[i] =' ';
            }
        }
        momento[29]='|';
        String s="";
        for(int i= 0;i<momento.length;i++){
            s+=momento[i];
        }
        return s;
    }
    public static class Snack{
        private int tipo;
        private String nombre;
        private int precio;
        private int cantidad;

        public Snack(int tipo, String nombre, int precio) {
            this.tipo = tipo;
            this.nombre = nombre;
            this.precio = precio;
            this.cantidad = 5;
        }

        public int getTipo() {
            return tipo;
        }

        public String getNombre() {
            return nombre;
        }

        public int getPrecio() {
            return precio;
        }

        public int getCantidad() {
            return cantidad;
        }

        public void setTipo(int tipo) {
            this.tipo = tipo;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public void setPrecio(int precio) {
            this.precio = precio;
        }

        public void setCantidad(int cantidad) {
            this.cantidad = cantidad;
        }
    }
}
