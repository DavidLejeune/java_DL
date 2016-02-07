/**
 * @(#)Vb0506_Applet2013.java
 *
 * Vb0506_Applet2013 Applet application
 *
 * @author 
 * @version 1.00 2013/10/23
 */
 
import java.awt.*;
import java.applet.*;
import java.awt.event.*; 
import javax.swing.*; 

public class Vb0506_Applet2013 extends Applet {
	private TextField invoerVak;
    private int aantal;
    
	public void init() {
		setBackground( Color.WHITE );
    	invoerVak = new TextField( 10 );
    	invoerVak.addActionListener( new InvoerVakHandler() );
    
    	add( new Label( "Voer aantal in" ) );
    	add( invoerVak );
	}

	public void paint(Graphics g) {
		
		g.setColor( Color.red );
    
	    for(int i = 1; i <= aantal; i+=1 ) {
	      g.drawOval( 50, 50, 20 + 5*i, 20 + 5*i );
	      
	    }
    
		
	}
	
	class InvoerVakHandler implements ActionListener {
    public void actionPerformed( ActionEvent e ) {
      String invoer = invoerVak.getText();
      aantal = Integer.parseInt( invoer );
      repaint();
    }
  }
  
}