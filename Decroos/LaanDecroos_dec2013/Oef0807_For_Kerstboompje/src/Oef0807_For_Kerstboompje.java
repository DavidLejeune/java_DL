/**
 * @(#)Oef0807_For_Kerstboompje.java
 *
 * Oef0807_For_Kerstboompje application
 *
 * @author 
 * @version 1.00 2012/12/3
 */
 
public class Oef0807_For_Kerstboompje {
    
  public static void main(String[] args) {
    	
	int i,j;	

	for (i = 1; i <= 15 ; i++) {			// we maken 15 lijntjes
	    for (j=1; j <= 20 - i ; j++ ) { System.out.print(" "); }  // spaties zetten
		for (j=1; j <= 2*i-1; j++)      { 
		    if  ((j==1) || (j==2*i-1))System.out.print("*");// de kruin maken
		    else {
		    	if ((int) (20* Math.random()+1)==6) System.out.print("@"); //soms een kerstbal
		        else  System.out.print("*");		     
		        }    	  
		}
	       System.out.println();    // naar volgende lijn
	}
	//onderkant boom
	for (i = 0; i<4;i++)System.out.print(" ");
	for (i = 0; i<31;i++)System.out.print("*");
	System.out.println();
	// en tot slot de "stam" eronder	
	for (j=1; j<=5; j++){  System.out.println("                  | |" );}
	
	
 }
}
    	
