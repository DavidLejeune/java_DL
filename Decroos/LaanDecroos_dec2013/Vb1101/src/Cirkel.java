import java.awt.*;

public class Cirkel implements Onderdeel {
  private int links, onder, diameter; // DIAMETER IS EIG STRAAL 
  private Color kleur;

  public Cirkel( Color kleur, int links, 
               int onder, int diameter ) {
    this.kleur = kleur;
    this.links = links;
    this.onder = onder;
    this.diameter = diameter;
  }

  public void teken( Graphics g ) { // overriding van teken() in interface
    g.setColor( kleur ) ;
    g.fillOval( links, onder-diameter, diameter, diameter );
    g.setColor( Color.black );
    g.drawOval( links, onder-diameter, diameter, diameter );
  }
}
	