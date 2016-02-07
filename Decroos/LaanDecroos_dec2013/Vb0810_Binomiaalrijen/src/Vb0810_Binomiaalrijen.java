/**
 * @(#)Vb0810_Binomiaalrijen.java
 *
 * Vb0810_Binomiaalrijen application
 *
 * @author Luc Decroos
 * @version 1.00 2008/3/11
 *
 * Beschrijving : Een 2D-array toepassing 
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
// eventueel extra imports hier

public class Vb0810_Binomiaalrijen extends JFrame {  
    
    public static void main(String[] argumentenRij) {
       JFrame frame = new Vb0810_Binomiaalrijen();
       frame.setSize(800,600);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setTitle("Vb0810_Binomiaalrijen");
         // naam aanpassen als je Paneel van naam wijzigt !!!
       Paneel paneel = new Paneel();
       frame.setContentPane( paneel );
       frame.setVisible(true);    	
    }
}

class Paneel extends JPanel {
        
  int n = 10 ; // aantal gewenste rijen
	
  int[][] a = new int [n] [];
	
	
   								
  
    // Constructor
  public Paneel() {
		
		
		// plaatsen reserveren                  (instanties maken)
	for ( int i = 0 ; i< a.length ; i++) {a[i] = new int [i+1];} 
   	
	a[0][0] = 1; // 1e rij
	a[1][0] = 1; a[1][1] = 1; // 2e rij
	
		// getallen berekenen
	for ( int rij = 2 ; rij < a.length ; rij++ ) 
	 for ( int kolom = 0; kolom < a[rij].length ; kolom++ ){  
	  if (kolom==0)  { a[rij][kolom] = 1;}  // als het de meest linkse positie is
	  else { if (kolom == a[rij].length-1) { // als het de meest rechtse positie is
	  		    a[rij][kolom] = 1;}
			 else {a[rij][kolom]= a[rij-1][kolom-1] + a[rij-1][kolom];}
	       }
	  }

	
  }
     
      // alle tekenwerk hier
  public void paintComponent( Graphics g ) {
      super.paintComponent( g );
      // hier komen de tekenopdrachten
       int xPos = 0,yPos = 40;
      g.drawString ("Dit zijn "+ n +" rijen met binomiaalgetallen :" , 20,40); 
	
      for ( int rij =0 ; rij < a.length ; rij++ ) {
	    xPos = 400 - (rij*20);  // iedere rij meer naar links beginnen
		for ( int kolom = 0; kolom < a[rij].length ; kolom++ ){
            g.drawString ( ""+a[rij][kolom] , xPos, yPos);
            xPos += 40;
        	}
        yPos += 30;
	  }
      
      
  }
  
 
}