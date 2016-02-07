// Voorbeeld 1303  Vallende steen
import javax.swing.*;

public class Vb1303 extends JFrame {
  public static void main( String args[] ) {
    JFrame frame = new Vb1303();
    frame.setSize( 340, 250 );
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    frame.setTitle( "Voorbeeld 1303  Vallende steen" );
    frame.setContentPane( new Steenpaneel() );
    frame.setVisible( true );
  }
}

