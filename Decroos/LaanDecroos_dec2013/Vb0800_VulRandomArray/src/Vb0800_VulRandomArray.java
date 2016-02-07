/**
 * @(#)Vb0800_VulRandomArray.java
 *
 * Vb0800_VulRandomArray application
 *
 * @author Luc Decroos - KHBO - 2008
 * @version 1.00 2008/3/6
 *
 * Vul een array van 10 int's met getallen 0 tot 9,
 * elk getal juist 1 keer in array (geen dubbels)
 *
 * Demo van 4 verschillende methoden
 *
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Vb0800_VulRandomArray extends JFrame {  
    
    public static void main(String[] argumentenRij) {
       JFrame frame = new Vb0800_VulRandomArray();
       frame.setSize(800,800);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setTitle("Vb0800_VulRandomArray");
         // naam aanpassen als je Paneel van naam wijzigt !!!
       Paneel paneel = new Paneel();
       frame.setContentPane( paneel );
       frame.setVisible(true);    	
    }
}

class Paneel extends JPanel {
    // referenties naar objecten 
  private JLabel label;
  private JButton knop;
    
  private int [] rij; // declaratie
  private int [] hulprij; // enkel gebruikt in mode = 2
    
    // primitieve variabelen
  private int mode, getal, i, j, k;
  private int pos, yPos, teller;
  
    // Constructor
  public Paneel() {
	  // label aanmaken
	label = new JLabel (" Demo : array random vullen zonder dubbels ");	  
	  // knop aanmaken en koppelen met event-handler
    knop = new JButton( " VUL " );
    knop.addActionListener( new KnopHandler() );
      // alle elementen toevoegen aan paneel-object
    add( label);
    add( knop );
      // array's instantiëren
    rij     = new int[10]; 
    hulprij = new int[10];
  }

      // alle tekenwerk hier
  public void paintComponent( Graphics g ) {
      super.paintComponent( g );
    
      yPos = 50;
      g.drawString("Methode = " + mode, 10, 20);
      
      switch(mode){
      	case 0 : g.drawString("Klik voor de eerste methode :", 10,200); 
      		break;
      	case 1 :  
      		// wellicht het meest efficiënte systeem :
      		// getallen 0 tot 9 in volgorde, telkens vrije "random" plaats zoeken :
      		
      		// vul de doel-array met 99's ("vrij-markers")
      		for ( i =0; i<rij.length ; i++) rij[i] = 99;
      		
      		// neem opeenvolgend de getallen 0 tot 9 
      		for (i = 0 ; i < rij.length ; i++){
      			
      			// zoek een random plaats die vrij is (= die 99 bevat)
      			do{
      				pos = (int) (10*Math.random()); // pos = 0 - 9
      				System.out.print("!"); // een primitieve "progress bar"
      			}while( rij[pos] != 99 );  // géén 99 = die plaats is al bezet
      			
      			// vrije plaats gevonden ? --> vervang door actuele teller
      			rij[pos] = i;
      			System.out.println(); // afsluiten progress bar
      		}
      		
      		g.drawString ("0-9 plaatsen op random (vrije) plaats", 10, 180);
      		g.drawString ("Klik voor volgende methode", 10, 220);
      		break;
      	
      	case 2 :
      		// variant op 1 :
      		// een hulp-array vullen met 0 tot 9 en "leegplukken" (vereist dus extra array)
            // een getrokken getal verwijderen (vervangen door 99) zodat het geen tweede
            // keer kan getrokken worden
            
            // hulp-array vullen met 0 tot 9
            for ( i =0; i<hulprij.length ; i++) hulprij[i] = i;
      		
            // hulprij "leegplukken" en rij vullen   
            for (j=0; j<rij.length ; j++){
       	  	  // zoek een plaats waar nog iets te "plukken" valt
       	  	  do{
       	  		k = (int) ( 10 * Math.random()); //0 - 9
       	  		System.out.print("!"); // een primitieve "progress bar"
       	  	  }while (hulprij[k] == 99); // 99 = 't is al weg! dus opnieuw
       	  	  
       	  	  // pluk ...  
       	  	  rij[j] = hulprij[k];
       	  	  // ... en vervang !
       	  	  hulprij[k] = 99;
       	  	  System.out.println(); // afsluiten progress bar
       	    }
       	    
       	    g.drawString ("hulparray leegplukken ...", 10, 180);
       	    g.drawString ("Klik voor volgende methode", 10, 220);
       	    break;
       	    
       	case 3 : 
       		// nog een ander systeem met 1 array , maar met een hulp-methode (= meer tijd): 
      		// de doel-plaatsen in volgorde overlopen en vullen met een
      		// "random" getal dat er nog niet in zit :
      		
      			// vul doel-array met 99's (anders kan je 0 nooit plaatsen => oneindige lus)
      		for ( i =0; i<rij.length ; i++) rij[i] = 99;
      		
      		for (pos =0; pos < rij.length ; pos++) {
      			// zoek een random getal dat er nog niet in zit
      			do{
      				getal = (int) (10*Math.random()); // 0 - 9
      			}while ( bestaat(getal, rij) ) ; // zie hulpmethode: bestaat() 
      				        // herhaal zolang het bestaat --> zoek een ander getal
      				        
      			// steek het weg op pos
      			rij [pos] = getal;
      		}
      		
      		g.drawString ("plaatsen in sequentie vullen, extra methode : bestaat() ", 10, 180);
      		g.drawString ("Klik voor volgende methode", 10, 220);
      		break;
       	  		
      	case 4 : 
            // domweg, vul met randoms en als er dubbels in zitten , doe het opnieuw !
            // kan wat lang duren, maar ooit moet het lukken ....
            // vereist ook een hulpmethode: dubbel_check()
            // tellertje erbij om te zien hoe "erg" het is ...
            teller = 0;
      		// vul array met 9 randoms zonder controle, herhaal indien dubbels
      		do{
      			for ( i =0; i<rij.length ; i++) rij[i] = (int) (10*Math.random()); // 0 - 9
      			teller++;
      		} while ( dubbel_check(rij) ); // true als er dubbele in zitten --> dan opnieuw !
      		
      		g.drawString ("eerst vullen, dan nadenken ; gebruikt methode dubbel_check()", 10, 180);
      		g.drawString ("geen dubbels na " + teller + " pogingen !" , 10, 200);
      		g.drawString ("Dit was de laatste methode", 10, 220);
      		mode = 3; // enkel voor demo, om meerdere keren te kunnen klikken
            break;      			
      	
      	case 5 : 
      		// wie bedenkt nog een ander systeem ???
      		break;	
      }
      
      // de bekomen array op scherm afdrukken :
      for (int i =0; i<rij.length ; i++){
      	g.drawString("" + rij[i], 400, yPos);
      	yPos += 30;
      } 
  }
  
  
    // zit een getal ergens in de array ?
  public boolean bestaat (int x, int[] r){
  	boolean temp = false;
  	for ( int i =0; i<r.length ; i++) {
  		if ( x == r[i]) temp = true;
  	}
	return temp;
  }
  
  
    // bevat een array dubbels ?
  public boolean dubbel_check (int[] rij){
  	boolean dubbel = false;
  	int size = rij.length;

  	for (int i = 0 ; i<size-1; i++){ // voor elk element ...
  		for (int j=i+1; j<size; j++){ // ... vanaf element + 1 tot einde
  				if (rij[i] == rij[j]) dubbel = true;
  		}
  	}
  	return dubbel;
  }

      // interne klasse voor event-handler
  class KnopHandler implements ActionListener {
    public void actionPerformed( ActionEvent e ) {
       // knophandler bestuurt enkel de "mode" (1-4)
       mode++;
       repaint();
    }
  }
}