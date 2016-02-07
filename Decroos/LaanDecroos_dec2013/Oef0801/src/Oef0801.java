/**
 * @(#)Oef0801.java
 *
 * Oef0801 application
 *                  
 * @author Luc Decroos - KHBO
 * @version 1.00 2008/2/13
 *
 * Beschrijving : dobbelsteen simulatie
 *
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
// eventueel extra imports hier

public class Oef0801 extends JFrame {  
    
    public static void main(String[] argumentenRij) {
       JFrame frame = new Oef0801();
       frame.setSize(800,600);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setTitle("Oef0801");
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
  
  private Dobbelsteen d1,d2;  
    // primitieve variabelen
   
  int     w1,w2;
  
  
    // Constructor
  public Paneel() {
	  // label aanmaken
	label = new JLabel (" Dobbelsteen : klik om te gooien ");	  
	  
	  // knop aanmaken en koppelen met event-handler
    knop = new JButton( " Gooi " );
    knop.addActionListener( new KnopHandler() );
    
      // vak aanmaken op deze wijze ...
    tekstvak = new JTextField( 20 );
  
    
      // alle elementen toevoegen aan paneel-object
    add( label);
    add( knop );
    add( tekstvak );
    
    d1 = new Dobbelsteen();
    d2 = new Dobbelsteen();
    
    
  }
      
  public void paintComponent( Graphics g ) {
    super.paintComponent( g );
      // teken de twee dobbelstenen
      
        // basis
  	  g.setColor (Color.red);
      g.fillRoundRect (150,150,150,150,30,30);
      g.fillRoundRect (450,150,150,150,30,30);      
      
        // de ogen eropzetten volgens de worp              
      g.setColor (Color.white);
            // ( offset, graphics context)
      d1.teken (0   ,g); // linkse  dobbelsteen
      d2.teken (300 ,g); // rechtse dobbelsteen
  }
  
  class KnopHandler implements ActionListener {
    public void actionPerformed( ActionEvent e ) {
       // de event-handler opdrachten
       w1 = d1.gooi();
       w2 = d2.gooi();
       tekstvak.setText("D1 = " + w1 + " , D2 = " + w2);
       repaint();
    }
  }

}