// Voorbeeld 1206  Gooien en opvangen van exeptie bij delen door 0
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;     // voor Locale

public class Vb1205 extends JFrame {
  public static void main( String args[] ) {
    JFrame frame = new Vb1205();
    frame.setSize( 400, 150 );
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    frame.setTitle( "Voorbeeld 1206  Gooien en opvangen van exeptie " );
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
    uitvoervak = new JTextField( 20 );
    uitvoervak.setEditable( false );
    uitvoervak.setBackground( Color.YELLOW );

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
      try {
        double resultaat = deel( a, b );
        uitvoervak.setText(
           String.format( Locale.US, "%.4f", resultaat ) ); 
      }
      catch( ArithmeticException ae ) {
        JOptionPane.showMessageDialog( Delingpaneel.this,
          ae.getMessage(),
          "Fout",
          JOptionPane.ERROR_MESSAGE
        );
      }
    }
    
    double deel( double x, double y ) throws ArithmeticException {
      if( y == 0.0 )
        throw new ArithmeticException( "Deling door nul"  );  
      return x / y;
    }
  }
}
