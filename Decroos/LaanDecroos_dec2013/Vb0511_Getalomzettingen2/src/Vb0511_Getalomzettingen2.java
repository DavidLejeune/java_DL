/**
 * @(#)Vb0511_Getalomzettingen2.java
 *
 * Vb0511_Getalomzettingen2 application
 *
 * @author Voornaam Naam - Klas
 * @version 1.00 2007/11/20
 */
 
import javax.swing.*;

public class Vb0511_Getalomzettingen2 extends JFrame {
    
    public static void main(String[] argumentenRij) {
       JFrame frame = new Vb0511_Getalomzettingen2();
       frame.setSize(800,600);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setTitle("Vb0511_Getalomzettingen2");
       Paneel paneel = new Paneel();
       frame.setContentPane( paneel );
       frame.setVisible(true);    	
    }
}
