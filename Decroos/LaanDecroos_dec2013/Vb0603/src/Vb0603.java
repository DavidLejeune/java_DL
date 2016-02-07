// Voorbeeld 0603   Rechthoek 
import javax.swing.*;
import java.awt.*;   
import java.awt.event.*;
   
public class Vb0603 extends JFrame {
  public static void main( String args[] ) {
    JFrame frame = new Vb0603();
    frame.setSize( 400, 280 );
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    frame.setTitle( "Voorbeeld 0603" );
    frame.setContentPane( new Tekenpaneel() );
    frame.setVisible( true );
  }
}


class Tekenpaneel extends JPanel {
  private Rechthoek rechthoek1, rechthoek2;
  private JButton knop;
  
  private int teller = 0;
  
  public Tekenpaneel() {
    setBackground( Color.WHITE );

    rechthoek1 = new Rechthoek( Color.BLUE, 100, 100, 40, 20 );
    rechthoek2 = new Rechthoek( Color.RED,  180, 100, 20, 40 );
    knop = new JButton( "Verplaats" );
    knop.addActionListener( new KnopHandler() );
    add( knop );
  }

  public void paintComponent( Graphics g ) {
    super.paintComponent( g );
    if (teller%2==0){
    	rechthoek1.teken( g );
        rechthoek2.teken( g );
    }
    else{
    	rechthoek2.teken( g );
    	rechthoek1.teken( g );    
    }
  }

  class KnopHandler implements ActionListener {
    public void actionPerformed( ActionEvent e ) {
      teller++;
      rechthoek1.naarRechts();
      rechthoek2.naarLinks();
      repaint();
    }
  }
}


class Rechthoek {
  private Color kleur;
  private int x, y;
  private int breedte, hoogte;

  public Rechthoek( Color kleur, int x, int y,
                    int breedte, int hoogte ) {
    this.kleur = kleur;
    this.x = x;
    this.y = y;
    this.breedte = breedte;
    this.hoogte = hoogte;
  }

  public void naarLinks() {
    x -= 4;
  }
   
  public void naarRechts() {
    x += 4;
  }

  public void teken( Graphics pen ) {
    pen.setColor( kleur );
    pen.fillRect( x, y, breedte, hoogte );
  }
}


