/**
 * @(#)Cirkel.java
 *
 *
 * @author 
 * @version 1.00 2014/12/11
 */




import java.awt.*;

public class Cirkel {
    	 // attributen
	private int x,y; 
	private int breedte, grootte;
	private Color kleur;
	
	
    public Cirkel(int x, int y, int breedte, int grootte, Color kleur) {
  
    
		this.x = x;
		this.y = y;
		this.breedte = breedte;
		this.grootte = grootte;
		this.kleur = kleur;
	}
	
	public void maakGroter() {
		if (grootte < 780)
		{
		grootte = grootte + 5; 
		}
	}	
	
	public void maakBreder() {
		if (breedte < 580)
		{
			breedte = breedte + 5; 
		}
	}	
		
	public void maakMinderGroot() {
		if (grootte > 20)
		{
		grootte = grootte - 5; 
		}
	}	
	
	public void maakMinderBreed() {
			if (breedte > 10)
		{
			breedte = breedte - 5; 
		}
	}		
	
      // getters en setters als je ze nodig hebt ... 
      // (niet gebruikt in dit voorbeeld)
	public void setX(int x) {
		this.x = x; 
	}

	public void setY(int y) {
		this.y = y; 
	}

	public void setBreedte(int breedte) {
		this.breedte = breedte; 
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

	public int getBreedte() {
		return (this.breedte); 
	}

	public int getGrootte() {
		return (this.grootte); 
	}
	
	public Color getKleur(){
		return (this.kleur);
	}

       // teken een vector : let op argument pen !
	public void tekenCirkel (Graphics pen){
		 
		pen.setColor (kleur);
	    pen.fillOval ( x,y,breedte, grootte ) ;
	}
    
    
}