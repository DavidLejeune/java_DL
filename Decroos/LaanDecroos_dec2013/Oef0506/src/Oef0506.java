/**
 * @(#)Oef0506.java
 *
 * @author Luc Decroos - KHBO
 * @version 1.00 2010/11/01
 *
 * Oef0506 application
 * oplossing oef 5.6 : Som van 1 tot en met 1000
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Oef0506 extends JFrame {  
    
    public static void main(String[] argumentenRij) {
       JFrame frame = new Oef0506();
       frame.setSize(800,200);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setTitle("Oef0506");
         // naam aanpassen als je Paneel van naam wijzigt !!!
       Paneel paneel = new Paneel();
       frame.setContentPane( paneel );
       frame.setVisible(true);    	
    }
}

class Paneel extends JPanel {

  private JLabel label;
  private JButton knop;
  private JTextField tekstvak;
  
    // Constructor
  public Paneel() {
	  // label aanmaken
	label = new JLabel (" Oefening 5.6 : Som van 1 tot en met 1000 ");	  
	  
	  // knop aanmaken en koppelen met event-handler
    knop = new JButton( " GO " );
    knop.addActionListener( new KnopHandler() );
    
      // vak aanmaken op deze wijze ...
    tekstvak = new JTextField( 10 );
    
      // alle elementen toevoegen aan paneel-object
    add( label);
    add( knop );
    add( tekstvak );
  }
     
       // interne klasse voor event-handler
  class KnopHandler implements ActionListener {
    public void actionPerformed( ActionEvent e ) {
 
       int som = 0;
       
       for (int i = 1; i<=1000; i++){
       	   System.out.println(""+i); // ter controle
       	   som += i;
       }
       
       tekstvak.setText (""  +som);
       
    }
  }
}