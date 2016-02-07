// Voorbeeld 0901
// Bank, Overerving: Rekening, Bankrekening, Spaarrekening
public class Vb0901 {
   
  public static void main(String[] args) {
    Bank javaBank = new Bank();
    
    Spaarrekening rekening1 = new Spaarrekening( "123", 1.0 );
    javaBank.voegRekeningToe( rekening1 );

    Bankrekening rekening2 = new Bankrekening( "123", 500 );
    javaBank.voegRekeningToe( rekening2 );

    Bankrekening rekening3 = new Bankrekening( "789", 700 );
    javaBank.voegRekeningToe( rekening3 );
    
    rekening1.stort( 100 );
    rekening1.schrijfRenteBij();
    rekening2.neemOp( 45 );
	rekening3.stort(50);
	
    javaBank.printOverzicht();
  }
}
