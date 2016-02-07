/**
 * @(#)Vb1313_Lichtkrant_Thread.java
 *
 * Vb1313_Lichtkrant_Thread application
 *                  
 * @author Luc Decroos - KHBO
 * @version 1.00 2011/5/16
 *
 * Beschrijving : Thread versie van de Lichtkrant
 *
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// eventueel extra imports hier

public class Vb1313_Lichtkrant_Thread extends JFrame {  
    
    public static void main(String[] argumentenRij) {
       JFrame frame = new Vb1313_Lichtkrant_Thread();
       frame.setSize(800,600);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setTitle("Vb1313_Lichtkrant_Thread");
         // naam aanpassen als je Paneel van naam wijzigt !!!
       Paneel paneel = new Paneel();
       frame.setContentPane( paneel );
       frame.setVisible(true);    	
    }
}

class Paneel extends JPanel {
    // declaraties van de variabelen, schrap wat je niet gebruikt !
    
    // referenties naar objecten 
private JPanel noordPaneel, centerPaneel, zuidPaneel; 
  	
    // referenties naar objecten 
    // voor noord 
  private JLabel label; // label voor Lichtkrant in noordpaneel
    // voor zuid
  private JButton knop, knop2;
  private JTextField tekstvak;
    
  private Lichtkrant lichtkrant;
    
  private String tekst = "             Lichtkrant ... tik onderaan iets anders en klik op 'Change' ... ";
  private StringBuffer sb = new StringBuffer(tekst);
  char temp = ' ';
  int len = sb.length();
  int x = 10, y=10;
  
    
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
	
	  // thread instantie maken en starten
	lichtkrant = new Lichtkrant();
	lichtkrant.start();
	
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
       g.fillOval( x, y, 80, 50 );
       //beetje naar rechts
       x += 5;
       y += 5;
       //nieuw balletje tekenen
       g.setColor(Color.RED );       
       g.fillOval( x, y, 80, 50 );
    }}
  
     // slaap routine, schrappen indien niet gebruikt
  public static void slaap (int mSec){		 
		try {
			Thread.currentThread().sleep(mSec); 
		} catch (InterruptedException e){ }
	}
	
	
  class Lichtkrant extends Thread {
  	
    // geen constructor nodig --> automatic default constructor
  	
  	
  	public void run(){
  	  while (true){
  	  	temp  = sb.charAt(0);
        for (int pos = 0; pos < len-1; pos++) sb.setCharAt(pos, sb.charAt(pos+1));
        sb.setCharAt( len-1, temp);
        int a = len/3;
        int b = 2*a;
        String s = sb.toString().substring(a,b);
        //tekst afdrukken
        label.setText(s);
        //even wachten
        slaap(250);
  	  }
  	  
  	}
  } 
  
}