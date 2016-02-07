// Voorbeeld 0307
// Optelmachine
// Invoer van gehele getallen in een tekstvak + extra : int en Integer vergeleken
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Vb0307 extends JFrame {
  public static void main( String args[] ) {
    JFrame frame = new Vb0307();
    frame.setSize( 400, 200 );
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    frame.setTitle( "Voorbeeld 0307" );
    frame.setContentPane( new Optelpaneel() );
    frame.setVisible( true );
  }
}

// Paneel met drie tekstvakken
class Optelpaneel extends JPanel {
  private JTextField invoervak1, invoervak2, resultaatVak;
  private JButton plusKnop;
  
  	// extra : verschil tussen een int en een Integer-object !
    int getal1 = 5, getal2; // twee primitieve int-variabelen : elk 4 bytes
    int resultaat = 15; // dit MOET een globale variabele zijn !
        
    Integer getal3 = new Integer (10); // een referentie (4 bytes) naar een
         				// Integer-object waarin een int-getal opgeborgen zit
         				// (nog eens 4 bytes) : totaal 8 bytes
  
  public Optelpaneel() {
  	invoervak1 = new JTextField( 10 );
    invoervak2 = new JTextField( 10 );
    resultaatVak = new JTextField( 10 );

    plusKnop = new JButton( " + " );
    plusKnop.addActionListener( new PlusKnopHandler() );
  
    add( invoervak1 );
    add( invoervak2 );
    add( plusKnop );
    add( resultaatVak );
  }

  // Inwendige klasse
  class PlusKnopHandler implements ActionListener {
    public void actionPerformed( ActionEvent e ) {
    	
      String invoerstring1 = invoervak1.getText();      
        // lokale variabelen getal1 en getal2 zijn ANDERE variabelen !
       getal1 = Integer.parseInt( invoerstring1 ) ;

      String invoerstring2 = invoervak2.getText();
        getal2 = Integer.parseInt( invoerstring2 );

      resultaat = getal1 + getal2;

      resultaatVak.setText( "" + resultaat );
      
      repaint();
    }
  }  
  
  public void paintComponent( Graphics g ) {
    super.paintComponent( g );
        	// extra gegevens afdrukken op paneel
        	// vergelijk de complexiteit !
    
    	g.drawString("int getal1 is         = " + getal1, 10,80);        
    		// gewoon int ophalen uit geheugen
    	g.drawString("int getal2 is         = " + getal2, 10,100);        
    		// gewoon int ophalen uit geheugen                               
    	g.drawString("Integer object = " + getal3.toString() ,10,120); 
    		                    // ook nog getal3.valueOf()    		             
    		// een (optionele) methode nodig om aan het getal te geraken 
    		// maar mag ook gewoon getal3, zal automatisch toString() oproepen 
    	g.drawString("resultaat      = " + resultaat, 10,140);    

  }	
      	
}
