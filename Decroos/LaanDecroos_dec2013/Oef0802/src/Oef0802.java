/**
 * @(#)Oef0802.java
 *
 * Oef0802 application
 *                  
 * @author Luc Decroos - KHBO
 * @version 1.00 2008/2/13
 *
 * Beschrijving : dobbelsteen telling
 *
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
// eventueel extra imports hier

public class Oef0802 extends JFrame {  
    
    public static void main(String[] argumentenRij) {
       JFrame frame = new Oef0802();
       frame.setSize(800,200);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setTitle("Oef0802");
         // naam aanpassen als je Paneel van naam wijzigt !!!
       Paneel paneel = new Paneel();
       frame.setContentPane( paneel );
       frame.setVisible(true);    	
    }
}
class Paneel extends JPanel {
    // declaraties van de variabelen, schrap wat je niet gebruikt !
    
    // referenties naar objecten 
  private JLabel label;
  private JButton knop;
  private JTextField tekstvak;
  
  private Dobbelsteen d1;  
  private String boodschap = "";	
    // primitieve variabelen
   
  long   w1;
  long  aantalWorpen; // om meer dan 2.000.000.000 worpen te kunnen doen
  long t1, t2;
  
    // Constructor
  public Paneel() {
	  // label aanmaken
	label = new JLabel (" Test : tik een aantal worpen in vak en klik");	  
	  
	  // knop aanmaken en koppelen met event-handler
    knop = new JButton( " Test " );
    knop.addActionListener( new KnopHandler() );
    
      // vak aanmaken op deze wijze ...
    tekstvak = new JTextField( 30 );

      // alle elementen toevoegen aan paneel-object
    add( label);
    add( knop );
    add( tekstvak );
      
      // na de GUI elementen, andere initialisaties
    d1 = new Dobbelsteen();
  }


          // alle tekenwerk hier
  public void paintComponent( Graphics g ) {
      super.paintComponent( g );
      // hier komen de tekenopdrachten
      g.drawString (boodschap, 80,80); //is de eerste keer nog leeg
  }
  
  
      // interne klasse voor event-handler
  class KnopHandler implements ActionListener {
    public void actionPerformed( ActionEvent e ) {
       // hier komen de event-handler opdrachten
       t1 = System.currentTimeMillis();
       
       try{
       	 aantalWorpen = Long.parseLong(tekstvak.getText());
       	 w1 = d1.telAantalZessen (aantalWorpen);
       	 t2 = System.currentTimeMillis();
       	 long delta = t2-t1;
         boodschap = "Aantal zessen in " + aantalWorpen +
         	    " worpen = " + w1 + "(tijd = " + delta + " )";
       }
       catch (NumberFormatException foutje){
       	 boodschap = "Dat was geen geldig getal hoor !";
       }
       repaint();
    }
  }


 
  
}