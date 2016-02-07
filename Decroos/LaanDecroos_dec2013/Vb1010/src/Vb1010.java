// Voorbeeld 1010  Inwendige klasse
public class Vb1010 {
  public static void main(String[] args) {
    
    Buiten buiten = new Buiten();  // object van een uitwendige klasse maken
    // deze constructor maakt een object aan met 3 variabelen : a, x én een Intern object
    
    System.out.println( buiten.laatZien() ); // methode aanroepen via object
    //System.out.println( buiten.toString()); // methode aanroepen via object
  }  
}

// Uitwendige (aparte) klasse
class Buiten {
  private int a = 5;
  private double x = 3.2;
  private Intern internObject; // een object van de interne klasse Intern

    // Constructor
  public Buiten() {
    internObject = new Intern();  // Intern() gebruikt een "a.. d.. c.." (?)
  }

  public String laatZien() {  // mag ook toString heten, maar is verwarrend ....
    return internObject.toString() + "\n" +  // dit is vrij logisch (aanroep methode via object)
           "y = " + internObject.y + "\n" +
           	"a van intern object nog eens = " + internObject.a
           	;  // dit iets minder logisch : y is toch private ?
  }
  // Inwendige klasse (staat IN de klasse Buiten)
  private class Intern { // en is ook nog eens private ... toch heeft Buiten toegang tot alles
      // maar buiten de klasse Buiten is hier NIETS van bereikbaar
    private int a = 20;  // naam a mag 2 keer gebruikt worden, maar is wel verwarrend + probleem : zie ***
    private double y = 10.4;

    public String toString() {
      return "a_in = "     + a + "\n" + 
             "a_buiten = " + Buiten.this.a + "\n" +  // dit is het "speciaalste" ...
                              // *** want je kan hier NIET buiten.a schrijven
             "x = " + x; // zou ook mogen Buiten.this.x zijn , maar hier geen verwarring
    }
  }  // Einde inwendige klasse
  
}  // Einde buitenklasse
