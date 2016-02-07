/**
 * @(#)Oefening3b_AVO.java
 *
 * Oefening3b_AVO application
 * @author David Lejeune - PBICT
 * @version 1.00 2014/11/12
 *
 * Bereken de ontbrekende waarde met de wet van Ohm
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.border.*;

// eventueel extra imports hier

public class Oefening3b_AVO extends JFrame {  
    
    public static void main(String[] argumentenRij) {
       JFrame frame = new Oefening3b_AVO();
       frame.setSize(650,200);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setTitle("Oefening3b_AVO");
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
  private JLabel labelCopyright;
  private JLabel labelSpanning;
  private JLabel labelStroom;
  private JLabel labelResult;
  private JLabel labelWeerstand;
  private JTextField tekstvakSpanning;
  private JTextField tekstvakStroom;
  private JTextField tekstvakWeerstand;
  private JButton knop;
  private JTextField tekstvak;
    
    // primitieve variabelen
  boolean p;
  char    ch;
  int     i,j,k;
  double  r,s,t;
  
    // Constructor
  public Paneel() {

	setLayout(new GridLayout ( 3,3 , 20 , 15 ));
	
	Border border = BorderFactory.createEmptyBorder(5,5,5,5);
	setBorder(border);
	
	//create labels
	labelSpanning = new JLabel ("Spanning [V]");
	labelStroom = new JLabel ("Stroom [A]");
	labelWeerstand = new JLabel ("Weerstand [\u2126]");
	labelResult = new JLabel ("");
	labelCopyright = new JLabel("\u00A9 David L 2014");
	
	
	//format labels
	labelSpanning.setHorizontalAlignment (JLabel.RIGHT);
	labelSpanning.setForeground (Color.RED);
	labelSpanning.setFont(new Font ("Consolas" , Font.BOLD , 15));
		
	labelStroom.setHorizontalAlignment (JLabel.RIGHT);
	labelStroom.setForeground (Color.BLUE);
	labelStroom.setFont(new Font ("Consolas" , Font.BOLD , 15));
		
	labelWeerstand.setHorizontalAlignment (JLabel.RIGHT);
	labelWeerstand.setForeground (Color.GREEN);
	labelWeerstand.setFont(new Font ("Consolas" , Font.BOLD , 15));
	
	labelCopyright.setHorizontalAlignment (JLabel.RIGHT);
	labelResult.setHorizontalAlignment (JLabel.CENTER);
	labelResult.setForeground (Color.GREEN);
	labelResult.setFont(new Font ("Consolas" , Font.BOLD , 15));
	labelCopyright.setForeground (Color.GRAY);
	labelCopyright.setFont(new Font ("Consolas" , Font.BOLD , 15));
	
	//create textfields
	tekstvakSpanning = new JTextField( 10 );
	tekstvakStroom = new JTextField( 10 );
	tekstvakWeerstand = new JTextField( 10 );
	//format textfields
	tekstvakSpanning.setHorizontalAlignment (JLabel.CENTER);
	tekstvakStroom.setHorizontalAlignment (JLabel.CENTER);
	tekstvakWeerstand.setHorizontalAlignment (JLabel.CENTER);
	tekstvakStroom.setForeground (Color.BLUE);
	tekstvakStroom.setBackground (Color.BLACK);
	tekstvakSpanning.setForeground (Color.RED);
	tekstvakSpanning.setBackground (Color.BLACK);
	tekstvakWeerstand.setForeground (Color.GREEN);
	tekstvakWeerstand.setBackground (Color.BLACK);
	tekstvakStroom.setFont(new Font ("Consolas" , Font.BOLD , 20));
	tekstvakSpanning.setFont(new Font ("Consolas" , Font.BOLD , 20));
	tekstvakWeerstand.setFont(new Font ("Consolas" , Font.BOLD , 20));
	  
	  // knop aanmaken en koppelen met event-handler
    knop = new JButton( "Calculate" );
    knop.addActionListener( new KnopHandler() );
    
      // alle elementen toevoegen aan paneel-object
    add(labelSpanning);
    add(tekstvakSpanning);
    add( knop );
    add(labelStroom);
    add(tekstvakStroom);
    add(labelResult);
    add(labelWeerstand);
    add(tekstvakWeerstand);
    add(labelCopyright);
    //add( tekstvak );
  }
     
      // alle tekenwerk hier
  public void paintComponent( Graphics g ) {
      super.paintComponent( g );
      // hier komen de tekenopdrachten
      
      g.setColor(Color.BLACK);
      g.fillRect(0,0,650,200);
      
      
  }
  
      // interne klasse voor event-handler
  class KnopHandler implements ActionListener {
    public void actionPerformed( ActionEvent e ) {
       // hier komen de event-handler opdrachten
       
  		
//  		tekstvakSpanning.setText("");
//  		labelResult.setText("test");
  		
  		
  		
  		  		int iCount = 0;
  		if (tekstvakSpanning.getText().length()>0 )
  			{
				iCount +=1;
  			}
  		if (tekstvakStroom.getText().length()>0 )
  			{
				iCount +=1;
  			}
  		if (tekstvakWeerstand.getText().length()>0 )
  			{
				iCount +=1;
  			}
  		if (iCount >1 );
   			{
				labelResult.setForeground (Color.ORANGE);
  				labelResult.setText("ENTER MORE VALUES");
  			}    
  		if (iCount==1);
  		{
  		
  		
  		       // get values
        String invoerSpanning = tekstvakSpanning.getText();
       	String invoerStroom = tekstvakStroom.getText();
       	String invoerWeerstand = tekstvakWeerstand.getText();
       	
       	
       	
       	
       	
       	
   		if (tekstvakWeerstand.getText().equals (""))
  			{ 
  				double intSpanning = Double.parseDouble(invoerSpanning);
  				double intStroom = Double.parseDouble(invoerStroom);
  				double dResult = intSpanning / intStroom;
				labelResult.setForeground (Color.GREEN);
  				labelResult.setText(String.format("Weerstand=%.2f \u2126",dResult) );
  			}
  		 		
  		
  		if (tekstvakStroom.getText().equals (""))
  			{ 

		  				double intSpanning = Double.parseDouble(invoerSpanning);
		  				double intWeerstand = Double.parseDouble(invoerWeerstand);
		  				double dResult = intSpanning / intWeerstand;
						labelResult.setForeground (Color.BLUE);
		  				labelResult.setText(String.format("Stroom=%.2f Ampere",dResult) );
  			
  			}
  		
  		
  		if (tekstvakSpanning.getText().equals (""))
  			{ 
  				double intStroom = Double.parseDouble(invoerStroom);
  				double intWeerstand = Double.parseDouble(invoerWeerstand);
  				double dResult = intStroom / intWeerstand;
				labelResult.setForeground (Color.RED);
  				labelResult.setText(String.format("Spanning=%.2f Volt",dResult) );
  			}
  		
  	
  		if (tekstvakSpanning.getText().length()>0 && tekstvakStroom.getText().length()>0 && tekstvakWeerstand.getText().length()>0 )
  			{
				labelResult.setForeground (Color.WHITE);
  				labelResult.setText("3 VALUES ENTERED");
  			}
  		
  		
  		}
       
       // niet vergeten (indien nodig) :
        validate();
        repaint();
    }
  }
  

  
}