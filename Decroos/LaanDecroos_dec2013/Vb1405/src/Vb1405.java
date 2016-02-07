// Voorbeeld 1405  Tekstbestand lezen met 
// BufferedReader en FileReader
import java.io.*;

public class Vb1405 {
  public static void main( String[] args ) {
    BufferedReader in;
    String regel;
    int aantal = 0;
    try {  
      in = new BufferedReader( new FileReader( "c:/temp/dagen2.txt" ) );
      // SUPERBELANGRIJK !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
      while ( ( regel = in.readLine() ) != null ) {
        System.out.println( regel );
        aantal++;
      }
      in.close();
      
      System.out.println(" er zijn  " + aantal + " regels gelezen !");
    }
    catch( FileNotFoundException e ) {
      System.out.println( "Kan bestand niet vinden" );
      e.printStackTrace();
    }
    catch( IOException e ) {
      System.out.println( "Fout bij het lezen of sluiten bestand" );
      e.printStackTrace();
    }
  }
}
