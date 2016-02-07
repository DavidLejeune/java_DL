// Voorbeeld 0806  Polygonen
import javax.swing.*;
import java.awt.*;   
   
public class Vb0806 extends JFrame {
  public static void main( String args[] ) {
    JFrame frame = new Vb0806();
    frame.setSize( 500, 500 );
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    frame.setTitle( "Voorbeeld 0806  Polygonen" );
    frame.setContentPane( new Polygoonpaneel() );
    frame.setVisible( true );
  }
}


class Polygoonpaneel extends JPanel {
  private Polygon pijl1, pijl2, pijl3;
  
  public Polygoonpaneel() {
    setBackground( Color.WHITE );                     // extra punt (70,125)
    int[] xPijl = { 50,  100, 100, 150, 100, 100, 50 , 70   };
    int[] yPijl = { 100, 100,  60, 125, 190, 150, 150, 125  };
    
    pijl1 = new Polygon( xPijl, yPijl, xPijl.length );
    
    pijl2 = new Polygon( xPijl, yPijl, xPijl.length );
                   // verplaats 150 naar rechts
    pijl2.translate( 150, 0 );
                   // verplaats 150 naar rechts & 150 naar onder
    pijl3 = new Polygon( xPijl, yPijl, xPijl.length );
    pijl3.translate( 150, 150 );
  }
  
  public void paintComponent( Graphics g ) {
    super.paintComponent( g );
    g.drawPolygon( pijl1 );

    g.setColor( Color.blue );
    g.fillPolygon( pijl2 );
    
    
    g.setColor( Color.red );
    g.fillPolygon( pijl3 );
    
  }
}
