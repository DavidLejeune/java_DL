/**
 * @(#)Vb1313_Lichtkrant_Timer.java
 *
 * Vb1313_Lichtkrant_Timer application
 *                  
 * @author Luc Decroos
 * @version 1.00 2011/4/28
 *
 * Beschrijving : Timer versie van de Lichtkrant
 *
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// eventueel extra imports hier

public class Vb1313_Lichtkrant_Timer extends JFrame {  
    
    public static void main(String[] argumentenRij) {
       JFrame frame = new Vb1313_Lichtkrant_Timer();
       frame.setSize(800,200);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setTitle("Vb1313 Lichtkrant met een Timer");
         // naam aanpassen als je Paneel van naam wijzigt !!!
       Paneel paneel = new Paneel();
       frame.setContentPane( paneel );
       frame.setVisible(true);    	
    }
}

class Paneel extends JPanel {
    // declaraties van de variabelen, schrap wat je niet gebruikt !
  private JPanel noordPaneel, centerPaneel, zuidPaneel; 
  	
    // referenties naar objecten 
    // voor noord 
  private JLabel label; // label voor Lichtkrant in noordpaneel
    // voor zuid
  private JButton knop, knop2;
  private JTextField tekstvak;
    
  private Timer timer;
    
  private String tekst = "             Lichtkrant ... tik onderaan iets anders en klik op de knop ... ";
  private StringBuffer sb = new StringBuffer(tekst);
  char temp = ' ';
  int len = sb.length();
  int x = 10;
  
    // Constructor
  public Paneel() {
  	setLayout (new BorderLayout());
  	
  	// noordpaneel
    noordPaneel = new JPanel();
    noordPaneel.setLayout (new FlowLayout());
    noordPaneel.setBackground(Color.cyan);
    	  // label aanmaken
	label = new JLabel ("");
	label.setFont(new Font ("Arial", Font.BOLD,  48));
	label.setForeground( Color.RED);
	noordPaneel.add (label);
	add (noordPaneel, BorderLayout.NORTH);	
  	
  	
  	 	
  	//centerpaneel
  	centerPaneel= new JPanel();
  	add (centerPaneel, BorderLayout.CENTER);

  	 	
  	//zuidPaneel : bediening
  	zuidPaneel  = new JPanel();
  	zuidPaneel.setLayout (new FlowLayout());

  	tekstvak = new JTextField( 50 );
    knop = new JButton( "Change" ); 
    knop.addActionListener( new KnopHandler() );
    knop2 = new JButton( "Balletje" ); 
    knop2.addActionListener( new Knop2Handler() );
    zuidPaneel.add (tekstvak);
    zuidPaneel.add (knop);
    zuidPaneel.add (knop2);
	add (zuidPaneel, BorderLayout.SOUTH);
	
      // timer instantie maken en starten
    timer = new Timer( 200, new TimerHandler() );
    timer.start();
  }

      // interne klasse voor event-handler
  class KnopHandler implements ActionListener {
    public void actionPerformed( ActionEvent e ) {
       // hier komen de event-handler opdrachten
       tekst = "           " + tekstvak.getText();
       sb = new StringBuffer(tekst);
       temp = ' ';
       len = sb.length();
       }
  }
  
  class Knop2Handler implements ActionListener {
    public void actionPerformed( ActionEvent e ) {
       Graphics g  = centerPaneel.getGraphics();
   	   //vorige wissen
   	   g.setColor(centerPaneel.getBackground()); 
       g.fillOval( x, 20, 80, 50 );
       //beetje naar rechts
       x += 5;
       //nieuw balletje tekenen
       g.setColor(Color.RED );       
       g.fillOval( x, 20, 80, 50 );
    }}
  
  class TimerHandler implements ActionListener{
    public void actionPerformed( ActionEvent e ) {
      //tekst doorschuiven
      temp  = sb.charAt(0);
      for (int pos = 0; pos < len-1; pos++) sb.setCharAt(pos, sb.charAt(pos+1));
      sb.setCharAt( len-1, temp);
      int a = len/3;
      int b = 2*a;
      String s = sb.toString().substring(a,b);
      //tekst afdrukken
      label.setText(s);
      
    }
  }
     // slaap routine, schrappen indien niet gebruikt
  public static void slaap (int mSec){		 
		try {
			Thread.currentThread().sleep(mSec); 
		} catch (InterruptedException e){ }
	} 
  
}