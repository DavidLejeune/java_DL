/**
 * @(#)Oefening5a_HogerLager.java
 *
 * Oefening5a_HogerLager application
 * @author David Lejeune - 1PBICT
 * @version 1.00 2014/11/27
 *
 * Old school hoger lager spelletje
 *
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import  java.applet.*;
// eventueel extra imports hier

public class Oefening5a_HogerLager extends JFrame {  
    
    public static void main(String[] argumentenRij) {
       JFrame frame = new Oefening5a_HogerLager();
       frame.setSize(600,150);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setTitle("Oefening5a_HogerLager");
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
  private JLabel labelKeuze;
  private JLabel labelResultaat;
  private JLabel labelInfo;
  private JButton knop;
  private JTextField tekstvakKeuze;
  private JTextField tekstvakResultaat;
  private int randomNumber;
  private int aantalGokken;
  AudioClip clipOK = java.applet.Applet.newAudioClip(getClass().getResource("applause-01.wav")); 
  AudioClip clipNOK = java.applet.Applet.newAudioClip(getClass().getResource("laughter-2.wav")); 
  private Boolean boolStart;
    
    // primitieve variabelen
  boolean p;
  char    ch;
  int     i,j,k;
  double  r,s,t;
  
    // Constructor
  public Paneel() {
	  // label aanmaken
	labelKeuze = new JLabel ("Maak uw keuze");
	labelResultaat = new JLabel (" Resultaat ");
	labelInfo = new JLabel ("<html> Klik op de knop start. Een random nummer wordt dan gekozen.<br>Vul uw gok (0-999) in het vakje 'uw keuze'. De positie van uw getal laat u<br> toe uw volgende keuze beter te kiezen.Veel geluk</html>");
	  
	  // knop aanmaken en koppelen met event-handler
    knop = new JButton( "Start" );
    knop.addActionListener( new KnopHandler() );
    
      // vak aanmaken op deze wijze ...
    tekstvakKeuze = new JTextField( 10);
    tekstvakKeuze.addActionListener(new keuzeVakhandler());
    tekstvakResultaat = new JTextField( 20);
    
      // ofwel deze :
    //tekstvak = new JTextField( 10 );
    
      // alle elementen toevoegen aan paneel-object
    add( knop );
    add( labelKeuze);
    add( tekstvakKeuze );
    add( labelResultaat);
    add( tekstvakResultaat );
    add( labelInfo);
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
       boolStart = true;
       
       randomNumber= (int) (Math.random () * 999); 
       
     System.out.println(randomNumber); 
   		labelInfo.setText ("<html>The game has started</html>");
	   	repaint();     
       // niet vergeten (indien nodig) :
       // validate();
       // repaint();
    }
  }
  
  
    class keuzeVakhandler implements ActionListener {
    public void actionPerformed( ActionEvent e ) {
       // hier komen de event-handler opdrachten
       
       aantalGokken += 1;
       
       if (boolStart)
       {
       
  		int Keuze_int = Integer.parseInt(tekstvakKeuze.getText());
  		

  		
  		if (Keuze_int == randomNumber)
			{
				tekstvakResultaat.setText("Goed geraden in " + aantalGokken + " beurt(en)");
				labelInfo.setText ("<html> Klik op de knop start. Een random nummer wordt dan gekozen.<br>Vul uw gok in het vakje 'uw keuze'. De positie van uw getal laat u<br> toe uw volgende keuze beter te kiezen.Veel geluk</html>");
	  
				clipOK.play(); 
				boolStart = false;
			}
		
  		if (Keuze_int < randomNumber)
			{
				tekstvakResultaat.setText("Hoger");
				clipNOK.play(); 
			}
			
  		if (Keuze_int > randomNumber)
			{
				tekstvakResultaat.setText("Lager");
				clipNOK.play(); // éénmalig dit geluid afspelen
			}
       }
					
		
		
		repaint();

  		
  		
       
       // niet vergeten (indien nodig) :
       //validate();
       
    }
  }
}
  
  
