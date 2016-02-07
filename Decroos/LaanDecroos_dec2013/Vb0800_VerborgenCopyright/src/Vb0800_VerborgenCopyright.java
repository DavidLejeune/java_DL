/**
 * @(#)Vb0800_VerborgenCopyright.java
 *
 * Vb0800_VerborgenCopyright application
 * @author Luc Decroos - KHBO
 * @version 1.00 2008/3/5
 *
 * Beschrijving : copyright verbergen in je programma 
 *                + detectie van wijzigingen in de class file
 *
 * een toepassing op String en StringBuffer
 *
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
// eventueel extra imports hier

public class Vb0800_VerborgenCopyright extends JFrame {  
    
    public static void main(String[] argumentenRij) {
       JFrame frame = new Vb0800_VerborgenCopyright();
       frame.setSize(800,700);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setTitle("Vb0800_VerborgenCopyright");
         // naam aanpassen als je Paneel van naam wijzigt !!!
       Paneel paneel = new Paneel();
       frame.setContentPane( paneel );
       frame.setVisible(true);    	
    }
}

class Paneel extends JPanel {
    // declaraties van de variabelen, schrap wat je niet gebruikt !
    
    // referenties naar objecten 

  private JButton knop1;
  private ImageIcon p1,p2;
  
    
  private String notice =  "Copyright Luc Decroos - KHBO - 2012"; // valse tekst
	                   // valse tekst is leesbaar in de bytecode (class file)
	
  private String code =    "Tfgpizxyk Clt Uvtiffj - BYSF - 2012"; // echte tekst
	        // is met een zwak codeer-algoritme, cijfers zijn nog zichtbaar !!!
	        // als 't voor echt is, iets beter coderen ... (zie les Wiskunde)

  private boolean toegang = false;  // toegang tot programma ?   

  
    // Constructor
  public Paneel() {
	  
	  // knop aanmaken en koppelen met event-handler
    knop1 = new JButton( " ENTER " );
    knop1.addActionListener( new KnopHandler() );

    add( knop1 );
    p1 = new ImageIcon("welkom.png");
    p2 = new ImageIcon("doodshoofd.jpg");
  }
     
      // alle tekenwerk hier
  public void paintComponent( Graphics g ) {
      super.paintComponent( g );
      
      //voor de uitleg, de originele tekst coderen :
      StringBuffer temp = new StringBuffer(notice);
      System.out.println(""+codeer(temp,17));
      StringBuffer codeb = new StringBuffer(code);  
      codeb = decodeer(codeb,17);                   // decoderen met sleutel 17
      String actueel = codeb.toString();
      
      g.drawString (actueel, 10,30);
      
      
      if (actueel.equals (notice)){
      	g.drawString ("Legale versie gevonden, ga gerust verder", 10,60);
      	p1.paintIcon(this,g,100,100);
      	toegang = true;
      }
      else{
      	g.drawString ("Helaba, niet met mijn programma knoeien , hé !", 10,60);
      	p2.paintIcon(this,g,100,100);
      	toegang = false;
      }	
      
      
      
  }
  
      // interne klasse voor event-handler
  class KnopHandler implements ActionListener {
    public void actionPerformed( ActionEvent e ) {
       // hier komen de event-handler opdrachten
       // ...
       if (toegang) {
       	 // wat het programma moet doen ...
       }
    }
  }
  
  
                     // codeer-routine, hier niet nodig
	public StringBuffer codeer (StringBuffer zin, int k) {   
		int i,code;				
		char ch;
		StringBuffer zin2 = zin;
		
		for ( i=0; i<zin.length() ; i++) {
			ch = zin.charAt(i);    // charAt(i) = karakter op positie i uithalen
			code = (int) ch;	           // ascii-code bepalen
			   
			   //enkel letters worden verwerkt
			if ((ch>='A') && (ch<='Z')){
			code = code + k;
			if ((char) code > 'Z') code = code - 26;
			}
			
			if ((ch>='a') && (ch<='z')){
				code = code + k;
				if ((char) code > 'z') code = code - 26;
			}
			
 	  		ch = (char) code;
 	  		zin2.setCharAt(i,ch);                       // code weggsteken in zin2
 	  	  	
		}	
		return zin2;
	}
                                 // hiermee verborgen tekst terug leesbaar maken
                                 // = omkeren wat codeer() gedaan heeft
    public StringBuffer decodeer (StringBuffer zin, int k) {
		int i,code;				
		char ch;
		StringBuffer zin2 =zin;
		
		for ( i=0; i<zin.length() ; i++) {
			ch = zin.charAt(i);    // charAt(i) = karakter op positie i uithalen
			code = ch;	           // ascii-code bepalen
			   
			   //enkel letters worden verwerkt
			if ((ch>='A') && (ch<='Z')){
			code = code - k;
			if ((char) code < 'A') code = code + 26;
			}
			
			if ((ch>='a') && (ch<='z')){
				code = code - k;
				if ((char) code < 'a') code = code + 26;
			}
			
 	  		ch = (char) code;
 	  		zin2.setCharAt(i,ch);                       // code weggsteken in zin2
 	  	  	
		}	
		return zin2;
	}  
}