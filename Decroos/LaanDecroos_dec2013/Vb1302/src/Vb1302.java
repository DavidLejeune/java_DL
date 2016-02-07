// Voorbeeld 1302  Starten en stoppen van de timer
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Vb1302 extends JFrame {
  public static void main( String args[] ) {
    JFrame frame = new Vb1302();
    frame.setSize( 320, 120 );
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    frame.setTitle( "Voorbeeld 1302  Starten en stoppen van timer" );
    frame.setContentPane( new Tellerpaneel() );
    frame.setVisible( true );
  }
}

  
