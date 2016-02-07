// Voorbeeld 1309  Wissen zonder XOR
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Vb1309 extends JFrame {
  public static void main( String args[] ) {
    JFrame frame = new Vb1309();
    frame.setSize( 400, 340 );
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    frame.setTitle( "Voorbeeld 1309  Wissen zonder XOR" );
    frame.setContentPane( new Balpaneel() );
    frame.setVisible( true );
  }
}


class Balpaneel extends JPanel {
  private Bal bal;
  private JButton startknop, pauzeknop, eindePauzeknop, stopknop;
  
  public Balpaneel() {
    startknop = new JButton( "Start" );
    stopknop  = new JButton( "Stop " );
    pauzeknop = new JButton( "Pauze" );
    eindePauzeknop = new JButton( "Einde pauze" );

    startknop.addActionListener( new StartknopHandler() );
    pauzeknop.addActionListener( new PauzeknopHandler() );
    eindePauzeknop.addActionListener( new EindePauzeknopHandler() );
    stopknop.addActionListener( new StopknopHandler() );
    add( startknop );
    add( pauzeknop );
    add( eindePauzeknop );
    add( stopknop );
  }
  
  public void paintComponent( Graphics g ) {
    super.paintComponent( g );    
    int halveBreedte = getWidth() / 2 ;
    int halveHoogte = getHeight() / 2;
    g.setColor( Color.YELLOW );
    g.fillRect( 0, 0, halveBreedte, halveHoogte );
    g.setColor( Color.LIGHT_GRAY );
    g.fillRect( halveBreedte, 0, halveBreedte, halveHoogte );
    g.setColor( Color.ORANGE );
    g.fillRect( 0, halveHoogte, halveBreedte, halveHoogte );
    g.setColor( Color.CYAN );
    g.fillRect( halveBreedte, halveHoogte, halveBreedte, halveHoogte  );
  }
  
  class StartknopHandler implements ActionListener {
    public void actionPerformed( ActionEvent e ) {
      if( bal == null ) {
        bal = new Bal( getGraphics(), 10, getBackground() );
        bal.start();
      }
    }
  }

  class PauzeknopHandler implements ActionListener {
    public void actionPerformed( ActionEvent e ) {
      if( bal != null )
        bal.pauzeer();
    }
  }

  class EindePauzeknopHandler implements ActionListener {
    public void actionPerformed( ActionEvent e ) {
      if( bal != null )
        bal.pauzeVoorbij();
    }
  }
  
  class StopknopHandler implements ActionListener {
    public void actionPerformed( ActionEvent e ) {
      if( bal != null ) {
        bal.nuStoppen();
        bal = null;
        repaint();
      }
    }
  }  
}


class Bal extends Thread {
  private Graphics pen;
  private int x, y, grootte;
  private Color kleur, wiskleur;
  private int dx;
  private boolean doorgaan, pauze;
  
  
  public Bal( Graphics g, int grootte, Color wiskleur ) {
    this.pen = g;
    this.grootte = grootte;
    this.wiskleur = wiskleur;
    x = -100;
    y = 0;
    dx = 2;
    doorgaan = true;
    pauze = false;
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
  
  public void pauzeer() {
    pauze = true;
  }

  public synchronized void pauzeVoorbij() {
    pauze = false;
    notify();
  }

  private synchronized void controleerPauze() throws
                                      InterruptedException {
    while( pauze ) {
      wait();
    }
  }    

  private void verplaats() {  // verplaatsing volgens parabool
    if( x + dx > 100 || x + dx < -100 ) {
      dx = -dx;
    }
    x += dx;
    y = (int) (x-100) * (x+100) / 50;
  }
  
  private void slaap( int millisec ) {
    try {
      Thread.sleep( millisec );
      controleerPauze();
    }
    catch( InterruptedException e ) {}
  }
}

