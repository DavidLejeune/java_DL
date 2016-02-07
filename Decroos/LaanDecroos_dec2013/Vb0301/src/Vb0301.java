// Voorbeeld 0301
// Declaratie en gebruik van drie int-variabelen 
import javax.swing.*;
import java.awt.*;   
 // merk op : vanaf H3 JFrame klasse in zelfde file als Paneel klasse 
public class Vb0301 extends JFrame {
  public static void main( String args[] ) {
    JFrame frame = new Vb0301();
    frame.setSize( 400, 200 );
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    frame.setTitle( "Voorbeeld 0301" );
    frame.setContentPane( new Paneel() );
    frame.setVisible( true );
  }
}

// Het paneel 
class Paneel extends JPanel {
          // drie variabelen van primitief type (geen objecten)
  private int a; // declaratie (de 'kotjes' reserveren)
  private int b;
  private int antwoord;
  
          // kan ook korter :
          // private int a, b, antwoord;
  
  public Paneel() {
  	// er zijn geen knoppen enz .. dus ook geen add() opdrachten
  	
    setBackground( Color.yellow );// wél nieuwe opdracht
    a = 174; // initialisatie (de 'kotjes' vullen)
    b = 26;
    antwoord = a + b;
  }
  
       // NIEUWE methode, kan in elk Paneel
       // g = de 'transparant" waar je mag op tekenen ...
  public void paintComponent( Graphics g ) {
    super.paintComponent( g ); // = paneel wissen
    
    // Zet de waarden van a, b en antwoord op het scherm
    // (afdruk direct op het paneel):
    //                 de tekst ...  en de plaats x , y 
    g.drawString( "Overzicht van de berekening:", 40, 20 );
     
    	// String + getal + ... resulteert in een nieuwe String
    g.drawString( "a = " + a + " \u2126", 40, 40 );
    
        // probeer eens zonder die "b = " ... lukt niet
    g.drawString( "b = " + b, 40, 60 );
    
    g.drawString( "De som is: " + antwoord, 40, 80 );
  
  }
}
