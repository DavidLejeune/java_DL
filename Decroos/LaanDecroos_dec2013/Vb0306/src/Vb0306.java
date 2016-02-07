// Voorbeeld 0306
// Applicatie met kleur en opgevulde figuren
import javax.swing.*;
import java.awt.*;   
   
public class Vb0306 extends JFrame {
  public static void main( String args[] ) {
    JFrame frame = new Vb0306();
    frame.setSize( 400, 280 );
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    frame.setTitle( "Voorbeeld 0306" );
    frame.setContentPane( new Tekenpaneel() );
    frame.setVisible( true );
  }
}


class Tekenpaneel extends JPanel {
  
  
  public Tekenpaneel() {
    setBackground( Color.YELLOW );    // gele achtergrond
  }

  public void paintComponent( Graphics pen ) {
    super.paintComponent( pen );
    // Teken vanaf hier met blauw
    pen.setColor( Color.BLUE );
    
    // Teken twee open figuren
    pen.drawRect( 10, 10, 100, 50 );
    pen.drawOval( 10, 80, 100, 50 );
    
    // Teken vanaf hier met rood
    pen.setColor( Color.RED );
        
    // Teken twee gevulde figuren
    pen.fillRect( 130, 10, 100, 50 );
    pen.fillOval( 130, 80, 100, 50 );
    
    // extra : rand
    pen.setColor( Color.black );
    pen.drawRect( 130, 10, 100, 50 );
    // randje erbinnen
    pen.drawRect( 131, 11, 98, 48 );
    // randje erbuiten
    pen.drawRect( 129, 9, 102, 52 );
    // extra ellips
    pen.setColor( Color.orange );
    pen.fillOval( 155, 92, 50, 25 );
    
 
  }
}
