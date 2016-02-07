/**
 * @(#)animated_gif_test.java
 *
 * animated_gif_test application
 *                  <vul hier steeds je voornaam - naam - klas in> !!!
 * @author Voornaam Naam - Klas
 * @version 1.00 2014/10/19
 *
 * Beschrijving : (vervang door je eigen beschrijving) !!!
 * Een standaard-programma met een paneel met een knop, 
 * tekstvak en event-afhandeling, aan te passen naargelang
 * wat je nodig hebt ...
 *
 */e

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
// eventueel extra imports hier

public class animated_gif_test extends JFrame {  
    
    public static void main(String[] argumentenRij) {
       JFrame frame = new animated_gif_test();
       frame.setSize(800,600);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setTitle("animated_gif_test");
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
    
    // primitieve variabelen
  boolean p;
  char    ch;
  int     i,j,k;
  double  r,s,t;
  
    // Constructor
  public Paneel() {
	  // label aanmaken
	label = new JLabel (" dummy tekst ");	  
	  
	  // knop aanmaken en koppelen met event-handler
    knop = new JButton( "Knop" );
    knop.addActionListener( new KnopHandler() );
    
      // vak aanmaken op deze wijze ...
    tekstvak = new JTextField( "dummy tekst" );
      // ofwel deze :
    //tekstvak = new JTextField( 10 );
    
      // alle elementen toevoegen aan paneel-object
    add( label);
    add( knop );
    add( tekstvak );
    
    
          	URL url = new URL("file://localhost/JAVA/animated_gif_test/classesoldschoolpc.gif");
        Icon icon = new ImageIcon(url);
        JLabel label = new JLabel(icon);

        JFrame f = new JFrame("Animation");
        f.getContentPane().add(label);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
       	
    
    
  }
     
      // alle tekenwerk hier
  public void paintComponent( Graphics g ) {
      super.paintComponent( g );
      // hier komen de tekenopdrachten
      
      
      
  }
  
      // interne klasse voor event-handler
  class KnopHandler implements ActionListener {
    public void actionPerformed( ActionEvent e ) {
       // hier komen de event-handler opdrachten
       
       
       
       
       // niet vergeten (indien nodig) :
       // validate();
       // repaint();
    }
  }
  
     // slaap routine, schrappen indien niet gebruikt
  public static void slaap (int mSec){		 
		try {
			Thread.currentThread().sleep(mSec); 
		} catch (InterruptedException e){ }
	} 
  
}