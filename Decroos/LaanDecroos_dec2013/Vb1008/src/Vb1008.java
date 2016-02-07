// Voorbeeld 1008  Borders
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;  // Nodig voor Border, niet voor BorderFactory

public class Vb1008 extends JFrame {
  public static void main( String args[] ) {
    JFrame frame = new Vb1008();
    frame.setSize( 900, 450 );
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    frame.setTitle( "Voorbeeld 1008  Borders" );
    frame.setContentPane( new BorderDemopaneel() );
    frame.setVisible( true );
  }
}

class BorderDemopaneel extends JPanel {
  JPanel paneel1, paneel2, paneel3;

  public BorderDemopaneel() {
    setLayout( new GridLayout( 1, 3 ) );

    paneel1 = new JPanel();
    paneel2 = new JPanel();
    paneel3 = new JPanel();
    
    //Border titelrand = BorderFactory.createTitledBorder( "Titel" );
    
    // alternatief uit index :
    // createTitledBorder(Border border, String title, int titleJustification, 
    //                     int titlePosition, Font titleFont, Color titleColor)
    // hier toegepast :
    // eerst een hulp-border voor de omtrek, mét een dikte (zie ook index)
    Border lijnrand = BorderFactory.createLineBorder( Color.red, 10);
    Border titelrand = BorderFactory.createTitledBorder(
    	lijnrand,              
    	"Mooi hee !", 
    	TitledBorder.CENTER, 
    	TitledBorder.BOTTOM ,
    	new Font ("Algerian", Font.BOLD, 36),
    	new Color (0,50,200) );
    
    Border groefrand = BorderFactory.createEtchedBorder();
    Border samengesteldeRand = 
           BorderFactory.createCompoundBorder( 
             BorderFactory.createEmptyBorder( 10, 10, 10, 10 ), 
             BorderFactory.createEtchedBorder()
           );
        
    paneel1.setBorder( titelrand );
    paneel2.setBorder( groefrand );
    paneel3.setBorder( samengesteldeRand );
    
    add( paneel1 );
    add( paneel2 );
    add( paneel3 );
  }
}
