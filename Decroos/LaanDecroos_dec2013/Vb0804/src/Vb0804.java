// Voorbeeld 0804 Array als argument van een methode
import java.util.*;

public class Vb0804 {
    
  public static void main(String[] args) {
    int[] lijst = { 1, 1, 2, 3, 5, 8, 13, 21 , 33, 39 };
    System.out.println( "De getallen zijn" );
    print( lijst ); //referentie naar array als argument
  }

   // omdat oproep vanuit een "static context" gebeurt (main methode is ook static)
  public static void print( int[] rij ) {
    for( int getal : rij ) // met de for-each lus
      System.out.println( getal );
    System.out.println();
    	
    // met de klassieke for-lus :	
//    for (int teller = 0; teller < rij.length; teller++ )  
//    	System.out.println( rij[teller]);

//of ook nog :
// System.out.println( Arrays.toString(rij));

  }
}

