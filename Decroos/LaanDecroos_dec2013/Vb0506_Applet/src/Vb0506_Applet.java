/**
 * @(#)Vb0506_Applet.java
 *
 * Vb0506_Applet Applet application
 *
 * @author 
 * @version 1.00 2011/11/24
 */
 
import java.awt.*;
import java.applet.*;
import javax.swing.*;
import java.awt.event.*;

public class Vb0506_Applet extends Applet {
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
		
		    int i_kopie = 0;
    	g.setColor( Color.red );
    	for(int i = 1; i <= aantal; i+=1 ) {
      		g.drawOval( 50, 50, 20 + 5*i, 20 + 5*i );
      		i_kopie = i;
    	}
    	System.out.println("teller i = " + i_kopie);
		
	}
	
	class InvoerVakHandler implements ActionListener {
    public void actionPerformed( ActionEvent e ) {
      String invoer = invoerVak.getText();
      aantal = Integer.parseInt( invoer );
      repaint();
    }
  }
}