// Voorbeeld 0203
// Opstartklasse voor applicatie met paneel en event handler
import javax.swing.*;

public class Vb0203 extends JFrame {

  public static void main( String args[] ) {
    JFrame frame = new Vb0203();
    frame.setSize( 400, 200 );
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    frame.setTitle( "Voorbeeld 0203" );
    JPanel paneel = new Paneel();
    frame.setContentPane( paneel );
    frame.setVisible( true );
  }
}

