/**
 * @(#)Vb07_04_KleurVectoren.java
 *
 * Vb07_04_KleurVectoren application
 *                  
 * @author Luc Decroos - KHBO - IWT - december 2007
 * @version 1.00 2007/12/11
 *
 * Beschrijving : ArrayList : eenvoudiger demo
 *
 * lijst van KleurVector objecten tekenen op panel
 *
 */

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class Vb0704_KleurVectoren extends JFrame {  
    
    public static void main(String[] argumentenRij) {
       JFrame frame = new Vb0704_KleurVectoren();
       frame.setSize(800,600);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setTitle("Gekleurde Vectoren Tekenen");
       Paneel paneel = new Paneel();
       frame.setContentPane( paneel );
       frame.setVisible(true);    	
    }
}

class Paneel extends JPanel {
    
  private JLabel label;
  private ArrayList<KleurVector> lijst;

  public Paneel() {
  	
  	setBackground (Color.BLACK);
  	
  		  // label aanmaken
	label = new JLabel ("   Spelen met Vectoren   ");	
	label.setFont (new Font ("Sanserif", Font.BOLD, 24));
	label.setBackground	(Color.cyan);
	label.setOpaque(true);	  
    add( label);
    
    // nu de lijst met vectoren maken & vullen
  	lijst = new ArrayList<>(); // lege lijst
  	            // signatuur = (int x, int y, int richting, int grootte, Color kleur)
  	lijst.add ( new KleurVector(  10,  10, 130, 150, Color.RED ));
  	lijst.add ( new KleurVector( 150, 210,  45, 150, Color.BLUE ));
  	lijst.add ( new KleurVector( 160, 280, 210, 250, Color.WHITE ));
  	lijst.add ( new KleurVector( 270, 160, 170, 350, new Color (100,50,200)));
  	lijst.add ( new KleurVector( 180, 250, 300, 150, Color.GREEN ));

    // nog 100 vectoren erbij .... geen probleem voor ArrayList !
    for( int i = 0 ; i<1;i++){
       lijst.add ( new KleurVector(
    		 (int) (700 * Math.random() +100 ) , // enkel in rechtse helft van paneel
    		 (int) (400 * Math.random()+ 100 ) ,
    		 (int) ( 360 * Math.random())  ,
    		 (int) ( 200 * Math.random() + 10) ,
    		  new Color ((int) ( 16777216 * Math.random())))); // tel de haakjes ! ;-)
    }
  } // einde constructor
     
      // alle tekenwerk hier
  public void paintComponent( Graphics g ) {
      super.paintComponent( g );
       // hier zo goed als geen code meer !
      for (KleurVector kv : lijst){
      	kv.tekenVector(g); // grafische context meegeven als argument --> pen
      }
  }
}