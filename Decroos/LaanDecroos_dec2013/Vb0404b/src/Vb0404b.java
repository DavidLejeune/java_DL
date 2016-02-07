// Voorbeeld 0404b  Kassa
// Zonder lay-outmanager
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;  
   
public class Vb0404b extends JFrame {
  public static void main( String args[] ) {
    JFrame frame = new Vb0404b();
    frame.setSize( 400, 200 );
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    frame.setTitle( "Voorbeeld 0404b: Kassa" );
    frame.setContentPane( new KassaPaneel() );
    frame.setVisible( true );
  }
}

// Het paneel 
class KassaPaneel extends JPanel {
  private JTextField bedragVak, subtotaalVak,
                     btwVak,totaalExBTWVak, totaalVak;
  private JLabel bedragLabel, subtotaalLabel, 
                 btwLabel, totaalExBTWLabel, totaalLabel;
  private JButton totaalKnop, resetKnop;
  
  private Kassa kassa;
  
  public KassaPaneel() {
    // Maak een kassa:
    kassa = new Kassa();
    
    // Schakel lay-outmanager uit
    setLayout( null ); 
    
    // Maak de tekstvakken
    bedragVak = new JTextField( 10 );
    bedragVak.addActionListener( new InvoerVakHandler() );

    subtotaalVak = new JTextField( 10 );
    subtotaalVak.setBackground( Color.YELLOW );
    
    btwVak = new JTextField( 10 );
    totaalExBTWVak = new JTextField( 10 );
    totaalVak = new JTextField( 10 );
    
      
    // Schakel wijzigen door gebruiker in tekstvak uit
    subtotaalVak.setEditable( false );
    btwVak.setEditable( false );
    totaalExBTWVak.setEditable( false );
    totaalVak.setEditable( false );
       
    
    // Maak de knoppen
    totaalKnop = new JButton( "Totaal" );
    totaalKnop.addActionListener( new TotaalKnopHandler() );
    
    resetKnop = new JButton( "Reset" );
    resetKnop.addActionListener( new ResetKnopHandler() );
    
    // Maak de labels
    bedragLabel = new JLabel( "Voer bedrag in" );
    subtotaalLabel = new JLabel( "Subtotaal" );
    btwLabel = new JLabel( "BTW" );
    totaalExBTWLabel = new JLabel( "Totaal ex BTW" );
    totaalLabel = new JLabel( "Totaal" );
    
    // Bepaal van alle componenten de plaats en afmeting
    bedragLabel.setBounds( 10, 10, 110, 20 );
    bedragVak.setBounds( 120, 10, 90, 20 );
    
    subtotaalLabel.setBounds( 10, 40, 110, 20 );
    subtotaalVak.setBounds( 120, 40, 90, 20 );
    
    totaalKnop.setBounds( 220, 40, 80, 20 );
    resetKnop.setBounds( 220, 130, 80, 20 );

    btwLabel.setBounds( 10, 70, 110, 20 );
    btwVak.setBounds( 120, 70, 90, 20 );

    totaalExBTWLabel.setBounds( 10, 100, 110, 20 );
    totaalExBTWVak.setBounds( 120, 100, 90, 20 );

    totaalLabel.setBounds( 10, 130, 110, 20 );
    totaalVak.setBounds( 120, 130, 90, 20 );

    // Voeg de componenten toe aan het paneel
    add( bedragLabel);
    add( bedragVak );
    add( subtotaalLabel );
    add( subtotaalVak );
    add( totaalKnop );
    add( resetKnop );
    add( btwLabel );
    add( btwVak );
    add( totaalExBTWLabel );
    add( totaalExBTWVak );
    add( totaalLabel );
    add( totaalVak );
  }

  class InvoerVakHandler implements ActionListener {
    public void actionPerformed( ActionEvent e ) {
      String invoer = bedragVak.getText();
      double invoerBedrag = Double.parseDouble( invoer );

      kassa.telOp( invoerBedrag );
      double st = kassa.getSubtotaal();
      
      // Formatteer de uitvoer
      subtotaalVak.setText( String.format( "%.2f", st ) );
      
      // Maak invoervak leeg
      bedragVak.setText( "" );
    }
  }
  
  class TotaalKnopHandler implements ActionListener {
    public void actionPerformed( ActionEvent e ) {
      btwVak.setText( "" + kassa.berekenBTWSubtotaal() );
      totaalExBTWVak.setText( "" + kassa.berekenSubtotaalExBTW() );
      totaalVak.setText( "" + kassa.getSubtotaal() );
    }
  }
  
  class ResetKnopHandler implements ActionListener {
    public void actionPerformed( ActionEvent e ) {
      subtotaalVak.setText( "" );
      btwVak.setText( "" );
      totaalExBTWVak.setText( "" );
      totaalVak.setText( "" );
      kassa.reset();
      
    }
  }
}


class Kassa {
  private double subtotaal;
  private final double PERCENTAGE_BTW = 19.0;
  
  public Kassa() {
    subtotaal = 0;
  }
  
  public void telOp( double bedrag ) {
    subtotaal += bedrag;
  }
  
  public double getSubtotaal() {
    return subtotaal;
  }
  
  public void reset() {
    subtotaal = 0;
  }
  
  public double berekenBTWSubtotaal() {
    return subtotaal - berekenSubtotaalExBTW();
  }
  
  public double berekenSubtotaalExBTW() {
    return subtotaal / (1 + PERCENTAGE_BTW/100 );
  }
}