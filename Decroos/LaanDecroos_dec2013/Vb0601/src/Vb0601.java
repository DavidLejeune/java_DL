// Voorbeeld 0601 Console-applicatie
// voor het testen van de klasse Datum
public class Vb0601 {
  public static void main( String[] args ) {
    System.out.println( "Voorbeeld 0601  Testen van Datum" );

    Datum datum1, datum2;

    // Gebruik default-constructor
    datum1 = new Datum();
    
    // Gebruik andere constructor
    datum2 = new Datum( 3, 7, 2014 );
    
    // Hier wordt toString() automatisch aangeroepen
    System.out.println( datum1 );
    System.out.println( datum2 );
    
    // Test de setters     
    datum1.setDag( 18 );
    datum1.setMaand( 7 );
    datum1.setJaar( 1958 );
    
    System.out.println( datum1 );
  }
}


class Datum {
  private int dag;
  private int maand;
  private int jaar;

  // Constructors
  public Datum() {
    this( 1, 1, 2000 );     
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
    return String.format( "%02d-%02d-%04d",
                   getDag(), getMaand(), getJaar() );
  }
}
