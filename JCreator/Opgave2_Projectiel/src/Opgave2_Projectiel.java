/**
 * @(#)Opgave2_Projectiel.java
 *
 * Opgave2_Projectiel application
 * @author David Lejeune - 1 PBICT
 * @version 1.00 2014/11/27
 *
 * Extra oefening om projectiel af te schieten
 *
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
// eventueel extra imports hier

public class Opgave2_Projectiel extends JFrame {  
    
    public static void main(String[] argumentenRij) {
       JFrame frame = new Opgave2_Projectiel();
       frame.setSize(900,720);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setTitle("Opgave2_Projectiel");
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
  private JLabel labelInfo;
  private JLabel labelHoek;
  private JLabel labelVuurkracht;
  private JButton knopHoger;
  private JButton knopLager;
  private JButton knopVuur;
  private JTextField tekstvakVuurkracht;
  private JTextField tekstvakHoek;
  private double angle;
  private int startX;
  private int startY;
  private int endX;
  private int endY;
  private double locationX;
  private double locationY;
  private double vuurkracht;
    
    // primitieve variabelen
  boolean p;
  char    ch;
  int     i,j,k;
  double  r,s,t;
  
    // Constructor
  public Paneel() {
  	
  	
  	setLayout(null);
  	
	  // label aanmaken
	labelInfo = new JLabel ("Richt het kanon hoger of lager en schiet het projectiel af");
	labelInfo.setBounds(90,20,400,40);	  
	labelVuurkracht = new JLabel ("Vuurkracht :");
	labelVuurkracht.setBounds(450,20,80,40);	 
	labelHoek = new JLabel ("Hoek");	
	labelHoek.setBounds(10,590,70,40);
	  
	  // knop aanmaken en koppelen met event-handler
    knopHoger = new JButton( "Hoger" );
    knopHoger.addActionListener( new hogerKnopHandler() );
    knopHoger.setBounds(10,400,70,40);
    knopLager = new JButton( "Lager" );
    knopLager.addActionListener( new lagerKnopHandler() );
    knopLager.setBounds(250,600,70,40);
    knopVuur = new JButton( "FIRE !!" );
    knopVuur.addActionListener( new vuurKnopHandler() );
    knopVuur.setBounds(800,400,70,40);
    
      // vak aanmaken op deze wijze ...
    tekstvakVuurkracht = new JTextField(10);
    tekstvakVuurkracht.setBounds(525,30,70,25);
    tekstvakHoek = new JTextField("45");
    tekstvakHoek.setBounds(50,600,70,25);
      // ofwel deze :
    //tekstvak = new JTextField( 10 );
    
    // alle elementen toevoegen aan paneel-object
    add( labelInfo);
    add( labelHoek);
    add( labelVuurkracht);
    add( knopHoger );
    add( knopLager );
    add( knopVuur );
    add( tekstvakVuurkracht );
    add( tekstvakHoek );
  }
     
      // alle tekenwerk hier
  public void paintComponent( Graphics g ) {
      super.paintComponent( g );
      // hier komen de tekenopdrachten
      
		g.drawLine (90,90,90,590);
		g.drawLine (90,590,810,590);
        angle = Double.parseDouble(tekstvakHoek.getText()); 	        
       	angle = angle * Math.PI / 180;
	        
	       	startX = 90;
			startY = 590;
			endX   = (int) (startX + 40 * Math.cos(angle));
			endY   = (int) (startY - 40 * Math.sin(angle));
	      
      		
		g.drawLine (startX,startY,endX, endY);
		

		
		


      
      
      
  }
  
      // interne klasse voor event-handler
  class vuurKnopHandler implements ActionListener {
    public void actionPerformed( ActionEvent e ) {
       // hier komen de event-handler opdrachten
       
       Graphics g = getGraphics(); 
        double angle = Double.parseDouble(tekstvakHoek.getText()); 	        
       	angle = angle * Math.PI / 180;
       	
       
 	       	startX = 90;
			startY = 590;
			endX   = (int) (startX + 40 * Math.cos(angle));
			endY   = (int) (startY - 40 * Math.sin(angle));
       	
  		vuurkracht= Double.parseDouble(tekstvakVuurkracht.getText());
  		
  		System.out.println(vuurkracht);
  		
  		
  		
  		
  		
  		
  		
  		
  		
//  		double beginfase = Double.parseDouble(tekstvakHoek.getText());
  
// 		for (i = 0 ; i<360 ; i++)
//		{  
//		
//  		double velocityX = vuurkracht * Math.cos(angle2);
//  		double velocityY = vuurkracht * Math.sin(angle2);
//  		
//  		locationX = locationX + velocityX * 1;
//  		locationY = locationY + velocityY * 1;
//      
//      	velocityY -= 1 * 9.81;
//      	
//      	System.out.println(velocityX + " " + velocityY);
//		}
  		
  		
		double grad,rad;
			
			
	       	startX = 90;
			startY = 590;
			endX   = (int) (startX + 40 * Math.cos(angle));
			endY   = (int) (startY - 40 * Math.sin(angle));
		
		
 		for (i = 0 ; i<360 ; i++)
		{      
		rad = i  /  1.0 / 2.0 * Math.PI / 180.0;
		double beginfase = angle;
		double beginrad = beginfase * Math.PI / 180.0;
		int y =(int)( startY  - vuurkracht * Math.sin(rad + beginrad)  ) ;
      	g.fillOval(i + endX, y ,4,4);
      	slaap(3);
      	
		System.out.println("i " + i);
		System.out.println("y " + y);
		}

//		int v0 = 50; // m/s
//		//int angle = 60;
//		double dt = 0.5; // s
//		
//		double vx = v0 * Math.cos(Math.PI / 180 * angle);
//		double vy = v0 * Math.sin(Math.PI / 180 * angle); 
//		
//		double posx = 1; // m
//		double posy = 1;  // m
//		double time = 0; // s
//		
//		while(posy > 0)
//		{
//		   posx = (int) (posx + vx * dt);
//		   posy = (int) (posy + vy * dt);
//		   time += dt;
//		
//		   // change speed in y  
//		   vy -= 9.82 * dt; // gravity
//		   g.fillOval(posx, posy ,4,4);
//		   System.out.println(" angle " + angle + "#" + "posx " + posx + "# posy" + posy);
//		}


//int v0 = 45; // m/s
////int angle = 60;
//double dt = 0.5; // s
//
//double vx = v0 * Math.cos(Math.PI / 180 * angle);
//double vy = v0 * Math.sin(Math.PI / 180 * angle); 
//
//int posx = endX; // m
//int posy = endY;  // m
//double time = 0; // s
//
//while(posy > 0)
//{
//   posx +=  (int) Math.round(vx * dt) * 1;
//   posy +=  (int) Math.round(vy * dt) * 1;
//   int posx2 = posx * 10 / 10;
//   int posy2 = posy * 10 / 10;
//   time += dt;
//
//   // change speed in y  
//   vy -= 9.82 * -dt; // gravity
//   g.fillOval(posx2, posy2 ,4,4);
//   System.out.println(" angle " + angle + "#" + "posx " + posx + "# posy" + posy);
//   System.out.println(" endX " + endX + "#" + "endY " + endY);
//}

		
       
       // niet vergeten (indien nodig) :
       // validate();
       // repaint();
    }
  }
  
        // interne klasse voor event-handler
  class hogerKnopHandler implements ActionListener {
    public void actionPerformed( ActionEvent e ) {
       // hier komen de event-handler opdrachten
       
        Graphics g = getGraphics(); 
       
       	angle = Double.parseDouble(tekstvakHoek.getText());       	
       	if(angle < 91 && angle > 0)
       	{
	       	angle += 1;
			System.out.println(angle);
	       	tekstvakHoek.setText("" + angle);
	        angle = angle * Math.PI / 180;
	        
	       	startX = 90;
			startY = 590;
			endX   = (int) (startX + 40 * Math.cos(angle));
			endY   = (int) (startY - 40 * Math.sin(angle));
       	}
       
       // niet vergeten (indien nodig) :
       // validate();
       repaint();
    }
  }
  
        // interne klasse voor event-handler
  class lagerKnopHandler implements ActionListener {
    public void actionPerformed( ActionEvent e ) {
       // hier komen de event-handler opdrachten
       
        Graphics g = getGraphics(); 
       
       	angle = Double.parseDouble(tekstvakHoek.getText());
       	
       	if(angle < 91 && angle > 0)
       	{
	       	angle -= 1;
			System.out.println(angle);
	       	tekstvakHoek.setText("" + angle);
	        angle = angle * Math.PI / 180;
	        
	       	startX = 90;
			startY = 590;
			endX   = (int) (startX + 40 * Math.sin(angle));
			endY   = (int) (startY - 40 * Math.cos(angle));
       	}
        

       
       // niet vergeten (indien nodig) :
       // validate();
       repaint();
       
       // niet vergeten (indien nodig) :
       // validate();
       // repaint();
    }
  }
  
     // slaap routine, schrappen indien niet gebruikt
  public static void slaap (int mSec){		 
		try {
			Thread.currentThread().sleep(mSec); 
		} catch (InterruptedException e){ }
	} 
  
}