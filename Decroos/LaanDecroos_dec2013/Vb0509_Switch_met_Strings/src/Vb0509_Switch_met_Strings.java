/**
 * @(#)Vb0509_Switch_met_Strings.java
 *
 * Vb0509_Switch_met_Strings application
 *                  
 * @author Luc Decroos - KHBO 2012
 * @version 1.00 2012/10/22
 *
 * Beschrijving : demo van switch statement met Strings, nieuw sedert Java 7
 *                (staat niet in boek)
 *
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Vb0509_Switch_met_Strings extends JFrame {  
    
    public static void main(String[] argumentenRij) {
       JFrame frame = new Vb0509_Switch_met_Strings();
       frame.setSize(800,600);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setTitle("Vb0509_Switch_met_Strings");
       frame.setContentPane( new Paneel() );
       frame.setVisible(true);    	
    }
}

class Paneel extends JPanel {
  private JTextField tekstvak1, tekstvak2;

  
    // Constructor
  public Paneel() {
	tekstvak1 = new JTextField( 25 );
    tekstvak1.addActionListener( new VakHandler() );
    tekstvak2 = new JTextField( 25 );
    add( tekstvak1 );
    add( tekstvak2 );
  }
   
  public void paintComponent( Graphics g ) {
      super.paintComponent( g );
      g.drawString("Tik een naam in, gevolgd door <Enter>",10,50);
	  g.drawString("Ik zoek je score op",10,80);
  }  

      
  class VakHandler implements ActionListener {
    public void actionPerformed( ActionEvent e ) {
       // lees een naam in  
       String naam = tekstvak1.getText();
       double score = 0;
       
       switch (naam) {   // voorlopig met "ingebakken" scores (hard coded)
			       
			       // twee gevallen , zelfde antwoord            
			    case "Thomas":case "thomas": { // layout mag "lang"
			    	naam = "Thomas"; 
			        score = 7.5;
			        break;  
			    }
			                                  // maar ook "kort" : 
  				case "Shana" :case "shana" :  naam = "Shana" ; score = 8.0;  break; 
  				case "Arne":case "arne":  naam = "Arne"; score = 8.5;  break; 
  				case "Thijs"   :case "thijs"   :  naam = "Thijs"   ; score = 8.0;  break; 
  				case "Niels"   :case "niels"   :  naam = "Niels"   ; score = 7.0;  break; 
		  		default 				   :  naam = ""      ; score = 0;    break;
       }
		  		          

  	   if ( !(score == 0) ){      // enkel iets afdrukken indien geldig !
  			tekstvak2.setText(naam + " behaalde " + score + " op 10");
  			tekstvak1.setText("");
  		}
    }
  }
  
 
  
}