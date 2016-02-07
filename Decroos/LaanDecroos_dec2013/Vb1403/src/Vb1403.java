// Voorbeeld 1403  Tekstbestand maken met BufferedWriter
// (en FileWriter)
import java.io.*;

public class Vb1403 {
  public static void main( String[] args ) {
    BufferedWriter uit;

    try {  
      String bestandnaam = "c:/temp/dagen2.txt";  
      uit = new BufferedWriter( new FileWriter( bestandnaam ) );

      for( int i = 1; i <= 7; i++ ) { 
        String dag = " dag " + i;
        uit.write( dag );        
        uit.newLine();
      }
      uit.close();
      System.out.println( "Bestand "+ bestandnaam + " is geschreven" );
    }
    catch( IOException e ) {
      System.out.println(
        "Fout bij het openen, maken of sluiten bestand" );
      e.printStackTrace();
    }
  }
}
