/**
 * @(#)Vb0700_ArrayList_Introductie.java
 *
 * ArrayList_Introductie application
 * @author Luc Decroos - KHBO
 * @version 1.00 2008/11/26
 *
 * Een heel eenvoudig ArrayList voorbeeld : 
 * een CD verzameling
 * (2013 : uitgebreid met een Deleteknop)
 *
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;          // nodig voor ArrayList

public class Vb0700_ArrayList_Introductie extends JFrame {  
    
    public static void main(String[] argumentenRij) {
       JFrame frame = new Vb0700_ArrayList_Introductie();
       frame.setSize(900,600);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setTitle("ArrayList Eenvoudiger Voorbeeld");
       Paneel paneel = new Paneel();
       frame.setContentPane( paneel );
       frame.setVisible(true);    	
    }
}


class Paneel extends JPanel {
  
  private JLabel     label;
  private JButton    addKnop, printKnop, removeKnop;
  private JTextField groepVak, titelVak, jaarVak;
  
  // *** DIT IS NIEUW ***
  private ArrayList<CD> lijst; // referentie naar een lijst van 'CD' objecten
                               // bekijk eerst de klasse CD onderaan ...
   
  private String  groep, titel;
  private int     jaar ;
  private boolean printen = false;
  
      // Constructor
  public Paneel() {
	  
	  // eerst alle klassieke GUI elementen
	  
	setFont (new Font( "Monospaced", Font.BOLD, 12))  ;
	label = new JLabel (" Om toe te voegen, vul vakjes in en klik ADD ");	  
	  
    addKnop = new JButton( " ADD " );
    addKnop.addActionListener( new AddKnopHandler() );
    
    printKnop = new JButton( " PRINT " );
    printKnop.addActionListener( new PrintKnopHandler() );
    
    removeKnop = new JButton( " DELETE 0" );
    removeKnop.addActionListener( new RemoveKnopHandler() );
      
    groepVak = new JTextField( 10 );
    titelVak = new JTextField( 10 );
    jaarVak  = new JTextField( 10 );
    
      // alle elementen toevoegen aan paneel
    add( label);
    add( groepVak ); add( titelVak );  add ( jaarVak );
    add( addKnop );  add( printKnop ); add( removeKnop );
    
    // nu de "speciale" initialisaties :
    
    // *** DIT IS NIEUW ***
    lijst = new ArrayList<>(); // we geven GEEN aantal op
                // default constructor voor een CD-ArrayList wordt door JVM 'ter plaatse' gemaakt
                // dit is het principe van Generics : http://en.wikipedia.org/wiki/Generics_in_Java   
    // NIEUW IN JAVA7 : type moet niet meer herhaald worden in de 'diamond' operator
    // vroeger moest er staan :  lijst = new ArrayList<CD>(); (staat nog zo in boek)
    
    // we hebben nu een lege lijst
    // steek er enkele cd's in als voorbeeld om te beginnen
               // dit zijn naamloze instanties van de CD klasse :
    lijst.add (new CD ("The Beatles",  "Sergeant Peppers", 1967 ));
  	lijst.add (new CD ("Queen",        "Innuendo",         1991 ));
  	lijst.add (new CD ("Led Zeppelin", "Led Zeppelin IV",  1971 ));
  	lijst.add (new CD ("U2",           "The Joshua Tree",  1987 ));
  	lijst.add (new CD ("U2",           "Achtung Baby",     1991 ));
  	lijst.add (new CD( "Roisin Murphy","Overpowered" ,     2007 ));
    lijst.add (new CD( "Coldplay",     "Viva La Vida",     2008 ));
    
  } // einde van de Paneel constructor
     

  public void paintComponent( Graphics g ) {
      super.paintComponent( g );
      // de inhoud van de lijst afdrukken
      
      if (printen){ // printen is de eerste keer false, dus geen afdruk
      	
      	int yPos = 50;
      	
      	
      	//   ***  DIT IS NIEUW  ***
      	//   het for-each statement, lees als :
      	//   voor iedere CD cdx die je in de lijst tegenkomt druk je die af
      	//
      	//   CD verwijst naar de klasse, cdx is de "lopende pointer", lijst is de ArrayList
      	for (CD cdx : lijst){ 
      		g.drawString ( cdx.toString(), 50, yPos);
      		yPos += 30;  // ieder element 30 pixels lager afdrukken
      	}

      	  //dit is equivalent met volgende klassieke for lus :
//  	    CD tempCD;
//      	for ( int i = 0; i < lijst.size(); i++){
//      		tempCD = lijst.get(i);
//      		g.drawString ( tempCD.toString(), 50, yPos);
//      		yPos += 30;
//      	}
       }
       
       // steeds aantal afdrukken
       g.drawString("Nu zijn er " + lijst.size() + " CD's in de lijst",450,550);
  }
      
  class AddKnopHandler implements ActionListener {
    public void actionPerformed( ActionEvent e ) {
       	  // lees de gegevens
       	groep =  groepVak.getText();
       	titel =  titelVak.getText();
       	jaar  =  Integer.parseInt (jaarVak.getText());
     	  
     	  // maak tijdelijk een nieuw CD-object met deze gegevens
     	  // gebruik de 3-argument Constructor
     	CD tempCD = new CD (groep, titel, jaar); 
     		
     	  // voeg dit object toe aan de lijst
     	  // DIT IS NIEUW ************
     	lijst.add (tempCD);
     	//printen = false;
     	repaint();
    }
  }

  class PrintKnopHandler implements ActionListener {
    public void actionPerformed( ActionEvent e ) {
       	printen = !printen; // zet printen aan of uit
       	repaint();
    }
  }
  
   class RemoveKnopHandler implements ActionListener {
    public void actionPerformed( ActionEvent e ) {
  		lijst.remove(0);
  		repaint();
    }
   }
}


// ********** aparte klasse : beschrijft 1 CD object ******************
class CD {
    // attributen
	private String groep ;
	private String titel ;
	private int jaar ;    // enz voor méér gegevens .... zelf uitbreiden
	
	// Constructor
	public CD ( String groep, String titel, int jaar ){
		this.groep = groep;
		this.titel = titel;
		this.jaar = jaar;
	}
	
	// setters ... te maken volgens noodzaak
	// eentje als voorbeeld :
	public void setGroep (String groep){
		this.groep = groep;
	}
	
	// getters ... te maken volgens noodzaak
	// eentje als voorbeeld :
	public String getGroep(){
		return groep;
	}
	
	// toString() methode, volstaat voorlopig om de gegevens zichtbaar te maken
	public String toString(){
		String tekst = 
			String.format ("%-30s %-30s is uit het jaar%5d", groep, titel, jaar);
		return tekst;
	}
} //************  einde van de CD klasse










