// Voorbeeld 1002  FlowLayout uitlijning
import java.awt.*;
import javax.swing.*;

public class Vb1002 extends JFrame {
  public static void main( String args[] ) {
    JFrame frame = new Vb1002();
    frame.setSize( 300, 300 );
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    frame.setTitle( "Voorbeeld 1002" );
    frame.setContentPane( new FlowLayoutpaneel() );
    frame.setVisible( true );
  }
}

class FlowLayoutpaneel extends JPanel {
  private JTextField t1, t2, t3;

  public FlowLayoutpaneel() {
    setLayout( new FlowLayout( FlowLayout.LEFT, 30, 30 ) );    
 // setLayout( new FlowLayout( FlowLayout.CENTER, 30, 30 ) );    
 //setLayout( new FlowLayout( FlowLayout.RIGHT ) );
    
    t1 = new JTextField( "een" );
    t2 = new JTextField( "twee" );
    t3 = new JTextField( "drie" );

    add( t1 );
    add( t2 );
    add( t3 );
  }
}
