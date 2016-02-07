/**
 * @(#)Oef0502.java
 *
 * Oef0502 application
 *
 * @author Voornaam Naam - Klas
 * @version 1.00 2007/10/21
 */
 
import javax.swing.*;

public class Oef0502 extends JFrame {
    
    public static void main(String[] argumentenRij) {
       JFrame frame = new Oef0502();
       frame.setSize(400,200);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setTitle("Oef0502");
       Paneel paneel = new Paneel();
       frame.setContentPane( paneel );
       frame.setVisible(true);    	
    }
}
