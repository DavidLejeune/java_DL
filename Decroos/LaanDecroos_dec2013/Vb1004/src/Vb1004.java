// Voorbeeld 1004  BorderLayout met twee componenten
import java.awt.*;
import javax.swing.*;

public class Vb1004 extends JFrame {
  public static void main( String args[] ) {
    JFrame frame = new Vb1004();
    frame.setSize( 400, 280 );
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    frame.setTitle( "Voorbeeld 1004" );
    frame.setContentPane( new CentrumZuidpaneel() );
    frame.setVisible( true );
  }
}


class CentrumZuidpaneel extends JPanel {
  private JButton knop1, knop2;
  
  public CentrumZuidpaneel() {
    setLayout( new BorderLayout() );

    knop1= new JButton( "Centrum" );
    knop2= new JButton( "Zuid" );

    add( knop1, BorderLayout.CENTER );
    add( knop2, BorderLayout.SOUTH );
  }
}
