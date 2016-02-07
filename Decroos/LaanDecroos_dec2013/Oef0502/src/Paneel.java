/* Naam : LDC 2007
 * Beschrijving : Laan 3, blz 116 : Oef 0502
 * Drie getallen sorteren van klein naar groot
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Paneel extends JPanel {
  private JTextField tekstvak1, tekstvak2, tekstvak3;
  private String boodschap = "Tik drie getallen in en druk <Enter>";
    // Constructor
  public Paneel() {
	VakHandler vh = new VakHandler();  // 1 object bedient drie vakken, zie Vb0503 !!!  
    tekstvak1 = new JTextField( 10 );
    tekstvak1.addActionListener (vh);
    tekstvak2 = new JTextField( 10 );
    tekstvak2.addActionListener (vh);
    tekstvak3 = new JTextField( 10 );
    tekstvak3.addActionListener (vh);
      // elementen toevoegen aan paneel-object
    add( tekstvak1 );
    add( tekstvak2 );
    add( tekstvak3 );
  }
  
  public void paintComponent( Graphics g ) {
      super.paintComponent( g );
      g.drawString( boodschap , 50, 100 ); // druk de boodschap
  }
  
      // interne klasse voor event-handler
  class VakHandler implements ActionListener {
    public void actionPerformed( ActionEvent e ) {
      // enkele lokale variabelen      
      boolean gelukt = true; // we denken positief ;-)
                             // is de 'potlood' truc
      double getal1=0,getal2=0,getal3=0; // drie ingevoerde getallen
      double temp = 0; // temp nodig voor swap
      // probeer het inlezen (beveiligde invoer)                                   
      try{
       getal1 = Double.parseDouble( tekstvak1.getText());
       getal2 = Double.parseDouble( tekstvak2.getText());
       getal3 = Double.parseDouble( tekstvak3.getText());
      }
      catch (NumberFormatException fout){       // vang de fout op en doe er iets nuttig mee                   
        	boodschap = "Helaba, je moet wel getallen intikken hoor !!!";
        	// je zou hier nu bvb kunnen zetten : repaint();
        	// is niet goed : actionPerformed() kan dan op twee plaatsen verlaten worden,
        	// dat doet alleen een slecht programmeur !!!
        	// beter is bvb. : 
        	gelukt = false; // en elders uitmaken wat er dan moet volgen ...
      }
        // en nu sorteren ...
      if (gelukt){   // hier dus, als het inlezen mislukt is wordt dit deel niet uitgevoerd
      	if (getal1 > getal2){
      		temp = getal1;
      		getal1 = getal2;
      		getal2 = temp;
      	}
      	if (getal2 > getal3){
      		temp = getal2;
      		getal2 = getal3;
      		getal3 = temp;
      	}
      	if (getal1 > getal2){
      		temp = getal1;
      		getal1 = getal2;
      		getal2 = temp;
      	}
      	boodschap = "Gesorteerde getallen : " + getal1 + " , " + getal2 + " , " + getal3;
      }
      
      repaint();  // methode actionPerformed() eindigt in alle gevallen HIER !
    }
  }

  
}