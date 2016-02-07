/**
 * @(#)Oef0601.java
 *
 * Oef0601 application
 *
 * @author Voornaam Naam - Klas
 * @version 1.00 2007/11/13
 */
 
import javax.swing.*;

public class Oef0601 extends JFrame {
    
    public static void main(String[] argumentenRij) {
       JFrame frame = new Oef0601();
       frame.setSize(300,200);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setTitle("Oef0601");
       Paneel paneel = new Paneel();
       frame.setContentPane( paneel );
       frame.setVisible(true);    	
    }
}
