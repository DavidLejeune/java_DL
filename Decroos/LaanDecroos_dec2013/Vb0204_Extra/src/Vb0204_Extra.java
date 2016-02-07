/**
 * @(#)Vb0204_Extra.java
 *
 * Vb0204_Extra application
 *
 * @author Voornaam Naam - Klas
 * @version 1.00 2007/9/30
 */
 
import javax.swing.*;

public class Vb0204_Extra extends JFrame {
    
    public static void main(String[] argumentenRij) {
       JFrame frame = new Vb0204_Extra();
       frame.setSize(800,600);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setTitle("Vb0204_Extra");
       Paneel paneel = new Paneel();
       frame.setContentPane( paneel );
       frame.setVisible(true);    	
    }
}
