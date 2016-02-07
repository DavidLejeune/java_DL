import java.awt.*;
import java.util.*;

public class Auto {
  private ArrayList<Onderdeel> onderdelenlijst;
  
  public Auto( int links, int onder, int breedte, int hoogte ) {
    onderdelenlijst = new ArrayList<>();
    int wielgrootte = hoogte/2;
    int carosOnder = onder - wielgrootte/2;

    // De carosserie
    onderdelenlijst.add(
      new Rechthoek( Color.BLUE, links, carosOnder, breedte, hoogte ) );

    // De cabine
    onderdelenlijst.add(
      new Rechthoek( Color.CYAN, links, carosOnder-hoogte,
                     4*breedte/5, 4*hoogte/5 ) );

    // Het achterwiel
    onderdelenlijst.add(
      new Cirkel( Color.YELLOW, links+5, onder, wielgrootte ) );

    // Het voorwiel
    onderdelenlijst.add(
      new Cirkel( Color.YELLOW, links+breedte-30, onder, wielgrootte ) );
  }

  public void teken( Graphics g ) {
    for( Onderdeel part : onderdelenlijst )
      part.teken( g );                    // polymorfie
  }
}
	