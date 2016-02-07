// Voorbeeld 0801 printRechthoek & printDriehoek
public class Vb0801 {
    
  public static void main( String[] args ) {
    Stempel stempel  = new Stempel();//= a.. d.. c.. ?
    stempel.printRechthoek( 3, 7 , '*' );
    System.out.println();
    stempel.printRechthoek( 5, 10 , '@' );
    System.out.println();
    stempel.printDriehoek();
  }
}


class Stempel {
																//ook teken meegeven
  public void printRechthoek( int aantalRegels, int regellengte, char ch ) {
    // Maak eerst een regel
    StringBuffer buffer = new StringBuffer( regellengte );
    for( int i = 1; i <= regellengte; i++ )
      buffer.append( ch ); // of ook "*"
    String regel = buffer.toString();
    
    // Zet daarna de regels op het scherm
    for( int i = 1; i <= aantalRegels; i++ )
      System.out.println( regel );
  }
  
  public void printDriehoek() { // 10 regels ipv 9 zoals boek
    for( int r = 1; r <= 10; r++ ) {
      for( int k = 0; k < r; k++ ) {
        System.out.print( "*" );
      }
      System.out.println();
    }
  }
}
