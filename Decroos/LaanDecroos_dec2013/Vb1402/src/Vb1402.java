// Voorbeeld 1402 Tekstbestand maken met FileWriter
import java.io.*;

public class Vb1402 {
  public static void main( String[] args ) {
    FileWriter uit;
    try {  
      uit = new FileWriter( "c:/temp/dagen.txt" );
      System.out.println( "Bestand wordt nu gemaakt..."  );
      for( int i=1; i<=7; i++ ) { 
        String dag = " dag " + i ;
        uit.write( dag );    // geen line feeds !    
      }
      uit.close();
      System.out.println( "Bestand is gesloten" );
    }
    catch( IOException e ) {
      System.out.println(
        "Fout bij het openen, maken of sluiten bestand" );
      e.printStackTrace();
    }
  }
}
