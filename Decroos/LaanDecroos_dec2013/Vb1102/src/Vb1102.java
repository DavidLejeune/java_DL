// Voorbeeld 1102  Auto, met abstracte klasse
import javax.swing.*;

public class Vb1102 extends JFrame {
  public static void main( String args[] ) {
    JFrame frame = new Vb1102();
    frame.setSize( 550, 400 );
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    frame.setTitle( "Voorbeeld 1102  Auto met abstracte klasse" );
    frame.setContentPane( new Autopaneel() );
    frame.setVisible( true );
  }
}
