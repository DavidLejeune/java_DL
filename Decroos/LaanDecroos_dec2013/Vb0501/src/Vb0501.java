// Voorbeeld 0501
// Testen van boolean uitdrukkingen

public class Vb0501 { //NIEUW : Console-applicatie? dus geen extends JFrame
  
  public static void main( String[] args ) {
    // iets afdrukken in Console venster  ( command line, DOS-box, ...)
    // let op verschil tussen print en println
    System.out.println( "Dit is voorbeeld 0501" );
    
    int jaartal = 2013;
    
    System.out.print( jaartal + " > 2000? " ); // test 1
    System.out.println(   jaartal > 2000 );
    
    System.out.println(); // extra : blanco lijn ertussen
    
    System.out.print( jaartal + " tussen 2000 en 2010? " ); //test 2
    System.out.println( jaartal >= 2000 && jaartal <= 2010 );
    System.out.println(); 
    	 
     // extra
     int cijfer  = 8;
     // iets testen en in een boolean variabele opslaan:
     //  de  variabele   de 'relationele expressie' 
     boolean voldoende = cijfer >= 5;
     System.out.println("Was cijfer voldoende ? " + voldoende );
  }
}
