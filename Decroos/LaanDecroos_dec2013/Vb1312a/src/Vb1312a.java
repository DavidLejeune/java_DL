// Voorbeeld 1312a  De wereld draait door
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Vb1312a extends JFrame {
  public static void main( String args[] ) {
    JFrame frame = new Vb1312a();
    frame.setSize( 400, 340 );
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    frame.setTitle( "Voorbeeld 1312a  De wereld draait door" );
    frame.setContentPane( new Wereldpaneel() );
    frame.setVisible( true );
  }
}


class Wereldpaneel extends JPanel {
  private javax.swing.Timer timer;
  private ArrayList<ImageIcon> lijst;
  private final int AANTAL = 24;
  private int index, volgende;
  private int delay;
  private MediaTracker tracker;
  
  private JButton snellerknop, langzamerknop;
  private JButton keeromknop;
  
  public Wereldpaneel() {
    tracker = new MediaTracker( this );
    lijst = new ArrayList<ImageIcon>();

    for( int i = 0; i < AANTAL; i++ ) {
      String bestandsnaam = String.format( "IMG%05d.gif", i );
      ImageIcon plaatje = new ImageIcon( bestandsnaam );
      // System.out.println( bestandsnaam );
      lijst.add( plaatje );
      tracker.addImage( plaatje.getImage(), 0);
    }
    
    index = 0;
    volgende = 1;
    delay = 210;

    timer = new javax.swing.Timer( delay, new TimerHandler() );
    //timer.setInitialDelay( 300 );
    snellerknop   = new JButton( "sneller" );
    langzamerknop = new JButton( "langzamer" );
    keeromknop    = new JButton( "keerom" );
    snellerknop.addActionListener( new SnellerHandler() );
    langzamerknop.addActionListener( new LangzamerHandler() );
    keeromknop.addActionListener( new KeeromHandler() );
    add( snellerknop );
    add( langzamerknop );
    add( keeromknop );
    
    timer.start();
  }

  public void update( Graphics g ) {
    paint( g );
  }

  public void paint( Graphics g ) {
    g.setColor( Color.BLACK );
    g.fillRect( 0, 0, getBounds().width, getBounds().height );
    ImageIcon plaatje = lijst.get( index );
    plaatje.paintIcon( this, g, 100, 100 ); 
  }
  
  class SnellerHandler implements ActionListener {
    public void actionPerformed( ActionEvent e ) {
      if( delay > 110 )
        delay -= 100;
      else delay = 10;
      timer.setDelay( delay );
    }
  }

  class LangzamerHandler implements ActionListener {
    public void actionPerformed( ActionEvent e ) {
      delay += 100;
      timer.setDelay( delay );
    }
  }

  class TimerHandler implements ActionListener {
    public void actionPerformed( ActionEvent e ) {
      index = index + volgende;
      if( index < 0 )
        index = AANTAL - 1;
      if( index >= AANTAL )
        index = 0;
      repaint();
    }
  }

  class KeeromHandler implements ActionListener {
    public void actionPerformed( ActionEvent e ) {
      volgende = -volgende;
    }
  }
}