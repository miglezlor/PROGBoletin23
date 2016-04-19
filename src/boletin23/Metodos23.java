package boletin23;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author mgonzalezlorenzo
 */
public class Metodos23 {
    ArrayList <Libro> inventario = new ArrayList();
    
    public void engadir(){
        String titulo = JOptionPane.showInputDialog("Titulo del libro: ");
        String autor = JOptionPane.showInputDialog("Autor del libro: ");
        float prezo = Float.parseFloat(JOptionPane.showInputDialog("Precio del libro: "));
        int numUni = Integer.parseInt(JOptionPane.showInputDialog("Numero de unidades: "));
        
        Libro lib = new Libro(titulo, autor, prezo, numUni);
        FileWriter fw = null;
        PrintWriter esc = null;
        
        try{
            fw = new FileWriter("inventario.txt",true);
            esc = new PrintWriter(fw);
            esc.println(titulo+","+autor+","+prezo+","+numUni);
        }
        catch(IOException ex){
            System.out.println("Erro engadir "+ ex.getMessage());
        }
        finally{
            try {
                fw.close();
            } catch (IOException ex) {
                Logger.getLogger(Metodos23.class.getName()).log(Level.SEVERE, null, ex);
            }
            esc.close();
        }
    }
    
    public void consultar(){
        String titu = JOptionPane.showInputDialog("Introduce el titulo del libro");
        Scanner sc=null;
        try {
            File f = new File ("inventario.txt");
            sc = new Scanner(f);
            while(sc.hasNextLine()){
                String res = sc.nextLine();
                String[]datos = res.split(",");
                if (datos[0].equalsIgnoreCase(titu)){
                    JOptionPane.showMessageDialog(null, Float.parseFloat(datos[2]+" euros."));
                }
                
            }
        }
        catch (FileNotFoundException ex) {
            System.out.println("Erro no ficheiro1 " + ex.toString());
        }
        finally{
            sc.close();
        }
    }
    
    public void visualizar() {
        Scanner sc = null;
        String aux="";
        try {
            File    f = new File ("inventario.txt");
            sc = new Scanner(f);
            while(sc.hasNextLine()){
                String res = sc.nextLine();
                aux=aux+res+"\n";
            }
            JOptionPane.showMessageDialog(null, aux);
            
        }
        catch (FileNotFoundException ex) {
            System.out.println("Erro no ficheiro1 " + ex.toString());
        }
        finally{
            sc.close();
        }
    }
    
    public void eliminar() {
        Scanner sc = null;
        PrintWriter escribir = null;
        try {
            File f = new File ("inventario.txt");
            File x = new File ("inventario1.txt");
            sc = new Scanner(f);
            escribir = new PrintWriter(x);
            while(sc.hasNextLine()){
                String res = sc.nextLine();
                String[]datos = res.split(",");
                if (Integer.parseInt(datos[3])!=0){
                    escribir.println(datos[0]+","+datos[1]+","+Float.parseFloat(datos[2])+","+Integer.parseInt(datos[3]));
                }
            }
            if (!f.delete()) {
                    System.out.println("");
                    
                } 
            if (x.renameTo(f))
                    System.out.println("");
      
        }
        catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
        finally{
            sc.close();
            escribir.close();
        }
        
    }
    
    public void modPrecio(){
        String titu = JOptionPane.showInputDialog("Introduce el titulo del libro a modificar");
        Scanner sc = null;
        PrintWriter escribir = null;
        try{
            File f = new File("inventario.txt");
            File x = new File("inventario1.txt");
            sc = new Scanner(f);
            escribir = new PrintWriter(x);
            while(sc.hasNextLine()){
                String res = sc.nextLine();
                String[]datos = res.split(",");
                if(datos[0].equalsIgnoreCase(titu)){
                    float newprecio = Float.parseFloat(JOptionPane.showInputDialog("Nuevo precio"));
                    escribir.println(datos[0]+","+datos[1]+","+newprecio+","+Integer.parseInt(datos[3]));
                }
                
                
                
            if (!f.delete()) {
                    System.out.println("");
                    
                } 
            if (x.renameTo(f))
                    System.out.println("");
      
            }
        }
        catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
        finally{
            sc.close();
            escribir.close();
        }
    }
}
