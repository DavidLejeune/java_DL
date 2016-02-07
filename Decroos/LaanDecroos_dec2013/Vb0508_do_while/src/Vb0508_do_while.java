/**
 * @(#)Vb0508_do_while.java
 *
 * Vb0508_do_while application
 *
 * @author Voornaam Naam - Klas
 * @version 1.00 2007/10/21
 */
 
import javax.swing.*;

public class Vb0508_do_while extends JFrame {
    
    public static void main(String[] argumentenRij) {
       JFrame frame = new Vb0508_do_while();
       frame.setSize(300,150);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setTitle("Vb0508_do_while");
       Paneel paneel = new Paneel();
       frame.setContentPane( paneel );
       frame.setVisible(true);    	
    }
}
