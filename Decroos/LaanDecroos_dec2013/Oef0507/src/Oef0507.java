/**
 * @(#)Oef0507.java
 *
 * Oef0507 application
 * oplossing boek oef 5.7
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Oef0507 extends JFrame {  
    public static void main(String[] argumentenRij) {
       JFrame frame = new Oef0507();
       frame.setSize(800,800);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setTitle("Oef0507");
         // naam aanpassen als je Paneel van naam wijzigt !!!
       Paneel paneel = new Paneel();
       frame.setContentPane( paneel );
       frame.setVisible(true);    	
    }
}

class Paneel extends JPanel {
  private JLabel label;
  private JTextField tekstvak;
  int aantal, x ,y , zijde;
  
    // Constructor
  public Paneel() {
	label = new JLabel (" geef aantal (max 15) : ");	  
    tekstvak = new JTextField( 10 );
    tekstvak.addActionListener( new VakHandler() );
    add( label);
    add( tekstvak );
  }

  public void paintComponent( Graphics g ) {
      super.paintComponent( g );
            
      x = 400; y = 400; zijde = 25;
      for (int i = 1; i <= aantal; i++){
      	g.drawRect (x, y, zijde, zijde);
      	x -= 25;
      	y -= 25; zijde += 50;
      }
  }

  class VakHandler implements ActionListener {
    public void actionPerformed( ActionEvent e ) {
       
       try{       	 
       	 aantal = Integer.parseInt(tekstvak.getText());
       }
       catch( NumberFormatException nfe){
       		JOptionPane.showMessageDialog(
          		Paneel.this,
          		"Dat is geen getal !",
          		"Fout in invoer",
          		JOptionPane.ERROR_MESSAGE
        );    	
       }
       repaint();
    }
  }
}