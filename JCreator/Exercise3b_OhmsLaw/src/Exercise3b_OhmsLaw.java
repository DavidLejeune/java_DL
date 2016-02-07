/**
 * @(#)Exercise3b_OhmsLaw.java
 *
 * Exercise3b_OhmsLaw application
 *
 * @author David Lejeune 1PBICT
 * @version 1.0 03012015
 *
 * Description :
 * Calculate missing value using Ohm's Law
 *
 */
 

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
// eventueel extra imports hier

public class Exercise3b_OhmsLaw extends JFrame {  
    
    public static void main(String[] argumentenRij) {
       JFrame frame = new Exercise3b_OhmsLaw();
       frame.setSize(200,225);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setTitle("Exercise3b_OhmsLaw");
         // naam aanpassen als je Paneel van naam wijzigt !!!
       Paneel paneel = new Paneel();
       frame.setContentPane( paneel );
       frame.setVisible(true);  
       frame.setLocationRelativeTo(null);
       frame.setResizable(false);
       
    }
}

class Paneel extends JPanel {
	
	// declaring variables
	private double dR, dI, dV;
	
	// references to objects
	private JLabel lblR, lblI, lblV;
	private JTextField txtR, txtI, txtV;
	
	// primitive variables;
	boolean p;
	char ch;
	int i,j,k;
	double r,s,t;
	
  
    // Constructor
  public Paneel() {
	  
	  // labels
	  lblR = new JLabel("Resistance :");
	  lblR.setFont(new Font ("Consolas" , Font.BOLD , 20));
	  lblI = new JLabel("Current    :");
	  lblI.setFont(new Font ("Consolas" , Font.BOLD , 20));
	  lblV = new JLabel("Voltage    :");
	  lblV.setFont(new Font ("Consolas" , Font.BOLD , 20));
	  
	  // textfields + handlers
	  txtR = new JTextField(10);
	  txtR.addActionListener(new TextboxHandler());
	  txtI = new JTextField(10);
	  txtI.addActionListener(new TextboxHandler());
	  txtV = new JTextField(10);
	  txtV.addActionListener(new TextboxHandler());
	  
	  // add elements to paneel object
	  add(lblR);
	  add(txtR);
	  add(lblI);
	  add(txtI);
	  add(lblV);
	  add(txtV);
  }
     
      // alle tekenwerk hier
  public void paintComponent( Graphics g ) {
      super.paintComponent( g );
      // hier komen de tekenopdrachten
      
      
      
  }
  
      // interne klasse voor event-handler
  class TextboxHandler implements ActionListener {
    public void actionPerformed( ActionEvent e ) {
       // hier komen de event-handler opdrachten
       
       int iCount = 0;
       if (txtR.getText().length()>0)
       {
       		iCount += 1;
       }
       if (txtI.getText().length()>0)
       {
       		iCount += 1;
       }
       if (txtV.getText().length()>0)
       {
       		iCount += 1;
       }
       System.out.println(iCount);
       
       if (iCount==2)
       {
//       dR=Double.parseDouble(txtR.getText());
//       dI=Double.parseDouble(txtI.getText());
//       dV=Double.parseDouble(txtV.getText());
//       
       if (txtR.getText().equals(""))
       {
       	    dI=Double.parseDouble(txtI.getText());
       		dV=Double.parseDouble(txtV.getText());
       		double dResult = dV / dI;
       		txtR.setText(""+dResult);
       }       
       if (txtI.getText().equals(""))
       {
       	    dR=Double.parseDouble(txtR.getText());
       		dV=Double.parseDouble(txtV.getText());
       		double dResult = dV / dR;
       		txtI.setText(""+dResult);
       }       
       if (txtV.getText().equals(""))
       {
       	    dI=Double.parseDouble(txtI.getText());
       		dR=Double.parseDouble(txtR.getText());
       		double dResult = dR * dI;
       		txtV.setText(""+dResult);
       }
      
      
      
       
       
       // niet vergeten (indien nodig) :
       // validate();
        repaint();
       }
    }
  }
  
     // slaap routine, schrappen indien niet gebruikt
  public static void slaap (int mSec){		 
		try {
			Thread.currentThread().sleep(mSec); 
		} catch (InterruptedException e){ }
	} 
  
}