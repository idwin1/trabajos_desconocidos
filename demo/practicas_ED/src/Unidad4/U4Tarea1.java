package Unidad4;

import javax.swing.*;

public class U4Tarea1 {

    public static void main(String[] args) {

        ListaArticulos abarrotes = new ListaArticulos();
        boolean salir = false;
        while(salir == false){
            String[] opciones={ "1. Insertar un artículo al inicio","2. Insertar un artículo al final","3. Mostrar lista de artículos",
                    "4. Inventario total","5. Eliminar el PRIMER artículo","6. Artículos que cuestan menos de $ 25.00",
                    "7. Aumentar precio de artículos","8. Buscar artículo por descripción","9. Terminar","10}"};
            String respuesta = (String)JOptionPane.showInputDialog(null,"Que quieres hacer","Menu",
                    JOptionPane.QUESTION_MESSAGE,null,opciones,0);
            switch (respuesta){
                case "1. Insertar un artículo al inicio":
                    //1. Leer del teclado los datos de un artículo para crear un nodo e insertarlo al INICIO de la lista
                    String desc = JOptionPane.showInputDialog("descripcion","inserte la descripcion");
                    int cant = Integer.parseInt(JOptionPane.showInputDialog(null,"inserte la cantidad"));
                    float pre = Float.parseFloat(JOptionPane.showInputDialog(null,"inserte el precio"));
                    abarrotes.insertaInicio(new NodoArticulo(desc,cant,pre));
                    break;
                case "2. Insertar un artículo al final":
                    //2. Leer del teclado los datos de un artículo para crear un nodo e insertarlo al FINAL de la lista
                    desc = JOptionPane.showInputDialog("descripcion","inserte la descripcion");
                    cant = Integer.parseInt(JOptionPane.showInputDialog(null,"inserte la cantidad"));
                    pre = Float.parseFloat(JOptionPane.showInputDialog(null, "inserte el precio"));
                    abarrotes.insertarFinal(new NodoArticulo(desc,cant,pre));
                    break;
                case "3. Mostrar lista de artículos":
                    // 3. Se despliegan en pantalla todos los datos de los artículos de la lista de abarrotes
                    JOptionPane.showMessageDialog(null,abarrotes.toString());
                    break;
                case "4. Inventario total":
                    //4. Se despliega en pantalla el inventario total que hay en la lista (Recuerden que el inventario se calcula
                    //multiplicando la cantidad por el precio de cada artículo de la lista).
                    JOptionPane.showMessageDialog(null,"Inventario total: " + abarrotes.inventario());
                    break;
                case "5. Eliminar el PRIMER artículo":
                    //5. Se elimina el PRIMER artículo de la lista de abarrotes y se despliegan sus datos en pantalla. Si la
                    //lista está vacía indicar con un mensaje que NO se pudo hacer la eliminación.
                    if(!abarrotes.listaVacia()){
                        JOptionPane.showMessageDialog(null,abarrotes.eliminarInicio().toString());
                    }else
                        JOptionPane.showMessageDialog(null," NO se pudo hacer la eliminación");
                    break;
                case "6. Artículos que cuestan menos de $ 25.00":
                    // 6. Se despliega un listado con las descripciones de los artículos cuyo precio es < a $25.00
                    JOptionPane.showMessageDialog(null,abarrotes.listado25());
                    break;
                case "7. Aumentar precio de artículos":
                    // 7. Se captura del teclado el porcentaje que se desea aumentar a los precios de los artículos y se aplica
                    //ese aumento a todos los artículos de la lista.
                    abarrotes.aumento(Integer.parseInt(JOptionPane.showInputDialog(null,"porcecntaje que desea aumentar")));
                    break;
                case "8. Buscar artículo por descripción":
                    abarrotes.buscar(JOptionPane.showInputDialog(null,"ingrese la descripcion"));
                    break;
                case "9. Terminar":
                    salir = true;
                    break;
                case"10}":
                    NodoArticulo s =abarrotes.eliminaUltimo();
                    JOptionPane.showMessageDialog(null,s.toString());
            }
        }
    }

}
