// Voorbeeld 0402  Tekstvak-event
// Invoer van bedrag exclusief BTW
// Uitvoer van bedrag inclusief BTW 
import javax.swing.*;
import java.awt.event.*;  
import java.awt.*;
   
public class Vb0402 extends JFrame {
  public static void main( String args[] ) {
    JFrame frame = new Vb0402();
    frame.setSize( 600, 200 );
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    frame.setTitle( "Voorbeeld 0402" );
    frame.setContentPane( new BTWPaneel() );
    frame.setVisible( true );
  }
}

// Het paneel 
class BTWPaneel extends JPanel {
  private JTextField invoerVak, uitvoerVak;
  private JLabel invoerLabel, uitvoerLabel;
  private final double PERCENTAGE_BTW = 21.0;

  public BTWPaneel() {
  	setBackground(Color.yellow);
    // Maak de tekstvakken
    invoerVak = new JTextField( 10 );
    invoerVak.addActionListener( new InvoerVakHandler() );

    uitvoerVak = new JTextField( 20 );
    
    // Maak de labels
    invoerLabel = new JLabel( "      Prijs zonder BTW       " );
            // extra LDC
            // doorzichtig, enkel pixels tekenen die veranderen
    invoerLabel.setBackground(new Color(110,200,125));  //of : Color.CYAN 
                                 
    		// ondoorzichtig , alle pixels tekenen
    invoerLabel.setOpaque(true); 
    
    uitvoerLabel = new JLabel(  );
    uitvoerLabel.setText("  Prijs met BTW  ");
    

    // Voeg alles toe aan het paneel
    add( invoerLabel);
    add( invoerVak );
    add( uitvoerLabel );
    add( uitvoerVak );
  }

  class InvoerVakHandler implements ActionListener {
    public void actionPerformed( ActionEvent e ) {
      String invoer = invoerVak.getText();
      double invoerGetal = Double.parseDouble( invoer );

      double uitvoerGetal = (1 + PERCENTAGE_BTW/100 ) * invoerGetal;
      uitvoerVak.setText( "Incl. BTW =" + uitvoerGetal + "(excl. " +
      	                     invoerGetal + " )" );
      
      invoerVak.setText("");
    }
  }
}
