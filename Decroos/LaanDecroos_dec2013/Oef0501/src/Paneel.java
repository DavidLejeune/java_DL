/* 
 * Naam : LDC 2007
 *
 * 
 * Beschrijving : Laan 3, blz 115 : Oef 0501
 * Bepalen in welk van twee tekstvakken het grootste getal staat
 *
 */
 
import javax.swing.*;
import java.awt.event.*;
// eventueel extra imports hier

public class Paneel extends JPanel {
    // declaraties van de variabelen
    
    // referenties naar objecten 
  
  private JTextField tekstvak1,tekstvak2;
  private VakHandler vh;
    
 //private double getal3;
  
    // Constructor
  public Paneel() {
	   
	vh = new VakHandler();  // 1 object bedient twee vakken, zie Vb0503 !!!  
    
    tekstvak1 = new JTextField( 10 );
    tekstvak1.addActionListener (vh);
    
    tekstvak2 = new JTextField( 10 );
    tekstvak2.addActionListener (vh);
    
      // elementen toevoegen aan paneel-object
    
    add( tekstvak1 );
    add( tekstvak2 );
  }
  
      // interne klasse voor event-handler
  class VakHandler implements ActionListener {
    public void actionPerformed( ActionEvent e ) {
       // hier komen de event-handler opdrachten
    String invoer1="", invoer2="";
    boolean eersteOk = false; 
    try{ // niet in boek : beveiliging ( = H12)
        invoer1 = tekstvak1.getText();
        invoer1 = invoer1.replace( ',' , '.' );
        double getal1 = Double.parseDouble( invoer1 );
        // als je hier geraakt is 1e getal ok
        eersteOk = true;
        invoer2 = tekstvak2.getText();
        invoer2 = invoer2.replace( ',' , '.' );
        double getal2 = Double.parseDouble( invoer2 );
          // let op aantal & plaats van accoladen !!!
          // buitenste if-else
      	if ( getal1 != getal2 ){
         
         // binnenste if-else
         	if (getal1>getal2){
       	   		System.out.println("Het grootste getal stond in vak 1");
         	}
        	else{
           		System.out.println("Het grootste getal stond in vak 2");
         	} // sluit binnenste else
       	} // sluit buitenste if
       	else{
       	 	System.out.println("Flauw hoor ... in beide vakken stond hetzelfde getal");
       	} // sluit buitenste else 
       
      }
      catch (NumberFormatException fout){                         
      //	System.out.println("Helaba, je moet wel getallen intikken hoor !!!");
      	//fout.printStackTrace();
      	  String boodschap="";
      	 
      	 if (eersteOk) boodschap = " tweede ";
      	 else boodschap = " eerste ";
      	 
      	 JOptionPane.showMessageDialog(
          Paneel.this,
          "Fout in je " + boodschap + "getal",
          "Fout in invoer",
          JOptionPane.ERROR_MESSAGE
        );    	
      	
      }
      
     }
  }
}