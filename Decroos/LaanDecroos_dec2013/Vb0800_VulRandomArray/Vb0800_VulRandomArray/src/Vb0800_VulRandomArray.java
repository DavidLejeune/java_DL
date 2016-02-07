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
       frame.setLocationRelativeTo(null);
    }
}

class Paneel extends JPanel {
    // referenties naar objecten 
  private JLabel label;
  private JLabel lblResult;
  private JLabel lblResult2;
  private JButton knop;
  
  private String strResult;
  private String strResult2;
    
  private int [] rij; // declaratie
  private int [] hulprij; // enkel gebruikt in mode = 2
    
    // primitieve variabelen
  private int mode, getal, i, j, k;
  private int pos, yPos, teller, poging;
  
  
      		long iTot1 = 0;
      		long iTot2 = 0;
      		long iTot3 = 0;
      		long iTot4 = 0;
      		long iTot5 = 0;
  
  private long tijdStart;
    // Constructor
  public Paneel() {
	  // label aanmaken
	  
	  
	  setLayout(null);
	label = new JLabel ("<html><h4><font color=yellow> Demo : array random vullen zonder dubbels </font></html>");	  
	lblResult = new JLabel(""); 
	lblResult2 = new JLabel("");
	label.setBounds(130,125,500,20);
	  // knop aanmaken en koppelen met event-handler
    knop = new JButton( "Next Method" );
    knop.setBounds(150,160,120,30);
    knop.addActionListener( new KnopHandler() );
      // alle elementen toevoegen aan paneel-object
    add( label);
    add( knop );
    
    
    
    
    lblResult.setBounds(125,450,250,150);
    add (lblResult);
    
    lblResult2.setBounds(125,575,250,150);
    add (lblResult2);
    
    
      // array's instantiëren
    rij     = new int[10]; 
    hulprij = new int[10];
  }

      // alle tekenwerk hier
  public void paintComponent( Graphics g ) {
      super.paintComponent( g );
    
    
     boolean tabelTonen = false;
    
    
      	      //LOGO
      g.setColor(Color.BLACK);
      g.fillRect(0,0,10000,2000);
      g.setFont(new Font ("Consolas" , Font.PLAIN , 18));
      g.setColor(Color.WHITE);
      g.drawString("n",30,39);
      g.setFont(new Font ("Consolas" , Font.PLAIN , 36));
      g.setColor(Color.WHITE);
      g.drawString("OO",39,44);
      g.setFont(new Font ("Consolas" , Font.PLAIN , 18));
      g.setColor(Color.WHITE);
      g.drawString("b",78,40);
      g.setFont(new Font ("Consolas" , Font.PLAIN , 18));
      g.setColor(Color.WHITE);
      g.drawString("©",52,57);
      g.setFont(new Font ("Consolas" , Font.PLAIN , 18));
      g.setColor(Color.WHITE);
      g.drawString("sh*t",35,75);
      g.setColor(Color.YELLOW);
      g.drawRect(22,10,72,74);
      g.setColor(Color.WHITE);
      g.fillOval(45,33,5,5);
      g.fillOval(64,33,5,5);
      g.setFont(new Font ("Consolas" , Font.PLAIN , 10));
      g.setColor(Color.GRAY);
      g.drawString("by DaLe",55,100);
      g.drawString("2015",72,110);
      g.setFont(new Font ("Consolas" , Font.PLAIN , 30));
      g.setColor(Color.PINK);
      //TITLE
      g.drawString("ARRAYS",10,142);
      	
      	
      g.setFont(new Font ("Consolas" , Font.PLAIN , 16));
      	g.setColor(Color.WHITE);
      	
      int xPos2 = 50;
      int yPos2 = 400;
      long tijdNu = 0;
      long resultaat = 0;
      yPos = 50;
      g.setColor(Color.RED);
      g.drawString("Methode = " + mode, 10, 170);
      g.setColor(Color.BLUE);
      g.drawString("Poging  = " + poging, 10, 190);
      g.setColor(Color.BLUE);
      
      g.drawRect(420,270,80,330);
      
      g.setColor(Color.WHITE);
      
      switch(mode){
      	case 0 : g.drawString("Klik voor de eerste methode :", 10,220); 
      		break;
      	case 1 :  
      		// wellicht het meest efficiënte systeem :
      		// getallen 0 tot 9 in volgorde, telkens vrije "random" plaats zoeken :
      		
      		// vul de doel-array met 99's ("vrij-markers")
      		//tijdStart = System.currentTimeMillis(); 
      		
      		
      		
      		
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
      		tijdNu = System.currentTimeMillis(); 
       		resultaat = tijdNu - tijdStart;
      		g.drawString ("0-9 plaatsen op random (vrije) plaats", 10, 220);
      		g.drawString ("Klik voor volgende methode", 10, 240);
      		strResult = " methode " + mode + "  >>  " + resultaat + " ms<br>";
      		g.setColor(Color.RED);
      		g.drawString("Methode = " + mode, 125, 360);
      		g.setColor(Color.WHITE);
      		g.drawString ("StartTijd  : " + tijdNu, 125, 380);
      		g.drawString ("EindeTijd  : " + tijdStart, 125, 400);
      		g.drawString ("TotaleTijd : " + resultaat + " ms" , 125, 420);
      		iTot1 = iTot1 + resultaat;
      		break;
      	
      	case 2 :
      		// variant op 1 :
      		// een hulp-array vullen met 0 tot 9 en "leegplukken" (vereist dus extra array)
            // een getrokken getal verwijderen (vervangen door 99) zodat het geen tweede
            // keer kan getrokken worden
            
            // hulp-array vullen met 0 tot 9
      		//tijdStart = System.currentTimeMillis(); 
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
       	    tijdNu = System.currentTimeMillis(); 
       		resultaat = tijdNu - tijdStart;
       	    g.drawString ("hulparray leegplukken ...", 10, 220);
       	    g.drawString ("Klik voor volgende methode", 10, 240);
      		strResult = strResult + " methode " + mode + "  >>  " + resultaat + " ms<br>";
      		g.setColor(Color.RED);
      		g.drawString("Methode = " + mode, 125, 360);
      		g.setColor(Color.WHITE);
      		g.drawString ("StartTijd  : " + tijdNu, 125, 380);
      		g.drawString ("EindeTijd  : " + tijdStart, 125, 400);
      		g.drawString ("TotaleTijd : " + resultaat + " ms" , 125, 420);
      		iTot2 += resultaat;
       	    break;
       	    
       	case 3 : 
       		// nog een ander systeem met 1 array , maar met een hulp-methode (= meer tijd): 
      		// de doel-plaatsen in volgorde overlopen en vullen met een
      		// "random" getal dat er nog niet in zit :
      		
      			// vul doel-array met 99's (anders kan je 0 nooit plaatsen => oneindige lus)
      		//tijdStart = System.currentTimeMillis(); 
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
      		tijdNu = System.currentTimeMillis(); 
       		resultaat = tijdNu - tijdStart;
      		g.drawString ("plaatsen in sequentie vullen, extra methode : bestaat() ", 10, 220);
      		g.drawString ("Klik voor volgende methode", 10, 240);
      		strResult = strResult + " methode " + mode + "  >>  " + resultaat + " ms<br>";
      		g.setColor(Color.RED);
      		g.drawString("Methode = " + mode, 125, 360);
      		g.setColor(Color.WHITE);
      		g.drawString ("StartTijd  : " + tijdNu, 125, 380);
      		g.drawString ("EindeTijd  : " + tijdStart, 125, 400);
      		g.drawString ("TotaleTijd : " + resultaat + " ms" , 125, 420);
      		iTot3 += resultaat;
      		break;
       	  		
      	case 4 : 
            // domweg, vul met randoms en als er dubbels in zitten , doe het opnieuw !
            // kan wat lang duren, maar ooit moet het lukken ....
            // vereist ook een hulpmethode: dubbel_check()
            // tellertje erbij om te zien hoe "erg" het is ...
      		//tijdStart = System.currentTimeMillis(); 
            teller = 0;
      		// vul array met 9 randoms zonder controle, herhaal indien dubbels
      		do{
      			for ( i =0; i<rij.length ; i++) rij[i] = (int) (10*Math.random()); // 0 - 9
      			teller++;
      		} while ( dubbel_check(rij) ); // true als er dubbele in zitten --> dan opnieuw !
      		tijdNu = System.currentTimeMillis(); 
       		resultaat = tijdNu - tijdStart;
      		g.drawString ("eerst vullen, dan nadenken ; gebruikt methode dubbel_check()", 10, 220);
      		g.drawString ("geen dubbels na " + teller + " pogingen !" , 10, 240);
      		strResult = strResult + " methode " + mode + "  >>  " + resultaat + " ms<br>";
      		g.setColor(Color.RED);
      		g.drawString("Methode = " + mode, 125, 360);
      		g.setColor(Color.WHITE);
      		g.drawString ("StartTijd  : " + tijdNu, 125, 380);
      		g.drawString ("EindeTijd  : " + tijdStart, 125, 400);
      		g.drawString ("TotaleTijd : " + resultaat + " ms" , 125, 420);
      		iTot4 += resultaat;
            break;      			
      	
      	case 5 : 
      		// wie bedenkt nog een ander systeem ???
      		// ik :)
      		//tijdStart = System.currentTimeMillis(); 
      		int i0 = 0;
      		int i1 = 0;
      		int i2 = 0;
      		int i3 = 0;
      		int i4 = 0;
      		int i5 = 0;
      		int i6 = 0;
      		int i7 = 0;
      		int i8 = 0;
      		int i9 = 0;
      		int iCount = 0;
      		
      		for ( i =0; i<rij.length ; i++)
      			{ 
      				do
      					{
      						getal = (int) (10*Math.random());
      							
      						if (getal == 0) 
      							{
      								i0++;
      								iCount = i0;
      							} 
      						else if (getal == 1) 
      							{
      								i1++;
      								iCount = i1;
      							}
      						else if (getal == 2) 
      							{
      								i2++;
      								iCount = i2;
      							}
      						else if (getal == 3) 
      							{
      								i3++;
      								iCount = i3;
      							}
      						else if (getal == 4) 
      							{
      								i4++;
      								iCount = i4;
      							}
      						else if (getal == 5) 
      							{
      								i5++;
      								iCount = i5;
      							}
      						else if (getal == 6) 
      							{
      								i6++;
      								iCount = i6;
      							}
      						else if (getal == 7) 
      							{
      								i7++;
      								iCount = i7;
      							}
      						else if (getal == 8) 
      							{
      								i8++;
      								iCount = i8;
      							}
      						else if (getal == 9) 
      							{
      								i9++;
      								iCount = i9;
      							}
					
      						
      					} while (iCount > 1);
      				
      				rij[i] = getal;
      		
      			}
      		tijdNu = System.currentTimeMillis(); 
       		resultaat = tijdNu - tijdStart;		
      		g.drawString ("1 Array invullen met random number", 10, 220);
      		g.drawString ("Individuele teller bijhouden ", 10, 240);
      		g.drawString ("if greater than 1 -> RETRY ", 10, 260);
      		g.drawString ("Dit was de laatste methode", 10, 280);
      		
      		strResult = strResult + " methode " + mode + "  >>  " + resultaat + " ms<br>";
      		g.setColor(Color.RED);
      		g.drawString("Methode = " + mode, 125, 360);
      		g.setColor(Color.WHITE);
      		g.drawString ("StartTijd  : " + tijdNu, 125, 380);
      		g.drawString ("EindeTijd  : " + tijdStart, 125, 400);
      		g.drawString ("TotaleTijd : " + resultaat + " ms" , 125, 420);
      		
      		iTot5 += resultaat;
      		//to loop around
      		mode = 0;
      		//to display result table after every 5th method
      		tabelTonen = true;
      		
      		
            break;   
      		
     	
      }
      
      if (tabelTonen)
      {
      	strResult = "<html><marquee><font color=blue face=consolas>Result Table poging " + poging + "</font></marquee><hr><font  face=consolas color=yellow>" + strResult + "</font></html>";
      	lblResult.setText(strResult);
      	strResult2 = "<html><marquee><font color=blue face=consolas>Result Table Total </font></marquee><hr><font  face=consolas color=yellow>" 
      		+ " methode 1   >>  " + iTot1 + " ms<br>" 
      		+ " methode 2   >>  " + iTot2 + " ms<br>" 
      		+ " methode 3   >>  " + iTot3 + " ms<br>" 
      		+ " methode 4   >>  " + iTot4 + " ms<br>" 
      		+ " methode 5   >>  " + iTot5 + " ms<br>"
      		+ "</font></html>";
      	lblResult2.setText(strResult2);
      	tabelTonen = false;
      }
      
      // de bekomen array op scherm afdrukken :
      for (int i =0; i<rij.length ; i++){
      	g.drawString("" + rij[i], 430, yPos+250);
      	
      	System.out.println(rij[i]);
      						if (rij[i] == 0) 
      							{
      								g.setColor(Color.WHITE);
      							} 
      						else if (rij[i] == 1) 
      							{
      								g.setColor(Color.BLUE);
      							}
      						else if (rij[i] == 2) 
      							{
      								g.setColor(Color.GRAY);
      							}
      						else if (rij[i] == 3) 
      							{
      								g.setColor(Color.GREEN);
      							}
      						else if (rij[i] == 4) 
      							{
      								g.setColor(Color.ORANGE);
      							}
      						else if (rij[i] == 5) 
      							{
      								g.setColor(Color.RED);
      							}
      						else if (rij[i] == 6) 
      							{
      								g.setColor(Color.MAGENTA);
      							}
      						else if (rij[i] == 7) 
      							{
      								g.setColor(Color.CYAN);
      							}
      						else if (rij[i] == 8) 
      							{
      								g.setColor(Color.YELLOW);
      							}
      						else if (rij[i] == 9) 
      							{
      								g.setColor(Color.PINK);
      							}
      	
      	
      	g.fillRect(455,yPos +250 -16,25,25);
      	g.setColor(Color.WHITE);
      	
      	
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
       // knophandler bestuurt enkel de "mode" (1-5)
      
      tijdStart = System.currentTimeMillis(); 
       //System.gc();
       mode++;
       if (mode == 1)
       {
       		poging++ ;
       }
       repaint();
    }
  }
}