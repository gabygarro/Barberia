

package GUI.funciones;


import barberia.Cliente;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Calendar;
import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;


import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;



public class funciones {
    public static void setLogo(javax.swing.JFrame ventana){
        try {
            ventana.setIconImage(ImageIO.read(new File("resources/barba.png")));
        } catch (IOException ex) {
        //nada qué hacer 

        }
    }
    
    public static LocalDateTime calToDate(Calendar calendario){

        return LocalDateTime.of(
                calendario.get(Calendar.YEAR), 
                calendario.get(Calendar.MONTH)+1,
                calendario.get(Calendar.DAY_OF_MONTH),
                calendario.get(Calendar.HOUR_OF_DAY), 0);
       
    }
    
    public static Calendar dateToCal(LocalDateTime ldt){
        
        Calendar cal = Calendar.getInstance();
        
        
        cal.set(Calendar.DAY_OF_WEEK, ldt.getDayOfWeek().getValue());
        cal.set(Calendar.YEAR, ldt.getYear());
        cal.set(Calendar.MONTH, ldt.getMonth().getValue());
        cal.set(Calendar.DAY_OF_MONTH, ldt.getDayOfMonth());
        cal.set(Calendar.HOUR_OF_DAY, ldt.getHour());
        cal.set(Calendar.MINUTE, 0);
        
        
        return cal;
    }
    
    public static void setFondo(javax.swing.JLabel labFondo, String nombreImg){
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                labFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("resources/ooke.png")));      
            }
        });
        
        
    }
     
    public static DefaultListModel initLista(ArrayList<Cliente> clientes) throws UnsupportedOperationException{
        if (clientes.isEmpty()){
            throw new UnsupportedOperationException("No existen clientes");
        }
        DefaultListModel modelo = new DefaultListModel();
        int i= 1;
        for (Cliente cliente : clientes){
            modelo.addElement(i++ + ". " + cliente.getNombre());
        }
        return modelo;
    }
    

    
    public static void LnF(){
        try {
            // Set System L&F
        UIManager.setLookAndFeel(
            UIManager.getSystemLookAndFeelClassName());
    } 
    catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
       // handle exception
    }
    }
}
