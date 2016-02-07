// Voorbeeld 1012  Naamloos object van anonieme inwendige klasse
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Vb1012 extends JFrame {
  public static void main( String args[] ) {
    JFrame frame = new Vb1012();
    frame.setSize( 400, 200 );
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    frame.setTitle( "Voorbeeld 1012  Naamloos object van anonieme inwendige klasse" );
    frame.setContentPane( new Paneel() );
    frame.setVisible( true );
  }
}

class Paneel extends JPanel {
  private int aantal;
  private JButton knop;

  public Paneel() {
    knop = new JButton( "Klik" );
    
    // Naamloos object van anonieme inwendige klasse + direct aan knop koppelen,
    //  dan heb je zelfs geen referentie nodig
    
    knop.addActionListener( 
      // de addActionListener() methode verwacht als argument een referentie naar
      // een object van een klasse die de interface ActionListener implementeert , dus ( .... )
                 
                 // roep de a.d.c. op van de anonieme klasse die de 
                 // interface implementeert (alles onzichtbaar ...)           
      new ActionListener() { 
        public void actionPerformed( ActionEvent e ) { // begin van de definitie van de enige methode
          aantal++;
          repaint();
        } // einde van de enige methode 
      } // deze accolade sluit de anonieme klasse af
      
    );  // dit haakje sluit dat van regel 28 af !!!
    
    
    add( knop );
  }
  
  public void paintComponent( Graphics g ) {
    super.paintComponent( g );
    for( int i = 0; i < aantal; i++ )
      g.drawOval( 50 + i * 10, 50, 50, 50 );
  }
}
