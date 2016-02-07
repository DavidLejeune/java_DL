/**
 * @(#)Oef6b_Robotje.java
 *
 * Oef6b_Robotje application
 * @author David Lejeune - 1PBICT
 * @version 1.00 2014/12/11
 *
 * Teken een 'robotje' op het scherm en beweeg het links en rechts
 *
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
// eventueel extra imports hier

public class Oef6b_Robotje extends JFrame {  
    
    public static void main(String[] argumentenRij) {
       JFrame frame = new Oef6b_Robotje();
       frame.setSize(1920,1080);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setTitle("Oef6b_Robotje");
         // naam aanpassen als je Paneel van naam wijzigt !!!
       Paneel paneel = new Paneel();
       frame.setContentPane( paneel );
       frame.setVisible(true);    	
    }
}

class Paneel extends JPanel {
    // declaraties van de variabelen, schrap wat je niet gebruikt !
    
    // referenties naar objecten 
  private JButton knopLinks;
  private JButton knopRechts;
  private JButton knopBoven;
  private JButton knopBeneden;
  private JButton knopNieuw;
  private JButton knopLoop;
  private ArrayList<Robot> lijst;  
  private JTextField tekstvak;
    
    // primitieve variabelen
  boolean p;
  char    ch;
  int     i,j,k;
  double  r,s,t;
  
    // Constructor
  public Paneel() {
	  // label aanmaken  
	  
	  // knop aanmaken en koppelen met event-handler
    knopLinks = new JButton( "Links" );
    knopLinks.addActionListener( new KnopHandler() );
    knopRechts = new JButton( "Rechts" );
    knopRechts.addActionListener( new KnopHandler() );
    knopBoven = new JButton( "Boven" );
    knopBoven.addActionListener( new KnopHandler() );
    knopBeneden = new JButton( "Beneden" );
    knopBeneden.addActionListener( new KnopHandler() );
    knopNieuw = new JButton( "Nieuw" );
    knopNieuw.addActionListener( new KnopHandler() );
    knopLoop = new JButton( "Loop" );
    knopLoop.addActionListener( new KnopHandler() );

    tekstvak = new JTextField( 10 );
    	  
	lijst = new ArrayList<>(); // lege lijst
	
	
      // alle elementen toevoegen aan paneel-object
    add( knopLinks );
    add( knopRechts );
    add( knopBoven );
    add( knopBeneden );
    add( knopNieuw );
    add(tekstvak);
    add(knopLoop);
  }
     
      // alle tekenwerk hier
  public void paintComponent( Graphics g ) {
      super.paintComponent( g );
      // hier komen de tekenopdrachten
      
          g.setColor(Color.BLACK);
      g.fillRect(0,0,10000,2000);
      
            for (Robot rt : lijst){
      	rt.tekenRobot(g); // grafische context meegeven als argument --> pen
      	
      	
      	
      	
      }
      
  }
  
      // interne klasse voor event-handler
  class KnopHandler implements ActionListener {
    public void actionPerformed( ActionEvent e ) {
       // hier komen de event-handler opdrachten
       
       	Object src = e.getSource();  
   		 if (src == knopLinks) 
   		 	{  
       				int arrayIndex = Integer.parseInt(tekstvak.getText());
   		 			Robot rt = lijst.get( arrayIndex);
      				rt.NaarLinks();
    	
        repaint();
   		 	}
   		 if (src == knopRechts) 
   		 	{  
       				int arrayIndex = Integer.parseInt(tekstvak.getText());
   		 			Robot rt = lijst.get( arrayIndex);
      				rt.NaarRechts();
    	
        repaint();
   		 	}
   		 if (src == knopBoven) 
   		 {
   		 
       				int arrayIndex = Integer.parseInt(tekstvak.getText());
   		 			Robot rt = lijst.get( arrayIndex);	
      				rt.NaarBoven();
  	
        repaint();
   		 	}
   		 if (src == knopBeneden) 
   		 	{  
       				int arrayIndex = Integer.parseInt(tekstvak.getText());
   		 			Robot rt = lijst.get( arrayIndex);
       				rt.NaarBeneden();

        repaint();
   		 	}
   		 if (src == knopNieuw) 
   		 	{  
		       	lijst.add ( new Robot(
				    		 (int) (50 * Math.random() + 1920 * Math.random() ) , 
				    		 (int) (50 * Math.random() + 1080 * Math.random() ) ,
				    		 (int) ( 300 * Math.random())  ,
				    		 (int) ( 400 * Math.random() + 10) ,
				    		  new Color ((int) ( 16777216 * Math.random())))  );
				
        repaint();
   		 	}   		 
   		 	if (src == knopLoop) 
   		 	{  
   		 		for(i=0;i<1000;i++)
   		 		{
		       	int x =  (int) (50 * Math.random() + 1920 * Math.random() ) ;
		       	int y =	 (int) (50 * Math.random() + 1080 * Math.random() ) ;
				int breedte =  (int) ( 300 * Math.random())  ;
				 int hoogte = (int) ( 400 * Math.random() + 10) ;
				       Graphics g = getGraphics();
    
      	 		g.setColor (new Color ((int) ( 16777216 * Math.random())));
	    g.fillOval ( x,y,breedte, hoogte ) ;

      	 		g.setColor (new Color ((int) ( 16777216 * Math.random())));
	    g.fillRect ( x + (breedte / 3) ,y + (hoogte / 4) ,breedte / 10 , hoogte / 10 ) ;
		g.setColor (new Color ((int) ( 16777216 * Math.random())));
	    g.fillRect ( x + 2 * (breedte / 3) ,y + (hoogte / 4) ,breedte / 10 , hoogte / 10 ) ;
		g.setColor (new Color ((int) ( 16777216 * Math.random())));
	    g.drawArc(x + (breedte / 3) - (breedte / 20) , y + 2 * (hoogte / 4) - (hoogte / 10)  , breedte / 2 , hoogte / 2 , 180 , 180 );
		g.setColor (new Color ((int) ( 16777216 * Math.random())));	  
	    g.drawArc(x + (breedte / 3) - (breedte / 20), y + 2 * (hoogte / 4) - (hoogte / 10) - 1  , breedte / 2 , hoogte / 2 , 180 , 180 );	  
			slaap(20);
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