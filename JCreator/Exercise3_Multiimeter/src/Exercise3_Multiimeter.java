/**
 * @(#)Exercise3_Multimeter.java
 * 
 * Exercise3_Multimeter application
 *
 * @author David Lejeune - 1PBICT
 * @version 1.0 03012015
 * 
 * Description :
 * First use of an external class
 * Simulating a multimeter
 *
 */
 
 
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
// eventueel extra imports hier

public class Exercise3_Multiimeter extends JFrame {  
    
    public static void main(String[] argumentenRij) {
       JFrame frame = new Exercise3_Multiimeter();
       frame.setSize(800,600);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setTitle("Exercise3_Multiimeter");
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
	private JLabel lblInfo;
	private JTextField txtMM;
	
	// declaring variables
	private int intMM, intRealMM;
	private String txtMMvalue;
	
	// 
	private Multimeter multimeter;
	
	// primitive variable
	boolean p;
	char ch;
	int i,j,k;
	double r,s,t;

    // Constructor
  public Paneel() {

	lblInfo = new JLabel("Enter a multimeter value : ");
	txtMM = new JTextField(10);
	txtMM.addActionListener(new TextboxHandler());
	
	multimeter = new Multimeter();
	
	add(lblInfo);
	add(txtMM);
	
	

  }
     
      // alle tekenwerk hier
  public void paintComponent( Graphics g ) {
      super.paintComponent( g );
      // black background
      g.setColor(Color.BLACK);
      g.fillRect(0,0,1000,1000);
      
      // draw the MM value
      int MM = multimeter.getMM();
      System.out.println(MM);
      g.setColor(Color.BLUE);
      g.fillRect(100,130,MM,20);

            
      //draw the analog multimeter
      g.setColor(Color.WHITE);
      g.drawLine(100,150,600,150);
      g.drawLine(100,130,100,150);
      g.drawLine(100,130,100,150);
      g.drawLine(150,130,150,150);
      g.drawLine(200,130,200,150);
      g.drawLine(250,130,250,150);
      g.drawLine(300,130,300,150);
      g.drawLine(350,130,350,150);
      g.drawLine(400,130,400,150);
      g.drawLine(450,130,450,150);
      g.drawLine(500,130,500,150);
      g.drawLine(550,130,550,150);
      g.drawLine(600,130,600,150);
       
       
       

      
  }
  
      // interne klasse voor event-handler
  class TextboxHandler implements ActionListener {
    public void actionPerformed( ActionEvent e ) {
	validate();
	int valueMM = Integer.parseInt(txtMM.getText()) * 5  ;
	System.out.println("MM:" + valueMM);
	multimeter.setMM(valueMM);

       
       // niet vergeten (indien nodig) :
       // validate();
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