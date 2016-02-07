// Voorbeeld 1011  Anonieme inwendige klasse
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Vb1011 extends JFrame {
  public static void main( String args[] ) {
    JFrame frame = new Vb1011();
    frame.setSize( 400, 200 );
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    frame.setTitle( "Voorbeeld 1011  Anonieme inwendige klasse" );
    frame.setContentPane( new Paneel() );
    frame.setVisible( true );
  }
}

class Paneel extends JPanel {
  private int aantal;
  private JButton knop;

  public Paneel() {
    knop = new JButton( "Klik" );
    
    // Anonieme inwendige klasse
    /* = een naamloze klasse die de interface ActionListener implementeert ,
         er direct een object vanmaakt en dit aan een referentie handler toewijst
         voor een klasse mag je altijd de superklasse gebruiken voor de referentie, zie
        	Rekening r = new SpaarRekening() ...
         dus mag hier ook ActionListener handler =...(terwijl ActionListener een interface is en geen klasse)
     */  
     //	ActionListener handler = new ActionListener(); // dit gaat bvb NIET 	
    ActionListener handler = new ActionListener(){
      // anonieme klasse bevat 1 methode :	
        public void actionPerformed( ActionEvent e ){
          aantal++;
          repaint();
        } 
    }; //  einde van de anonieme klasse
    
    knop.addActionListener( handler );//gebruik de referentie, maar kan nog korter , zie Vb1012
    add( knop );
  }
  
  public void paintComponent( Graphics g ) {
    super.paintComponent( g );
    for( int i = 0; i < aantal; i++ )
      g.drawOval( 50 + i * 10, 50, 50, 50 );
  }
}
