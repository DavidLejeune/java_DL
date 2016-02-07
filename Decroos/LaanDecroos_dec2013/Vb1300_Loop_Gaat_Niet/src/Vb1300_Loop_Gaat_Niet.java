/**
 * @(#)Vb1300_Loop_Gaat_Niet.java
 *
 * Vb1300_Loop_Gaat_Niet application
 *                  
 * @author Luc Decroos - KHBO
 * @version 1.00 2010/10/7
 *
 * Demo om te tonen dat een gewone lus vastloopt !
 *
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;


public class Vb1300_Loop_Gaat_Niet extends JFrame {  
    
    public static void main(String[] argumentenRij) {
       JFrame frame = new Vb1300_Loop_Gaat_Niet();
       frame.setSize(800,600);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setTitle("Vb1300_Loop_Gaat_Niet");
         // naam aanpassen als je Paneel van naam wijzigt !!!
       Paneel paneel = new Paneel();
       frame.setContentPane( paneel );
       frame.setVisible(true);    	
    }
}

class Paneel extends JPanel {
    
  private JLabel label;  
  private int teller; 
 
    // Constructor
  public Paneel() {
     label = new JLabel("      ");
     add (label);
  }
     
      
  public void paintComponent( Graphics g ) {
      super.paintComponent( g );
      
      while (true){
      	teller++;
      	slaap(1000);
      	label.setText("" + teller);
      }
  }
  
     // slaap routine
  public static void slaap (int mSec){		 
		try {
			Thread.currentThread().sleep(mSec); 
		} catch (InterruptedException e){ }
	} 
}