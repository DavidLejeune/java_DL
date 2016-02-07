// nu met een ingevoerd getal via tekstvakje

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
// eventueel extra imports hier

public class Vb0303_Extra_User_Input extends JFrame {  
    
    public static void main(String[] argumentenRij) {
       JFrame frame = new Vb0303_Extra_User_Input();
       frame.setSize(325,250);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setTitle("Decimaal naar Binair Omzetter");
         // naam aanpassen als je Paneel van naam wijzigt !!!
       Paneel paneel = new Paneel();
       frame.setContentPane( paneel );
       frame.setVisible(true);    	
    }
}

class Paneel extends JPanel {
    // declaraties van de variabelen, schrap wat je niet gebruikt !
    
    // referenties naar objecten 
  private JLabel label;
  private JButton knop;
  private JTextField tekstvak;
    
    // primitieve variabelen

  
  private int getal, bin128, bin64, bin32, bin16, bin8, bin4, bin2, bin1 ;
  
    // Constructor
  public Paneel() {
  	
  	setBackground( Color.WHITE );
	  // label aanmaken
	label = new JLabel ("Decimaal (0-255) > ");	  
	  
	  // knop aanmaken en koppelen met event-handler
    knop = new JButton( " Naar Binair " );
    knop.addActionListener( new KnopHandler() );
    
      // vak aanmaken op deze wijze ...
    tekstvak = new JTextField( 5 );
    tekstvak.setText("0");
   
      // alle elementen toevoegen aan paneel-object
    add( label);    
    add( tekstvak );
    add( knop );
  }
     
      // alle tekenwerk hier
  public void paintComponent( Graphics g ) {
      super.paintComponent( g );
      // hier komen de tekenopdrachten
    g.drawString( "Het decimale getal " + getal , 50, 60 );
    g.drawString( "wordt in het binaire stelsel geschreven als :", 50, 100 );
    g.drawString( bin128+" "+ bin64 +" " + bin32 + " " + bin16 + " "  + 
    	            bin8+" "+ bin4 +" " + bin2 + " " + bin1, 80, 160 );
      
      
  }
  
      // interne klasse voor event-handler
  class KnopHandler implements ActionListener {
    public void actionPerformed( ActionEvent e ) {
       // hier komen de event-handler opdrachten
    getal = Integer.parseInt(tekstvak.getText());          // getal-invoer door gebruiker
    bin128 = getal/128;
    int rest = getal%128;
    bin64 =	rest/64;
    rest = rest%64;
    bin32 = rest/32;
    rest = rest%32;
    bin16 = rest/16;
    rest = rest%16;    
    bin8 = rest/8;
    rest = rest%8;
    bin4 =rest/4;
    rest = rest%4;
    bin2 = rest/2;
    bin1 = rest%2;
  
    repaint();
    }
  }
  
}




