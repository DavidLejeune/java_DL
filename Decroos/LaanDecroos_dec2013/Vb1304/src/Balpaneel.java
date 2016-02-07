import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Balpaneel extends JPanel {
  private Timer timer;
  
  private Bal bal;
  
  public Balpaneel() {
    bal = new Bal( -100, 0, 10, Color.RED );
    
    timer = new Timer( 10, new TimerHandler() );    
    timer.start();    
  }
  
  public void paintComponent( Graphics g ) {
    super.paintComponent( g );
    setBackground( Color.WHITE );
    g.translate( 200, 220 ); // om nulpunt in het midden te leggen
    g.drawLine( -110, 10, 120, 10 );
    bal.stuiter( g ); // = tekenen + verplaatsen, zie klasse Bal
  }

  class TimerHandler implements ActionListener{
    public void actionPerformed( ActionEvent e ) {
      // om de 10 msec
      repaint();
    }
  }
}
	