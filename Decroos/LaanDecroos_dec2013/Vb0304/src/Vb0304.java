// Voorbeeld 0304
// Te grote waarde voor een int
import javax.swing.*;
import java.awt.*;   
   
public class Vb0304 extends JFrame {
  public static void main( String args[] ) {
    JFrame frame = new Vb0304();
    frame.setSize( 400, 200 );
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    frame.setTitle( "Voorbeeld 0304" );
    frame.setContentPane( new Paneel() );
    frame.setVisible( true );
  }
}

// Het paneel 
class Paneel extends JPanel {
  private int groot, klein, teGroot;
    
  public Paneel() {
    setBackground( Color.WHITE );
    groot = 2147483640;
    klein = 9;  				// hier 7 lukt wel
    
    teGroot = groot + klein ;  	// te groot!
  }
  
  public void paintComponent( Graphics g ) {
    super.paintComponent( g );
    g.drawString( groot + " + " + klein, 50, 30 );
    g.drawString( " = " + teGroot, 50, 60 );
    g.drawString( "Grootste int waarde = " + Integer.MAX_VALUE , 50, 100 );
  }
}
