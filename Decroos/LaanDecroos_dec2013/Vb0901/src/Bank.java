import java.util.*;
   // de cliënt klasse
public class Bank {
  private ArrayList<Rekening> lijst;
  
  public Bank() {
    lijst = new ArrayList<>();
  }
    
  public void voegRekeningToe( Rekening r ) {
    lijst.add( r );
  }

  public void printOverzicht() { 
  	double som = 0;// extra, niet in boek
    for( Rekening r : lijst  ) {
      r.print(); // zoekt autom de juiste print via dyn binding
      som += r.getSaldo(); // niet in boek : totaal maken
    }
    System.out.println( "Totaal kapitaal in de bank =  " + som);
  }
}
