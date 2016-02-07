// Voorbeeld 0302
// Operatoren +, -, *, / en %
import javax.swing.*;
import java.awt.*;   
   
public class Vb0302 extends JFrame {
  public static void main( String args[] ) {
    JFrame frame = new Vb0302();
    frame.setSize( 400, 200 );
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    frame.setTitle( "Voorbeeld 0302" );
    frame.setContentPane( new Paneel() );
    frame.setVisible( true );
  }
}


// Het paneel 
class Paneel extends JPanel {
  private int a, b, som, verschil,
   			  product, quotient,rest ;

  public Paneel() {
    setBackground( Color.CYAN );
    a = 10;
    b = 8;
    som      = a + b;
    verschil = a - b;
    product  = a * b;
    quotient = a / b; // gehele deling
    rest     = a % b; // rest !!!
  }
  
  public void paintComponent( Graphics g ) {
    super.paintComponent( g );
    g.drawString( "a = " + a + " en b = " + b, 10, 20 );
    g.drawString( "De som is " + som, 10, 50 );
    g.drawString( "Het verschil is " + verschil, 10, 70 );
    g.drawString( "Het product is " + product, 10, 90 );
    g.drawString( "Het quotiënt is " + quotient, 10, 110 );
    g.drawString( "De rest is " + rest, 10, 130 );
  }
}
