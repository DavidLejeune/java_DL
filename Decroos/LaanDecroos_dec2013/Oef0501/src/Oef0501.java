/**
 * @(#)Oef0501.java
 *
 * Oef0501 application
 *
 * @author Voornaam Naam - Klas
 * @version 1.00 2007/10/21
 */
 
import javax.swing.*;

public class Oef0501 extends JFrame {
    
    public static void main(String[] argumentenRij) {
       JFrame frame = new Oef0501();
       frame.setSize(300,150);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setTitle("Oef0501");
       Paneel paneel = new Paneel();
       frame.setContentPane( paneel );
       frame.setVisible(true);    	
    }
}
