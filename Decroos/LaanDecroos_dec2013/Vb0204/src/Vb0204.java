// Voorbeeld 0204
// Opstartklasse voor applicatie met paneel voor twee knoppen en tekstvak
import javax.swing.*;

public class Vb0204 extends JFrame {

  public static void main( String args[] ) {
    JFrame frame = new Vb0204();
    frame.setSize( 400, 200 );
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    frame.setTitle( "Voorbeeld 0204" );
    JPanel paneel = new Paneel();
    frame.setContentPane( paneel );
    frame.setVisible( true );
  }
}

