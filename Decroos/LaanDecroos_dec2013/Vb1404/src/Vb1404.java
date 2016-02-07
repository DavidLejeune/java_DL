// Voorbeeld 1404  Tekstbestand maken met PrintWriter 
// (en BufferedWriter en FileWriter)
import java.io.*;

public class Vb1404 {
  public static void main( String[] args ) {
    PrintWriter uit = null;

    try {
      String bestandnaam = "c:/temp/maand.txt";
      uit = new PrintWriter( 
             new BufferedWriter(
               new FileWriter( bestandnaam ) ) );
      System.out.println( "Bestand "+ bestandnaam + " is gemaakt" );
    }
    catch( IOException e ) {
      System.out.println( "Fout bij het openen van het bestand" );
      e.printStackTrace();
    }

    if( uit != null ) {
      for( int i = 1; i <= 12; i++ ) { 
        uit.print( "maand " );
        uit.println( i );        
      }
      uit.close();
    }
    
    if( uit.checkError() )
      System.out.println( "Fout in PrintWriter" );
  }  
}
