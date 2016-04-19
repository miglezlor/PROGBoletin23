package boletin23;

import javax.swing.JOptionPane;

/**
 *
 * @author mgonzalezlorenzo
 */
public class Boletin23 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Metodos23 obx = new Metodos23();
        int opcion;
        
        do{
            
            opcion=Integer.parseInt(JOptionPane.showInputDialog("OPCIONES: \n 1. Añadir libro. \n 2. Consultar precio. \n 3. Visualizar el inventario. \n 4. Eliminar libros con 0 unidades. \n 5. Modificar precio. \n 6. Salir"));
            
            switch(opcion){
                case 1 : obx.engadir();
                    break;
                case 2 : obx.consultar();
                    break;
                case 3 : obx.visualizar();
                    break;
                case 4 : obx.eliminar();
                    break;
                case 5 : obx.modPrecio();
                    break;
            }
        }while(opcion<6);
    }
    
}
