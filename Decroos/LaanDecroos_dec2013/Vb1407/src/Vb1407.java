// Voorbeeld 1407  Bestand maken met bytestream
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Vb1407 extends JFrame {
  public static void main( String args[] ) {
    JFrame frame = new Vb1407();
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    frame.setBounds( 50, 50, 350, 350 );
    frame.setTitle( "Maak een bestand met een byte-stream" );
    frame.setContentPane( new Bestandpaneel() );
    frame.setVisible( true );
  }
}

class Bestandpaneel extends JPanel {
	
  JButton knop ;
  boolean geschreven = false;
  
	
  public Bestandpaneel() {
  	// extra, niet in boek
  	knop = new JButton (" Lees bestand ");
  	knop.addActionListener(new KnopHandler());
  	add (knop);
  	
    try {
      DataOutputStream uit = 
        new DataOutputStream(
          new FileOutputStream( "c:/temp/geboorteGegevens.dat" )
        );

      // Schrijf gegevens
      uit.writeUTF( "Welmer");
      
      uit.writeInt( 1973 );
      uit.writeUTF( "Decroos");
      uit.writeDouble( 3.020 );

      // Sluit de stream
      uit.close();
    }
    catch( IOException e ) {
      System.out.println( "IO-exceptie" );
    }
  }

  public void paintComponent( Graphics g ) {
    super.paintComponent( g );
    g.drawString( "Bestand is klaar", 40, 50 );
    
    if (geschreven){
    	
    	// lees bestand terug binnen
    	try {
         DataInputStream in = 
             new DataInputStream(
                new FileInputStream( "c:/temp/geboorteGegevens.dat" )
             );
             // Lees gegevens
      	g.drawString( in.readUTF(), 40,100);
      	g.drawString( "" + in.readInt(),40,130);
      	g.drawString( in.readUTF(), 40,160);
      	g.drawString( "" + in.readDouble(),40,190);

      	// Sluit de stream
      	in.close();
    	}
    	catch( IOException e ) {
      		System.out.println( "IO-exceptie" );
    	}
    	
    }
  
  }
  
  
  class KnopHandler implements ActionListener {  
      public void actionPerformed( ActionEvent e ) {
      	geschreven = true;
      	repaint();
      }}
}
