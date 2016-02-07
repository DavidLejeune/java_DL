// Eerste versie van kassa
public class Kassa {
   // attribuut --> TOESTAND
   // private = DATA HIDING
  private double subtotaal;
  
  // methoden --> GEDRAG
  public void telOp( double bedrag ) {
  						//argument(en) of parameter(s)
  						// gedraagt zich als locale variabele
  						// maar is het niet
  	//double temp; // dit zou een lokale variabele zijn					
    subtotaal += bedrag;
  }
  
  public double getSubtotaal() { // een getter
    return subtotaal;
  }
  

}