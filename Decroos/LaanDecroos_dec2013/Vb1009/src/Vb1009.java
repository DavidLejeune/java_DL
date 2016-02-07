// Voorbeeld 1009  Verkeerslicht
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Vb1009 extends JFrame {
  public static void main( String args[] ) {
    JFrame frame = new Vb1009();
    frame.setSize( 400, 400 );
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    frame.setTitle( "Voorbeeld 1009  Gescheiden model en view" );
    frame.setContentPane( new Verkeerslichtpaneel() );
    frame.setVisible( true );
  }
}


class Verkeerslichtpaneel extends JPanel {
  private Verkeerslicht model;
  private Verkeerslichtview view;
  private Bedieningspaneel bedieningspaneel;

  public Verkeerslichtpaneel() {
    setLayout( new BorderLayout() );
    
    model = new Verkeerslicht( true, false, false ); // licht op rood
								
			// let op model als argument !
    view = new Verkeerslichtview( model );
    
    					// let op model + view als argument !!
    bedieningspaneel = new Bedieningspaneel( model, view );
    
    add( view, BorderLayout.CENTER );
    add( bedieningspaneel, BorderLayout.SOUTH );
  }
}


class Verkeerslichtview extends JPanel {
  private Verkeerslicht model; //lokale kopie van ZELFDE model uit hoofdpaneel

  // Constructor
  public Verkeerslichtview( Verkeerslicht model ) {
    this.model = model;
  }
  
  public void paintComponent( Graphics g ) {
    super.paintComponent( g );
    g.setColor( Color.GRAY );
    int midden = getBounds().width / 2;

    // De kast voor de lampen
    g.fillRect( midden - 30, 50, 60, 160 );
    		//vb hieraan iets veranderen = enkel aan de View werken
    		//g.fillRoundRect( midden - 30, 50, 60, 160, 25 , 25 );
    // De paal
    g.fillRect( midden - 5, 210, 10, 120 );
    
    // Teken de lampen
    if( model.isRood() )
      g.setColor( Color.RED );
    else 
      g.setColor( Color.LIGHT_GRAY );
    g.fillOval( midden - 20, 60, 40, 40 );

    if( model.isOranje() )
      g.setColor( Color.ORANGE );
    else
      g.setColor( Color.LIGHT_GRAY );
    g.fillOval( midden - 20, 110, 40, 40 );

    if( model.isGroen() )
      g.setColor( Color.GREEN );
    else
      g.setColor( Color.LIGHT_GRAY );
    g.fillOval( midden - 20, 160, 40, 40 );
  }
}


class Bedieningspaneel extends JPanel {
  private Verkeerslicht model;  // lokale kopie van nog eens ZELFDE model
  private JPanel view; //lokale kopie van view-paneel --> repaint() oproepen
  private JButton roodKnop, oranjeKnop, groenKnop;

  // Constructor : twee argumenten 
  public Bedieningspaneel( Verkeerslicht model, Verkeerslichtview view ) {
    this.model = model;
    this.view = view;

    setBackground( Color.DARK_GRAY );

    roodKnop   = new JButton( "rood" );
    oranjeKnop = new JButton( "oranje" );
    groenKnop  = new JButton( "groen" );

    Handler handler = new Handler();
    roodKnop.addActionListener( handler );
    oranjeKnop.addActionListener( handler );
    groenKnop.addActionListener( handler );

    add( roodKnop );
    add( oranjeKnop );
    add( groenKnop );
  }

  class Handler implements ActionListener {
    public void actionPerformed( ActionEvent e ) {
      if( e.getSource() == roodKnop )
        model.setRood(); // hier dus model nodig !
      else
      if( e.getSource() == oranjeKnop )
        model.setOranje();
      else
      if( e.getSource() == groenKnop )
        model.setGroen();
      
      view.repaint(); // hiervoor dus view nodig !
    }
  }
}

// Model
class Verkeerslicht {
	// wat moet je weten van een verkeerslicht ?
	// --> toestand van de lampen :	
  private boolean rood, oranje, groen;

  public Verkeerslicht( boolean rood, boolean oranje, boolean groen ) {
    this.rood = rood;
    this.oranje = oranje;
    this.groen = groen;
  }
    // setters
  public void setRood() {
    reset();
    rood = true;  }

  public void setOranje() {
    reset();
    oranje = true;  }

  public void setGroen() {
    reset();
    groen = true;  }
  
  public void reset() { // zodat er altijd maar 1 lamp tegelijk brandt
    rood   = false;
    oranje = false;
    groen  = false;  }
    
   // getters
  public boolean isRood() {
    return rood;  }

  public boolean isOranje() {
    return oranje;  }

  public boolean isGroen() {
    return groen;  }
}