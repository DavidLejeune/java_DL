// Een paneel met een knop en een tekstvak
import javax.swing.*;

public class Paneel extends JPanel {
  private JButton knop;   // stap 1: referentie (of pointer) "declareren"
  private JTextField tekstvak;

  public Paneel() {  // de Constructor = speciale methode
      
    knop = new JButton( " Klik " );  // stap 2: het object "instantiëren"
        /* kan ook zo (gesplitst):
           knop = new JButton();
           knop.setText( " Klik ");
           en dan kan je verder doen :
           knop.set.... (zoek op via index, in welke klasse ??) 
        */
    
    tekstvak = new JTextField( 10 ); // een vak voor 10 tekens
   
        // toevoegen aan het paneel, volgorde is belangrijk
      
    add( knop ); 
    add( tekstvak );
  }
} 
