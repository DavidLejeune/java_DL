// Paneel met drie knoppen en twee tekstvakken
import javax.swing.*;
import java.awt.event.*;

public class Paneel extends JPanel {
									// extra copyknop
  private JButton knop, herstelknop, copyknop;
  private JTextField tekstvak, tekstvak2;

  public Paneel() {
    knop = new JButton( "Klik" );
    knop.addActionListener( new KnopHandler() );
    
    herstelknop = new JButton( "Veeg uit" );
    herstelknop.addActionListener( new HerstelknopHandler() );
    
    copyknop = new JButton( "Kopieer" );
    copyknop.addActionListener( new CopyknopHandler() );
    
    tekstvak = new JTextField( 10 );
    tekstvak2 = new JTextField( 10 );
    
    add( knop );
    add( tekstvak );
    add( herstelknop );
    add( tekstvak2);
    add (copyknop);
  }
  
  class KnopHandler implements ActionListener {
    public void actionPerformed( ActionEvent e ) {
      tekstvak.setText( "Je hebt geklikt!" );
    }
  }
  
  class HerstelknopHandler implements ActionListener {
    public void actionPerformed( ActionEvent e ) {
      tekstvak.setText( "" );
      tekstvak2.setText( "" );
    }
  }  
  	
  class CopyknopHandler implements ActionListener {
    public void actionPerformed( ActionEvent e ) {
      //String str = tekstvak.getText();
      //tekstvak2.setText (str);
//      
      //of in één keer (zonder opslag van de tekst):
      tekstvak2.setText( tekstvak.getText() );
      
     
    }
  }  
}
