// Voorbeeld 0803 Array met int

import java.util.*;

public class Vb0803 {
    
  public static void main(String[] args) {
    Leeftijdenlijst lijst = new Leeftijdenlijst();
    lijst.print();
  }
}


class Leeftijdenlijst {
  private int[] leeftijdArray; // 1. declaratie !
  
  //kan ook zo (methode 4)
  //int[] leeftijdArray = { 10,10,20,30,50 };
  
  

   // Constructor
  public Leeftijdenlijst() {
  	   // initialisatie in 2 stappen
    
    leeftijdArray = new int[ 5 ];  // 2. instantiëring
    
    leeftijdArray[ 0 ] = 10;       // 3. initialisatie
    leeftijdArray[ 1 ] = 10;
    leeftijdArray[ 2 ] = 20;
    leeftijdArray[ 3 ] = 30;
    leeftijdArray[ 4 ] = 50;
    // arraynaam [index] 
    
    // indien regelmatig, kan het veel korter :
//    for( int i = 0; i < leeftijdArray.length; i++ )	leeftijdArray[ i ] = 10*i;
//
//    leeftijdArray[ 0 ] = 10;   // eventuele uitzonderingen achteraf corrigeren
//    leeftijdArray[ 4 ] = 50;
//    
  }

  public void print() {
    System.out.println( "De leeftijden zijn:" );
    // zomaar een array afdrukken gaat niet !!!
    System.out.println( leeftijdArray ); // ook niet met "" +
                                         //ook niet met .toString()
    
                   // zet hier eens opzettelijk <=
    for( int i = 0; i < leeftijdArray.length; i++ ) // let op : niet length()
      System.out.println("index was: " + i + ", leeftijd was: " + leeftijdArray[ i ]);
      
     
     // de static methode toString() uit de klasse Arrays
     System.out.println(); 
     System.out.println ( "met toString() methode : " + Arrays.toString(leeftijdArray));
  }
}

