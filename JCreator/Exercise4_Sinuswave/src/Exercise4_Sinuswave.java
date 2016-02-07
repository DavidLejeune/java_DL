/**
 * @(#)Exercise4_Sinuswave.java
 *
 * Exercise4_Sinuswave application
 *                
 * @author David Lejeune - 1PBICT
 * @version 1.00 2015/1/3
 *
 * Description :
 * Drawing a sinuswave (Oscilloscope simulator)
 *
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
// eventueel extra imports hier

public class Exercise4_Sinuswave extends JFrame {  
    
    public static void main(String[] argumentenRij) {
       JFrame frame = new Exercise4_Sinuswave();
       frame.setSize(825,700);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setTitle("Exercise4_Sinuswave");
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
    
    // referenties naar objecten 
  private JLabel lblNr, lblAmplitude , lblStartFase;
  private JTextField txtNr, txtAmplitude, txtStartFase;
 
    
    // primitieve variabelen
  boolean p;
  char    ch;
  int     i,j,k;
  double  r,s,t;
  
    // Constructor
  public Paneel() {
  	
  	// labels
  	lblNr = new JLabel("Number :" );
  	lblAmplitude = new JLabel("Amplitude :");
  	lblStartFase = new JLabel("Start Fase :");
  	
  	// textfields
  	txtNr = new JTextField(10);
  	txtNr.addActionListener(new TextboxHandler());
  	txtAmplitude = new JTextField(10);
  	txtAmplitude.addActionListener(new TextboxHandler());
  	txtStartFase = new JTextField(10);
  	txtStartFase.addActionListener(new TextboxHandler());
  	
  	add(lblNr);
  	add(txtNr);
  	add(lblAmplitude);
  	add(txtAmplitude);
  	add(lblStartFase);
  	add(txtStartFase);
  		
  	
  }
  
  
 public void paintComponent(Graphics g)
 {
 	super.paintComponent(g);
 	      
 	  // black background
      g.setColor(Color.BLACK);
      g.fillRect(0,30,1000,800);
      
      g.setColor(Color.DARK_GRAY);
		g.drawLine(50,150,770,150);
		g.drawLine(50,200,770,200);
		g.drawLine(50,250,770,250);
		g.drawLine(50,300,770,300);
		g.drawLine(50,400,770,400);
		g.drawLine(50,450,770,450);
		g.drawLine(50,500,770,500);
		g.drawLine(50,550,770,550);
      //g.setColor(Color.GRAY);
		g.drawLine(122,100,122,600);
		g.drawLine(194,100,194,600);
		g.drawLine(266,100,266,600);
		g.drawLine(338,100,338,600);
		g.drawLine(410,100,410,600);
		g.drawLine(482,100,482,600);
		g.drawLine(554,100,554,600);
		g.drawLine(626,100,626,600);
		g.drawLine(698,100,698,600);
		
		
		
      g.setColor(Color.WHITE);
		g.drawLine(50,100,50,600);
		g.drawLine(50,350,770,350);	
		g.drawRect(50,100,720,500);
 	
 }
     
     
     
//  
// public void paintComponent(Graphics g)
// {
// 	super.paintComponent(g);
// 	      
// }
     
     
class TextboxHandler implements ActionListener
{
	public void actionPerformed(ActionEvent e)
	{
		
		Graphics g = getGraphics();
		
		int xStart = 50;
		int yStart = 350;
		int x = 0;
		int y = 0;
		double rad,startRad;
		
		double aantal = Double.parseDouble(txtNr.getText());
		double amplitude = Double.parseDouble(txtAmplitude.getText());
		double startFase = Double.parseDouble(txtStartFase.getText());
		
		if (amplitude < 250)
		{
			for (i=0;i<2880;i++)
			{
				rad = aantal * i / 8.0 * Math.PI / 180.0;
				startRad = startFase * Math.PI / 180;
				y = (int) (yStart - amplitude * Math.sin(rad + startRad));
				
				g.setColor(Color.YELLOW);
				slaap(2);
				g.drawLine(i / 4 + 50, y , i / 4 + 50 , y);
		
			}
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