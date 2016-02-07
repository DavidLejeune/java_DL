/**
 * @(#)Vb0808_Array2D.java
 *
 * Vb0808_Array2D application
 *                  
 * @author Luc Decroos
 * @version 1.00 2008/3/11
 *
 * Beschrijving : Een 2D-array in Java
 *
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Vb0808_Array2D extends JFrame {  
    
    public static void main(String[] argumentenRij) {
       JFrame frame = new Vb0808_Array2D();
       frame.setSize(800,600);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setTitle("Vb0808_Array2D");
         // naam aanpassen als je Paneel van naam wijzigt !!!
       Paneel paneel = new Paneel();
       frame.setContentPane( paneel );
       frame.setVisible(true);    	
    }
}

class Paneel extends JPanel {
    // declaraties van de variabelen
    
  int size = 10;
            // declaratie + instantiëring van een 2D array
  int[][] a = new int [size][size];	// een vierkante matrix
	
  
    // Constructor
  public Paneel() {
	// geen components nodig, enkel afdruk via paintComponent()
	
	//wel array initialiseren : vullen met random getallen
	for ( int rij =0 ; rij < a.length ; rij++ )   
		for ( int kolom = 0; kolom < a[0].length ; kolom++ ){  // of a[rij].length
            a[rij][kolom]= (int) (90 * Math.random()+10);
        	}
  }
     
      // alle tekenwerk hier
  public void paintComponent( Graphics g ) {
      super.paintComponent( g );
      // hier komen de tekenopdrachten
      int xPos = 40,yPos = 40;
	   g.setFont (new Font( "script",  Font.PLAIN, 24 ));
	   for ( int rij =0 ; rij < a.length ; rij++ ) {
	     xPos=40;
	     for ( int kolom = 0; kolom < a[0].length ; kolom++ ){
            g.drawString ( ""+a[rij][kolom] , xPos, yPos);
            xPos += 40;
        	}
        yPos += 40;
	   }
  }
}