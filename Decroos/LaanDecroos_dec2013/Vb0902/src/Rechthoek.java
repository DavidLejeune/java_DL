public class Rechthoek {
  protected int breedte;
  protected int hoogte;

  //oplossing 1
  public Rechthoek (){ // bijgevoegde DEFAULT CONSTRUCTOR
  	this(1,1);
  }
  
    // klasse heeft een "two-argument" constructor
  public Rechthoek( int hoogte, int breedte ) {
    this.hoogte = hoogte;
    this.breedte = breedte;
  }

  public void print() { // rechthoek in console, zoals in H8
    // Maak eerst een regel
    String regel = "";
    for( int i = 1; i <= breedte; i++ )
      regel += "x ";

    // Zet daarna de regels op het scherm
    for( int i = 1; i <= hoogte; i++ )
      System.out.println( regel );
  }
}
