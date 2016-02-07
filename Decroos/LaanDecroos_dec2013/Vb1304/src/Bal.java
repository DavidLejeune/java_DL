import java.awt.*;

public class Bal {
  private int x, y, grootte;
  private Color kleur;
  private int dx;    // De verplaatsing in de x-richting
  
  public Bal( int x, int y, int grootte, Color kleur ) {
    this.x = x;
    this.y = y;
    this.grootte = grootte;
    this.kleur = kleur;
    dx = 4;
  }

  public void stuiter( Graphics g ) {
    teken( g );
    verplaats();
  }

  public void teken( Graphics g ) {
    g.setColor( kleur );
    g.fillOval( x, y, grootte, grootte );
  }

  private void verplaats() {  // verplaatsing volgens parabool
    if( x + dx > 100 || x + dx < -100 ) {
      dx = -dx;
    }
    x += dx;
    y = (int) (x-100) * (x+100) / 50;
  }
}
	