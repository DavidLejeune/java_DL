/**
 * @(#)Robot.java
 *
 *
 * @David Lejeune
 * @version 1.00 2014/12/11
 */


import java.awt.*;


public class Robot {
	
	
	
    	 // attributen
	private int x,y; 
	private Color kleur;
	private int breedte, hoogte;
	

    public Robot(int x, int y, int breedte, int hoogte, Color kleur ) {
  
    
		this.x = x;
		this.y = y;
		this.breedte = breedte;
		this.hoogte = hoogte;
		this.kleur = kleur;



    }
    
    
    	public void NaarLinks() {
		if (x > 5)
		{
		x = x - 5; 
		}
	}	
		
		 public void NaarRechts() {
		if (x < 780)
		{
		x = x + 5; 
		}
	}	
		
		
    	public void NaarBoven() {
		if (y > 5)
		{
		y = y - 5; 
		}
	}	
		
		 public void NaarBeneden() {
		if (y < 680)
		{
		y = y + 5; 
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

	public void setHoogte(int hoogte) {
		this.hoogte = hoogte; 
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

	public int getHoogte() {
		return (this.hoogte); 
	}
	
	public Color getKleur(){
		return (this.kleur);
	}
	
	
	       // teken een vector : let op argument pen !
	public void tekenRobot (Graphics pen){
		 
		pen.setColor (kleur);
	    pen.fillOval ( x,y,breedte, hoogte ) ;
	    
	    
		pen.setColor (new Color ((int) ( 16777216 * Math.random())));
	    pen.fillRect ( x + (breedte / 3) ,y + (hoogte / 4) ,breedte / 10 , hoogte / 10 ) ;
		pen.setColor (new Color ((int) ( 16777216 * Math.random())));
	    pen.fillRect ( x + 2 * (breedte / 3) ,y + (hoogte / 4) ,breedte / 10 , hoogte / 10 ) ;
		pen.setColor (new Color ((int) ( 16777216 * Math.random())));
	    pen.drawArc(x + (breedte / 3) - (breedte / 20) , y + 2 * (hoogte / 4) - (hoogte / 10)  , breedte / 2 , hoogte / 2 , 180 , 180 );
		pen.setColor (new Color ((int) ( 16777216 * Math.random())));	  
	    pen.drawArc(x + (breedte / 3) - (breedte / 20), y + 2 * (hoogte / 4) - (hoogte / 10) - 1  , breedte / 2 , hoogte / 2 , 180 , 180 );	  


	    
	}
    
}