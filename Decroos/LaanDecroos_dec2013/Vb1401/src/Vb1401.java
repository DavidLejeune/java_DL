// Voorbeeld 1401 Invoer van getallen in console-applicatie
import java.io.*;

public class Vb1401 {
  public static void main( String[] args ) {
    BufferedReader toetsenbord =
      new BufferedReader( new InputStreamReader( System.in) );    
    int i = 0;
    double d = 0.0;
    int teller = 0;
    boolean gelukt = true;
    do{
    gelukt = true;
    System.out.println( "Typ een geheel getal:" );

    try {
      	
      // Lees een regel van het toetsenbord
      String s = toetsenbord.readLine();
      i = Integer.parseInt( s );
      System.out.println( "Typ een gebroken getal:" );

      // Lees nog een regel van het toetsenbord
      s = toetsenbord.readLine();
      d = Double.parseDouble( s );
      System.out.println( "Je tikte " + i + " en " + d );
      gelukt = true;      
    }
    // meest specifieke fout
    catch( IOException ioe ) {
      System.out.println( "Fout bij inlezen, ik sluit af");
      
    }
    catch( NumberFormatException nfe ) {
      System.out.println( "Fout bij omzetten van invoer naar getal, probeer opnieuw");
      teller++;
      if (teller <= 3) gelukt = false;
    }
    //algemeenste fout
    catch ( Exception fout){
      System.out.println( "Nu heb je wel een heel rare fout gemaakt hoor, opnieuw");
      teller++;
      if (teller <= 3) gelukt = false;	
    }
    
    } while (!gelukt);
    
    if (teller==3) System.out.println(teller + "Kansen verkeken !");
  }
}
