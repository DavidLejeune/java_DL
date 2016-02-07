// Voorbeeld 0404  Kassa
// GridLayout
import javax.swing.*;
import javax.swing.border.*; // voor Border
import java.awt.*;
import java.awt.event.*;  
import java.util.*;

public class Vb0404 extends JFrame {
  public static void main( String args[] ) {
    JFrame frame = new Vb0404();
    frame.setSize( 300, 100 );
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    frame.setTitle( "Voorbeeld 0404: Kassa" );
    frame.setContentPane( new KassaPaneel() );
    frame.setVisible( true );
  }
}

// Het paneel voor de kassa
class KassaPaneel extends JPanel  {
  private JLabel bedragLabel, subtotaalLabel;
  private JTextField bedragVak, subtotaalVak;
  private Kassa kassa4; //enkel een referentie (pointer)
  
  public KassaPaneel() {
    // Kies GridLayout
    setLayout( new GridLayout( 2, 2 , 10, 10 ) );
    setBackground (Color.RED);
    // een border errond, is maar opsmuk, niet belangrijk
    // vergeet de extra import niet !
    //Border border = BorderFactory.createEmptyBorder( 5, 5, 5, 5 );
    Border border = BorderFactory.createLineBorder( Color.CYAN
    	, 10 );
    setBorder( border );

    // Maak een kassa:
    kassa4 = new Kassa(); // java maakt een automatic default constructor en roept deze op
    
    // Maak de tekstvakken
    bedragVak = new JTextField( 10 );
    bedragVak.addActionListener( new BedragVakHandler() );
    bedragVak.setHorizontalAlignment( JTextField.RIGHT );

    subtotaalVak = new JTextField( 10 );
    subtotaalVak.setBackground( Color.YELLOW );
    subtotaalVak.setForeground( Color.RED );
    // Zorg dat gebruiker niet kan wijzigen en lijn rechts uit
    subtotaalVak.setEditable( false );
    subtotaalVak.setHorizontalAlignment( JTextField.RIGHT );    

    
    // Maak de labels
    bedragLabel = new JLabel( "Voer bedrag in" );
    bedragLabel.setBackground(Color.gray);
    bedragLabel.setOpaque(true);
    
    subtotaalLabel = new JLabel( "Subtotaal" );
	subtotaalLabel.setBackground(Color.gray);
	subtotaalLabel.setOpaque(true);
    
    // Voeg de componenten toe aan het paneel
    add( bedragLabel);
    add( bedragVak );
    //add(new JLabel("dummy"));
    add( subtotaalLabel );    
    add( subtotaalVak );
    //add(new JLabel("LDC Soft 2013"));
    //add(new JLabel("dummy2"));
    
    
  }

  class BedragVakHandler implements ActionListener {
    public void actionPerformed( ActionEvent e ) {
      String invoer = bedragVak.getText();
      double invoerBedrag = Double.parseDouble( invoer );

      // Geef het bedrag door aan de kassa
      kassa4.telOp( invoerBedrag );
      
      // Vraag om het subtotaal en formatteer dit
      double st = kassa4.getSubtotaal();
      subtotaalVak.setText( String.format( "%20.2f", st ) );
      
      //subtotaalVak.setText( String.format(Locale.US, "%.2f", st ) );
      // subtotaalVak.setText( ""+ st  ); 
          
      // Maak invoervak leeg (plaatst ook de cursor in dat vak)
      bedragVak.setText( "" );
      
      // cursor in een bepaald vak zetten zonder iets te wissen gaat ook :
      //subtotaalVak.requestFocus();
      
    }
  }
}

