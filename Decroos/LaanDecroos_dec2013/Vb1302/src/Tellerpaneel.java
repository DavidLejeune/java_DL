import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Tellerpaneel extends JPanel {
  private int teller;
  private Timer timer;
  private JButton startknop, stopknop;
  
  public Tellerpaneel() {
    teller = 0;
    timer = new Timer( 100, new TimerHandler() );  // tiende seconde
    
    startknop = new JButton( "Start" );
    stopknop =  new JButton( "Stop" );
    
    KnopHandler kh = new KnopHandler();
    startknop.addActionListener( kh );
    stopknop.addActionListener( kh );
    
    add( startknop );
    add( stopknop );  
  }

  public void paintComponent( Graphics g ) {
    super.paintComponent( g );
    g.setColor( Color.BLUE );
    g.setFont( new Font( "SansSerif", Font.BOLD, 14 ) );
    g.drawString( "Teller = " + teller, 130, 80 );
  }

  class TimerHandler implements ActionListener{
    public void actionPerformed( ActionEvent e ) {
      teller++;
      repaint();
    }
  }
  
  class KnopHandler implements ActionListener {
    public void actionPerformed( ActionEvent e ) {
      if( e.getSource() == startknop ) 
        timer.start();
      if( e.getSource() == stopknop ) 
        timer.stop();
    }
  }
}
	