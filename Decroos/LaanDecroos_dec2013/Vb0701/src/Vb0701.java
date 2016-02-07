// Voorbeeld 0701 Lesrooster
/**
 * Opstartklasse voor testen van <code>Lesrooster</code>, <code>Les</code> en <code>Tijdstip</code>
 * @author Gertjan Laan
 * @version 1.0
 * @see Lesrooster
 * @see Les
 * @see Tijdstip
 */
  
public class Vb0701 {
  public static void main( String[] args ) {
    
    System.out.println( "Voorbeeld 0701  Testen van Lesrooster" );

    Lesrooster rooster = new Lesrooster();
    
    // een Les object maken ... zo kan het niet !
    // Les les = new Les( "Wiskunde", "dinsdag", 1 , "A01" );
    
    // maar wel door in de constructor een "naamloos" Tijdstip mee te geven
    Les les = new Les( "Wiskunde", new Tijdstip( "dinsdag", 1 ), "A01" );
    
    rooster.voegtoe( les ); //LET OP: rooster.add(..) kan NIET !
    
    les = new Les( "Informatica 1", new Tijdstip( "dinsdag", 5 ), "B401" );
    rooster.voegtoe( les );
    
    les = new Les( "Informatica 1", new Tijdstip( "dinsdag", 6 ), "B401" );
    rooster.voegtoe( les );
    
    // het kan nog korter :
    rooster.voegtoe( new Les( "Elektronica 1", new Tijdstip( "dinsdag", 8 ), "B401" ) );

    rooster.print();
  }
}
