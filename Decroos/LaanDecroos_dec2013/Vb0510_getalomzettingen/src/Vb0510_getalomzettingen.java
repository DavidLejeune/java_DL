/**
 * @(#)Vb0510_getalomzettingen.java
 *
 * Vb0510_getalomzettingen application
 *
 * @author Voornaam Naam - Klas
 * @version 1.00 2007/11/5
 */
 
import javax.swing.*;

public class Vb0510_getalomzettingen extends JFrame {
    
    public static void main(String[] argumentenRij) {
       JFrame frame = new Vb0510_getalomzettingen();
       frame.setSize(800,600);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setTitle("Vb0510_getalomzettingen");
       Paneel paneel = new Paneel();
       frame.setContentPane( paneel );
       frame.setVisible(true);    	
    }
}
