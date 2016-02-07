// Voorbeeld 1203  Mededeling exceptie in JOptionPane
import java.awt.event.*;
import javax.swing.*;

public class Vb1203 extends JFrame {
  public static void main( String args[] ) {
    JFrame frame = new Vb1203();
    frame.setSize( 500, 80 );
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    frame.setTitle( "Voorbeeld 1203  Mededeling exceptie in JOptionPane" );
    frame.setContentPane( new Invoerpaneel() );
    frame.setVisible( true );
  }
}

class Invoerpaneel extends JPanel {
  private JTextField invoervak, uitvoervak;
  
  public Invoerpaneel() {
    invoervak = new JTextField( 5 );
    invoervak.addActionListener( new VakHandler() );
    uitvoervak = new JTextField( 10 );

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
       
        JOptionPane.showMessageDialog(
          Invoerpaneel.this,
          "Fout getal: " + invoer,
          "Fout in invoer",
          JOptionPane.ERROR_MESSAGE
        );
      }
      
      finally {    // zie volgende paragraaf  
         invoervak.selectAll();
      }
    }
  }
}
