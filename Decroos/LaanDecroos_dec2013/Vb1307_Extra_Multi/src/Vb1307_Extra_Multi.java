// Voorbeeld 1307  Bal als Thread - Meerdere balletjes in een ArrayList

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Vb1307_Extra_Multi extends JFrame {
  public static void main( String args[] ) {
    JFrame frame = new Vb1307_Extra_Multi();
    frame.setSize( 400, 340 );
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    frame.setTitle( "Voorbeeld 1307  Bal als Thread" );
    frame.setContentPane( new Balpaneel() );
    frame.setVisible( true );
  }
}


class Balpaneel extends JPanel {
  private Bal bal;
  
  
  private ArrayList<Bal> lijst;    //*** nieuw
  private JButton startknop, stopknop;

  public Balpaneel() {
    startknop = new JButton( "Start" );
    stopknop = new JButton( "Stop " );
    startknop.addActionListener( new StartknopHandler() );
    stopknop.addActionListener( new StopknopHandler() );
    add( startknop );
    add( stopknop );
    
    lijst = new ArrayList<>(); // ***** nieuw
    
  }
  
  class StartknopHandler implements ActionListener {
    public void actionPerformed( ActionEvent e ) {
        bal = new Bal( getGraphics(), 10, getBackground() );
        bal.start();
        lijst.add(bal); // ***** nieuw
    }
  }
  
 
  
  class StopknopHandler implements ActionListener {
    public void actionPerformed( ActionEvent e ) {
     // alle balletjes ineens weg
//     for (Bal bal : lijst) {	// ***** nieuw
//   		bal.nuStoppen();
//        bal = null;  // thread is "dood", pointer heeft geen zin meer
//     }
     
     //ofwel één voor één stopppen tot er geen meer zijn
     if(lijst.size()>0){
      	Bal temp = lijst.get(lijst.size()-1);
      	temp.nuStoppen();
        temp = null;  // thread is "dood", pointer heeft geen zin meer
        lijst.remove(lijst.size()-1);
        System.out.println("aantal in lijst = "+ lijst.size());
     }              
       
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
    this.pen = g;
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

