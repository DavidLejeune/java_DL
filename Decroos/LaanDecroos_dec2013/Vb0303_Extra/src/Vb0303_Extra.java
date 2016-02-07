// Voorbeeld 0303 "extra"
// Decimaal naar binair omzetten (zie Digitaaltechniek in 2e semester)
import javax.swing.*;
import java.awt.*;   
   
public class Vb0303_Extra extends JFrame {
  public static void main( String args[] ) {
    JFrame frame = new Vb0303_Extra();
    frame.setSize( 400, 200 );
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    frame.setTitle( "Voorbeeld 0303" );
    frame.setContentPane( new Paneel() );
    frame.setVisible( true );
  }
}

// Het paneel 
class Paneel extends JPanel {
  private int getal, rest, 
  	          bin8, bin4, bin2, bin1 ;
    
  public Paneel() {
    setBackground( Color.WHITE );
    getal = 11 ;     // later : getal-invoer door gebruiker
    
    bin8 = getal/8;  // 1
    rest = getal%8;  //    3
    bin4 = rest/4;   // 0
    rest = rest%4;   //    3
    bin2 = rest/2;   // 1
    //laatste rest is meteen laatste cijfer
    bin1 = rest%2;   // 1
  }
  
  public void paintComponent( Graphics g ) {
    super.paintComponent( g );
    g.drawString( "Het decimale getal " + getal , 50, 30 );
    g.drawString( "wordt in het binaire stelsel geschreven als :", 50, 60 );
    g.drawString( bin8 + " " + bin4 + " " + bin2 + " "  + bin1, 50, 90 );
  }
}
