// Voorbeeld 1101  Auto, opgebouwd uit onderdelen met interface Onderdeel
import javax.swing.*;

public class Vb1101 extends JFrame {
  public static void main( String args[] ) {
    JFrame frame = new Vb1101();
    frame.setSize( 550, 400 );
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    frame.setTitle( "Voorbeeld 1101  Onderdelen van een auto" );
    frame.setContentPane( new Autopaneel() );
    frame.setVisible( true );
  }
}

