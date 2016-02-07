public class Rekening {
  protected String rekeningnummer;
  protected double saldo;

  public double getSaldo() {
    return saldo;
  }

  public void stort( double bedrag ) {
    saldo += bedrag;
  }

  public void neemOp( double bedrag ) {
    saldo -= bedrag;
  }

  public void print() {
    System.out.println( "Nummer: " + rekeningnummer );
    System.out.printf( "Saldo: %.2f%n", saldo );
  }
}
