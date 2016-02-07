public class FlexRechthoek extends Rechthoek {
  
  // basisversie heeft slechts deze twee methoden :
  public void breder() {
    breedte++;
  }

  public void hoger() {
    hoogte++;
  }
  
  
  // oplossing 2
  public FlexRechthoek (int hoogte, int breedte ) {
  	// werk doorgeven naar superklasse-constructor met zelfde signatuur
  	// super() moet eerst komen
  	super (hoogte , breedte); 
   // dan evt andere opdrachten (hier zijn er geen)
  		
  }
  
  // maar hier bvb. wél :
  private String symbool = "x";

  public FlexRechthoek (int hoogte, int breedte, String symbool ) {
  	// werk doorgeven naar superklasse-constructor met zelfde signatuur 
  	// dit moet de EERSTE opdracht zijn
  	super (hoogte , breedte); 
  	// dan de 'extra' opdrachten
  	this.symbool = symbool;
  		
  }

  // OVERRIDING van methode print() uit superklasse
  public void print() {
    // Maak eerst een regel
    String regel = "";
    for( int i = 1; i <= breedte; i++ )
      regel = regel + symbool + " ";

    // Zet daarna de regels op het scherm
    for( int i = 1; i <= hoogte; i++ )
      System.out.println( regel );
  }
  
  
}
