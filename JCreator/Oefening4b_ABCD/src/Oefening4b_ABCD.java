/**
 * @(#)Oefening4b_ABCD.java
 *
 * Oefening4b_ABCD application
 * @author David Lejeune - 1IPBICT
 * @version 1.00 2014/11/12
 *
 * Magische cijfers tussen 0 en 9999 di voldoen aan de stelling : ABCD = A4 + B4 + C4 + D4  
 *
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
// eventueel extra imports hier

public class Oefening4b_ABCD extends JFrame {  
    
    public static void main(String[] argumentenRij) {
       JFrame frame = new Oefening4b_ABCD();
       frame.setSize(800,600);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setTitle("Oefening4b_ABCD");
         // naam aanpassen als je Paneel van naam wijzigt !!!
       Paneel paneel = new Paneel();
       frame.setContentPane( paneel );
       frame.setVisible(true);  
       frame.setLocationRelativeTo(null);  
       frame.setResizable(false);   	
    }
}

class Paneel extends JPanel {
    // declaraties van de variabelen, schrap wat je niet gebruikt !
    
    // referenties naar objecten 
  private JLabel label;
  private JButton knop;
  private String stringNumber;
  private JTextField tekstvakAantal;
    
    // primitieve variabelen
  boolean p;
  char    ch;
  int     i,j,k;
  double  r,s,t;
  
    // Constructor
  public Paneel() {
	  // label aanmaken
	label = new JLabel (" Magische gestallen zoeken , druk op START ");	  	  
	  
	  // knop aanmaken en koppelen met event-handler
    knop = new JButton( "START" );
    knop.addActionListener( new KnopHandler() );
    
      // vak aanmaken op deze wijze ...
      // ofwel deze :
    //tekstvak = new JTextField( 10 );
    
      // alle elementen toevoegen aan paneel-object
    add( label);
    add( knop );
  }
     
      // alle tekenwerk hier
  public void paintComponent( Graphics g ) {
      super.paintComponent( g );



//      
  }
  
      // interne klasse voor event-handler
  class KnopHandler implements ActionListener {
    public void actionPerformed( ActionEvent e ) {
       // hier komen de event-handler opdrachten
       

		int y = 50;
		Graphics g = getGraphics(); 

       		for (i=0 ;i <= 9999 ; i++)
		       	{
					int number = i; 
						
					stringNumber = String.format("%04d", number);
		
						int digit1 = (number)/(1000) %  10;
						int digit2 = (number)/(100) %  10;
						int digit3 = (number)/(10) %  10;
						int digit4 = (number)/(1) %  10;
						

		    			
		    			//double controlPower = Math.pow(digit1, 4) + Math.pow(digit2, 4) + Math.pow(digit3, 4) + Math.pow(digit4, 4);
		    			
		    			if( Math.pow(digit1, 4) + Math.pow(digit2, 4) + Math.pow(digit3, 4) + Math.pow(digit4, 4) == number)
		    			{
		    				
		      				    String regel = stringNumber;  
		    						
		    					g.drawString(regel ,50 ,y += 25);
		    					
		    			}
		
		       
		       }

       
       
       // niet vergeten (indien nodig) :
       // validate();
       
    }
  }
  
     // slaap routine, schrappen indien niet gebruikt
  public static void slaap (int mSec){		 
		try {
			Thread.currentThread().sleep(mSec); 
		} catch (InterruptedException e){ }
	} 
		

  
}