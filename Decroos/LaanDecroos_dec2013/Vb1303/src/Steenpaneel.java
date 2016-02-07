import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Steenpaneel extends JPanel {
  private Timer timer;
  
  private Steen baksteen, grond;  

  public Steenpaneel() {
    baksteen = new Steen( Color.RED, 165, 0, 20, 10 );
    grond = new Steen( Color.BLUE, 100, 200, 150, 20 );
    
    timer = new Timer( 20, new TimerHandler() );    
    timer.start();    
  }
  
  public void paintComponent( Graphics g ) {
    super.paintComponent( g );
    grond.teken( g ); 
    baksteen.teken( g );
  }

  class TimerHandler implements ActionListener{
    public void actionPerformed( ActionEvent e ) {
      if( baksteen.getY() + baksteen.getHoogte() < grond.getY() ) {
        baksteen.naarBeneden();        
        repaint();
      }
      else
        timer.stop();
    }
  }
}
	