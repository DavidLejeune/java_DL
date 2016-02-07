/**
 * @(#)Vb0512_ForDemo_Xmas.java
 *
 * Vb0512_ForDemo_Xmas application
 *                  <vul hier steeds je voornaam - naam - klas in> !!!
 * @author Voornaam Naam - Klas
 * @version 1.00 2008/11/5
 *
 * Beschrijving : (vervang door je eigen beschrijving) !!!
 * Een standaard-programma met een paneel met een knop, 
 * tekstvak en event-afhandeling, aan te passen naargelang
 * wat je nodig hebt ...
 *
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// eventueel extra imports hier

public class Vb0512_ForDemo_Xmas extends JFrame {  
    
    public static void main(String[] argumentenRij) {
       JFrame frame = new Vb0512_ForDemo_Xmas();
       frame.setSize(700,700);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setTitle("Vb0512_ForDemo_Xmas");
      // frame.setResizable(false);
         // naam aanpassen als je Paneel van naam wijzigt !!!
       Paneel paneel = new Paneel();
       frame.setContentPane( paneel );
       frame.setVisible(true);    	
    }
}

class Paneel extends JPanel {
  private JButton knop; 
  int     x,y, ro,gr,bl, size;
  boolean geklikt;
  Timer t;
  
    // Constructor
  public Paneel() {
  	setLayout(null);
  	setBackground (Color.BLACK);
  	knop = new JButton( "Go" );
    knop.setBounds (10,10,50,20);
    knop.addActionListener( new KnopHandler() );
    add (knop);
    
    t = new Timer (400, new flashHandler());
    
  }
     
      // alle tekenwerk hier
  public void paintComponent( Graphics g ) {
      super.paintComponent( g );
      
      
  }

  class KnopHandler implements ActionListener {
    public void actionPerformed( ActionEvent e ) {
     // knop.setVisible(false);
      
    Graphics g = getGraphics();
      
      // hier komen de tekenopdrachten
      
      //sterretjes
      for (int i = 0; i < 500; i++){
      	ro = (int) (255 * Math.random() );
        gr = (int) (255 * Math.random() );
        bl = (int) (255 * Math.random() );
        x = (int) (794 * Math.random());
        y = (int) (775 * Math.random());
        
        size = (int) (10 * Math.random() +1 );
      	g.setColor (new Color (ro,gr,bl));
      	g.fillOval (x,y,size,size);
      	slaap (5);
    	
      }
            
//      g.setFont (new Font ("Serif", Font.BOLD, 72));
//  	  
//  	  while (true){
//      	g.setColor (Color.YELLOW);
//      	g.drawString ("MERRY XMAS !!!", 100, 400);
//      	slaap(400);
//      	g.setColor (Color.BLACK);
//      	g.drawString ("MERRY XMAS !!!", 100, 400);
//      	slaap(400);
//      }
      
      
     t.start();
      
      
      
      
    }
  }
  
  class flashHandler implements ActionListener {
    public void actionPerformed( ActionEvent e ) {
      Graphics g = getGraphics();
      g.setFont (new Font ("Serif", Font.BOLD, 72));
  	  //while (true){
      	g.setColor (Color.YELLOW);
      	g.drawString ("MERRY XMAS !!!", 50, 400);
      	slaap(400);
      	g.setColor (Color.BLACK);
      	g.drawString ("MERRY XMAS !!!", 50, 400);
      	
      //}
  
     }
  }
  
     // slaap routine, schrappen indien niet gebruikt
  public static void slaap (int mSec){		 
		try {
			Thread.currentThread().sleep(mSec); 
		} catch (InterruptedException e){ }
	} 
  
}