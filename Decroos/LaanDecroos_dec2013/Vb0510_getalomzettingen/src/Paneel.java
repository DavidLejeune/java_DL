/* 
 * Naam : Luc Decroos - KHBO IW&T - 2007
 * Beschrijving : getallen in verschillende stelsels afdrukken
 */
 
import javax.swing.*;
import java.awt.*;

public class Paneel extends JPanel {

  public Paneel(){
  	setFont( new Font( "Monospaced", Font.BOLD, 14 ) );
  }	
 
  public void paintComponent( Graphics g ) {
      super.paintComponent( g );
      
      int getal = 123;      
      double d = Math.PI;                         
      
      g.drawString( "Een getal in verschillende getalstelsels voorgesteld", 50 , 30); 	  
	  g.drawString( "Decimaal     : " + Integer.toString(getal)       , 50, 60 ); 
	  g.drawString( "Hexadecimaal : " + Integer.toHexString(getal)    , 50, 80 );  
	  g.drawString( "Octaal       : " + Integer.toOctalString(getal)  , 50, 100);  
	  g.drawString( "Binair       : " + Integer.toBinaryString(getal) , 50, 120);
	  
	  g.drawString( "Getal PI (double) HEX : " + Double.toHexString(d) , 50, 140);
   }
}