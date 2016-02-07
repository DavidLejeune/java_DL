// Voorbeeld 0802 Tabel met uitkomsten van tafels 1 tot en met 5
public class Vb0802 {
    
  public static void main(String[] args) {
    Tabel tabel = new Tabel();
    tabel.print(); // op eerste manier , met aparte printRij() methode
    System.out.println();
    tabel.printTabel(); // op tweede manier , alles in 1 methode met geneste for-lus
  }
}


class Tabel {
  
  // deze mag private zijn (of is best private), is enkel voor "intern" gebruik in klasse
  private void printRij( int rijnr ) {
    for( int kol = 1; kol <= 10; kol++ ) {
      System.out.print( String.format( "%3d", rijnr * kol ) );
    }
  }
  
  public void print() {
    for( int r = 1; r <= 5; r++ ) {
      printRij( r );
      System.out.println();
    }
  }
  
  public void printTabel() {
    for( int rij = 1; rij <= 5; rij++ ) {
      for( int kol = 1; kol <= 10; kol++ ) {
        System.out.print( String.format( "%3d", rij * kol ) );
      }
      System.out.println();
    }
  }
}

