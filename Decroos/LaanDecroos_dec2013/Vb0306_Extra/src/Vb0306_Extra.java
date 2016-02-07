// Extra Voorbeeld 0306
// Schooletiket tekenen
import javax.swing.*;
import java.awt.*;   
   
public class Vb0306_Extra extends JFrame {
  public static void main( String args[] ) {
    JFrame frame = new Vb0306_Extra();
    frame.setSize( 400, 280 );
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    frame.setTitle( "Voorbeeld Schooletiket" );
    frame.setContentPane( new Tekenpaneel() );
    frame.setAlwaysOnTop(true);
    frame.setVisible( true );
  }
}


class Tekenpaneel extends JPanel {
  public Tekenpaneel() {
     setBackground( Color.GRAY ); // grijze achtergrond
  }

  public void paintComponent( Graphics g ) {
    super.paintComponent( g );
    
    // teken buitenste rand wit
    g.setColor( Color.WHITE );
    g.fillRoundRect( 10, 10, 180, 120, 30, 30 );
    
    // teken binnenrand blauw
    g.setColor( Color.BLUE);
    g.fillRoundRect( 15, 15, 170, 110 ,30, 30 );
    
    // teken etiket binnen wit
    g.setColor( Color.WHITE);
    g.fillRoundRect( 20, 20, 160, 100, 30, 30 );
    
      // drie lijntjes
    g.setColor( Color.BLUE);
    g.drawLine (30,55,165,55);
    g.drawLine (30,75,165,75);
    g.drawLine (30,95,165,95);
      // de tekst
    g.setColor( Color.BLACK);
    g.drawString(" Jantje Pruimelaar " , 45, 53);
    g.drawString("  Eerste Leerjaar  " , 45, 73);
    g.drawString("     Juf. Ann      " , 45, 93);
  }
}
