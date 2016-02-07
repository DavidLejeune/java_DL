/**
 * @(#)Vb0809_Array2Dunbalanced.java
 *
 * Vb0809_Array2Dunbalanced application
 * @author Luc Decroos
 * @version 1.00 2008/3/11
 *
 * Beschrijving : Een 2D-array met ongelijke rijen
 *
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
// eventueel extra imports hier

public class Vb0809_Array2Dunbalanced extends JFrame {  
    
    public static void main(String[] argumentenRij) {
       JFrame frame = new Vb0809_Array2Dunbalanced();
       frame.setSize(800,600);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setTitle("Vb0809_Array2Dunbalanced");
         // naam aanpassen als je Paneel van naam wijzigt !!!
       Paneel paneel = new Paneel();
       frame.setContentPane( paneel );
       frame.setVisible(true);    	
    }
}

class Paneel extends JPanel {
    // declaraties van de variabelen, schrap wat je niet gebruikt !
    
      // plaats voor vier rij-referenties, maar geen plaats
      // voor elementen gereserveerd !
    int[][] a = new int [4][ ]; 
    	
    	
    	
    // Constructor
  public Paneel() {
	
	
	  // enkel initialisaties 
	  
	  a[0] = new int [7];		    // rijen met oplopende lengte,
   	  a[1] = new int [3];		    // dit mogen ook random getallen zijn !
   	  a[2] = new int [2];
   	  a[3] = new int [4];
   	  
      	// 	of gebruik deze alternatieve code :
      	//	   for ( int i = 0 ; i< a.length ; i++) {a[i] = new int [i+1] } 
   	
	  for ( int rij =0 ; rij < a.length ; rij++ ){       // opvullen ...
		for ( int kolom = 0; kolom < a[rij].length ; kolom++ ){  
		  // deze for-lus wordt per rij verschillend aantal keer doorlopen !
          a[rij][kolom]= (int) (90 * Math.random()+10);
       	}
	  }
	
  }
     
      // hier array opnieuw afdrukken op scherm
  public void paintComponent( Graphics g ) {
      super.paintComponent( g );
      // hier komen de tekenopdrachten
      
      int xPos = 40,yPos = 40;
	   g.setFont (new Font( "script",  Font.PLAIN, 24 ));
	   
	   for ( int rij =0 ; rij < a.length ; rij++ ) {
         xPos = 40;
		 for ( int kolom = 0; kolom < a[rij].length ; kolom++ ){
           g.drawString ( ""+a[rij][kolom] , xPos, yPos);
           xPos += 40;
           }
         yPos += 40;
       }      
  }
}