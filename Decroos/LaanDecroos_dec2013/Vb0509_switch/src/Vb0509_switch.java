/**
 * @(#)Vb0509_switch.java
 *
 * Vb0509_switch application
 *
 * @author Voornaam Naam - Klas
 * @version 1.00 2007/10/22
 */
 
import javax.swing.*;

public class Vb0509_switch extends JFrame {
    
    public static void main(String[] argumentenRij) {
       JFrame frame = new Vb0509_switch();
       frame.setSize(600,200);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setTitle("Vb0509_switch");
       Paneel paneel = new Paneel();
       frame.setContentPane( paneel );
       frame.setVisible(true);    	
    }
}
