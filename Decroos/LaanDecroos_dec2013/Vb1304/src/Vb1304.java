// Voorbeeld 1304  Stuiterende bal
import javax.swing.*;

public class Vb1304 extends JFrame {
  public static void main( String args[] ) {
    JFrame frame = new Vb1304();
    frame.setSize( 400, 280 );
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    frame.setTitle( "Voorbeeld 1304  Stuiterende bal" );
    frame.setContentPane( new Balpaneel() );
    frame.setVisible( true );
  }
}





