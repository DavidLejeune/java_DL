// Voorbeeld 0405  Twee kassa's
// GridLayout
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;  
   
public class Vb0405 extends JFrame {
  
  
  public static void main( String args[] ) {
    JFrame frame = new Vb0405();
    frame.setSize(500,100);
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    frame.setTitle( "Voorbeeld 0405: Twee kassa's" );
    frame.setContentPane( new TweeKassaPaneel() );
    frame.setVisible( true );
  }
}


class TweeKassaPaneel extends JPanel {
  public TweeKassaPaneel() {
    setLayout( new GridLayout( 2, 2, 10, 0 ) );
    setBackground(Color.green);
       // twee naamloze instanties = onafhankelijke objecten 
       // extra LDC : een kleur meegeven als argument voor de constructor
    add( new KassaPaneel( Color.CYAN ) );
    add( new KassaPaneel( Color.yellow ) );
    add( new KassaPaneel( Color.pink ) );
    add (new JLabel("(c) LDC soft 2013"));
  }
  
  
  public void paintComponent( Graphics g ) {
    super.paintComponent( g );
       //g.fillRect (245,0,10,100);
  }
  
} 




