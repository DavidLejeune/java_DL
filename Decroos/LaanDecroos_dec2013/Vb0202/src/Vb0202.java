


// Voorbeeld 0202
// Opstartklasse voor applicatie met paneel
import javax.swing.*;

public class Vb0202 extends JFrame {

  public static void main( String args[] ) {
  	
    JFrame frame = new Vb0202();
    frame.setSize( 400, 200 );
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    frame.setTitle( "Nu met een paneel erin !" );
    // *** NIEUW !
    Paneel p = new Paneel(); // declareer én instantieer een Paneel object
    frame.setContentPane( p ); // zet het paneel in het frame
    
    frame.setVisible( true );
  }
}

