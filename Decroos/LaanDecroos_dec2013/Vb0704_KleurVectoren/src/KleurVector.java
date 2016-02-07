/**
 * @(#)KleurVector.java
 *
 *
 * @author Luc Decroos - KHBO
 * @version 1.00 2007/12/11
 */

import java.awt.*;

public class KleurVector{
	 // attributen
	private int x,y; 
	private int richting, grootte;
	private Color kleur;
	
	 // methoden	
	public KleurVector(int x, int y, int richting, int grootte, Color kleur) {
		this.x = x;
		this.y = y;
		this.richting = richting;
		this.grootte = grootte;
		this.kleur = kleur;
	}
      // getters en setters als je ze nodig hebt ... 
      // (niet gebruikt in dit voorbeeld)
	public void setX(int x) {
		this.x = x; 
	}

	public void setY(int y) {
		this.y = y; 
	}

	public void setRichting(int richting) {
		this.richting = richting; 
	}

	public void setGrootte(int grootte) {
		this.grootte = grootte; 
	}
	
	public void setKleur( Color kleur ) {
		this.kleur = kleur; 
	}

	public int getX() {
		return (this.x); 
	}

	public int getY() {
		return (this.y); 
	}

	public int getRichting() {
		return (this.richting); 
	}

	public int getGrootte() {
		return (this.grootte); 
	}
	
	public Color getKleur(){
		return (this.kleur);
	}

       // teken een vector : let op argument pen !
	public void tekenVector (Graphics pen){
		 
		double rad = richting * Math.PI / 180.0;
		int x2 = x + (int) Math.round (grootte * Math.cos(rad));
		int y2 = y - (int) Math.round (grootte * Math.sin(rad));
		pen.setColor (kleur);
	    pen.fillOval ( x-2,y-2, 5,5);
	    pen.drawLine( x,y,x2,y2);
	}
	
}