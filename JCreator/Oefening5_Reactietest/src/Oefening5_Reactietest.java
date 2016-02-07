/**
 * @(#)Oefening5_Reactietest.java
 *
 * Oefening5_Reactietest application
 * @author David Lejeune
 * @version 1.00 2014/11/26
 *
 * Reactietestje 
 *
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
// eventueel extra imports hier

public class Oefening5_Reactietest extends JFrame {  
    
    public static void main(String[] argumentenRij) {
       JFrame frame = new Oefening5_Reactietest();
       frame.setSize(400,300);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setTitle("Meet je reactietijd!");
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
  private JLabel labelInfo;
  private JLabel labelKlik;
  private JLabel labelTijd;
  private JButton bStart;
  private JButton bStop;
  private JTextField tekstvakAantal;
  private int intStartTijd;
  private Boolean startOK;
  private long tijdStart;
    
    // primitieve variabelen
  boolean p;
  char    ch;
  int     i,j,k;
  double  r,s,t;
  
    // Constructor
  public Paneel() {
  	
  	
  	setLayout(null);
  	
	  // label aanmaken
	labelInfo  = new JLabel ("<html> klik eerst op start , na een willekeurige <br>tijd wordt ergens een label zichtbaar.<br> Klik dan zo snel mogelijk op STOP</html> ");	  
	labelKlik  = new JLabel ("");
	labelTijd  = new JLabel (" Jouw Tijd ");	  
	  	  
	  // knop aanmaken en koppelen met event-handler
    bStart = new JButton( "Start" );
    bStart.addActionListener( new KnopHandlerStart() );
    bStop = new JButton( "Stop" );
    bStop.addActionListener( new KnopHandlerStop() );
    
    
	labelInfo.setBounds(125,25,250,100); 
	labelKlik.setBounds(125,100,250,100); 
	labelKlik.setFont(new Font ("Consolas" , Font.BOLD , 20));
    labelKlik.setBackground (Color.GREEN);
    //labelInfo.setForeground (Color.GREEN);
       
    bStart.setBounds(125,10,100,25);
    bStop.setBounds(250,10,100,25);
    tekstvakAantal = new JTextField(20);
	tekstvakAantal.setBounds(10,10,100,25); 
    
    
    
      // alle elementen toevoegen aan paneel-object
    add( labelInfo );
    add ( labelKlik );
    add ( labelTijd) ;
    add( bStart );
    add( bStop );
    add( tekstvakAantal);
  }
     
      // alle tekenwerk hier
  public void paintComponent( Graphics g ) {
      super.paintComponent( g );
      // hier komen de tekenopdrachten
      
      
      
  }
  
      // interne klasse voor event-handler
  class KnopHandlerStop implements ActionListener {
    public void actionPerformed( ActionEvent e ) {
       // hier komen de event-handler opdrachten
       
       if (startOK)
       {
       		long tijdNu = System.currentTimeMillis(); 
       		long resultaat = tijdNu - tijdStart;
     		tekstvakAantal.setText(resultaat + " ms");
     		labelKlik.setText("");
       		
       }
       
       
       // niet vergeten (indien nodig) :
       // validate();
       // repaint();
    }
  }
  
        // interne klasse voor event-handler
  class KnopHandlerStart implements ActionListener {
    public void actionPerformed( ActionEvent e ) {
       // hier komen de event-handler opdrachten
       
       	startOK = false;
     	tekstvakAantal.setText("");
      	repaint();
       
     	long tijd = System.currentTimeMillis(); 
     	System.out.println(tijd); 
     //System.out.println(randomtijd);
     //slaap(randomtijd);  
     	int slaapTijd = (int) (Math.random () * 999); 
       
     	System.out.println(slaapTijd); 
    	slaap(slaapTijd);
    	tijdStart = System.currentTimeMillis(); 
    	 System.out.println(tijdStart); 
     	labelKlik.setText("KLIK NU");
     	
     	startOK = true;
     	
     
		 // niet vergeten (indien nodig) :
       validate();
        repaint();
    }
  }
  
     // slaap routine, schrappen indien niet gebruikt
  public static void slaap (int mSec){		 
		try {
			Thread.currentThread().sleep(mSec); 
		} catch (InterruptedException e){ }
	} 
  
}