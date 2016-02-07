// Voorbeeld 1307  Bal als Thread
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Vb1307 extends JFrame {
  public static void main( String args[] ) {
    JFrame frame = new Vb1307();
    frame.setSize( 400, 340 );
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    frame.setTitle( "Voorbeeld 1307  Bal als Thread" );
    frame.setContentPane( new Balpaneel() );
    frame.setVisible( true );
  }
}


class Balpaneel extends JPanel {
  private Bal bal;
  private JButton startknop, stopknop;

  public Balpaneel() {
    startknop = new JButton( "Start" );
    stopknop = new JButton( "Stop " );
    startknop.addActionListener( new StartknopHandler() );
    stopknop.addActionListener( new StopknopHandler() );
    add( startknop );
    add( stopknop );
  }
  
  class StartknopHandler implements ActionListener {
    public void actionPerformed( ActionEvent e ) {
      if( bal == null ) {  // zodat je er geen twee kan maken, doe het eens weg ...
        bal = new Bal( getGraphics(), 10, getBackground());
        //bal = new Bal( getGraphics(), 10, Color.GREEN);
        bal.start();
      }
    }
  }
   
  class StopknopHandler implements ActionListener {
    public void actionPerformed( ActionEvent e ) {
      bal.nuStoppen();
      bal = null;  // thread is "dood", pointer heeft geen zin meer +
                   // je zou geen nieuwe meer kunnen maken
                   
      
    }
  }  
}


class Bal extends Thread {
  private Graphics pen;
  private int x, y, grootte;
  private Color kleur, wiskleur;
  private int dx;
  private boolean doorgaan;
  
  
  public Bal( Graphics g, int grootte, Color wiskleur ) {
    pen = g;
    this.grootte = grootte;
    this.wiskleur = wiskleur;
    x = -100;
    y = 0;
    dx = 2;
    doorgaan = true;
  }
  
  public void run() {
    pen.translate( 200, 300 );
    while( doorgaan ) {
      teken( Color.red );
      slaap( 10 );
      teken( wiskleur );
      verplaats();
    }
  }

  public void teken( Color kleur ) {
    pen.setColor( kleur );
    pen.fillOval( x, y, grootte, grootte );
  }
  
  public void nuStoppen() {
    doorgaan = false;
  }

  private void verplaats() {  // verplaatsing volgens parabool
    if( x + dx > 100 || x + dx < -100 ) {
      dx = -dx;
    }
    x += dx;
    y = (int) (x-100) * (x+100) / 50;
  }
  
  public void slaap( int millisec ) {
    try {
      Thread.sleep( millisec );
    }
    catch( InterruptedException e ) {}
  }
}

