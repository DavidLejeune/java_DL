// Voorbeeld 1202  Opvangen van een exceptie
import java.awt.event.*;
import javax.swing.*;

public class Vb1202 extends JFrame {
  public static void main( String args[] ) {
    JFrame frame = new Vb1202();
    frame.setSize( 500, 80 );
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    frame.setTitle( "Voorbeeld 1202  Opvangen van exceptie bij verkeerde invoer" );
    frame.setContentPane( new TryCatchpaneel() );
    frame.setVisible( true );
  }
}

class TryCatchpaneel extends JPanel {
  private JTextField invoervak, uitvoervak;
  
  public TryCatchpaneel() {
    invoervak = new JTextField( 5 );
    invoervak.addActionListener( new VakHandler() );
    uitvoervak = new JTextField( 20 );

    add( new JLabel( "Voer een geheel getal in" ) ); 
    add( invoervak );
    add( new JLabel( "10-voud" ) );
    add( uitvoervak );
  }
  
  private class VakHandler implements ActionListener {
    public void actionPerformed( ActionEvent e ) {
      String invoer = invoervak.getText();
      try {
        int getal = 10 * Integer.parseInt( invoer );
        uitvoervak.setText( "" + getal );
      }
      catch( NumberFormatException nfe ) {
        if( invoer.equals( "" ) ) invoer = "lege invoer";
        uitvoervak.setText( "Fout getal: " + invoer );
      }
    }
  }
}
