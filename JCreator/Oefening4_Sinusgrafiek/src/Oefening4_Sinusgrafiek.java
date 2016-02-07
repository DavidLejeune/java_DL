/**
 * @(#)Oefening4_Sinusgrafiek.java
 *
 * Oefening4_Sinusgrafiek application
 * @author David Lejeune - 1PBICT
 * @version 1.00 2014/11/13
 *
 * Teken een sinusgrafiek op het scherm
 *
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
// eventueel extra imports hier

public class Oefening4_Sinusgrafiek extends JFrame {  
    
    public static void main(String[] argumentenRij) {
       JFrame frame = new Oefening4_Sinusgrafiek();
       frame.setSize(900,700);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setTitle("Oefening4_Sinusgrafiek");
         // naam aanpassen als je Paneel van naam wijzigt !!!
       Paneel paneel = new Paneel();
       frame.setContentPane( paneel );
       frame.setVisible(true);    	
    }
}

class Paneel extends JPanel {
    // declaraties van de variabelen, schrap wat je niet gebruikt !
    
    // referenties naar objecten 
  private JLabel labelAantal;
  private JLabel labelAmplitude;
  private JLabel labelBeginfase;
  private JTextField tekstvakAantal;
  private JTextField tekstvakAmplitude;
  private JTextField tekstvakBeginfase;
  private JButton knop;
    
    // primitieve variabelen
  boolean p;
  char    ch;
  int     i,j,k;
  double  r,s,t;
  
    // Constructor
  public Paneel() {
  	setLayout(null);
  	
	  // label aanmaken
	labelAantal = new JLabel (" Aantal ");	
	labelAmplitude = new JLabel (" Amplitude ");
	labelBeginfase = new JLabel (" Beginfase ");	
		
	labelAantal.setBounds(50,20,150,20);
	labelAmplitude.setBounds(150,20,200,20);
	labelBeginfase.setBounds(250,20,300,20); 
    labelAantal.setForeground (Color.GREEN);
    labelAmplitude.setForeground (Color.GREEN);
    labelBeginfase.setForeground (Color.GREEN);
	  
	  // knop aanmaken en koppelen met event-handler
    knop = new JButton( "GO" );
    knop.setBounds(350,50,80,30);
    knop.addActionListener( new KnopHandler() );
    
      // vak aanmaken op deze wijze ...
    tekstvakAantal = new JTextField(20);
    tekstvakAmplitude = new JTextField( 20);
    tekstvakBeginfase = new JTextField(20 );
    
    tekstvakAantal.setBounds(50,50,50,30);
    tekstvakAmplitude.setBounds(150,50,50,30);
    tekstvakBeginfase.setBounds(250,50,50,30); 
    
    
    
      // alle elementen toevoegen aan paneel-object
    add( labelAantal);
    add( labelAmplitude);
    add( labelBeginfase);
    add( knop );
    add( tekstvakAantal );
    add( tekstvakAmplitude );
    add( tekstvakBeginfase );
  }
     
      // alle tekenwerk hier
  public void paintComponent( Graphics g ) {
      super.paintComponent( g );
      // hier komen de tekenopdrachten
      
      
      g.setColor(Color.BLACK);
      g.fillRect(0,0,1000,800);
      
      
      g.setColor(Color.DARK_GRAY);
		g.drawLine(50,150,770,150);
		g.drawLine(50,200,770,200);
		g.drawLine(50,250,770,250);
		g.drawLine(50,300,770,300);
		g.drawLine(50,400,770,400);
		g.drawLine(50,450,770,450);
		g.drawLine(50,500,770,500);
		g.drawLine(50,550,770,550);
      //g.setColor(Color.GRAY);
		g.drawLine(122,100,122,600);
		g.drawLine(194,100,194,600);
		g.drawLine(266,100,266,600);
		g.drawLine(338,100,338,600);
		g.drawLine(410,100,410,600);
		g.drawLine(482,100,482,600);
		g.drawLine(554,100,554,600);
		g.drawLine(626,100,626,600);
		g.drawLine(698,100,698,600);
		
		
		
      g.setColor(Color.WHITE);
		g.drawLine(50,100,50,600);
		g.drawLine(50,350,770,350);	
		g.drawRect(50,100,720,500);
      
  }
  
      // interne klasse voor event-handler
  class KnopHandler implements ActionListener {
    public void actionPerformed( ActionEvent e ) {
       // hier komen de event-handler opdrachten
       
       	Graphics g = getGraphics(); 

		int xStart = 50;
		int yStart = 350;
		int x=0;
		int y=0;
		int iCount = 0;
		double grad,rad;
		
  		double aantal = Double.parseDouble(tekstvakAantal.getText());
  		double amplitude= Double.parseDouble(tekstvakAmplitude.getText());
  		double beginfase = Double.parseDouble(tekstvakBeginfase.getText());


//		int mycolor = (int) (new Color ((int) ( 16777216 * Math.random())));
		
		if (amplitude > 250)
			
	
		{
			
      		g.setColor(Color.BLUE);
			String regel = "You need to stay within the bounds . 250 Amplitude";
			g.drawString(regel ,250 ,200);
		}
		if (amplitude < 250)
		{
			// loop that shit
				while (amplitude < 250)
		{
		
		for (i = 0 ; i<2880 ; i++)
		{
			
		// grad = Math.round (aantal * i / 2.0);
		
		rad = aantal * i  /  4.0 / 2.0 * Math.PI / 180.0;
		double beginrad = beginfase * Math.PI / 180.0;
		//System.out.println(y);
		//x = (int) Math.sin(x) ;
		// + Math.sin( Math.toRadians(beginfase) )
		y =(int)( yStart  - amplitude * Math.sin(rad + beginrad)  ) ;

      	//g.setColor(Color.YELLOW);
      	slaap(1);
      	g.drawLine(i / 4 + 50,y ,i / 4 + 50,y);
      	//g.fillOval(i / 8 + 50,y ,4,4);	
 
 	if (y==350)
		{    
			
      	g.setColor(Color.WHITE);
			String tregel = "t" + iCount ;
						
			g.drawString(tregel ,i / 8 + 55 ,y - 10);

			iCount += 1;
			

			
		}		 	
		}
		amplitude = amplitude + 10;
//		mycolor = new Color ((int) ( 16777216 * Math.random()));

		Color kleur = new Color ((int) ( 16777216 * Math.random()));
		g.setColor(kleur);
		}
		
		}
		
		 	amplitude = amplitude + 5;
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