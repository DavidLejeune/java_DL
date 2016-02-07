/**
 * @(#)Vb0800_UpperCaser.java
 *
 * Vb0800_UpperCaser application
 *             
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;


public class Vb0800_UpperCaser extends JFrame {  
    
    public static void main(String[] argumentenRij) {
       JFrame frame = new Vb0800_UpperCaser();
       frame.setSize(800,600);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setTitle("Vb0800_UpperCaser");
         // naam aanpassen als je Paneel van naam wijzigt !!!
       Paneel paneel = new Paneel();
       frame.setContentPane( paneel );
       frame.setVisible(true);    	
    }
}

class Paneel extends JPanel {
       
    // referenties naar objecten 
  private JLabel label;
  private JButton knop;
  private JTextField tekstvak,tekstvak2;
    
   

  
    // Constructor
  public Paneel() {
	  // label aanmaken
	label = new JLabel (" Typ een zin : ");	  
	  
	  // knop aanmaken en koppelen met event-handler
    knop = new JButton( "Alles in Hoofdletters" );
    knop.addActionListener( new KnopHandler() );
    

    tekstvak = new JTextField( 30 );
    tekstvak2 = new JTextField( 30 );
      // alle elementen toevoegen aan paneel-object
    add( label);add( tekstvak );
    add( knop );
    add( tekstvak2 );
  }
     
 
  
      // interne klasse voor event-handler
  class KnopHandler implements ActionListener {
    public void actionPerformed( ActionEvent e ) {

       // alle letters apart omzetten in hoofdletters :
       StringBuffer sb = new StringBuffer (tekstvak.getText());
       char ch = ' '; // mag ook '' zijn, het NULL-teken
       
       for (int pos = 0; pos < sb.length(); pos++){ // voor alle letters
       	 ch = sb.charAt(pos); // teken uithalen op die positie
       	     // als die in juiste bereik ligt ... hoofdletter van maken
       	 if ( ch >= 'a' && ch <= 'z') ch = (char) ( (int) ch-32);
       	 sb.setCharAt( pos, ch); // letter terugsteken
       }
       
       tekstvak2.setText ("" + sb); // = sb.toString()
    }
  }
}