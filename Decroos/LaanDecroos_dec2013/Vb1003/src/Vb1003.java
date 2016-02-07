// Voorbeeld 1003  BorderLayout
import java.awt.*;
import javax.swing.*;

public class Vb1003 extends JFrame {
  public static void main( String args[] ) {
    JFrame frame = new Vb1003();
    frame.setSize( 400, 280 );
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    frame.setTitle( "Voorbeeld 1003" );
    frame.setContentPane( new BorderLayoutpaneel() );
    frame.setVisible( true );
  }
}

class BorderLayoutpaneel extends JPanel {
  private JTextField t1, t2, t3, t4, t5;

  public BorderLayoutpaneel() {
    setLayout( new BorderLayout() );

    t1 = new JTextField( "  Noord " );
    t2 = new JTextField( "  West   " );
    t3 = new JTextField( 20);
    t4 = new JTextField( "  Oost  " );
    t5 = new JTextField( "  Zuid  " );
    
     // volgorde van add is van geen belang
    
    add( t1, BorderLayout.NORTH );
    add( t2, BorderLayout.WEST );
    add( t3, BorderLayout.CENTER );
    add( t4, BorderLayout.EAST );
    add( t5, BorderLayout.SOUTH ); // plaats wordt bepaald door de constanten
    
  }
}

