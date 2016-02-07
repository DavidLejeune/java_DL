import java.awt.*;

public abstract class AbstractOnderdeel implements Onderdeel {
  protected int links, onder; // de gemeenschappelijke attributen 
  protected Color kleur;      // (kan niet in een interface)
    
  protected AbstractOnderdeel() { // default constructor (kan ook niet in interface)
    kleur = Color.black;
    links = onder = 0;
  }
  								// andere constructor (idem)
  protected AbstractOnderdeel(Color kleur, int links, int onder ) {
    this.kleur = kleur;
    this.links = links;
    this.onder = onder;
  }

   // abstracte methode als "doorgeefluik" : stond al in interface, 
   // maar willen we hier nog niet implementeren, blijft dus abstract
   // waardoor de klasse ook abstract is
  public abstract void teken( Graphics g ); 
   
   // enkele concrete methoden (kon ook niet in interface)
  public Color getKleur() {
    return kleur;
  }

  public void setKleur( Color kleur ) {
    this.kleur = kleur;
  }
}
