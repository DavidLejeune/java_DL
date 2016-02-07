// Voorbeeld 1001  FlowLayout
import java.awt.*;
import javax.swing.*;

public class Vb1001 extends JFrame {
  public static void main( String args[] ) {
    JFrame frame = new Vb1001();
    frame.setSize( 400, 200 );
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    frame.setTitle( "Voorbeeld 1001  FlowLayout" );
    frame.setContentPane( new FlowLayoutpaneel() );
    frame.setVisible( true );
  }
}

class FlowLayoutpaneel extends JPanel {
  private JTextField t1, t2, t3, t4, t5;

  public FlowLayoutpaneel() {
    //eigenlijk staat er automatisch (onzichtbaar)
    //setLayout(new FlowLayout());
   
    t1 = new JTextField( "een", 20 );
    t2 = new JTextField( "twee", 20 );
    t3 = new JTextField( "drie", 20 );
    t4 = new JTextField( "vier", 20 );
    t5 = new JTextField( "vijf", 20 );

    add( t1 );
    add( t2 );
    add( t3 );
    add( t4 );
    add( t5 );
  }
}
