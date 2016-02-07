import java.awt.*;

public class Rechthoek implements Onderdeel {
  private int links, onder, breedte, hoogte;
  private Color kleur;

  public Rechthoek( Color kleur, int links, int onder,
                    int breedte, int hoogte ) {
    this.kleur = kleur;
    this.links = links;
    this.onder = onder;
    this.breedte = breedte;
    this.hoogte = hoogte;
  }

  public void teken( Graphics g  ) { // overriding van teken() in interface
    g.setColor( kleur ) ;
    g.fillRect( links, onder-hoogte, breedte, hoogte );
    g.setColor( Color.black );
    g.drawRect( links, onder-hoogte, breedte, hoogte );

  }
}
	