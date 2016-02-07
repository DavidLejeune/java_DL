// Voorbeeld 1308  Thread met pauzemogelijkheid
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Vb1308 extends JFrame {
  public static void main( String args[] ) {
    JFrame frame = new Vb1308();
    frame.setSize( 400, 340 );
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    frame.setTitle( "Voorbeeld 1308  Thread met pauzemogelijkheid" );
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
  
  class StartknopHandler implements ActionListener {
    public void actionPerformed( ActionEvent e ) {
      if( bal == null ) {
        bal = new Bal( getGraphics(), 10, getBackground());
        //bal = new Bal( getGraphics(), 10, Color.GREEN);
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
      slaap( 10 );  // hierin wordt ook de "pauzetoestand" gecontroleerd
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
    notify();  // thread uit de wait toestand halen
  }

  private synchronized void controleerPauze() throws
                                      InterruptedException {
    while( pauze ) {
      wait(); // eens in wait, staat de thread geblokkeerd
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
      controleerPauze();  // hier dus controle van de "pauzetoestand"
    }
    catch( InterruptedException e ) {}
  }
}

