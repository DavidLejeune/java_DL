import java.io.*;
					// *** dit moet erbij *** 
public class Datum implements Serializable {
  public static final long serialVersionUID = 10L; // versie 1.0
  private int dag, maand, jaar;

  public Datum( int dag, int maand, int jaar ) {
    this.dag = dag;
    this.maand = maand;
    this.jaar = jaar;
  }
  
  public String toString() {
    return dag + "-" + maand + "-" + jaar;
  }
}