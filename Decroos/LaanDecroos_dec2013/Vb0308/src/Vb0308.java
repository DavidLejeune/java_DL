// Voorbeeld 0308
// De groeiende cirkel
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
   
public class Vb0308 extends JFrame {
  public static void main( String args[] ) {
    
    JFrame frame = new Vb0308();
    frame.setSize( 1000, 700 );
    frame.setLocationRelativeTo (null);
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    frame.setTitle( "Voorbeeld 0308" );
    frame.setContentPane( new Cirkelpaneel() );
    frame.setVisible( true );
  }
}


class Cirkelpaneel extends JPanel {
  private JButton knop;
  private int diameter ;
  
  public Cirkelpaneel() {
     setBackground( Color.WHITE );
     diameter = 10;
     knop = new JButton( "Groter" );
     knop.addActionListener( new KnopHandler() );
     add( knop );
  }

  public void paintComponent( Graphics g ) {
    super.paintComponent( g );
    // Teken met blauw
    g.setColor( Color.BLUE );
    // Teken een schijf (wiskundig : een opgevulde cirkel)
    // originele versie boek
    g.fillOval( 100, 80, diameter, diameter );
    // eventueel : gecentreerd
    g.setColor( Color.RED );
    g.fillOval( 500-diameter/2, 350-diameter/2, diameter, diameter );
  }
  
  class KnopHandler implements ActionListener {
    public void actionPerformed( ActionEvent e ) {
      //diameter++;
      diameter += 15; // als het wat rapper moet groeien
      
      // uitvoer in console-venster (dos-box of output van JCreator)
      System.out.println ("diameter is nu : " + diameter);
      
      repaint();
    }
  }
}
