/**
 * @(#)Exercise1_Drawining.java
 * 
 * Exercise1_Drawing application
 * 
 * @author David Lejeune-1PBICT
 * @version 1.0 03/01/2015
 * 
 * Description : 
 * A simple drawing program 
 *
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
// eventueel extra imports hier

public class Exercise1_Drawing extends JFrame {  
    
    public static void main(String[] argumentenRij) {
       JFrame frame = new Exercise1_Drawing();
       frame.setSize(1000,800);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setTitle("Exercise1_Drawing");
       
       //my style
       frame.setLocationRelativeTo(null);
       frame.setResizable(false);
       frame.setAlwaysOnTop(true);
       
       // naam aanpassen als je Paneel van naam wijzigt !!!
       Paneel paneel = new Paneel();
       frame.setContentPane( paneel );
       frame.setVisible(true);   
        	
    }
}


class Paneel extends JPanel{
	
	// references to objects
	private JLabel lbl1;
	private JButton btn1;
	private JTextField txt1;
	
	// primitive variable
	boolean p;
	char ch;
	int i,j,k;
	double r,s,t;
	
	// constructor
	public Paneel(){

	// make the label
	lbl1 = new JLabel("First Label");
	
	// make a button
	// and couple it with event-handler
	btn1 = new JButton("First button");
	btn1.addActionListener(new KnopHandler());
	
	// create textfield
	txt1 = new JTextField("And here is the first TextField");
	
	// add all elements to panel-object
	add(lbl1);
	add(btn1);
	add(txt1);
		
  }
     
      // alle tekenwerk hier
  public void paintComponent( Graphics g ) {
      super.paintComponent( g );
      // hier komen de tekenopdrachten
      
      // outher frame of the house
      g.setColor(Color.blue);     
      g.drawLine(150,250,475,100);
      g.drawLine(150,250,800,250);
      g.drawLine(475,100,800,250);
      g.drawLine(150,250,150,600);
      g.drawLine(150,600,800,600);
      g.drawLine(800,250,800,600);
      
      
   	  //  simple window 
      g.setColor(Color.orange);
   	  g.drawLine(500,350,700,350);
   	  g.drawLine(500,400,700,400);
   	  g.drawLine(500,450,700,450);
   	  g.drawLine(500,450,700,450);
   	  g.drawLine(500,350,500,450);
   	  g.drawLine(700,350,700,450);
   	  g.drawLine(600,350,600,450);
   	  
   	  
   	  // the door
      g.setColor(Color.red);
      g.drawLine(250,350,400,350);
      g.drawLine(250,350,250,600);
   	  g.drawLine(400,350,400,600);
   	  g.drawLine(250,600,400,600);
   	  

   	  
      
  }
  
      // interne klasse voor event-handler
  class KnopHandler implements ActionListener {
    public void actionPerformed( ActionEvent e ) {
       // hier komen de event-handler opdrachten
       
       
       
       
       // niet vergeten (indien nodig) :
       // validate();
       // repaint();
    }
  }
  

  
}