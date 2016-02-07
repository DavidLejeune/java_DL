import java.util.*;

public class Kassa2 {
  private ArrayList<Double> lijst;

  public Kassa2() {
    lijst = new ArrayList<>(); 
  }

  public void voerIn( double bedrag ) {
    lijst.add( bedrag ); //auto-boxing
    		// new Double( bedrag)
  }
  
  private double berekenTotaal() {
    double totaal = 0;
    for( Double dObject : lijst ) {
      totaal += dObject; // auto-unboxing
      		   // dObject.doubleValue()
    }
    return totaal;
  }

  public void printKassabon() {  // zou ook weer beter een toString() zijn ...
    for( Double dObject : lijst ){
       //System.out.printf( "%8.2f%n", d );   // auto-unboxing
      System.out.println( String.format("%8.2f", dObject ));
      										  // dObject.doubleValue()
    }
    
    System.out.println( "  ______" );
    System.out.println( String.format("%8.2f", berekenTotaal()));
    
    if ( lijst.size()>= 3)
    	System.out.println( 
    		"Extra bonus voor 3 of meer artikelen, \nU krijgt een gratis blik Cola");
  }
}
