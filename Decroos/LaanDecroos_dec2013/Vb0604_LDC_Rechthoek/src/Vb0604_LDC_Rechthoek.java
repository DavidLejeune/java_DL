/* Extra Voorbeeld  H6 : VB0604_LDC_Rechthoek
 * Rechthoek met draaihoek
 * Luc Decroos - KHBO - 071126
 */
import javax.swing.*;
import java.awt.*;   
import java.awt.event.*;
   
public class Vb0604_LDC_Rechthoek extends JFrame {
  public static void main( String args[] ) {
    JFrame frame = new Vb0604_LDC_Rechthoek();
    frame.setSize( 500, 500 );
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    frame.setTitle( "Vb0604_LDC_Rechthoek" );
    frame.setContentPane( new Tekenpaneel() );
    frame.setVisible( true );
  }
}

class Tekenpaneel extends JPanel {
  private LDC_Rechthoek rechthoek1;
  private JButton knop;
  private Color kl;
  
  public Tekenpaneel() {
    setBackground( Color.BLACK );
     // willekeurig kleurtje kiezen
    kl = new Color( (int) ( 16777216 * Math.random())); 
    	    // constructor Color (int RGB), zie index
    		// RGB getal 0 tot 2^24-1
    rechthoek1 = new LDC_Rechthoek( kl , 250, 200, 150, 75,0 );
    knop = new JButton( "Draai" );
    knop.addActionListener( new KnopHandler() );
    add( knop );
  }

  public void paintComponent( Graphics g ) {
    super.paintComponent( g );
      rechthoek1.teken( g );
      
      // dit werkt hier niet zoals verwacht :
//      for (int i = 0; i<5;i++){
//      	 kl = new Color( (int) ( 16777216 * Math.random()));
//         rechthoek1.setKleur( kl);      
//         rechthoek1.draai(5);
//      	 rechthoek1.teken(g);
//      	 slaap(250);
//      }
  }
     // inwendige klasse
  class KnopHandler implements ActionListener {
    public void actionPerformed( ActionEvent e ) {
              // bij iedere klik kleur veranderen
      kl = new Color( (int) ( 16777216 * Math.random()));
      rechthoek1.setKleur( kl);      
      rechthoek1.draai(5);
      //repaint();
      
      // maar hier kan het dus wel ...
      Graphics g = getGraphics();
      for (int i = 0; i<50;i++){
      	 kl = new Color( (int) ( 16777216 * Math.random()));
         rechthoek1.setKleur( kl);      
         rechthoek1.draai(5);
      	 rechthoek1.teken(g);
      	 slaap(250);
      }
    }
  }
       // slaap routine
  public static void slaap (int mSec){		 
		try {
			Thread.currentThread().sleep(mSec); 
		} catch (InterruptedException e){ }
	} 
}
 
 // uitwendige klasse
class LDC_Rechthoek {
  private Color kleur;
  private int x, y;
  private int breedte, hoogte;
  private int hoek; //****** = EXTRA
                           
     // Constructor
  public LDC_Rechthoek( Color kleur, int x, int y,
                    int breedte, int hoogte, int hoek ) {
    this.kleur = kleur;
    this.x = x;
    this.y = y;
    this.breedte = breedte;
    this.hoogte = hoogte;
    this.hoek = hoek;
  }
         // een setter
  public void setKleur (Color kleur) {
    this.kleur = kleur;
  }      

         // wel een mutator, maar geen zuivere "setter" 
  public void draai (int deltaHoek) {
    hoek += deltaHoek;
  }
         // teken de rechthoek
  public void teken( Graphics pen ) {
  	 // lokale variabelen
    int x1,y1,x2,y2,x3,y3,x4,y4;           // 4 hoekpunten
    double hrad = hoek * Math.PI / 180.0 ; // 180.0 anders gehele deling !!!
       // er is ook een methode voor : 
       // double hrad = Math.toRadians(hoek);
    
    x1 = x; // hoekpunt steeds in oorsprong houden
    y1 = y; 
           // andere coordinaten berekenen 
           // een beetje goniometrie-kennis is altijd handig ...
           // teken het maar eens uit !
    x2 = x1 + (int) ( Math.round( breedte * Math.cos (hrad))) ;
    y2 = y1 - (int) ( Math.round( breedte * Math.sin (hrad))) ;
    
    x3 = x2 + (int) ( Math.round( hoogte * Math.sin (hrad))) ;
    y3 = y2 + (int) ( Math.round( hoogte * Math.cos (hrad))) ;
    
    x4 = x1 + (int) ( Math.round( hoogte  * Math.sin (hrad))) ;
    y4 = y1 + (int) ( Math.round( hoogte  * Math.cos (hrad))) ;

        // figuur tekenen
    pen.setColor( kleur );
        // een gevulde rechthoek is voorlopig iets te moeilijk ...
    pen.drawLine( x1,y1,x2,y2 ); // 4 lijnen
    pen.drawLine( x2,y2,x3,y3 );
    pen.drawLine( x3,y3,x4,y4 );
    pen.drawLine( x4,y4,x1,y1 ); 
    	
     // ... hoewel, voor de liefhebbers	: met fillPolygon() , je hebt 2 arrays nodig
     int[] xx =  {x1,x2,x3,x4,x1}; // dus 5 punten voor een gesloten figuur
     int[] yy =  {y1,y2,y3,y4,y1};
     pen.fillPolygon (xx,yy,5);
  }
}


