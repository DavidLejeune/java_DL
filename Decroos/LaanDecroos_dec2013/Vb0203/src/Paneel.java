// Een paneel met een knop, tekstvak en event-afhandeling
import javax.swing.*;
import java.awt.event.*;                // dit is nieuw

public class Paneel extends JPanel {
  private JButton knop;
  private JTextField tekstvak;

  public Paneel() {
    knop = new JButton( "Klik" );
    
    KnopHandler kh = new KnopHandler(); // dit is ook nieuw
       // een instantie van de klasse KnopHandler is dus 
       // een "object" met een "opdracht"
    
    knop.addActionListener( kh ); // hier wordt kh aan knop gekoppeld
       // het systeem "luistert" dus naar de knop, 
       // en vertelt aan kh als het moment gekomen is om iets te doen
       
    tekstvak = new JTextField( 10 );
    add( knop );
    add( tekstvak );
  }
  
   // dit is een interne klasse of inner class
  class KnopHandler implements ActionListener {
    public void actionPerformed( ActionEvent e ) {
      // hier moet dus de code staan voor de actie 
      // die je met de knop wil laten uitvoeren
      tekstvak.setText( "Je hebt geklikt!" );
    }
  }
}

