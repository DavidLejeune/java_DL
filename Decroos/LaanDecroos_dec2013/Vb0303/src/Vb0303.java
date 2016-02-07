// Voorbeeld 0303
// Klokrekenen
import javax.swing.*;
import java.awt.*;   
   
public class Vb0303 extends JFrame {
  public static void main( String args[] ) {
    JFrame frame = new Vb0303();
    frame.setSize( 400, 200 );
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    frame.setTitle( "Voorbeeld 0303" );
    frame.setContentPane( new Paneel() );
    frame.setVisible( true );
  }
}

// Het paneel 
class Paneel extends JPanel {
  private int totaalMinuten, uren, restMinuten;
    
  public Paneel() {
    setBackground( Color.WHITE );
    totaalMinuten = 1412;
    uren = totaalMinuten / 60; // hoeveel keer kan 60 erin
    restMinuten = totaalMinuten % 60; // hoeveel blijft er over na deling
    
  }
  
  public void paintComponent( Graphics g ) {
    super.paintComponent( g );
    g.drawString( totaalMinuten + " minuten = ", 50, 30 );
    g.drawString( uren + " uur en ", 50, 60 );
    g.drawString( restMinuten + " minuten", 50, 90 );
  }
}
