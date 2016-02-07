import java.awt.*;
import javax.swing.*;

class Autopaneel extends JPanel {
  private Auto auto, oude;
  
  public Autopaneel() {
    auto = new Auto( 20, 150, 80, 30 );
    oude = new Auto( 120, 250, 180, 50 );
  }
  
  public void paintComponent( Graphics g ) {
    super.paintComponent( g );
    setBackground( Color.WHITE );     
    auto.teken( g );
    oude.teken( g );
  }
}
  