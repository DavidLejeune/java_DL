// Voorbeeld 1312b  De wereld draait door
// De wereld op een JLabel ipv paintComponent
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Vb1312b extends JFrame {
  public static void main( String args[] ) {
    JFrame frame = new Vb1312b();
    frame.setSize( 400, 340 );
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    frame.setTitle( "Voorbeeld 1312b  De wereld draait door" );
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
  
  private JLabel label;
  
  public Wereldpaneel() {
    lijst = new ArrayList<ImageIcon>();

    for( int i = 0; i < AANTAL; i++ ) {
      String bestandsnaam = String.format( "IMG%05d.gif", i );
      ImageIcon plaatje = new ImageIcon( bestandsnaam );
      // System.out.println( bestandsnaam );
      lijst.add( plaatje );
    }
    
    index = 0;
    volgende = 1;
    delay = 210;

    timer = new javax.swing.Timer( delay, new TimerHandler() );
    
    startknop = new JButton( "start" );
    stopknop = new JButton( "stop" );
    snellerknop   = new JButton( "sneller" );
    langzamerknop = new JButton( "langzamer" );
    keeromknop    = new JButton( "keerom" );
    //System.out.println( lijst.get( 0 ) );
    label = new JLabel( lijst.get( 0 ) );

    startknop.addActionListener( new StartHandler() );
    stopknop.addActionListener( new StopHandler() );
    snellerknop.addActionListener( new SnellerHandler() );
    langzamerknop.addActionListener( new LangzamerHandler() );
    keeromknop.addActionListener( new KeeromHandler() );

add( label );
    add( startknop );
    add( stopknop );
    add( snellerknop );
    add( langzamerknop );
    add( keeromknop );
    
   // add( label );
  }

/*
  public void paintComponent( Graphics g ) {
    super.paintComponent( g );
    setBackground( Color.BLACK );
    ImageIcon plaatje = lijst.get( index );
    plaatje.paintIcon( this, g, 100, 100 ); 
  }
*/  
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
      index = index + volgende;
      if( index < 0 )
        index = AANTAL - 1;
      if( index >= AANTAL )
        index = 0;
      //repaint();
      label.setIcon( lijst.get( index ) );
    }
  }

  class KeeromHandler implements ActionListener {
    public void actionPerformed( ActionEvent e ) {
      volgende = -volgende;
    }
  }
}