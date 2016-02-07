// Voorbeeld 0403  Uitgeschakelde lay-outmanager
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;  
import java.util.*;
   
public class Vb0403 extends JFrame {
  public static void main( String args[] ) {
    JFrame frame = new Vb0403();
    frame.setSize( 400, 200 );
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    frame.setTitle( "Voorbeeld 0403" );
    frame.setContentPane( new BTWPaneel() );
    frame.setAlwaysOnTop(true);
    frame.setVisible( true );
  }
}

// Het paneel 
class BTWPaneel extends JPanel {
  private JTextField invoerVak, uitvoerVak;
  private JLabel invoerLabel, uitvoerLabel;
  final double PERCENTAGE_BTW = 21.0;

  public BTWPaneel() {
    // NIEUW :Schakel lay-outmanager uit
    setLayout( null ); 
    
    // Maak de tekstvakken
    invoerVak = new JTextField( 10 );
    invoerVak.setHorizontalAlignment( JTextField.RIGHT );
    invoerVak.addActionListener( new InvoerVakHandler() );

    uitvoerVak = new JTextField( 10 );
    uitvoerVak.setHorizontalAlignment( JTextField.RIGHT );
    uitvoerVak.setBackground( Color.GRAY);
    
    // NIEUW :Schakel wijzigen door gebruiker in tekstvak uit
    //uitvoerVak.setEditable( false );// je kan er niet in typen, wel nog kopiëren
    
    // en ook nog :
    //uitvoerVak.setEnabled( false );  // niet typen noch kopiëren
    uitvoerVak.setVisible( false );  // onzichtbaar
    
    // later :
    //uitvoerVak.setVisible (true); validate(); // terug zichtbaar+ validate() !
    
    
    // Maak de labels
    invoerLabel = new JLabel( "Prijs zonder BTW" );
    uitvoerLabel = new JLabel( "Prijs met BTW" );
    uitvoerLabel.setForeground(Color.RED);
    
    // NIEUW :Bepaal van alle componenten de plaats en afmeting
    invoerLabel.setBounds( 80, 50, 120, 20 );
    invoerVak.setBounds( 200, 50, 90, 20 );
    uitvoerLabel.setBounds( 80, 80, 120, 20 );
    uitvoerVak.setBounds( 200, 80, 90, 20 );

    // Voeg de componenten toe aan het paneel
    add( invoerLabel);
    add( uitvoerLabel );
    add( uitvoerVak );
    add( invoerVak );
    
  }

  class InvoerVakHandler implements ActionListener {
    public void actionPerformed( ActionEvent e ) {
//      String invoer = invoerVak.getText();
//      double invoerGetal = Double.parseDouble( invoer );
//      // of korter :
      double invoerGetal = Double.parseDouble( invoerVak.getText() );

      // bereken mét BTW :
      double uitvoerGetal = (1 + PERCENTAGE_BTW/100 ) * invoerGetal;
      
      // NIEUW :                Formatteer de uitvoer
      uitvoerVak.setText( "\u20AC" + String.format( Locale.GERMANY , "%,10.2f", uitvoerGetal ) );
      uitvoerVak.setVisible( true );  
      validate();	
      // vakje leegmaken én cursor staat dan ook klaar om te typen
      invoerVak.setText("");
      // als je de uitvoer opnieuw als invoer wil gebruiken
      //invoerVak.setText(String.format( Locale.US , "%,10.2f", uitvoerGetal ));	
    }
  }
}
