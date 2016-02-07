import java.awt.*;

public class Cirkel extends AbstractOnderdeel implements Onderdeel{
  private int diameter;    //specif. attributen

  public Cirkel( Color kleur, int links, int onder, int diameter ) {
    super( kleur, links, onder );
    this.diameter = diameter;
  }

  // implementatie van abstracte methode
  public void teken( Graphics g ) { // nu wel een concrete uitwerking
    g.setColor( kleur ) ;
    g.fillOval( links, onder-diameter, diameter, diameter );
    g.setColor( Color.black );
    g.drawOval( links, onder-diameter, diameter, diameter );
  }
}
  