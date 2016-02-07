/**
 * @(#)Vb0800_PalindroomTest.java
 *
 * Vb0800_PalindroomTest application
 *                  
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Vb0800_PalindroomTest extends JFrame {  
    
    public static void main(String[] argumentenRij) {
       JFrame frame = new Vb0800_PalindroomTest();
       frame.setSize(550,300);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setTitle("Vb0800_PalindroomTest");
         // naam aanpassen als je Paneel van naam wijzigt !!!
       Paneel paneel = new Paneel();
       frame.setContentPane( paneel );
       frame.setVisible(true);    	
    }
}

class Paneel extends JPanel {
    
  private JLabel label;
  private JButton knop;
  private JTextField tekstvak;
  private String boodschap = "";
  
    // Constructor
  public Paneel() {
	  
	label = new JLabel (" Test woord of het een palindroom is ");	  
	  
    knop = new JButton( "Test" );
    knop.addActionListener( new KnopHandler() );
    
    tekstvak = new JTextField( 20 );
  
    add( label );
    add( tekstvak );
    add( knop );
  }
     
     
  public void paintComponent( Graphics g ) {
      super.paintComponent( g );      
      g.drawString (boodschap , 50,50);     
  }
  
      // interne klasse voor event-handler
  class KnopHandler implements ActionListener {
    public void actionPerformed( ActionEvent e ) {
       // hier komen de event-handler opdrachten
       String invoer = tekstvak.getText(); //.toUpperCase();
       StringBuffer sb = new StringBuffer (invoer);
       String omgekeerd = sb.reverse().toString();
       tekstvak.setText( omgekeerd );
                   // of : "" + sb.reverse()
                   // of : sb.toString()
       if (invoer.equalsIgnoreCase(omgekeerd)) boodschap = "Dat is een palindroom !";
                      //IgnoreCase
       else boodschap = "Dat is geen palindroom !";       
       repaint();
    }
  }
}