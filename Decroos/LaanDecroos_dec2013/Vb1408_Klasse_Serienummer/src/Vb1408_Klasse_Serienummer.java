/**
 * @(#)Vb1408_Klasse_Serienummer.java
 *
 * Vb1408_Klasse_Serienummer application
 *                  
 * @author Decroos Luc - KHBO
 *
 * @version 1.00 2013/9/20

 *
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

public class Vb1408_Klasse_Serienummer extends JFrame {  
    
    public static void main(String[] argumentenRij) {
       JFrame frame = new Vb1408_Klasse_Serienummer();
       frame.setSize(800,600);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setTitle("Vb1408_Klasse_Serienummer");
         // naam aanpassen als je Paneel van naam wijzigt !!!
       Paneel paneel = new Paneel();
       frame.setContentPane( paneel );
       frame.setVisible(true);    	
    }
}

class Paneel extends JPanel {
     
	private Persoon ingelezenKind;

  
    // Constructor
  public Paneel() {
  	
    // Hier lezen van object dat door vorig programma in een bestand gezet is
    try {
      ObjectInputStream in = 
        new ObjectInputStream(
          new FileInputStream( "c:/temp/persoon.dat" )
      );
      // nu object inlezen, maar ... je MOET TYPECASTEN :
      ingelezenKind = (Persoon) in.readObject();
      in.close();
    }
    catch( ClassNotFoundException e ) {
      System.out.println( "Onbekende klasse" );
    }
    catch( IOException e ) {
      System.out.println( "IO-exceptie" );
    }

  }
     
      // alle tekenwerk hier
  public void paintComponent( Graphics g ) {
      super.paintComponent( g );
      // hier komen de tekenopdrachten
      g.drawString( "Object is gelezen", 50, 50 );
      g.drawString( ingelezenKind.toString(), 50, 80 );
      
      
  }
  
 
}

// de nodige klassen letterlijk gecopieerd uit Vb1408
// (maar wel "public" weg omdat ze in 1 file staan met hoofdprogramma)

class Datum implements Serializable {
  public static final long serialVersionUID = 10L; // versie 1.0
  private int dag, maand, jaar;

  public Datum( int dag, int maand, int jaar ) {
    this.dag = dag;
    this.maand = maand;
    this.jaar = jaar;
  }
  
  public String toString() {
    return dag + "-" + maand + "-" + jaar;
  }
}
				     
class Persoon implements Serializable {
  public static final long serialVersionUID = 10L; // versie 1.0
  private String naam;
  private Datum gebDatum;
  private double gewicht;

  public Persoon( String naam, Datum gebDatum, double gewicht ) {
    this.naam = naam;
    this.gebDatum = gebDatum;
    this.gewicht = gewicht;
  }

  public String toString() {
    return naam + ", geb: "+ gebDatum + ", gew: " + gewicht + " kilo";
  }
}

