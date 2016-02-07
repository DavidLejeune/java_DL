import java.awt.*;
import javax.swing.*;

class Autopaneel extends JPanel {
  private Auto auto, mycar;
  
  public Autopaneel() {
    auto = new Auto( 20, 150, 80, 30 );
    mycar = new Auto( 200, 250, 160, 60 );
  }
  
  public void paintComponent( Graphics g ) {
    super.paintComponent( g );
    setBackground( Color.WHITE );     
    auto.teken( g );
    mycar.teken(g);
  }
}
	