/**
 * @(#)Vb0800_Algoritmen_Allerlei.java
 *
 * Vb0800_Algoritmen_Allerlei application

 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
// eventueel extra imports hier

public class Vb0800_Algoritmen_Allerlei extends JFrame {  
    
    public static void main(String[] argumentenRij) {
       JFrame frame = new Vb0800_Algoritmen_Allerlei();
       frame.setSize(275,700);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setTitle("Vb0800_Algoritmen_Allerlei");
         // naam aanpassen als je Paneel van naam wijzigt !!!
       Paneel paneel = new Paneel();
       frame.setContentPane( paneel );
       frame.setAlwaysOnTop(true);
       frame.setVisible(true);    	
    }
}

class Paneel extends JPanel {
  
  public Paneel() {

  }
      
  public void paintComponent( Graphics g ) {
      super.paintComponent( g );
      
      // allerlei uit begin hoofdstuk 8
      
      // p 199 : som
      int som = 0; // niet vergeten !!
      for (int getal  = 1; getal<=50; getal++){
      	  som += getal;
      }
      g.drawString ( "Het  totaal is gelijk aan :"  + som , 10, 150);
      
      
      //p 200 : faculteit
      int faculteit = 1; // niet nul !
      int laatste = 10;
      for (int i = 2; i<= laatste; i++){
      	faculteit *= i;
      }  
      g.drawString ( "Faculteit van 10 is : "  + faculteit , 10, 200);
      
      
      // p 200 random
      double t1, t2;
      t1 = Math.random (); // levert 0.000 .. 0.999
      t2 = Math.random ();
      g.drawString ( "t1 = "  + t1 , 10, 250);
      g.drawString ( "t2 = "  + t2 , 10, 300);
      
      
      // p 201 dobbelsteen korte methode, formule op p 202 !
      int worp = (int) ( 6 * Math.random() + 1);
      g.drawString ( "dobbelsteen worp = "  + worp , 10, 350);
      
      // p 203 char en typecasting
      char ch = 'A';
      int code = (int) ch;  // is hier optie
      code++;  // of test eens code += 32; // HOOFDLETTER > kleine letter
      ch = (char) code; // eig enkel hier typecasting vereist
      ch++; // je kan de char variabele ook direct verhogen  
      g.drawString ( "eindwaarde char =  "  + ch , 10, 400);
      int posX = 10;
      	// of er zelfs een for lus mee schrijven
      for ( ch = 'A'; ch <= 'Z'; ch++){
      	g.drawString ( "*"  + ch ,posX , 425);
      	 posX += 12;
      }
      
      // p 229 grootste zoeken
      double[] winstArray = { 22.3 , -6.27, 31.44, 123.2, 17.84, 119.6 };
      
      double max = winstArray[0]; // neem eerste element
      // overloop de andere (vanaf index 1)
      for (int i = 1 ; i < winstArray.length; i++){
      	if (winstArray[i] > max) max = winstArray[i];
      }
	  g.drawString("Grootste winst is : "  + max, 10, 450);      
	  	
	  //en zoek de tweede grootste ? 
	  
	  // deze manier lukt niet, waarom ?
	  max = winstArray[0]; // neem eerste element
      double oldmax = max;
      // overloop de andere (vanaf index 1)
      for (int i = 1 ; i < winstArray.length; i++){
      	if (winstArray[i] > max){
      		oldmax = max; //schuif deze waarde door
      		max = winstArray[i]; // onthoud nieuw grootste
        }
      }
	  g.drawString("Tweede grootste winst is : "  + oldmax, 10, 500);    
	  	
	  // dan maar zo ... maar op voorwaarde dat je de array MAG wijzigen !
	  int len = winstArray.length;
	  
	  // of maak anders eerst een kopie :
	  double[] wAcopy = new double[len];
	  System.arraycopy (winstArray, 0, wAcopy, 0, len);
	  //array sorteren
	  Arrays.sort(wAcopy);
	  g.drawString("grootste = "  + wAcopy [len-1] + " , tweede grootste : " 
	  	                                            + wAcopy[len-2], 10, 540);   		  
      	  
      // of nog anders, maar ook met wijzigen van de array :
      // zoek grootste en vervang het door iets heel kleins en zoek dan weer het grootste
	  double[] wAcopy2 = new double[len];
	  System.arraycopy (winstArray, 0, wAcopy2, 0, len);
	  int index = 0;
	  max = wAcopy2[0]; // neem eerste element
      // overloop de andere (vanaf index 1)
      for (int i = 1 ; i < len ; i++){
      	 if (wAcopy2[i] > max){
      	 	max = wAcopy2[i];
      	 	index = i;
      	 }
      }
      // overschrijf grootste
      wAcopy2[index] = -999999;
      // en nu opnieuw grootste zoeken
      
      max = wAcopy2[0]; // neem eerste element
      // overloop de andere (vanaf index 1)
      for (int i = 1 ; i < len ; i++){
      	 if (wAcopy2[i] > max){
      	 	max = wAcopy2[i];
      	 	index = i;
      	 }
      }
      // nu is max het tweede grootste element
      g.drawString("tweede grootste (derde methode) = "  
      	 + max , 10, 570); 
      
      
      
      // zoek methode toepassen (zie hieronder)
      g.drawString( "Positie van getal 31.44 = " + zoek ( winstArray, 31.44), 10 , 600);
      g.drawString( "Positie van getal 21.44 = " + zoek ( winstArray, 21.44), 10 , 620);
  }
  
  public static int zoek ( double[] rij , double getal){

//  	for (int i = 0; i < rij.length; i++){
//  		if (rij[i] == getal) return i;
//  	}
//  	return -1;
//  	
  	
  	// eerste verbetering :
//  	int index = -1;
//  	for (int i = 0; i < rij.length; i++){
//  		if (rij[i] == getal) index = i;
//  	}
//  	return index ; // één uitgang !
  	 
  	 
  	 // of nog beter :
  	int index = -1; 
  	boolean gevonden = false;
  	int i = 0;
  	while ( i < rij.length && !gevonden ){
  	    if (rij[i] == getal) {
  			gevonden = true;
  			index = i;
  		}
  		i++;
  	}
  	// hier kan je nog iets doen met die boolean ... bvb
  	if (gevonden) System.out.println ("Getal gevonden in zoekmethode");
  	else System.out.println ("Getal niet gevonden in zoekmethode");
  	
  	// en tot slot :
  	return index ; // één uitgang !
  	  	
  }
  
  
}