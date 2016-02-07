/**
 * @(#)Oefening3_Multimeter_v2.java
 *
 * Oefening3_Multimeter_v2 application
 * @author David Lejeune 1PB-ICT
 * @version 1.00 2014/12/20
 *
 * Hermaken oefening 3 : Multimeter 
 *
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
// eventueel extra imports hier

public class Oefening3_Multimeter_v2 extends JFrame {  
    
    public static void main(String[] argumentenRij) {
       JFrame frame = new Oefening3_Multimeter_v2();
       frame.setSize(410,600);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setTitle("Oefening3_Multimeter_v2");
         // naam aanpassen als je Paneel van naam wijzigt !!!
       Paneel paneel = new Paneel();
       frame.setContentPane( paneel );
       frame.setLocationRelativeTo(null);
       frame.setVisible(true);    	
    }
}

class Paneel extends JPanel {
    // declaraties van de variabelen, schrap wat je niet gebruikt !
    
    // referenties naar objecten 
  private JLabel labelTitle,labelMission;
  private JButton buttonRandom;
 // private JButton buttonDisplay;
  private JTextField textMultimeterValue;
  private Multimeter multimeter;
    
    // primitieve variabelen
  boolean p;
  char    ch;
  int     i,j,k;
  double  r,s,t;
  
    // Constructor
  public Paneel() {
  	
  		setLayout(null);
  		multimeter = new Multimeter(); 
  		
  		labelTitle = new JLabel ("MULTIMETER");
		labelTitle.setBounds(50,10,350,50);
		labelTitle.setForeground (Color.YELLOW);
		labelTitle.setFont(new Font ("Consolas" , Font.BOLD , 50));
		
  		labelMission = new JLabel ("<html><center>Enter a multimeter value <br>or click the RANDOM button</center></html>");
  		labelMission = new JLabel ("<html><center>Enter a multimeter value</center></html>");
		labelMission.setBounds(80,60,350,50);
		labelMission.setForeground (Color.GRAY);
		labelMission.setFont(new Font ("Consolas" , Font.BOLD , 15));
		
		textMultimeterValue = new JTextField("");
	    textMultimeterValue.addActionListener( new VakHandler() );
    	textMultimeterValue.setBounds(145,120,95,25);
		
//	    buttonDisplay = new JButton( "DISPLAY" );
//	    buttonDisplay.addActionListener( new MissionHandler() );
//	    buttonDisplay.setBounds(185,120,95,25);
		
	    buttonRandom = new JButton( "RANDOM" );
	    //buttonRandom.addActionListener( new MissionHandler() );
	    buttonRandom.setBounds(145,165,95,25);
		
		add(labelTitle);
		add(labelMission);		
//		add(buttonRandom);	
//		add(buttonDisplay);
		add(textMultimeterValue);
  }
     
      // alle tekenwerk hier
  public void paintComponent( Graphics g ) {
      super.paintComponent( g );
      // hier komen de tekenopdrachten
      
      //black background
      g.setColor(Color.BLACK);
      g.fillRect(0,0,10000,2000);
      
      
      //draw the linear digital multimeter
      g.setColor(Color.WHITE);
      
		
      g.drawLine(50,250,350,250);
      
      
      g.drawLine(50,230,50,250);
      g.drawLine(80,230,80,250);
      g.drawLine(110,230,110,250);
      g.drawLine(140,230,140,250);
      g.drawLine(170,230,170,250);
      g.drawLine(200,230,200,250);
      g.drawLine(230,230,230,250);
      g.drawLine(260,230,260,250);
      g.drawLine(290,230,290,250);
      g.drawLine(320,230,320,250);
      g.drawLine(350,230,350,250);
      
      g.drawString("0",48,225);
      g.drawString("10",73,225);
      g.drawString("20",103,225);
      g.drawString("30",133,225);
      g.drawString("40",163,225);
      g.drawString("50",193,225);
      g.drawString("60",223,225);
      g.drawString("70",253,225);
      g.drawString("80",283,225);
      g.drawString("90",313,225);
      g.drawString("100",343,225);
      
      // the analog multimeter 
      // fillArc(int x, int y, int width, int height, int startAngle, int arcAngle) 
      g.setColor(Color.GRAY);
      g.fillArc(25,325,350,350,45,90);
      
      
//      g.setColor(Color.WHITE);
//         for(int i=1; i<100; i=i+10)
//         	{
//      			g.fillArc(25,325,350,350,135 - i,1);
//              
//         	}
      

      
      
  }
  
   
   class VakHandler implements ActionListener {
    public void actionPerformed( ActionEvent e ) {
    validate();  
      
      Graphics g = getGraphics();  
      	    
      int valueMultimeter = Integer.parseInt(textMultimeterValue.getText()) * 3;
      
      multimeter.setMeterstand(valueMultimeter);
      
      int meterstandReturn = multimeter.getMeterstand();
      System.out.println(meterstandReturn);
      
				      if (meterstandReturn >= 240)
				      {
				      	g.setColor(Color.RED);
				      }
				      else
				      {
				      	g.setColor(Color.BLUE);
				      }	
      
         for(int i=1; i<meterstandReturn; i++)
         	{	
              g.fillRect(50,235,i,15);
              slaap(30);
         	}
         	
         	
	        double dialValue = (meterstandReturn /3) * -0.9;
	      	int dialValueRounded = (int)Math.round(dialValue);
//	      	System.out.println(dialValueRounded);
//	         for(int i=dialValueRounded; i<0; i++)
//	         	{
//	         		int degree = 135;
//
//				       // als waarde boven of gelijk aan 80% is duid gevaar aan
//				      if (meterstandReturn >= 240)
//				      {
//				      	g.setColor(Color.RED);
//				      }
//				      else
//				      {
//				      	g.setColor(Color.BLUE);
//				      }	      		
//	      		  g.fillArc(25,325,350,350,degree,2);
//	      		  degree++;	
//	              slaap(30);
//	              
//
//      			  g.setColor(Color.GRAY);	     
//      			  if(degree>0)
//      			  {
//	      		   g.fillArc(25,325,350,350,degree - 1,2);
//      			  }         
//	      		  g.fillArc(25,325,350,350,degree,2);	
//              slaap(30);
//	      		System.out.println(degree);
//	         	} 	 
//	         		
//				      if (meterstandReturn >= 240)
//				      {
//				      	g.setColor(Color.RED);
//				      }
//				      else
//				      {
//				      	g.setColor(Color.BLUE);
//				      }		         		             
	      		  g.fillArc(25,325,350,350,135 + dialValueRounded,2); 
              	  g.fillRect(50,235,meterstandReturn,15);  
 
      
      
      g.setColor(Color.WHITE);	
      g.drawLine(50,230,50,250);
      g.drawLine(80,230,80,250);
      g.drawLine(110,230,110,250);
      g.drawLine(140,230,140,250);
      g.drawLine(170,230,170,250);
      g.drawLine(200,230,200,250);
      g.drawLine(230,230,230,250);
      g.drawLine(260,230,260,250);
      g.drawLine(290,230,290,250);
      g.drawLine(320,230,320,250);
      g.drawLine(350,230,350,250);   
      
    }
    
   }
   
  
//      // interne klasse voor event-handler
//  class MissionHandler implements ActionListener {
//    public void actionPerformed( ActionEvent e ) {
//       // hier komen de event-handler opdrachten
//       
//       frame.setContentPanel( new JPanel( new BorderLayout() ) );
//       
//      Graphics g = getGraphics();  
//       int randomNumber = (int) (Math.random () * 99) ;
//       int meterstandReturn = randomNumber * 3;
//       System.out.println(meterstandReturn);
//		System.out.println(randomNumber);
////	      		System.out.println(degree);
//      
//				      if (meterstandReturn >= 240)
//				      {
//				      	g.setColor(Color.RED);
//				      }
//				      else
//				      {
//				      	g.setColor(Color.BLUE);
//				      }	
//      
//         for(int i=1; i<meterstandReturn; i++)
//         	{	
//              g.fillRect(50,235,i,15);
//              slaap(30);
//         	}
//         	
//         	
//	        double dialValue = (meterstandReturn /3) * -0.9;
//	      	int dialValueRounded = (int)Math.round(dialValue);
////	      	System.out.println(dialValueRounded);
////	         for(int i=dialValueRounded; i<0; i++)
////	         	{
////	         		int degree = 135;
////
////				       // als waarde boven of gelijk aan 80% is duid gevaar aan
////				      if (meterstandReturn >= 240)
////				      {
////				      	g.setColor(Color.RED);
////				      }
////				      else
////				      {
////				      	g.setColor(Color.BLUE);
////				      }	      		
////	      		  g.fillArc(25,325,350,350,degree,2);
////	      		  degree++;	
////	              slaap(30);
////	              
////
////      			  g.setColor(Color.GRAY);	     
////      			  if(degree>0)
////      			  {
////	      		   g.fillArc(25,325,350,350,degree - 1,2);
////      			  }         
////	      		  g.fillArc(25,325,350,350,degree,2);	
////              slaap(30);
////	      		System.out.println(degree);
////	         	} 	 
////	         		
////				      if (meterstandReturn >= 240)
////				      {
////				      	g.setColor(Color.RED);
////				      }
////				      else
////				      {
////				      	g.setColor(Color.BLUE);
////				      }		         		             
//	      		  g.fillArc(25,325,350,350,135 + dialValueRounded,2); 
//              	  g.fillRect(50,235,meterstandReturn,15);  
// 
//      
//      
//      g.setColor(Color.WHITE);	
//      g.drawLine(50,230,50,250);
//      g.drawLine(80,230,80,250);
//      g.drawLine(110,230,110,250);
//      g.drawLine(140,230,140,250);
//      g.drawLine(170,230,170,250);
//      g.drawLine(200,230,200,250);
//      g.drawLine(230,230,230,250);
//      g.drawLine(260,230,260,250);
//      g.drawLine(290,230,290,250);
//      g.drawLine(320,230,320,250);
//      g.drawLine(350,230,350,250);   
//      
//    
//       
//       // niet vergeten (indien nodig) :
//       // validate();
//       // repaint();
//    }
//  }
  
     // slaap routine, schrappen indien niet gebruikt
  public static void slaap (int mSec){		 
		try {
			Thread.currentThread().sleep(mSec); 
		} catch (InterruptedException e){ }
	} 
  
}