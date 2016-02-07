// Voorbeeld 0602  Klasse voor een rechthoek
import javax.swing.*;
import java.awt.*;   
   
public class Vb0602 extends JFrame {
  public static void main( String args[] ) {
    JFrame frame = new Vb0602();
    frame.setSize( 400, 280 );
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    frame.setTitle( "Voorbeeld 0602 Drie rechthoeken" );
    frame.setContentPane( new Tekenpaneel() );
    frame.setVisible( true );
  }
}

class Tekenpaneel extends JPanel {
  private Rechthoek rechthoek1, rechthoek2, rechthoek3;
  
  public Tekenpaneel() {
    setBackground( Color.WHITE );
    // Maak drie objecten
    rechthoek1 = new Rechthoek( Color.RED,     50, 40, 100, 60 );
    rechthoek2 = new Rechthoek( Color.YELLOW, 100, 70, 130, 40 );
    rechthoek3 = new Rechthoek( Color.BLUE,    70, 120, 40, 70 );
    
  }

  public void paintComponent( Graphics g ) {
    super.paintComponent( g );
    
    rechthoek1.teken( g );
    rechthoek2.teken( g );
    rechthoek3.teken( g );
    
    
  }
}


class Rechthoek {
	 // TOESTAND
  private Color kleur;
  private int x, y;
  private int breedte, hoogte;

     // Constructor
  public Rechthoek( Color kleur, int x, int y,
                    int breedte, int hoogte ) {
    this.kleur = kleur;
    this.x = x;
    this.y = y;
    this.breedte = breedte;
    this.hoogte = hoogte;
  }

     // GEDRAG
     // speciaal argument ! pen = kopie van g uit hoofdprogramma
  public void teken( Graphics pen ) {
    pen.setColor( kleur );
    pen.fillRect( x, y, breedte, hoogte );
  }
}
