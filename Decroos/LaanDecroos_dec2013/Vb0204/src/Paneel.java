// Paneel met twee knoppen en een tekstvak
import javax.swing.*;
import java.awt.event.*;

public class Paneel extends JPanel {
  private JButton knop, herstelknop; // tweede knop erbij
  private JTextField tekstvak;

  public Paneel() {
    knop = new JButton( "Klik" );
    		// nieuw : een "naamloos" handler-object
    knop.addActionListener( new KnopHandler() );
    
    herstelknop = new JButton( "Veeg uit" );
    herstelknop.addActionListener( new HerstelknopHandler() );
   
    tekstvak = new JTextField( 10 );
    
    add( knop );    add( tekstvak );    add( herstelknop ); 
    
  }
  
  // handler voor de knop "Klik"
  class KnopHandler implements ActionListener {
    public void actionPerformed( ActionEvent e ) {
      tekstvak.setText( "Je hebt geklikt!" );
    }
  }
  
  // handler voor de knop "Veeg uit"
  class HerstelknopHandler implements ActionListener {
    public void actionPerformed( ActionEvent e ) {
      tekstvak.setText( "" );
    }
  }
   
}// einde van de klasse Paneel 
