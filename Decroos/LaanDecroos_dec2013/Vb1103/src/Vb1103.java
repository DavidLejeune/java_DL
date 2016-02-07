// Voorbeeld 1103  Grafiek
// Met ArrayList
// Namen van de Panelen aangepast voor meer duidelijkheid

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Vb1103 extends JFrame {
  public static void main( String args[] ) {
    JFrame frame = new Vb1103();
    frame.setSize( 500, 300 );
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    frame.setTitle( "Voorbeeld 1103  Grafiek" );
    frame.setContentPane( new Hoofdpaneel() );
    frame.setVisible( true );
  }
}

      // het paneel met de BorderLayout
class Hoofdpaneel extends JPanel {
  private Bedieningspaneel bedieningspaneel; 
  private Grafiekpaneel    grafiekpaneel;
  private Functie f1, f2, f3; //statisch type, van de INTERFCACE

  public Hoofdpaneel() {
    setLayout( new BorderLayout() );
    grafiekpaneel = new Grafiekpaneel( -3, -4, 5, 10 );
    f1 = new Derdegraads(); // dynamisch type, van de subklassen
    f2 = new ExpPlusSin();
	f3 = new DemoFunctie();
    bedieningspaneel = new Bedieningspaneel( grafiekpaneel, f1, f2, f3 );
    add( grafiekpaneel, BorderLayout.CENTER );
    add( bedieningspaneel, BorderLayout.SOUTH );
  }
}


class Grafiekpaneel extends JPanel {
  private double links = -10, onder = -10,
                 rechts = 10, boven = 10;
  private Functie functie; // Functie  = statisch type

  private int assenBreedte, assenHoogte;
  private double xFactor, yFactor;
  private ArrayList<Double> xWaarden, yWaarden;

  public Grafiekpaneel() {
    xWaarden = new ArrayList<Double>();
    yWaarden = new ArrayList<Double>();
  }

  public Grafiekpaneel( double links, double onder,
                  double rechts, double boven ) {
    this();
    this.links = links;
    this.onder = onder;
    this.rechts = rechts;
    this.boven = boven;
  }

  public void paintComponent( Graphics g ) {
    super.paintComponent( g );

    assenBreedte = getBounds().width - 1;
    assenHoogte = getBounds().height - 1;
    xFactor = assenBreedte / ( rechts - links );
    yFactor = assenHoogte / ( boven - onder );

    setBackground( Color.WHITE );
    tekenAssen( g );

    if( functie != null ) {
      xWaarden.clear();
      yWaarden.clear();
      // Bereken de functiewaarden
      for( double x = links; x <= rechts; x += 0.1 ) {
        xWaarden.add( x );
        yWaarden.add( functie.f( x ) );//*** dit is de speciale oproep !
      }
      // Teken de grafiek
      g.setColor( Color.black );
      for( int i = 1; i < xWaarden.size(); i++ ) {
        tekenLijn( g, xWaarden.get( i-1 ), yWaarden.get( i-1 ),
                      xWaarden.get( i ), yWaarden.get( i ) );
      }
    }
  }

  public void setFunctie( Functie functie ) {
    this.functie = functie;
  }

  private void tekenAssen( Graphics g ) {
    g.setColor( Color.BLACK );
    tekenLijn( g, links, 0, rechts, 0 );
    tekenLijn( g, 0, onder, 0, boven );
  }

  private void tekenLijn( Graphics g, double x1, double y1,
    double x2, double y2 ) {
    g.drawLine( xPxl( x1 ), yPxl( y1 ),
    xPxl( x2 ), yPxl( y2 ) );
  }

  private int xPxl( double x ) {
    return (int) Math.round( (x - links ) * xFactor );
  }

  private int yPxl( double y ) {
    return (int) Math.round( (boven - y ) * yFactor );
  }
}


interface Functie {
  public double f( double x );
}


// twee concrete implementaties van Functie :

class Derdegraads implements Functie {
  public double f( double x ) {
    return -0.5 * (x + 2) * (x - 1) * (x - 2);
  }
}

class ExpPlusSin implements Functie {
  public double f( double x ) {
    return Math.exp( x ) + Math.sin( 3*x );
  }
}

class DemoFunctie implements Functie {  // nog extra functie, niet in boek
  public double f( double x ) {
    return x*x - Math.cos (x*x);
    //return Math.pow(x,x);
  }
}



class Bedieningspaneel extends JPanel {
  private JButton knop1, knop2,knop3;
  private Grafiekpaneel grafiekpaneel;
  private Functie f1, f2, f3;
                               
  public Bedieningspaneel( Grafiekpaneel grafiekpaneel, 
  	                       Functie f1, Functie f2, Functie f3 ) {
  	          // merk op : 3x zelfde statisch type = Functie
    this.grafiekpaneel = grafiekpaneel;
    this.f1 = f1;
    this.f2 = f2;    
    this.f3 = f3;
    
    knop1 = new JButton( "f1" );
    knop1.addActionListener( new KnopHandler() );
    knop2 = new JButton( "f2" );
    knop2.addActionListener( new KnopHandler() );
    knop3 = new JButton( "f3" );
    knop3.addActionListener( new KnopHandler() );
    
    add( knop1 );
    add( knop2 );
    add( knop3 );
    setBackground( Color.BLUE );
  }

  class KnopHandler implements ActionListener {
    public void actionPerformed( ActionEvent e ) {
      if( e.getSource() == knop1 ) {
        grafiekpaneel.setFunctie( f1 );
        grafiekpaneel.repaint();
      }
      if( e.getSource() == knop2 ) {
        grafiekpaneel.setFunctie( f2 );
        grafiekpaneel.repaint();
      }
      
      if( e.getSource() == knop3 ) {
        grafiekpaneel.setFunctie( f3 );
        grafiekpaneel.repaint();
      }
      
    }
  }
}
