package UNIDAD1;

import javax.swing.*;

public class U1Practica5 {

    public static void main(String[] args) {
        int cont=0;
        Factura[] facturas = new Factura[2];
        boolean salir = false;
        while (!salir) {
            String[] opciones1 = {"1. Captura de una factura", "2. Mostrar datos de facturas", "3. Monto total de todas las facturas", "4. Buscar artículos", "5. Salir"};
            String respuesta = (String) JOptionPane.showInputDialog(null, "Que quieres hacer",
                    "", JOptionPane.QUESTION_MESSAGE, null, opciones1, 0);
            switch (respuesta) {
                case "1. Captura de una factura":
                    if(cont< facturas.length) {
                        if(facturas[facturas.length-1]!=null){
                            JOptionPane.showMessageDialog(null, "no puedes ingresasr otra factura");
                        }else{
                            JLabel lblPromptFactura = new JLabel("Datos de la factura");
                            JLabel lblNumero = new JLabel("Folio:");
                            JTextField tfNumero = new JTextField();
                            /*
                            JLabel lblFechaCaducidad = new JLabel("Fecha de expedición:");
                            JLabel lblDia = new JLabel("Dia:");
                            JTextField tfDia = new JTextField();
                            JLabel lblMes = new JLabel("Mes:");
                            JTextField tfMes = new JTextField();
                            JLabel lblAnio = new JLabel("Anio:");
                            JTextField tfAnio = new JTextField();*/
                            Object[] compsFormRegistroFactura = {lblPromptFactura, lblNumero, tfNumero};//, lblFechaCaducidad, lblDia, tfDia,lblMes, tfMes, lblAnio, tfAnio
                            JOptionPane.showMessageDialog(null, compsFormRegistroFactura, "Ingresar factura",
                                    JOptionPane.QUESTION_MESSAGE, null);
                            Articulo[] articulosActuales = new Articulo[1];
                            float total=0;
                            for (int i = 0; i < articulosActuales.length; i++) {
                                JLabel lblPromptArticulo = new JLabel("Datos del articulo " + i);
                                /*JLabel lblDescripcion = new JLabel("Folio:");
                                JTextField tfDescripcion = new JTextField();
                                JLabel lblCantidad = new JLabel("Fecha de expedición:");
                                JTextField tfCantidad = new JTextField();
                                JLabel lblPrecio = new JLabel("Precio:");
                                JTextField tfPrecio = new JTextField();**/
                                JLabel labelDesc = new JLabel("Descripcion del articulo");
                                JLabel labelCant = new JLabel("Cantidad de articulos");
                                JLabel labelPrecio = new JLabel("Precio");
                                JTextField tfDesc = new JTextField();
                                JTextField tfCant = new JTextField();
                                JTextField tfPrecio = new JTextField();

                                //JOptionPane.showMessageDialog(null,registro,"registro",JOptionPane.QUESTION_MESSAGE);
                                Object[] compsFormArticulo = {lblPromptArticulo, labelDesc, tfDesc, labelCant, tfCant, labelPrecio, tfPrecio};
                                JOptionPane.showMessageDialog(null, compsFormArticulo, "Ingresar articulo",
                                        JOptionPane.QUESTION_MESSAGE, null);
                                total+= Float.parseFloat(tfPrecio.getText())*Integer.parseInt(tfCant.getText());
                                articulosActuales[i] = new Articulo(tfDesc.getText(), Integer.parseInt(tfCant.getText()),Float.parseFloat(tfPrecio.getText()),new fecha(30,3,2023));
                            }
                            facturas[cont] = new Factura(Integer.parseInt(tfNumero.getText()), articulosActuales,total );
                            JOptionPane.showMessageDialog(null, "Factura creada");
                            cont++;
                        }
                    }else
                        JOptionPane.showMessageDialog(null,"no puedes crear mas facturas");
                    break;
                case "2. Mostrar datos de facturas":
                    String s="";
                    int i=0;
                    for(Factura fac : facturas){
                        if(facturas[i]!=null) {
                            s += "indice: " + i + "\n" + fac.toString() + "\n";
                        }
                        i++;
                    }
                    JOptionPane.showMessageDialog(null,s);
                    break;
                case "3. Monto total de todas las facturas":
                    float total = 0;
                    int i1=0;
                    for(Factura fac : facturas){
                        if(facturas[i1]!=null){
                            total+= fac.getTotal();
                        }
                        i1++;
                    }
                    JOptionPane.showMessageDialog(null, "El monto total de todas las facturas es $" + total);
                    break;
                case "4. Buscar artículos":
                    String s1 = JOptionPane.showInputDialog(null,"Descripcion del articulo");
                    String s2="";
                    String s3="";
                    for(i=0;i<facturas.length;i++){
                        if(s3.equalsIgnoreCase(""))
                            if(facturas[i]!=null){
                                s2="numero en el vector de factura: " +i+"\n" +facturas[i].buscar(s1);
                                s3=facturas[i].buscar(s1);
                        }
                    }
                    if(s3.equals("")){
                        JOptionPane.showMessageDialog(null,"no se encontro el articulo");
                    }else
                        JOptionPane.showMessageDialog(null,s2);
                    break;
                case "5. Salir":
                    salir=true;
                    break;
            }
        }
    }
}
