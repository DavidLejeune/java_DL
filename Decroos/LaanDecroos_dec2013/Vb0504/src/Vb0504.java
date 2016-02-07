// Voorbeeld 0504  KlikPaneel
//       if-else statement


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
   
public class Vb0504 extends JFrame {
  public static void main( String args[] ) {
    JFrame frame = new Vb0504();
    frame.setSize( 350, 200 );
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    frame.setTitle( "Voorbeeld 0504" );
                  // zet hier KlikPaneel OF KlikPaneel2
    frame.setContentPane( new KlikPaneel2() );
    frame.setVisible( true );
  }
}

// originele versie uit boek

class KlikPaneel extends JPanel {
  private JButton knop;
  private boolean geklikt; // bevat default false
  
  public KlikPaneel() {
    setBackground( Color.WHITE );
    knop = new JButton( "Klik" );
    knop.addActionListener( new KnopHandler() );
    add( knop );
  }
  
  public void paintComponent( Graphics g ) {
    super.paintComponent( g );
    
    if( !geklikt ) {
      g.drawString( "Er is nog niet geklikt", 100, 70 );
    }
    else {
      g.drawString( "Nu is er wel geklikt", 100, 70 );
    }
  }
  
  class KnopHandler implements ActionListener {
    public void actionPerformed( ActionEvent e ) {
      geklikt = true;
      repaint();
    }
  }
}



 /* Voorbeeld 0504  if-else statement
    uitgebreide versie */

  
class KlikPaneel2 extends JPanel {
  private JButton knop;
  private int teller;
  
  public KlikPaneel2() {
    setBackground( Color.WHITE );
    knop = new JButton( "Geklikt = " + teller);
    knop.addActionListener( new KnopHandler() );
    add( knop );
  }
  
  public void paintComponent( Graphics g ) {
    super.paintComponent( g );
    if (teller > 0){
      if( teller %2 == 0 ){
      	 g.drawString( "Er is een even aantal keer geklikt" , 100, 70 );
      }
      else {
    	g.drawString( "Er is een oneven aantal keer geklikt" , 100, 70 );
      }
    }	

    
  }

  class KnopHandler implements ActionListener {
    public void actionPerformed( ActionEvent e ) {
      teller++;
      System.out.println("teller =  "+teller);
      knop.setText("Geklikt = " + teller);
      repaint();
    }
  }
}
