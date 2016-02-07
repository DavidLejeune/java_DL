// Voorbeeld 1201  Genereren van een exceptie
import java.awt.event.*;
import javax.swing.*;

public class Vb1201 extends JFrame {
  public static void main( String args[] ) {
    JFrame frame = new Vb1201();
    frame.setSize( 400, 80 );
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    frame.setTitle( "Voorbeeld 1201  Exceptie bij verkeerde invoer" );
    frame.setContentPane( new Invoerpaneel() );
    frame.setVisible( true );
  }
}


class Invoerpaneel extends JPanel {
  private JTextField invoervak, uitvoervak;
  
  public Invoerpaneel() {
    invoervak = new JTextField( 5 );
    invoervak.addActionListener( new VakHandler() );
    uitvoervak = new JTextField( 5 );

    add( new JLabel( "Voer een geheel getal in" ) ); 
    add( invoervak );
    add( new JLabel( "10-voud" ) );
    add( uitvoervak );
  }
  
  private class VakHandler implements ActionListener {
    public void actionPerformed( ActionEvent e ) {
      String invoer = invoervak.getText();
      int getal = 10 * Integer.parseInt( invoer );
      uitvoervak.setText( "" + getal );
    }
  }
}
