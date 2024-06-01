package UNIDAD1;

import javax.swing.*;

public class U1Practica4 {
    public static void main(String[] args) {
        Departamento[] superMercado = new Departamento[4];
        int cont=0;
        boolean salir = false;
        while (!salir) {
            String[] opciones1 = {"1. Registrar departamentos", "2. Registrar articulo en un departamento ", "3. Mostrar departamentos", "4. inventario por departamento", "5 buscar un articulo", "6. Terminar"};
            String respuesta = (String) JOptionPane.showInputDialog(null, "Que quieres hacer",
                    "", JOptionPane.QUESTION_MESSAGE, null, opciones1, 0);
            switch (respuesta) {
                case "1. Registrar departamentos":
                    if(cont<4){
                        if(superMercado[superMercado.length-1]!=null) {
                            JOptionPane.showMessageDialog(null, "no puedes ingresasr otro departamento");
                        }else {
                            JLabel labelnom_dep = new JLabel("nombre departamento");
                            JLabel labelnom_enc = new JLabel("nombre del encargado");
                            JTextField tfnom_dep = new JTextField();
                            JTextField tfnom_enc = new JTextField();

                            Object[] comp = {labelnom_dep,tfnom_dep,labelnom_enc,tfnom_enc};
                            JOptionPane.showMessageDialog(null, comp, "Inserte el nombre del departamento y el encargado", JOptionPane.QUESTION_MESSAGE, null);
                            superMercado[cont]=new Departamento(tfnom_dep.getText(),tfnom_enc.getText(), new Articulo[10]);
                            cont++;
                        }
                    }else   {
                        JOptionPane.showMessageDialog(null,"no hay lugar para mas departamentos");
                    }
                    break;
                case "2. Registrar articulo en un departamento ":
                    String[] dep = new String[4];
                    for (int i = 0 ; i<superMercado.length;i++ ) {
                        if(superMercado[i]!=null){
                            dep[i]=superMercado[i].getNombre();
                        }
                    }
                    String de = (String) JOptionPane.showInputDialog(null, "selecione el departamento",
                            "", JOptionPane.QUESTION_MESSAGE, null, dep, 0);
                    for (int i = 0;i<superMercado.length;i++ ) {
                        if(superMercado[i]!=null){
                            if (superMercado[i].getNombre().equals(de)) {
                                if (superMercado[i].hayEspacio() < 11) {
                                    JLabel labelDesc = new JLabel("Descripcion del articulo");
                                    JLabel labelCant = new JLabel("Cantidad de articulos");
                                    JLabel labelPrecio = new JLabel("Precio");
                                    JLabel labelCaducidad = new JLabel("Fecha de caducidad");
                                    JLabel labelDia = new JLabel("Dia");
                                    JLabel labelMes = new JLabel("Mes");
                                    JLabel labelAño = new JLabel("Año");
                                    JTextField tfDesc = new JTextField();
                                    JTextField tfCant = new JTextField();
                                    JTextField tfPrecio = new JTextField();
                                    JTextField tfDia = new JTextField();
                                    JTextField tfMes = new JTextField();
                                    JTextField tfAño = new JTextField();
                                    Object[] registro ={labelDesc,tfDesc,labelCant,tfCant,labelPrecio,tfPrecio,labelCaducidad,labelDia,tfDia,labelMes,tfMes,labelAño,tfAño};
                                    JOptionPane.showMessageDialog(null,registro,"registro",JOptionPane.QUESTION_MESSAGE);
                                    superMercado[i].agregarArticulo(new Articulo(tfDesc.getText(),Integer.parseInt(tfCant.getText()),Float.parseFloat(tfPrecio.getText()),new fecha(Integer.parseInt(tfDia.getText()),Integer.parseInt(tfMes.getText()),Integer.parseInt(tfAño.getText()))));
                                } else
                                    JOptionPane.showMessageDialog(null, "no hay lugar para insertar mas articulos");
                            }
                        }
                    }
                    break;
                case "3. Mostrar departamentos":
                    String s = "";
                    for (int i = 0;i<superMercado.length;i++) {
                        if(superMercado[i]!=null)
                            s+="\nPosicion: "+ (i+1)+"\n"+superMercado[i].toString();
                    }
                    JOptionPane.showMessageDialog(null,s);
                    break;
                case "4. inventario por departamento":
                     s="";
                    for (int i = 0;i<superMercado.length;i++) {
                        if(superMercado[i]!=null)
                            s+="\nDepartamento: " + superMercado[i].getNombre() + "\nInventario total: $" + superMercado[i].inventario();
                    }
                    JOptionPane.showMessageDialog(null,s);
                    break;
                case "5 buscar un articulo":
                    String buscar = JOptionPane.showInputDialog(null,"que quieres buscar");
                    boolean seEncontro = false;
                    for (int i = 0;i<superMercado.length;i++) {
                        if (superMercado[i] != null) {
                            if (i < 4) {
                                if (!seEncontro) {
                                    if (superMercado[i].buscar(buscar) != -1) {
                                        JOptionPane.showMessageDialog(null, superMercado[i].escojerArticulo(superMercado[i].buscar(buscar)));
                                        seEncontro = true;
                                    } else {
                                        seEncontro = false;
                                    }
                                }
                            }
                        }
                    }
                    if(!seEncontro){
                        JOptionPane.showMessageDialog(null,"No se encontro el articulo");
                    }
                    break;
                case "6. Terminar":
                    salir=true;
                    break;
            }
        }
    }
}
