// Voorbeeld 1204  Infinity bij delen door 0
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Vb1204 extends JFrame {
  public static void main( String args[] ) {
    JFrame frame = new Vb1204();
    frame.setSize( 400, 150 );
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    frame.setTitle( "Voorbeeld 1204  Infinity bij delen door 0" );
    frame.setContentPane( new Delingpaneel() );
    frame.setVisible( true );
  }
}

class Delingpaneel extends JPanel {
  private JTextField invoervakA, invoervakB, uitvoervak;
  
  public Delingpaneel() {
    setLayout( new GridLayout( 4, 2 ) );
    invoervakA = new JTextField( 10 );
    invoervakB = new JTextField( 10 );
    uitvoervak = new JTextField( 10 );
    uitvoervak.setEditable( false );
    uitvoervak.setBackground( Color.WHITE );

    add( new JLabel( "Getal a" ) ); 
    add( invoervakA );

    add( new JLabel( "Getal b" ) ); 
    add( invoervakB );

    add( new JLabel( "a gedeeld door b: " ) );
    add( uitvoervak );
    
    JButton deelknop  = new JButton( "deel" );
    deelknop.addActionListener( new KnopHandler() );
    add( new JLabel() );  // leeg label
    add( deelknop );
  }
  
  private class KnopHandler implements ActionListener {
    public void actionPerformed( ActionEvent e ) {
      double a = Double.parseDouble( invoervakA.getText() );
      double b = Double.parseDouble( invoervakB.getText() );
      double resultaat = deel( a, b ); // methode ipv  a/b, zie Vb1205
      uitvoervak.setText( String.format( "%.4f", resultaat ) ); 
    }
    
    double deel( double x, double y ) { // wordt uitgebreid in Vb1205
      return x / y;
    }
  }
}
