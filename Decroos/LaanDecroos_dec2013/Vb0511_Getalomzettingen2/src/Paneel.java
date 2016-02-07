/* 
 *  L. Decroos - KHBO - 071120
 * 
 *  Omzetting van een binair/octaal/hex String
 *  naar een long formaat 
 *  Verschillende mogelijkheden worden getest
 * 
 */
 
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
// eventueel extra imports hier

public class Paneel extends JPanel {
    // declaraties van de variabelen
    
    // referenties naar objecten 
  private JLabel label;
  private JButton knop;
  private JTextField tekstvak;
    
    // primitieve variabelen
  String s = "";       // in te lezen String
  long   getal = 0;    // zal het getal bevatten
  int    drawMode = 0; // in begin niets afdrukken
  int    yPos = 50;    // tekenpositie voor uitvoer
  String msg = "";     // uitvoer bericht
  
    // Constructor
  public Paneel() {
	  // label aanmaken
	label = new JLabel ("Geef een binair getal en druk <Enter>");
	label.setOpaque(true);
    
    tekstvak = new JTextField( 10 );
    tekstvak.addActionListener( new VakHandler() );
    
    add( label);
    add( tekstvak );
  }
     
      // tekenwerk hier
  public void paintComponent( Graphics g ) {
      
      if(drawMode == 0) super.paintComponent( g );
      
      if ( (drawMode>=1) && (drawMode <= 3) ){
      	g.drawString (msg, 10, yPos);
      	yPos += 50;
      }
      
      if (drawMode >3){
      	g.drawString("En ook dit is mogelijk ! ",10,yPos); 
      	yPos += 50;	
        
        s = "Bachelor123" ;       // in het 36-delig stelsel !
        getal = Long.parseLong(s,36); // met radix 36 
        g.drawString("Het rare getal " + s + " is gelijk aan decimaal " + getal,10,yPos);
      }
  }
  
      // interne klasse voor event-handler
  class VakHandler implements ActionListener {
    public void actionPerformed( ActionEvent e ) {
       // hier komen de event-handler opdrachten
      drawMode++;
      try {
  	    s = tekstvak.getText(); // common opdracht buiten switch
  	    switch(drawMode){
  	    	case 1 : // BINAIR
  	          
              getal = Long.parseLong(s,2); // radix 2, dit is de eenvoudigste methode
              /*  bekijk ook volgende alternatieve opdracht :
                  hierbij moet je nog Long naar long omzetten
                  g = Long.valueOf(s,2).longValue();              */
              msg = "Het binaire getal " + s + " is gelijk aan decimaal " + getal ;
              label.setText("Geef een octaal getal en druk <Enter>");
              break;
            case 2 : // OCTAAL
              
              getal = Long.parseLong(s,8);  // met radix 8
              /*  hier heb je twee alternatieven :
                   getal = Long.decode ("0" + s).longValue();   ( '0' = nul )
                   of     
                   getal = Long.valueOf(s,8).longValue();           */
              msg = "Het octale getal " + s + " is gelijk aan decimaal " + getal;
              label.setText("Geef een hex getal en druk <Enter>");
              break;
            case 3 : // HEX
              getal = Long.parseLong(s,16); // met radix 16
              /* ook hier twee alternatieven :
                  getal = Long.decode ("0x" + s).longValue(); 
                        let op  = ("nul" + "x" + "getal")         
                  of
                  getal = Long.valueOf(s,16).longValue();          */
              msg = "Het hex getal " + s + " is gelijk aan decimaal " + getal;
              label.setText("Druk nog eens op <Enter>");
              break; // hoeft niet maar je weet nooit of je nog gaat uitbreiden, dus ...
  	      }
  	      
        }
        catch (NumberFormatException err) {	
           System.out.println (err); 
           msg = "Verkeerde invoer !";  
           drawMode--;	
        }
        tekstvak.setText("");
        repaint();
    }
  } // einde VakHandler
  
} // einde programma