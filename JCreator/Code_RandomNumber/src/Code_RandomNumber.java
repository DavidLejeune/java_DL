/**
 * @(#)Code_RandomNumber.java
 *
 * Code_RandomNumber application
 *                 
 * @author David Lejeune - 1PBICT
 * @version 1.00 2015/1/3
 *
 * Display a random number
 * 
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
// eventueel extra imports hier

public class Code_RandomNumber extends JFrame {  
    
    public static void main(String[] argumentenRij) {
       JFrame frame = new Code_RandomNumber();
       frame.setSize(800,600);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setTitle("Code_RandomNumber");
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
    private int yPos = 50;
    
    // referenties naar objecten 
  private JButton btnRandom;
    
    // primitieve variabelen
  boolean p;
  char    ch;
  int     i,j,k;
  double  r,s,t;
  
    // Constructor
  public Paneel() {
  	
  	btnRandom = new JButton("Random");
  	btnRandom.addActionListener(new ButtonHandler());
  	
  	add(btnRandom);
  	
  	
  }
     
     
 public void paintComponent(Graphics g)
 {
 	super.paintComponent(g);
 	
 }    
     
  class ButtonHandler implements ActionListener
  {
  	public void actionPerformed (ActionEvent e)
  	{
  		Graphics g = getGraphics();
  		
  		int randomNumber = (int) (Math.random() * 999);
  		g.drawString(""+randomNumber, 50 ,yPos);
  		yPos = yPos + 20;
  	}
  }   
     
     
     // slaap routine, schrappen indien niet gebruikt
  public static void slaap (int mSec){		 
		try {
			Thread.currentThread().sleep(mSec); 
		} catch (InterruptedException e){ }
	} 
  
}