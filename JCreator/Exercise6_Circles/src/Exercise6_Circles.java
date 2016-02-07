/**
 * @(#)Exercise6_Circles.java
 *
 * Exercise6_Circles application
 *                  
 * @author David Lejeune - 1PBICT
 * @version 1.00 2015/1/3
 *
 * Beschrijving : 
 * Store random circles in ArrayList
 * and draw them
 *
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
// eventueel extra imports hier

public class Exercise6_Circles extends JFrame {  
    
    public static void main(String[] argumentenRij) {
       JFrame frame = new Exercise6_Circles();
       frame.setSize(800,600);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setTitle("Exercise6_Circles");
         // naam aanpassen als je Paneel van naam wijzigt !!!
       Paneel paneel = new Paneel();
       frame.setContentPane( paneel );
       frame.setVisible(true);   
       frame.setLocationRelativeTo(null);
        	
    }
}

class Paneel extends JPanel {
    // declaraties van de variabelen, schrap wat je niet gebruikt !
    
    // referenties naar objecten 
  private JLabel lblInfo;
  private JButton btnDraw, btnLarger, btnSmaller;
  private JTextField txtNr;
  private ArrayList<Circle> lijst;
    
    // primitieve variabelen
  boolean p;
  char    ch;
  int     i,j,k;
  double  r,s,t;
  
    // Constructor
  public Paneel() {
  	
  		lijst = new ArrayList<>();
  	
  		lblInfo = new JLabel("<html><h3>Number of circles:</h3></html>");
  		
  		txtNr = new JTextField(10);
  		
  		btnDraw = new JButton("Draw");
  		btnDraw.addActionListener(new MissionHandler());  		
  		btnLarger = new JButton("Larger");
  		btnLarger.addActionListener(new MissionHandler());
  		btnSmaller = new JButton("Smaller");
  		btnSmaller.addActionListener(new MissionHandler());
  		
  		
  		
  		add(lblInfo);
  		add(txtNr);
  		add(btnDraw);
  		add(btnSmaller);
  		add(btnLarger);
  	
  }
     
      // alle tekenwerk hier
  public void paintComponent( Graphics g ) {
      super.paintComponent( g );
      // hier komen de tekenopdrachten
      
//		g.setBackGroundColor(Color.BLACK);      
//      g.setColor(Color.BLACK);
//      g.fillRect(0,0,10000,10000);
      
      for (Circle circleItem : lijst)
      {
      	circleItem.tekenCircle(g);
      }
      
  }
  
  
  class MissionHandler implements ActionListener
  {
  	public void actionPerformed(ActionEvent e)
  	{
  		Object src = e.getSource();
  		if (src==btnDraw)
  		{
  			int nrCircles = Integer.parseInt(txtNr.getText());
  			lijst.clear();
  			
  			for (int i =0; i<nrCircles ; i++)
  			{
  				int x = (int) (Math.random() * 100 * Math.random() * 12);
  				int y = (int) (Math.random() * 100 * Math.random() * 7);
  				int intR = (int) (Math.random() * 100 * Math.random() * 10);
  				Color kleur = new Color ((int) (16777216 * Math.random()));
  				
  				System.out.println(x);
  				
  				
  				lijst.add(new Circle(
  						x,
  						y,
  						intR,
  						kleur
  					));
  			}
  			
  		}		
  			
  			if (src==btnLarger)
  			{
  				for (Circle circleItem: lijst)
  				{
  					circleItem.makeLarger();
  					repaint();
  				}
  			}
 			if (src==btnSmaller)
 			{
 				for (Circle circleItem: lijst)
 				{
 					circleItem.makeSmaller();
 					repaint();
 				}
 			} 	
  		
  		
  		
  		
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