/**
 * De klasse <code>Les</code> representeert een les.
 * Instanties van <code>Les</code> kan je aan een 
 * <code>Lesrooster</code> toevoegen
 * @author Gertjan Laan
 * @version 1.1
 * @see Lesrooster
 * @see Tijdstip
 */
public class Les {
  private String vak;
  private Tijdstip tijdstip;
  private String lokaal;
  
  /**
   * Initialiseert een Les
   * @param vak het vak waarin wordt lesgegeven
   * @param tijdstip het tijdstip van de les
   * @param lokaal het lokaal waarin de les plaatsvindt
   */
  public Les( String vak, Tijdstip tijdstip, String lokaal ) {
    this.vak = vak;
    this.tijdstip = tijdstip;
    this.lokaal = lokaal;
  }
  
  /**
   * Levert het vak van deze les
   * @return het vak van deze les
   */
  public String getVak() {
    return vak;
  }
  
  /**
   * Levert het tijdstip van deze les
   * @return het tijdstip van deze les
   */
  public Tijdstip getTijdstip() {
    return tijdstip;
  }

  /**
   * Levert het lokaal van deze les
   * @return het lokaal van deze les
   */
  public String getLokaal() {
    return lokaal;
  }
  
  /**
   * Levert de gegevens van deze les als string
   * @return de gegevens van deze les als een geformatteerde string
   */
  public String toString() {
    return String.format( "%-13s %s in %s", vak, tijdstip, lokaal );
  }
}
