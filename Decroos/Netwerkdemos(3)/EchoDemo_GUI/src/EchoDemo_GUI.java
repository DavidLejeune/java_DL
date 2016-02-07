/**
 * @(#)EchoDemo_GUI.java
 *
 * EchoDemo_GUI application
 *
 * @author Voornaam Naam - Klas
 * @version 1.00 2007/10/24
 */
 
import javax.swing.*;

import javax.swing.UIManager.*;



public class EchoDemo_GUI extends JFrame {
    
    public static void main(String[] argumentenRij) {
       JFrame frame = new EchoDemo_GUI();
       frame.setSize(800,600);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setTitle("EchoClient met GUI");
       ClientPaneel paneel = new ClientPaneel();
       frame.setContentPane( paneel );
       frame.setVisible(true);    	
    }
}
