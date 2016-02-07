// Voorbeeld 1311  Gif en animated gif
import java.awt.*;
import javax.swing.*;

public class Vb1311 extends JFrame {
  public static void main( String args[] ) {
    JFrame frame = new Vb1311();
    frame.setSize( 400, 340 );
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    frame.setTitle( "Voorbeeld 1311  Gif en animated gif" );
    frame.setContentPane( new Gifpaneel() );
    frame.setVisible( true );
  }
}

class Gifpaneel extends JPanel {
  private ImageIcon gif, animatedGif;
      
  public Gifpaneel() {
  	setBackground(Color.yellow);
    gif =  new ImageIcon( "javalogo.gif" );
    animatedGif = new ImageIcon( "animaties/tumble.gif" );
  }

  public void paintComponent( Graphics g ) {
    super.paintComponent( g );

    gif.paintIcon( this , g, 100, 100 ); 
    animatedGif.paintIcon( this , g, 250, 100 ); 
  }
}
