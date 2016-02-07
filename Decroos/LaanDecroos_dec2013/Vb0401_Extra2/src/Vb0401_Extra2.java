/**
 * @(#)Vb0401_Extra2.java
 *
 * Vb0401_Extra2 application
 *                  
 * @author Luc Decroos
 * @version 1.00 2009/10/13
 *
 * Beschrijving : Correct afronden met Math.round()
 *
 *                 + nog wat rare getallen ...
 *
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
// eventueel extra imports hier

public class Vb0401_Extra2 extends JFrame {  
    
    public static void main(String[] argumentenRij) {
       JFrame frame = new Vb0401_Extra2();
       frame.setSize(500,300);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setTitle("Vb0401_Extra2");
       frame.setLocationRelativeTo(null);
         // naam aanpassen als je Paneel van naam wijzigt !!!
       Paneel paneel = new Paneel();
       frame.setContentPane( paneel );
       frame.setVisible(true);    	
    }
}

class Paneel extends JPanel {

    // primitieve variabelen
  double  onafgerondGetal;
  int     afgerondIntGetal;
  long    afgerondLongGetal;
  
  
    // Constructor
  public Paneel() {
	
  }
     
      // alle tekenwerk hier
  public void paintComponent( Graphics g ) {
      super.paintComponent( g );
      
      onafgerondGetal = 123.65434432;
      
      					  // Math.round() levert een long type af, zie index
      afgerondLongGetal = Math.round (onafgerondGetal);
                          // voor int resultaat moet je dus nog typecasten
                          // anders error: possible loss of precision
      afgerondIntGetal =  (int) Math.round (onafgerondGetal);
   
      g.drawString ("long  = " + afgerondLongGetal, 50,50);
      
      g.drawString ("int   = " + afgerondIntGetal, 50,80);
      
      // en nog wat eigenaardigheden in Java :
      g.drawString ("Delen door nul in Java (1.0/0.0)?) = " + (1.0/0.0), 50,110);
      g.drawString ("Delen door nul in Java (-1.0/0.0)?) = " + (-1.0/0.0), 50,140);
      g.drawString ("Delen door nul in Java (0.0/0.0)?) = " + (0.0/0.0), 50,170);
  }
}