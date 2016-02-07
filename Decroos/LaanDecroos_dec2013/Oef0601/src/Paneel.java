/* 
 * Naam : LDC
 * 
 * Beschrijving : Oef0601 blz 146
 *
 * ingeven van een datum via 1 tekstvak 
 * 
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
// eventueel extra imports hier

  // de datumklasse
class Datum {
  private int dag;
  private int maand;
  private int jaar;

  // Constructors
  public Datum() {
    this( 1, 1, 2000 );  // 6.7.5 ene Constructor roept de andere op   
  }

  public Datum( int dag, int maand, int jaar ) {
    this.dag = dag;
    this.maand = maand;
    this.jaar = jaar;
  }

  // Getters
  public int getDag() {
    return dag;
  }

  public int getMaand() {
    return maand;
  }

  public int getJaar() {
    return jaar;
  }
    
  // Setters
  public void setDag( int dag ) {
    this.dag = dag;
  }

  public void setMaand( int maand ) {
    this.maand = maand;
  }

  public void setJaar( int jaar ) {
    this.jaar = jaar;
  }

  // Overige methoden
  public String toString() {
    return String.format( "%02d-%02d-%4d",
                   getDag(), getMaand(), getJaar() );
    // kan ook zo :
    //return String.format( "%02d-%02d-%4d",
    //               dag, maand , jaar );    
    // maar als je eerste vorm test heb je ineens ook de getters getest
  }

}



public class Paneel extends JPanel {
    // declaraties van de variabelen
    
    // referenties naar objecten 
  private JLabel label;
  private JTextField tekstvak;
  private Datum datum;  
  private String boodschap;
   
    // primitieve variabelen
  boolean dagIngevoerd, maandIngevoerd;

    // Constructor
  public Paneel() {
    datum = new Datum();
    
    label = new JLabel ("Voer dag in");
 
    tekstvak = new JTextField( 5 );
    tekstvak.addActionListener (new VakHandler());
    
      // elementen toevoegen aan paneel-object
    add (label);
    add( tekstvak );
  }
  
  public void paintComponent( Graphics g ) {
      super.paintComponent( g );
      // zoals in het boek, maar eerst tekst in boodschap stoppen :
//      boodschap = 
//      	String.format("De ingevoerde datum is %02d-" , 
//      		datum.getDag())
//      		+ String.format("%02d-" , datum.getMaand())
//      		+ String.format("%04d" , datum.getJaar());
//      // en dan de boodschap afdrukken
//      g.drawString( boodschap , 50, 100 ); 
//      
      // als je in Datum de toString() methode activeert kan
      // je ook dit schrijven: (je MOET .toString() zetten !)
      g.drawString("De ingevoerde datum is " + datum.toString() , 50, 100 );
      // of korter :
      // g.drawString( "" + datum , 50, 100 ); 
     

  }
  
  
      // interne klasse voor event-handler
  class VakHandler implements ActionListener {
    public void actionPerformed( ActionEvent e ) {
       // hier komen de event-handler opdrachten
      int getal = Integer.parseInt( tekstvak.getText());
      tekstvak.setText("");
      if (!dagIngevoerd){
      	datum.setDag(getal);
      	dagIngevoerd = true;
      	label.setText("Voer maand in");
      }
      else{
      	  if (!maandIngevoerd){
      	  	datum.setMaand(getal);
      	    maandIngevoerd = true;
      	    label.setText("Voer jaartal in");
      	  }
      	  else{
      	  	datum.setJaar(getal);
      	  	label.setText("Voer dag in");
      	  	dagIngevoerd = false;
      	  	maandIngevoerd = false;
      	  	repaint();
      	  }
      }
    }
  }
}
