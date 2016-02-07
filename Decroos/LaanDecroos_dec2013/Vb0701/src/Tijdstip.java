/**
 * De klasse <code>Tijdstip</code> representeert het tijdstip van een les
 * @author Gertjan Laan
 * @version 1.0
 * @see Les
 */
public class Tijdstip {
  private String dag;
  private int uur;

  /**
   * Initialiseert een Tijdstip.
   * @param dag de dag, bijvoorbeeld "maandag", "dinsdag".
   * @param uur het uur, bijvoorbeeld 1 voor 1e uur, 2 voor 2e uur, et cetera.
   */
  public Tijdstip( String dag, int uur ) {
    this.dag = dag;
    this.uur = uur;
  }
  

  /**
   * Levert de dag van dit tijdstip. Bijvoorbeeld "maandag", "dinsdag".
   * @return dag van dit tijdstip
   */
  public String getDag() {
    return dag;
  }
  
  /**
   * Levert het uur van dit tijdstip.
   * Bijvoorbeeld 1 voor 1e uur, 2 voor 2e uur, et cetera. 
   * @return uur van dit tijdstip
   */
  public int getUur() {
    return uur;
  }
  
  /**
   * Levert de gegevens van dit tijdstip als string
   * @return de gegevens van dit tijdstip als string, bijvoorbeeld:
   * <code>maandag, 3e uur</code>
   */
  public String toString() {
  	                                 // een CONDITIONELE EXPRESSIE :
  	String temp = dag + ", " + uur + (((uur==1)||(uur==8)) ? "ste uur" : "e   uur");

      // is hetzelfde als :    
//    String temp = dag + ", " + uur;
//    if ((uur==1)||(uur==8)) temp = temp + "ste uur";
//    else temp = temp + "e uur";
    
    return temp;
  }
}
