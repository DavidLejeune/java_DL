// Voorbeeld 1312  De wereld draait door
// werkt op basis van een Timer
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Vb1312 extends JFrame {
  public static void main( String args[] ) {
    JFrame frame = new Vb1312();
    frame.setSize( 400, 340 );
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    frame.setTitle( "Voorbeeld 1312  De wereld draait door" );
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

  private JButton startknop, stopknop;
  private JButton snellerknop, langzamerknop;
  private JButton keeromknop;
  
  public Wereldpaneel() {
    lijst = new ArrayList<ImageIcon>();

    for( int i = 0; i < AANTAL; i++ ) {
      String bestandsnaam = String.format( "IMG%05d.gif", i );
      ImageIcon plaatje = new ImageIcon( bestandsnaam );
      System.out.println( bestandsnaam );
      lijst.add( plaatje );
    }
    
    index = 0;
    volgende = 1;
    delay = 210;

    timer = new javax.swing.Timer( delay, new TimerHandler() );
                           // deze delay kan gewijzigd worden met .setDelay( )
    
    startknop = new JButton( "start" );
    stopknop = new JButton( "stop" );
    snellerknop   = new JButton( "sneller" );
    langzamerknop = new JButton( "langzamer" );
    keeromknop    = new JButton( "keerom" );

    startknop.addActionListener( new StartHandler() );
    stopknop.addActionListener( new StopHandler() );
    snellerknop.addActionListener( new SnellerHandler() );
    langzamerknop.addActionListener( new LangzamerHandler() );
    keeromknop.addActionListener( new KeeromHandler() );

    add( startknop );
    add( stopknop );
    add( snellerknop );
    add( langzamerknop );
    add( keeromknop );
  }

  public void paintComponent( Graphics g ) {
    super.paintComponent( g );
    setBackground( Color.BLACK );
    ImageIcon plaatje = lijst.get( index );
    plaatje.paintIcon( this, g, 100, 100 ); 
  }
  
  class StartHandler implements ActionListener {
    public void actionPerformed( ActionEvent e ) {
      timer.start();
    }
  }
  
  class StopHandler implements ActionListener {
    public void actionPerformed( ActionEvent e ) {
      timer.stop();
    }
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
      index = index + volgende; // 1 erbij of 1 eraf
      if( index < 0 )
        index = AANTAL - 1; //= 23
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