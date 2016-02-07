// Voorbeeld 0503 Twee knoppen en tekstvak
// Event handling met if-statment
import javax.swing.*;
import java.awt.event.*;

public class Vb0503 extends JFrame {
  public static void main( String args[] ) {
    JFrame frame = new Vb0503();
    frame.setSize( 400, 200 );
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    frame.setTitle( "Voorbeeld 0503" );
    Paneel paneel = new Paneel();
    frame.setContentPane( paneel );
    frame.setVisible( true );
  }
}

// Paneel met twee knoppen en een tekstvak
class Paneel extends JPanel {
  private JButton knop, herstelknop;
  private JTextField tekstvak;

  public Paneel() {
  	
  	  
 // hieronder liever KnopHandler ipv ActionListener
    KnopHandler handler= new KnopHandler();
    
    knop = new JButton( "Klik" );
    knop.addActionListener( handler );
    
    herstelknop = new JButton( "Veeg uit" );
    herstelknop.addActionListener( handler );
       /* LET OP : 1 KnopHandler-object bedient twee knoppen,
  	      dit is niet hetzelfde als :
          	knop.addActionListener(        new KnopHandler() );
           	herstelknop.addActionListener( new KnopHandler() );
          want dan heb je TWEE KnopHandler-objecten gemaakt !!!
          (waarbij in elke handler 1 v/d if's nooit zal gebruikt worden)
       */
          
    tekstvak = new JTextField( 10 );
    add( knop );
    add( tekstvak );
    add( herstelknop );
  }
  
  // Er is nu slechts 1 inwendige klasse !
  class KnopHandler implements ActionListener {
    public void actionPerformed( ActionEvent e ) {
      if( e.getSource() == knop ){
        tekstvak.setText( "Je hebt geklikt!" );
      }
        
      if( e.getSource() == herstelknop ){
        tekstvak.setText( "" );
      }
    }
  }
} 

