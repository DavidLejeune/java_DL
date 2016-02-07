public class Bankrekening extends Rekening {



    // Constructors
  public Bankrekening( String rekeningnummer ) {
    this.rekeningnummer = rekeningnummer;
    saldo = 0;
  }
  
  public Bankrekening( String rekeningnummer,
                       double eersteInleg ) {
    this.rekeningnummer = rekeningnummer;
    saldo  = eersteInleg;
  }

  // Methoden
  public void print() {
    super.print();
    System.out.println( "-------------" );
  }
}
