/**
 * @(#)Oef6_Circkels.java
 *
 * Oef6_Circkels application
 * @author David Lejeune-1PBICT
 * @version 1.00 2014/12/11
 *
 * Cirkels tekenen op het scherm + mogelijkheid tot grotere
 * of kleinere cirkels
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
// eventueel extra imports hier

public class Oef6_Circkels extends JFrame {  
    
    public static void main(String[] argumentenRij) {
       JFrame frame = new Oef6_Circkels();
       frame.setSize(800,600);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setTitle("Oef6_Circkels");
         // naam aanpassen als je Paneel van naam wijzigt !!!
       Paneel paneel = new Paneel();
       frame.setContentPane( paneel );
       frame.setVisible(true);    	
    }
}

class Paneel extends JPanel {
	
	

 
  
  	
	
    // declaraties van de variabelen, schrap wat je niet gebruikt !
    
    // referenties naar objecten 
  private JLabel labelT;
  private JButton knopStart;
  private JButton knopGroter;
  private JButton knopKleiner;
  private JTextField tekstvak;
  private ArrayList<Cirkel> lijst;  
  	
  	 
    // primitieve variabelen
  boolean p;
  char    ch;
  int     i,j,k;
  double  r,s,t;
  
    // Constructor
  public Paneel() {
	  // label aanmaken
	labelT = new JLabel ("Hoeveel cirkels wil je tekenen? ");	  
	lijst = new ArrayList<>(); // lege lijst
	  // knop aanmaken en koppelen met event-handler
    knopStart = new JButton( "Start" );
    knopGroter = new JButton( "Groter" );
    knopKleiner = new JButton( "Kleiner" );
    knopStart.addActionListener( new KnopHandler() );
    knopGroter.addActionListener( new KnopHandler() );
    knopKleiner.addActionListener( new KnopHandler() );
    
      // vak aanmaken op deze wijze ...
    tekstvak = new JTextField( 10 );
      // ofwel deze :
    //tekstvak = new JTextField( 10 );
    
      // alle elementen toevoegen aan paneel-object
    add( labelT);
    add( tekstvak );
    add( knopStart );
    add( knopGroter );
    add( knopKleiner );
  }
     
      // alle tekenwerk hier
  public void paintComponent( Graphics g ) {
      super.paintComponent( g );
      // hier komen de tekenopdrachten
      
      for (Cirkel ct : lijst){
      	ct.tekenCirkel(g); // grafische context meegeven als argument --> pen
      }
      
  }
  
      // interne klasse voor event-handler
  class KnopHandler implements ActionListener {
    public void actionPerformed( ActionEvent e ) {
       // hier komen de event-handler opdrachten
       
       
	Object src = e.getSource();  
    if (src == knopStart) {  
       	
       int aantalCirkels = Integer.parseInt(tekstvak.getText());
       
       		lijst.clear();
       
           for( int i = 0 ; i< aantalCirkels;i++)
           	{
		       lijst.add ( new Cirkel(
		    		 (int) (100 * Math.random() + 100 * Math.random() ) , 
		    		 (int) (200 * Math.random() + 100 * Math.random() ) ,
		    		 (int) ( 300 * Math.random())  ,
		    		 (int) ( 400 * Math.random() + 10) ,
		    		  new Color ((int) ( 16777216 * Math.random())))); 
    		}
       
       // niet vergeten (indien nodig) :
       // validate();
       repaint();       	
       	
       	
       	
       }
       if (src == knopGroter) {  
       	
       
      for (Cirkel ct : lijst){
      	
//      	cirkel.getX();
//      	int x = x + 1 ;
//      	cirkel.setX(x);
//       	cirkel.getY();
//      	int y = y + 1 ;
//      	cirkel.setY(x);
//		int breedte, grootte;
//      	ct.getBreedte();
//      	breedte = breedte + 1 ;
//      	ct.setBreedte(breedte);
//		ct.getGrootte();
//      	grootte = grootte + 1 ;
//      	ct.setGrootte(grootte);
      	
      		ct.maakGroter();
      		ct.maakBreder();
      		
      		
      		
      			repaint();  
      		     	
      		
      		
      		
      		
      } 
       
        repaint();       	
       	
       	
       	
       }  
       	
           if (src == knopKleiner) {  
       	
       
       
       
      for (Cirkel ct : lijst){
      	
      		ct.maakMinderGroot();
      		ct.maakMinderBreed();
      		
      			repaint();  
      		     	
      		
      		
      		
      		
      } 
       	
       	
       } 
       
       

    }
  }
  
  
  

  
  
     // slaap routine, schrappen indien niet gebruikt
  public static void slaap (int mSec){		 
		try {
			Thread.currentThread().sleep(mSec); 
		} catch (InterruptedException e){ }
	} 
  
}