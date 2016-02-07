public class Spaarrekening extends Rekening {
  // Attributen
  private double percentage;
  
  // Constructor
  public Spaarrekening( String rekeningnummer, double percentage ) {
    this.rekeningnummer = rekeningnummer;
    this.percentage = percentage;
    saldo = 0;
  }
  
  // Methoden
  public void print() {
    super.print();
    System.out.println( "Rente: " + percentage + "%" );
    System.out.println( "-------------" );
  }

  public void schrijfRenteBij() {
    double rente = saldo * percentage / 100;
    saldo += rente;
  }
}
