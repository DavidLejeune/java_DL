// Voorbeeld 0600
// Klasse datum zonder methode toString() + testprogramma in consolevenster

public class Vb0600 {
  public static void main( String[] args ) {
  	
    System.out.println( "Voorbeeld 0600: klasse Datum zonder toString()" );

    Datum datum;  	     // declareer een referentie (pointer)    
    
    datum = new Datum(); // maak het object (instantie)
    datum.setDag(5);     // vul de attributen in (initialisatie)
   	datum.setMaand(11);
	datum.setJaar(2013);

			//mits er een geschikte Constructor is kan dit veel korter :
    		//datum = new Datum( 5, 11, 2013 );
    
    // Hier wordt automatisch toString() aangeroepen (van klasse Object)
    System.out.println( datum );
    // dit levert helaas niet de gewenste output :-(
    
    // dit wel, maar dit staat beter in een to String() methode , zie Vb0601
    // System.out.println( datum.getDag() +"/" + datum.getMaand()+"/"+ datum.getJaar());
    
  }
}


class Datum {
	// attributen
  private int dag;
  private int maand;
  private int jaar;

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
    if (maand >= 1 && maand <= 12) this.maand = maand; 
  }

  public void setJaar( int jaar ) {
    this.jaar = jaar;
  }

}
