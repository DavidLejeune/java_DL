// Voorbeeld 1208 Niet opvangen van een exceptie
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Vb1208 extends JFrame {
  public static void main( String args[] ) {
    JFrame frame = new Vb1208();
    frame.setSize( 400, 150 );
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    frame.setTitle( "Voorbeeld 1208  Niet opvangen van een exceptie" );
    
    frame.setContentPane( new Exceptiepaneel() );
    frame.setVisible( true );
  }
}

class Exceptiepaneel extends JPanel { 
  private int getal = 1;
  
  public Exceptiepaneel() {
  	setBackground(Color.red);
    test1();
    System.out.println( "In constructor van het paneel" );
  }

  public void test1() {
    test2();
    System.out.println( "In test1" );
  }   

  public void test2() {
    if ( getal == 1 )
      throw new RuntimeException();
    System.out.println( "In test2" );
  }
}
