/**
 * @(#) Exercise2_Circles.java
 *
 * Excercise2_Circles application
 *
 * @author David Lejeune - 1PBICT
 * @version 1.0 03/01/2015
 *
 * Description
 * I guess it's about draxwing circles now
 *
 */
 
 

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
// eventueel extra imports hier

public class Exercise2_Circles extends JFrame {  
    
    public static void main(String[] argumentenRij) {
       JFrame frame = new Exercise2_Circles();
       frame.setSize(700,600);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setTitle("Exercise2_Circles");
         // naam aanpassen als je Paneel van naam wijzigt !!!
       Paneel paneel = new Paneel();
       frame.setContentPane( paneel );
       frame.setVisible(true);    	
       frame.setLocationRelativeTo(null);
       frame.setResizable(false);
    }
}

class Paneel extends JPanel{


	// references to objects
	private JLabel lblX, lblY, lblR;
	private JTextField txtX, txtY , txtR;
	private JButton btnDraw, btnLeft, btnRight, btnUp, btnDown, btnLarger;
	private int boxX, boxY, circleWidth, circleHeight;
	private String strX, strY, strR;
	private int intX, intY, intR;
	
	// primitive variable
	boolean p;
	char ch;
	int i,j,k;
	double r,s,t;
	
	// constructor
	
	public Paneel(){

		// labels
		lblX = new JLabel("Enter X centre :");
		lblY = new JLabel("Enter Y centre :");
		lblR = new JLabel("Enter diametre :");
		// textfields
		txtX = new JTextField(10);
		txtY = new JTextField(10);
		txtR = new JTextField(10);
		// buttons
		btnDraw = new JButton("Draw");
		btnDraw.addActionListener(new ButtonHandler());
		btnLeft = new JButton("Left");
		btnLeft.addActionListener(new ButtonHandler());
		btnRight = new JButton("Right");
		btnRight.addActionListener(new ButtonHandler());
		btnUp = new JButton("Up");
		btnUp.addActionListener(new ButtonHandler());
		btnDown = new JButton("Down");
		btnDown.addActionListener(new ButtonHandler());
		btnLarger  = new JButton("Larger");
		btnLarger.addActionListener(new ButtonHandler());
		
		
		add(lblX);
		add(txtX);
		add(lblY);
		add(txtY);
		add(lblR);
		add(txtR);
		add(btnDraw);
		add(btnLeft);
		add(btnRight);
		add(btnUp);
		add(btnDown);
		add(btnLarger);
		
		

	}

      // alle tekenwerk hier
  public void paintComponent( Graphics g ) {
      super.paintComponent( g );
      
      g.setColor(Color.BLACK);
      g.fillRect(0,65,1000,1000);
      
      //fill the alternating colors
      g.setColor(Color.BLUE	);
      g.fillArc(boxX,boxY,circleWidth,circleHeight,0,90);
      g.fillArc(boxX,boxY,circleWidth,circleHeight,180,90);
      // draw the circle
      g.setColor(Color.WHITE);
      g.drawOval(boxX, boxY, circleWidth, circleHeight);
      // draw the crossheirs
      g.drawLine(boxX - 10, boxY + (intR / 2), boxX + intR + 10, boxY + (intR / 2));
      g.drawLine(boxX + (intR/2) , boxY - 10 , boxX + (intR/2), boxY + intR + 10);
      
      
      
      
      
      
      
      
  }
  
      // interne klasse voor event-handler
  class ButtonHandler implements ActionListener {
    public void actionPerformed( ActionEvent e ) {

       
       if (e.getSource()==btnDraw)
       {
       		intX = Integer.parseInt(txtX.getText());
       		intY = Integer.parseInt(txtY.getText());
       		intR = Integer.parseInt(txtR.getText());
       		
       		boxX = intX - (intR/2);
       		boxY = intY - (intR/2);
       		circleWidth = intR;
       		circleHeight = intR;		
       	
       }
       if (e.getSource()==btnLeft)
       {
       		boxX = boxX - 5;
       }
       if (e.getSource()==btnRight)
       {
       		boxX = boxX + 5;
       }
       if (e.getSource()==btnUp)
       {
       		boxY = boxY - 5;
       }
       if (e.getSource()==btnDown)
       {
       		boxY = boxY + 5;
       }
       if (e.getSource()==btnLarger)
       {
       		circleWidth = circleWidth + 5;
       		circleHeight = circleHeight + 5;
       		intR = intR + 5;
       }
       
        validate();
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