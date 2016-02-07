// Voorbeeld 0703 Kassa2
public class Vb0703 {
  public static void main(String[] args) {
    // kassa maken
    Kassa2 kassa2 = new Kassa2();
    
    // wat bedragen intikken
    kassa2.voerIn( 3.25 );
    kassa2.voerIn( 200.20 );
    kassa2.voerIn( 51.99 );
    kassa2.voerIn( 1.55 );
    kassa2.voerIn( 22.25 );
   
	// resultaat afdrukken   
    kassa2.printKassabon();
    
    
  }
}



