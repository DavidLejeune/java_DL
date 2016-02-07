/**
 * @(#)Oefening5b_Toegangscontrole.java
 *
 * Oefening5b_Toegangscontrole application
 * @author David Lejeune - 1 PBICT
 * @version 1.00 2014/11/27
 *
 * een simulatie van een inlogtool
 *
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
// eventueel extra imports hier

public class Oefening5b_Toegangscontrole extends JFrame {  
    
    public static void main(String[] argumentenRij) {
       JFrame frame = new Oefening5b_Toegangscontrole();
       frame.setSize(300,300);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setTitle("Oefening5b_Toegangscontrole");
         // naam aanpassen als je Paneel van naam wijzigt !!!
       Paneel paneel = new Paneel();
       frame.setContentPane( paneel );
       frame.setVisible(true);   
       frame.setLocationRelativeTo(null);  
       frame.setResizable(false);    	
    }
}

class Paneel extends JPanel {
    // declaraties van de variabelen, schrap wat je niet gebruikt !
    
    // referenties naar objecten 
  private JLabel labelInfo;
  private JLabel labelResultaat;
  private JTextField tekstvakNaam;
  private JTextField tekstvakLeeftijd;
  private JTextField tekstvakPaswoord;
  private JButton knop;
    
    // primitieve variabelen
  boolean p;
  char    ch;
  int     i,j,k;
  double  r,s,t;
  
    // Constructor
  public Paneel() {
  	
  	
  	
  	setLayout(null);
  	
	  // label aanmaken
	labelInfo = new JLabel ("Geef je naam, leeftijd en paswoord :");
	labelInfo.setBounds(20,10,250,50);
	labelResultaat = new JLabel ("");
	labelResultaat.setBounds(50,130,150,100);	  
	  
	  // knop aanmaken en koppelen met event-handler
    knop = new JButton( "Log in" );
    knop.addActionListener( new KnopHandler() );
    knop.setBounds(125,90,95,25);
    
      // vak aanmaken op deze wijze ...
    tekstvakNaam = new JTextField("");
    tekstvakNaam.setBounds(25,50,95,25);
    tekstvakLeeftijd = new JTextField("");
    tekstvakLeeftijd.setBounds(125,50,95,25);
    tekstvakPaswoord = new JTextField("");
    tekstvakPaswoord.setBounds(25,90,95,25);
      // ofwel deze :
    //tekstvak = new JTextField( 10 );
    
      // alle elementen toevoegen aan paneel-object
    add( labelInfo);
    add( tekstvakNaam );
    add( tekstvakLeeftijd );
    add( tekstvakPaswoord );
    add( knop );
    add( labelResultaat );
  }
     
      // alle tekenwerk hier
  public void paintComponent( Graphics g ) {
      super.paintComponent( g );
      // hier komen de tekenopdrachten
      
      
      
  }
  
      // interne klasse voor event-handler
  class KnopHandler implements ActionListener {
    public void actionPerformed( ActionEvent e ) {
       // hier komen de event-handler opdrachten
       
       String naamPersoon = tekstvakNaam.getText();
       int leeftijdPersoon =  Integer.parseInt(tekstvakLeeftijd.getText());
       int countOK = 0;
       String paswoordPersoon = tekstvakPaswoord.getText();
       
       String fout = "";
       
//        if (naamPersoon.equals (""))
//       	{
//       		labelResultaat.setText("ENTER MORE DATA");
//       	}        
//       	if (paswoordPersoon.equals (""))
//       	{
//       		labelResultaat.setText("ENTER MORE DATA");
//       	}        
//       	if (leeftijdPersoon == "")
//       	{
//       		labelResultaat.setText("ENTER MORE DATA");
//       	}
       
       
       if (naamPersoon.equals ("David"))
       	{
       		countOK += 1;
       	}
       else 
       	{
        	fout = fout + "<br> Naam incorrect";
  		} 
        if (leeftijdPersoon >= 18 )
       	{
       		countOK += 1;
       	}
       else 
       	{
        	fout = fout + "<br> Te jong";
  		}   
        if (paswoordPersoon.equals ("paswoord123"))
       	{
       		countOK += 1;
       	}
       else 
       	{
        	fout = fout + "<br> Paswoord incorrect";
  		}       
 
        if (countOK == 3)
       	{
       		labelResultaat.setText("<html>Toegang verleend aan <br><h1>" + naamPersoon + "</h1></html>");
       	}     
      	else
      	{
      		labelResultaat.setText("<html>" + fout + "</html>");
      	}
       
       
       
       // niet vergeten (indien nodig) :
       // validate();
        repaint();
    }
  }
  
     // slaap routine, schrappen indien niet gebruikt
  public static void slaap (int mSec){		 
		try {
			Thread.currentThread().sleep(mSec); 
		} catch (InterruptedException e){ }
	} 
  
}