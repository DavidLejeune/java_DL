/**
 * De klasse <code>Lesrooster</code> representeert een lesrooster,
 * waaraan je instanties van <code>Les</code> 
 * kunt toevoegen.
 * @author Gertjan Laan
 * @version 1.0
 * @see Les
 */
import java.util.*;

public class Lesrooster { // klasse Lesrooster IS geen ArrayList !!!
						  // maar BEVAT (o.a.) een ArrayList (van Les objecten)
						  // of nog : is "eigenaar" van de ArrayList
  
  private ArrayList<Les> lijst; // de lijst van lessen
        
        // ****** = EXTRA attribuut & opdrachten LDC
  private String klasgroep ;  // iedere lesrooster kan voor een andere klas zijn
  
  private static String school = "VIVES";   // alle lessen zijn in VIVES
     //****** een static attribuut hoort bij de klasse , niet bij elk object apart
     // het woord "VIVES" zit maar 1 keer in de computer
     
  /**
   * Initialiseert een lesrooster
   */
  public Lesrooster (String kg){  ///**** EXTRA
    lijst = new ArrayList<>();
    klasgroep = kg; //*** EXTRA
  }
  
  /**
   * Voegt een <code>Les</code>-object toe aan het rooster
   * @param les de les die je toevoegt
   */
  public void voegtoe( Les les ) {
    lijst.add( les );
    // ter controle, actueel aantal elementen in de ArrayList
    System.out.println("Actueel aantal elementen = " + lijst.size());
  }

  /**
   * Levert de lessen van het lesrooster als 1 "multiline" string
   */
  public String toString() {
  	  // maak een lege StringBuffer (kan in het begin 16 karakters bevatten)
  	  // wordt automatisch verdubbeld indien vol, zie blz. 204
    StringBuffer buffer = new StringBuffer();
    
    for( Les les : lijst ) {
    	   // zoals in het boek :
      //buffer.append( les ); 	
    	   // ***** deze versie : met de extra velden erbij :
        buffer.append( "[ " + school + " ] - "+ klasgroep + " : " + les );
           // en voeg nog een line-feed bij
      buffer.append( "\n" );
    }
      // zet de StringBuffer eerst weer om in String
    String lijntjes =  buffer.toString();
      // stuur de String terug naar de oproeper
    return lijntjes;
  }
}
