/**
 * @(#)Oefening1_Tekenen.java
 *
 * Oefening1_Tekenen application
 * 
 * 
 * @author David Lejeune - 1PBICT
 * @version 1.00 2014/9/25
 *
 * Mijn eerste programm
 * Huis tekenen , joepie
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
// eventueel extra imports hier

public class Oefening1_Tekenen extends JFrame {  
    
    public static void main(String[] argumentenRij) {
       JFrame frame = new Oefening1_Tekenen();
       frame.setSize(1000,800);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setTitle("Oefening1_Tekenen");
       
       //added these in class
       frame.setLocationRelativeTo(null);
       frame.setResizable(false);
       frame.setAlwaysOnTop(true);
       
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
  }
     
      // alle tekenwerk hier
  public void paintComponent( Graphics g ) {
      super.paintComponent( g );
      // hier komen de tekenopdrachten
      
      
      // outer frame of the house
      g.setColor(Color.blue);
      g.drawLine(150,250,475,100);
      g.drawLine(150,250,800,250);
      g.drawLine(475,100,800,250);
      g.drawLine(150,250,150,600);
      g.drawLine(150,600,800,600);
      g.drawLine(800,250,800,600);
   	  
   	  //  simple window 
      g.setColor(Color.orange);
   	  g.drawLine(500,350,700,350);
   	  g.drawLine(500,400,700,400);
   	  g.drawLine(500,450,700,450);
   	  g.drawLine(500,450,700,450);
   	  g.drawLine(500,350,500,450);
   	  g.drawLine(700,350,700,450);
   	  g.drawLine(600,350,600,450);
   	  
   	  
   	  // the door
      g.setColor(Color.red);
      g.drawLine(250,350,400,350);
      g.drawLine(250,350,250,600);
   	  g.drawLine(400,350,400,600);
   	  g.drawLine(250,600,400,600);
   	  
   	  
   	   
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