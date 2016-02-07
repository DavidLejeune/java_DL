/**
 * @(#)Vb1407_Met_JFileChooser.java
 *
 * Vb1407_Met_JFileChooser application
 * Beschrijving : 
 * Zelfde als Vb1407, maar nu met JFileChooser
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
// eventueel extra imports hier
import java.io.*;

public class Vb1407_Met_JFileChooser extends JFrame {  
    
    public static void main(String[] argumentenRij) {
       JFrame frame = new Vb1407_Met_JFileChooser();
       frame.setSize(800,600);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setTitle("Vb1407_Met_JFileChooser");
         // naam aanpassen als je Paneel van naam wijzigt !!!
       Paneel paneel = new Paneel();
       frame.setContentPane( paneel );
       frame.setVisible(true);    	
    }
}

class Paneel extends JPanel {
  // referenties naar objecten 
  
  private JButton knop;
  //EXTRA
  private JFileChooser fc;
  
  private boolean geschreven = false;
  
  private String naam ="", naam2="";
  private int jaar;
  private double gewicht;
  
    // Constructor
  public Paneel() {  	
  	// extra, niet in boek
  	knop = new JButton (" Lees bestand ");
  	knop.addActionListener(new KnopHandler());
  	add (knop);
  	
  	// bestand maken zoals in boek, in classes map
  	// vaste bestandsnaam
//    try {
//      DataOutputStream uit = 
//        new DataOutputStream(
//          new FileOutputStream( "c:/temp/geboorteGegevens.dat" )
//        );
//
//      // Schrijf gegevens
//      uit.writeUTF( "Welmer");
//      uit.writeInt( 1973 );
//      uit.writeDouble( 3.020 );
//
//      // Sluit de stream
//      uit.close();
//    }
//    catch( IOException e ) {
//      System.out.println( "IO-exceptie" );
//    }
  }
     
      // alle tekenwerk hier
  public void paintComponent( Graphics g ) {
      super.paintComponent( g );
      // hier komen de tekenopdrachten
      //g.drawString( "Bestand is klaar", 40, 50 );
    
      if (geschreven){
    	  // druk de gegevens af 
      	  g.drawString( naam         ,40,100);
      	  g.drawString( "" + jaar    ,40,130);
		  g.drawString( naam2        ,40,160);
      	  g.drawString( "" + gewicht ,40,190);
      }
  }
  
      // interne klasse voor event-handler
  class KnopHandler implements ActionListener {
    public void actionPerformed( ActionEvent e ) {
 
       	// lees bestand terug binnen, nu met ingevoerd path uit JFileChooser
    	// zie doc op toledo, daar ook info over "saven" met JFileChooser
    	fc = new JFileChooser();
   		// niet verplicht, maar geeft opties voor dir's of files of beide selecteerbaar
   		fc.setFileSelectionMode(JFileChooser.FILES_ONLY); // een dir is sowieso ongeldig
   		int returnVal = fc.showOpenDialog(Paneel.this);
   		if (returnVal == JFileChooser.APPROVE_OPTION) {
      	  File file = fc.getSelectedFile();
      	  // nu iets doen met het bestand ...     	
      	  // hier dezelfde code als in Vb1407, behalve nu "file.getPath()"
      	  // om aan de naam te geraken
      	  try {
            DataInputStream in = 
              new DataInputStream(
                new FileInputStream( file.getPath() )
              );

           // Lees gegevens zoals vorige programma
      	  naam = in.readUTF();      	  
      	  jaar = in.readInt();
      	  naam2 = in.readUTF(); 
      	  gewicht = in.readDouble();
          geschreven = true;
      	  // Sluit de stream
      	  in.close();
    	  }
    	  catch( IOException foutje ) {
      		System.out.println( "IO-exceptie" );
    	  }
        }
       repaint();
    }
  }

}