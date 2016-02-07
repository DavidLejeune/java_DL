/**
 * @(#)Oefening3_Multimeter.java
 *
 * Oefening3_Multimeter application
 * @author David Lejeune - 1PB-ICT
 * @version 1.00 2014/10/23
 *
 * Poging om een multimeter na te bootsen
 *
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
// eventueel extra imports hier

public class Oefening3_Multimeter extends JFrame {  

	
	
	
    public static void main(String[] argumentenRij) {
       JFrame frame = new Oefening3_Multimeter();
       frame.setSize(800,600);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setTitle("Oefening3_Multimeter");
         // naam aanpassen als je Paneel van naam wijzigt !!!
       Paneel paneel = new Paneel();
       frame.setContentPane( paneel );
       frame.setVisible(true); 
       frame.setLocationRelativeTo(null);    	
    }
}

class Paneel extends JPanel {
    // declaraties van de variabelen, schrap wat je niet gebruikt !
	private String meterstandTekstvakinhoud;
	private int meterstandTekstvakinhoud_int;
	private int actueleMeterstand;
    
    // referenties naar objecten 
  private JLabel label;
  private JTextField tekstvak;
  private Multimeter multimeter;
    
    // primitieve variabelen
  boolean p;
  char    ch;
  int     i,j,k;
  double  r,s,t;
  
    // Constructor
  public Paneel() {
	  // label aanmaken
	label = new JLabel ("Geef de nieuwe meterstand + <enter>");	  
	multimeter = new Multimeter(); 
    
      // vak aanmaken op deze wijze ...
    tekstvak = new JTextField( 20 );
    tekstvak.addActionListener(new meterstandVakhandler());
    
    
    
    
      // alle elementen toevoegen aan paneel-object
    add( label);
    add( tekstvak );
  }
     
      // alle tekenwerk hier
  public void paintComponent( Graphics g ) {
      super.paintComponent( g );
      // hier komen de tekenopdrachten
      
      
      g.drawLine(100,150,600,150);
      g.drawLine(100,130,100,150);
      g.drawLine(100,130,100,150);
      g.drawLine(150,130,150,150);
      g.drawLine(200,130,200,150);
      g.drawLine(250,130,250,150);
      g.drawLine(300,130,300,150);
      g.drawLine(350,130,350,150);
      g.drawLine(400,130,400,150);
      g.drawLine(450,130,450,150);
      g.drawLine(500,130,500,150);
      g.drawLine(550,130,550,150);
      g.drawLine(600,130,600,150);
      
      
      
      int meterstandReturn = multimeter.getMeterstand();
      // deze println was gewon ter controle voor mij tijdens het programmeren
      System.out.println(meterstandReturn);
      
      // als waarde boven of gelijk aan 80% is duid gevaar aan
      if (meterstandReturn >= 400)
      {
      	g.setColor(Color.RED);
      }
      else
      {
      	g.setColor(Color.BLUE);
      }
      g.fillRect(100,150,meterstandReturn,20);	
      	
      	
      
      
      
      double dialValue = (meterstandReturn /5) * -0.9;
      int dialValueRounded = (int)Math.round(dialValue);
      
      // als waarde boven of gelijk aan 80% is duid gevaar aan
      if (meterstandReturn >= 400)
      {
      	g.setColor(Color.RED);
      }
      else
      {
      	g.setColor(Color.BLUE);
      }
        
      	g.fillArc(150,200,400,400,45,90);
      	// dit was een opsplitsing in een gevarenzone, vond het niet zo mooi
      	//g.setColor(Color.RED);
        //g.fillArc(150,200,400,400,45,18);
      
      // deze println was gewon ter controle voor mij tijdens het programmeren
      //System.out.println(myDial);
      


      	
      	
      g.setColor(Color.YELLOW);
      g.fillArc(150,200,400,400,135 + dialValueRounded,2);	
      	
  }
  

  
  
      // interne klasse voor event-handler
  class meterstandVakhandler implements ActionListener {
    public void actionPerformed( ActionEvent e ) {
       // hier komen de event-handler opdrachten
       
       
       	meterstandTekstvakinhoud = tekstvak.getText();
  		meterstandTekstvakinhoud_int = Integer.parseInt(meterstandTekstvakinhoud);
  		meterstandTekstvakinhoud_int = meterstandTekstvakinhoud_int *5;

  		multimeter.setMeterstand(meterstandTekstvakinhoud_int);

		repaint();

  		
  		
       
       // niet vergeten (indien nodig) :
       //validate();
       
    }
  }
 
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