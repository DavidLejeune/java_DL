// Voorbeeld 0507  Rente :
// Hoe lang duurt het voor je geld verdubbeld is ?

// while statement
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
   
public class Vb0507 extends JFrame {
  public static void main( String args[] ) {
    JFrame frame = new Vb0507();
    frame.setSize( 600, 400 );
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    frame.setTitle( "Voorbeeld 0507 Rente" );
    frame.setContentPane( new RentePaneel() );
    frame.setVisible( true );
  }
}


// Het paneel met niet proportionele letter
class RentePaneel extends JPanel {
  private JTextField inlegVak, renteVak;
  private JButton knop;
  private double inleg, renteFactor;
  
  
  public RentePaneel() {
    setBackground( Color.WHITE );
    inlegVak = new JTextField( 10 );
    renteVak = new JTextField( 10 );
    knop = new JButton( "Bereken" );
    knop.addActionListener( new KnopHandler() );
    
    add( new JLabel( "inleg" ) );
    add( inlegVak );
    add( new JLabel( "rentepercentage" ) );
    add( renteVak );
    add( knop );
  }
  
  public void paintComponent( Graphics g ) {
    super.paintComponent( g );
    g.setFont( new Font( "Courier", Font.BOLD, 14 ) );

    double bedrag = inleg;
    int jaar = 2014; 
    int y = 50;
    g.drawString( "Rentefactor: " + renteFactor, 80, y );
    y += 15;
    
    while( bedrag < 2 * inleg  ) {
      g.drawString( String.format( "%5d : %10.2f", jaar, bedrag ), 80, y += 15 );
      jaar++;
      bedrag = bedrag * renteFactor;
      
    }
     // laatste bedrag ook nog afdrukken, want we hebben juist nog niet het dubbele : 
    g.drawString( String.format( "%5d:%10.2f", jaar, bedrag ), 80, y += 15 );
  }
  
  class KnopHandler implements ActionListener {
    public void actionPerformed( ActionEvent e ) {
      String invoer1 = inlegVak.getText();
      inleg = Double.parseDouble( invoer1 );
      
      String invoer2 = renteVak.getText();
      renteFactor = 1 + Double.parseDouble( invoer2 ) / 100;
      repaint();
    }
  }
}

