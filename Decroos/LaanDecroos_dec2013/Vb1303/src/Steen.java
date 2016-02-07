import java.awt.*;

public class Steen {
  private Color kleur;
  private int x;
  private int y;
  private int breedte;
  private int hoogte;

  public Steen( Color kleur, int x, int y, int breedte, int hoogte ) {
    this.kleur = kleur;
    this.x = x;
    this.y = y;
    this.breedte = breedte;
    this.hoogte = hoogte;
  }

  public void naarBeneden() {
    y++;
  }
  
  public int getY() {
    return y;
  }
  
  public int getHoogte() {
    return hoogte;
  }

  public void teken( Graphics g ) {
    g.setColor( this.kleur );
    g.fillRect( this.x, this.y, this.breedte, this.hoogte );
  }
}
	