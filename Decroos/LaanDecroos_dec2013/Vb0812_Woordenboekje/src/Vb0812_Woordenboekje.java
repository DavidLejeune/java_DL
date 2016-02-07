/**
 * @(#)Vb0812_Woordenboekje.java
 *
 * Vb0812_Woordenboekje application
 *                
 * @author Luc Decroos - KHBO
 * @version 1.00 2008/3/11
 *
 *
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
// eventueel extra imports hier

public class Vb0812_Woordenboekje extends JFrame {  
    
    public static void main(String[] argumentenRij) {
       JFrame frame = new Vb0812_Woordenboekje();
       frame.setSize(500,150);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setTitle("Vb0812_Woordenboekje");
         // naam aanpassen als je Paneel van naam wijzigt !!!
       Paneel paneel = new Paneel();
       frame.setContentPane( paneel );
       frame.setVisible(true);    	
    }
}

class Paneel extends JPanel {
    // declaraties van de variabelen, schrap wat je niet gebruikt !
    
    JTextField vak1,vak2;    // NL, EN
    VakHandler vh;

	String[] nederlands = {"auto", "beer" , "citroen", "duif" , "egel"     , "fluit"   };
	String[] engels     = {"car" , "bear" , "lemon"  , "dove" , "hedgehog" , "whistle" };

    String zoekwoord;
    int teller, aantal;
  
    // Constructor
  public Paneel() {
	    aantal = nederlands.length;  // actueel aantal woorden in woordenboek, nu 6
        vh = new VakHandler();
		
		vak1 = new JTextField( 12 );  // invoer Nederlands
        vak1.addActionListener(vh);
              
        vak2 = new JTextField( 12 );  // invoer Engels
        vak2.addActionListener(vh);
           
        add(vak1); add(vak2);
  }
     
      // alle tekenwerk hier
  public void paintComponent( Graphics g ) {
      super.paintComponent( g );
      // hier komen de tekenopdrachten
      	g.drawString("Nederlands                Engels  ", 140, 40 );
      
      
  }
  
  class VakHandler implements ActionListener {
      public void actionPerformed( ActionEvent e ) {

      	if (e.getSource() == vak1){  // NL > EN
      	  zoekwoord = vak1.getText();
      	  teller=0;

      	  while ( (teller<aantal) && !(zoekwoord.equals(nederlands[teller]) )){
      	  	teller++;
      	  }
      	  
      	  if ( teller == aantal ) vak2.setText("niet gevonden");
      	  else vak2.setText( engels[teller]);
      	}
      	
      	if (e.getSource() == vak2){  // EN > NL
      	  zoekwoord = vak2.getText();
      	  teller=0;

      	  while ( (teller<aantal) && !(zoekwoord.equals(engels[teller]) )){
      	  	teller++;
      	  }
      	  
      	  if ( teller == aantal ) vak1.setText("niet gevonden");
      	  else vak1.setText( nederlands[teller]);
        }
    }}   
}