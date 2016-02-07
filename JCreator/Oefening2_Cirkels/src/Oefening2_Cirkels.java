/**
 * @(#)Oefening2_Cirkels.java
 *
 * Oefening2_Cirkels application
 * @author David Lejeune - 1PB-ICT
 * @version 1.00 2014/10/9
 *
 *  een Java programma dat drie gegevens voor een cirkel inleest uit 
 *  drie tekstvakken :  de x- en y-coordinaat  voor het middelpunt en de diameter. 
 *
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.applet.*;
// eventueel extra imports hier

public class Oefening2_Cirkels extends JFrame {  
    
    public static void main(String[] argumentenRij) {
       JFrame frame = new Oefening2_Cirkels();
       frame.setSize(750,600);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setTitle("Oefening2_Cirkels");
         // naam aanpassen als je Paneel van naam wijzigt !!!
       Paneel paneel = new Paneel();
       frame.setContentPane( paneel );
       frame.setVisible(true);    	
    }
}

class Paneel extends JPanel {
    // declaraties van de variabelen, schrap wat je niet gebruikt !
    
    // referenties naar objecten 
  private JLabel labelX;
  private JLabel labelY;
  private JLabel labelDiameter;
  private JTextField tekstvakX;
  private JTextField tekstvakY;
  private JTextField tekstvakDiameter;
  private JButton knopTEKEN;
  private JButton knopLEFT;  
  private JButton knopRIGHT;
  private JButton knopLARGER;
  private JButton knopUP;
  private JButton knopDOWN;
  private int BoundingBox_x_circle;
  private int BoundingBox_y_circle;
  private int circle_height;
  private int circle_width;
  private String X_center;
  private String Y_center;
  private String Diameter_invoer;
  private int X_center_int;
  private int Y_center_int;
  private int Diameter_invoer_int;
  
    
    // primitieve variabelen
  boolean p;
  char    ch;
  int     i,j,k;
  double  r,s,t;
  
    // Constructor
  public Paneel() {
	  // label aanmaken
	labelX = new JLabel (" Geef x center : ");
      // vak aanmaken op deze wijze ...
    tekstvakX = new JTextField( 10 );
    
	  // label aanmaken
	labelY = new JLabel (" Geef y center : ");
      // vak aanmaken op deze wijze ...
    tekstvakY = new JTextField( 10 );
	  // label aanmaken
	labelDiameter = new JLabel (" Geef diameter ");
      // vak aanmaken op deze wijze ...
    tekstvakDiameter = new JTextField( 10 );	  
	  
	  // knop aanmaken en koppelen met event-handler
    knopTEKEN = new JButton( "TEKEN" );
    knopTEKEN.addActionListener( new KnopHandler() );
    knopLEFT = new JButton( "<<<" );
    knopLEFT.addActionListener( new KnopHandlerLEFT() );
    knopRIGHT = new JButton( ">>>" );
    knopRIGHT.addActionListener( new KnopHandlerRIGHT() );
    knopUP = new JButton( "UP" );
    knopUP.addActionListener( new KnopHandlerUP() );
    knopDOWN = new JButton( "DOWN" );
    knopDOWN.addActionListener( new KnopHandlerDOWN() );
    knopLARGER = new JButton( "++" );
    knopLARGER.addActionListener( new KnopHandlerLARGER() );
    
    
    
    
      // ofwel deze :
    //tekstvak = new JTextField( 10 );
    
      // alle elementen toevoegen aan paneel-object
    add( labelX);
    add( tekstvakX );
    add( labelY);
    add( tekstvakY );
    add( labelDiameter);
    add( tekstvakDiameter );
    add( knopTEKEN );
    add( knopLEFT );
    add( knopRIGHT );
    add( knopUP );
    add( knopDOWN );
    add( knopLARGER );
  }
     
      // alle tekenwerk hier
  public void paintComponent( Graphics g ) {
      super.paintComponent( g );
      // hier komen de tekenopdrachten
      //BoundingBox_x_circle = 20;
      //BoundingBox_y_circle = 100;
      //circle_height = 200;
      //circle_width = 200;
      //Diameter_invoer_int = 200;
      g.setColor(Color.YELLOW);
      g.fillArc(BoundingBox_x_circle,BoundingBox_y_circle,circle_width,circle_height,0,90);
      g.fillArc(BoundingBox_x_circle,BoundingBox_y_circle,circle_width,circle_height,180,90);

      
      g.setColor(Color.BLACK);
      g.drawOval(BoundingBox_x_circle,BoundingBox_y_circle,circle_width,circle_height);
      // horizontale crossheir
      g.drawLine(BoundingBox_x_circle -10 ,BoundingBox_y_circle + (circle_width/2),BoundingBox_x_circle + Diameter_invoer_int + 10,BoundingBox_y_circle + (Diameter_invoer_int/2));
      // verticale crossheir
      g.drawLine(BoundingBox_x_circle + (circle_height /2 ) ,BoundingBox_y_circle -10 ,BoundingBox_x_circle + (circle_height /2) ,BoundingBox_y_circle+ Diameter_invoer_int + 10);
        
      
      
      
  }
  
      // interne klasse voor event-handler
  class KnopHandler implements ActionListener {
    public void actionPerformed( ActionEvent e ) {
       // hier komen de event-handler opdrachten
       
       	X_center = tekstvakX.getText();
  		Y_center = tekstvakY.getText();
  		Diameter_invoer = tekstvakDiameter.getText();
  		
  		X_center_int = Integer.parseInt(X_center);
  		Y_center_int = Integer.parseInt(Y_center);
  		Diameter_invoer_int = Integer.parseInt(Diameter_invoer);
       
       
       BoundingBox_x_circle = X_center_int - (Diameter_invoer_int/2) ;
       BoundingBox_y_circle = Y_center_int - (Diameter_invoer_int/2);
       circle_height = Diameter_invoer_int;
       circle_width = Diameter_invoer_int;
       
       
       // niet vergeten (indien nodig) :
        validate();
        repaint();
    }
  }  
  	class KnopHandlerLEFT implements ActionListener {
    public void actionPerformed( ActionEvent e ) {
       // hier komen de event-handler opdrachten
       
 
       BoundingBox_x_circle = BoundingBox_x_circle - 5;
       
       // niet vergeten (indien nodig) :
        validate();
        repaint();
    }
  }
    class KnopHandlerRIGHT implements ActionListener {
    public void actionPerformed( ActionEvent e ) {
       // hier komen de event-handler opdrachten
       
       BoundingBox_x_circle= BoundingBox_x_circle + 5;
       
       
       // niet vergeten (indien nodig) :
        validate();
        repaint();
    }
  }
  
    class KnopHandlerLARGER implements ActionListener {
    public void actionPerformed( ActionEvent e ) {
       // hier komen de event-handler opdrachten
       AudioClip clip =java.applet.Applet.newAudioClip(getClass().getResource("Camera_Shutter.wav"));

       clip.play();
       circle_height = circle_height + 5;
       circle_width = circle_width + 5;
       Diameter_invoer_int = Diameter_invoer_int + 5;
       
       // niet vergeten (indien nodig) :
        validate();
        repaint();
    }
  }
    class KnopHandlerUP implements ActionListener {
    public void actionPerformed( ActionEvent e ) {
       // hier komen de event-handler opdrachten

       BoundingBox_y_circle = BoundingBox_y_circle - 5;
       
       // niet vergeten (indien nodig) :
        validate();
        repaint();
    }
  }
    class KnopHandlerDOWN implements ActionListener {
    public void actionPerformed( ActionEvent e ) {
       // hier komen de event-handler opdrachten

       BoundingBox_y_circle = BoundingBox_y_circle + 5;
       
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