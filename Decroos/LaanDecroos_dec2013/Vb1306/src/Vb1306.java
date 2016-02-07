// Voorbeeld 1306  Twee draden met Runnable
public class Vb1306 {
  public static void main(String[] args) {
    Printdraad draad1 = new Printdraad( "1");
    Printdraad draad2 = new Printdraad( "0");
    draad1.begin();
    draad2.begin();
    //hier kan je nu nog een derde activiteit doen
  }
}

// Implementeren van Runnable
class Printdraad implements Runnable {
  private String s;
  private Thread draad;
  private boolean doorgaan;  
  
  public Printdraad( String s ) {
    this.s = s;
    draad = new Thread( this );
    doorgaan = true;
  }
  
  public void begin() {
    draad.start();
  }
  
  public void run() {
    while( doorgaan ) {
      System.out.print( s );
      slaap( 200 );
    }
  }
  
  public void slaap( int millisec ) {
    try { Thread.sleep( millisec ); }
    catch( InterruptedException e ) { }
  }
}