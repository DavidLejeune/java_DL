// Voorbeeld 1103a  Grafiek
// Met TreeMap
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Vb1103a extends JFrame {
  public static void main( String args[] ) {
    JFrame frame = new Vb1103a();
    frame.setSize( 500, 300 );
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    frame.setTitle( "Voorbeeld 1103a  Grafiek" );
    frame.setContentPane( new Grafiekpaneel() );
    frame.setVisible( true );
  }
}


class Grafiekpaneel extends JPanel {
  private JPanel bedieningspaneel; 
  private Grafiek grafiek;
  private Functie f1, f2;

  public Grafiekpaneel() {
    setLayout( new BorderLayout() );
    grafiek = new Grafiek( -7, -4, 7, 10 );
    f1 = new DerdeGraads();
    f2 = new SinX();

    bedieningspaneel = new Bedieningspaneel( grafiek, f1, f2 );
    add( grafiek, BorderLayout.CENTER );
    add( bedieningspaneel, BorderLayout.SOUTH );
  }
}


class Grafiek extends JPanel {
  private double links = -10, onder = -10,
                 rechts = 10, boven = 10;
  private Functie functie;

  private int assenBreedte, assenHoogte;
  private double xFactor, yFactor;
  private TreeMap<Double, Double> map;

  public Grafiek() {
    map = new TreeMap<Double, Double>();
  }

  public Grafiek( double links, double onder,
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

    setBackground( Color.LIGHT_GRAY );
    tekenAssen( g );

    if( functie != null ) {
      map.clear();
      // Bereken de functiewaarden
      for( double x = links; x <= rechts; x += 0.1 ) {
        map.put( x, functie.f( x ) );
      }
      // Teken de grafiek
      g.setColor( Color.black );
      Set<Double> xWaarden = map.keySet();
      for( Double x : xWaarden ) {
        Double x2 = map.higherKey( x );
        if( x2 != null )
          tekenLijn( g, x, map.get( x ), x2, map.get( x2 ) );
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
    g.drawLine( xPxl( x1 ), yPxl( y1 ), xPxl( x2 ), yPxl( y2 ) );
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

class DerdeGraads implements Functie {
  public double f( double x ) {
    return 0.5 * (x + 2) * (x - 1) * (x - 2);
  }
}

class SinX implements Functie {
  public double f( double x ) {
    return 2 * Math.sin( x );
  }
}



class Bedieningspaneel extends JPanel {
  private JButton knop1, knop2;
  private Grafiek grafiek;
  private Functie f1, f2;

  public Bedieningspaneel( Grafiek grafiek, Functie f1, Functie f2 ) {
    this.grafiek = grafiek;
    this.f1 = f1;
    this.f2 = f2;
    knop1 = new JButton( "f1" );
    knop1.addActionListener( new KnopHandler() );
    knop2 = new JButton( "f2" );
    knop2.addActionListener( new KnopHandler() );
    add( knop1 );
    add( knop2 );
    setBackground( Color.BLUE );
  }

  class KnopHandler implements ActionListener {
    public void actionPerformed( ActionEvent e ) {
      if( e.getSource() == knop1 ) {
        grafiek.setFunctie( f1 );
        grafiek.repaint();
      }
      if( e.getSource() == knop2 ) {
        grafiek.setFunctie( f2 );
        grafiek.repaint();
      }
    }
  }
}
