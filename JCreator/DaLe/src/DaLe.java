/**
 * @(#)DaLe.java
 *
 * DaLe application
 * @author David Lejeune
 * @version 1.00 2014/10/19
 *
 *
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
// eventueel extra imports hier

public class DaLe extends JFrame {  
    
    public static void main(String[] argumentenRij) {
       JFrame frame = new DaLe();
       frame.setSize(1000,600);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setTitle("DaLe");
         // naam aanpassen als je Paneel van naam wijzigt !!!
       Paneel paneel = new Paneel();
       frame.setContentPane( paneel );
       frame.setVisible(true);
       frame.setLocationRelativeTo(null);     	
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
	//label = new JLabel (" dummy tekst ");	  
	  
	  // knop aanmaken en koppelen met event-handler
    //knop = new JButton( "Knop" );
    //knop.addActionListener( new KnopHandler() );
    
      // vak aanmaken op deze wijze ...
    //tekstvak = new JTextField( "dummy tekst" );
      // ofwel deze :
    //tekstvak = new JTextField( 10 );
    
      // alle elementen toevoegen aan paneel-object
    //add( label);
    //add( knop );
    //add( tekstvak );
  }
     
      // alle tekenwerk hier
  public void paintComponent( Graphics g ) {
      super.paintComponent( g );
      // hier komen de tekenopdrachten
      
     
      g.setColor(Color.BLACK);
      g.fillRect(0,0,10000,2000);
      g.setColor(Color.ORANGE);
      g.fillRect(250,15,525,525);
     
      //g.setColor(Color.YELLOW);
      //g.fillRect(50,50,50,450);
      
      //g.fillRect(105,50,50,50);
      
      //g.fillRect(160,70,50,50);
      //g.fillRect(105,450,50,50);
      //g.fillRect(160,430,50,50);
      //g.fillRect(215,95,50,365);
      
      
      
      g.setColor(Color.BLUE);
      g.fillArc(250,25,500,500,270,180);
      g.setColor(Color.BLACK);
      g.fillRect(425,50,50,350);
      g.fillRect(325,350,100,50);
      g.setColor(Color.WHITE);
      g.fillArc(380,60,300,300,270,180);
      g.setColor(Color.BLACK);
      //g.fillArc(405,65,265,275,270,180);
      g.fillArc(465,175,150,150,270,180);
      g.setColor(Color.WHITE);
      g.drawRect(250,15,525,525);
      
      
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