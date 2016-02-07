/**
 * @(#)Vb0811_Parkeergarage.java
 *
 * Vb0811_Parkeergarage application
 *                  <vul hier steeds je voornaam - naam - klas in> !!!
 * @author Luc Decroos - KHBO
 * @version 1.00 2008/3/11
 *
 *
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
// eventueel extra imports hier

public class Vb0811_Parkeergarage extends JFrame {  
    
    public static void main(String[] argumentenRij) {
       JFrame frame = new Vb0811_Parkeergarage();
       frame.setSize(700,150);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setTitle("Vb0811_Parkeergarage");
         // naam aanpassen als je Paneel van naam wijzigt !!!
       Paneel paneel = new Paneel();
       frame.setContentPane( paneel );
       frame.setVisible(true);    	
    }
}

class Paneel extends JPanel {
    // declaraties van de variabelen, schrap wat je niet gebruikt !
    
    JTextField vak,vak2;    // invoer , plaats

          // 3D !!!
    String[][][] garage = new String[5][10][10]; // garage voor 500 auto's 
    String zoekplaat = "";
    boolean gevonden = false;
    int v,r,k; // verdieping, rij, kolom
  
    // Constructor
  public Paneel() {
      // om te testen
	  garage[1][5][7] = "ABC123";
	  garage[3][3][2] = "XYZ234";
	  garage[0][9][0] = "JB007";
	  garage[4][4][8] = "VRT001";
	  garage[2][5][8] = "VRT002";
	  
	  setLayout(null);
      vak = new JTextField( 30 );
      vak.setBounds(10,50,80,20);
      vak.addActionListener (new EnterHandler());
      vak2 = new JTextField( 30 );
      vak2.setBounds(250,50,320,20);
      add(vak);
      add(vak2);
  }
     
      // alle tekenwerk hier
  public void paintComponent( Graphics g ) {
      super.paintComponent( g );
      // hier komen de tekenopdrachten
      g.drawString("Geef je nummerplaat in het eerste vak",10,25);
	  g.drawString("en druk <Enter>", 10, 45 );
  }
  
 class EnterHandler implements ActionListener {
      public void actionPerformed( ActionEvent e ) {
      	zoekplaat = vak.getText();
      	gevonden = false;
      	   // (dit kan ook met while of do-while: stoppen als je het gevonden hebt)
      	for (int verd = 0; verd<garage.length; verd++){ // voor alle verdiepingen
      	  for (int rij = 0; rij<garage[verd].length; rij++){ // voor alle rijen
      	    for (int kol = 0; kol<garage[verd][rij].length; kol++){ // voor alle plaatsen op die rij van dat verdiep
      	       if (zoekplaat.equalsIgnoreCase (garage[verd][rij][kol])){
      	         gevonden = true;
      	       	 v=verd; r = rij; k = kol;  // onthouden waar gevonden
      	       }
      	    }
          }
      	}
        // resultaat afdrukken
        if (gevonden) vak2.setText(zoekplaat.toUpperCase() + " staat op verdieping " + v + " , RIJ " + (r+1) + ", PLAATS " + (k+1));
      	else vak2.setText("niet gevonden");
      }
    }
  
}